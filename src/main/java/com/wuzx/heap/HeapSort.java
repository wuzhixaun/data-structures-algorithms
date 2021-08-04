package com.wuzx.heap;

import org.junit.Test;

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
