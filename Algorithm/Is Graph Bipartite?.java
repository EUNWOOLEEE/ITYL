class Solution {
    public boolean[] nums = new boolean[101];
    public boolean[] visited = new boolean[101];
    public boolean res = true;

    public boolean isBipartite(int[][] graph) {
        for (int i = 0; i < graph.length; i++) {
            if (graph[i].length == 0 || visited[i] == true)
                continue;
            nums[i] = true;
            visited[i] = true;
            dfs(graph, i, true);
        }
        return res;
    }

    public void dfs(int[][] graph, int cur, boolean group) {
        if (res == false)
            return;

        int[] links = graph[cur];

        for (int node : links) {
            if (visited[node] == false) {
                nums[node] = !group;
                visited[node] = true;
                dfs(graph, node, !group);
            }
            if (nums[node] == group)
                res = false;
        }
    }
}
