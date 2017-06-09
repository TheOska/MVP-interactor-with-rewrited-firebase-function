package theoska.com.mvpfirebasechat.ui.chat.interactor;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import theoska.com.mvpfirebasechat.NetworkEndpoint;

/**
 * Created by theoska on 6/9/17.
 */
//When the chat activity's onDestroy is called, "logs the User out"
public class ChatLoginInteractor implements CLoginInteractor {
    @Override
    public void logTheUserOut(String uid) {
        DatabaseReference userRef = FirebaseDatabase.getInstance().getReference().child(NetworkEndpoint.URL_CURRENT_USERS).child(uid);

//        Firebase userRef = new Firebase("https://fir-mvpinteractor.firebaseio.com/currentUsers/" + uid);
        userRef.removeValue();
    }
}
