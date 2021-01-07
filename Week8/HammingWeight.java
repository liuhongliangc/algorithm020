package com.yuemei.okhttpsourcecode.leetcodetest1.week8;

import org.junit.Test;

public class HammingWeight {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for (int i = 0; i < 32; i++) {
            if ((n & mask) != 0) {
                bits++;
            }
            mask <<= 1;
        }
        return bits;
    }

    @Test
    public void test(){
        System.out.println(hammingWeight(00000000000000000000000000001011));
    }
}
