package theoska.com.mvpfirebasechat.ui.registration.interactor;


import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.StorageReference;

import java.util.HashMap;
import java.util.Map;

import theoska.com.mvpfirebasechat.NetworkEndpoint;
import theoska.com.mvpfirebasechat.model.User;
import theoska.com.mvpfirebasechat.ui.registration.presenter.FirebaseUserRegisterPresenter;

/**
 * Created by theoska on 6/9/17.
 */
public class RegisterInteractor implements RInteractor {
    DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child(NetworkEndpoint.URL_USER);
    FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();

    String key;
    StorageReference storageReference;

    private final FirebaseUserRegisterPresenter presenter;

    public RegisterInteractor(FirebaseUserRegisterPresenter pre) {
        this.presenter = pre;
    }

    @Override
    public void receiveRegisterRequest(final String username, final String email, final String password, final String emoji) {
        firebaseAuth.createUserWithEmailAndPassword(email , password).addOnSuccessListener(new OnSuccessListener<AuthResult>() {
            @Override
            public void onSuccess(AuthResult authResult) {
                final User userMessage = new User(username, password, email, emoji, authResult.getUser().getUid());
                userRef.child(authResult.getUser().getUid()).setValue(userMessage);
                presenter.onSuccess();

            }
        });
    }


    @Override
    public Map<String, Object> createUser(String username, String emoji) {
        Map<String, Object> user = new HashMap<>();
        user.put("username", username);
        user.put("emoji", emoji);
        return user;
    }
}
