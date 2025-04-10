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
            DoubleNode<Comparable[]> parentNode = this.head;
            int parentIndex = (index - 1) >>> 1;

            for (int i = 0; i < parentIndex; i++) {
                parentNode = parentNode.getNext();
            }

            Comparable parentPrio = parentNode.getElement()[0];
            Comparable newNodePrio = newNode.getElement()[0];

            System.out.println("Parent Priority: " + parentPrio + "\n"
                             + "Child Priority: " + newNodePrio);

            if (parentPrio.compareTo(newNodePrio) > 0) {
                DoubleNode tempPrevious = newNode.getPrevious();
                DoubleNode tempNext = newNode.getNext();

                if (index - parentIndex == 1) {
                    System.out.println("Nodes are next to each other!");
                    if (parentNode.getPrevious() == null) {
                        this.head = newNode;
                    } else {
                        parentNode.getPrevious().setNext(newNode);
                    }

                    newNode.setNext(parentNode);
                    newNode.setPrevious(parentNode.getPrevious());

                    parentNode.setPrevious(newNode);

                    if (tempNext == null) {
                        parentNode.setNext(null);
                    }

                } else {
                    System.out.println("Does this even run");
                    if (parentNode.getPrevious() == null) {
                        this.head = newNode;
                    } else {
                        parentNode.getPrevious().setNext(newNode);
                    }

                    newNode.setNext(parentNode.getNext());
                    newNode.setPrevious(parentNode.getPrevious());

                    parentNode.setPrevious(tempPrevious);
                    parentNode.setNext(tempNext);

                    System.out.println(parentNode.getPrevious());

                    if (tempNext == null) {
                        parentNode.setNext(null);
                    }
                }

                System.out.println("Swapped " + parentPrio + " <-> " + newNodePrio);
            }

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
        int count = 0;

        while (current != null) {
            Comparable[] data = current.getElement();
            System.out.println("Key: " + data[0] + ", Value: " + data[1] + ", Index: " + count);
            current = current.getNext();
            count++;
        }
    }

    public static void main(String[] args) {
        LinkedHeapPQ pq = new LinkedHeapPQ();

        pq.add('2', 2);
        pq.add('1', 4);
        pq.add('4', 5);
        pq.add('1', 4);



        pq.traverse();;
    }
}