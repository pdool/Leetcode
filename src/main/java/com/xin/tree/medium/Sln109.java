package com.xin.tree.medium;

import common.TreeNode;

public class Sln109 {
    public TreeNode sortedListToBST(ListNode head) {
        return buildTree(head,null);
    }

    private TreeNode buildTree(ListNode left, ListNode right) {
        if (left == right){
            return null;
        }
        ListNode mid = getMidNode(left,right);
        TreeNode treeNode = new TreeNode(mid.val);
        treeNode.left = buildTree(left,mid);
        treeNode.right = buildTree(mid.next,right);
        return treeNode;
    }

    private ListNode getMidNode(ListNode left, ListNode right) {
        ListNode fast = left;
        ListNode slow = left;
        while (fast != right && fast.next != right) {
            fast = fast.next;
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
    //   主要是取中间结点
    // 然后分治法组装树
}
