package com.example.cityguide.Common.LoginSignup;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.util.Pair;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.cityguide.R;
import com.google.android.material.textfield.TextInputLayout;

public class SignUp extends AppCompatActivity {

    ImageView backButton;
    Button next,login;
    TextView titleText;

    TextInputLayout fullname,username,email,password;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_retailer_sign_up);

        //Hooks
        backButton=findViewById(R.id.signup_back_button);
        next=findViewById(R.id.signup_next_button);
        login=findViewById(R.id.signup_login_button);
        titleText=findViewById(R.id.signup_title_text);


        fullname = findViewById(R.id.sign_up_fullname);
         username = findViewById(R.id.sign_up_username);
        email = findViewById(R.id.sign_up_email);
        password = findViewById(R.id.sign_up_password);

    }

    public void signupnextcall(View view) {


        if (!validateFullname() | !validateEmail() | !validateUsername() | !validatePassword()) {
            return;
        } else {


            Intent intent = new Intent(getApplicationContext(), SignUp2ndClass.class);

            //Add trasition

            Pair[] pairs = new Pair[4];

            pairs[0] = new Pair<View, String>(backButton, "transition_back_arrow_btn");
            pairs[1] = new Pair<View, String>(next, "transition_next_btn");
            pairs[2] = new Pair<View, String>(login, "transition_login_btn");
            pairs[3] = new Pair<View, String>(titleText, "transition_title_text");

            if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.LOLLIPOP) {
                ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(SignUp.this, pairs);
                startActivity(intent, options.toBundle());
            } else {
                startActivity(intent);
            }

        }
    }

    //Validation Function

    private boolean validateFullname(){
        String val= fullname.getEditText().getText().toString().trim();

        if (val.isEmpty()){
            fullname.setError("Field Cannot be Empty");
            return false;
        }
        else {
            fullname.setError(null);
            fullname.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateUsername(){
        String val= username.getEditText().getText().toString().trim();
        String checkSpaces = "\\A\\w{1,20}\\z";

        if (val.isEmpty()){
            username.setError("Field Cannot be Empty");
            return false;
        }else if (val.length()>20){
            username.setError("Username is too large");
            return false;
        }else if(!val.matches(checkSpaces)){
            username.setError("Not White Space Allowd");
            return false;
        }
        else {
            username.setError(null);
            username.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validateEmail(){
        String val= email.getEditText().getText().toString().trim();
        String checkEmail= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()){
            email.setError("Field Cannot be Empty");
            return false;
        }
        else if(!val.matches(checkEmail)){
            email.setError("Invalid Email");
            return false;
        }
        else {
            email.setError(null);
            email.setErrorEnabled(false);
            return true;
        }

    }

    private boolean validatePassword(){
        String val= password.getEditText().getText().toString().trim();
       // String checkEmail= "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if (val.isEmpty()){
            password.setError("Field Cannot be Empty");
            return false;
        }
        else {
            password.setError(null);
            password.setErrorEnabled(false);
            return true;
        }

    }


}
