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
    
    public static Integer findMinInBst(TreeNode root) {
        if (root == null) {
            return -1;
        }
        while (root.left != null) {
            root = root.left;
        }
        return root.data;
    }
    
    public static Integer findMaxInBst(TreeNode root) {
        if (root == null) {
            return -1;
        }
        while (root.right != null) {
            root = root.right;
        }
        return root.data;
    }
    
    /**
     * A generic function to find min/max of a Binary Search Tree.
     *
     * @param findMin set true to find minimum and set false for maximum
     */
    public static Integer findMinMaxInBst(TreeNode root, boolean findMin) {
        if (root == null) {
            return -1;
        }
        if (findMin) {
            while (root.left != null) {
                root = root.left;
            }
        } else {
            while (root.right != null) {
                root = root.right;
            }
        }
        return root.data;
    }
    
    /**
     * Ceil is the value in the BST which is just greater than the given value/key, and it should be the lowest one in the tree.
     */
    public static Integer findCeilInBst(TreeNode root, int key) {
        int ceil = -1;
        while (root != null) {
            if (root.data == key) {
                return root.data; // exact match is also the ceil
            } else if (root.data > key) {
                ceil = root.data;
                root = root.left;
            } else {
                root = root.right;
            }
        }
        return ceil;
    }
    
    /**
     * Floor: key se chota element jo sabse bara ho
     */
    public static Integer findFloorInBst(TreeNode root, int key) {
        int floor = -1;
        while (root != null) {
            if (root.data == key) {
                return root.data; // exact match is also the floor
            }
            if (root.data < key) {
                floor = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return floor;
    }
    
    /**
     * Insertion in a Binary Search Tree
     * @return T = O(N) -> Worst case: skewed tree && T = O(log N) -> Best case
     */
    public static TreeNode insertInBst(TreeNode root, int val) {
        if (root == null) return new TreeNode(val);
        TreeNode curr = root;
        while (true) {
            if (curr.data <= val) {
                if (curr.right != null) curr = curr.right;
                else {
                    curr.right = new TreeNode(val);
                    break;
                }
            } else {
                if (curr.left != null) curr = curr.left;
                else {
                    curr.left = new TreeNode(val);
                }
            }
        }
        return root;
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
        
        System.out.println("Minimum: " + findMinMaxInBst(root, true));   // findMin = true
        System.out.println("Maximum: " + findMinMaxInBst(root, false));  // findMin = false
        
        System.out.println("Floor of 9: " + findFloorInBst(root, 9));
        System.out.println("Ceil of 9: " + findCeilInBst(root, 9));
        
        System.out.println("Inserted: " + insertInBst(root, 9).data);
        System.out.println("Found: " + searchInBst(root, 9));
        
    }
    
}
