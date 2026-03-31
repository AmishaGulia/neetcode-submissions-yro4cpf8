

class LRUCache {
    private class Node {
        int key, value;
        Node prev, next;
        Node(int k, int v) { key = k; value = v; }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail; // dummy nodes

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();
        
        // Initialize dummy head and tail
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        if (!map.containsKey(key)) return -1;
        Node node = map.get(key);
        moveToHead(node);
        return node.value;
    }

    public void put(int key, int value) {
        if (map.containsKey(key)) {
            Node node = map.get(key);
            node.value = value;
            moveToHead(node);
        } else {
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addToHead(newNode);

            if (map.size() > capacity) {
                Node lru = removeTail();
                map.remove(lru.key);
            }
        }
    }

    // Helper: add node right after head
    private void addToHead(Node node) {
        node.prev = head;
        node.next = head.next;
        head.next.prev = node;
        head.next = node;
    }

    // Helper: remove any node
    private void removeNode(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // Helper: move node to head (most recently used)
    private void moveToHead(Node node) {
        removeNode(node);
        addToHead(node);
    }

    // Helper: remove LRU (from tail)
    private Node removeTail() {
        Node lru = tail.prev;
        removeNode(lru);
        return lru;
    }

    
}
