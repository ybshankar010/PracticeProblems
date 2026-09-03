package in.bhavanishankar.pathSum;

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

    private boolean hasPathHelper(TreeNode root,int targetSum) {
        if (root == null) return targetSum == 0;
        targetSum = targetSum-root.val;
        boolean sumFound = false;
        if (targetSum == 0) {
            sumFound = (root.left == null) && (root.right==null);
        }
        if (sumFound) {
            return true;
        }

        if (root.left != null) {
            sumFound = hasPathHelper(root.left,targetSum);
        }

        if (!sumFound && root.right != null) {
            sumFound = hasPathHelper(root.right,targetSum);
        }

        System.out.println(root.val + " :: "+targetSum + " :: "+sumFound);
        return sumFound;
    }
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        return hasPathHelper(root,targetSum);
    }
}
