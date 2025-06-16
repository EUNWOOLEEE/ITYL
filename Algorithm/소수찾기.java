import java.util.*;

class Solution {
    public int answer = 0;
    public HashSet<Integer> set = new HashSet<>();
    
    public int solution(String numbers) {
        char[] nums = numbers.toCharArray();
        
        for (int cnt = 1; cnt <= nums.length; cnt++)
            recursion(nums, new StringBuilder(), cnt, new boolean[8]);
        
        return answer;
    }
    
    public void recursion(char[] nums, StringBuilder str, int cnt, boolean[] visited) {
        if (str.length() == cnt) {
            if (isPrime(str) == true)
                answer++;
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (visited[i] == true) continue;
            
            visited[i] = true;
            str.append(nums[i]);
            
            recursion(nums, str, cnt, visited);
            
            str.deleteCharAt(str.length() - 1);
            visited[i] = false;
        }
    }
    
    public boolean isPrime(StringBuilder str) {
        int n = Integer.parseInt(new String(str));
        if (set.contains(n) == true)
            return false;
        set.add(n);
        
        if (n == 2)
            return true;
        if (n <= 1 || n % 2 == 0)
            return false;
        
        for (int i = 3; i * i <= n; i++)
            if (n % i == 0)
                return false;
        
        return true;
    }
}
