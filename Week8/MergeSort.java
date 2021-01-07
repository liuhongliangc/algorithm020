package com.yuemei.okhttpsourcecode.leetcodetest1.week8;

public class MergeSort {
    private void mergeSort(int[] arry, int left, int right) {
        if (right <= left) return;
        int mid = (right + left) >> 1;

        mergeSort(arry, left, mid);
        mergeSort(arry, mid + 1, right);
        merge(arry, left, mid, right);
    }

    private void merge(int[] arry, int left, int mid, int right) {
        int[] temp = new int[right - left + 1];//中间数组
        int i = left, j = mid + 1, k = 0;

        while (i <= mid && j <= right) {
            temp[k++] = arry[i] <= arry[j] ? arry[i++] : arry[j++];
        }

        while (i <= mid) temp[k++] = arry[i++];
        while (j <= right) temp[k++] = arry[j++];

        for (int p = 0; p < temp.length; p++) {
            arry[left + p] = temp[p];
        }
        //也可以用 System.arraycopy(a, start1, b, start2, length)
    }

}
