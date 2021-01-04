package com.yuemei.okhttpsourcecode.leetcodetest1.week3;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class GenerateParenthesis {


    private List<String> mResult;

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
    }
    private List<String> generateParenthesis(int n) {
        if (n <= 0) return Collections.EMPTY_LIST;
        mResult = new ArrayList<>();
        generate(0, 0,n, "");
        return mResult;
    }

    private void generate(int left, int right,int n, String s) {
        //terminator
        if (left == n && right == n) {
            mResult.add(s);
            return;
        }
        //process current logic
        if (left < n){
            generate(left + 1, right, n,s + "(");//左边的括号，随时可以加，只要别超标
        }
        if (left > right){
            generate(left,right+1, n, s + ")");//左括号>右括号
        }

        //drill down

        //reverse states
    }
}
