import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        List<Integer> answer = new ArrayList<>();
        List<Integer> numbers = Arrays.stream(array)
            .boxed()
            .collect(Collectors.toList());
        
        // Arrays.copyOfRange()를 사용해도 됨.
        for (int[] command : commands) {
            int start = command[0] - 1;
            int end = command[1];
            int k = command[2] - 1;

            List<Integer> subNumbers = new ArrayList<>(numbers.subList(start, end));
            Collections.sort(subNumbers);
            answer.add(subNumbers.get(k));
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}