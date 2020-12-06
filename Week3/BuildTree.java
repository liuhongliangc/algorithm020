package com.yuemei.okhttpsourcecode.leetcodetest1.week3;

import android.support.annotation.NonNull;

import org.junit.Test;

public class BuildTree {
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

    /**
     * 根据一棵树的前序遍历与中序遍历构造二叉树。
     * <p>
     * 注意:
     * 你可以假设树中没有重复的元素。
     * 前序遍历 preorder = [3,9,20,15,7]
     * 中序遍历 inorder = [9,3,15,20,7]
     */

    @Test
    public void test() {

    }


    private TreeNode buildTree(int[] preorder, int[] inorder) {
        return helper(0, 0, inorder.length - 1, preorder, inorder);
    }

    private TreeNode helper(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
        if (preStart > preorder.length - 1 || inStart > inEnd) {
            return null;
        }

        TreeNode root = new TreeNode(preorder[preStart]);
        int inIndex = 0;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == root.val) {
                inIndex = i;
            }
        }
        root.left = helper(preStart + 1, inStart, inIndex - 1, preorder, inorder);
        root.rigth = helper(preStart + inIndex - inStart + 1, inIndex + 1, inEnd, preorder, inorder);
        return null;
    }
}
