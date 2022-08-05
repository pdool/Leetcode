package com.xin.tree.medium;

import common.TreeNode;

public class Sln623 {
    public TreeNode addOneRow(TreeNode root, int val, int depth) {

        if (depth ==1) {
            return new TreeNode(val,root,null);
        } else {
            createTree(root, val, depth);
            return root;
        }
    }

    private void createTree(TreeNode root, int val, int depth) {
        if (root == null) {
            return;
        }
        if (depth == 2) {
            TreeNode left = new TreeNode(val);
            left.left = root.left;
            root.left = left;
            TreeNode right = new TreeNode(val);
            right.right = root.right;
            root.right = right;
            return;
        }
        createTree(root.left, val, depth - 1);
        createTree(root.right, val, depth - 1);
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(4, new TreeNode(2, new TreeNode(3), new TreeNode(1)), null);
        TreeNode treeNode = new TreeNode(4);
        new Sln623().addOneRow(treeNode, 1, 2);
        System.out.println();
    }
}
