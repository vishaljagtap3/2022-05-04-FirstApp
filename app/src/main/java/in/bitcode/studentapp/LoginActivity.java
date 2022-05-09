package in.bitcode.studentapp;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;

public class LoginActivity extends Activity {

    private TextView txtWelcomeMessage;
    private EditText edtUsername, edtPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.login_activity);

        txtWelcomeMessage = findViewById(R.id.txtWelcomeMessage);
        edtUsername = findViewById(R.id.edtUsername);
        edtPassword = findViewById(R.id.edtPassword);
        btnLogin = findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new BtnSignInClickListener());

    }

    private class BtnSignInClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if( edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode@123") ) {
                txtWelcomeMessage.setText("Welcome " + edtUsername.getText().toString());
            }
            else {
                txtWelcomeMessage.setText("Login failed..");
            }
        }
    }
}
