import java.util.stream.Stream;

public class Solution {
    public int solution(int n) {
        return Stream.of(String.valueOf(n).split("")).mapToInt(Integer::parseInt).sum();
    }
}