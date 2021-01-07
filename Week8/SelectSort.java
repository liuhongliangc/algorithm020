package com.yuemei.okhttpsourcecode.leetcodetest1.week8;

import org.junit.Test;

import java.util.Arrays;

/**
 *
 */
public class SelectSort {
    private void selectSort(int[] arry) {
        int minIndex, temp;
        for (int i = 0; i < arry.length - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < arry.length; j++) {
                if (arry[j] < arry[minIndex]) {
                    minIndex = j;
                }
            }
            temp = arry[i];
            arry[i] = arry[minIndex];
            arry[minIndex] = temp;
        }
    }
    @Test
    public void test() {
        int arr[] = new int[]{1, 6, 2, 2, 5};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
