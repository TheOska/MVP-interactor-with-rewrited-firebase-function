package theoska.com.mvpfirebasechat.ui.login.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import theoska.com.mvpfirebasechat.R;
import theoska.com.mvpfirebasechat.ui.chat.view.ChatScreenActivity;
import theoska.com.mvpfirebasechat.ui.login.presenter.FirebaseLoginPresenterImpl;


/**
 * Created by theoska on 6/9/17.
 */
public class LoginActivity extends AppCompatActivity implements LoginView, View.OnClickListener {
    private ProgressBar mProgressBar;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mLoginButton;
    private FirebaseLoginPresenterImpl presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        createUI();
    }

    @Override
    public void logTheUserIn(String username, String uid, String emoji) {
        Intent i = new Intent(this, ChatScreenActivity.class);
        i.putExtra("uid", uid); //uid not key
        i.putExtra("username", username);
        i.putExtra("emoji", emoji);
        startActivity(i);
        Toast.makeText(this, "success " + username + " " + uid,Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onFailure() {
        Toast.makeText(LoginActivity.this, R.string.on_failure_message, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void spinProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }

    private void createUI() {
        mProgressBar = (ProgressBar) findViewById(R.id.progress_bar);
        mEmailEditText = (EditText) findViewById(R.id.login_email_edit_text);
        mPasswordEditText = (EditText) findViewById(R.id.login_password_edit_text);
        mLoginButton = (Button) findViewById(R.id.login_button);
        mLoginButton.setOnClickListener(this);
        presenter = new FirebaseLoginPresenterImpl(this);
    }

    @Override
    public void onClick(View v) {
        presenter.receiveUserLogin(mEmailEditText.getText().toString(), mPasswordEditText.getText().toString());
    }
}
