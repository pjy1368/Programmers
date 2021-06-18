import java.util.Arrays;
class Solution {
    public static int ans = Integer.MAX_VALUE;
    
    public int solution(String begin, String target, String[] words) {
        final boolean[] visited = new boolean[words.length];
        dfs(begin, target, words, visited, 1);
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
    
    private void dfs(String begin, String target, String[] words, boolean[] visited, int cnt) {
        if (begin.equals(target)) {
            ans = Math.min(ans, cnt - 1);
        }

        for (int i = 0; i < words.length; i++) {
            if (!visited[i] && onlyOneDifferentChar(begin, words[i])) {
                visited[i] = true;
                dfs(words[i], target, words, visited, cnt + 1);
                visited[i] = false;
            }
        }
    }

    private boolean onlyOneDifferentChar(String a, String b) {
        if (a.length() != b.length()) {
            return false;
        }

        int differentCnt = 0;
        for (int i = 0; i < a.length(); i++) {
            if (a.charAt(i) != b.charAt(i)) {
                differentCnt++;
            }
        }
        return differentCnt == 1;
    }
}