package theoska.com.mvpfirebasechat.ui.login.view;

/**
 * Created by theoska on 6/9/17.
 */
public interface LoginView {
    void logTheUserIn(String username, String uid, String emoji);
    void onFailure();
    void spinProgressBar();
    void stopProgressBar();
}
