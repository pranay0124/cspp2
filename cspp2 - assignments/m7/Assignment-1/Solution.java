/**
 * Author : Pranay Kumar Y.
 * Date : 3rd September,2018.
 */
import java.util.Scanner;
/**
 * Class for input validator.
 */
class InputValidator {
    /**
     * { It is of string type }.
     */
    private String testinput;

    /**
     * Constructs the object.
     *
     * @param      giveninput  String type
     */
    InputValidator(final String giveninput) {
        this.testinput = giveninput;
    }

    /**
     * { It is created to validate the data }.
     *
     * @return     { return value is of boolean type }.
     */
    public boolean validateData() {
        final int six = 6;
        return this.testinput.length() >= six;
    }
}

/**
 * Class for solution.
 */
final class Solution {
    /**
     * Constructs the object.
     */
    private Solution() {
        //unused
    }
    /**
     * { Main function to intiate the program }.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        Scanner scan = new Scanner(System.in);
        String input = scan.next();
        InputValidator inputclass = new InputValidator(input);
        System.out.println(inputclass.validateData());
    }
}
