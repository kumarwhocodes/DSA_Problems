package P270425;

import P200425.TreeNode;

public class BST1 {
    
    public static boolean searchInBst(TreeNode root, int key) {
        while (root != null) {
            if (root.data == key) {
                return true;
            } else if (key > root.data) {
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return false;
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(5);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(7);
        root.left.right.left = new TreeNode(6);
        root.right = new TreeNode(12);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(14);
        root.right.right.left = new TreeNode(13);
        System.out.println(searchInBst(root, 12));
    }
    
}
