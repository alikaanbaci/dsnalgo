package sum_of_nodes_with_even_valued_grandparents;

import tree_node.TreeNode;

class Solution {

    private int sum = 0;

    public int sumEvenGrandparent(TreeNode root) {

        traverse(root);
        return sum;
    }



    public void traverse(TreeNode root) {

        if(root!=null){
            if(root.val % 2 == 0){
                traverse(root, 2);
            }

            traverse(root.left);
            traverse(root.right);
        }
    }



    public void traverse(TreeNode root, int deep){

        if(root!=null){
            if(deep==0) {
                sum+=root.val;
                return;
            }

            traverse(root.left, deep-1);
            traverse(root.right, deep-1);
        }
    }
}