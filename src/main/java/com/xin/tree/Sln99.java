package com.xin.tree;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Sln99 {
    //  二叉搜索树 -> 中序遍历有序
    public void recoverTree(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root,list);
        int[] swapped = findTwoSwapped(list);
        recover(root,2,swapped[0],swapped[1]);

    }
    public void inOrder(TreeNode root, List<Integer> list){
        //  这地方没写好
        if (root == null) {
            return;
        }
        inOrder(root.left,list);
        list.add(root.val);
        inOrder(root.right,list);
    }

    public int[] findTwoSwapped(List<Integer> nums) {
        //  [1,6,3,4,5,2,7]
        int n = nums.size();
        int index1 = -1, index2 = -1;
        for (int i = 0; i < n - 1; ++i) {
            if (nums.get(i + 1) < nums.get(i)) {
                //  保存最后一次
                index2 = i + 1;
                //  只保存一次
                if (index1 == -1) {
                    index1 = i;
                } else {
                    break;
                }
            }
        }
        int x = nums.get(index1), y = nums.get(index2);
        return new int[]{x, y};
    }

    public void recover(TreeNode root, int count, int x, int y) {
        if (root != null) {
            if (root.val == x || root.val == y) {
                root.val = root.val == x ? y : x;
                if (--count == 0) {
                    return;
                }
            }
            recover(root.right, count, x, y);
            recover(root.left, count, x, y);
        }
    }
    public static void main(String[] args) {
//        TreeNode p = new TreeNode(1,new TreeNode(3,null,new TreeNode(2)),null);
        List<Integer> integers = Arrays.asList(1, 6, 3, 4, 5, 2, 7);
        new Sln99().findTwoSwapped(integers);
    }
}
