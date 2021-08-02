package com.wuzx.mergesort;

import org.junit.Test;

/**
 * 荷兰国旗问题  小于区域| 等于区域 |大于区域 
 */
public class DutchFlagIssue {

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }


    /**
     * 返回等于区域左右边界
     * @param arr
     * @param L
     * @param R
     * @return
     */
    public static int[] DutchFlag(int[] arr, int L, int R) {

        // 无效值
        if (L > R) {
            return new int[]{-1, -1};
        }

        // 证明只有一个数
        if (L == R) {
            return new int[]{L, R};
        }


        int less = L - 1; // 小于区域右边界
        int more = R; // 大于区域左边界
        int index = L; // 遍历开始索引
        while (index < more) {

            if (arr[index] == arr[R]) {
                index++;
            } else if (arr[index] > arr[R]) {
                swap(arr, index, --more);//当前位置和大于区域前一个位置做交换
            } else {
                swap(arr, index++, ++less);
            }
        }

        //最后将最后一个位置和大于区域前一个数做交换(扩大等于区域)
        swap(arr, more, R);

        return new int[]{less + 1, more};
    }


    public static void process2(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        int[] equalArea = DutchFlag(arr, L, R);
        process2(arr, L, equalArea[0] - 1);
        process2(arr, equalArea[1] + 1, R);
    }

    public static void quickSort2(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process2(arr, 0, arr.length - 1);
    }


    public static void quickSort3(int[] arr) {
        if (arr == null || arr.length < 2) {
            return;
        }
        process3(arr, 0, arr.length - 1);
    }

    public static void process3(int[] arr, int L, int R) {
        if (L >= R) {
            return;
        }
        swap(arr, L + (int) (Math.random() * (R - L + 1)), R);
        int[] equalArea = DutchFlag(arr, L, R);
        process3(arr, L, equalArea[0] - 1);
        process3(arr, equalArea[1] + 1, R);
    }

    @Test
    public void testQuickSort() {
        int[] arr = new int[]{2, 6, 1, 3, 4, 5, 3, 2, 3};
        quickSort2(arr);

        for (int i : arr) {
            System.out.print(i+" ");
        }
    }

    @Test
    public void test() {
        int[] arr = new int[]{2, 6, 1, 3, 4, 5, 3, 2, 3};


        final int[] ints = DutchFlag(arr, 0, arr.length - 1);

        for (int anInt : ints) {
            System.out.println(anInt);
        }


        for (int i : arr) {
            System.out.print(i+"  ");
        }
    }
    
}

