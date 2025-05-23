import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int height = maps.length;
        int width = maps[0].length;
        int[][] dist = new int[height][width];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        dist[0][0] = 1;
        
        while (queue.isEmpty() == false) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int[] next = {cur[0] + dirs[i][0], cur[1] + dirs[i][1]};
                
                if (0 <= next[0] && next[0] < height
                    && 0 <= next[1] && next[1] < width
                    && dist[next[0]][next[1]] == 0
                    && maps [next[0]][next[1]] == 1) {
                    dist[next[0]][next[1]] = dist[cur[0]][cur[1]] + 1;
                    queue.add(next);
                }
            }
        }
        return dist[height - 1][width - 1] == 0 ? -1 : dist[height - 1][width - 1];
    }
}
