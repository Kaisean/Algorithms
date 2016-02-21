import edu.princeton.cs.algs4.StdRandom;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class RandomizedQueue<Item> implements Iterable<Item> {
    private int N;
    private Item[] s;

    public RandomizedQueue() {
        s = (Item[]) new Object[2];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void nullCheck(Item item) {
        if (item == null) throw new NullPointerException("Cannot add null to RandomizedQueue!");
    }

    private void emptyQueue() {
        if (N == 0)
            throw new NoSuchElementException("Cannot remove items from empty Deque!");
    }

    private void resize(int capacity) {
        assert capacity >= N;
        s = copyArray(capacity);
    }

    private Item[] copyArray(int capacity) {
        Item[] temp = (Item[]) new Object[capacity];
        System.arraycopy(s, 0, temp, 0, N);
        return temp;
    }

    public void enqueue(Item item) {
        nullCheck(item);
        if (N == s.length) resize(2 * s.length);
        s[N++] = item;
    }

    public Item dequeue() {
        emptyQueue();
        int index = StdRandom.uniform(N);
        Item item = s[index];
        s[index] = s[--N];
        s[N] = null;
        if (N > 0 && N == s.length / 4) resize(s.length / 2);
        return item;
    }

    public Item sample() {
        emptyQueue();
        return s[StdRandom.uniform(N)];
    }

    public Iterator<Item> iterator() {
        return new RandomizedQueueIterator();
    }

    private class RandomizedQueueIterator implements Iterator<Item> {
        private int current;
        private final Item[] copy;

        public RandomizedQueueIterator() {
            current = 0;
            copy = copyArray(s.length);
            if (N > 0) StdRandom.shuffle(copy, 0, N - 1);
        }

        @Override
        public boolean hasNext() {
            return current < N;
        }

        @Override
        public Item next() {
            if (current >= N) throw new NoSuchElementException("No remaining items in Iterator!");
            return copy[current++];
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove function not supported.");
        }
    }
}