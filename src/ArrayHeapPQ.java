import java.util.Scanner;

//----------------------------PRIVATE ITEM CLASS----------------------------
class Item implements Comparable
{
	private Comparable key;
	private	Comparable item;
	
	public Item(Comparable key, Comparable item)
	{
		this.key  = key;
		this.item = item;
	}
	
	public Item(Item itemToCopy)
	{
		this.key  = itemToCopy.getKey();
		this.item = itemToCopy.getValue();
	}
	
	public Comparable getKey()
	{
		return this.key;
	}
	
	public Comparable getValue()
	{
		return this.item;
	}
	
	public int compareTo(Object other)
	{
		return this.key.compareTo(((Item) other).getKey());
	}
	
	public String toString()
	{
		return "[Key: " + this.getKey().toString() + "; Value: " + this.getValue().toString() + "]";
	}
}


public class ArrayHeapPQ implements PriorityQueue
{
	private final static double GROWTH_RATIO = 1.5;
	private final static int INITIAL_SIZE = 4;
	
	private Item[] data;
	private int count;

	//---------------------------HEAP HELPER METHODS----------------------------
	private static int leftChildIndex(int index)
	{
        return (index * 2) + 1;
	}

    private static int rightChildIndex(int index)
	{
        return (index * 2) + 2;
	}

    private static int parentIndex(int index)
	{
        return (index - 1) >>> 1;
	}

    private boolean hasLeft(int index)
	{
        return ArrayHeapPQ.leftChildIndex(index) < this.size();
	}

    private boolean hasRight(int index)
	{
        return ArrayHeapPQ.rightChildIndex(index) < this.size();
	}

    private boolean hasParent(int index)
	{
        return index > 0;
	}

    private void swap(int index1, int index2)
	{
        Item temp;

        temp = this.data[index1];
        this.data[index1] = this.data[index2];
        this.data[index2] = temp;
	}

    private void upheap(int index)
	{
        int parentIndex = this.parentIndex(index);

        //if(this.hasParent(index) && this.data[index].get_key() < this.data[parentIndex].get_key())
        if(this.hasParent(index) && this.data[index].compareTo(this.data[parentIndex]) < 0)
		{
            this.swap(index, parentIndex);
            this.upheap(parentIndex);
		}
	}

    private void downheap(int index)
	{
        if(this.hasLeft(index))
		{
            int minIndex   = this.leftChildIndex(index);
            int rightIndex = this.rightChildIndex(index);

            //if(this.hasRight(index) && this.data[rightIndex].getKey() < self._data[minIndex].getKey())
            if(this.hasRight(index) && this.data[rightIndex].compareTo(this.data[minIndex]) < 0)
                minIndex = rightIndex;

            //if(this.data[minIndex].getKey() < self._data[index].getKey())
            if(this.data[minIndex].compareTo(this.data[index]) < 0)
			{
                this.swap(index, minIndex);
                this.downheap(minIndex);
			}
		}
	}

	//---------------------------ARRAY HELPER METHODS---------------------------
	private void resize(int capacity)
	{
		//I) If the underlying array is smaller than the capacity
		if(this.data.length < capacity)
		{
			//A) Create a new array at the specified capacity
			Item[] newArray = new Item[capacity];
			
			//B) Copy each populated element
			for(int i = 0; i < this.data.length; i++)
				newArray[i] = new Item(this.data[i]);
			
			//C) Overwrite the old array with the new array
			this.data = newArray;
		}
	}
		
	private static String arrayToString(Comparable[] array)
	{
		if(array == null)
			return "null";
		else if(array.length == 0)
			return "{}";
		
		String output = "{";
		
		for(int i = 0; i < array.length; i++)
			output += array[i].toString() + ", ";
		
		output = output.substring(0, output.length() - 2) + "}";
		
		return output;
	}
	
	//--------------------------PRIORITY QUEUE METHODS--------------------------
	public ArrayHeapPQ()
	{
		data = new Item[ArrayHeapPQ.INITIAL_SIZE];
		count = 0;
	}

	// Adds value to the priority queue with the associated key value. Values
    //   will be returned arbitrarily based on having the minimum key value
    //   remaining in the priority queue.
    public void add(Comparable key, Comparable value)
	{
		if(this.count == this.data.length)
			this.resize(((int) (this.count * ArrayHeapPQ.GROWTH_RATIO)) + 1);
		
		this.data[this.count] = new Item(key, value);
		this.upheap(this.count);
		count++;
	}

