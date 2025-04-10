import java.util.Arrays;

public class LinkedHeapPQ implements PriorityQueue {
    private DoubleNode<Comparable[]> head;
    private DoubleNode<Comparable[]> tail;
    private int length;

    public LinkedHeapPQ() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }


    public void add(Comparable key, Comparable value) {
        Comparable[] data = {key, value};

        this.length++;

        if (this.head == null) {
            this.head = new DoubleNode(data);
            this.tail = head;
        } else {
            this.tail.setNext(new DoubleNode(data, this.tail, null));
            this.tail = this.tail.getNext();

            // upheap here
            _upheap();
        }
    }

    private void _upheap() {
        int index = this.length - 1;

        DoubleNode<Comparable[]> newNode = this.tail;

        while (index > 0) {
            DoubleNode<Comparable[]> currNode = this.head;
            int parentIndex = (index - 1) >>> 1;

            for (int i = 1; i < parentIndex; i++) {
                currNode = currNode.getNext();
            }

            if (currNode.getElement()[0].compareTo(newNode.getElement()[0]) >= 0) {
                break;
            }

            System.out.println("Need Swap");

            DoubleNode<Comparable[]> tempNode =
                    new DoubleNode<Comparable[]>(null, newNode.getPrevious(), newNode.getNext());

            newNode.setPrevious(currNode.getPrevious());
            newNode.setNext(currNode.getNext());

            currNode.setNext(tempNode.getNext());
            currNode.setPrevious(tempNode.getPrevious());

            index = parentIndex;
        }
    }



    public Comparable[] removeMin() {
        return new Comparable[0];
    }

    public Comparable[] min() {
        return this.head.getElement();
    }

    public boolean empty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }

    public void traverse() {
        DoubleNode<Comparable[]> current = this.head;
        while (current != null) {
            Comparable[] data = current.getElement();
            System.out.println("Key: " + data[0] + ", Value: " + data[1]);
            current = current.getNext();
        }
    }

    public static void main(String[] args) {
        LinkedHeapPQ pq = new LinkedHeapPQ();

        pq.add('1', 2);
        pq.add('1', 4);
        pq.add('5', 1241);
        pq.add('3', 5);

        pq.traverse();
    }
}