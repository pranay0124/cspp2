/**.
    * Author : Pranay Kumar Y
    * Date : 28th Aygyst,2018
*/
import java.util.Scanner;
/**.
    * Scanner function
*/
public final class DegreesToFahrenheit {

    /**.
        * default constructor
    */
    private DegreesToFahrenheit() {
        //Zero parameter constructor
    }

    /**.
        * @param args of type string[]
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        final double mul = 1.8;
        final double add = 32;
        System.out.println("Enter the Celcius Temperature");
        double d = s.nextInt();
        double f = (mul * d) + add;
        System.out.println("Fahrenheit Temperature: " + f);
    }
}
