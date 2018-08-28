/**
 * Author : Pranay Kumar Y.
 * Date : 28th August, 2018.
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
        // Zero Parameter Constructor
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int base = s.nextInt();
        int exponent = s.nextInt();
        long result = power(base, exponent);
        System.out.println(result);
    }

    /**
     * Power Function.
     *
     * @param      base      The base
     * @param      exponent  The exponent
     *
     * @return     { description_of_the_return_value }
     */
    public static long power(final int base, final int exponent) {
        final int num = 1;
        if (exponent == 0) {
            return num;
        } else {
            return base * power(base, exponent - 1);
        }
    }
}
