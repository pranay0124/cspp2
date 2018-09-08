import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;

/**
 * Class for set.
 * @author : Pranay Kumar Y.
 */
class Set {
	//your code goes here...
	//Good luck :-)
	private int[] set;
	private int size;

	public Set() {
		set = new int[10];
		size = 0;
	}

	public int size() {
		return size;
	}

	public boolean contains(final int item) {
		for (int i = 0; i < size; i++) {
			if (item == set[i]) {
				return true;
			}
		}
		return false;
	}

	public String StringtoString() {
		if (size == 0) {
			return "{}";
		}
		String str = "{";
		int i = 0;
		for (i = 0; i < size - 1; i++) {
			str = str + set[i] + ",";
		}
		str = str + set[i] + "}";
		return str;
	}

	public void add(final int item) {
		try {
			set[size] = item;
			size++;
		} catch (Exception  e) {
			resize();
			add(item);
			
		}
	}
	public void add(final int[] newArray) {
		// write the logic
		for (int i = 0; i < newArray.length; i++) {
			try {
				set[size] = newArray[i];
				size++;
			} catch (Exception  e) {
				resize();
				add(newArray[i]);
			}
		}
	}
	public void resize() {
		set = Arrays.copyOf(set, 2 * set.length);
	}
    
    public int get(final int index) {
        if (index < 0 || index >= size) {
            return -1;
        } else {
            return set[index];
        }
    }

	public Set intersection(Set set1) {
        Set set2 = new Set();
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < set1.size; j++) {
				if (set[i] == set1.get(j)) {
					set2.add(set[i]);
				}
			}
        }
        return set2;
	}
    
	public Set retainAll(int[] arr) {
        Set set2 = new Set();
		for (int i = 0; i < size; i++) {
            for (int j = 0; j < arr.length; j++) {
				if (set[i] == arr[j]) {
					set2.add(set[i]);
				}
            }
		}
		return set2;
	}

	// public void cartesianProduct(int set) {
	// 	return null;
	// }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {

	/**
	 * Constructs the object.
	 */
	private Solution() {

	}
	/**
	 * helper function to convert string input to int array.
	 *
	 * @param      s     { string input from test case file }
	 *
	 * @return     { int array from the given string }
	 */
	public static int[] intArray(final String s) {
		String input = s;
		if (input.equals("[]")) {
			return new int[0];
		}
		if (s.contains("[")) {
			input = s.substring(1, s.length() - 1);
		}
		return Arrays.stream(input.split(","))
		       .mapToInt(Integer::parseInt)
		       .toArray();
	}
	/**
	 * main function to execute test cases.
	 *
	 * @param      args  The arguments
	 */
	public static void main(final String[] args) {
		// instantiate this set
		Set s = new Set();
		// code to read the test cases input file
		Scanner stdin = new Scanner(new BufferedInputStream(System.in));
		// check if there is one more line to process
		while (stdin.hasNext()) {
			// read the line
			String line = stdin.nextLine();
			// split the line using space
			String[] tokens = line.split(" ");
			// based on the list operation invoke the corresponding method
			switch (tokens[0]) {
			case "size":
				System.out.println(s.size());
				break;
			case "contains":
				System.out.println(s.contains(Integer.parseInt(tokens[1])));
				break;
			case "print":
				System.out.println(s);
				break;
			case "add":
				int[] intArray = intArray(tokens[1]);
				if (intArray.length == 1) {
					s.add(intArray[0]);
				} else {
					s.add(intArray);
				}
				break;
			case "intersection":
				s = new Set();
				Set t = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				t.add(intArray);
				System.out.println(s.intersection(t));
				break;
			case "retainAll":
				s = new Set();
				intArray = intArray(tokens[1]);
				s.add(intArray);
				intArray = intArray(tokens[2]);
				System.out.println(s.retainAll(intArray));
				break;
			// case "cartesianProduct":
			// 	s = new Set();
			// 	t = new Set();
			// 	intArray = intArray(tokens[1]);
			// 	s.add(intArray);
			// 	intArray = intArray(tokens[2]);
			// 	t.add(intArray);
			// 	System.out.println(Arrays.deepToString(s.cartesianProduct(t)));
			// 	break;
			default:
				break;
			}
		}
	}
}
