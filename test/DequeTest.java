import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DequeTest {

    Deque<String> deque;

    @Before
    public void init() {
        deque = new Deque<>();
    }

    @Test(expected = NullPointerException.class)
    public void addNullTest() {
        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());

        deque.addFirst(null);
        deque.addLast(null);
    }

    @Test(expected = NoSuchElementException.class)
    public void removeNullTest() {
        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());

        deque.removeFirst();
        deque.removeLast();
    }

    @Test(expected = NoSuchElementException.class)
    public void iteratorNullTest() {
        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());

        Iterator<String> it = deque.iterator();
        it.next();
    }

    @Test
    public void addTest() {
        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());

        deque.addFirst("head0");
        Assert.assertEquals(1, deque.size());
        Assert.assertEquals("head0", deque.removeFirst());

        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());

        deque.addLast("tail0");
        Assert.assertEquals(1, deque.size());
        Assert.assertEquals("tail0", deque.removeLast());
    }

    @Test
    public void addCrossHeadTailTest() {
        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());

        deque.addFirst("head0");
        Assert.assertEquals(1, deque.size());
        Assert.assertEquals("head0", deque.removeLast());

        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());

        deque.addLast("tail0");
        Assert.assertEquals(1, deque.size());
        Assert.assertEquals("tail0", deque.removeFirst());
    }

    @Test
    public void iteratorTest() {
        Assert.assertTrue(deque.isEmpty());
        Assert.assertEquals(0, deque.size());

        deque.addFirst("head2");
        deque.addFirst("head1");
        deque.addFirst("head0");
        deque.addLast("tail0");
        deque.addLast("tail1");
        deque.addLast("tail2");

        StringBuilder sb = new StringBuilder();
        Iterator it = deque.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) sb.append(", ");
        }

        Assert.assertEquals("head0, head1, head2, tail0, tail1, tail2", sb.toString());
    }

    @Test
    public void addRemoveIteratorTest() {
        Deque<Integer> dq = new Deque<>();
        dq.addFirst(1);

        Assert.assertTrue(1 == dq.removeLast()); //==>1

        dq.addLast(3);
        dq.addLast(4);
        Assert.assertTrue(3 == dq.removeFirst()); // ==>3

        dq.addLast(6);
        dq.addFirst(7);
        dq.addLast(8);
        Assert.assertTrue(8 == dq.removeLast()); //==>8

        Assert.assertTrue(3 == dq.size());

        Iterator<Integer> it = dq.iterator();
        int t = 0;
        while (it.hasNext()) {
            it.next();
            t++;
        }
        Assert.assertTrue(t == 3);
    }
}
