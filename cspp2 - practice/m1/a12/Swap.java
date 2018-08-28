/**
    * Author: Pranay Kumar Y.
    * Date : 28th August,2018
*/
import java.util.Scanner;
/**.
    * Scanner function
*/
public final class Swap {
    /**.
    * constructor
    */
    private HelloWorld() {
        // Zero argument constructor...
    }
    /**.
    * @param args of type string[] : command line arguments.
    *
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int temp = b;
        b = a;
        a = temp;
        System.out.println("After Swap");
        System.out.println(a);
        System.out.println(b);
    }
}
