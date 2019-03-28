package com.example.medicationbox;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.*;
import android.widget.*;
import android.util.Log;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class RegisterActivity extends AppCompatActivity {

    private Button mCreate;
    private EditText mEmail;
    private EditText mPassword;
    private FirebaseAuth mAuth;
    private DatabaseReference mReference;
    private User user;
    private FireBaseStorage storage;


    private static final String TAG = "EmailPassword";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_temp);

        mAuth = FirebaseAuth.getInstance();
        mReference = FirebaseDatabase.getInstance()
                .getReferenceFromUrl("https://medication-box.firebaseio.com");
        storage = new FireBaseStorage();

        mCreate = (Button) findViewById(R.id.btnRegister);
        mCreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mEmail = (EditText) findViewById(R.id.rEditEmail);
                mPassword = (EditText) findViewById(R.id.rEditPassword);

                String email = mEmail.getText().toString();
                String password = mPassword.getText().toString();

                Log.e("EMAIL", "User email is " + email);
                Log.e("PASSWORD", "User password is " + password);

                createAccount(email, password);

            }
        });

    }

    public void createAccount(String email, String password)
    {
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.e("login", "createUserWithEmail:success");
                        } else {

                            //Indiaminah

                        }
                    }
                });
    }


}