import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
    private int N;
    private Node head, tail;

    public Deque() {
        N = 0;
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    private void nullCheck(Item item) {
        if (item == null) throw new NullPointerException("Cannot add null to Deque!");
    }

    private void emptyDeque() {
        if (N == 0)
            throw new NoSuchElementException("Cannot remove items from empty Deque!");
    }

    public void addFirst(Item item) {
        nullCheck(item);
        Node node = new Node(item);
        node.prev = null;
        node.next = head;
        if (head != null) head.prev = node;
        head = node;
        N++;
        if (N == 1) tail = head;
    }

    public void addLast(Item item) {
        nullCheck(item);
        Node node = new Node(item);
        node.prev = tail;
        node.next = null;
        if (tail != null) tail.next = node;
        tail = node;
        N++;
        if (N == 1) head = tail;
    }

    public Item removeFirst() {
        emptyDeque();
        Node node = head;
        head = head.next;
        if (head != null) head.prev = null;
        if (tail == node) tail = head;
        N--;
        return node.item;
    }

    public Item removeLast() {
        emptyDeque();
        Node node = tail;
        tail = tail.prev;
        if (tail != null) tail.next = null;
        if (head == node) head = tail;
        N--;
        return node.item;
    }

    public Iterator<Item> iterator() {
        return new DequeIterator();
    }

    private class Node {
        private final Item item;
        private Node next;
        private Node prev;

        Node(Item item) {
            this.item = item;
        }
    }

    private class DequeIterator implements Iterator<Item> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public Item next() {
            if (current == null) throw new NoSuchElementException("Cannot iterate over empty Deque!");
            Item item = current.item;
            current = current.next;
            return item;
        }

        @Override
        public void remove() {
            throw new UnsupportedOperationException("remove function not supported.");
        }
    }
}