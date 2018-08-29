/**
 * Author :Pranay Kumar Y.
 * Date : 29th August,2018.
 */
import java.util.Scanner;
/**
 * Scanner class.
 */
public final class Solution {
    /**.
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
            final int zero = 0;
            final int ten = 10;
            final int seven = 7;
            while (number != zero) {
                if (number % ten == seven) {
                    count = count + 1;
                }
                number = number / ten;
            }
        }
        System.out.println(count);
    }
}
