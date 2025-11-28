import java.util.*;

class Solution {
    private List<Integer>[] graph;
    private int[] values;
    private int k;
    private int count;

    public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
        this.k = k;
        this.values = values;
        graph = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] e : edges) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }
        count = 0;
        dfs(0, -1);
        return count;
    }

    private long dfs(int u, int parent) {
        long sum = values[u];
        for (int v : graph[u]) {
            if (v == parent) continue;
            sum += dfs(v, u);
        }
        if (sum % k == 0) {
            count++;
            return 0;
        }
        return sum % k;
    }
}