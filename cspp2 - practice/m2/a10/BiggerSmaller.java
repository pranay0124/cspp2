/**
 * Author : Pranay Kumar Y.
 * Date : 28th August,2018.
 */
import java.util.Scanner;
/**
 * Scanner class.
 */
public final class BiggerSmaller {
    /**
     * Constructor.
     */
    private BiggerSmaller() {
        // Zero Parameter Constructor
    }
    /**
     * Main Class.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        if (a == b) {
            System.out.println("Equal");
        } else if (a > b) {
            System.out.println("Bigger");
        } else {
            System.out.println("Smaller");
        }
    }
}
