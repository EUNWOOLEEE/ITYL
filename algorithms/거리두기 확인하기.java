class Solution {
    public int[][] dir = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    
    public int[] solution(String[][] places) {
        int[] answer = new int[places.length];
        for (int i = 0; i < places.length; i++)
            answer[i] = checkPlace(places[i]);
        return answer;
    }
    
    public int checkPlace(String[] place) {
        boolean flag = false;
        
        for (int curR = 0; curR < 5; curR++) {
            for (int curC = 0; curC < 5; curC++) {
                char cur = place[curR].charAt(curC);

                if (cur == 'X') continue;
                
                for (int i = 0; i < 4; i++) {
                    int nextR = curR + dir[i][0];
                    int nextC = curC + dir[i][1];
                    
                    if (nextR < 0 || 5 <= nextR || nextC < 0 || 5 <= nextC)
                        continue;
                    
                    char next = place[nextR].charAt(nextC);
                    if (cur == 'P' && next == 'P') return 0;
                    if (cur == 'O' && next == 'P') {
                        if (flag == true) return 0;
                        flag = true;
                    }
                }
                flag = false;
            }
        }
        return 1;
    }
}
