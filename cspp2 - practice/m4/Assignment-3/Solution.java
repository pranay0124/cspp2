/**
 * Author : Pranay Kumar Y.
 * Date : 31st August, 2018.
 */
import java.util.Scanner;
/**
 * Class for converting the binary format to decimal.
 */
public final class Solution {
    /**
     * Constructor.
     */
    private Solution() {
        //Zero Parameter Constructor.
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());
        for (int i = 0; i < n; i++) {
            String s = sc.nextLine();
            long res = binaryToDecimal(s); //Write binaryToDecimal function
            System.out.println(res);
        }
    }

    /**
     * Function for conversion.
     *
     * @param      str   The string
     *
     * @return     { description_of_the_return_value }
     */
    public static long binaryToDecimal(final String str) {
        int len = str.length();
        int sum = 0;
        int j = 0;
        for (int i = len - 1; i >= 0; i--) {
            sum += Character.getNumericValue(str.charAt(i)) * (Math.pow(2, j));
            j++;
        }
        return sum;
    }
}
