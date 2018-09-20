import java.util.Scanner;
import java.io.File;

/**
 * Class for solution.
 */
public final class Solution {
    /**
         * Constructs the object.
         */
    private Solution() {
        //Zero Parameter Constructor.
    }
    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        try {
            Scanner scan = new Scanner(System.in);
            String input = scan.nextLine();
            File folder = new File(input);
            File[] files = folder.listFiles();
            int ans;
            int maxval = 0;
            String file1 = null;
            String file2 = null;
            System.out.print("\t\t"); //p
            for (int i = 0; i < files.length - 1; i++) { //p
                System.out.print(files[i].getName() + "\t"); //p
            }
            System.out.print(files[files.length - 1].getName()); //p
            System.out.println(); //p
            for (File firstfile : files) {
                System.out.print(firstfile.getName() + "\t"); //p
                for (File secondfile : files) {
                    Distance map1 = new Distance(firstfile);
                    Distance map2 = new Distance(secondfile);
                    ans = (int) Math.round(map1.angle(map2));
                    if (ans > maxval && !firstfile.getName().equals(
                                secondfile.getName())) {
                        maxval = ans;
                        file1 = firstfile.getName();
                        file2 = secondfile.getName();
                    }
                    System.out.print(ans + "\t\t");
                }
                System.out.println();
            }
            System.out.println("Maximum similarity is between " + file1
                               + " and " + file2);
        } catch (Exception e) {
            System.out.println("empty directory");
        }
    }
}
