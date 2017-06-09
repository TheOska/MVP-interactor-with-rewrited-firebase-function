package theoska.com.mvpfirebasechat.ui.adapter.chat;

import theoska.com.mvpfirebasechat.model.Message;

/**
 * Created by theoska on 6/9/17.
 */
public interface MessagePresenter {
    void sendMessageToAdapter(Message message);
    void requestMessages();
}
