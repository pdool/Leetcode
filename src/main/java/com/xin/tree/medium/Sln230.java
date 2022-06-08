package com.xin.tree.medium;

import common.TreeNode;

import java.util.List;

public class Sln230 {
    /**
     *
     给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。
     */
    /**
     * 二叉搜索树：有序的，k
     * 思路：中序遍历，第K个
     */

    int count;
    int target;
    TreeNode kNode;
    public int kthSmallest(TreeNode root, int k) {
        count = 0;
        target =k;
        getK(root);
        return kNode.val;
    }
    public void getK(TreeNode root){
        if (root == null ){
            return;
        }
        //  一路到底
        getK(root.left);
        count++;
        if (count == target){
            kNode =root;
            return;
        }
        getK(root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode1 = new TreeNode(1,null,treeNode2);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode3 = new TreeNode(4,treeNode1,treeNode4);
        int i = new Sln230().kthSmallest(treeNode3, 1);
        System.out.println();
    }
}
