import java.util.List;
import java.util.Set;

public class Main {

    public static void main(String[] args) {
        String annaId = "57923471";
        String annaName = "Анна";
        String annaEmail = "anna@university.edu";
        String annaPhone = null;
        Set<String> annaChannels = Set.of(EmailChannel.CHANNEL_ID, SmsChannel.CHANNEL_ID);
        User anna = new User(annaId, annaName, annaEmail, annaPhone, annaChannels);

        String borisId = "9573235";
        String borisName = "Борис";
        String borisEmail = "boris@university.edu";
        String borisPhone = "+7-900-123-45-67";
        Set<String> borisChannels = Set.of(SmsChannel.CHANNEL_ID, PushChannel.CHANNEL_ID);
        User boris = new User(borisId, borisName, borisEmail, borisPhone, borisChannels);

        List<User> users = List.of(anna, boris);

        NotificationChannel emailChannel = new EmailChannel();
        NotificationChannel smsChannel = new SmsChannel();
        NotificationChannel pushChannel = new PushChannel();

        NotificationService notificationService = new NotificationService();

        System.out.println("=== Рассылка 1: Изменение аудитории (Email, SMS) ===");
        String classroomTitle = "Изменение расписания";
        String targetClassroom = "304";
        Notification classroomNotification = new ClassroomChangeNotification(classroomTitle, targetClassroom);
        List<NotificationChannel> firstWaveChannels = List.of(emailChannel, smsChannel, pushChannel);
        notificationService.broadcast(users, classroomNotification, firstWaveChannels);

        System.out.println();
        System.out.println("=== Рассылка 2: Напоминание о дедлайне (Email, SMS, Push) ===");
        String deadlineTitle = "Учебный дедлайн";
        String assignmentTitle = "Лабораторная работа № 5";
        String dueDate = "13 ноября";
        Notification deadlineNotification = new DeadlineReminderNotification(deadlineTitle, assignmentTitle, dueDate);
        List<NotificationChannel> secondWaveChannels = List.of(emailChannel, smsChannel, pushChannel);
        notificationService.broadcast(users, deadlineNotification, secondWaveChannels);
    }
}
