package com.xin.tree.easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Sln144 {
    /**
     * easy
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     *
     * @param root
     * @return
     */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> arrayList = new ArrayList<>();
        preorder(arrayList, root);
        return arrayList;
    }

    private void preorder(List<Integer> arrayList, TreeNode root) {
        //  结束点 是什么？ 思考下，因为有null的形式
        if (root == null) {
            return;
        }
        arrayList.add(root.val);
        preorder(arrayList, root.left);
        preorder(arrayList, root.right);
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, null, new TreeNode(2, new TreeNode(3), null));
        List<Integer> integers = new Sln144().preorderTraversal(treeNode);
        System.out.println();
    }

}