    // Removes and returns a (key, value) pair with a minimum key value in the
    //   priority queue. Values will be returned arbitrarily based on having
    //   the minimum key value remaining in the priority queue.
    public Comparable[] removeMin()
	{
		//I) Grab the data in the root as an array
		Comparable[] returnValue = this.min();
		
		//II) Swap root with the most recently added leaf
		this.swap(0, this.count - 1);

		//III) Destroy the most recently added leaf
		this.data[this.count - 1] = null;
		
		//IV) Decrement the number of elements in the heap
		count--;
		
		//V) Downheap from the root
		this.downheap(0);
		
		//VI) Return the held return value
		return returnValue;
	}

    // Returns a (key, value) pair with a minimum key value in the
    //   priority queue. Values will be returned arbitrarily based on having
    //   the minimum key value remaining in the priority queue.
    public Comparable[] min()
	{
		Comparable[] returnValue = new Comparable[2];
		
		returnValue[0] = this.data[0].getKey();
		returnValue[1] = this.data[0].getValue();
		
		return returnValue;
	}

    // Returns true if there are not any elements in the priority queue,
    //   false otherwise
    public boolean empty()
	{
		return this.size() == 0;
	}
   
    // Returns the number of elements in the priority queue
    public int size()
	{
		return this.count;
	}
	
