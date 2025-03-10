package com.epam.google.top30.tree;

//height balanced
public class BalancedBinaryTree {
    public boolean isBalanced(TreeNode root){
        return getMaxHeightDiff(root) == 0 ? false : true;
    }
    private int getMaxHeightDiff(TreeNode root){
        if(root == null){
            return 1;
        }
        int leftHeight = getMaxHeightDiff(root.left);
        int rightHeight = getMaxHeightDiff(root.right);
        // negative case
        if(leftHeight == 0 || rightHeight == 0 || Math.abs(leftHeight-rightHeight) >1){
            return 0;
        }
        return Math.max(leftHeight,rightHeight)+1; //positive case
    }
}
