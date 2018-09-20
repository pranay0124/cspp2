import java.util.*;
import java.io.*;

class Solution {
	public static void main(String[] args) {

		try {
			Scanner scan = new Scanner(System.in);
			String input = scan.nextLine();
			File folder = new File(input);
			File[] files = folder.listFiles();
			int ans;
			if (files.length == 0) {
				System.out.println("empty directory");
			} else {
				// for (File firstfile : files) {
				// 	for (File secondfile : files) {
						
				// 		ans = firstfile.angle(secondfile);
				// 	}
				// }
			}
		} catch (Exception e) {
			System.out.println("empty directory");
		}
	}
}