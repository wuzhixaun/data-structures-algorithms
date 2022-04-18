# 计数排序

> 计数排序是一个非基于比较的排序算法，该算法于1954年由 Harold H. Seward 提出。它的优势在于在对一定范围内的整数排序时，它的复杂度为Ο(n+k)（其中k是整数的范围），快于任何比较排序算法。 [1] 当然这是一种牺牲空间换取时间的做法，而且当O(k)>O(n*log(n))的时候其效率反而不如基于比较的排序（基于比较的排序的时间复杂度在理论上的下限是O(n*log(n)), 如归并排序，堆排序）

# 算法步骤

+ 找到数组`arr` 中的最大值为 max
+ 创建一个桶数组`bucket=int[max+1]` , i代表的是就是arr里面的值，value就是arr 出现的个数
+ 统计数组中每个值为i的元素出现的次数，存入数组的第i项
+ 反向填充目标数组`arr` ,遍历 `bucket` 值大于0的就往arr反向填充

# 演示

![计数排序](https://www.runoob.com/wp-content/uploads/2019/03/countingSort.gif)

# 代码

```java


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
        int[] arr = {7, 1,66, 5, 9, 3, 11, 55, 33, 8, 16};
        final int[] arr2 = countSort(arr);
        for (int i : arr2) {
            System.out.print(i + " ");
        }
    }
}

```