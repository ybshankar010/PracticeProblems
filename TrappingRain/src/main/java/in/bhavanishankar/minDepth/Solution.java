package in.bhavanishankar.minDepth;


import java.util.Queue;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val,  TreeNode left,  TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        int leftMinDepth = minDepth(root.left)+1;
        int rightMinDepth = minDepth(root.right)+1;

        int depth = Math.min(leftMinDepth,rightMinDepth);
        if (root.right == null) {
            depth = leftMinDepth;
        } else if (root.left == null) {
            depth = rightMinDepth;
        }

        return depth;
    }
}
