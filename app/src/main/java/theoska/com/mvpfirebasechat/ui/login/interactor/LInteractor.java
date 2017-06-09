package theoska.com.mvpfirebasechat.ui.login.interactor;

import java.util.Map;

/**
 * Created by theoska on 6/9/17.
 */
public interface LInteractor {
    void attemptToLogIn(String email, String password);

    Map<String, Object> createUser(String user, String emoji);

}
