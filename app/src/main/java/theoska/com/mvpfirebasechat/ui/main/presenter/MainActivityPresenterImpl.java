package theoska.com.mvpfirebasechat.ui.main.presenter;


import theoska.com.mvpfirebasechat.ui.main.interactor.MainInteractor;
import theoska.com.mvpfirebasechat.ui.main.view.MainView;

/**
 * Created by theoska on 6/9/17.
 */
public class MainActivityPresenterImpl implements MainPresenter {
    private final MainView mainView;
    private final MainInteractor interactor;

    public MainActivityPresenterImpl(MainView view) {
        this.mainView = view;
        interactor = new MainInteractor(this);
    }


    @Override
    public void receiveRequest() {
        interactor.receiveRequest();
    }

    @Override
    public String getNumberOfUsers(long numberOfUsers) {
        return "Online users: " + String.valueOf(numberOfUsers);
    }

    @Override
    public void sendNumberOfChildren(long number) {
        mainView.setNumberOfUsersTextView(getNumberOfUsers(number));
    }
}
