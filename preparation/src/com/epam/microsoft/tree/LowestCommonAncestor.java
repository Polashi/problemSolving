package com.epam.microsoft.tree;

public class LowestCommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode a, TreeNode b){
        if(root == null || a == null || b== null){
            return root;
        }
        TreeNode lca_left = lowestCommonAncestor(root.left, a,b);
        TreeNode lca_right = lowestCommonAncestor(root.right, a, b);
        if(lca_right == null){
            return lca_right;
        }
        if(lca_right == null){
            return lca_left;
        }
        return root;
    }
}
