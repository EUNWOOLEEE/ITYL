import java.util.*;

class Solution {
    public int solution(int width, int height, int[][] hole) {
        boolean[][] map = new boolean[height][width];
        int[][][] visited = new int[height][width][2];
        Queue<int[]> queue = new LinkedList<>();
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        
        for (int[] hole_info : hole)
            map[hole_info[1] - 1][hole_info[0] - 1] = true;
        queue.add(new int[]{0, 0, 0});
        visited[0][0][0] = 0;

        while (queue.isEmpty() == false) {
            int[] cur = queue.poll();
            
            if (cur[0] == height - 1 && cur[1] == width - 1)
                return visited[cur[0]][cur[1]][cur[2]];
            
            for (int[] dir : dirs) {
                int[] next = {cur[0] + dir[0], cur[1] + dir[1], cur[2]};
                
                if (isValidPos(next, visited, map, height, width) == true) {
                    queue.add(next);
                    visited[next[0]][next[1]][next[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
                }
                if (cur[2] == 0) {
                    next = new int[]{cur[0] + (dir[0] * 2), cur[1] + (dir[1] * 2), 1};
                    
                    if (isValidPos(next, visited, map, height, width) == true) {
                        queue.add(next);
                        visited[next[0]][next[1]][next[2]] = visited[cur[0]][cur[1]][cur[2]] + 1;
                    }
                }
            }
        }
        return -1;
    }

    public boolean isValidPos(int[] pos, int[][][] visited, boolean[][] map, int height, int width) {
        return (0 <= pos[0] && pos[0] < height
                && 0 <= pos[1] && pos[1] < width
                && visited[pos[0]][pos[1]][pos[2]] == 0
                && map[pos[0]][pos[1]] == false);
    }
}
