package theoska.com.mvpfirebasechat.model;

/**
 * Created by theoska on 6/9/17.
 */

public class User {
    private String username;
    private String email;
    private String emoji;
    private String password;
    private String uid;
    public User(){}
    public User(String username, String password, String email, String emoji, String uid) {
        this.username = username;
        this.email = email;
        this.emoji = emoji;
        this.password = password;
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmoji() {
        return emoji;
    }

    public void setEmoji(String emoji) {
        this.emoji = emoji;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
