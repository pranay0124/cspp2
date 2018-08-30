import java.util.Scanner;
public class Solution {
	public static int[][] matrix() {
		Scanner s = new Scanner(System.in);
		int row = s.nextInt();
		int column = s.nextInt();
		int[][] multi = new int[row][column];
		for (int i = 0; i < row; i++) {
			for (int j = 0; j < i; j++) {
				multi[i][j] = s.nextInt();
			}
		}
		return multi;
	}
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		//Solution obj1 = new Solution();
		System.out.println(matrix());
        //System.out.println(matrix1);
	}
}