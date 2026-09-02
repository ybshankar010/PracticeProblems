package in.bhavanishankar.recoverBST;

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

    private List<TreeNode> inOrderElements;

    public Solution() {
        this.inOrderElements = new ArrayList<>();
    }

    private void inOrderTraversal(TreeNode root) {
        if (root == null) return;
        inOrderTraversal(root.left);
        this.inOrderElements.add(root);
        inOrderTraversal(root.right);
    }

    public void recoverTree(TreeNode root) {

        inOrderTraversal(root);

        TreeNode curr,next;
        TreeNode firstElement = null, secondElement = null;
        for (int i =0;i<this.inOrderElements.size()-1;++i) {
            curr = this.inOrderElements.get(i);
            next = this.inOrderElements.get(i+1);
            if (curr.val > next.val) {
                if (firstElement == null) {
                    firstElement = curr;
                    secondElement = next;
                } else {
                    secondElement = next;
                    break;
                }
            }
        }

        if (firstElement != null && secondElement != null) {
            int val = firstElement.val;
            firstElement.val = secondElement.val;
            secondElement.val = val;
        }
    }
}
