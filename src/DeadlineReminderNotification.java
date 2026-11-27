public class DeadlineReminderNotification extends Notification {

    private final String assignmentTitle;
    private final String dueDate;

    public DeadlineReminderNotification(String title, String assignmentTitle, String dueDate) {
        super(title);

        if (assignmentTitle == null || assignmentTitle.isBlank()) {
            throw new IllegalArgumentException("Название работы не может быть пустым.");
        }

        if (dueDate == null || dueDate.isBlank()) {
            throw new IllegalArgumentException("Дата сдачи не может быть пустой.");
        }

        this.assignmentTitle = assignmentTitle;
        this.dueDate = dueDate;
    }

    public String getAssignmentTitle() {
        return assignmentTitle;
    }

    public String getDueDate() {
        return dueDate;
    }

    @Override
    protected String formatBody() {
        return String.format("Напоминание о сдаче «%s» до %s", getAssignmentTitle(), getDueDate());
    }
}
