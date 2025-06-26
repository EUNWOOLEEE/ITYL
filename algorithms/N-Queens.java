import java.util.*;

class Solution {
    List<List<String>> result = new ArrayList<>();

    public List<List<String>> solveNQueens(int n) {
        int[] board = new int[n];
        Arrays.fill(board, -1);

        recursion(n, 0, board);
        return result;        
    }

    public void recursion(int n, int row, int[] board) {
        if (row == n) {
            ArrayList<String> completedBoard = new ArrayList<>();
            
            for (int queen : board) {
                StringBuilder str = new StringBuilder(".".repeat(n));
                str.setCharAt(queen, 'Q');
                completedBoard.add(new String(str));
            }

            result.add(completedBoard);
            return;
        }

        for (int col = 0; col < n; col++) {
            board[row] = col;
            if (isValidPos(n, board, row, col) == true)
                recursion(n, row + 1, board);
            board[row] = -1;
        }
    }

    public boolean isValidPos(int n, int[] board, int row, int col) {
        for (int i = 0; i < row; i++)
            if (board[i] == col || Math.abs(i - row) == Math.abs(board[i] - col))
                return false;
        return true;
    }
}
