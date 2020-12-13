package com.yuemei.okhttpsourcecode.leetcodetest1.week4;

import org.junit.Test;

import java.util.Arrays;

public class LemonadeChange {


    @Test
    public void test() {
        int[] bills = new int[]{5, 5, 5, 10, 20};
        System.out.println(coinChange(bills));
    }

    private boolean coinChange(int[] bills) {
        int five = 0, ten = 0;
        for (int bill : bills) {
            if (bill == 5) {
                five++;
            } else if (bill == 10) {
                five--;
                ten++;
            } else if (ten > 0) {
                ten--;
                five--;
            } else {
                five -= 3;
            }

            if (five < 0) return false;
        }
        return true;
    }
}
