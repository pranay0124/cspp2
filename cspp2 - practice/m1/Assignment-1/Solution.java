/**
    * Author: Pranay Kumar Y.
    * Date : 28th August,2018
*/
import java.util.Scanner;
/**.
    * Scanner function
*/
public final class Solution {

    /**.
        * default constructor
    */
    private Solution() {
        //Zero parameter constructor
    }

    /**.
        * @param args of type string[]
    */
    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the name :");
        String name = s.nextLine();
        System.out.println("Enter the roll no :");
        String rollno = s.nextLine();
        System.out.println("Name : " + name + " ---"
            + " Roll Number : " + rollno);
    }
}
