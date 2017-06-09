package theoska.com.mvpfirebasechat.ui.chat.presenter;

/**
 * Created by theoska on 6/9/17.
 */
public interface FirebaseChatMessagePresenter {
    void sendMessage(String author, String message, String emoji);
}
