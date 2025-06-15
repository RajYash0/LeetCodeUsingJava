import java.util.*;
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        List<List<String>> result = new ArrayList<>();
        if (!wordSet.contains(endWord)) return result;

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> distance = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        distance.put(beginWord, 0);

        while (!queue.isEmpty()) {
            String word = queue.poll();
            for (String neighbor : getNeighbors(word, wordSet)) {
                if (!distance.containsKey(neighbor)) {
                    distance.put(neighbor, distance.get(word) + 1 );
                    queue.offer(neighbor);
                }
                if (distance.get(neighbor) == distance.get(word) + 1) {
                    graph.computeIfAbsent(neighbor, k -> new ArrayList<>()).add(word);
                }
            }
        }

        if (!distance.containsKey(endWord)) return result;
        LinkedList<String> path = new LinkedList<>();
        dfs(endWord, beginWord, graph, path, result);
        return result;
    }

    private void dfs(String word, String beginWord, Map<String, List<String>> graph, LinkedList<String> path, List<List<String>> result) {
        path.addFirst(word);
        if (word.equals(beginWord)) {
            result.add(new ArrayList<>(path));
        } else if (graph.containsKey(word)) {
            for (String prev : graph.get(word)) {
                dfs(prev, beginWord, graph, path, result);
            }
        }
        path.removeFirst();
    }

    private List<String> getNeighbors(String word, Set<String> wordSet) {
        List<String> neighbors = new ArrayList<>();
        char[] arr = word.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char original = arr[i];
            for (char c = 'a'; c <= 'z'; c++) {
                if (c == original) continue;
                arr[i] = c;
                String newWord = new String(arr);
                if (wordSet.contains(newWord)) {
                    neighbors.add(newWord);
                }
            }
            arr[i] = original;
        }
        return neighbors;
    }
}
