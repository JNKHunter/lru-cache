package LRUCache;

/**
 * Created by John on 3/20/18.
 */
@lombok.Data
public class Node {
    private Node next;
    private Node prev;
    private int value;
    private int key;

    public Node(int key, int value) {
        this.value = value;
        this.key = key;
    }
}
