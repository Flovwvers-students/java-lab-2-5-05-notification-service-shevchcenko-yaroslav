public class SmsChannel implements NotificationChannel {

    public static final String CHANNEL_ID = "sms";

    @Override
    public String id() {
        return CHANNEL_ID;
    }

    @Override
    public void send(User user, String message) throws NotificationDeliveryException {
        if (user == null) {
            throw new NotificationDeliveryException("Пользователь не задан.");
        }

        String phone = user.getPhone();

        if (phone == null || phone.isBlank()) {
            throw new NotificationDeliveryException(
                    String.format("У пользователя %s отсутствует номер телефона.", user.getName())
            );
        }

        System.out.printf("[SMS] Доставлено пользователю %s (%s): %s%n", user.getName(), phone, message);
    }
}
