import java.util.*;

class Solution {
    public int[] solution(int[] arr, int divisor) {
        TreeSet<Integer> answer = Arrays.stream(arr).boxed().filter(i -> i % divisor == 0).collect(TreeSet::new, TreeSet::add, TreeSet::addAll);
        
        if (answer.isEmpty()) {
            answer.add(-1);
        }
        
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}