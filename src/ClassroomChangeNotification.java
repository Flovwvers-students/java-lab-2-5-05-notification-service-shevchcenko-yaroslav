public class ClassroomChangeNotification extends Notification {

    private final String classroomNumber;

    public ClassroomChangeNotification(String title, String classroomNumber) {
        super(title);

        if (classroomNumber == null || classroomNumber.isBlank()) {
            throw new IllegalArgumentException("Номер аудитории не может быть пустым.");
        }

        this.classroomNumber = classroomNumber;
    }

    public String getClassroomNumber() {
        return classroomNumber;
    }

    @Override
    protected String formatBody() {
        return String.format("Пара перенесена в аудиторию %s", getClassroomNumber());
    }
}
