public class ArrayDeque<T> {    /** Creates an empty list. */

    private T[] items;
    private int size;
    private int nextFirst;
    private int nextLast;

    /** Creates an empty list. */
    public ArrayDeque() {
        items = (T[]) new Object[8];
        size = 0;
        nextFirst = 4;
        nextLast = 5;
        }

    public void addFirst(T item){
        items[nextFirst] = item;
        if (nextFirst != 0){
            nextFirst--;
        }else{
            nextFirst = items.length-1;
        }
        size++;
    }
    /** Inserts X into the back of the list. */
    public void addLast(T item) {
        items[nextLast] = item;
        if (nextLast != 0){
            nextLast++;
        }else{
            nextFirst = 0;
        }
        size++;
    }

    /** Returns the number of items in the list. */
    public int size() {
        return size;
    }

    public boolean isEmpty(){return size == 0;}

    public void printDeque() {
        for (T p : items) {
            System.out.print(p + " ");
        }
        System.out.print("\n");
    }

    /** Returns the item from the back of the list. */
    public T removeFirst() {
        size--;
        if (nextFirst != items.length - 1) {
            nextFirst++;
            return items[nextFirst + 1];
        }else{
            nextFirst = 0;
            return items[0];
        }
    }
    /** Deletes item from back of the list and
     * returns deleted item. */
    public T removeLast() {
        size--;
        if (nextLast != 0) {
            nextLast--;
            return items[nextLast - 1];
        }else{
            nextLast = items.length;
            return items[items.length-1];
        }
    }

    /** Gets the ith item in the list (0 is the front). */
    public T get(int index) {
        return items[index];
    }



}
