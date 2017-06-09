package theoska.com.mvpfirebasechat.ui.registration.presenter;


import theoska.com.mvpfirebasechat.ui.registration.interactor.UsernameInteractor;
import theoska.com.mvpfirebasechat.ui.registration.view.UsernameFragmentView;

/**
 * Created by theoska on 6/9/17.
 */
public class UsernamePresenterImpl implements UsernamePresenter {
    private final UsernameFragmentView usernameFragmentView;
    private final UsernameInteractor interactor;

    public UsernamePresenterImpl(UsernameFragmentView view) {
        this.usernameFragmentView = view;
        this.interactor = new UsernameInteractor(this);
    }

    @Override
    public void checkIfUsernameIsTaken(String username) {
        interactor.checkIfUsernameExists(username);
    }

    @Override
    public void onUserAlreadyExists() {
        usernameFragmentView.onFailure();
    }

    @Override
    public void onUserDoesNotExist() {
        usernameFragmentView.onSuccess();
    }
}
