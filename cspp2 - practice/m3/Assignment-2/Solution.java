/**
 * Author :Pranay Kumar Y.
 * Date : 29th August,2018.
 */
import java.util.Scanner;
/**
 * Scanner class.
 */
public final class Solution {
	/**
	 * Constructor.
	 */
    private Solution() {
    	// Zero Parameter Constructor.
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);      
        int n = s.nextInt();
        int count = 0;
        for (int i = 1; i <= n; i++) {
            int number = i;
            while (number != 0) {
            	if (number % 10 == 7) {
            		count = count + 1;
            	}
            	number = number / 10;
            }
        }
        System.out.println(count);
    }
}
