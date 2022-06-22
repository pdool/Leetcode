package com.xin.tree.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Sln199 {
    public List<Integer> rightSideView(TreeNode root) {

        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<TreeNode> layerNodeList = new ArrayList<>();
        while (!queue.isEmpty()){
            TreeNode poll = queue.poll();
            //  先将本层的数据加进去
            if (poll.left != null){
                layerNodeList.add(poll.left);
            }
            if (poll.right != null){
                layerNodeList.add(poll.right);
            }
            //  将最后一个节点加进去
            if (queue.isEmpty()){
                result.add(poll.val);
                queue.addAll(layerNodeList);
                layerNodeList.clear();
            }
        }

        return result;
    }
    //  如果有右子树 去右子树
    //  如果左子树深度更深，左子树
    //  后续遍历，深度
    //  层级遍历，只留最后一个
}
