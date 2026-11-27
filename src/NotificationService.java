import java.util.List;

public class NotificationService {

    public void broadcast(List<User> users, Notification notification, List<NotificationChannel> channels) {
        if (users == null || notification == null || channels == null) {
            throw new IllegalArgumentException("Списки пользователей, каналов и само уведомление не должны быть null.");
        }

        String formattedMessage = notification.format();

        for (User user : users) {
            for (NotificationChannel channel : channels) {
                deliverToSingleChannel(user, channel, formattedMessage);
            }
        }
    }

    private void deliverToSingleChannel(User user, NotificationChannel channel, String formattedMessage) {
        String channelId = channel.id();

        if (!user.isNotificationEnabled(channelId)) {
            System.out.printf("Пропущено: канал '%s' отключён у пользователя %s.%n", channelId, user.getName());
            return;
        }

        try {
            channel.send(user, formattedMessage);
        } catch (NotificationDeliveryException exception) {
            System.out.printf(
                    "Ошибка доставки по каналу '%s' для пользователя %s: %s%n",
                    channelId,
                    user.getName(),
                    exception.getMessage()
            );
        }
    }
}
