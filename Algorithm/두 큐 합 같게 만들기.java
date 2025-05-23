class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int len = queue1.length;
        int[] arr = new int[len * 2];
        long sum1 = 0, sum2 = 0;
        
        for (int i = 0; i < len; i++) {
            arr[i] = queue1[i];
            arr[i + len] = queue2[i];
            
            sum1 += queue1[i];
            sum2 += queue2[i];
        }
        
        int cnt = 0;
        int left = 0, right = len;
        while (left < right && right < len * 2) {
            if (sum1 == sum2)
                return cnt;
            
            if (sum1 > sum2) {
                sum1 -= arr[left];
                sum2 += arr[left++];
            }
            else {
                sum2 -= arr[right];
                sum1 += arr[right++];
            }
            cnt++;
        }
        
        return -1;
    }
}
