///**
// * Tester code for Question 05 (LinkedLinkedPQ) of the Final Project.
// **/
//import java.util.Scanner;
//
//public class LinkedLinkedPQTester
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
//		//10.1) Test the LinkedLinkedPQ constructor
//		System.out.println("------------------------------------------------------------");
//		System.out.println("10.1) Test the LinkedLinkedPQ constructor");
//		System.out.println("------------------------------------------------------------");
//
//		PriorityQueue pq = new LinkedLinkedPQ();
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
//		//10.2) Test accessing an empty LinkedLinkedPQ
//		System.out.println("------------------------------------------------------------");
//		System.out.println("10.2) Test accessing an empty LinkedLinkedPQ");
//		System.out.println("------------------------------------------------------------");
//
//		try
//		{
//			System.out.println("null:\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		}
//		catch(Exception e)
//		{
//			System.out.println("null:\t= null (via exception)");
//		}
//
//		try
//		{
//			System.out.println("null:\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
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
//		//10.3) Test the LinkedLinkedPQ add method with ints as keys
//		System.out.println("------------------------------------------------------------");
//		System.out.println("10.3) Test the LinkedLinkedPQ add method with ints keys");
//		System.out.println("------------------------------------------------------------");
//
//		pq = new LinkedLinkedPQ();
//
//		pq.add(Integer.valueOf(5), Integer.valueOf(10));
//
//		System.out.println("size:     1\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {5, 10}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(2), Integer.valueOf(1));
//
//		System.out.println("size:     2\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {2, 1}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(23), "My Password is Taco");
//
//		System.out.println("size:     3\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {2, 1}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(-10), "Baklava");
//
//		System.out.println("size:     4\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(0), "Should be second");
//
//		System.out.println("size:     5\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(123), "Last");
//
//		System.out.println("size:     6\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
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
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(0), "Should be first");
//
//		System.out.println("size:     8\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(47), Double.valueOf(555.55));
//
//		System.out.println("size:     9\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(1), Character.valueOf('A'));
//
//		System.out.println("size:     10\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-10, Baklava}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		pq.add(Integer.valueOf(-15), "¡Top!");
//
//		System.out.println("size:     11\t\t\t= " + pq.size());
//		System.out.println("empty:    false\t\t\t= " + pq.empty());
//		System.out.println("min:      {-15, ¡Top!}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		//10.4) Test the LinkedLinkedPQ min and removeMin methods
//		System.out.println("------------------------------------------------------------");
//		System.out.println("10.4) Test the LinkedLinkedPQ min and removeMin methods");
//		System.out.println("------------------------------------------------------------");
//
//		System.out.println("removeMin:  {-15, ¡Top!}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       10\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {-10, Baklava}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {-10, Baklava}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       9\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {-5, Weird, right?}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {-5, Weird, right?}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       8\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {0, Should be first}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {0, Should be first}\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       7\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {0, Should be second}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {0, Should be second}\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       6\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		System.out.println("min:        {1, A}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {1, A}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       5\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {2, 1}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {2, 1}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       4\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {5, 10}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {5, 10}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       3\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {23, My Password is Taco}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {23, My Password is Taco}\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       2\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {47, 555.55}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {47, 555.55}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       1\t\t\t\t= " + pq.size());
//		System.out.println("empty:      false\t\t\t= " + pq.empty());
//		System.out.println();
//
//		System.out.println("min:        {123, Last}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println("removeMin:  {123, Last}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("size:       0\t\t\t\t= " + pq.size());
//		System.out.println("empty:      true\t\t\t= " + pq.empty());
//
//		if(pause)
//			input = keyboard.nextLine();
//		else
//			System.out.println();
//
//		//10.5) Test the LinkedLinkedPQ add method with doubles as keys
//		System.out.println("------------------------------------------------------------");
//		System.out.println("10.5) Test the LinkedLinkedPQ add method doubles as keys");
//		System.out.println("------------------------------------------------------------");
//
//		pq = new LinkedLinkedPQ();
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
//		System.out.println("min:      {-14.55, ¡Top!}\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		System.out.println("removeMin:  {-14.55, ¡Top!}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {-10.4, Baklava}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {-4.9, Weird, right?}\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {0.6, Should be first}\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {0.6, Should be second}\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {1.0000007, A}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {2.15, 1}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {5, 10}\t\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {23.5, My Password is Taco) = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {47, 555.55}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {123.467, Last}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println();
//
//		System.out.println("size:     0\t= " + pq.size());
//		System.out.println("empty:    true\t= " + pq.empty());
//
//		try
//		{
//			System.out.println("min:      null\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
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
//		//10.6) Test the LinkedLinkedPQ add method with strings as keys
//		System.out.println("------------------------------------------------------------");
//		System.out.println("10.6) Test the LinkedLinkedPQ add method strings as keys");
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
//		System.out.println("min:      {!!, ¡Top!}\t\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		System.out.println();
//
//		System.out.println("removeMin:  {!!, ¡Top!}\t\t       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {!2, Baklava}\t       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {2.7, Weird, right?}       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {Apescat!, First}\t       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {Apescat!, Second}\t       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {apes, A}\t\t       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {apescat!, 1}\t       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {baklava, 10}\t       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {zoo, My Password is Taco) = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {åpescat!, 555.55}\t       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println("removeMin:  {æëα, Last)\t\t       = " + LinkedLinkedPQTester.arrayToString(pq.removeMin()));
//		System.out.println();
//
//		System.out.println("size:     0\t= " + pq.size());
//		System.out.println("empty:    true\t= " + pq.empty());
//
//		try
//		{
//			System.out.println("min:      null\t= " + LinkedLinkedPQTester.arrayToString(pq.min()));
//		}
//		catch(Exception e)
//		{
//			System.out.println("min:      null\t= null (via exception)");
//		}
//	}
//}