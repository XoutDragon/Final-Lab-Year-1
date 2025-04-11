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
            DoubleNode<Comparable[]> parent = this.head;
            int parentIndex = (index - 1) >>> 1;

            for (int i = 0; i < parentIndex; i++) {
                parent = parent.getNext();
            }

            Comparable parentPrio = parent.getElement()[0];
            Comparable childPrio = child.getElement()[0];

            if (parentPrio.compareTo(childPrio) > 0) {
                _swap(parent, child);
            }

            index = parentIndex;
        }
    }


    private void _swap(DoubleNode parent, DoubleNode child) {
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

        this.tail = this.tail.getPrevious();
        this.tail.setNext(null);
        this.length--;

        _downheap();

        return min;
    }

    private void _downheap() {
        DoubleNode<Comparable[]> parent = this.head;

        int index = 0;
        int leftChildIndex = (index << 1) + 1;
        System.out.println("leftChildIndex = " + leftChildIndex);
        int rightChildIndex = (index << 1) + 2;
        System.out.println("rightChildIndex = " + rightChildIndex);

        while (index < this.length) {
            DoubleNode<Comparable[]> leftChild = this.head;
            DoubleNode<Comparable[]> rightChild = this.head;

            if (leftChildIndex < this.length) {
                for (int i = 0; i < leftChildIndex; i++)
                    leftChild = leftChild.getNext();
            }
            else {
                leftChild = null;
            }

            if (rightChildIndex < this.length) {
                for (int i = 0; i < rightChildIndex; i++)
                    rightChild = rightChild.getNext();
            } else {
                rightChild =  null;
            }

            Comparable leftChildPrio = leftChild != null ? leftChild.getElement()[0] : null;
            System.out.println("leftChildPrio = " + leftChildPrio);
            Comparable rightChildPrio = rightChild != null ? rightChild.getElement()[0] : null;
            System.out.println("rightChildPrio = " + rightChildPrio);
            Comparable parentPrio = parent.getElement()[0];
            System.out.println("parentPrio = " + parentPrio);

            if ((leftChild != null && rightChild == null) || leftChildPrio.compareTo(rightChildPrio) <= 0) {
                if (parentPrio.compareTo(leftChildPrio) <= 0) {
                    break;
                }

                _swap(parent, leftChild);

                index = leftChildIndex;
            } else if ((leftChild == null && rightChild != null) || leftChildPrio.compareTo(rightChildPrio) > 0){
                System.out.println("Does this run");
                if (parentPrio.compareTo(rightChildPrio) <= 0) {
                    break;
                }

                _swap(parent, rightChild);

                index = rightChildIndex;
            } else {
                break;
            }
        }


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
        System.out.println('\n');
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
        pq.traverse();

        pq.removeMin();
        pq.traverse();
    }
}