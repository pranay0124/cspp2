/**
 * Author : Pranay Kumar Y.
 * Date : 29th August, 2018.
 */
import java.util.Scanner;
/**
 * Scanner Class.
 */
public final class SumofNNumbers {
    /**
     * Constructor.
     */
    private SumofNNumbers() {
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
        int sum = 0;
        for (int i = 0; i <= n; i++) {
            sum = sum + i;
        }
        System.out.println("Sum : " + sum);
    }
}
