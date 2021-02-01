import java.util.Arrays;
import java.util.stream.IntStream;

class Solution {
    public int solution(int n) {
        return eratos(n);
    }
    
    public int eratos(int n) {
        boolean[] isPrime = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = isPrime[1] = false;
        
        for (int i = 2; i * i <= n; i++) {
            if (isPrime[i]) {
                for (int j = i * i; j <= n; j += i) {
                    isPrime[j] = false;
                }
            }
        }
        return (int) IntStream.range(0, isPrime.length)
            .mapToObj(i -> isPrime[i])
            .filter(i -> i)
            .count();
    }
}