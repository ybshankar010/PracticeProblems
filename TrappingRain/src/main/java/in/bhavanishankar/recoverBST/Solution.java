package in.bhavanishankar.recoverBST;

import com.sun.source.tree.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class Solution {

    private TreeNode prev, first,second;

    public Solution() {
        this.prev = this.first = this.second = null;
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        if (prev != null && prev.val > root.val) {
            if (first == null) {
                first = prev;
            }
            second = root;
        }
        this.prev = root;
        inOrderTraversal(root.right);
    }

    public void recoverTree(TreeNode root) {

        inOrderTraversal(root);

        if (this.first != null && this.second != null) {
            int val = this.first.val;
            this.first.val = this.second.val;
            this.second.val = val;
        }
    }
}
