package com.xin.tree.easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Sln145 {
    //给你一棵二叉树的根节点 root ，返回其节点值的 后序遍历 。
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        postOrder(list,root);
        return list;
    }

    private void postOrder(List<Integer> list, TreeNode root) {
        if (root == null){
            return;
        }
        postOrder(list,root.left);
        postOrder(list,root.right);
        list.add(root.val);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> integers = new Sln145().postorderTraversal(treeNode);
        System.out.println();
    }

}
