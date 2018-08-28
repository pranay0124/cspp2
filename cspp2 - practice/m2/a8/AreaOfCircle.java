/**
 * Author : Pranay Kumar Y.
 * Date : 28th August,2018.
 */
import java.util.Scanner;
/**
 * Scanner class.
 */
class AreaOfCircle {
    /**
     * function for pi.
     *
     * @return     { description_of_the_return_value }
     */
    public double value() {
        final double pi = 3.14;
        return pi;
    }

    /**
     * Function for area.
     *
     * @param      r     { parameter_description }
     *
     * @return     { description_of_the_return_value }
     */
    public double area(final double r) {
        return value() * r * r;
    }

    /**
     * Main function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the radius : ");
        double r = s.nextDouble();
        AreaOfCircle obj = new AreaOfCircle();
        System.out.println("The area of the circle is :" + obj.area(r));
    }
}