	//------------------------------TESTER METHOD-------------------------------
	public static void main(String[] args)
	{
		Item i1 = new Item(Integer.valueOf(1), Integer.valueOf(1));
		Item i2 = new Item(Integer.valueOf(2), Integer.valueOf(2));
		
		System.out.println(i1.compareTo(i2));
		System.out.println(i2.compareTo(i1));
		System.out.println(i1.compareTo(i1));
		System.out.println(i2.compareTo(i2));
		System.out.println();
		
		System.out.println(i1);
		System.out.println(i2);
		System.out.println();
		
		Item i3 = new Item(i1);
		System.out.println(i3);
		
		Scanner keyboard = new Scanner(System.in);
		String input;
		
		//2.1) Test the ArrayHeapPQ constructor
		System.out.println("------------------------------------------------------------");
		System.out.println("2.1) Test the ArrayHeapPQ constructor");
		System.out.println("------------------------------------------------------------");

		PriorityQueue pq = new ArrayHeapPQ();
		boolean pause = true;

		System.out.println("size:     0\t= " + pq.size());
		System.out.println("empty:    true\t= " + pq.empty());

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		//2.2) Test accessing an empty ArrayHeapPQ
		System.out.println("------------------------------------------------------------");
		System.out.println("2.2) Test accessing an empty ArrayHeapPQ");
		System.out.println("------------------------------------------------------------");

		try
		{
			System.out.println("null:\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		}
		catch(Exception e)
		{
			System.out.println("null:\t= null (via exception)");
		}

		try
		{
			System.out.println("null:\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		}
		catch(Exception e)
		{
			System.out.println("null:\t= null (via exception)");
		}

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();
			
		//2.3) Test the ArrayHeapPQ add method with ints as keys
		System.out.println("------------------------------------------------------------");
		System.out.println("2.3) Test the ArrayHeapPQ add method with ints keys");
		System.out.println("------------------------------------------------------------");

		pq = new ArrayHeapPQ();

		pq.add(Integer.valueOf(5), Integer.valueOf(10));

		System.out.println("size:     1\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {5, 10}\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(2), Integer.valueOf(1));

		System.out.println("size:     2\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {2, 1}\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(23), "My Password is Taco");

		System.out.println("size:     3\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {2, 1}\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(-10), "Baklava");

		System.out.println("size:     4\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {-10, Baklava}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(0), "Should be second");

		System.out.println("size:     5\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {-10, Baklava}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(123), "Last");

		System.out.println("size:     6\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {-10, Baklava}\t= " + ArrayHeapPQ.arrayToString(pq.min()));

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		pq.add(Integer.valueOf(-5), "Weird, right?");

		System.out.println("size:     7\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {-10, Baklava}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(0), "Should be first");

		System.out.println("size:     8\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {-10, Baklava}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(47), Double.valueOf(555.55));

		System.out.println("size:     9\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {-10, Baklava}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(1), Character.valueOf('A'));

		System.out.println("size:     10\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {-10, Baklava}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(-15), "¡Top!");

		System.out.println("size:     11\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {-15, ¡Top!}\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		//2.4) Test the ArrayHeapPQ min and removeMin methods
		System.out.println("------------------------------------------------------------");
		System.out.println("2.4) Test the ArrayHeapPQ min and removeMin methods");
		System.out.println("------------------------------------------------------------");

		System.out.println("removeMin:  {-15, ¡Top!}\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       10\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {-10, Baklava}\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {-10, Baklava}\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       9\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {-5, Weird, right?}\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {-5, Weird, right?}\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       8\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {0, Should be first}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {0, Should be first}\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       7\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {0, Should be second}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {0, Should be second}\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       6\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		System.out.println("min:        {1, A}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {1, A}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       5\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {2, 1}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {2, 1}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       4\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {5, 10}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {5, 10}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       3\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {23, My Password is Taco}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {23, My Password is Taco}\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       2\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {47, 555.55}\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {47, 555.55}\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       1\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {123, Last}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println("removeMin:  {123, Last}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("size:       0\t\t\t\t= " + pq.size());
		System.out.println("empty:      true\t\t\t= " + pq.empty());

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		//2.5) Test the ArrayHeapPQ add method with doubles as keys
		System.out.println("------------------------------------------------------------");
		System.out.println("2.5) Test the ArrayHeapPQ add method doubles as keys");
		System.out.println("------------------------------------------------------------");

		pq = new ArrayHeapPQ();

		pq.add(Double.valueOf(5.0), Integer.valueOf(10));
		pq.add(Double.valueOf(2.15), Integer.valueOf(1));
		pq.add(Double.valueOf(23.5), "My Password is Taco");
		pq.add(Double.valueOf(-10.4), "Baklava");
		pq.add(Double.valueOf(0.6), "Should be second");
		pq.add(Double.valueOf(123.467), "Last");
		pq.add(Double.valueOf(-4.9), "Weird, right?");
		pq.add(Double.valueOf(0.6), "Should be first");
		pq.add(Double.valueOf(47.0), Double.valueOf(555.55));
		pq.add(Double.valueOf(1.0000007), Character.valueOf('A'));
		pq.add(Double.valueOf(-14.55), "¡Top!");

		System.out.println("size:     11\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {-14.55, ¡Top!}\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		System.out.println("removeMin:  {-14.55, ¡Top!}\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {-10.4, Baklava}\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {-4.9, Weird, right?}\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {0.6, Should be first}\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {0.6, Should be second}\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {1.0000007, A}\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {2.15, 1}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {5, 10}\t\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {23.5, My Password is Taco) = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {47, 555.55}\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {123.467, Last}\t\t= " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println();

		System.out.println("size:     0\t= " + pq.size());
		System.out.println("empty:    true\t= " + pq.empty());

		try
		{
			System.out.println("min:      null\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		}
		catch(Exception e)
		{
			System.out.println("min:      null\t= null (via exception)");
		}

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		//2.6) Test the ArrayHeapPQ add method with strings as keys
		System.out.println("------------------------------------------------------------");
		System.out.println("2.6) Test the ArrayHeapPQ add method strings as keys");
		System.out.println("------------------------------------------------------------");

		pq.add("baklava", Integer.valueOf(10));
		pq.add("apescat!", Integer.valueOf(1));
		pq.add("zoo", "My Password is Taco");
		pq.add("!2", "Baklava");
		pq.add("Apescat!", "Second");
		pq.add("æëα", "Last");
		pq.add("2.7", "Weird, right?");
		pq.add("Apescat!", "First");
		pq.add("åpescat!", Double.valueOf(555.55));
		pq.add("apes", Character.valueOf('A'));
		pq.add("!!", "¡Top!");

		System.out.println("size:     11\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {!!, ¡Top!}\t\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		System.out.println();

		System.out.println("removeMin:  {!!, ¡Top!}\t\t       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {!2, Baklava}\t       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {2.7, Weird, right?}       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {Apescat!, First}\t       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {Apescat!, Second}\t       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {apes, A}\t\t       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {apescat!, 1}\t       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {baklava, 10}\t       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {zoo, My Password is Taco) = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {åpescat!, 555.55}\t       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println("removeMin:  {æëα, Last)\t\t       = " + ArrayHeapPQ.arrayToString(pq.removeMin()));
		System.out.println();

		System.out.println("size:     0\t= " + pq.size());
		System.out.println("empty:    true\t= " + pq.empty());

		try
		{
			System.out.println("min:      null\t= " + ArrayHeapPQ.arrayToString(pq.min()));
		}
		catch(Exception e)
		{
			System.out.println("min:      null\t= null (via exception)");
		}
	}
}