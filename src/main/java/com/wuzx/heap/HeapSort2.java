package com.wuzx.heap;


import java.util.Arrays;

/**
 * 堆排序
 * 思路：
 */
public class HeapSort2 {

    public static void sort(int[] array) {

        // 1. 把无序数组构建成最大堆
        for (int i = array.length / 2 - 1; i >= 0; i--) {
            adjustHeap(array, i, array.length);
        }

        // 2. 调整堆结构+交换堆顶元素与末尾元素，调整堆产生新的堆顶
        for (int i = array.length - 1; i > 0; i--) {
            // 最后1个元素和第1个元素进行交换
            int temp = array[i];
            array[i] = array[0];
            array[0] = temp;
            // “下沉”调整最大堆
            adjustHeap(array, 0, i);
        }

    }


    private static void adjustHeap(int[] array, int parentIndex, int length) {

        // 保存父节点的值
        int tmp = array[parentIndex];
        // 左孩子节点
        int childIndex = parentIndex * 2 + 1;


        while (childIndex < length) {
            // 如果有右孩子并且右孩子的值大于左孩子
            if (childIndex + 1 < length && array[childIndex + 1] > array[childIndex]) {
                childIndex++;
            }

            // 比较父节点和子节点的大小
            if (tmp > array[childIndex]) {
                break;
            }

            ///无须真正交换，单向赋值即可
            array[parentIndex] = array[childIndex];
            parentIndex = childIndex;
            //下一个左孩子
            childIndex = 2 * childIndex + 1;
        }

        array[parentIndex] = tmp;

    }


    public static void main(String[] args) {
        int[] arr = {7, 6, 4, 3, 5, 2, 10, 9, 8};
        System.out.println("排序前:" + Arrays.toString(arr));
        sort(arr);
        System.out.println("排序后:" + Arrays.toString(arr));
    }
}
