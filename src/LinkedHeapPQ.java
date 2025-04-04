public class LinkedHeapPQ implements PriorityQueue{
    private DoubleNode<Comparable> head;
    private DoubleNode<Comparable> tail;

    private int length;

    public LinkedHeapPQ() {
        head = null;
        tail = null;
        length = 0;
    }

    public void add(Comparable key, Comparable value) {

        Comparable[] data = {key, value};

        if (this.head == null) {
            this.head = new DoubleNode(data, null, null);
            this.tail = head;
        } else {
            this.tail.setNext(new DoubleNode(data, this.tail, null));
            this.tail = this.tail.getNext();
        }

        this.length++;
    }

    public Comparable[] removeMin() {
        return new Comparable[0];
    }

    public Comparable[] min() {
        return new Comparable[0];
    }

    public boolean empty() {
        return false;
    }

    public int size() {
        return this.length;
    }
}
