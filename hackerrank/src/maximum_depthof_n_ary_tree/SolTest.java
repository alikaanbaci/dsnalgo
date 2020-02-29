package maximum_depthof_n_ary_tree;

import org.junit.Assert;
import org.junit.Test;

public class SolTest {
    Solution solution = new Solution();

    @Test
    public void maxDepthOfNAryTree(){
        /**
         * Build tree of [1,null,3,2,4,null,5,6]
         */
        Node tree = new Node();
        Assert.assertEquals(3, solution.maxDepth(tree));
    }
}
