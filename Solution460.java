class LFUCache {
    class Node {
        int key, val, freq;
        Node prev, next;
        Node(int k, int v) { key = k; val = v; freq = 1; }
    }
    class DLinkedList {
        Node head, tail;
        DLinkedList() {
            head = new Node(-1, -1);
            tail = new Node(-1, -1);
            head.next = tail;
            tail.prev = head;
        }
        void addFirst(Node node) {
            node.next = head.next;
            node.prev = head;
            head.next.prev = node;
            head.next = node;
        }
        void remove(Node node) {
            node.prev.next = node.next;
            node.next.prev = node.prev;
        }
        Node removeLast() {
            if (tail.prev == head) return null;
            Node node = tail.prev;
            remove(node);
            return node;
        }
        boolean isEmpty() {
            return head.next == tail;
        }
    }
    int capacity, size, minFreq;
    Map<Integer, Node> nodeMap;
    Map<Integer, DLinkedList> freqMap;
    public LFUCache(int capacity) {
        this.capacity = capacity;
        size = 0;
        minFreq = 0;
        nodeMap = new HashMap<>();
        freqMap = new HashMap<>();
    }
    public int get(int key) {
        if (!nodeMap.containsKey(key)) return -1;
        Node node = nodeMap.get(key);
        int oldFreq = node.freq;
        freqMap.get(oldFreq).remove(node);
        if (oldFreq == minFreq && freqMap.get(oldFreq).isEmpty()) {
            minFreq++;
        }
        node.freq++;
        freqMap.computeIfAbsent(node.freq, f -> new DLinkedList()).addFirst(node);
        return node.val;
    }
    public void put(int key, int value) {
        if (capacity == 0) return;
        if (nodeMap.containsKey(key)) {
            Node node = nodeMap.get(key);
            node.val = value;
            get(key);
        } else {
            if (size == capacity) {
                DLinkedList list = freqMap.get(minFreq);
                Node toRemove = list.removeLast();
                nodeMap.remove(toRemove.key);
                size--;
            }
            Node newNode = new Node(key, value);
            nodeMap.put(key, newNode);
            freqMap.computeIfAbsent(1, f -> new DLinkedList()).addFirst(newNode);
            minFreq = 1;
            size++;
        }
    }
}