import java.util.*;

class Solution {
    public int[] solution(long n) {
        List<Integer> answer = new ArrayList<>();
        while (n != 0) {
            long q = n % 10;
            answer.add((int) q);
            n /= 10;
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
}