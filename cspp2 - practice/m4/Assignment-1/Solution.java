/**
 * Author : Pranay Kumar Y.
 * Date : 30th August, 2018.
 */
import java.util.Scanner;
/**
 * Class to find the maximum value in the array.
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
        Scanner s = new Scanner(System.in);
        int size = s.nextInt();
        int[] arrList = new int[size];
        for (int i = 0; i < size; i++) {
            arrList[i] = s.nextInt();
        }
        int max = arrList[0];
        for (int j = 0; j < size; j++) {
            if (max < arrList[j]) {
                max = arrList[j];
            }
        }
        System.out.println(max);
    }
}
