package com.xin.tree;

import common.TreeNode;

public class Sln100 {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == q && p == null){
            return true;
        }
        if(p == null || q == null || p.val != q.val){
            return false;
        }
        return isSameTree(p.left,q.left) &&  isSameTree(p.right,q.right);
    }

    public static void main(String[] args) {
        TreeNode p = new TreeNode(1,null,new TreeNode(2,null,null));
        TreeNode q = new TreeNode(1,new TreeNode(2,null,null),null);
        boolean sameTree = new Sln100().isSameTree(null, null);
        System.out.println();
    }
}
