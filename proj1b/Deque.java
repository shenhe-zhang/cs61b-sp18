public interface Deque<Item> {
    /** Add one item to the front of the list. */
    void addFirst(Item item);

    /** Remove the last item of the queue. */
    void addLast(Item item);

    /** Return a boolean to tell if a queue is empty. */
    boolean isEmpty();

    /** Return the size of a queue. */
    int size();

    /** Print every elements in a queue, separated by a space. */
    void printDeque();

    /** Delete the first item and return it. */
    Item removeFirst();

    /** Delete the last item and return it. */
    Item removeLast();

    /** Gets the item at the given index */
    public Item get(int index);
}
