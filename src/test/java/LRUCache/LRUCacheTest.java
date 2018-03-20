package LRUCache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John on 3/20/18.
 */
public class LRUCacheTest {

    private LRUCache cache;

    @Before
    public void setUp(){
        cache = new LRUCache(3);
    }

    @Test
    public void testInitialCapacity(){
        assertEquals(0, cache.getCount());
    }

    @Test
    public void testCapacity(){
        cache.put(1, 1);
        assertEquals(1, cache.getCount());
        cache.put(1, 1);
        assertEquals(1, cache.getCount());
        cache.put(2, 2);
        assertEquals(2, cache.getCount());
        cache.put(3, 3);
        assertEquals(3, cache.getCount());
        cache.put(4, 4);
        assertEquals(3, cache.getCount());
    }

    @Test
    public void testPut() {
        cache.put(1, 10);
        assertEquals(10, cache.get(1));
        cache.put(2, 20);
        assertEquals(20, cache.get(2));
        cache.put(3, 30);
        assertEquals(30, cache.get(3));
        assertEquals(-1, cache.get(4));
        cache.put(4,40);
        assertEquals(40, cache.get(4));
        assertEquals(-1, cache.get(1));
        cache.put(5,50);
        assertEquals(50, cache.get(5));
        assertEquals(40, cache.get(4));
        assertEquals(30, cache.get(3));
        assertEquals(-1, cache.get(2));
        assertEquals(-1, cache.get(1));
        assertEquals(3, cache.getCount());
    }

}