package theoska.com.mvpfirebasechat.ui.registration.view;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import theoska.com.mvpfirebasechat.R;
import theoska.com.mvpfirebasechat.ui.registration.presenter.FirebaseUserRegisterPresenterImpl;


/**
 * Created by theoska on 6/9/17.
 */
public class ChooseEmailFragment extends Fragment implements View.OnClickListener, RegisterView {
    private ProgressBar mProgressBar;
    private EditText mEmailEditText;
    private EditText mPasswordEditText;
    private Button mRegisterButton;
    private FirebaseUserRegisterPresenterImpl presenter;

    public static ChooseEmailFragment newInstance(Bundle data) {
        ChooseEmailFragment f = new ChooseEmailFragment();
        f.setArguments(data);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_register_third, container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        createUIWidgets(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        presenter = new FirebaseUserRegisterPresenterImpl(this);
    }

    private void createUIWidgets(View view) {
        mProgressBar = (ProgressBar) view.findViewById(R.id.progress_bar);
        mEmailEditText = (EditText) view.findViewById(R.id.reg_email_edit_text);
        mPasswordEditText = (EditText) view.findViewById(R.id.reg_password_edit_text);
        mRegisterButton = (Button) view.findViewById(R.id.register_button);
        mRegisterButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Bundle data = this.getArguments();
        presenter.receiveRegisterRequest(data.getString("username"), mEmailEditText.getText().toString(), mPasswordEditText.getText().toString(), data.getString("emoji"));
    }


    @Override
    public void onSuccess() {
        Toast.makeText(getActivity(), R.string.register_success, Toast.LENGTH_SHORT).show();
        getActivity().finish();
    }

    @Override
    public void onFailure() {
        Toast.makeText(getActivity(), R.string.register_failure, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void spinProgressBar() {
        mProgressBar.setVisibility(View.VISIBLE);
    }

    @Override
    public void stopProgressBar() {
        mProgressBar.setVisibility(View.GONE);
    }
}
