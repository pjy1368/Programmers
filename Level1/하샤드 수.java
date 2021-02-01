import java.util.stream.Stream;

class Solution {
    public boolean solution(int x) {
        return x % (Stream.of(String.valueOf(x).split(""))
                    .mapToInt(Integer::parseInt).sum()) == 0;
    }
}