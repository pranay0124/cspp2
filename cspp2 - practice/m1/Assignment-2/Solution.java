/**
 * Author : Pranay Kumar Y.
 * Date : 28th August,2018.
 */
import java.util.Scanner;
/**
 * Scanner Function.
 */
public final class Solution {
    /**
     * Constructor.
     */
    private Solution() {
        // Zero Arguement Parameter.
    }

    /**
     * main function.
     *
     * @param      args  The arguments
     */

    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        int base = scan.nextInt();
        int height = scan.nextInt();
        Solution obj = new Solution();
        System.out.println(obj.areaOfTriangle(base, height));
    }

    /**
     * Area function.
     *
     * @param      base    The base
     * @param      height  The height
     *
     * @return     { description_of_the_return_value }
     */
    public double areaOfTriangle(final int base, final int height) {
        final double a = 0.5;
        double area = a * base * height;
        return area;
    }
    /*
    Need to fill the areaOfTriangle function and print the output
    of fahrenheit.
    */
}
