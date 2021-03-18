import java.util.*;

class Solution {
    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        for(int i = 0; i < prices.length; i++){
            int temp = prices[i];
            
            int time = prices.length - 1 - i;
            boolean flag = false;
            int idx = -1;
            for(int j = i + 1; j < prices.length; j++){
                if(temp > prices[j]){
                    flag = true;
                    idx = j;
                    break;
                }
            }
            
            if(flag){
                time = idx - i;
            }
            
            answer[i] = time;
        }
        
        return answer;
    }
}