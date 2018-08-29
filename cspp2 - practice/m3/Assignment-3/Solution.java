/**
 * Author : Pranay Kumar Y.
 * Date : 29th August,2018.
 */
import java.util.Scanner;
/**
 * Class Solution.
 */
public final class Solution {
    /**
     * Construction.
     */
    private Solution() {
        // Zero parameter Constructor.
    }
    /**
     * GCD Function.
     *
     * @param      n1    The n 1
     * @param      n2    The n 2
     *
     * @return     { description_of_the_return_value }
     */
    public static int gcd(final int n1, final int n2) {
        int minval = Math.min(n1, n2);
        for (int i = minval; i >= 1; i--) {
            if ((n1 % i == 0) && (n2 % i == 0)) {
                return i;
            }
        }
        return 0;
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n1 = s.nextInt();
        int n2 = s.nextInt();
        Solution obj = new Solution();
        int ans = obj.gcd(n1, n2);
        System.out.println(ans);
    }
}
