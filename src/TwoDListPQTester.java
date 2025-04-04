/**
 * Tester code for Question 07 (TwoDListPQ) of the Final Project.
 **/
import java.util.ArrayList;
import java.util.Scanner;

public class TwoDListPQTester
{
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

	private static String arrayListToString(ArrayList<Comparable> arraylist)
	{
		if(arraylist == null)
			return "null";
		else if(arraylist.size() == 0)
			return "{}";

		String output = "{";

		for(int i = 0; i < arraylist.size(); i++)
			output += arraylist.get(i).toString() + ", ";

		output = output.substring(0, output.length() - 2) + "}";

		return output;
	}

	public static void main(String[] args)
	{
		Scanner keyboard = new Scanner(System.in);
		String input;

		//7.1) Test the TwoDListPQ constructor
		System.out.println("------------------------------------------------------------");
		System.out.println("7.1) Test the TwoDListPQ constructor");
		System.out.println("------------------------------------------------------------");

		PriorityQueue pq = new TwoDListPQ();
		boolean pause = false;

		System.out.println("size:     0\t= " + pq.size());
		System.out.println("empty:    true\t= " + pq.empty());

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		//7.2) Test accessing an empty TwoDListPQ
		System.out.println("------------------------------------------------------------");
		System.out.println("7.2) Test accessing an empty TwoDListPQ");
		System.out.println("------------------------------------------------------------");

		try
		{
			System.out.println("null:\t= " + TwoDListPQTester.arrayToString(pq.min()));
		}
		catch(Exception e)
		{
			System.out.println("null:\t= null (via exception)");
		}

		try
		{
			System.out.println("null:\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		}
		catch(Exception e)
		{
			System.out.println("null:\t= null (via exception)");
		}

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		//7.3) Test the TwoDListPQ add method with ints as keys
		System.out.println("------------------------------------------------------------");
		System.out.println("7.3) Test the TwoDListPQ add method with ints keys");
		System.out.println("------------------------------------------------------------");

		pq = new TwoDListPQ();

		pq.add(Integer.valueOf(5), Integer.valueOf(10));

		System.out.println("size:     1\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {5, 10}\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(2), Integer.valueOf(1));

		System.out.println("size:     2\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {2, 1}\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(23), "My Password is Taco");

		System.out.println("size:     3\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {2, 1}\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(10), "Baklava");

		System.out.println("size:     4\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {2, 1}\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(0), "Should be second");

		System.out.println("size:     5\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {0, Should be second}\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(123), "Last");

		System.out.println("size:     6\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {0, Should be second}\t= " + TwoDListPQTester.arrayToString(pq.min()));

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		pq.add(Integer.valueOf(5), "Weird, right?");

		System.out.println("size:     7\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {0, Should be second}\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(0), "Should be first");

		System.out.println("size:     8\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {0, Should be <either>}\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(47), Double.valueOf(555.55));

		System.out.println("size:     9\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {0, Should be <either>}\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(1), Character.valueOf('A'));

		System.out.println("size:     10\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {0, Should be <either>}\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		pq.add(Integer.valueOf(15), "¡Top!");

		System.out.println("size:     11\t\t\t= " + pq.size());
		System.out.println("empty:    false\t\t\t= " + pq.empty());
		System.out.println("min:      {0, Should be <either>}\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println();

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		//7.4) Test the TwoDListPQ min and removeMin methods
		System.out.println("------------------------------------------------------------");
		System.out.println("7.4) Test the TwoDListPQ min and removeMin methods");
		System.out.println("------------------------------------------------------------");

		System.out.println("removeMin:  {0, Should be <either>}\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       10\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {0, Should be <either>}\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {0, Should be <either>}\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       9\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {1, A}\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {1, A}\t\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       8\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {2, 1}\t\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {2, 1}\t\t\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       7\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {5, 10}\t\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {5, 10}\t\t\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       6\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		System.out.println("min:        {10, Baklava}\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {10, Baklava}\t\t\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       5\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {14, Weird, right?}\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {14, Weird, right?}\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       4\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {15, ¡Top!}\t\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {15, ¡Top!}\t\t\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       3\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {23, My Password is Taco}\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {23, My Password is Taco}\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       2\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {47, 555.55}\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {47, 555.55}\t\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       1\t\t\t\t= " + pq.size());
		System.out.println("empty:      false\t\t\t= " + pq.empty());
		System.out.println();

		System.out.println("min:        {123, Last}\t\t\t= " + TwoDListPQTester.arrayToString(pq.min()));
		System.out.println("removeMin:  {123, Last}\t\t\t= " + TwoDListPQTester.arrayToString(pq.removeMin()));
		System.out.println("size:       0\t\t\t\t= " + pq.size());
		System.out.println("empty:      true\t\t\t= " + pq.empty());

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		/*************************************************************************************************
		 * THIS CODE WILL ONLY POTENTIALLY WORK IF:
		 *		1) YOU COPY THE TEST CODE INTO YOUR MAIN METHOD; AND
		 *		2) YOU COPY THE arrayListToString HELPER METHOD ABOVE; AND
		 *		3) YOU MAKE YOUR ARRAYLIST PUBLICLY VISIBLE; AND
		 *		4) YOU ADJUST THE CODE LABELED <YOUR ARRAYLIST NAME> WITH THE ACTUAL NAME OF YOUR ARRAYLIST
		 *
		 * THERE MAY BE OTHER CHANGES THAT YOU NEED TO MAKE TO MAKE THE CODE WORK SUCH AS IMPORTING
		 * METHODS AND CHANGING REFERENCES. THIS CODE MAY NOT WORK EVEN IF YOUR CODE IS PERFECT.
		 *************************************************************************************************/
		/*
		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		//7.5) Try to test the underlying non-heap structure. MAY NOT WORK!
		System.out.println("------------------------------------------------------------");
		System.out.println("7.5) Try to test the underlying heap structure. MAY NOT WORK!");
		System.out.println("     NOTE: Only populated priorities will print!");
		System.out.println("           If nothing is at a given priority, it will be skipped.");
		System.out.println("------------------------------------------------------------");

		pq = new TwoDListPQ();

		pq.add(Integer.valueOf(5),   Integer.valueOf(10));
		pq.add(Integer.valueOf(2),   Integer.valueOf(1));
		pq.add(Integer.valueOf(47),  Double.valueOf(555.55));
		pq.add(Integer.valueOf(23),  "My Password is Taco");
		pq.add(Integer.valueOf(0),   "Should be second");
		pq.add(Integer.valueOf(123), "Last");
		pq.add(Integer.valueOf(14),  "Weird, right?");
		pq.add(Integer.valueOf(0),   "Should be first");
		pq.add(Integer.valueOf(10),  "Baklava");
		pq.add(Integer.valueOf(1),   Character.valueOf('A');
		pq.add(Integer.valueOf(15), "¡Top!");

		ArrayList<ArrayList<Comparable>> pointer = pq.<YOUR ROOT NODE NAME>;

		int i = 0;
		while(i <= 123) #Maximum key
		{
			if((pointer.get(i) != null) && (pointer.get(i).size() != 0))
				System.out.println("Key: " + i + "; Values: " + TwoDListPQTester.arrayListToString(pointer.get(i)));

			i += 1;
		}

		if(pointer.size() > 124)
			System.out.println("NOTE! ArrayList is too big! Length of " + pointer.size() + " exceeds 124 (maximum key + 1)!");

		if(pause)
			input = keyboard.nextLine();
		else
			System.out.println();

		//7.6) Test the various key types that shouldn't be allowed
		System.out.println("------------------------------------------------------------");
		System.out.println("7.6) Test the various key types that shouldn't be allowed");
		System.out.println("------------------------------------------------------------");

		pq = TwoDListPQ();

		try
		{
			pq.add(Double(3.5), "Uh oh");

			if(pq.size() == 0)
				System.out.println("Good. Float key value failed. (Not allowed)");
			else
				System.out.println("FLOAT KEY VALUE ALLOWED!");
		}
		catch(Exception e)
		{
			System.out.println("Good. Float key value failed. (Exception)\n" + e);
		}


		pq = TwoDListPQ()

		try
		{
			pq.add("3", "Uh oh");

			if(pq.size() == 0)
				System.out.println("Good. String key value of an integer failed. (Not allowed)");
			else
				System.out.println("STRING KEY VALUE OF AN INTEGER ALLOWED!");
		}
		catch(Exception e)
		{
			System.out.println("Good. String key value of an integer failed. (Exception)\n" + e);
		}

		pq = TwoDListPQ();

		try:
			pq.add("Uh oh", "Uh oh");

			if(pq.size() == 0)
				System.out.println("Good. String key value failed. (Not allowed)");
			else
				System.out.println("STRING KEY VALUE ALLOWED!");
		}
		catch(Exception e)
		{
			System.out.println("Good. String key value failed. (Exception)\n" + e);
		}

		pq = TwoDListPQ();

		try
		{
			pq.add(Integer.valueOf(-5), "¡Top!");

			if(pq.size() == 0)
				System.out.println("Good. Negative key value failed. (Not allowed)");
			else
				System.out.println("NEGATIVE KEY VALUE ALLOWED!");
		}
		catch(Exception e)
		{
			System.out.println("Good. Negative key value failed. (Exception)\n" + e);
		}
		*/
	}
}