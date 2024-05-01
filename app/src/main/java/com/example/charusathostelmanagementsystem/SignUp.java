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
import com.google.firebase.auth.FirebaseAuthUserCollisionException;

public class SignUp extends AppCompatActivity implements View.OnClickListener{
    EditText username,password;
    private FirebaseAuth mAuth;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.signup).setOnClickListener(this);
        findViewById(R.id.signin).setOnClickListener(this);
    }

    private void registeruser() {

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
            mAuth.createUserWithEmailAndPassword(email, pd).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        Toast.makeText(getApplicationContext(), "User Registered SuccessFull", Toast.LENGTH_SHORT).show();
                    } else {
                        if (task.getException() instanceof FirebaseAuthUserCollisionException) {
                            Toast.makeText(getApplicationContext(), "you are already registered", Toast.LENGTH_SHORT).show();
                            Intent k = new Intent(SignUp.this, lobby.class);
                            startActivity(k);
                        } else {
                            Toast.makeText(getApplicationContext(), task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                        }
                    }
                }
            });

        }
        
    public void onClick(View view) {
                switch (view.getId()) {
                    case R.id.signup:
                        registeruser();
                        break;

                    case R.id.signin:
                        startActivity(new Intent(this, MainActivity.class));
                        break;
                }
            }
}