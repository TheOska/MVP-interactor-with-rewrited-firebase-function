package theoska.com.mvpfirebasechat.ui.main.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import theoska.com.mvpfirebasechat.R;
import theoska.com.mvpfirebasechat.ui.login.view.LoginActivity;
import theoska.com.mvpfirebasechat.ui.main.presenter.MainActivityPresenterImpl;
import theoska.com.mvpfirebasechat.ui.registration.view.RegisterActivity;


/**  * Created by theoska on 6/9/17.  */
public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainView {
    private TextView mOnlineUsers;
    private Button mLoginButton;
    private Button mRegisterButton;
    private MainActivityPresenterImpl presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUI();
    }

    @Override
    protected void onStart() {
        super.onStart();
        presenter = new MainActivityPresenterImpl(this);
        presenter.receiveRequest();
    }

    private void setUI() {
        mOnlineUsers = (TextView) findViewById(R.id.current_number_of_users_text_view);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mRegisterButton = (Button) findViewById(R.id.register_button);

        mLoginButton.setOnClickListener(this);
        mRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mLoginButton) {
            startActivity(new Intent(this, LoginActivity.class));
        }
        if (v == mRegisterButton) {
            startActivity(new Intent(this, RegisterActivity.class));
        }
    }

    @Override
    public void setNumberOfUsersTextView(String numberOfUsers) {
        mOnlineUsers.setText(numberOfUsers);
    }
}