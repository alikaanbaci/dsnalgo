package group_the_people;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Solution of group-the-people-given-the-group-size-they-belong-to
 */
class Solution {

    public List<List<Integer>> groupThePeople(int[] groupSizes) {

        Map<Integer, List<Integer>> grouped = new HashMap<>();
        List<List<Integer>> result = new ArrayList<>();

        for(int i = 0; i < groupSizes.length; i++){

            List<Integer> group = grouped.get(groupSizes[i]);

            if(group == null) {
                group = new ArrayList<Integer>();
                grouped.put(groupSizes[i], group);
            }

            group.add(i);

            if(group.size() == groupSizes[i]){
                result.add(group);
                grouped.remove(groupSizes[i]);
            }

        }

        return result;
    }

}
