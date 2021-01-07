package com.yuemei.okhttpsourcecode.leetcodetest1.week8;

import org.junit.Test;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    private void insertSort(int[] arry) {
        int preIndex, current;
        for (int i = 1; i < arry.length; i++) {
            preIndex = i - 1;
            current = arry[i];
            while (preIndex >= 0 && arry[preIndex] > current) {
                arry[preIndex + 1] = arry[preIndex];
                preIndex--;
            }
            arry[preIndex + 1] = current;
        }
    }
    @Test
    public void test() {
        int arr[] = new int[]{1, 6, 2, 2, 5};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
