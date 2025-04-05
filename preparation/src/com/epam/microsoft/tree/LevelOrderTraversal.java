package com.epam.microsoft.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    public List<List<Integer>> traverse(TreeNode root){
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> level = new ArrayList<>();
        if(root == null){
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(null);

        while (!queue.isEmpty()){
            TreeNode currentNode = queue.poll();
            if(currentNode == null && queue.isEmpty()){
                result.add(new ArrayList<>(level));
                break;
            }else if(currentNode == null){
                result.add(new ArrayList<>(level));
                level.clear();
                queue.offer(null);
            }else {
                level.add(currentNode.val);
                if(currentNode.left != null){
                    queue.offer(currentNode.left);
                }
                if(currentNode.right != null){
                    queue.offer(currentNode.right);
                }
            }
        }
        return result;
    }
}
