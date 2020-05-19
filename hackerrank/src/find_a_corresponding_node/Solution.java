package find_a_corresponding_node;

import tree_node.TreeNode;

class Solution {

    private TreeNode c;

    public final TreeNode getTargetCopy(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        traverse(original, cloned, target);

        return c;
    }



    private void traverse(final TreeNode original, final TreeNode cloned, final TreeNode target) {

        if(original != null){
            if(original == target){
                c = cloned;
                return;
            }

            getTargetCopy(original.left, cloned.left, target);

            getTargetCopy(original.right, cloned.right, target);

        }
        return;
    }

}
