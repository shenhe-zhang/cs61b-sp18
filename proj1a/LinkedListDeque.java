public class LinkedListDeque<T> {
    private class StuffNode {
        public StuffNode prev;
        public T item;
        public StuffNode next;

        public StuffNode(StuffNode p, T i, StuffNode n) {
            prev = p;
            item = i;
            next = n;
        }
    }
    private StuffNode sentinel;
    private int size;

    public LinkedListDeque(){
        sentinel = new StuffNode(null, null, null);
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
        size = 0;
    }
    public LinkedListDeque(T item) {
        sentinel = new StuffNode(null, null, null);
        StuffNode first = new StuffNode(sentinel, item, sentinel);
        sentinel.next = first;
        sentinel.prev = first;
        size = 1;
    }
    public void addFirst(T item){
        sentinel.next = new StuffNode(sentinel, item, sentinel.next);
        sentinel.next.next.prev = sentinel.next;
        size ++;
    }
    public void addLast(T item){
        sentinel.prev = new StuffNode(sentinel.prev, item, sentinel);
        sentinel.prev.prev.next = sentinel.prev;
        size ++;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public int size(){
        return size;
    }
    public void printDeque(){
        if (isEmpty()){return;};
        StuffNode s = sentinel.next;
        System.out.print(s.item);
        s = s.next;
        while (s != sentinel){
            System.out.print(',');
            System.out.print(s.item);
            s = s.next;

        }
    }
    public T removeFirst(){
        if (isEmpty()){return null;};
        StuffNode first = sentinel.next;
        sentinel.next = first.next;
        first.next.prev = sentinel;
        size --;
        return first.item;
    }
    public T removeLast(){
        if (isEmpty()){return null;};
        StuffNode last = sentinel.prev;
        sentinel.prev = last.prev;
        last.prev.next = sentinel;
        size --;
        return last.item;
    }
    public T get(int index){
        if (isEmpty()){return null;};
        StuffNode s = sentinel.next;
        while (s != sentinel){
            if (index == 0){
                return s.item;
            }
            index--;
            s = s.next;
        }
        return null;
    }
    public T getRecursive(int index){
        if (index == 0){
            return sentinel.next.item;
        }
        sentinel = sentinel.next;
        return getRecursive(index - 1);
    }
}
