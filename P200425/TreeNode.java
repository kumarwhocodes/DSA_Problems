package P200425;

public class TreeNode {
    public int data;
    public TreeNode left;
    public TreeNode right;
    
    public TreeNode(int val) {
        data = val;
        left = null;
        right = null;
    }
    
    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.data = val;
        this.left = left;
        this.right = right;
    }
}
