import java.util.*;

public class Solution {
    public int[] solution(int[] arr) {
        List<Integer> answer = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        
        Arrays.stream(arr).forEach(i -> {
          if (stack.isEmpty() || stack.peek() != i) {
            stack.push(i);
            answer.add(i);
          }
        });

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}