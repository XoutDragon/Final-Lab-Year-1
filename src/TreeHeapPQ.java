import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;


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
            this.root = new BinaryNode<>(data);

            this.length++;
        } else {
            BinaryNode<Comparable[]> node = new BinaryNode<Comparable[]>(data);
            _insertion(this.root, node, 1, _log2(this.length-1));

//            while (node.getParent() != null) {
//
//                BinaryNode<Comparable[]> parent = node.getParent();
//
//                if (node.getElement()[0].compareTo(parent.getElement()[0]) <= 0) {
//                    System.out.println(Arrays.toString(node.getElement()) + Arrays.toString(parent.getElement()) + "No swap");
//                    break;
//                }
//                System.out.println(Arrays.toString(node.getElement()) + Arrays.toString(parent.getElement()) + "swap");
//                BinaryNode tempRight = node.getRight();
//                BinaryNode tempLeft = node.getLeft();
//
//                node.setRight(parent.getRight());
//                node.setLeft(parent.getLeft());
//                node.setParent(parent.getParent());
//
//                parent.setParent(node);
//                parent.setRight(tempRight);
//                parent.setLeft(tempLeft);
//            }

            this.length++;
        }
    }

    private int _log2(int num) {
        return (int) (Math.ceil(Math.log(num) / Math.log(2)));
    }


    private boolean _insertion(BinaryNode<Comparable[]> currNode, BinaryNode<Comparable[]> newNode, int level, int height) {
        if (level > height) return false;

        if (level == height && currNode.getLeft() == null) {
            currNode.setLeft(newNode);
            newNode.setParent(currNode);
            return true;
        }

        if (level == height && currNode.getRight() == null) {
            currNode.setRight(newNode);
            newNode.setParent(currNode);
            return true;
        }

        boolean inserted = false;

        if (currNode.getLeft() != null) {
            inserted = _insertion(currNode.getLeft(), newNode, level+1, height);
            if (inserted) return true;
        }

        if (currNode.getRight() != null) {
            inserted = _insertion(currNode.getRight(), newNode, level+1, height);
            if (inserted) return true;
        }

        return inserted;
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

    public void printTree() {
        if (root == null) {
            System.out.println("Tree is empty.");
            return;
        }

        Queue<BinaryNode<Comparable[]>> nodeQueue = new LinkedList<>();
        Queue<Integer> levelQueue = new LinkedList<>();

        nodeQueue.add(root);
        levelQueue.add(0); // root is at level 0

        while (!nodeQueue.isEmpty()) {
            BinaryNode<Comparable[]> current = nodeQueue.poll();
            int level = levelQueue.poll();

            Comparable[] data = current.getElement();
            System.out.println("Level " + level + " - Key: " + data[0] + ", Value: " + data[1]);

            if (current.getLeft() != null) {
                nodeQueue.add(current.getLeft());
                levelQueue.add(level + 1);
            }

            if (current.getRight() != null) {
                nodeQueue.add(current.getRight());
                levelQueue.add(level + 1);
            }
        }
    }

    public static void main(String[] args) {
        TreeHeapPQ e = new TreeHeapPQ();
        e.add(0, "idk do this");
        e.add(0, "a"); // root
        e.add(1, "b"); // level 1 left
        e.add(2, "c"); // level 1 right
        e.add(3, "d"); // level 2 left of left
        e.add(4, "e"); // level 2 right of left
        e.add(5, "f"); // level 2 left of right
        e.add(6, "g"); // level 2 right of right (last complete node at height 2)        System.out.println(Arrays.toString(e.min()));
        e.add(0, "aaaa"); // root
        e.add(0, "aaaa"); // root
        e.add(4, "aaaa"); // root
        e.add(2, "aaaa"); // root
        e.add(4, "aaaa"); // root
        e.add(0, "aaaa"); // root
        e.add(0, "aaaa"); // root
        e.add(7, "ba"); // root
        e.add(3, "aaaa"); // root
        e.add(15, "aa"); // root
        e.add(11, "aaaaaaa"); // root
        e.add(8, "aaaa"); // root

        e.printTree();
    }
}
