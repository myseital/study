package com.mao.algorithm.sort;

import java.util.Arrays;

/**
 * 希尔排序
 * 希尔排序的提出，主要基于以下两点
 * 1. 插入排序算法在数组基本有序的情况下，可以近似达到O(n)复杂度，效率极高。
 * 2. 但插入排序每次只能将数据移动一位，在数组较大且基本无序的情况下性能会迅速恶化。
 *
 * @author myseital
 * @date 2022/5/6 14:29
 */
public class ShellSort {

    public static void main(String[] args) {
        int[] arr = {132, 110, 122, 90, 50};
        System.out.println("排序前：" + Arrays.toString(arr));
        shellSort(arr);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void shellSort(int[] arr) {
        int temp;
        for (int delta = arr.length / 2; delta >= 1; delta /= 2) {
            //对每个增量进行一次排序
            for (int i = delta; i < arr.length; i++) {
                for (int j = i; j >= delta && arr[j] < arr[j - delta]; j -= delta) {
                    //注意每个地方增量和差值都是delta
                    temp = arr[j - delta];
                    arr[j - delta] = arr[j];
                    arr[j] = temp;
                }
            }//loop i
        }//loop delta
    }

    public static void shellSort2(int[] arr) {
        int delta = 1;
        while (delta < arr.length / 3) {
            //generate delta
            delta = delta * 3 + 1;
            // <O(n^(3/2)) by Knuth,1973>: 1, 4, 13, 40, 121, ...
        }
        int temp;
        for (; delta >= 1; delta /= 3) {
            for (int i = delta; i < arr.length; i++) {
                for (int j = i; j >= delta && arr[j] < arr[j - delta]; j -= delta) {
                    temp = arr[j - delta];
                    arr[j - delta] = arr[j];
                    arr[j] = temp;
                }
            }//loop i
        }//loop delta
    }
}
