package theoska.com.mvpfirebasechat.ui.adapter.users;


import java.util.ArrayList;

import theoska.com.mvpfirebasechat.model.User;

/**
 * Created by theoska on 6/9/17.
 */
public interface CurrentUsersPresenter {
    void getChildren(ArrayList<User> users);
    void request();
}
