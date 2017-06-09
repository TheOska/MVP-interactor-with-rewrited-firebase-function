package theoska.com.mvpfirebasechat.ui.registration.presenter;

/**
 * Created by theoska on 6/9/17.
 */
public interface UsernamePresenter {
    void checkIfUsernameIsTaken(String username);
    void onUserAlreadyExists();
    void onUserDoesNotExist();
}
