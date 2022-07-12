package com.xin.tree.medium;

import common.TreeNode;

public class Sln450 {
    public TreeNode deleteNode(TreeNode root, int key) {
        TreeNode cur = root, curParent = null;
        while (cur != null && cur.val != key) {
            curParent = cur;
            if (cur.val > key) {
                cur = cur.left;
            } else {
                cur = cur.right;
            }
        }
        if (cur == null) {
            return root;
        }
        if (cur.left == null && cur.right == null) {
            cur = null;
        } else if (cur.right == null) {
            cur = cur.left;
        } else if (cur.left == null) {
            cur = cur.right;
        } else {
            TreeNode successor = cur.right, successorParent = cur;
            while (successor.left != null) {
                successorParent = successor;
                successor = successor.left;
            }
            if (successorParent.val == cur.val) {
                successorParent.right = successor.right;
            } else {
                successorParent.left = successor.right;
            }
            successor.right = cur.right;
            successor.left = cur.left;
            cur = successor;
        }
        if (curParent == null) {
            return cur;
        } else {
            if (curParent.left != null && curParent.left.val == key) {
                curParent.left = cur;
            } else {
                curParent.right = cur;
            }
            return root;
        }
    }
//    TreeNode parent = null;
//    TreeNode current;
//    public TreeNode deleteNode(TreeNode root, int key) {
//        //1、找到
//        current = root;
//        findKey(root,key);
//        //2、调整
//        adjustTree(root,key);
//        return root;
//    }
//
//    private void adjustTree(TreeNode root,  int key) {
//
//    }
//
//    private void findKey(TreeNode root, int key) {
//        while (current != null){
//            if (current.val == key) {
//                break;
//            }
//            parent = root;
//            if (key > root.val && root.right != null){
//                current = root.right;
//            }
//            if (key < root.val && root.left != null){
//                current = root.left;
//            }
//        }
//    }
}
