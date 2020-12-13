package com.yuemei.okhttpsourcecode.leetcodetest1.week4;

import org.junit.Test;

public class Sqrtx {

    private int mySqrt(int x) {
        int left = 0, right = x, ans = -1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if ((long) mid * mid <= x) {
                ans = mid;
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return ans;
    }

    private int mySqrt2(int x){
        long r = x;
        while(r*r >x){
            r = (r+x/r)/2;
        }
        return (int) r;
    }



    /**
     * 计算并返回 x 的平方根，其中 x 是非负整数。
     * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去。
     * 示例 1:
     * 输入: 4
     * 输出: 2
     * 示例 2:
     * 输入: 8
     * 输出: 2
     * 说明: 8 的平方根是 2.82842...,
     * 由于返回类型是整数，小数部分将被舍去。
     */
    @Test
    public void test() {
        System.out.println(mySqrt(9));
        System.out.println(mySqrt2(9));
    }
}
