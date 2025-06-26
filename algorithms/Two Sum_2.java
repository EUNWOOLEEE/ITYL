import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Queue<Integer>> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) == false)
                map.put(nums[i], new LinkedList<>());
            map.get(nums[i]).add(i);
        }

        for (int i = 0; i < nums.length; i++) {
            map.get(nums[i]).poll();

            if (map.containsKey(target - nums[i]) == false
                || map.get(target - nums[i]).isEmpty() == true)
                continue;

            if (map.get(target - nums[i]).isEmpty() == false)
                return new int[]{i, map.get(target - nums[i]).poll()};
        }
        return null;
    }
}

-------------------------------

import java.util.HashMap;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            int num = target - nums[i];
            if (map.containsKey(num) == true)
                return new int[]{map.get(num), i};
            map.put(nums[i], i);
        }
        return null;
    }
}
