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