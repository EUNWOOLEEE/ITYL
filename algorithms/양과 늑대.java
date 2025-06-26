class Solution {
    public boolean[] visited;
    
    public int solution(int[] info, int[][] edges) {
        visited = new boolean[info.length];
        visited[0] = true;
        
        return dfs(info, edges, 1, 0);
    }
    
    public int dfs(int[] info, int[][] edges, int sheep, int wolf) {
        if (sheep == wolf) return sheep;
        int max = sheep;
        
        for (int[] edge : edges) {
            if (visited[edge[0]] == true && visited[edge[1]] == false) {
                visited[edge[1]] = true;
                
                if (info[edge[1]] == 0)
                    max = Math.max(max, dfs(info, edges, sheep + 1, wolf));
                else
                    max = Math.max(max, dfs(info, edges, sheep, wolf + 1));
                
                visited[edge[1]] = false;
            }
        }
        return max;
    }
}
