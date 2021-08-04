# 堆排序
+ 先让整个数组都变成大根堆结构，建立堆的过程
  + 从上到下的方法，时间复杂度为O(logN*N)
  + 从下到上的方法，时间复杂度为O(N)
+ 把堆的最大值和堆末尾的值进行交换，然后减少堆的大小之后，再去调整堆，一直周而复始，时间复杂度为O(N)
+ 堆的大小减成0之后，排序完成

# 图示
![堆排序](https://www.runoob.com/wp-content/uploads/2019/03/heapSort.gif)

# 代码
> 其实你会将数据调整为 小根堆或者大根堆，你就会堆排序了

## 从上到下构建堆
```java
    /**
     * 
     * 从上之下
     * @param heap
     * @param index
     */
    public void heapInsert(int[] heap, int index) {
        
        // 父节点(index - 1) / 2小于当前节点
        while (heap[(index - 1) / 2] < heap[index]) {
            // 交换
            swap(heap,(index - 1) / 2,index);
            index = (index - 1) / 2;
        }
    }
```

## 从下到上构建堆
```java
private void heapfiy(int[] arr, int index, int heapSize) {
        // 获取当前index 的左孩子
        int left = index * 2 + 1;

        // 左孩子节点小于堆大小
        while (left < heapSize) {

            // 孩子节点的最大 值的位置值
            int lagest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            // 判断index 和孩子节点的值大小
            lagest = arr[index] > arr[lagest] ? index : lagest;

            // 如果当前节点就是最大的不需要继续下沉，跳出
            if (lagest == index) {
                break;
            }
            // 交换
            swap(arr, index, lagest);

            index = lagest;

            // 获取最大的节点的左孩子节点
            left = index * 2 + 1;
        }

    }
```


## 整个堆排序代码
```java


public class HeapSort {

    private void heapfiy(int[] arr, int index, int heapSize) {
        // 获取当前index 的左孩子
        int left = index * 2 + 1;

        // 左孩子节点小于堆大小
        while (left < heapSize) {

            // 孩子节点的最大 值的位置值
            int lagest = left + 1 < heapSize && arr[left + 1] > arr[left] ? left + 1 : left;

            // 判断index 和孩子节点的值大小
            lagest = arr[index] > arr[lagest] ? index : lagest;

            // 如果当前节点就是最大的不需要继续下沉，跳出
            if (lagest == index) {
                break;
            }
            // 交换
            swap(arr, index, lagest);

            index = lagest;

            // 获取最大的节点的左孩子节点
            left = index * 2 + 1;
        }

    }


    /**
     * 数组两个位置交换
     * @param arr
     * @param i
     * @param j
     */
    private void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    @Test
    public void testHeapSort() {
        int[] arr = {1, 20,18, 6, 9, 2, 10, 11, 7};

        // 构建最大根堆
        for (int i = 0; i < arr.length; i++) {
            heapfiy(arr, arr.length - 1 - i, arr.length);
        }

        System.out.println("----------------------");
        for (int i : arr) {
            System.out.print (i+" ");
        }
        System.out.println();
        System.out.println("----------------------");

        /*
         * 最大跟交换
         * heapSize --
         * heapFiy调用
         */
        int len = arr.length;
        for (int i = 0; i < arr.length - 1; i++) {
            swap(arr, 0, len - 1);
            heapfiy(arr, 0, --len);
        }
        
        System.out.println("++++++++++++++++++");
        for (int i : arr) {
            System.out.print (i+" ");
        }
        System.out.println();
        System.out.println("++++++++++++++++++");
    }
}
```