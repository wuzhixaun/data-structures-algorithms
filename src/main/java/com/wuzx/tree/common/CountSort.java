package com.wuzx.tree.common;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName CountSort.java
 * @Description 计数排序
 * @createTime 2021年08月11日 09:08:00
 */
public class CountSort {

    public static int[] countSort(int[] arr) {

        // step 1: 找到最大值
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            max = Math.max(max, i);
        }

        // step 2:创建桶数组
        int[] bucket = new int[max + 1];
        for (int i : arr) {
            bucket[i]++;
        }

        int index = 0;
        // step 3: 将桶中的数倒出
        for (int i = 0; i < bucket.length; i++) {
            while (bucket[i] > 0) {
                arr[index++] = i;
                bucket[i]--;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {7, 88, 1, 5, 66, 9, 3, 11, 55, 33, 8, 16};
        final int[] arr2 = countSort(arr);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}
