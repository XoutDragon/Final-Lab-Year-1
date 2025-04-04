///**
// * Tester code for Question 02 (LinkedHeapPQ) of the Final Project.
// **/
//import java.util.Scanner;
//
//public class LinkedHeapPQTester
//{
//	private static String arrayToString(Comparable[] array)
//	{
//		if(array == null)
//			return "null";
//		else if(array.length == 0)
//			return "{}";
//
//		String output = "{";
//
//		for(int i = 0; i < array.length; i++)
//			output += array[i].toString() + ", ";
//
//		output = output.substring(0, output.length() - 2) + "}";
//
//		return output;
//	}
//
//	public static void main(String[] args)
//	{
//		Scanner keyboard = new Scanner(System.in);
//		String input;
//
//		//2.1) Test the LinkedHeapPQ constructor
//		System.out.println("------------------------------------------------------------");
//		System.out.println("2.1) Test the LinkedHeapPQ constructor");
//		System.out.println("------------------------------------------------------------");
//
//		PriorityQueue pq = new LinkedHeapPQ();
//		boolean pause = true;
//
//		System.out.println("size:     0\t= " + pq.size());
//		System.out.println("empty:    true\t= " + pq.empty());
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		//2.2) Test accessing an empty LinkedHeapPQ
//		System.out.println("------------------------------------------------------------");
//		System.out.println("2.2) Test accessing an empty LinkedHeapPQ");
//		System.out.println("------------------------------------------------------------");
//
//		try
//		{
//			System.out.println("null:\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		}
//		catch(Exception e)
//		{
//			System.out.println("null:\t= null (via exception)");
//		}
//
//		try
//		{
//			System.out.println("null:\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		}
//		catch(Exception e)
//		{
//			System.out.println("null:\t= null (via exception)");
//		}
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		//2.3) Test the LinkedHeapPQ add method with ints as keys
//		System.out.println("------------------------------------------------------------");
//		System.out.println("2.3) Test the LinkedHeapPQ add method with ints keys");
//		System.out.println("------------------------------------------------------------");
//
//		pq = new LinkedHeapPQ();
//
//		pq.add(Integer.valueOf(5), Integer.valueOf(10));
//
//		System.out.println("size:     1\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {5, 10}\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(2), Integer.valueOf(1));
//
//		System.out.println("size:     2\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {2, 1}\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(23), "My Password is Taco");
//
//		System.out.println("size:     3\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {2, 1}\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(-10), "Baklava");
//
//		System.out.println("size:     4\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(0), "Should be second");
//
//		System.out.println("size:     5\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(123), "Last");
//
//		System.out.println("size:     6\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		pq.add(Integer.valueOf(-5), "Weird, right?");
//
//		System.out.println("size:     7\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(0), "Should be first");
//
//		System.out.println("size:     8\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(47), Double.valueOf(555.55));
//
//		System.out.println("size:     9\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(1), Character.valueOf('A'));
//
//		System.out.println("size:     10\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(-15), "¡Top!");
//
//		System.out.println("size:     11\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-15, ¡Top!}\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		//2.4) Test the LinkedHeapPQ min and removeMin methods
//		System.out.println("------------------------------------------------------------");
//		System.out.println("2.4) Test the LinkedHeapPQ min and removeMin methods");
//		System.out.println("------------------------------------------------------------");
//
//		System.out.println("removeMin:  {-15, ¡Top!}\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       10\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {-10, Baklava}\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {-10, Baklava}\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       9\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {-5, Weird, right?}\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {-5, Weird, right?}\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       8\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {0, Should be first}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {0, Should be first}\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       7\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {0, Should be second}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {0, Should be second}\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       6\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		System.out.println("min:        {1, A}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {1, A}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       5\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {2, 1}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {2, 1}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       4\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {5, 10}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {5, 10}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       3\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {23, My Password is Taco}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {23, My Password is Taco}\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       2\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {47, 555.55}\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {47, 555.55}\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       1\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {123, Last}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {123, Last}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       0\t\t\t\t= " + pq.size());
//		System.out.println("empty:      true\t\t\t= " + pq.empty());
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		//2.5) Test the LinkedHeapPQ add method with doubles as keys
//		System.out.println("------------------------------------------------------------");
//		System.out.println("2.5) Test the LinkedHeapPQ add method doubles as keys");
//		System.out.println("------------------------------------------------------------");
//
//		pq = new LinkedHeapPQ();
//
//		pq.add(Double.valueOf(5.0),       Integer.valueOf(10));
//		pq.add(Double.valueOf(2.15),      Integer.valueOf(1));
//		pq.add(Double.valueOf(23.5),      "My Password is Taco");
//		pq.add(Double.valueOf(-10.4),     "Baklava");
//		pq.add(Double.valueOf(0.6),       "Should be second");
//		pq.add(Double.valueOf(123.467),   "Last");
//		pq.add(Double.valueOf(-4.9),      "Weird, right?");
//		pq.add(Double.valueOf(0.6),       "Should be first");
//		pq.add(Double.valueOf(47.0),      Double.valueOf(555.55));
//		pq.add(Double.valueOf(1.0000007), Character.valueOf('A'));
//		pq.add(Double.valueOf(-14.55),    "¡Top!");
//
//		System.out.println("size:     11\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-14.55, ¡Top!}\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		System.out.println("removeMin:  {-14.55, ¡Top!}\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {-10.4, Baklava}\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {-4.9, Weird, right?}\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {0.6, Should be first}\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {0.6, Should be second}\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {1.0000007, A}\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {2.15, 1}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {5, 10}\t\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {23.5, My Password is Taco) = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {47, 555.55}\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {123.467, Last}\t\t= " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println();
//
//		System.out.println("size:     0\t= " + pq.size());
//		System.out.println("empty:    true\t= " + pq.empty());
//
//		try
//		{
//			System.out.println("min:      null\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		}
//		catch(Exception e)
//		{
//			System.out.println("min:      null\t= null (via exception)");
//		}
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		//2.6) Test the LinkedHeapPQ add method with strings as keys
//		System.out.println("------------------------------------------------------------");
//		System.out.println("2.6) Test the LinkedHeapPQ add method strings as keys");
//		System.out.println("------------------------------------------------------------");
//
//		pq.add("baklava",  Integer.valueOf(10));
//		pq.add("apescat!", Integer.valueOf(1));
//		pq.add("zoo",      "My Password is Taco");
//		pq.add("!2",       "Baklava");
//		pq.add("Apescat!", "Second");
//		pq.add("æëα",      "Last");
//		pq.add("2.7",      "Weird, right?");
//		pq.add("Apescat!", "First");
//		pq.add("åpescat!", Double.valueOf(555.55));
//		pq.add("apes",     Character.valueOf('A'));
//		pq.add("!!",       "¡Top!");
//
//		System.out.println("size:     11\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {!!, ¡Top!}\t\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		System.out.println("removeMin:  {!!, ¡Top!}\t\t       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {!2, Baklava}\t       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {2.7, Weird, right?}       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {Apescat!, First}\t       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {Apescat!, Second}\t       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {apes, A}\t\t       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {apescat!, 1}\t       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {baklava, 10}\t       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {zoo, My Password is Taco) = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {åpescat!, 555.55}\t       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {æëα, Last)\t\t       = " + LinkedHeapPQTester.arrayToString(pq.removeMin()));
//		System.out.println();
//
//		System.out.println("size:     0\t= " + pq.size());
//		System.out.println("empty:    true\t= " + pq.empty());
//
//		try
//		{
//			System.out.println("min:      null\t= " + LinkedHeapPQTester.arrayToString(pq.min()));
//		}
//		catch(Exception e)
//		{
//			System.out.println("min:      null\t= null (via exception)");
//		}
//
//		/*************************************************************************************************
//		 * THIS CODE WILL ONLY POTENTIALLY WORK IF:
//		 *		1) YOU COPY THE TEST CODE INTO YOUR MAIN METHOD; AND
//		 *		2) YOU MAKE YOUR HEAD NODE PUBLICLY VISIBLE; AND
//		 *		3) YOU ADJUST THE CODE LABELED <YOUR HEAD NODE NAME> WITH THE ACTUAL NAME OF YOUR HEAD NODE
//		 *
//		 * THERE MAY BE OTHER CHANGES THAT YOU NEED TO MAKE TO MAKE THE CODE WORK SUCH AS IMPORTING
//		 * METHODS AND CHANGING REFERENCES. THIS CODE MAY NOT WORK EVEN IF YOUR CODE IS PERFECT.
//		 *************************************************************************************************/
//		/*
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		#2.7) Try to test the underlying heap structure. MAY NOT WORK!
//		System.out.println("------------------------------------------------------------");
//		System.out.println("2.7) Try to test the underlying heap structure. MAY NOT WORK!");
//		System.out.println("------------------------------------------------------------");
//
//		pq = LinkedHeapPQ();
//
//		pq.add(Integer.valueOf(5),   Integer.valueOf(10));
//		pq.add(Integer.valueOf(20),  Integer.valueOf(1));
//		pq.add(Integer.valueOf(47),  Double.valueOf(555.55));
//		pq.add(Integer.valueOf(23),  "My Password is Taco");
//		pq.add(Integer.valueOf(0),   "Should be second");
//		pq.add(Integer.valueOf(123), "Last");
//		pq.add(Integer.valueOf(-5),  "Weird, right?");
//		pq.add(Integer.valueOf(0),   "Should be first");
//		pq.add(Integer.valueOf(-10), "Baklava");
//		pq.add(Integer.valueOf(1),   Character.valueOf('A'));
//		pq.add(Integer.valueOf(-15), "¡Top!");
//
//		DoubleNode<Comparable[]> pointer = pq.<YOUR HEAD NODE NAME>;
//
//		//############# OLD DEBUG CODE FOR THE INSTRUCTOR ONLY! #############
//		//#from Double_Node import DNode #Uncomment first and test
//		//#pointer = DNode(null, null, pointer) #Uncomment first and test
//		//#pointer.get_next().set_previous(pointer) #Uncomment second and test
//		//#tail = pointer.get_next().get_next().get_next().get_next().get_next().get_next().get_next().get_next().get_next().get_next().get_next() #Uncomment third and test
//		//#tail.set_next(DNode(null, tail)) #Uncomment third and test
//		//#tail.get_next().set_previous(tail) #Uncomment third and test
//		//#tail.get_next().set_element("WHOOPSIE DOODLE") #Uncomment last and test
//		//####################### END DEBUG CODE ########################
//
//		//If the element in the pointer is null, set a variable appropriately
//		boolean sentinelNode = (pointer.getElement() == null);
//
//		System.out.println("Going forward from the head node");
//		System.out.println("------------------------------------------------------------");
//
//		if(entinelNode)
//		{
//			System.out.println("Sentinel Node Used at Head");
//			pointer = pointer.getNext();
//		}
//
//		System.out.println("{-15, ¡Top!}\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{-10, Baklava}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{0, Should be second}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{0, Should be first}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{-5, Weird, right?}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{123, Last}\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{47, 555.55}\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{23, My Password is Taco}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{2, 1}\t\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{5, 10}\t\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getNext();
//		System.out.println("{1, A}\n\t  = " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		System.out.println("tail.getNext()\t\t= " + pointer.getNext());
//
//		if(sentinelNode)
//		{
//			if(pointer.getNext() == null)
//				System.out.println("Sentinel Node NOT Used at Tail");
//			else if(pointer.getNext().getElement() == null)
//				System.out.println("Sentinel Node Used at Tail");
//			else
//				System.out.println("POPULATED NODE WHERE THERE ONE SHOULDN'T BE");
//		}
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		System.out.println("------------------------------------------------------------");
//		System.out.println("Going backward from the tail node");
//		System.out.println("------------------------------------------------------------");
//		System.out.println("{1, A}\n\t  = " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{5, 10}\t\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{2, 1}\t\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{23, My Password is Taco}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{47, 555.55}\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{123, Last}\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{-5, Weird, right?}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{0, Should be first}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{0, Should be second}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{-10, Baklava}\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		pointer = pointer.getPrevious();
//		System.out.println("{-15, ¡Top!}\t\t= " + LinkedHeapPQTester.arrayToString(pointer.getElement()));
//		System.out.println("head.getPrevious()\t= " + pointer.getPrevious());
//
//		if(sentinelNode)
//		{
//			if(pointer.getPrevious() == null)
//				System.out.println("Sentinel Node NOT Used at Head (for some reason...)");
//			else if(pointer.getPrevious().getElement() == null)
//				System.out.println("Sentinel Node Used at Head");
//			else
//				System.out.println("POPULATED NODE WHERE THERE ONE SHOULDN'T BE");
//		}
//		*/
//	}
//}