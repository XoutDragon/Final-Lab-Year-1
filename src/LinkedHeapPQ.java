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

            _upheap();
        }
    }

    private void _upheap() {
        int index = this.length - 1;

        DoubleNode<Comparable[]> child = this.tail;

        while (index > 0) {
            int parentIndex = (index - 1) >>> 1;
            DoubleNode<Comparable[]> parent = _getNode(parentIndex);

            Comparable parentPrio = parent.getElement()[0];
            Comparable childPrio = child.getElement()[0];

            if (parentPrio.compareTo(childPrio) > 0) {
                _swap(parent, child);
            }

            index = parentIndex;
        }
    }


    private void _swap(DoubleNode parent, DoubleNode child) {
        if (parent.getPrevious() == null && parent.getNext() == null) {
            this.head = null;
            this.tail = null;
            return;
        }

        DoubleNode parentPrev = parent.getPrevious();
        DoubleNode parentNext = parent.getNext();

        DoubleNode childPrev = child.getPrevious();
        DoubleNode childNext = child.getNext();

        if (parent.getNext() == child) {
            if (parentPrev != null) {
                parentPrev.setNext(child);
            } else {
                this.head = child;
            }
            child.setPrevious(parentPrev);

            child.setNext(parent);
            parent.setPrevious(child);

            parent.setNext(childNext);

            if (childNext != null) {
                childNext.setPrevious(parent);
            } else {
                this.tail = parent;
            }
        }
        else {
            if (parentPrev != null) {
                parentPrev.setNext(child);
            } else {
                this.head = child;
            }
            child.setPrevious(parentPrev);
            parentNext.setPrevious(child);
            child.setNext(parentNext);
            childPrev.setNext(parent);
            parent.setPrevious(childPrev);

            if (childNext != null) {
                childNext.setPrevious(parent);
            } else {
                this.tail = parent;
            }
            parent.setNext(childNext);
        }

    }

    public Comparable[] removeMin() {
        Comparable[] min = this.min();

        _swap(this.head, this.tail);

        if (this.tail != null) {
            this.tail = this.tail.getPrevious();
            this.tail.setNext(null);
        }
        this.length--;

        _downheap();

        return min;
    }

    private void _downheap() {
        DoubleNode<Comparable[]> parent = this.head;

        int index = 0;
        while (index < this.length) {
            int leftChildIndex = (index << 1) + 1;
            int rightChildIndex = (index << 1) + 2;

            DoubleNode<Comparable[]> leftChild = _getNode(leftChildIndex);
            DoubleNode<Comparable[]> rightChild = _getNode(rightChildIndex);

            Comparable parentPrio = parent.getElement()[0];

            DoubleNode<Comparable[]> smallerNode;

            if (leftChild == null && rightChild == null) break;
            else if (leftChild != null && rightChild != null) {
                Comparable leftPrio = leftChild.getElement()[0];
                Comparable rightPrio = rightChild.getElement()[0];
                smallerNode = (leftPrio.compareTo(rightPrio) <= 0) ? leftChild : rightChild;
                index = (leftPrio.compareTo(rightPrio) <= 0) ? leftChildIndex : rightChildIndex;
            } else if (leftChild != null) {
                smallerNode = leftChild;
                index = leftChildIndex;
            } else {
                smallerNode = rightChild;
                index = rightChildIndex;
            }
            Comparable childPrio = smallerNode.getElement()[0];

            if (parentPrio.compareTo(childPrio) <= 0) break;

            _swap(parent, smallerNode);
        }
    }

    private DoubleNode<Comparable[]> _getNode(int index) {
        if (index >= this.length) return null;
        DoubleNode node = this.head;

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }

        return node;
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


    public static void main(String[] args) {

        LinkedHeapPQ pq = new LinkedHeapPQ();

        pq.add(Integer.valueOf(5), Integer.valueOf(10));
        pq.add(Integer.valueOf(2), Integer.valueOf(1));
        pq.add(Integer.valueOf(23), "My Password is Taco");
        pq.add(Integer.valueOf(-10), "Baklava");
        pq.add(Integer.valueOf(0), "Should be second");
        pq.add(Integer.valueOf(123), "Last");
        pq.add(Integer.valueOf(-5), "Weird, right?");
        pq.add(Integer.valueOf(0), "Should be first");

        pq.removeMin();
    }
}