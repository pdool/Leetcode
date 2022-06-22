package com.xin.tree.easy;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Sln257 {

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if (root != null){
            backtrack(root,result,new StringBuilder());
        }
        return result;
    }

    private void backtrack(TreeNode root, List<String> result, StringBuilder sb) {
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            append(sb, root.val);
            result.add(sb.toString());
            return;
        }
        append(sb, root.val);
        int prevIndex = sb.length();
        backtrack(root.left,result,sb);
        sb.delete(prevIndex,sb.length());
        backtrack(root.right,result,sb);
    }

    public void append(StringBuilder sb,int val){
        if (sb.length() != 0){
            sb.append("->");
        }
        sb.append(val);
    }


    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, null, new TreeNode(5)), new TreeNode(3));
        List<String> strings = new Sln257().binaryTreePaths(treeNode);
        System.out.println();
    }
}
