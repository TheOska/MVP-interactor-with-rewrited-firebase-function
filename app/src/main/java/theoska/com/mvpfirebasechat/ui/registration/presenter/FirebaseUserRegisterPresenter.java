package theoska.com.mvpfirebasechat.ui.registration.presenter;

/**
 * Created by theoska on 6/9/17.
 */
public interface FirebaseUserRegisterPresenter {
    void receiveRegisterRequest(String username, String email, String password, String emoji);

    void onFailure();

    void onSuccess();
}
