/**
 * Author : Pranay Kumar Y.
 * Date : 28th August,2018.
 */
import java.util.Scanner;
/**
 * Scanner Class.
 */
public final class Factorial {
    /**
     * Constructor.
     */
    private Factorial() {
        // Zero Parameter Constructor
    }

    /**
     * Function for Factorial.
     *
     * @param      n     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static long factorial(final long n) {
        if (n == 1) {
            return 1;
        } else {
            return (n * factorial(n - 1));
        }
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        long num = s.nextLong();
        long ans = factorial(num);
        System.out.println("Factorial : " + ans);
    }
}
