package theoska.com.mvpfirebasechat.ui.chat.presenter;


import theoska.com.mvpfirebasechat.ui.chat.interactor.ChatMessageInteractor;

/**
 * Created by theoska on 6/9/17.
 */
public class FirebaseChatMessagePresenterImpl implements FirebaseChatMessagePresenter {
    private final ChatMessageInteractor interactor;

    public FirebaseChatMessagePresenterImpl() {
        this.interactor = new ChatMessageInteractor();
    }

    @Override
    public void sendMessage(String author, String message, String emoji) {
        interactor.pushMessageToFirebase(author, message, emoji);
    }
}
