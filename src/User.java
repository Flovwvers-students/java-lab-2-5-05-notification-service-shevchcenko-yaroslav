import java.util.Collections;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class User {

    private final String id;
    private final String name;
    private final String email;
    private final String phone;
    private final Set<String> enabledChannels;

    public User(String id, String name, String email, String phone, Set<String> enabledChannels) {
        if (id == null || id.isBlank()) {
            throw new IllegalArgumentException("ID пользователя не может быть пустым.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Имя пользователя не может быть пустым.");
        }

        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.enabledChannels = (enabledChannels == null)
                ? Collections.emptySet()
                : Collections.unmodifiableSet(new HashSet<>(enabledChannels));
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public Set<String> getEnabledChannels() {
        return enabledChannels;
    }

    public boolean isNotificationEnabled(String channelId) {
        if (channelId == null) {
            return false;
        }

        return enabledChannels.contains(channelId);
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }

        if (other instanceof User == false) {
            return false;
        }

        User otherUser = (User) other;

        return id.equals(otherUser.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
