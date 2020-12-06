package com.yuemei.okhttpsourcecode.leetcodetest2.week3;

import android.support.annotation.NonNull;

import org.junit.Test;

public class LowestCommonAncestor {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode rigth;

        public TreeNode(int val) {
            this.val = val;
        }

        @NonNull
        @Override
        public String toString() {
            return "" + val;
        }
    }

    @Test
    public void test() {
        TreeNode root = new TreeNode(3);
        TreeNode five = new TreeNode(5);
        TreeNode one = new TreeNode(1);
        TreeNode six = new TreeNode(6);
        TreeNode two = new TreeNode(2);
        TreeNode zero = new TreeNode(0);
        TreeNode eight = new TreeNode(8);
        TreeNode seven = new TreeNode(7);
        TreeNode four = new TreeNode(4);

        root.left = five;
        root.rigth = one;
        five.left = six;
        five.rigth = two;
        one.left = zero;
        one.rigth = eight;
        two.left = seven;
        two.rigth = four;

        System.out.println(lowestCommonAncestor(root,five,four));
    }

    private TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q){
            return root;
        }

        TreeNode lson = lowestCommonAncestor(root.left, p, q);
        TreeNode rson = lowestCommonAncestor(root.rigth, p, q);

        if (lson != null && rson != null)return root;
        return lson != null ? lson:rson;
    }
}
