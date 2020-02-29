package maximum_depthof_n_ary_tree;

import java.util.List;

public class Solution {
    public int recurr(Node root, int depth) {
        int tmp, max = 0;

        if(root == null)
            return depth;

        if(root.children.isEmpty())
            return depth+1;


        for(Node node : root.children) {
            tmp = recurr(node, depth+1);
            if(tmp > max){
                max = tmp;
            }
        }

        return max;
    }

    public int maxDepth(Node root) {
        return recurr(root, 0);
    }
}
