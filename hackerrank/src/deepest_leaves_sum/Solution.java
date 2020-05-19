package deepest_leaves_sum;

import tree_node.TreeNode;

class Solution {

    int sum = 0;

    int deepest = 0;

    public int deepestLeavesSum(TreeNode root) {

        traverse(root, 0);

        return sum;
    }



    private void traverse(TreeNode root, int h) {

        if(root == null){
            return;
        }

        if(h > deepest){
            sum = root.val;
        }

        else if(deepest == h){
            sum += root.val;
        }
        deepest = Math.max(deepest, h);

        traverse(root.left, h+1);
        traverse(root.right, h+1);
    }

}
