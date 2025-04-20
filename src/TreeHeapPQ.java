import java.util.ArrayList;
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
            this.length++;
            BinaryNode<Comparable[]> node = new BinaryNode<Comparable[]>(data);
            _insertToEnd(this.root, node, 1, _log2(this.length));
            _upheap(node);
        }
    }

    private void _upheap(BinaryNode<Comparable[]> newNode) {
        while (newNode.getParent() != null) {
            BinaryNode<Comparable[]> parent = newNode.getParent();
            if (parent.getElement()[0].compareTo(newNode.getElement()[0]) <= 0) {
                break;
            }

            _swap(parent, newNode);
        }
    }


    private boolean _insertToEnd(BinaryNode<Comparable[]> currNode, BinaryNode<Comparable[]> newNode, int level, int height) {
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
            inserted = _insertToEnd(currNode.getLeft(), newNode, level+1, height);
            if (inserted) return true;
        }

        if (currNode.getRight() != null) {
            inserted = _insertToEnd(currNode.getRight(), newNode, level+1, height);
            if (inserted) return true;
        }

        return inserted;
    }

    private int _log2(int num) {
        return (int) (Math.floor(Math.log(num) / Math.log(2)));
    }

    private void _swap(BinaryNode<Comparable[]> parent, BinaryNode<Comparable[]> child) {

        //System.out.println("Swapping: Parent:" + parent.getElement()[1] + " and Child:" + child.getElement()[1]);

        BinaryNode<Comparable[]> parentParent = parent.getParent();
        //.out.println("parentParent = " + (parentParent != null ? parentParent.getElement()[1] : null));
        BinaryNode<Comparable[]> parentLeft = parent.getLeft();
        //System.out.println("parentLeft = " + (parentLeft != null ? parentLeft.getElement()[1] : null));
        BinaryNode<Comparable[]> parentRight = parent.getRight();
        //System.out.println("parentRight = " + (parentRight != null ? parentRight.getElement()[1]: null));

        BinaryNode<Comparable[]> childParent = child.getParent();
        //System.out.println("childParent = " + (childParent != null ? childParent.getElement()[1] : null));
        
        BinaryNode<Comparable[]> childLeft = child.getLeft();
        //System.out.println("childLeft = " + (childLeft != null ? childLeft.getElement()[1] : null));
        BinaryNode<Comparable[]> childRight = child.getRight();
        //System.out.println("childRight = " + (childRight != null ? childRight.getElement()[1] : null));
        System.out.println();

        // UPDATE PARENTS PARENT WITH CHILD
        if (parentParent != null) {
            if (parentParent.getLeft() == parent) {
                parentParent.setLeft(child);
            } else if (parentParent.getRight() == parent) {
                parentParent.setRight(child);
            }
        }

        // IF PARENT AND CHILD ARE ADJACENT
        if (parentLeft == child || parentRight == child) {
            if (parentLeft == child) {
                child.setLeft(parent);
                child.setRight(parentRight);
                if (parentRight != null) {
                    parentRight.setParent(child);
                }
            } else {
                child.setRight(parent);
                child.setLeft(parentLeft);
                if (parentLeft != null) {
                    parentLeft.setParent(child);
                }
            }
            parent.setParent(child);
        }
        // NOT ADJACENT
        else {
            parent.setParent(childParent);

            if (childParent.getLeft() == child) {
                child.setLeft(parent);
            }
            if (childParent.getRight() == child) {
                child.setRight(parent);
            }

            child.setLeft(parentLeft);
            child.setRight(parentRight);
        }

        //UPDATE CHILDS PARENT WITH PARENTS PARENT
        child.setParent(parentParent);

        //UPDATE PARENTS CHILDS WITH CHILDS CHILD
        parent.setRight(childRight);
        parent.setLeft(childLeft);

        // UPDATE CHILDS CHILDS WITH PARENT
        if (childLeft != null) {
            childLeft.setParent(parent);
        }
        if (childRight != null) {
            childRight.setParent(parent);
        }

        if (child.getParent() == null) {
            this.root = child;
        }
    }


    public Comparable[] removeMin() {
        if (this.root == null) {
            return null;
        }

        Comparable[] min = this.min();

        BinaryNode<Comparable[]> removedNode = this.root;


        if (this.length > 1) {
            BinaryNode<Comparable[]> latestNode = _getLatestNode();
            _swap(removedNode, latestNode);
        }

        if (removedNode != this.root) {
            if (removedNode.getParent().getLeft() == removedNode) {
                removedNode.getParent().setLeft(null);

            } else {
                removedNode.getParent().setRight(null);
            }
            removedNode.setParent(null);
            _downheap();
        } else {
            this.root = null;
        }

        this.length--;

        return min;
    }

    private void _downheap() {
        BinaryNode<Comparable[]> newNode = this.root;

        while (newNode.getRight() != null || newNode.getLeft() != null) {
            Comparable leftChildPrio = newNode.getLeft() != null ? newNode.getLeft().getElement()[0] : null;
            Comparable rightChildPrio = newNode.getRight() != null ? newNode.getRight().getElement()[0] : null;
            Comparable parentPrio = newNode.getElement()[0];


            if (leftChildPrio != null && rightChildPrio == null) {
                if (parentPrio.compareTo(leftChildPrio) <= 0) {
                    break;
                }
                _swap(newNode, newNode.getLeft());
                continue;
            }

            if (leftChildPrio.compareTo(rightChildPrio) <= 0) {
                if (parentPrio.compareTo(leftChildPrio) <= 0) {
                    break;
                }
                _swap(newNode, newNode.getLeft());
            } else {
                if (parentPrio.compareTo(rightChildPrio) <= 0) {
                    break;
                }
                _swap(newNode, newNode.getRight());
            }
        }
    }

    private BinaryNode<Comparable[]> _getLatestNode() {
        ArrayList<BinaryNode> nodes = new ArrayList();
        LinkedList<BinaryNode> temp = new LinkedList();

        temp.add(this.root);
        nodes.add(this.root);


        while (!temp.isEmpty()) {
            BinaryNode node = temp.remove();

            if (node.getLeft() != null) {
                nodes.add(node.getLeft());
                temp.add(node.getLeft());
            }

            if (node.getRight() != null) {
                nodes.add(node.getRight());
                temp.add(node.getRight());
            }
        }
        return nodes.getLast();
    }

    public Comparable[] min() {
        return root != null ? root.getElement() : null;
    }

    public boolean empty() {
        return this.length == 0;
    }

    public int size() {
        return this.length;
    }

    public void printTree() {
        if (this.root == null) {
            System.out.println("Nothing in tree");
            return;
        }

        LinkedList<BinaryNode> nodeQueue = new LinkedList();
        LinkedList<Integer> levelQueue = new LinkedList();

        nodeQueue.add(this.root);
        levelQueue.add(Integer.valueOf(0));

        while (!nodeQueue.isEmpty()) {
            BinaryNode<Comparable[]> node = nodeQueue.remove();
            Integer level = levelQueue.remove();

            System.out.println("Level: " + level + " Key: " + node.getElement()[0] + " Value: " + node.getElement()[1]);

            if (node.getLeft() != null) {
                nodeQueue.add(node.getLeft());
                levelQueue.add(level + 1);
            }
            if (node.getRight() != null) {
                nodeQueue.add(node.getRight());
                levelQueue.add(level + 1);
            }
        }
    }

    public static void main(String[] args) {

        TreeHeapPQ pq = new TreeHeapPQ();

        pq.add(Integer.valueOf(5), Integer.valueOf(10));
        pq.add(Integer.valueOf(2), Integer.valueOf(1));
        pq.add(Integer.valueOf(23), "My Password is Taco");
        pq.add(Integer.valueOf(-10), "Baklava");
//        pq.add(Integer.valueOf(0), "Should be second");
//        pq.add(Integer.valueOf(123), "Last");
//        pq.add(Integer.valueOf(-5), "Weird, right?");
//        pq.add(Integer.valueOf(0), "Should be first");
//        pq.add(Integer.valueOf(47), Double.valueOf(555.55));
//        pq.add(Integer.valueOf(1), Character.valueOf('A'));
//        pq.add(Integer.valueOf(-15), "¡Top!");

        pq.printTree();
        System.out.println();
        System.out.println(pq.removeMin()[1]);

        //System.out.println(pq.root.getLeft().getLeft().getLeft().getLeft().getLeft().getElement()[1]);

        //pq.printTree();
    }
}
