package com.yuemei.okhttpsourcecode.leetcodetest1.week3;

import org.junit.Test;

public class MaxDepth {
    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        @Override
        public String toString() {
            return "" + val;
        }
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(4);
        TreeNode two = new TreeNode(2);
        TreeNode seven = new TreeNode(7);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);
        TreeNode six = new TreeNode(6);
        TreeNode nine = new TreeNode(9);

        root.left = two;
        root.right = seven;
        two.left = one;
        two.right = three;
        seven.left = six;
        seven.right = nine;

        System.out.println(maxDepth(root));
    }

    private int maxDepth(TreeNode root) {
        if (root == null){
            return 0;
        }else {
            int leftHeight = maxDepth(root.left);
            int rightHeight = maxDepth(root.right);
            return Math.max(leftHeight,rightHeight)+1;
        }
    }
}
