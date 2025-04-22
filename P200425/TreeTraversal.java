package P200425;

import java.util.*;
import java.util.function.BiConsumer;

public class TreeTraversal {
    
    static void preorder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        arr.add(root.data);
        preorder(root.left, arr);
        preorder(root.right, arr);
    }
    
    static void inOrder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        inOrder(root.left, arr);
        arr.add(root.data);
        inOrder(root.right, arr);
    }
    
    static void postorder(TreeNode root, List<Integer> arr) {
        if (root == null) return;
        postorder(root.left, arr);
        postorder(root.right, arr);
        arr.add(root.data);
    }
    
    static List<Integer> traverse(TreeNode root, BiConsumer<TreeNode, List<Integer>> traversalFunction) {
        List<Integer> arr = new ArrayList<>();
        traversalFunction.accept(root, arr);
        return arr;
    }
    
    public static void levelOrder(TreeNode root) {
        if (root == null) return;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);  //adding to queue
        
        while (!queue.isEmpty()) {
            TreeNode curr = queue.poll();   //returns the head of the queue
            System.out.print(curr.data + " ");
            
            if (curr.left != null)
                queue.offer(curr.left);
            if (curr.right != null)
                queue.offer(curr.right);
        }
    }
    
    static List<Integer> iterativePreorder(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        if (root == null) return traversal;
        
        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        
        while (!stack.isEmpty()) {
            root = stack.pop();
            traversal.add(root.data);
            
            if (root.right != null) {
                stack.push(root.right);
            }
            if (root.left != null) {
                stack.push(root.left);
            }
        }
        return traversal;
    }
    
    static List<Integer> iterativeInorder(TreeNode root) {
        List<Integer> inOrderTraversal = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        
        TreeNode current = root;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }
            current = stack.pop();
            inOrderTraversal.add(current.data);
            
            current = current.right;
        }
        return inOrderTraversal;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        
        // You can pass any traversal function here: preorder, inOrder, postorder
//        List<Integer> result = traverse(root, TreeTraversal::preorder);
//
//        System.out.print("Traversal Result: ");
//        for (int val : result) {
//            System.out.print(val + " ");
//        }

//        levelOrder(root);
        
        System.out.println(iterativeInorder(root));
        System.out.println();
    }
}
