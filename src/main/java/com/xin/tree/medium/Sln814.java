package com.xin.tree.medium;

import common.TreeNode;

public class Sln814 {
    public TreeNode pruneTree(TreeNode root) {
        if (root == null){
            return null;
        }
        if (root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        root.left = pruneTree(root.left);
        root.right = pruneTree(root.right);
        if (root.val == 0 && root.left == null && root.right == null){
            return null;
        }
        return root;

    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(0,new TreeNode(0),new TreeNode(0));
//        TreeNode right = new TreeNode(1,new TreeNode(0),new TreeNode(1));
        TreeNode treeNode = new TreeNode(1,left, null);
        TreeNode treeNode1 = new Sln814().pruneTree(treeNode);
        System.out.println();
    }
}
