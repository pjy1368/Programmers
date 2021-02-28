class Solution {
    public int solution(int n) {
        return sum(n);
    }
    
    private int sum(int n) {
        int total = 0;
        int i = 1;
        for (i = 1; i * i < n; i++) {
            if (n % i == 0) {
                total += i;
                total += n / i;
            }
        }
        
        if (i * i == n) {
            total += i;
        }
        
        return total;
    }
}