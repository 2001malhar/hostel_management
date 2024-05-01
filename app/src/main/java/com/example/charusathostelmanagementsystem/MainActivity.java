package com.example.charusathostelmanagementsystem;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    EditText username,password;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();

        findViewById(R.id.newuser).setOnClickListener(this);
        findViewById(R.id.login).setOnClickListener(this);
    }
   public void team(View v)
   {
       startActivity(new Intent(this,Team.class));
   }
    private void userlogin() {
        String email = username.getText().toString().trim();
        String pd = password.getText().toString().trim();
        if (email.isEmpty()) {
            username.setError("Email is reqired");
            username.requestFocus();
            return;
        }
        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            username.setError("please enter a valid email");
            username.requestFocus();
            return;
        }
        if (pd.isEmpty()) {
            password.setError("password is reqired");
            password.requestFocus();
            return;
        }
        if (pd.length() < 6) {
            password.setError("minimum lenght of password should be 6");
            password.requestFocus();
            return;
        }
        mAuth.signInWithEmailAndPassword(email, pd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful()){
                     Intent k = new Intent(MainActivity.this,lobby.class);
                     Toast.makeText(getApplicationContext(), "User Registered SuccessFull", Toast.LENGTH_SHORT).show();
                     startActivity(k);

                 }
                 else{
                     Toast.makeText(getApplicationContext(),task.getException().getMessage(),Toast.LENGTH_SHORT).show();
                 }

            }
        });
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.newuser:

                startActivity(new Intent(this, SignUp.class));

                break;
            case R.id.login:
                userlogin();
                break;
        }
    }
}


