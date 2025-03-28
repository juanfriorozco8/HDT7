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
        root = insertRec(root, key, value);
    }

    private Node insertRec(Node current, K key, V value) {
        if (current == null) return new Node(key, value);
        if (key.compareTo(current.key) < 0)
            current.left = insertRec(current.left, key, value);
        else if (key.compareTo(current.key) > 0)
            current.right = insertRec(current.right, key, value);
        else
            current.value = value;
        return current;
    }

    public V search(K key) {
        return searchRec(root, key);
    }

    private V searchRec(Node current, K key) {
        if (current == null) return null;
        if (key.compareTo(current.key) == 0) return current.value;
        return key.compareTo(current.key) < 0 ? searchRec(current.left, key) : searchRec(current.right, key);
    }

    public void inOrderTraversal() {
        inOrderRec(root);
    }

    private void inOrderRec(Node current) {
        if (current != null) {
            inOrderRec(current.left);
            System.out.println(current.value);
            inOrderRec(current.right);
        }
    }
}
