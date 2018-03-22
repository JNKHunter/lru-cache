package LRUCache;

/**
 * Created by John on 3/20/18.
 */

public class Node<T> {
    private Node next;
    private Node prev;
    private T value;
    private long key;

    public Node(long key, T value) {
        this.value = value;
        this.key = key;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public Node getPrev() {
        return prev;
    }

    public void setPrev(Node prev) {
        this.prev = prev;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public long getKey() {
        return key;
    }

    public void setKey(long key) {
        this.key = key;
    }
}
