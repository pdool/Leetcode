package com.xin.tree.medium;

import common.TreeNode;

import javax.xml.stream.events.NotationDeclaration;
import java.util.ArrayList;
import java.util.List;

public class Sln129 {
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        calc(root, 0);
        return sum;
    }

    public void calc(TreeNode node, int prev) {
        if (node.left == null && node.right == null) {
            sum += prev * 10 + node.val;
            return;
        }
        prev = prev * 10 + node.val;
        if (node.left != null) {
            calc(node.left, prev);
        }
        if (node.right != null) {
            calc(node.right, prev);
        }
    }

    public static void main(String[] args) {
//        TreeNode treeNode = new TreeNode(1, new TreeNode(2), new TreeNode(3));
        TreeNode treeNode = new TreeNode(4, new TreeNode(9,new TreeNode(5),new TreeNode(1)), new TreeNode(0));
        new Sln129().sumNumbers(treeNode);
    }
}
