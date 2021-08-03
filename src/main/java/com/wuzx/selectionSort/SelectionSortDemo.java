package com.wuzx.selectionSort;

import org.junit.Test;

/**
 * 选择排序
 */
public class SelectionSortDemo {
    
    
    public void SelectionSort(int[] arr) {
        if (null == arr) {
            return;
        }

        for (int i = 0; i < arr.length; i++) {
            
            int minIndex = i;

            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            if (minIndex != i) {
                // 交换
                int tem = arr[minIndex];
                arr[minIndex] =arr[i];
                arr[i] =tem;
            }
        }
    }
    
    
    @Test
    public  void test() {
        int[] arr = new int[]{2, 6, 1, 3, 4, 5, 3, 2, 3};
        SelectionSort(arr);

        for (int i : arr) {
            System.out.print(i + " ");
        }
    }


    /**
     * 2 9 7 4
     * 
     * 
     */
}
