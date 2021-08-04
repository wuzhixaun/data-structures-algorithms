package com.wuzx.heap;

import org.junit.Test;

/**
 * 堆结构
 */
public class Heap01 {
    private int[] heap;
    private int heapSize;
    private int limit;

    public int[] getHeap() {
        return heap;
    }

    public void setHeap(int[] heap) {
        this.heap = heap;
    }

    public int getHeapSize() {
        return heapSize;
    }

    public void setHeapSize(int heapSize) {
        this.heapSize = heapSize;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    private boolean isEmpty() {
        return heapSize == 0;
    }

    private boolean isFull() {
        return heapSize == limit;
    }

    public void push(int value) {
        if (isFull()) {
            throw new RuntimeException("heap is full");
        }
        heap[heapSize] = value;
        heapInsert(heap, heapSize++);
    }


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

    /**
     * 
     * 
     * @param heap
     * @param index
     * @param heapSize
     */
    public void heapify(int[] heap, int index, int heapSize) {

        // 左孩子节点
        int left = index * 2 + 1;
        while (left < heapSize) {
            int lagest = left + 1 < heapSize && heap[left + 1] > heap[left] ? left + 1 : left;

            // 当前节点的值和最大值比较->是否还需要下沉
            lagest = heap[lagest] > heap[index] ? lagest : index;

            if (lagest == index) {
                break;
            }
            
            // 交换
            swap(heap, index, lagest);

            // 当前的节点更换
            index = lagest;
            // 继续下沉
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

    public Heap01 create(int[] arr) {
        Heap01 heap = new Heap01();
        heap.setHeap(new int[arr.length]);
        heap.setLimit(arr.length);
        heap.setHeapSize(0);
        return heap;
    }

    /**
     * 构建堆
     * 时间复杂度 N * logN
     */
    @Test
    public void testCreateHeap() {
        int[] arr = {1, 18, 6, 9, 2, 10, 3, 6};

        Heap01 heap = create(arr);
        for (int i : arr) {
            heap.push(i);
        }
        for (int i : heap.getHeap()) {
            System.out.println(i+" ");
        }

    }

    /**
     * 堆
     */
    @Test
    public void testheapFiy() {
        int[] arr = {1, 18, 6, 9, 2, 10, 3, 6};
        Heap01 heap = create(arr);
        heap.setHeap(arr);


        for (int i = 0; i < heap.getHeap().length; i++) {
            heapify(heap.getHeap(), arr.length - 1-i, arr.length);
        }

        for (int i : heap.getHeap()) {
            System.out.println(i+" ");
        }
    }
}
