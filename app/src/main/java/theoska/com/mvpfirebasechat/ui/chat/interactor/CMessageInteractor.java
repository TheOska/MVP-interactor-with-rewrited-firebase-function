package theoska.com.mvpfirebasechat.ui.chat.interactor;

import java.util.Map;

/**
 * Created by theoska on 6/9/17.
 */
public interface CMessageInteractor {
    void pushMessageToFirebase(String author, String message, String emoji);

    Map<String, Object> createMessage(String message, String author, String emoji);
}
