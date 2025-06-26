import java.util.ArrayList;

class Solution {
    public ArrayList<ArrayList<Integer>> tree;
    public boolean[] visited;
    
    public int solution(int n, int[][] wires) {
        tree = new ArrayList<>();
        for (int i = 0; i <= n; i++)
            tree.add(new ArrayList<>());
        
        for (int[] wire : wires) {
            tree.get(wire[0]).add(wire[1]);
            tree.get(wire[1]).add(wire[0]);
        }
        
        int minDiff = Integer.MAX_VALUE;
        for (int[] wire : wires) {
            visited = new boolean[n + 1];
            int diff = Math.abs(dfs(wire[0], wire[1]) - dfs(wire[1], wire[0]));
            minDiff = diff < minDiff ? diff : minDiff;
        }
        
        return minDiff;
    }
    
    public int dfs(int curNode, int exceptNode) {
        ArrayList<Integer> arr = tree.get(curNode);
        if (arr.size() == 1 && arr.get(0) == exceptNode)
            return 1;
        
        int cnt = 0;
        for (int next : tree.get(curNode)) {
            if (next == exceptNode)
                continue;
            if (visited[next] == false) {
                visited[next] = true;
                cnt += dfs(next, exceptNode) + 1;
            }
        }
        return cnt;
    }
}
