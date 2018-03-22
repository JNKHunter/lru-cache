package LRUCache;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by John on 3/20/18.
 */
public class LRUCacheTest {

    private LRUCache<Long> cache;

    @Before
    public void setUp() {
        cache = new LRUCache<Long>(3);
    }

    @Test
    public void testInitialCapacity() {
        assertEquals(0, cache.getCount());
    }

    @Test
    public void testCapacity() {
        cache.put(1, 1L);
        assertEquals(1, cache.getCount());
        cache.put(1, 1L);
        assertEquals(1, cache.getCount());
        cache.put(2, 2L);
        assertEquals(2, cache.getCount());
        cache.put(3, 3L);
        assertEquals(3, cache.getCount());
        cache.put(4, 4L);
        assertEquals(3, cache.getCount());
    }

    @Test
    public void testPut() {
        cache.put(1L, 10L);
        assertEquals(10L, (Object)cache.get(1L));
        cache.put(2L, 20L);
        assertEquals(20L, (Object)cache.get(2L));
        cache.put(3L, 30L);
        assertEquals(30L, (Object)cache.get(3L));
        assertEquals(null, (Object)cache.get(4L));
        cache.put(4L, 40L);
        assertEquals(40L, (Object)cache.get(4L));
        assertEquals(null, (Object)cache.get(1L));
        cache.put(5L, 50L);
        assertEquals(50L, (Object)cache.get(5L));
        assertEquals(40L, (Object)cache.get(4L));
        assertEquals(30L, (Object)cache.get(3L));
        assertEquals(null, (Object)cache.get(2L));
        assertEquals(null, (Object)cache.get(1L));
        assertEquals(3L, cache.getCount());
    }

}