public abstract class Notification {

    private static final String FORMAT_TEMPLATE = "%s: %s";

    private final String title;

    protected Notification(String title) {
        if (title == null || title.isBlank()) {
            throw new IllegalArgumentException("Заголовок уведомления не может быть пустым.");
        }

        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    public String format() {
        return String.format(FORMAT_TEMPLATE, getTitle(), formatBody());
    }

    protected abstract String formatBody();
}
