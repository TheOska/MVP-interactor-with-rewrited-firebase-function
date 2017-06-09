package theoska.com.mvpfirebasechat.ui.registration.view;

/**
 * Created by theoska on 6/9/17.
 */
public interface RegisterView {
    void onSuccess();

    void onFailure();

    void spinProgressBar();

    void stopProgressBar();
}
