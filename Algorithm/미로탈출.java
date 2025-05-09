import java.util.*;

class Solution {
    public int height, width;
    public int[][] map;
    public int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int solution(String[] maps) {
        height = maps.length;
        width = maps[0].length();
        map = new int[height][width];
        
        int[] start = {}, lever = {}, exit = {};
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                char c = maps[i].charAt(j);
                
                if (c == 'S') start = new int[]{i, j, 0};
                else if (c == 'L') lever = new int[]{i, j, 0};
                else if (c == 'E') exit = new int[]{i, j, 0};
                
                map[i][j] = c == 'X' ? 0 : 1;
            }
        }
        
        int first = bfs(start, lever);
        if (first == -1) return -1;
        int second = bfs(lever, exit);
        if (second == -1) return -1;
        return first + second;
    }
    
    public int bfs(int[] start, int[] goal) {
        boolean[][] visited = new boolean[height][width];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(start);
        
        while (queue.isEmpty() == false) {
            int[] cur = queue.poll();
            
            for (int i = 0; i < 4; i++) {
                int[] next = {cur[0] + dir[i][0], cur[1] + dir[i][1], cur[2] + 1};
                
                if (next[0] == goal[0] && next[1] == goal[1])
                    return next[2];
                
                if (0 <= next[0] && next[0] < height && 0 <= next[1] && next[1] < width
                    && map[next[0]][next[1]] == 1 && visited[next[0]][next[1]] == false) {
                    visited[next[0]][next[1]] = true;
                    queue.offer(next);
                }
            }
        }
        return -1;
    }
}
