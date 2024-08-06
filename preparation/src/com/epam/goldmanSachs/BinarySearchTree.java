package com.epam.goldmanSachs;

public class BinarySearchTree {
    static class Node{
        int data;
        Node left;
        Node right;
        Node(int data){
            this.data = data;
            left = right = null;
        }
    }
    Node root;
    public BinarySearchTree(){
        root = null;
    }

    public void deleteNode(Node root, int key){
        root = deleteRecursion(root, key);
    }

    private Node deleteRecursion(Node root, int key){
        if(root == null){
            return root;
        }
        if(key < root.data){
            root.left = deleteRecursion(root.left, key);
        }else if(key > root.data){
            root.right = deleteRecursion(root.right, key);
        }else{
            if(root.left == null){
                return root.right;
            }else if(root.right ==null){
                return root.left;
            }else{
                root.data = getMinValue(root.right);
                root.right = deleteRecursion(root.right, root.data);
            }
        }
        return root;
    }

    private int getMinValue(Node root){
        int min = root.data;
        while(root.left != null){
            min = root.left.data;
            root = root.left;
        }
        return min;
    }

    public void insert(int key) {
        root = insertRecursion(root, key);
    }
    private Node insertRecursion(Node root, int key){
        Node node = new Node(key);
        if(root == null){
            return node;
        }
        if(key < root.data){
            root.left = insertRecursion(root.left, key);
        }else if(key> root.data){
            root.right = insertRecursion(root.right, key);
        }
        return root;
    }
}
