//package com.epam.salesforce;
//
//public class BSTValid {
//
//}
//
//import java.io.*;
//        import java.math.*;
//        import java.security.*;
//        import java.text.*;
//        import java.util.*;
//        import java.util.concurrent.*;
//        import java.util.function.*;
//        import java.util.regex.*;
//        import java.util.stream.*;
//
//        import org.omg.CORBA.PUBLIC_MEMBER;
//
//import static java.util.stream.Collectors.joining;
//import static java.util.stream.Collectors.maxBy;
//import static java.util.stream.Collectors.reducing;
//import static java.util.stream.Collectors.toList;
//
//
//class TreeNode{
//    int value;
//    TreeNode left;
//    TreeNode right;
//
//    TreeNode(int value){
//        this.value = value;
//    }
//}
//
//class Result {
//    static class Index{
//        int index = 0;
//    }
//
//    /*
//     * Complete the 'isValid' function below.
//     *
//     * The function is expected to return a STRING.
//     * The function accepts INTEGER_ARRAY a as parameter.
//     */
//
//    public static String isValid(List<Integer> a) {
//        TreeNode root = buildTreeNode(a);
//        if(isValidBST(root, null, null)){
//            return "YES";
//        }
//        return "NO";
//
//    }
//
//    public TreeNode createNode(TreeNode root, TreeNode val){
//        if (root==null){
//            root = val;
//            return root;
//        }
//        if (root.left == null){
//            root.left = val;
//            return root;
//        } else if (root.right == null) {
//            root.right = val;
//            return root;
//        }else {
//            createNode(root.left, val);
//        }
//
//    }
//
//    public static TreeNode buildTreeNode(List<Integer> list){
//        return buildTree(list, new Index(), Integer.MIN_VALUE, Integer.MAX_VALUE);
//    }
//
//    public static TreeNode buildTree(List<Integer> list, Index index, int min, int max){
//        if(index.index >= list.size()){
//            return null;
//        }
//
//        int val = list.get(index.index);
//        if(val < min || val > max){
//            return null;
//        }
//        TreeNode node = new TreeNode(val);
//        index.index++;
//        node.left = buildTree(list, index, min, val);
//        node.right = buildTree(list, index, val, max);
//
//        return node;
//    }
//
//    private static boolean isValidBST(TreeNode root, Integer min, Integer max){
//        if(root == null){
//            return true;
//        }
//        if(min != null && root.value <= min || max!= null && root.value >= max){
//            return false;
//        }
//        return isValidBST(root.left, min, root.value) && isValidBST(root.right, root.value, max);
//    }
//
//}
//
//public class Solution {
//    public static void main(String[] args) throws IOException {
//        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int q = Integer.parseInt(bufferedReader.readLine().trim());
//
//        IntStream.range(0, q).forEach(qItr -> {
//            try {
//                int aCount = Integer.parseInt(bufferedReader.readLine().trim());
//
//                List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
//                        .map(Integer::parseInt)
//                        .collect(toList());
//
//                String result = Result.isValid(a);
//
//                bufferedWriter.write(result);
//                bufferedWriter.newLine();
//            } catch (IOException ex) {
//                throw new RuntimeException(ex);
//            }
//        });
//
//        bufferedReader.close();
//        bufferedWriter.close();
//    }
//}
//
