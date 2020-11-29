package com.yuemei.okhttpsourcecode.leetcodetest4;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class InorderTraversal {
    public class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data) {
            this.data = data;
        }

        @Override
        public String toString() {
            return ""+data;
        }
    }
    @Test
    public void test(){
        TreeNode root = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode five = new TreeNode(5);
        TreeNode six = new TreeNode(6);
        root.left = two;
        root.right = three;
        two.left = null;
        two.right = four;
        three.left = five;
        three.right = six;

//        TreeNode root = new TreeNode(3);
//        TreeNode two = new TreeNode(9);
//        TreeNode three = new TreeNode(4);
//        TreeNode four = new TreeNode(5);
//        TreeNode five = new TreeNode(7);
//        root.left = two;
//        root.right = three;
//
//        three.left = four;
//        three.right = five;


        System.out.println(inorderTrasersal(root));
        System.out.println(inorderTraversal2(root));

        System.out.println(preorderTraversal(root));
        System.out.println(preorderTraversal2(root));


        System.out.println(postorderTraversal(root));
        System.out.println(postorderTraversal2(root));
    }

    //------------------------------------------前序遍历-----------------------------------------------------------------------------
    private List<Integer> preorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        preorder(root,list);
        return list;
    }

    private void preorder(TreeNode root, List<Integer> list) {
        if (root == null)return;
        list.add(root.data);
        preorder(root.left,list);
        preorder(root.right,list);
    }

    private List<Integer> preorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null )return list;

        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()){
            while (root != null){
                list.add(root.data);
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            root = root.right;
        }
        return list;
    }


    //------------------------------------------中序遍历-----------------------------------------------------------------------------
    /**
     * 递归
     * @param root
     * @return
     */
    private List<Integer> inorderTrasersal (TreeNode root){
        List<Integer> list = new ArrayList<>();
        inorder(root,list);
        return list;
    }

    private void inorder(TreeNode root, List<Integer> list) {
        if (root == null)return;
        inorder(root.left,list);
        list.add(root.data);
        inorder(root.right,list);
    }


    private List<Integer> inorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()){
            while (root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();
            list.add(root.data);
            root = root.right;
        }
        return list;
    }

    //------------------------------------------后序遍历-----------------------------------------------------------------------------

    private List<Integer> postorderTraversal(TreeNode root){
        List<Integer> list = new ArrayList<>();
        postorder(root,list);
        return list;
    }

    private void postorder(TreeNode root, List<Integer> list) {
        if (root == null)return;
        postorder(root.left,list);
        postorder(root.right,list);
        list.add(root.data);
    }

    private List<Integer> postorderTraversal2(TreeNode root){
        List<Integer> list = new ArrayList<>();
        if (root == null)return list;
        TreeNode prev = null;
        Deque<TreeNode> stk = new LinkedList<>();
        while (root != null || !stk.isEmpty()){
            while (root != null){
                stk.push(root);
                root = root.left;
            }
            root = stk.pop();

            if (root.right == null || root.right == prev){
                list.add(root.data);
                prev = root;
                root = null;
            }else {
                stk.push(root);
                root = root.right;
            }

        }
        return list;
    }
}
