package com.xin.tree.easy;

import common.TreeNode;

public class Sln404 {
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root,  false);
    }


    public int sum(TreeNode root,  boolean isLeft) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            if (isLeft) {
                return root.val;
            }
            return 0;
        }
        return  sum(root.left, true) + sum(root.right,  false);
    }
}
