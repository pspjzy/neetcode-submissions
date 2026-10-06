class LRUCache {

    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;

    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {

        if (!map.containsKey(key)) {
            return -1;
        }

        Node node = map.get(key);

        // 刚刚使用过，变成 MRU
        remove(node);
        addFirst(node);

        return node.value;
    }

    public void put(int key, int value) {

        // key 已存在
        if (map.containsKey(key)) {
            Node node = map.get(key);

            node.value = value;

            remove(node);
            addFirst(node);

            return;
        }

        // 新 key
        Node node = new Node(key, value);

        map.put(key, node);
        addFirst(node);

        // 超容量
        if (map.size() > capacity) {

            Node lru = tail.prev;

            remove(lru);
            map.remove(lru.key);
        }
    }

    // 从链表删除 node
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    // 放到最前面，表示最近使用
    private void addFirst(Node node) {

        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }
}