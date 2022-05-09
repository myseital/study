package com.mao.algorithm.sort;

import java.util.Arrays;

/**
 * 堆排序（Heap Sort）算法是利用堆结构和二叉树的一些特性来完成排序的。
 * 堆结构是一种树结构，准确来说是一个完全二叉树。完全二叉树每个节点应满足以下条件：
 * • 如果按照从小到大的顺序排序，要求非叶节点的数据要大于等于，其左、右子节点的数据；
 * • 如果按照从大到小的顺序排序，要求非叶节点的数据小于等于，其左、右子节点的数据。
 * 可以看出，堆结构对左、右子节点的大小没有要求，只规定叶节点要和子节点（左、右）的数据满足大小关系。
 *
 * @author myseital
 * @date 2021/4/4 03:30
 */
public class HeapSort {

    public static void main(String[] args) {
        int[] heapNums = {18, 1, 6, 27, 15};
        System.out.println("堆排序前：" + Arrays.toString(heapNums));
        heapSort(heapNums, heapNums.length);
        System.out.println("堆排序后：" + Arrays.toString(heapNums));
    }

    private static void heapSort(int[] nums, int length) {
        int i;
        // 从最后一个非叶节点开始将 nums[0,n-1] 构建大顶堆
        for (i = length / 2 - 1; i >= 0; i--) {
            maximumHeap(nums, length, i);
        }
        // 从最小的叶子节点开始与根节点进行交换并重新构建大顶堆
        for (i = length - 1; i > 0; i--) {
            // 与第 i 个记录交换
            swap(nums, i, 0);
            length--;
            maximumHeap(nums, length, 0);
            // 输出每步排序结果
            System.out.println("第" + (length - i) + "次排序：" + Arrays.toString(nums));
        }
    }

    private static void maximumHeap(int[] nums, int length, int i) {
        int j;
        // 第 i 个节点，有右子树
        while (2 * i + 1 < length) {
            j = 2 * i + 1;
            if ((j + 1) < length) {
                // 右左子树小于右子树，则需要比较右子树
                if (nums[j] < nums[j + 1]) {
                    // 序号增加 1，指向右子树
                    j++;
                }
            }
            if (nums[i] < nums[j]) {
                // 交换数据
                swap(nums, j, i);
                // 堆被破坏，重新调整
                i = j;
            } else {
                // 左右子节点均大，则堆未被破坏，不需要调整
                break;
            }
        }
    }

    private static void heapify(int[] arr, int len, int i) {
        // 先根据堆性质，找出它左右节点的索引
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        // 默认当前节点（父节点）是最大值。
        int largestIndex = i;
        if (left < len && arr[left] > arr[largestIndex]) {
            // 如果有左节点，并且左节点的值更大，更新最大值的索引
            largestIndex = left;
        }
        if (right < len && arr[right] > arr[largestIndex]) {
            // 如果有右节点，并且右节点的值更大，更新最大值的索引
            largestIndex = right;
        }

        if (largestIndex != i) {
            // 如果最大值不是当前非叶子节点的值，那么就把当前节点和最大值的子节点值互换
            swap(arr, largestIndex, i);
            // 因为互换之后，子节点的值变了，如果该子节点也有自己的子节点，仍需要再次调整。
            heapify(arr, largestIndex, len);
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
