import java.util.Scanner;
import java.util.ArrayList;
/**
 * Class for quiz.
 */
class Quiz {
    String question;
    String[] choices;
    String answer;
    String marks;
    String penalty;
    /**
     * Constructs the object.
     */
    Quiz() {

    }
    /**
     * Constructs the object.
     *
     * @param      question  The question
     * @param      choices   The choices
     * @param      answer    The answer
     * @param      marks     The marks
     * @param      penalty   The penalty
     */
    Quiz(String question, String[] choices, String answer, String marks, String penalty) {
        this.question = question;
        this.choices = choices;
        this.answer = answer;
        this.marks = marks;
        this.penalty = penalty;
    }

    // String getQuestion() {
    //  return question;
    // }

    // String[] getChoices() {
    //  return choices;
    // }

    // String getAnswer() {
    //  return answer;
    // }

    // String getMarks() {
    //  return marks;
    // }

    // String getPenalty() {
    //  return penalty;
    // }
}
/**
 * Solution class for code-eval.
 */
public final class Solution {
    /**
     * { var_description }
     */
    static ArrayList<Quiz> questionList = new ArrayList<Quiz>();
    /**
     * { var_description }
     */
    static ArrayList<String> answerList = new ArrayList<String>();
    /**
    * Constructs the object.
    */
    private Solution() {
        // leave this blank
    }
    /**
     * main function to execute test cases.
     *
     * @param      args  The arguments
     */
    public static void main(final String[] args) {
        // instantiate this Quiz
        Quiz q = new Quiz();
        // code to read the test cases input file
        Scanner s = new Scanner(System.in);
        // check if there is one more line to process
        while (s.hasNext()) {
            // read the line
            String line = s.nextLine();
            // split the line using space
            String[] tokens = line.split(" ");
            // based on the list operation invoke the corresponding method
            switch (tokens[0]) {
            case "LOAD_QUESTIONS":
                System.out.println("|----------------|");
                System.out.println("| Load Questions |");
                System.out.println("|----------------|");
                loadQuestions(s, q, Integer.parseInt(tokens[1]));
                break;
            case "START_QUIZ":
                System.out.println("|------------|");
                System.out.println("| Start Quiz |");
                System.out.println("|------------|");
                startQuiz(s, q, Integer.parseInt(tokens[1]));
                break;
            case "SCORE_REPORT":
                System.out.println("|--------------|");
                System.out.println("| Score Report |");
                System.out.println("|--------------|");
                displayScore(q);
                break;
            default:
                break;
            }
        }
    }
    /**
     * Loads questions.
     *
     * @param      s              The scanner object for user input
     * @param      quiz           The quiz object
     * @param      questionCount  The question count
     */
    public static void loadQuestions(final Scanner s, final Quiz quiz, int questionCount) {
        // write your code here to read the questions from the console
        // tokenize the question line and create the question object
        // add the question objects to the quiz class
        try {
            while (questionCount > 0) {
                String line = s.nextLine();
                String[] tokens = line.split(":");
                String[] keys = tokens[1].split(",");
                int a = keys.length;
                if (a <= 1) {
                    System.out.println("trick question  does not have enough answer choices");
                    return;
                }
                if (tokens[4] == "") {
                    System.out.println("Error! Malformed question");
                    return;
                }
                if (Integer.parseInt(tokens[3]) < 0) {
                    System.out.println("Invalid max marks for question about sony");
                    return;
                }
                if (!tokens[2].equals("1") && !tokens[2].equals("2") && !tokens[2].equals("3") && !tokens[2].equals("4")) {
                    System.out.println("Error! Correct answer choice number is out of range for question text 1");
                    return;
                }
                Quiz q = new Quiz(tokens[0], keys, tokens[2], tokens[3], tokens[4]);
                questionList.add(q);
                questionCount--;
            }
            int b = questionList.size();
            if (b != 0) {
                System.out.println(b + " are added to the quiz");
            } else {
                System.out.println("Quiz does not have questions");
            }
        } catch (Exception e) {
            System.out.println("Error! Malformed question");
        }

    }

    /**
     * Starts a quiz.
     *
     * @param      s            The scanner object for user input
     * @param      quiz         The quiz object
     * @param      answerCount  The answer count
     */
    public static void startQuiz(final Scanner s, final Quiz quiz, int answerCount) {
        // write your code here to display the quiz questions
        // read the user responses from the console
        // store the user respones in the quiz object
        if (questionList.size() > 0) {
            for (int i = 0; i < questionList.size(); i++) {
                System.out.println(questionList.get(i).question + "(" + questionList.get(i).marks + ")");
                for (int j = 0 ; j < questionList.get(i).choices.length - 1; j++) {
                    System.out.print(questionList.get(i).choices[j] + "        ");
                }
                // int z = questionList.get(i).choices.length;
                // while (z > 0) {
                //  System.out.println(questionList.get(i).choices[] + "        ");
                // }
                System.out.println(questionList.get(i).choices[questionList.get(i).choices.length-1]);
                System.out.println();
            }
            System.out.println();
        }

        while (answerCount > 0) {
            String line = s.nextLine();
            String[] key = line.split(" ");
            if (key[1].equals("a")) {
                key[1] = "1";
            } else if (key[1].equals("b") ) {
                key[1] = "2";
            } else if (key[1].equals("c")) {
                key[1] = "3";
            } else if (key[1].equals("d")) {
                key[1] = "4";
            }
            answerList.add(key[1]);
            answerCount--;
        }
    }

    /**
     * Displays the score report
     *
     * @param      quiz     The quiz object
     */
    public static void displayScore(final Quiz quiz) {
        // write your code here to display the score report
        int finalScore = 0;
        for (int i = 0; i < questionList.size(); i++) {
            System.out.println(questionList.get(i).question);
            if (answerList.get(i).equals(questionList.get(i).answer)) {
                System.out.println(" Correct Answer! - Marks Awarded: " + questionList.get(i).marks);
                finalScore += Integer.parseInt(questionList.get(i).marks);
            } else {
                System.out.println(" Wrong Answer! - Penalty: " + questionList.get(i).penalty);
                finalScore += Integer.parseInt(questionList.get(i).penalty);
            }
        }
        if (questionList.size() != 0) {
            System.out.println("Total Score: " + finalScore);
        }
    }
}

