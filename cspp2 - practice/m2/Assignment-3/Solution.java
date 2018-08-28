import java.util.Scanner;

public class Solution {
	/*
	Do not modify this main function.
	*/
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);      
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base,exponent);
        System.out.println(result);
	}
	public static long power(final int base, final int exponent) {
		final int num = 1;
		if (exponent == 0) {
			return num;
		} else return base * power(base, exponent - 1);
	}
	/*
	Need to write the power function and print the output.
	*/
}
