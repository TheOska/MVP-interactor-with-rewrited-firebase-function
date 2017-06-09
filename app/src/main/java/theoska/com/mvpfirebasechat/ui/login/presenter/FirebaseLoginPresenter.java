package theoska.com.mvpfirebasechat.ui.login.presenter;



/**
 * Created by theoska on 6/9/17.
 */
public interface FirebaseLoginPresenter {
    void receiveUserLogin(String email, String password);
    void onFailure();
    void onSuccess(String user, String uid, String emoji);
}
