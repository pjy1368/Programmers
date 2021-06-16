class Solution {
    public int solution(int[] numbers, int target) {
        return bfs(numbers, target, numbers[0], 1) + bfs(numbers, target, -numbers[0], 1);
    }
    
     private int bfs(int[] numbers, int target, int sum, int idx) {
        if (idx == numbers.length) {
            if (sum == target) {
                return 1;
            }
            return 0;
        }

        int result = 0;
        result += dfs(numbers, target, sum + numbers[idx], idx + 1);
        result += dfs(numbers, target, sum - numbers[idx], idx + 1);
        return result;
    }
}