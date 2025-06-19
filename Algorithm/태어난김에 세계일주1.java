import java.util.*;

class Solution {
    public boolean[] visited;
    public int answer;

    public int solution(int balance, int[][] countries) {
        answer = 0;
        visited = new boolean[countries.length];
        dfs(balance, countries, 0);
        return answer;
    }

    public void dfs(int balance, int[][] countries, int cnt) {
        answer = Math.max(answer, cnt);

        for (int i = 0; i < countries.length; i++) {
            if (visited[i] == false && balance >= countries[i][1]) {
                visited[i] = true;
                dfs(balance - countries[i][0], countries, cnt + 1);
                visited[i] = false;
            }
        }
    }
}
