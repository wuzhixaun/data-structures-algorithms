# 冒泡排序
> 冒泡排序（Bubble Sort）也是一种简单直观的排序算法。它重复地走访过要排序的数列，一次比较两个元素，如果他们的顺序错误就把他们交换过来。走访数列的工作是重复地进行直到没有再需要交换，也就是说该数列已经排序完成。这个算法的名字由来是因为越小的元素会经由交换慢慢"浮"到数列的顶端。

# 算法步骤
> 比较相邻的元素。如果第一个比第二个大，就交换他们两个。
对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对。这步做完后，最后的元素会是最大的数。
针对所有的元素重复以上的步骤，除了最后一个。
持续每次对越来越少的元素重复上面的步骤，直到没有任何一对数字需要比较。

# 图示
![img.png](https://www.runoob.com/wp-content/uploads/2019/03/bubbleSort.gif)

# 代码
```java

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

```