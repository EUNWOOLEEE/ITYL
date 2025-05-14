import java.util.*;

class Solution {
    public int solution(int[][] city) {
        int height = city.length;
        int width = city[0].length;

        if (city[0][0] == 1 || city[height - 1][width - 1] == 1)
            return -1;
        
        int[][] dir = {{1, 1}, {1, -1}, {-1, 1}, {-1, -1},
                       {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int[][] visited = new int[height][width];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0});
        visited[0][0] = 1;

        while (queue.isEmpty() == false) {
            int[] cur = queue.poll();

            if (cur[0] == height - 1 && cur[1] == width - 1)
                return visited[cur[0]][cur[1]];
            
            for (int i = 0; i < 8; i++) {
                int[] next = {cur[0] + dir[i][0], cur[1] + dir[i][1]};

                if (0 <= next[0] && next[0] < height
                    && 0 <= next[1] && next[1] < width
                    && visited[next[0]][next[1]] == 0
                    && city[next[0]][next[1]] == 0) {
                    
                    visited[next[0]][next[1]] = visited[cur[0]][cur[1]] + 1;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
