/**
 * Author : Pranay Kumar Y.
 * Date : 28th August, 2018.
 */
import java.util.Scanner;
/**
 * Scanner function.
 */
public final class Solution {
    /**
     * Constructor.
     */
    private Solution() {
        // Zero Parameter Constructor
    }
    /**
     * Main class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        double degreesCelsius = scan.nextDouble();
        Solution obj = new Solution();
        obj.calculateFromDegreesToFarenheit(degreesCelsius);
    }
    /**
     * Degrees to farhenheit function.
     *
     * @param      degreesCelsius  The degrees celsius
     *
     * @return     The from degrees to farenheit.
     */
    public double calculateFromDegreesToFarenheit(final double degreesCelsius) {
        final double mul = 1.8;
        final double add = 32;
        double f = (mul * degreesCelsius) + add;
        System.out.println(f);
        return 0;
    }
}
