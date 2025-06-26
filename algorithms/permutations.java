import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        recursion(nums, 0, new ArrayList<>(), new boolean[21]);
        return result;    
    }

    public void recursion(int[] nums, int idx, ArrayList<Integer> list, boolean[] visited) {
        if (list.size() == nums.length) {
            result.add(list);
            return ;
        }

        for (int i = 0; i < nums.length; i++) {
            if (visited[nums[i] + 10] == true)
                continue;
                
            ArrayList<Integer> next = new ArrayList<>(list);
            next.add(nums[i]);

            visited[nums[i] + 10] = true;
            recursion(nums, i, next, visited);
            visited[nums[i] + 10] = false;
        }
    }
}
