package com.xin.tree.medium;

import common.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Sln919 {
    //  层级遍历
    class CBTInserter {
        TreeNode root;
        public CBTInserter(TreeNode root) {
            this.root = root;
        }

        public int insert(int val) {
            TreeNode parent = findInsert(null);
            if (parent.left == null){
                parent.left = new TreeNode(val);
            }else {
                parent.right = new TreeNode(val);
            }
            return parent.val;
        }

        private TreeNode findInsert(TreeNode root) {
            if (root.left != null || root.right != null){
                return root;
            }
            if (root.left != null){
                return findInsert(root.left);
            }
            if (root.right != null){
                return findInsert(root.right);
            }
            //  TODO
            return null;

        }

        public TreeNode get_root() {
            return root;
        }
    }
}
