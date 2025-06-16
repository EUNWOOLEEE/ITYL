import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        for (int size = 0; size <= nums.length; size++)
            recursion(nums, -1, size, new ArrayList<>());
        return result;
    }

    public void recursion(int[] nums, int cur, int size, ArrayList<Integer> list) {
        if (list.size() == size) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = cur + 1; i < nums.length; i++) {
            list.add(nums[i]);
            recursion(nums, i, size, list);
            list.remove(list.size() - 1);
        }
    }
}
