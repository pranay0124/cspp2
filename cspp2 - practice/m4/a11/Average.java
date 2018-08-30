/**
 * Author : Pranay Kumar Y.
 * Date : 30th August, 2018.
 */
import java.util.Scanner;
/**
 * Average Class.
 */
public final class Average {
    /**
     * Constructor.
     */
    private Average() {
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
        float sum = 0;
        for (int i = 0; i < size; i++) {
            arrList[i] = s.nextInt();
        }
        for (int value : arrList) {
            sum = sum + value;
        }
        float avg = sum / size;
        System.out.println("Average : " + avg);
    }
}
