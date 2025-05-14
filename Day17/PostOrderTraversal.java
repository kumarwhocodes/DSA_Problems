package Day17;

import Day16.TreeNode;

import java.util.*;

public class PostOrderTraversal {
    
    /**
     * Post Order Traversal using 2 stack
     * T = O(N)
     * S = O(2N)
     */
    public static List<Integer> postOrderTraversalUsing2stack(TreeNode root) {
        Stack<TreeNode> s1 = new Stack<>();
        Stack<TreeNode> s2 = new Stack<>();
        List<Integer> traversal = new ArrayList<>();
        
        if (root == null) return Collections.emptyList();
        
        s1.push(root);
        while (!s1.isEmpty()) {
            root = s1.pop();
            s2.push(root);
            if (root.left != null) s1.push(root.left);
            if (root.right != null) s1.push(root.right);
        }
        while (!s2.isEmpty()) {
            traversal.add(s2.pop().data);
        }
        return traversal;
    }
    
    /**
     * Post Order Traversal Using 1 Stack
     * T = O(2N)
     * S = O(N)
     */
    public static List<Integer> postOrderTraversalUsing1stack(TreeNode root) {
        Stack<TreeNode> st = new Stack<>();
        List<Integer> traversal = new ArrayList<>();
        TreeNode curr = root;
        
        if (root == null) return Collections.emptyList();
        
        while (curr != null || !st.isEmpty()) {
            if (curr != null) {
                st.push(curr);
                curr = curr.left;
            } else {
                TreeNode temp = st.peek().right;
                if (temp == null) {
                    do {
                        temp = st.pop();
                        traversal.add(temp.data);
                    } while (!st.isEmpty() && temp == st.peek().right);
                } else {
                    curr = temp;
                }
            }
        }
        return traversal;
    }
    
    /**
     * Height or Depth of a tree using Recursion
     * T = O(N)
     * S = O(h) ; h = height
     */
    public static Integer heightOfTree(TreeNode root) {
        if (root == null) return 0;
        
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        
        return 1 + Math.max(lh, rh);
    }
    
    /**
     * Height or Depth of a tree using level order traversal
     * T = O(N)
     * S = O(w) ; w = max width of the tree = max number of nodes at any level
     */
    public static int heightOfTreeUsingLevelOrderTraversal(TreeNode root) {
        if (root == null) return 0;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int height = 0;
        
        while (!queue.isEmpty()) {
            int levelSize = queue.size(); // number of nodes at current level
            
            //adding the child nodes of each level to the queue to scan each and every node
            for (int i = 0; i < levelSize; i++) {
                TreeNode current = queue.poll();
                if (current.left != null) queue.offer(current.left);
                if (current.right != null) queue.offer(current.right);
            }
            
            height++;
        }
        
        return height;
    }
    
    /**
     * Find whether tree is balanced or not
     * <p>
     * Balanced Tree: A binary tree where the height difference between the left and right subtrees of every node is at most 1.
     *
     * @return -1 if tree is not balanced and height if tree is balanced
     */
    public static Integer isBalancedTree(TreeNode root) {
        if (root == null) return 0;
        
        int lh = heightOfTree(root.left);
        int rh = heightOfTree(root.right);
        
        if (Math.abs(lh - rh) > 1) return -1;
        if (lh == -1 || rh == -1) return -1;
        
        return 1 + Math.max(lh, rh);
    }
    
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(6);
        
        System.out.println(postOrderTraversalUsing1stack(root));
        System.out.println("Height of the tree is: " + isBalancedTree(root));
    }
}
