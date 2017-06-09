package theoska.com.mvpfirebasechat.ui.adapter.users;


import java.util.ArrayList;

import theoska.com.mvpfirebasechat.model.User;

/**
 * Created by theoska on 6/9/17.
 */
public class CurrentUsersPresenterImpl implements CurrentUsersPresenter {
    private final CurrentAdapterView adapterView;
    private final CurrentUsersInteractor interactor;


    public CurrentUsersPresenterImpl(CurrentAdapterView view) {
        this.adapterView = view;
        this.interactor = new CurrentUsersInteractor(this);
    }

    @Override
    public void getChildren(ArrayList<User> users) {
        adapterView.addAll(users);
    }

    @Override
    public void request() {
        interactor.request();
    }

}
