package com.wuzx.tree;

/**
 * 基数排序
 */
public class RadixSort {

    /**
     * 1.先按个位树排序放置到桶中
     * 2.
     * @param arr
     */
    public void radixSortDemo1(int[] arr) {
        radixSort(arr, 0, arr.length - 1, getMaxDigit(arr));
    }


    /**
     * 1.首先就是统计当前位数上面有多少个
     * @param arr 
     * @param L 
     * @param R
     * @param digit 最大位数
     */
    public void radixSort(int[] arr, int L, int R, int digit) {

        final int radix = 10; // 个位，十位，百位....
        int i = 0, j = 0;
        // 有多少个数准备多少个辅助空间
        int[] help = new int[R - L + 1];

        for (int d = 1; d <= digit; d++) { // 有多少位就进出几次

            // 10个空间
            // count[0] 当前位(d位)是0的数字有多少个
            // count[1] 当前位(d位)是(0和1)的数字有多少个
            // count[2] 当前位(d位)是(0、1和2)的数字有多少个
            // count[i] 当前位(d位)是(0~i)的数字有多少个
            int[] count = new int[radix]; // count[0..9]

            for (i = L; i <= R; i++) {
                j = getDigit(arr[i], d);
                count[j]++;
            }


            for (i = 1; i < radix; i++) {
                count[i] = count[i] + count[i - 1];
            }
            
            for (i = R; i >= L; i--) {
                j = getDigit(arr[i], d);
                help[count[j] - 1] = arr[i];
                count[j]--;
            }
            for (i = L, j = 0; i <= R; i++, j++) {
                arr[i] = help[j];
            }
        }
        
    }

    public static void main(String[] args) {
        System.out.println(getDigit(1,1));
        System.out.println(Math.pow(10, 1));
    }


    /**
     * 获取当前位数上面的值
     * @param x
     * @param d
     * @return
     */
    public static int getDigit(int x, int d) {
        return ((x / ((int) Math.pow(10, d - 1))) % 10);
    }

    /**
     * 获取最高位数
     */
    private int getMaxDigit(int[] arr) {
        int maxValue = getMaxValue(arr);
        return getNumLenght(maxValue);
    }

    /**
     * 获取数组中最大的一个数
     * @param arr
     * @return
     */
    public int getMaxValue(int[] arr) {
        int max = Integer.MIN_VALUE;
        for (int i : arr) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }


    /**
     * 获取一个数的位数
     * @param value
     * @return
     */
    public int getNumLenght(int value) {
        if (value == 0) {
            return 1;
        }

        int lenght = 0;
        for (int temp = value; temp != 0; temp /= 10) {
            lenght++;
        }

        return lenght;
    }
    
}
