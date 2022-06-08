package com.xin.tree.medium;

import com.xin.tree.easy.Sln145;
import common.TreeNode;

public class Sln222 {
    /**
     * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
     *
     * 完全二叉树 的定义如下：在完全二叉树中，
     * 除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。若最底层为第 h 层，则该层包含 1~2h个节点。
     *
     * @param root
     * @return
     */
    /**
     * 思路：
     * 1、可以层序遍历，做个队列，计数
     * 2、可以递归遍历，计数，随便中序，后序，前序
     *
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            return 1;
        }
        //  注意+1 ，要不然只能计算子节点
        return countNodes(root.left) + countNodes(root.right) + 1;

    }

    public static void main(String[] args) {
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode3 = new TreeNode(6, treeNode6, null);
        TreeNode treeNode2 = new TreeNode(6, treeNode4, treeNode5);
        TreeNode treeNode1 = new TreeNode(6, treeNode2, treeNode3);

        int i = new Sln222().countNodes(treeNode1);
        System.out.println();
    }
}
