/**
 * Author : Pranay Kumar Y.
 * Date : 29th August, 2018.
 */
import java.util.Scanner;
/**
 * Scanner Class.
 */
public final class Pattern {
    /**
     * Constructor.
     */
    private Pattern() {
        // Zero Parameter Constructor.
    }

    /**
     * Main Class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println(" ");
        }
    }
}
