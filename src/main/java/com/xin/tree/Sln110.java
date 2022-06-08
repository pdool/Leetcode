package com.xin.tree;

import common.TreeNode;

public class Sln110 {
    public boolean isBalanced(TreeNode root) {
        if (root == null){
            return true;
        }
        int right = getHeight(root.right);
        int left = getHeight(root.left);
        return Math.abs( right -left) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    public int getHeight(TreeNode root) {
        if (root == null) {
            return 1;
        }
        return Math.max(getHeight(root.left), getHeight(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(20, new TreeNode(15), new TreeNode(7));
        TreeNode treeNode1 = new TreeNode(3, new TreeNode(9), treeNode);
        boolean balanced = new Sln110().isBalanced(treeNode1);
        System.out.println(balanced);
    }
}
