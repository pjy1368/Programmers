import java.util.*;
class Solution {
    public int solution(int n, int[][] computers) {
        final ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                final int position = computers[i][j];
                if (position == 1 && i != j) {
                    graph.get(i).add(j);
                }
            }
        }

        final boolean[] visited = new boolean[n];
        int ans = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(graph, visited, i);
                ans++;
            }
        }
        return ans;
    }

    private void dfs(ArrayList<ArrayList<Integer>> graph, boolean[] visited, int now) {
        visited[now] = true;
        for (int computer : graph.get(now)) {
            if (!visited[computer]) {
                visited[computer] = true;
                dfs(graph, visited, computer);
            }
        }
    }
}