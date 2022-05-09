package com.mao.algorithm.sort;

import java.util.Arrays;

/**
 * 快速排序 (二分排序)（Quick Sort）算法和冒泡排序算法类似，
 * 都是基于交换排序思想实现的，快速排序算法是对冒泡排序算法的改进，从而具有更高的执行效率。
 * • 首先设定一个分界值，通过该分界值把数组分为左右两个部分；
 * • 将大于等于分界值的元素放到分界值的右边，将小于分界值的元素放到分界值的左边；
 * • 然后对左右两边的数据进行独立的排序，在左边数据中取一个分界值，把小于分界值的元素放到分界值的左边，
 * 大于等于分界值的元素，放到数组的右边；右边的数据也执行同样的操作；
 * • 重复上述操作，当左右各数据排序完成后，整个数组也就完成了排序。
 *
 * @author myseital
 * @date 2021/4/1 02:07
 */
public class QuickSort {
    public static void main(String[] args) {
        int[] quickNums = {18, 1, 6, 27, 15};
        System.out.println("排序前：" + Arrays.toString(quickNums));
        quickSort(quickNums, 0, quickNums.length - 1);
        System.out.println("排序后：" + Arrays.toString(quickNums));
    }


    public static void quickSort(int[] arr){
        qsort(arr, 0, arr.length-1);
    }
    private static void qsort(int[] arr, int low, int high){
        if (low >= high)
            return;
        //将数组分为两部分
        int pivot = partition(arr, low, high);
        //递归排序左子数组
        qsort(arr, low, pivot-1);
        //递归排序右子数组
        qsort(arr, pivot+1, high);
    }
    private static int partition(int[] arr, int low, int high){
        int pivot = arr[low];     //基准
        while (low < high){
            while (low < high && arr[high] >= pivot) --high;
            //交换比基准大的记录到左端
            arr[low]=arr[high];
            while (low < high && arr[low] <= pivot) ++low;
            //交换比基准小的记录到右端
            arr[high] = arr[low];
        }
        //扫描完成，基准到位
        arr[low] = pivot;
        //返回的是基准的位置
        return low;
    }


    public static void quickSort(int[] arr, int start, int end) {
        //直到start=end时结束递归
        if (start >= end) {
            return;
        }
        int left = start;
        int right = end;
        // 基准数
        int baseval = arr[start];
        while (left < right) {
            // 从右向左找比基准数小的数
            while (left < right && arr[right] > baseval) {
                right--;
            }
            arr[left] = arr[right];
            left++;

            // 从左向右找比基准数大的数
            while (left < right && arr[left] <= baseval) {
                left++;
            }
            arr[right] = arr[left];
            right--;
        }
        // 把基准数放到i的位置
        arr[left] = baseval;
        System.out.println(Arrays.toString(arr));
        // 递归
        quickSort(arr, start, left - 1);
        quickSort(arr, left + 1, end);
    }

    private static void quickSort1(int[] nums, int left, int right) {
        int f, t;
        int ltemp = left;
        int rtemp = right;
        // 分界值
        f = nums[(left + right) / 2];
        while (ltemp < rtemp) {
            while (nums[ltemp] < f) {
                ++ltemp;
            }
            while (nums[rtemp] > f) {
                --rtemp;
            }
            if (ltemp <= rtemp) {
                t = nums[ltemp];
                nums[ltemp] = nums[rtemp];
                nums[rtemp] = t;
                --rtemp;
                ++ltemp;
            }
        }

        System.out.println(Arrays.toString(nums));


        if (ltemp == rtemp) {
            ltemp++;
        }
        if (left < rtemp) {
            // 递归调用
            quickSort1(nums, left, ltemp - 1);
        }
        if (right > ltemp) {
            // 递归调用
            quickSort1(nums, rtemp + 1, right);
        }
    }
}
