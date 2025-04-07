import java.util.Arrays;

public class TreeHeapPQ implements PriorityQueue{
    private BinaryNode<Comparable[]> root;
    private int length;

    public TreeHeapPQ() {
        this.root = null;
        this.length = 0;
    }


    public void add(Comparable key, Comparable value) {
        Comparable[] data = new Comparable[]{key, value};

        if (this.root == null) {
            this.root = new BinaryNode<Comparable[]>(data);

            this.length++;
        } else {

        }
    }

    public Comparable[] removeMin() {
        return null;
    }

    public Comparable[] min() {
        return root.getElement();
    }

    public boolean empty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }

    public static void main(String[] args) {
        TreeHeapPQ e = new TreeHeapPQ();
        e.add(0, "idk do this");

        System.out.println(Arrays.toString(e.min()));

        System.out.println(Math.ceil(Math.log(12)/Math.log(2)));
    }
}
