import java.util.Scanner;
import java.lang.Math;

public final class Solution {
	/*
	Do not modify this main function.
	*/
	public static double rootsOfQuadraticEquation(int a, int b, int c) {
        double sqrt = Math.sqrt((b * b) - (4 * a * c));
        double root1 = ((-b) + (sqrt)) / (2 * a);
        double root2 = ((-b) - (sqrt)) / (2 * a);
	    System.out.println(root1 + " " + root2);
	    return 0;
	}
	public static void main(final String[] args) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		int c = scan.nextInt();
		Solution obj = new Solution();
		obj.rootsOfQuadraticEquation(a, b, c);
	}
}
