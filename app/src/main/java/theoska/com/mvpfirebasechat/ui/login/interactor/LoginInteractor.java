package theoska.com.mvpfirebasechat.ui.login.interactor;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Map;

import theoska.com.mvpfirebasechat.NetworkEndpoint;
import theoska.com.mvpfirebasechat.model.User;
import theoska.com.mvpfirebasechat.ui.login.presenter.FirebaseLoginPresenter;

/**
 * Created by theoska on 6/9/17.
 */
public class LoginInteractor implements LInteractor {
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child(NetworkEndpoint.URL_USER);
    DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference();

    FirebaseAuth auth = FirebaseAuth.getInstance();
    private FirebaseAuth.AuthStateListener mAuthListener;
    private final FirebaseLoginPresenter presenter;

    public LoginInteractor(FirebaseLoginPresenter pre) {
        this.presenter = pre;
    }

    @Override
    public void attemptToLogIn(String email, String password) {
        auth.signInWithEmailAndPassword(email ,password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                userRef.child(authResult.getUser().getUid()).addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        User user = dataSnapshot.getValue(User.class);
                        databaseReference.child(NetworkEndpoint.URL_CURRENT_USERS+"/" + user.getUid())
                                .setValue(createUser(user.getUsername(), user.getEmoji()));
                        presenter.onSuccess(user.getUsername(), user.getUid(), user.getEmoji());

                    }

                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        presenter.onFailure();
                    }
                });
            }


        });


    }

    @Override
    public Map<String, Object> createUser(String user, String emoji) {
        Map<String, Object> userToCreate = new HashMap<>();
        userToCreate.put("username", user);
        userToCreate.put("emoji", emoji);
        return userToCreate;
    }
}
