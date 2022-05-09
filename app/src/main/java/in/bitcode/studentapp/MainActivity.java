package in.bitcode.studentapp;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends Activity implements View.OnClickListener {

    private EditText edtUsername, edtPassword;
    private TextView txtWelcomeMessage;
    private Button btnSignIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        LinearLayout mainContainerLayout = new LinearLayout(this);
        mainContainerLayout.setOrientation(LinearLayout.VERTICAL);
        mainContainerLayout.setPadding(20, 20, 20, 40);
        mainContainerLayout.setGravity(Gravity.CENTER_VERTICAL|Gravity.CENTER_HORIZONTAL);

        ViewGroup.LayoutParams layoutParams =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.MATCH_PARENT
                );

        mainContainerLayout.setLayoutParams(layoutParams);


        txtWelcomeMessage = new TextView(this);
        txtWelcomeMessage.setText("Welcome to Android@BitCode");
        txtWelcomeMessage.setTextSize(30);
        txtWelcomeMessage.setTextColor(Color.BLACK);

        ViewGroup.LayoutParams paramsForView =
                new ViewGroup.LayoutParams(
                        ViewGroup.LayoutParams.MATCH_PARENT,
                        ViewGroup.LayoutParams.WRAP_CONTENT
                );

        txtWelcomeMessage.setLayoutParams(paramsForView);

        mainContainerLayout.addView(txtWelcomeMessage);
        //setContentView(txtWelcomeMessage);

        edtUsername = new EditText(this);
        edtUsername.setHint("Enter username");
        edtUsername.setLayoutParams(paramsForView);
        //setContentView(edtUsername);
        mainContainerLayout.addView(edtUsername);

        edtPassword = new EditText(this);
        edtPassword.setLayoutParams(paramsForView);
        mainContainerLayout.addView(edtPassword);

        btnSignIn = new Button(this);
        btnSignIn.setText("Sign In");
        btnSignIn.setLayoutParams(paramsForView);
        mainContainerLayout.addView(btnSignIn);

        setContentView(mainContainerLayout);

        /*btnSignIn.setOnClickListener(new BtnSignInClickListener());
        txtWelcomeMessage.setOnClickListener(new TxtWelcomeMessageClickListener());*/

        /*View.OnClickListener listener = new MyViewClickListener();
        btnSignIn.setOnClickListener(listener);
        txtWelcomeMessage.setOnClickListener(listener);*/

        btnSignIn.setOnClickListener(this);
        txtWelcomeMessage.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view == txtWelcomeMessage) {
            txtWelcomeMessage.setText("");
        }
        if(view == btnSignIn) {
            if( edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode@123") ) {
                txtWelcomeMessage.setText("Welcome " + edtUsername.getText().toString());
            }
            else {
                txtWelcomeMessage.setText("Login failed..");
            }
        }
    }

    class MyViewClickListener implements View.OnClickListener {
        @Override
        public void onClick(View view) {
            if(view == txtWelcomeMessage) {
                txtWelcomeMessage.setText("");
            }
            if(view == btnSignIn) {
                if( edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode@123") ) {
                    txtWelcomeMessage.setText("Welcome " + edtUsername.getText().toString());
                }
                else {
                    txtWelcomeMessage.setText("Login failed..");
                }
            }

        }
    }



    class TxtWelcomeMessageClickListener implements View.OnClickListener {
        @Override
        public void onClick(View v) {
            txtWelcomeMessage.setText("");
        }
    }

    class BtnSignInClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if( edtUsername.getText().toString().equals("bitcode") && edtPassword.getText().toString().equals("bitcode@123") ) {
                txtWelcomeMessage.setText("Welcome " + edtUsername.getText().toString());
            }
            else {
                txtWelcomeMessage.setText("Login failed..");
            }
        }
    }

}