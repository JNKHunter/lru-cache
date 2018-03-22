package LRUCache;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by John on 3/20/18.
 */
public class LRUCache<T> {

    private long capacity;
    private long count;
    private Map<Long, Node<T>> map;
    private Node<T> head;
    private Node<T> tail;

    public LRUCache(int capacity) {
        //Dummy head and tail nodes for convenience
        map = new HashMap<Long, Node<T>>();
        this.head = new Node(0, 0);
        this.tail = new Node(-1, 0);
        head.setPrev(null);
        head.setNext(tail);
        tail.setPrev(head);
        tail.setNext(null);
        this.capacity = capacity;
    }

    private long getSize() {
        return count;
    }

    public T get(long key) {
        if (map.containsKey(key)) {
            Node found = map.get(key);

            //Remove found from it's place in the linked list
            found.getNext().setPrev(found.getPrev());
            found.getPrev().setNext(found.getNext());

            //Add found to the head since it's now the most recently used
            found.setNext(head.getNext());
            found.setPrev(head);
            found.getNext().setPrev(found);
            head.setNext(found);

            return (T)found.getValue();
        } else {
            return null;
        }
    }

    public void put(long key, T value) {
        if (map.containsKey(key)) {
            Node found = map.get(key);
            found.setValue(value);
        } else {
            count++;
            if (count > capacity) {
                count = capacity;
                //Remove tail.prev node since we are at capacity and it is the least recently used
                Node nodeToRemove = tail.getPrev();
                nodeToRemove.getPrev().setNext(tail);
                tail.setPrev(nodeToRemove.getPrev());
                map.remove(nodeToRemove.getKey());

            }
            //Put the new node at it's proper place at the head of the list
            Node<T> newNode = new Node(key, value);
            newNode.setNext(head.getNext());
            newNode.setPrev(head);
            head.getNext().setPrev(newNode);
            head.setNext(newNode);
            map.put(newNode.getKey(), newNode);
        }
    }

    public long getCount() {
        return count;
    }
}
