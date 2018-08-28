/**.
    * Author : Pranay Kumar Y
    * Date : 28th Aygyst,2018
*/
import java.util.Scanner;
/**.
    * Scanner function
*/
public final class QuotientRemainder {

    /**.
        * default constructor
    */
    private QuotientRemainder() {
        //Zero parameter constructor
    }

    /**.
        * @param args of type string[]
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int a = s.nextInt();
        int b = s.nextInt();
        int quotient = a / b;
        int remainder = a % b;
        System.out.println("Quotient: " + quotient);
        System.out.println("Remainder:" + remainder);
    }
}
