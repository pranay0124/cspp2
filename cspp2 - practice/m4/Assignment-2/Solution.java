/**
 * Author : Pranay Kumar Y.
 * Date : 30th August, 2018.
 */
import java.util.Scanner;
/**
 * Class for matrix addition.
 */
public final class Solution {
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int row1 = s.nextInt();
        int column1 = s.nextInt();
        int[][] matrix1 = new int[row1][column1];
        for (int i = 0; i < row1; i++) {
            for (int j = 0; j < column1; j++) {
                matrix1[i][j] = s.nextInt();
            }
        }
        int row2 = s.nextInt();
        int column2 = s.nextInt();
        int[][] matrix2 = new int[row2][column2];
        for (int k = 0; k < row2; k++) {
            for (int l = 0; l < column2; l++) {
                matrix2[k][l] = s.nextInt();
            }
        }

        if (row1 == row2 && column1 == column2) {
            int[][] matrix3 = new int[row2][column2];
            String res = "";
            for (int m = 0; m < row1; m++) {
                for (int n = 0; n < column2; n++) {
                    matrix3[m][n] = matrix1[m][n] + matrix2[m][n];
                    res += matrix3[m][n] + " ";
                }
                res = res.trim() + "\n";
            }
            System.out.print(res);
        } else {
            System.out.println("not possible");
        }
    }
}
