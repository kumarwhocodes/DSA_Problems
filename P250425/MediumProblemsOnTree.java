package P250425;

import P200425.TreeNode;

public class MediumProblemsOnTree {
    
    /**
     * Max Diameter - the longest path between any two nodes |
     * T = O(N) & S = O(H) ; where N = number of nodes & H = height of the tree
     */
    static int maxDiameter = 0;
    public static int findDiameterOfTree(TreeNode root) {
        computeHeight(root);
        return maxDiameter;
    }
    private static int computeHeight(TreeNode node) {
        if (node == null) return 0;
        
        int lh = computeHeight(node.left);
        int rh = computeHeight(node.right);
        
        maxDiameter = Math.max(maxDiameter, lh + rh);
        
        return 1 + Math.max(lh, rh);
    }
    
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(6);
        root.right.left.left = new TreeNode(5);
        root.right.right.right = new TreeNode(7);
        root.right.left.left.left = new TreeNode(9);
        root.right.right.right.right = new TreeNode(8);
        
        System.out.println(findDiameterOfTree(root));
    }
    
}
