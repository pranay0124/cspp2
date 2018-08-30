/**
 * Author : Pranay Kumar Y.
 * Date : 30th August, 2018.
 */
import java.util.Scanner;
/**
 * Concatinate class.
 */
public final class Concatinate {
    /**
     * Constructor.
     */
    private Concatinate() {
        // Zero Parameter Constructor.
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        String strIn = s.nextLine();
        String newStr = "Hello ".concat(str_in);
        String finalStr = newStr.concat("!");
        System.out.println(finalStr);
    }
}
