import java.io.BufferedInputStream;
import java.util.Scanner;
import java.util.Arrays;
/**
 * Class for set.
 */
class Set {
    /**
     * { It is of int type }.
     */
    private int[] setarr;
    /**
     * { It is of int type }.
     */
    private int size;
    /**
     * Constructs the object.
     */
    Set() {
        final int ten = 10;
        setarr = new int[ten];
        size = 0;
    }

    /**
     * Get Function.
     *
     * @return     { description_of_the_return_value }
     */
    public int[] get() {
        return setarr;
    }
    /**
     * { To resize }.
     */
    public void resize() {
        setarr = Arrays.copyOf(setarr, 2 * setarr.length);
    }
    /**
     * { To return size value }.
     *
     * @return     { description_of_the_return_value }
     */
    public int size() {
        return size;
    }
    /**
     * { To check for element }.
     *
     * @param      item  The item
     *
     * @return     { boolean type }
     */
    public boolean contains(final int item) {
        for (int i = 0; i < size; i++) {
            if (setarr[i] == item) {
                return true;
            }
        }
        return false;
    }
    /**
     * Returns a string representation of the object.
     *
     * @return     String representation of the object.
     */
    public String toString() {
        if (size == 0) {
            return "{}";
        } else {
            String str = "";
            str = str + "{";
            int i = 0;
            for (i = 0; i < size - 1; i++) {
                str = str + setarr[i] + ", ";
            }
            str = str + setarr[i] + "}";
            return str;
        }
    }
    /**
     * Sort function.
     *
     * @param      items  The items
     */
    public void sort(final int[] items) {
        int[] newsetarr = new int[size];
        for (int i = 0; i < size; i++) {
            newsetarr[i] = items[i];
        }
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size - 1; j++) {
                if (newsetarr[j] > newsetarr[j + 1]) {
                    int temp = 0;
                    temp = newsetarr[j];
                    newsetarr[j] = newsetarr[j + 1];
                    newsetarr[j + 1] = temp;
                }
            }
        }
        setarr = newsetarr.clone();
        //System.out.println(Arrays.toString(newsetarr));
    }
    /**
     * { To add an item }.
     *
     * @param      item  The item
     */
    public void add(final int item) {
        if (size == setarr.length) {
            resize();
        }
        if (!(contains(item))) {
            setarr[size] = item;
            size++;
            int[] sample = new int[size];
            System.arraycopy(setarr, 0, sample, 0, size);
            sort(sample);
        }
    }
    /**
     * { To add multiple items }.
     *
     * @param      items  The items
     */
    public void addAll(final int[] items) {
        for (int i = 0; i < items.length; i++) {
            add(items[i]);
        }
    }
    /**
     * { To return intersection }.
     *
     * @param      items  The items
     *
     * @return     { set type }
     */
    public Set intersection(final Set items) {
        Set newsetarr = new Set();
        for (int i = 0; i < size; i++) {
            if (items.contains(setarr[i])) {
                newsetarr.add(setarr[i]);
            }
        }
        return newsetarr;
    }
    /**
     * { To retain all the elements }.
     *
     * @param      items  The items
     *
     * @return     { set type }
     */
    public Set retainAll(final int[] items) {
        Set newsetarr = new Set();
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < items.length; j++) {
                if (setarr[i] == items[j]) {
                    newsetarr.add(setarr[i]);
                    break;
                }
            }
        }
        return newsetarr;
    }
    /**
     * { To find cartesian product }.
     *
     * @param      other  The other
     *
     * @return     { 2D array }
     */
    public int[][] cartesianProduct(final Set other) {
        if (size == 0 || other.size == 0) {
            return null;
        }
        int[][] cartarr = new int[size * other.size][2];
        for (int i = 0, k = 0; i < size; i++) {
            for (int j = 0; j < other.size; j++, k++) {
                cartarr[k][0] = setarr[i];
                cartarr[k][1] = other.setarr[j];
            }
        }
        return cartarr;
    }
}

/**
 * Class for sorted set.
 */
class SortedSet extends Set {
    /**
     * SubSet Function.
     *
     * @param      fromElement  The from element
     * @param      toElement    To element
     *
     * @return     { description_of_the_return_value }
     */
    public Set subSet(final int fromElement, final int toElement)
    throws Exception {
        Set newsetarr = new Set();
        if (fromElement > toElement) {
            throw new Exception("Invalid Arguments to Subset Exception");
        }
        for (int i = 0; i < size(); i++) {
            if (super.get()[i] >= fromElement && super.get()[i] < toElement) {
                newsetarr.add(super.get()[i]);
            }
        }
        return newsetarr;
    }

    /**
     * HeadSet Function.
     *
     * @param      toElement  To element
     *
     * @return     { description_of_the_return_value }
     */
    public Set headSet(final int toElement) throws Exception {
        sort(super.get());
        Set newsetarr = new Set();
        for (int i = 0; i < size(); i++) {
            if (super.get()[i] < toElement) {
                newsetarr.add(super.get()[i]);
            }
        }
        if (newsetarr.toString().equals("{}")) {
            throw new Exception();
        }
        return newsetarr;
    }

    /**
     * Last Function.
     *
     * @return     { description_of_the_return_value }
     */
    int last() throws Exception {
        if (size() <= 0) {
            throw new Exception("Set Empty Exception");
        }
        sort(super.get());
        int s = size() - 1;
        return super.get()[s];
        // Arrays.sort(getSet(), 0, size());
        // int s = size() - 1;
        // return getSet()[s];
    }
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
        SortedSet s = new SortedSet();
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
            case "addAll":
                int[] intArray = intArray(tokens[1]);
                s.addAll(intArray);
                break;
            case "intersection":
                s = new SortedSet();
                SortedSet t = new SortedSet();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(s.intersection(t));
                break;
            case "retainAll":
                s = new SortedSet();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                System.out.println(s.retainAll(intArray));
                break;
            case "cartesianProduct":
                s = new SortedSet();
                t = new SortedSet();
                intArray = intArray(tokens[1]);
                s.addAll(intArray);
                intArray = intArray(tokens[2]);
                t.addAll(intArray);
                System.out.println(Arrays.deepToString
                         (s.cartesianProduct(t)));
                break;
            case "subSet":
                String[] strArray = tokens[1].split(",");
                intArray = new int[2];
                intArray[0] = Integer.parseInt(strArray[0]);
                intArray[1] = Integer.parseInt(strArray[1]);
                try {
                    Set sa = new Set();
                    sa = s.subSet(intArray[0], intArray[1]);
                    System.out.println(sa);
                } catch(Exception e) {
                    System.out.println(e.getMessage());
                }
            break;
        case "headSet":
            String[] strArray1 = tokens[1].split(",");
            intArray = new int[1];
            intArray[0] = Integer.parseInt(strArray1[0]);
            try {
                System.out.println(s.headSet(intArray[0]));
            } catch (Exception e) {
                System.out.println("Set Empty Exception");
            }

            break;
        case "last":
            try {
                System.out.println(s.last());
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
            break;
        default:
            break;
        }
    }
}
}
