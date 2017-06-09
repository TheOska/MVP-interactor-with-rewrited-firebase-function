package theoska.com.mvpfirebasechat.ui.registration.interactor;

import java.util.Map;

/**
 * Created by theoska on 6/9/17.
 */
public interface RInteractor {
    void receiveRegisterRequest(String username, String email, String password, String emoji);
    Map<String, Object> createUser(String username, String emoji);
}
