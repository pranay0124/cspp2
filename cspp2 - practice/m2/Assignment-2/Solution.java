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
        // Zero Parameter Construction
    }

    /**
     * Function for Quadratic Equation.
     *
     * @param      a     { parameter_description }
     * @param      b     { parameter_description }
     * @param      c     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public static double rootsOfQuadraticEquation(final int a, final int b, final int c) {
        final int z = 4;
        double sqrt = Math.sqrt((b * b) - (z * a * c));
        double root1 = ((-b) + (sqrt)) / (2 * a);
        double root2 = ((-b) - (sqrt)) / (2 * a);
        System.out.println(root1 + " " + root2);
        return 0;
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int a = scan.nextInt();
        int b = scan.nextInt();
        int c = scan.nextInt();
        Solution obj = new Solution();
        obj.rootsOfQuadraticEquation(a, b, c);
    }
}
