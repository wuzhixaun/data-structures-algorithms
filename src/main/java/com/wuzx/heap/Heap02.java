package com.wuzx.heap;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;

public class Heap02<T> {

    // 堆
    private ArrayList<T> heap;

    // 大小
    private int heapSize;
    
    // 记录每一个对象所在堆中的index
    private HashMap<T, Integer> indexMap;

    // 比较器
    private Comparator<? super T> comparator;

    public Heap02(Comparator<? super T> comparator) {
        this.heap = new ArrayList<>();
        this.indexMap = new HashMap<>();
        this.heapSize = 0;
        this.comparator = comparator;
    }


    public boolean isEmpty() {
        return heapSize == 0;
    }

    public int size() {
        return heapSize; 
    }

    public boolean contains(T value) {
        return indexMap.containsKey(value);
    }

    public void push(T value) {
        heap.add(value);
        indexMap.put(value, heapSize);
        heapInsert(heapSize++);
    }


    public T pop() {
        T ans = heap.get(0);
        int end = heapSize - 1;
        swap(0, end);
        heap.remove(end);
        indexMap.remove(ans);
        heapfiy(0, --heapSize);
        return ans;
    }


    public void resign(T value) {
        final Integer index = indexMap.get(value);
        
        // insert 和 heapFiy只会匹配一个
        heapInsert(index);
        heapfiy(index, heapSize);
    }


    public void heapInsert(int index) {

        // 判断当前节点 大于 父节点则需要一直往上面寻找
        while (comparator.compare(heap.get(index), heap.get((index - 1) / 2)) < 0) {
            // 交换
            swap(index, (index - 1) / 2);
            
            // 设置当前节点为父节点
            index = (index - 1) / 2;
        }
    }


    public void heapfiy(int index,int heapSize) {
        // index 的左儿子节点
        int left = index * 2 + 1;
        while (left < heapSize) {
            int lagest = left + 1 < heapSize && comparator.compare(heap.get(left), heap.get(left + 1)) > 0 ? left + 1 : left;


            // 比较当前index 和子节点值大小
            lagest = comparator.compare(heap.get(index), heap.get(lagest)) > 0 ? lagest : index;
            
            // 证明还是index比较大
            if (lagest == index) {
                break;
            }

            swap(index, lagest);

            index = lagest;

            left = index * 2 + 1;
        }
    }


    public void swap(int i, int j) {
        T o1 = heap.get(i);
        T o2 = heap.get(j);

        heap.set(i, o2);
        heap.set(j, o1);

        indexMap.put(o1, j);
        indexMap.put(o2, i);
    }


    public static class Student {
        public int classNo;
        public int age;
        public int id;

        public Student(int classNo, int age, int id) {
            this.classNo = classNo;
            this.age = age;
            this.id = id;
        }

        public int getClassNo() {
            return classNo;
        }

        public void setClassNo(int classNo) {
            this.classNo = classNo;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "Student{" +
                    "classNo=" + classNo +
                    ", age=" + age +
                    ", id=" + id +
                    '}';
        }
    }
    
    public static class StudentCompartor implements Comparator<Student>{
        @Override
        public int compare(Student o1, Student o2) {
            return o1.age - o2.age;
        }
    }


    public static void main(String[] args) {
        Heap02<Student> heap02 = new Heap02(new StudentCompartor());

        Student s1 = new Student(001, 18, 10001);
        Student s2 = new Student(001, 22, 10002);
        Student s3 = new Student(002, 15, 10003);
        Student s4 = new Student(002, 17, 10004);

        heap02.push(s1);
        heap02.push(s2);
        heap02.push(s3);
        heap02.push(s4);
        
        s2.setAge(11);
        heap02.resign(s2);

        while (!heap02.isEmpty()) {
            final Student pop = heap02.pop();
            System.out.println(pop);
        }
        
    }
}
