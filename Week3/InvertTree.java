package com.yuemei.okhttpsourcecode.leetcodetest1.week3;

import com.yuemei.okhttpsourcecode.leetcodetest1.week2.InorderTraversal;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class InvertTree {

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

        System.out.println(inorderTraverasl(root));
        invertTree(root);
        System.out.println(inorderTraverasl(root));
    }

    /**
     * 翻转二叉树
     * @param root
     * @return
     */
    private TreeNode invertTree(TreeNode root) {
        if (root == null){
            return null;
        }

        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;

        return root;
    }


    /**
     * 中序遍历
     * @param root
     * @return
     */
    private List<Integer> inorderTraverasl(TreeNode root){
        List<Integer> res = new ArrayList<>();
        inorder(root,res);
        return res;
    }

    private void inorder(TreeNode root, List<Integer> res) {
        if (root == null)return;
        inorder(root.left,res);
        res.add(root.val);
        inorder(root.right,res);
    }



}
