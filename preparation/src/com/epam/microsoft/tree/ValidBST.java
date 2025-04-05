package com.epam.microsoft.tree;

public class ValidBST {
    public boolean isValidBST(TreeNode root) {

        int min = Integer.MIN_VALUE;
        int max = Integer.MAX_VALUE;
        return isValidBSTHelper(root, min, max) && isValidBST(root.left) && isValidBST(root.right);
    }

    private boolean isValidBSTHelper(TreeNode root, int min, int max) {
        if(root == null){
            return true;
        }
        if(root.val <= min || root.val >= max){
            return false;
        }
        return isValidBSTHelper(root.left, min, root.val) && isValidBSTHelper(root.right, root.val, max);
    }
}
