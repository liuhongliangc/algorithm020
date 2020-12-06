package com.yuemei.okhttpsourcecode.leetcodetest1.week3;

import org.junit.Test;

public class IsValidBST {
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

    /**
     * 给定一个二叉树，判断其是否是一个有效的二叉搜索树。
     *
     * 假设一个二叉搜索树具有如下特征：
     *
     * 节点的左子树只包含小于当前节点的数。
     * 节点的右子树只包含大于当前节点的数。
     * 所有左子树和右子树自身必须也是二叉搜索树。
     *
     */
    @Test
    public void test(){
        TreeNode root = new TreeNode(2);
        TreeNode one = new TreeNode(1);
        TreeNode three = new TreeNode(3);

        root.left = one;
        root.right = three;
        System.out.println(isValidBST(root));
        System.out.println(isValidBST2(root));
    }

    public boolean isValidBST(TreeNode root) {
        return recursion(root,null,null);
    }

    private boolean recursion(TreeNode root,Integer lower,Integer upper) {
        if (root == null)return true;

        int val = root.val;
        if (lower != null && val < lower){
            return false;
        }
        if (upper != null && val >= upper){
            return false;
        }
        if (!recursion(root.right,val,upper)){
            return false;
        }
        if (!recursion(root.left,lower,val)){
            return false;
        }
        return true;
    }


    private boolean isValidBST2(TreeNode root){
        return isValidBST2(root,Long.MIN_VALUE,Long.MAX_VALUE);
    }
    private boolean isValidBST2(TreeNode root, long minValue, long maxValue) {
        if (root == null)return true;
        if (root.val >= maxValue || root.val <= minValue)return false;
        return isValidBST2(root.left,minValue,root.val) && isValidBST2(root.right,root.val,maxValue);
    }


}
