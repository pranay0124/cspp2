import java.io.BufferedInputStream;
import java.util.Scanner;

public class Solution {

	// private String[] list;
	// private int size;

	// public void List() {
	// 	list = new String[10];
	// 	size = 0;
	// }

	// public void List(int capacity) {
	// 	size = 0;
	// 	list = new String[capacity];
	// }

	// public void add(String item) {
 //        try {
 //        	list[size++] = item;
 //        } catch (Exception e) {
 //        	resize();
 //        	add(item);
 //        }
        
	// }

	// public void resize() {
 //        list = Arrays.copyOf(list, 2 * size);
	// }

	// public void addall(int List[]) {
	// 	for (int i = 0; i<list.length; i++) {
	// 		add(list[i]);
	// 	}
	// }

	// public int size() {
	// 	return size;
	// }

	// public String toString() {
	// 	if (size == 0) 
	// 		return "[]";
	// 	String str = "[";
	// 	int i = 0;
	// 	for (i = 0; i< size-1; i++) {
	// 	   	str = str + list[i] + ",";
	// 	}
	// 	str = str + list[i] + "]";
	// 	return str;
	// }

	// public void remove(int index) {
	// 	if (index >= 0 && index < size) {
	// 		for (int i=index;i<size-1;i++) {
	// 			list[i] = list[i+1];
	// 		}
	// 		size--;
	// 	} else{
	// 		System.out.println("Invalid Position Exception");
	// 	}
	// }

	// public int indexOf(String item) {
 //    	for(int i = 0; i<size;i++) {
 //    		if(item == list[i]) {
 //    			return i;
 //    		}
 //    	}
 //    	return -1;
	// }

	// public String get(int index) {
	// 	if (index<0 || index>= size) {
	// 		return "-1";
	// 	} else {
	// 		return list[index];
	// 	}
	// }

	// public boolean contains(String item) {
	// 	for(int i = 0; i<size;i++) {
 //    		if(item == list[i]) {
 //    			return true;
 //    		}
 //    	}
 //    	return false;
	// }

	public static void main(String[] args) {
        // create an object of the list to invoke methods on it
        StringList sl = new StringList();
        StringListInterface l=(StringListInterface)sl;//Typecasting is done for StringListInterface
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
                case "add":
	                l.add(tokens[1]);
                break;
                case "addAll":
                if(tokens.length==2){
                String[] t1 = tokens[1].split(",");
                l.addAll(t1);
                }
                break;
                case "size":
                // invoke size method and print the list size
                // BTW, list size is not the array size
                // it is the number of items in the list
                System.out.println(l.size());
                break;
                case "print":
                // print the list (implement toString in StringList class
                //for this to work)
                // expected format is [item-1,item-2,...,item-n]
                // review the output testcase file
                System.out.println(l);
                break;
                case "remove":
                l.remove(Integer.parseInt(tokens[1]));
                break;
                case "indexOf":
                System.out.println(l.indexOf(tokens[1]));
                break;
                case "get":
                System.out.println(l.get(Integer.parseInt(tokens[1])));
                break;
                case "contains":
                System.out.println(l.contains(tokens[1]));
                break;
            }
        }
	}
}
