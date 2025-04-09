import java.util.ArrayList;

public class TwoDListPQ implements PriorityQueue{
    private ArrayList<ArrayList<Comparable>> queue;
    private int length;

    public TwoDListPQ() {
        this.queue = new ArrayList();
        this.length = 0;
    }

    public void add(Comparable key, Comparable value) {
        while (queue.size() < (int) key + 1) {
            queue.add(new ArrayList<Comparable>());
        }

        queue.get((int) key).add(value);
        this.length++;
    }

    public Comparable[] removeMin() {
        for (int i = 0; i < queue.size(); i++) {
            if (!queue.get(i).isEmpty()) {
                this.length--;
                return new Comparable[]{i, queue.get(i).removeFirst()};
            }
        }
        return null;
    }

    public Comparable[] min() {
        for (int i = 0; i < queue.size(); i++) {
            if (!queue.get(i).isEmpty()) {
                return new Comparable[]{i, queue.get(i).getFirst()};
            }
        }
        return null;
    }

    public boolean empty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }

    public static void main(String[] args) {
        TwoDListPQ e = new TwoDListPQ();
        e.add(1, "2");
        e.add(1, "2");
        e.add(1, "2");
        e.add(2, "2");

    }
}
