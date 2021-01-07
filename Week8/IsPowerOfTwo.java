package com.yuemei.okhttpsourcecode.leetcodetest1.week8;

import org.junit.Test;

public class IsPowerOfTwo {
    private boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        long x = (long) n;
        //当一个偶数与它的负值相与时，结果是能被这个偶数整除的最大的2的n次幂
        //当一个奇数与它的负值相与时结果一定是1.
        return (x & (-x)) == x;
    }

    @Test
    public void test() {
        System.out.println(isPowerOfTwo(218));
    }
}
