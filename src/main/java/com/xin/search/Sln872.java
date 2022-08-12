package com.xin.search;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.cn/problems/leaf-similar-trees/
public class Sln872 {
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> list1 = new ArrayList<>();
        List<Integer> list2 = new ArrayList<>();
        dfs(root1,list1);
        dfs(root2,list2);
        return list1.equals(list2);
    }
    public void dfs(TreeNode root, List<Integer> list){
        if (root == null){
            return;
        }
        if (root.left == null && root.right == null){
            list.add(root.val);
            return;
        }
        dfs(root.left,list);
        dfs(root.right,list);
    }

}
