import java.util.*;

class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1)
            return -1;
        if (n == 1)
            return 1;

        int[][] dir = {{1, 1}, {-1, 1}, {1, -1}, {-1, -1}, {1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{0, 0, 1});

        while (queue.isEmpty() == false) {
            int[] cur = queue.poll();

            for (int i = 0; i < 8; i++) {
                int[] next = {cur[0] + dir[i][0], cur[1] + dir[i][1], cur[2] + 1};

                if (next[0] == n - 1 && next[1] == n - 1)
                    return next[2];

                if (0 <= next[0] && next[0] < n && 0 <= next[1] && next[1] < n && grid[next[0]][next[1]] == 0) {
                    grid[next[0]][next[1]] = 2;
                    queue.add(next);
                }
            }
        }
        return -1;
    }
}
