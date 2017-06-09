package theoska.com.mvpfirebasechat.ui.main.interactor;


import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import theoska.com.mvpfirebasechat.NetworkEndpoint;
import theoska.com.mvpfirebasechat.ui.main.presenter.MainPresenter;

/**
 * Created by theoska on 6/9/17.
 */
public class MainInteractor implements MInteractor {
    private final MainPresenter presenter;
    DatabaseReference mainRef = FirebaseDatabase.getInstance().getReference().child(NetworkEndpoint.URL_CURRENT_USERS);

    public MainInteractor(MainPresenter pre) {
        this.presenter = pre;
    }

    @Override
    public void receiveRequest() {
        mainRef.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                presenter.sendNumberOfChildren(dataSnapshot.getChildrenCount());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
//        mainRef.addValueEventListener(new ValueEventListener() {
//            @Override
//            public void onDataChange(DataSnapshot dataSnapshot) {
//                  presenter.sendNumberOfChildren(dataSnapshot.getChildrenCount());
//            }
//
//            @Override
//            public void onCancelled(FirebaseError firebaseError) {
//            }
//        });
    }
}
