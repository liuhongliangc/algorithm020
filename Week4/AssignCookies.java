package com.yuemei.okhttpsourcecode.leetcodetest1.week4;


import org.junit.Test;

import java.util.Arrays;

public class AssignCookies {

    private int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);
        int kid = 0;
        for (int i = 0; i < s.length && kid < g.length; i++) {
            if (s[i]>= g[kid])kid++;//小饼干尺寸满足孩子胃口
        }
        return kid;
    }


    @Test
    public void test() {
        int[] g = new int[]{1, 2};
        int[] s = new int[]{1, 1, 1};
        System.out.println(findContentChildren(g, s));
    }
}
