import java.util.Scanner;
import java.util.Arrays;

/**
  * write your code below this comment
  */

class Task {
    private String title;
    private String assignedTo;
    private int timeToComplete;
    private boolean important;
    private boolean urgent;
    private String status;

    Task(final String title, final String assignedTo, final int timeToComplete, final boolean important, final boolean urgent, final String status) {
        this.title = title;
        this.assignedTo = assignedTo;
        this.timeToComplete = timeToComplete;
        this.important = important;
        this.urgent = urgent;
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public String getAssignedTo() {
        return assignedTo;
    }

    public int getTimeToComplete() {
        return timeToComplete;
    }

    public boolean getImportant() {
        return important;
    }

    public boolean getUrgent() {
        return urgent;
    }

    public String getStatus() {
        return status;
    }

    public String toString() {
        String ans = title + ", " + assignedTo + ", " + timeToComplete + ", ";
        if (important == true) {
            ans += "Important" + ", ";
        } else {
            ans += "Not Important" + ", ";
        }

        if (urgent == true) {
            ans += "Urgent" + ", ";
        } else {
            ans += "Not Urgent" + ", ";
        }
        ans += status;
        return ans;
    }
}

class Todoist {
    Task[] tasks;
    int size;

    Todoist() {
        tasks = new Task[10];
        size = 0;
    }

    public int size() {
        return size;
    }

    public void addTask(final Task task1) {
        try {
            tasks[size] = task1;
            size++;
        } catch (Exception e) {
            resize();
            addTask(task1);
        }
    }

    private void resize() {
        tasks = Arrays.copyOf(tasks, 2 * tasks.length);
    }

    public String toString() {
        String str = "";
        for (int i = 0; i < size; i++) {
            str += tasks[i] + "\n";
        }
        return str;
    }

}

/**
 * Class for todoist main.
 */
public class TodoistMain {

    /**
     * Starts a test.
     */
    public static void startTest() {
        Todoist todo = new Todoist();
        Scanner s = new Scanner(System.in);
        while (s.hasNext()) {
            String[] tokens = s.nextLine().split(",");
            switch (tokens[0]) {
            case "task":
                testTask(tokens);
                break;
            case "add-task":
                testAddTask(todo, tokens);
                break;
            case "print-todoist":
                System.out.println(todo);
                break;
            // case "get-next":
            //     System.out.println(todo.getNextTask(tokens[1]));
            //     break;
            // case "get-next-n":
            //     int n = Integer.parseInt(tokens[2]);
            //     Task[] tasks = todo.getNextTask(tokens[1], n);
            //     System.out.println(Arrays.deepToString(tasks));
            //     break;
            // case "total-time":
            //     System.out.println(todo.totalTime4Completion());
            //     break;
            default:
                break;
            }
        }
    }

    // public static Todoist getNextTask(final String name) {
    //     for (int i = 0; i < tasks.size(); i++) {
    //         return tasks[i];
    //     }
    // }

    /**
     * method to test add task.
     *
     * @param      todo    The todo
     * @param      tokens  The tokens
     */
    public static void testAddTask(final Todoist todo, final String[] tokens) {
        try {
            todo.addTask(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * method to test the creation of task object.
     *
     * @param      tokens  The tokens
     */
    public static void testTask(final String[] tokens) {
        try {
            System.out.println(createTask(tokens));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Creates a task object.
     *
     * @param      tokens     The tokens
     *
     * @return     Task object
     *
     * @throws     Exception  if task inputs are invalid
     */
    public static Task createTask(final String[] tokens) throws Exception {
        // System.out.println(Arrays.toString(tokens));
        if (tokens[1].equals("")) {
            throw new Exception("Title not provided");
        }
        String title = tokens[1];
        String assignedTo = tokens[2];
        int timeToComplete = Integer.parseInt(tokens[3]);
        if (timeToComplete < 0) {
            throw new Exception("Invalid timeToComplete " + timeToComplete);
        }
        boolean important = tokens[4].equals("y");
        boolean urgent = tokens[5].equals("y");
        String status = tokens[6];
        if (status == "todo") {
            if (status == "done") {
                throw new Exception("invalid status");
            }
        }
        return new Task(
                   title, assignedTo, timeToComplete, important, urgent, status);
    }

    /**
     * main method.
     *
     * @param      args  The command line arguments
     */
    public static void main(final String[] args) {
        startTest();
    }
}
