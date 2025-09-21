import java.util.*;

class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0), b = equations.get(i).get(1);
            graph.putIfAbsent(a, new HashMap<>());
            graph.putIfAbsent(b, new HashMap<>());
            graph.get(a).put(b, values[i]);
            graph.get(b).put(a, 1.0 / values[i]);
        }
        double[] res = new double[queries.size()];
        for (int i = 0; i < queries.size(); i++) {
            String a = queries.get(i).get(0), b = queries.get(i).get(1);
            if (!graph.containsKey(a) || !graph.containsKey(b)) res[i] = -1.0;
            else if (a.equals(b)) res[i] = 1.0;
            else res[i] = dfs(a, b, graph, new HashSet<>(), 1.0);
        }
        return res;
    }

    private double dfs(String cur, String target, Map<String, Map<String, Double>> graph, Set<String> visited, double val) {
        if (cur.equals(target)) return val;
        visited.add(cur);
        for (Map.Entry<String, Double> e : graph.get(cur).entrySet()) {
            if (!visited.contains(e.getKey())) {
                double res = dfs(e.getKey(), target, graph, visited, val * e.getValue());
                if (res != -1.0) return res;
            }
        }
        return -1.0;
    }
}
