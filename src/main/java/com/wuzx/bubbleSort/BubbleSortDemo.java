package com.wuzx.bubbleSort;

import org.junit.Test;

/**
 * 冒泡排序
 */
public class BubbleSortDemo {


    public void bubbleSort(int[] arr) {
        if (null == arr) {
            return;
        }
        
        // 外层
        for (int i = 0; i < arr.length-1; i++) {
            for (int j = 0; j < arr.length-1 - i; j++) {
                // j 和 j +1 位置上面的数做比较
                if (arr[j] > arr[j + 1]) {
                    int tem = arr[j+1];
                    arr[j + 1] = arr[j];
                    arr[j] = tem;
                }
            }
        }
    }


    @Test
    public void test() {
        int[] arr = { 22, 34, 3, 32, 82, 55, 89, 50, 37, 5, 64, 35, 9, 70 };
        bubbleSort(arr);

        for (int i : arr) {
            System.out.print(i+ "  " );
        }
        
    }
}
