public class LinkedHeapPQ implements PriorityQueue{
    private DoubleNode<Comparable[]> head;
    private DoubleNode<Comparable[]> tail;

    private int length;

    public LinkedHeapPQ() {
        head = null;
        tail = null;
        length = 0;
    }

    public void add(Comparable key, Comparable value) {

        Comparable[] data = {key, value};

        this.length++;

        if (this.head == null) {
            this.head = new DoubleNode<Comparable[]>(data, null, null);
            this.tail = head;
        } else {
            this.tail.setNext(new DoubleNode<Comparable[]>(data, this.tail, null));
            this.tail = this.tail.getNext();


        }
    }

    private DoubleNode<Comparable[]> getParent(DoubleNode<Comparable[]> child, int index) {
        if (index <= 0) return null;

        int parentIndex = (index - 1) >>> 1;
        DoubleNode<Comparable[]> parent = this.head;

        for (int i = 0; i < parentIndex; i++) {
            parent = parent.getNext();
        }

        return parent;
    }

    public Comparable[] removeMin() {
        return new Comparable[0];
    }

    public Comparable[] min() {
        return head.getElement();
    }

    public boolean empty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }

    public static void main(String[] args) {
        System.out.println((7 - 1) >>> 1);
    }

}
