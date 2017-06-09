package theoska.com.mvpfirebasechat.ui.main.presenter;

/**
 * Created by theoska on 6/9/17.
 */
public interface MainPresenter {
    void receiveRequest();
    String getNumberOfUsers(long numberOfUsers);
    void sendNumberOfChildren(long number);
}
