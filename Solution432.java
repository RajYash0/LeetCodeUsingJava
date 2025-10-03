class AllOne {
    private class Node {
        int count;
        Set<String> keys;
        Node prev, next;
        Node(int c) {
            count = c;
            keys = new HashSet<>();
        }
    }
    private Map<String, Node> map;
    private Node head, tail;
    public AllOne() {
        map = new HashMap<>();
        head = new Node(Integer.MIN_VALUE);
        tail = new Node(Integer.MAX_VALUE);
        head.next = tail;
        tail.prev = head;
    }
    public void inc(String key) {
        if (!map.containsKey(key)) {
            if (head.next.count != 1) insertNodeAfter(head, new Node(1));
            head.next.keys.add(key);
            map.put(key, head.next);
        } else {
            Node node = map.get(key);
            Node next = node.next;
            if (next.count != node.count + 1) {
                next = new Node(node.count + 1);
                insertNodeAfter(node, next);
            }
            next.keys.add(key);
            map.put(key, next);
            node.keys.remove(key);
            if (node.keys.isEmpty()) removeNode(node);
        }
    }
    public void dec(String key) {
        Node node = map.get(key);
        if (node.count == 1) {
            map.remove(key);
            node.keys.remove(key);
            if (node.keys.isEmpty()) removeNode(node);
        } else {
            Node prev = node.prev;
            if (prev.count != node.count - 1) {
                prev = new Node(node.count - 1);
                insertNodeAfter(node.prev, prev);
            }
            prev.keys.add(key);
            map.put(key, prev);
            node.keys.remove(key);
            if (node.keys.isEmpty()) removeNode(node);
        }
    }
    public String getMaxKey() {
        return tail.prev == head ? "" : tail.prev.keys.iterator().next();
    }
    public String getMinKey() {
        return head.next == tail ? "" : head.next.keys.iterator().next();
    }
    private void insertNodeAfter(Node prev, Node node) {
        node.next = prev.next;
        node.prev = prev;
        prev.next.prev = node;
        prev.next = node;
    }
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }
}