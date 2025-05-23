import java.util.*;

class Solution {
    public int solution(int width, int height, int[][] hole) {
        boolean[][] map = new boolean[height][width];
        boolean[][][] visited = new boolean[height][width][2];
        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        int answer = -1;
        
        for (int[] tmp : hole)
            map[tmp[1] - 1][tmp[0] - 1] = true;
        
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 0, 0});
        
        while (queue.isEmpty() == false) {
            int[] cur = queue.poll();
            
            if (cur[0] == height - 1 && cur[1] == width - 1) {
                answer = cur[3];
                break;
            }
            
            for (int i = 0; i < 4; i++) {
                int[] next = {cur[0] + dirs[i][0], cur[1] + dirs[i][1], cur[2], cur[3] + 1};
                
                if (isValidPos(visited, map, next, height, width) == true) {
                    visited[next[0]][next[1]][next[2]] = true;
                    queue.add(next);
                }
                
                if (next[2] == 0) {
                    next = new int[]{cur[0] + (dirs[i][0] * 2), cur[1] + (dirs[i][1] * 2), 1, cur[3] + 1};
                
                    if (isValidPos(visited, map, next, height, width) == true) {
                        visited[next[0]][next[1]][next[2]] = true;
                        queue.add(next);
                    }
                }
            }
        }
        return answer;
    }
    
    public boolean isValidPos(boolean[][][] visited, boolean[][] map, int[] pos, int height, int width) {
        return (0 <= pos[0] && pos[0] < height
                && 0 <= pos[1] && pos[1] < width
                && visited[pos[0]][pos[1]][pos[2]] == false
                && map[pos[0]][pos[1]] == false);
    }
}
