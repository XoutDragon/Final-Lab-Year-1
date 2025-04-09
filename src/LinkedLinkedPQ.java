public class LinkedLinkedPQ implements PriorityQueue{
    private Node<Node> head;
    private int length;

    public LinkedLinkedPQ() {
        this.head = null;
        this.length = 0;
    }

    public void add(Comparable key, Comparable value) {


        this.length++;
    }

    public Comparable[] removeMin() {
        int index = 0;
        Node<Node> currNode = this.head;
        while (currNode != null) {
            if (currNode.getElement() != null) {
                Comparable[] data = new Comparable[]{index, (Comparable) currNode.getElement().getElement()};
                this.length--;
                currNode.setElement(currNode.getElement().getNext());
                return data;
            }
            index++;
            currNode = currNode.getNext();
        }

        return null;
    }

    public Comparable[] min() {
        int index = 0;
        Node<Node> currNode = this.head;

        while (currNode != null) {
            if (currNode.getElement() != null) {
                return new Comparable[]{index, (Comparable) currNode.getElement().getElement()};
            }
            index++;
            currNode = currNode.getNext();
        }

        return null;
    }

    public boolean empty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }
}
