/**
 * Author : Pranay Kumar Y.
 * Date : 30th August, 2018.
 */
import java.util.Scanner;
/**
 * Print True if the array contains "6" in first or last.
 */
public final class FirstLast {
    /**
     * Constructor.
     */
    private FirstLast() {
        //Zero Parameter Constructor.
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arrList = new int[size];
        for (int i = 0; i < size; i++) {
            arrList[i] = s.nextInt();
        }
        final int six = 6;
        if (arrList[0] == six || arrList[size - 1] == six) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}
