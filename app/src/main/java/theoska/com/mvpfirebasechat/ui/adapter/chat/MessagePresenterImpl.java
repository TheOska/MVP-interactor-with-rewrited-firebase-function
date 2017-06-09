package theoska.com.mvpfirebasechat.ui.adapter.chat;


import theoska.com.mvpfirebasechat.model.Message;

/**
 * Created by theoska on 6/9/17.
 */
public class MessagePresenterImpl implements MessagePresenter {
    private final MessageAdapterView adapterView;
    private final MessageInteractor interactor;

    public MessagePresenterImpl(MessageAdapterView view) {
        this.adapterView = view;
        this.interactor = new MessageInteractor(this);
    }

    @Override
    public void sendMessageToAdapter(Message message) {
        adapterView.addItem(message);
    }

    @Override
    public void requestMessages() {
        interactor.request();
    }
}
