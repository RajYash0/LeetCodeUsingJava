import java.util.*;

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<>();
    }

    public Node(int val) {
        this.val = val;
        neighbors = new ArrayList<>();
    }

    public Node(int val, List<Node> neighbors) {
        this.val = val;
        this.neighbors = neighbors;
    }
}

class Solution133 {
    private Map<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        if (map.containsKey(node)) return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);

        for (Node neighbor : node.neighbors) {
            copy.neighbors.add(cloneGraph(neighbor));
        }

        return copy;
    }
}
