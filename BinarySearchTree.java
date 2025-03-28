public class BinarySearchTree<K extends Comparable<K>, V> {
    private class Node {
        K key;
        V value;
        Node left, right;

        Node(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    private Node root;

    public void insert(K key, V value) {
        root = insertRecursive(root, key, value);
    }

    private Node insertRecursive(Node current, K key, V value) {
        if (current == null) return new Node(key, value);

        int cmp = key.compareTo(current.key);
        if (cmp < 0)
            current.left = insertRecursive(current.left, key, value);
        else if (cmp > 0)
            current.right = insertRecursive(current.right, key, value);
        else
            current.value = value;

        return current;
    }

    public V search(K key) {
        return searchRecursive(root, key);
    }

    private V searchRecursive(Node current, K key) {
        if (current == null) return null;
        int cmp = key.compareTo(current.key);
        if (cmp == 0) return current.value;
        return (cmp < 0) ? searchRecursive(current.left, key) : searchRecursive(current.right, key);
    }

    public void inOrderTraversal() {
        inOrderRecursive(root);
    }

    private void inOrderRecursive(Node current) {
        if (current != null) {
            inOrderRecursive(current.left);
            System.out.println(current.value);
            inOrderRecursive(current.right);
        }
    }
}
