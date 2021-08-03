# 算法-选择排序
> 选择排序是一种简单直观的排序算法，无论什么数据进去都是 O(n²) 的时间复杂度。所以用到它的时候，数据规模越小越好。唯一的好处可能就是不占用额外的内存空间了吧。

# 算法步骤

+ 首先在未排序序列中找到最小（大）元素，存放到排序序列的起始位置。
+ 再从剩余未排序元素中继续寻找最小（大）元素，然后放到已排序序列的末尾。
+ 重复第二步，直到所有元素均排序完毕

# 演示

![选择排序](https://www.runoob.com/wp-content/uploads/2019/03/selectionSort.gif)

# 代码
```java

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
    
}

```