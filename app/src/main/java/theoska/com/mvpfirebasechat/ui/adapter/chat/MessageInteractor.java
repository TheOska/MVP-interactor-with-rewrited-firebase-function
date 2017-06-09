package theoska.com.mvpfirebasechat.ui.adapter.chat;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;

import theoska.com.mvpfirebasechat.NetworkEndpoint;
import theoska.com.mvpfirebasechat.model.Message;

/**
 * Created by theoska on 6/9/17.
 */
public class MessageInteractor {
    private final MessagePresenter presenter;
    DatabaseReference mMessagesRef = FirebaseDatabase.getInstance().getReference().child(NetworkEndpoint.URL_MESSAGE);

    private final Query mMessageQuery;


    public MessageInteractor(MessagePresenter pre) {
        this.presenter = pre;
        this.mMessageQuery = mMessagesRef.orderByValue().limitToLast(100);
    }

    public void request() {
        mMessageQuery.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                presenter.sendMessageToAdapter(dataSnapshot.getValue(Message.class));
            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
