package theoska.com.mvpfirebasechat.ui.chat.presenter;


import theoska.com.mvpfirebasechat.ui.chat.interactor.ChatLoginInteractor;

/**  * Created by theoska on 6/9/17.  */
public class FirebaseChatLoginPresenterImpl implements FirebaseChatLoginPresenter {
    private final ChatLoginInteractor interactor;

    public FirebaseChatLoginPresenterImpl() {
        this.interactor = new ChatLoginInteractor();
    }

    @Override
    public void removeUserFromCurrentUsers(String uid) {
        interactor.logTheUserOut(uid);
    }
}
