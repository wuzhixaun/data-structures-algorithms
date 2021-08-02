package com.wuzx.mergesort;

import org.junit.Test;

/**
 * @author wuzhixuan
 * @version 1.0.0
 * @ClassName MergeSort.java
 * @Description 归并排序
 * @createTime 2021年08月02日 10:46:00
 */
public class MergeSortDemo {


    /**
     * 归并排序 ，从上往下(递归)
     * @param arr 需要排序的数组
     * @param left 左节点
     * @param right 右节点
     */
    public void mergeSort1(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }

        int mid = (left + right) / 2;

        // 左边
        mergeSort1(arr,left,mid);

        // 右边
        mergeSort1(arr, mid + 1, right);

        // 合并
        mergeArr(arr, left, mid, right);
    }


    /**
     * 归并排序 ，从下往上（非递归）
     *
     * @param arr   需要排序的数组
     */
    public void mergeSort2(int[] arr) {
        if (null == arr || arr.length < 2) {
            return;
        }
        // 每组的个数
        int mergeSize = 1;
        int N = arr.length;
        while (mergeSize < N) {
            int l = 0;
            while (l < N) {
                int m = l + mergeSize - 1;

                while (m >= N) {
                    break;
                }

                int R = Math.min(m + mergeSize, N - 1);

                mergeArr(arr, l, m, R);

                l = R + 1;
            }

            // 越界处理，一般情况不会出现
            if (mergeSize > N / 2) {
                break;
            }
            mergeSize <<= 1;
        }
    }

    /**
     * 合并左右两个区间数组
     * @param arr
     * @param left
     * @param mid
     * @param right
     */
    public void mergeArr(int[] arr, int left, int mid, int right) {
        // 临时的数组
        int[] temp = new int[right - left + 1];
        int tempIndex = 0;
        int p1 = left;
        int p2 = mid + 1;

        // p1 和p2 不越界的情况下
        while (p1 <= mid && p2 <= right) {
            temp[tempIndex++] = arr[p1] <= arr[p2] ? arr[p1++] : arr[p2++];
        }

        // 拷贝p1剩下部分
        while (p1 <= mid) {
            temp[tempIndex++] = arr[p1++];
        }
        // 拷贝p1剩下部分
        while (p2 <= right) {
            temp[tempIndex++] = arr[p2++];
        }
        // 将这部分排好序的部分刷入
        for (int i = 0; i < temp.length; i++) {
            arr[left + i] = temp[i];
        }
    }

    private void sort1(int[] arr) {
        mergeSort1(arr, 0, arr.length - 1);
    }

    private void sort2(int[] arr) {
        mergeSort2(arr);
    }

    @Test
    public void testMergeSort1() {
        int[] arr = {11, 7, 2,11, 9, 8, 18};
        sort1(arr);

        for (int i : arr) {
            System.out.print(i+" ");
        }

    }

    @Test
    public void testMergeSort2() {
        int[] arr = {11, 7, 2,11, 9, 8, 18};
        sort2(arr);

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }


}
