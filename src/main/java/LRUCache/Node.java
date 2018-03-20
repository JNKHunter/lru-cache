package LRUCache;

/**
 * Created by John on 3/20/18.
 */
public class Node {
    private Node next;
    private Node prev;
    private int value;
    private int key;

    public Node(int key, int value) {
        this.value = value;
        this.key  = key;
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
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

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
