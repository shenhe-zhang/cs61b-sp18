// TODO: Make sure to make this class a part of the synthesizer package
package synthesizer;
import java.util.Arrays;
import java.util.Iterator;

//TODO: Make sure to make this class and all of its methods public
//TODO: Make sure to make this class extend AbstractBoundedQueue<t>
public class ArrayRingBuffer<T> extends AbstractBoundedQueue<T> {
    /* Index for the next dequeue or peek. */
    private int first;            // index for the next dequeue or peek
    /* Index for the next enqueue. */
    private int last;
    /* Array for storing the buffer data. */
    private T[] rb;

    /**
     * Create a new ArrayRingBuffer with the given capacity.
     */
    public ArrayRingBuffer(int capacity) {
        // TODO: Create new array with capacity elements.
        //       first, last, and fillCount should all be set to 0.
        //       this.capacity should be set appropriately. Note that the local variable
        //       here shadows the field we inherit from AbstractBoundedQueue, so
        //       you'll need to use this.capacity to set the capacity.
        first = 0;
        last = 0;
        fillCount = 0;
        this.capacity = capacity;
        rb = (T[]) new Object[capacity];
    }

    /**
     * Adds x to the end of the ring buffer. If there is no room, then
     * throw new RuntimeException("Ring buffer overflow"). Exceptions
     * covered Monday.
     */
    @Override
    public void enqueue(T x) {
        // TODO: Enqueue the item. Don't forget to increase fillCount and update last.
        if (isFull()) {
            throw new RuntimeException("Ring buffer overflow");
        }
        rb[last] = x;
        fillCount++;
        if (last == capacity - 1) {
            last = 0;
        } else {
            last++;
        }
    }

    /**
     * Dequeue oldest item in the ring buffer. If the buffer is empty, then
     * throw new RuntimeException("Ring buffer underflow"). Exceptions
     * covered Monday.
     */
    public T dequeue() {
        // TODO: Dequeue the first item. Don't forget to decrease fillCount and update first
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        }
        T output = rb[first];
        fillCount--;
        if (first == capacity - 1) {
            first = 0;
        } else {
            first++;
        }
        return output;
    }

    /**
     * Return oldest item, but don't remove it.
     */
    public T peek() {
        // TODO: Return the first item. None of your instance variables should change.
        if (isEmpty()) {
            throw new RuntimeException("Ring buffer underflow");
        } else {
            return rb[first];
        }
    }

    // TODO: When you get to part 5, implement the needed code to support iteration.
    @Override
    public Iterator<T> iterator() {
        return new BufferIterator();
    }

    private class BufferIterator implements Iterator<T> {
        private int ptr;
        public BufferIterator() {
            ptr = 0;
        }
        public boolean hasNext() {
            return (ptr != capacity);
        }
        public T next() {
            T returnItem = rb[ptr];
            ptr = ptr + 1;
            return returnItem;
        }

    }

    public static void main(String[] args){
        ArrayRingBuffer arb = new ArrayRingBuffer(3);

        arb.enqueue("t1");
        arb.enqueue("t2");
        arb.enqueue("t3");
        System.out.println(arb.peek());
        System.out.println(arb.fillCount);
        System.out.println(arb.dequeue());
        System.out.println(arb.peek());
        System.out.println(arb.first);
        System.out.println(arb.fillCount);
        System.out.println(arb.dequeue());
        System.out.println(arb.peek());
        arb.enqueue("t4");
        System.out.println(arb.peek());
        System.out.println(arb.fillCount);
        System.out.println(arb.capacity);
    }
}
