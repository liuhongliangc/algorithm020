package com.yuemei.okhttpsourcecode.leetcodetest3.week3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {

    private ArrayList<String> mStrings;

    /**
     * 数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。
     * 输入：n = 3
     * 输出：[
     * "((()))",
     * "(()())",
     * "(())()",
     * "()(())",
     * "()()()"
     * ]
     */
    @Test
    public void test() {
        System.out.println(generateParenthesis(3));
        System.out.println(factorial(6));

        int[] a = new int[10];
        fill(a,a.length-1);
        System.out.println(Arrays.toString(a));
    }

    private List<String> generateParenthesis(int n) {
        mStrings = new ArrayList<>();
        recursion(0, 0, n, "");
//        recursion(0, 2*n, "");
        recursionDisplay(6);
        return mStrings;
    }

    private void recursion(int left, int right, int n, String s) {
        if (left == n && right == n) {
            mStrings.add(s);
            System.out.println(s);
            return;
        }

        if (left < n) {
            recursion(left + 1, right, n, s + "1");

        }
        if (left > right) {
            recursion(left, right + 1, n, s + "2");

        }
    }

    private void recursion(int level, int max, String s) {
        //terminator
        if (level > max) {
            System.out.println(s);
            return;
        }

        recursion(level + 1, max, s + "1");
        recursion(level + 1, max, s + "2");


        //process current logic
        //drill down
        //revese
    }

    private long factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * factorial(n - 1);
        }
    }
    /**
     * (factorial 6)
     * (* 6 (factorial 5))
     * (* 6 (5 *(factorial 4)))
     * (* 6 (5 *(4 *(factorial 3))))
     * (* 6 (5 *(4 *(3 *(factorial 2)))))
     * (* 6 (5 *(4 *(3 *(2 *(factorial 1))))))
     * (* 6 (5 *(4 *(3 *(2 1)))))
     * (* 6 (5 *(4 *(3 2))))
     * (* 6 (5 *(4 6))))
     * (* 6 (5 24)))
     * (* 6 120))
     * 720
     */

    /*
    关于 递归中 递进和回归的理解*/
    private void recursionDisplay(int n) {
        int temp = n;//保证前后打印的值一样
        System.out.println("递进:" + temp);
        if (n > 0) {
            recursionDisplay(--n);
        }
        System.out.println("回归:" + temp);
    }
    /**
     * 递进:6
     * 递进:5
     * 递进:4
     * 递进:3
     * 递进:2
     * 递进:1
     * 递进:0
     * 回归:0
     * 回归:1
     * 回归:2
     * 回归:3
     * 回归:4
     * 回归:5
     * 回归:6
     */

    private void fill(int[] a,int n){
        if (n<0)return;
        else {
            a[n] = n;
            fill(a,n-1);
        }
    }
}
