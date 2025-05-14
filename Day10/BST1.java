package Day10;

import Day16.TreeNode;
import Day16.TreeTraversal;

import java.util.List;

public class BST1 {
    
    /**
     * Delete a node in Binary Search Tree
     */
    public static TreeNode deleteNodeInBst(TreeNode root, int key) {
        if (root == null) return null;
        
        if (root.data > key) {
            root.left = deleteNodeInBst(root.left, key);
        } else if (root.data < key) {
            root.right = deleteNodeInBst(root.right, key);
        } else {
            if (root.left == null)
                return root.right;
            if (root.right == null)
                return root.left;
            
            TreeNode succ = getSuccessor(root);
            root.data = succ.data;
            root.right = deleteNodeInBst(root.right, succ.data);
        }
        return root;
    }
    
    static TreeNode getSuccessor(TreeNode curr) {
        curr = curr.right;
        while (curr != null && curr.left != null) {
            curr = curr.left;
        }
        return curr;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);
        root.right.left = new TreeNode(12);
        root.right.right = new TreeNode(18);
        
        int x = 15;
        root = deleteNodeInBst(root, x);
        List<Integer> result = TreeTraversal.traverse(root, TreeTraversal::preorder);
        System.out.print("Traversal Result: ");
        for (int val : result) {
            System.out.print(val + " ");
        }
    }
    
}
