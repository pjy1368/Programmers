import java.util.Collections;
import java.util.stream.Stream;
import java.util.stream.Collectors;

class Solution {
    public long solution(long n) {
        String answer = Stream.of(String.valueOf(n).split(""))
            .sorted(Collections.reverseOrder())
            .collect(Collectors.joining());
        return Long.parseLong(answer);
    }
}