import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashSet;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;

public class RandomizedQueueTest {
    RandomizedQueue<Integer> randQueue;

    @Before
    public void init() {
        randQueue = new RandomizedQueue<>();
    }

    @Test(expected = NullPointerException.class)
    public void addNullTest() {
        Assert.assertTrue(randQueue.isEmpty());
        Assert.assertEquals(0, randQueue.size());

        randQueue.enqueue(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeNullTest() {
        Assert.assertTrue(randQueue.isEmpty());
        Assert.assertEquals(0, randQueue.size());

        randQueue.dequeue();
    }

    @Test
    public void addRemoveTest() {
        Assert.assertTrue(randQueue.isEmpty());
        Assert.assertEquals(0, randQueue.size());

        randQueue.enqueue(0);
        Assert.assertEquals(1, randQueue.size());
        Assert.assertTrue(0 == randQueue.dequeue());

        Assert.assertTrue(randQueue.isEmpty());
        Assert.assertEquals(0, randQueue.size());

        randQueue.enqueue(1);
        Assert.assertEquals(1, randQueue.size());
        Assert.assertTrue(1 == randQueue.dequeue());
    }

    @Test
    public void addSampleTest() {
        Assert.assertTrue(randQueue.isEmpty());
        Assert.assertEquals(0, randQueue.size());

        randQueue.enqueue(0);
        Assert.assertEquals(1, randQueue.size());
        Assert.assertTrue(0 == randQueue.sample());

        randQueue.enqueue(1);
        Assert.assertEquals(2, randQueue.size());
    }

    @Test
    public void iteratorTest() {
        Assert.assertTrue(randQueue.isEmpty());
        Assert.assertEquals(0, randQueue.size());

        randQueue.enqueue(0);
        randQueue.enqueue(1);
        randQueue.enqueue(2);
        randQueue.enqueue(3);
        randQueue.enqueue(4);
        randQueue.enqueue(5);

        Set<Integer> actual0 = new HashSet<>(randQueue.size());
        Set<Integer> actual1 = new HashSet<>(randQueue.size());
        Iterator<Integer> it0 = randQueue.iterator();
        Iterator<Integer> it1 = randQueue.iterator();
        while (it0.hasNext()) {
            actual0.add(it0.next());
        }
        while (it1.hasNext()) {
            actual1.add(it1.next());
        }

        Assert.assertTrue(actual0.contains(0));
        Assert.assertTrue(actual0.contains(1));
        Assert.assertTrue(actual0.contains(2));
        Assert.assertTrue(actual0.contains(3));
        Assert.assertTrue(actual0.contains(4));
        Assert.assertTrue(actual0.contains(5));

        Assert.assertTrue(actual1.contains(0));
        Assert.assertTrue(actual1.contains(1));
        Assert.assertTrue(actual1.contains(2));
        Assert.assertTrue(actual1.contains(3));
        Assert.assertTrue(actual1.contains(4));
        Assert.assertTrue(actual1.contains(5));

        randQueue.dequeue();
        Assert.assertEquals(5, randQueue.size());
        randQueue.dequeue();
        Assert.assertEquals(4, randQueue.size());
        randQueue.dequeue();
        Assert.assertEquals(3, randQueue.size());
        randQueue.dequeue();
        Assert.assertEquals(2, randQueue.size());
        randQueue.dequeue();
        Assert.assertEquals(1, randQueue.size());
        randQueue.dequeue();
        Assert.assertEquals(0, randQueue.size());
    }
}
