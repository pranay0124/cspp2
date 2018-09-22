import java.util.Arrays;
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

    public void totalTime4Completion() {
        int sum = 0;
        for (int i = 0; i < size; i++) {
            if (tasks[i].getStatus().equals("todo")) {
                sum += tasks[i].getTimeToComplete();
            }
        }
        System.out.println(sum);
    }
}