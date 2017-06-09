package theoska.com.mvpfirebasechat.ui.chat.interactor;


import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;

import theoska.com.mvpfirebasechat.NetworkEndpoint;

/**
 * Created by theoska on 6/9/17.
 */
//pushes a message to Firebase on every onClick method usage
public class ChatMessageInteractor implements CMessageInteractor {

    @Override
    public void pushMessageToFirebase(String author, String message, String emoji) {
        DatabaseReference messageRef = FirebaseDatabase.getInstance().getReference().child(NetworkEndpoint.URL_MESSAGE);

        messageRef.push().setValue(createMessage(message, author, emoji));
    }

    @Override
    public Map<String, Object> createMessage(String message, String author, String emoji) {
        Map<String, Object> values = new HashMap<>();
        values.put("message", message);
        values.put("author", author);
        values.put("emoji", emoji);
        return values;
    }
}
