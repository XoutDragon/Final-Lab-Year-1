public class LinkedLinkedPQ implements PriorityQueue {
    private Node<Node> head;
    private int length;

    public LinkedLinkedPQ() {
        this.head = null;
        this.length = 0;
    }

    public void add(Comparable key, Comparable value) {

        if (this.head == null) {
            this.head = new Node(new Node(value), null, key);
            this.length++;
            return;
        }

        Node<Node> currNode = this.head;
        Node<Node> prevNode = null;

        while (currNode != null) {
            if (key.equals(currNode.getKey())) {
                if (currNode.getElement() != null)
                    currNode.getElement().setNext(new Node(value));
                else
                    currNode.setElement(new Node(value));
                break;
            }
            if (currNode.getNext() == null && key.compareTo(currNode.getKey()) > 0) {
                currNode.setNext(new Node(new Node(value), null, key));
                break;
            } else if (prevNode == null && key.compareTo(currNode.getKey()) < 0) {
                this.head = new Node(new Node(value), this.head, key);
                break;
            } else if (
                    prevNode != null
                    && key.compareTo(prevNode.getKey()) > 0
                    && key.compareTo(currNode.getKey()) < 0
            ) {
                prevNode.setNext(new Node(new Node(value), currNode, key));
                break;
            }

            prevNode = currNode;
            currNode = currNode.getNext();
        }

        this.length++;
    }


    public Comparable[] removeMin() {
        if (this.head == null) return null;

        Comparable[] data = new Comparable[]{this.head.getKey(), (Comparable) this.head.getElement().getElement()};

        this.head = new Node<Node>(this.head.getElement().getNext(), this.head.getNext(), this.head.getKey());

        if (this.head.getElement() == null) {
            this.head = this.head.getNext();
        }

        this.length--;

        return data;
    }


    public Comparable[] min() {
        if (this.head == null) return null;

        Comparable[] data = new Comparable[]{this.head.getKey(), (Comparable) this.head.getElement().getElement()};

        return data;
    }

    public boolean empty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }

}
