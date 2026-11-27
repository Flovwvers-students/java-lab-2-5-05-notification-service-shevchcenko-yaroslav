public class PushChannel implements NotificationChannel {

    public static final String CHANNEL_ID = "push";

    @Override
    public String id() {
        return CHANNEL_ID;
    }

    @Override
    public void send(User user, String message) throws NotificationDeliveryException {
        if (user == null) {
            throw new NotificationDeliveryException("Пользователь не задан.");
        }

        String userId = user.getId();

        if (userId == null || userId.isBlank()) {
            throw new NotificationDeliveryException(
                    String.format("У пользователя %s отсутствует ID для Push-уведомлений.", user.getName())
            );
        }

        System.out.printf("[PUSH] Доставлено пользователю %s (ID: %s): %s%n", user.getName(), userId, message);
    }
}
