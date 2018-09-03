/**
 * Author : Pranay kumar Y.
 * Date : 3rd September,2018.
 */
final class StudentDetails {
    /**
     * Student Name.
     */
    private String studentName;
    /**
     * Student Roll no.
     */
    private String studentRollno;
    /**
     * Marks1.
     */
    private double marks1;
    /**
     * Marks2.
     */
    private double marks2;
    /**
     * Marks3.
     */
    private double marks3;

    /**
     * Function for Student Details.
     *
     * @param      stuName    The stu name
     * @param      stuRollno  The stu rollno
     * @param      m1         The m 1
     * @param      m2         The m 2
     * @param      m3         The m 3
     */
    private StudentDetails(final String stuName, final String stuRollno,
                    final float m1, final float m2,
                    final float m3) {
        this.studentName = stuName;
        this.studentRollno = stuRollno;
        this.marks1 = m1;
        this.marks2 = m2;
        this.marks3 = m3;
    }


    /**
     * Function for GPA.
     *
     * @return     { description_of_the_return_value }
     */
    public double gpa() {
        final double three = 3.0f;
        double gpa = (marks1 + marks2 + marks3) / three;
        return gpa;
    }

    /**
     * Main Function.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        final float sixPointZero = 6.0f;
        final float sevenPointZero = 7.0f;
        final float sevenPointFive = 7.5f;
        final float eightPointZero = 8.0f;
        final float eightPointFive = 8.5f;
        final float ninePointZero = 9.0f;

        StudentDetails student1 = new StudentDetails(
        "Sangay", "IT201985001",
         sevenPointFive, sevenPointZero, eightPointZero);
        StudentDetails student2 = new StudentDetails(
        "Bidhya", "IT201985003",
         eightPointFive, sixPointZero, sevenPointFive);
        StudentDetails student3 = new StudentDetails(
        "Kelzang", "IT201985065",
         sevenPointFive, eightPointZero, ninePointZero);

        System.out.println(student1.studentName + " - "
            + student1.studentRollno + " - " + student1.gpa());
        System.out.println(student2.studentName + " - "
            + student2.studentRollno + " - " + student2.gpa());
        System.out.println(student3.studentName + " - "
            + student3.studentRollno + " - " + student3.gpa());
    }
}
