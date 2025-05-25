class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = {0, sequence.length - 1};
        int left = 0, right = 0;
        int sum = sequence[0];
        
        while (right < sequence.length) {
            if (sum == k)
                answer = answer[1] - answer[0] <= right - left ? answer : new int[]{left, right};
            else if (sum > k) {
                sum -= sequence[left++];
                continue;
            }
            
            if (++right < sequence.length)
                sum += sequence[right];
        }
        
        return answer;
    }
}
