public class EmailChannel implements NotificationChannel {

    public static final String CHANNEL_ID = "email";

    @Override
    public String id() {
        return CHANNEL_ID;
    }

    @Override
    public void send(User user, String message) throws NotificationDeliveryException {
        if (user == null) {
            throw new NotificationDeliveryException("Пользователь не задан.");
        }

        String email = user.getEmail();

        if (email == null || email.isBlank()) {
            throw new NotificationDeliveryException(
                    String.format("У пользователя %s отсутствует адрес электронной почты.", user.getName())
            );
        }

        System.out.printf("[EMAIL] Доставлено пользователю %s (%s): %s%n", user.getName(), email, message);
    }
}
