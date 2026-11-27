import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        User anna = new User(
                "user-101",
                "Анна",
                "anna@university.edu",
                null,
                Set.of(EmailChannel.CHANNEL_ID, SmsChannel.CHANNEL_ID)
        );
        User boris = new User(
                "user-102",
                "Борис",
                "boris@university.edu",
                "+7-900-123-45-67",
                Set.of(SmsChannel.CHANNEL_ID, PushChannel.CHANNEL_ID)
        );

        List<User> users = List.of(anna, boris);

        NotificationChannel emailChannel = new EmailChannel();
        NotificationChannel smsChannel = new SmsChannel();
        NotificationChannel pushChannel = new PushChannel();

        NotificationService notificationService = new NotificationService();

        System.out.println("=== Рассылка 1: Изменение аудитории (Email, SMS) ===");
        Notification classroomNotification = new ClassroomChangeNotification(
                "Изменение расписания",
                "304"
        );
        List<NotificationChannel> firstWaveChannels = List.of(emailChannel, smsChannel);
        notificationService.broadcast(users, classroomNotification, firstWaveChannels);

        System.out.println();
        System.out.println("=== Рассылка 2: Напоминание о дедлайне (Email, SMS, Push) ===");
        Notification deadlineNotification = new DeadlineReminderNotification(
                "Учебный дедлайн",
                "Лабораторная работа № 5",
                "13 ноября"
        );
        List<NotificationChannel> secondWaveChannels = List.of(emailChannel, smsChannel, pushChannel);
        notificationService.broadcast(users, deadlineNotification, secondWaveChannels);
    }
}
