import java.util.Stack;

class Solution {
    public int solution(String s) {
        int answer = 0;
        int len = s.length();
        
        for (int start = 0; start < len; start++) {
            Stack<Character> stack = new Stack();

            int idx = 0;
            for (; idx < len; idx++) {
                char c = s.charAt((start + idx) % len);
                
                if (c == ']' || c == '}' || c == ')') {
                    if (stack.isEmpty())
                        break;
                    
                    char tmp = stack.pop();
                    if ((tmp == '[' && c != ']')
                        || (tmp == '{' && c != '}')
                        || (tmp == '(' && c != ')'))
                        break;
                }
                else
                    stack.push(c);
            }
            
            if (stack.isEmpty() == true && idx == len)
                answer++;
        }
        return answer;
    }
}
