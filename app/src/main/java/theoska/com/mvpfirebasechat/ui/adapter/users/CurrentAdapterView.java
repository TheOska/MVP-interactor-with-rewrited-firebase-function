package theoska.com.mvpfirebasechat.ui.adapter.users;


import java.util.ArrayList;

import theoska.com.mvpfirebasechat.model.User;

/**
 * Created by theoska on 6/9/17.
 */
public interface CurrentAdapterView {
    void addAll(ArrayList<User> users);
    void request();
}
