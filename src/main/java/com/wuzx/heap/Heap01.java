package com.wuzx.heap;

/**
 * 堆结构
 */
public class Heap01 {
    private int[] heap;
    private int heapSize;
    private int limit;

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
     * 
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
     *     8
     *    5  7
     *   3 3
     *    
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
}
