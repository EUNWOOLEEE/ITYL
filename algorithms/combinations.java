import java.util.*;

class Solution {
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> combine(int n, int k) {
        recursion(n, k, 0, new ArrayList<>());
        return result;
    }

    public void recursion(int n, int k, int cur, ArrayList<Integer> list) {
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }

        for (int i = cur + 1; i <= n; i++) {
            list.add(i);
            recursion(n, k, i, list);
            list.remove(list.size() - 1);
        }
    }
}
