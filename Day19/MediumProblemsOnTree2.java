package Day19;

import Day16.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MediumProblemsOnTree2 {
    
    /**
     * Function to check for identical trees | T = O(N) | S = O(N)
     *
     * @param root1 root node of first tree
     * @param root2 root node of second tree
     * @return recursively returning like preorder traversal
     */
    public static boolean checkForIdenticalTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null || root2 == null) {
            return root1 == root2;
        }
        return (root1.data == root2.data) &&
                checkForIdenticalTrees(root1.left, root2.left) &&
                checkForIdenticalTrees(root1.right, root2.right);
    }
    
    /**
     * Zig Zag Traversal / Spiral Traversal of a Binary Tree | T = O(N) | S = O(N)
     */
    public static List<Integer> zigZagTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        
        Queue<TreeNode> nodesQueue = new LinkedList<>();
        nodesQueue.add(root);
        boolean leftToRight = true;
        
        while (!nodesQueue.isEmpty()) {
            int size = nodesQueue.size();
            int[] row = new int[size];
            
            for (int i = 0; i < size; i++) {
                TreeNode node = nodesQueue.poll();
                
                int index = (leftToRight) ? i : size - i - 1;
                row[index] = node.data;
                if (node.left != null) {
                    nodesQueue.offer(node.left);
                }
                if (node.right != null) {
                    nodesQueue.offer(node.right);
                }
            }
            for (int num : row) {
                result.add(num);
            }
            leftToRight = !leftToRight;
        }
        return result;
    }
    
    public static void main(String[] args) {
//        TreeNode root1 = new TreeNode(1);
//        root1.left = new TreeNode(2);
//        root1.right = new TreeNode(3);
//        root1.right.left = new TreeNode(4);
//        root1.right.right = new TreeNode(6);
//        root1.right.left.left = new TreeNode(5);
//        root1.right.right.right = new TreeNode(7);
//        root1.right.left.left.left = new TreeNode(9);
//        root1.right.right.right.right = new TreeNode(8);
//
//        TreeNode root2 = new TreeNode(1);
//        root2.left = new TreeNode(2);
//        root2.right = new TreeNode(3);
//        root2.right.left = new TreeNode(4);
//        root2.right.right = new TreeNode(6);
//        root2.right.left.left = new TreeNode(5);
//        root2.right.right.right = new TreeNode(7);
//        root2.right.left.left.left = new TreeNode(9);
//        root2.right.right.right.right = new TreeNode(8);
//
//        System.out.println(checkForIdenticalTrees(root1, root2));
        
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.right = new TreeNode(6);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        
        System.out.println(zigZagTraversal(root));
    }
    
}
