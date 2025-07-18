class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) graph[i] = new ArrayList<>();
        for (int[] pair : prerequisites) graph[pair[1]].add(pair[0]);
        int[] visited = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            if (dfs(i, graph, visited)) return false;
        }
        return true;
    }

    private boolean dfs(int node, List<Integer>[] graph, int[] visited) {
        if (visited[node] == 1) return true;
        if (visited[node] == 2) return false;
        visited[node] = 1;
        for (int neighbor : graph[node]) {
            if (dfs(neighbor, graph, visited)) return true;
        }
        visited[node] = 2;
        return false;
    }
}
