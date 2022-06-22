package com.xin.tree.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

public class Sln107 {
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        List<TreeNode> layerNode = new ArrayList<>();
        List<Integer> layerValue = new ArrayList<>();

        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            //  本层的值
            layerValue.add(poll.val) ;

            //  保存下层节点
            if (poll.left != null){
               layerNode.add(poll.left) ;
            }
            if (poll.right != null){
                layerNode.add(poll.right) ;
            }
            //  本层遍历结束
            if (queue.isEmpty()){
                //  保存当前层的值
                result.add(new ArrayList<>(layerValue));
                queue.addAll(layerNode);
                //  清空临时表
                layerNode.clear();
                layerValue.clear();
            }

        }
        Collections.reverse(result);
        return result;
    }
    //  最后的翻转似乎没有必要，可以每次放在队列的第一位
}
