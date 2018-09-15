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