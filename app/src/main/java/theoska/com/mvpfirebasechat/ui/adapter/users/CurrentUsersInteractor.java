package theoska.com.mvpfirebasechat.ui.adapter.users;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

import theoska.com.mvpfirebasechat.NetworkEndpoint;
import theoska.com.mvpfirebasechat.model.User;

/**
 * Created by theoska on 6/9/17.
 */
public class CurrentUsersInteractor {
    private final CurrentUsersPresenter presenter;
        DatabaseReference currentUsersRef = FirebaseDatabase.getInstance().getReference().child(NetworkEndpoint.URL_CURRENT_USERS);

    public CurrentUsersInteractor(CurrentUsersPresenter pre) {
        this.presenter = pre;
    }

    public void request() {
        currentUsersRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                ArrayList<User> mListOfUsers = new ArrayList<>();
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    mListOfUsers.add(x.getValue(User.class));
                }
                presenter.getChildren(mListOfUsers);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
