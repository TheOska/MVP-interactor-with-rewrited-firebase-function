package theoska.com.mvpfirebasechat.ui.registration.interactor;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import theoska.com.mvpfirebasechat.NetworkEndpoint;
import theoska.com.mvpfirebasechat.model.User;
import theoska.com.mvpfirebasechat.ui.registration.presenter.UsernamePresenter;

/**
 * Created by theoska on 6/9/17.
 */
public class UsernameInteractor implements UInteractor {
    private final UsernamePresenter presenter;
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child(NetworkEndpoint.URL_USER);
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
    public UsernameInteractor(UsernamePresenter pre) {
        this.presenter = pre;
    }

    @Override
    public void checkIfUsernameExists(final String username) {
        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                boolean exists = false;
                for (DataSnapshot x : dataSnapshot.getChildren()) {
                    User user = x.getValue(User.class);
                    if (user.getUsername().equals(username)) {
                        exists = true;
                        presenter.onUserAlreadyExists();
                    }
                    if (exists) break;
                }
                if (!exists) presenter.onUserDoesNotExist();
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        userRef.addListenerForSingleValueEvent(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                boolean exists = false;
//                for (DataSnapshot x : dataSnapshot.getChildren()) {
//                    User user = x.getValue(User.class);
//                    if (user.getUsername().equals(username)) {
//                        exists = true;
//                        presenter.onUserAlreadyExists();
//                    }
//                    if (exists) break;
//                }
//                if (!exists) presenter.onUserDoesNotExist();
//            }
//
//        });
    }
}
