package theoska.com.mvpfirebasechat.ui.registration.view;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import theoska.com.mvpfirebasechat.R;

/**
 * Created by theoska on 6/9/17.
 */
public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void onStart() {
        super.onStart();
        addStartFragment();
    }

    private void addStartFragment() {
        FragmentManager manager = getSupportFragmentManager();
        manager.beginTransaction().setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN).add(R.id.register_activity_frame_layout, new ChooseUsernameFragment(), "username").commit();
    }
}