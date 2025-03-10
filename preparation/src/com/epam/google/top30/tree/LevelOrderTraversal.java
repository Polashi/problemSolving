package com.epam.google.top30.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();

        if(root==null){
            return result;
        }
        queue.add(root);
        queue.add(null);

        while(!queue.isEmpty()){
            TreeNode node = queue.poll();
            if(node == null && queue.isEmpty()){
                result.add(new ArrayList<>(level));
                break;
            }
            if(node == null){
                result.add(new ArrayList<>(level));
                level.clear();
                queue.add(null);
            }else{
                level.add(node.data);
                if(node.left != null){
                    queue.add(node.left);
                }
                if(node.right != null){
                    queue.add(node.right);
                }
            }
        }
        return result;
    }
}
