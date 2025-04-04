public interface PriorityQueue
{
	// Adds value to the priority queue with the associated key value. Values
    //   will be returned arbitrarily based on having the minimum key value
    //   remaining in the priority queue.
    public void add(Comparable key, Comparable value);

    // Removes and returns a (key, value) pair with a minimum key value in the
    //   priority queue. Values will be returned arbitrarily based on having
    //   the minimum key value remaining in the priority queue.
    public Comparable[] removeMin();

    // Returns a (key, value) pair with a minimum key value in the
    //   priority queue. Values will be returned arbitrarily based on having
    //   the minimum key value remaining in the priority queue.
    public Comparable[] min();

    // Returns True if there are not any elements in the priority queue,
    //   False otherwise
    public boolean empty();
   
    // Returns the number of elements in the priority queue
    public int size();
}