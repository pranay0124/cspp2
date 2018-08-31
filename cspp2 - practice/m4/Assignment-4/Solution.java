/**
 * Author : Pranay Kumar Y.
 * Date : 31st August, 2018.
 */
import java.util.Scanner;
/**
 * Class to reverse a string.
 */
public final class Solution {
    /**
     * Constructor.
     */
    private Solution() {
        //Zero Parameter Constructor.
    }

    /**
     * Reverse Function.
     *
     * @param      str   The string
     *
     * @return     { description_of_the_return_value }
     */
    public static String reverseString(String str) {
        int len = str.length();
        String reverse = "";
        for (int i = len - 1; i >= 0; i--) {
            reverse = reverse + str.charAt(i);
        }
        return reverse;
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        String reverse = reverseString(s);
        System.out.println(reverse);
    }
}
