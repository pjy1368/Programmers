import java.util.stream.LongStream;

class Solution {
    public long solution(int a, int b) {
        if (a > b) {
            a ^= b;
            b ^= a;
            a ^= b;
        }
        return LongStream.range(a, b + 1).sum();
    }
}