package com.example.myapplicationf;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class MainActivity extends AppCompatActivity {

    EditText mail,password;
    Button sign;
    TextView Register;
    FirebaseAuth MyAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(getApplicationContext());
        MyAuth = FirebaseAuth.getInstance();
        setContentView(R.layout.activity_main);
        Register=findViewById(R.id.resgisterc);
        mail=findViewById(R.id.emailc);
        password=findViewById(R.id.passwordc);
        sign=findViewById(R.id.loginc);
        sign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              String emailInput = mail.getText().toString().trim();
                String passwordInput = password.getText().toString().trim();

                if (emailInput.isEmpty() || passwordInput.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all fields", Toast.LENGTH_SHORT).show();
                    return;
                }

                MyAuth.signInWithEmailAndPassword(emailInput, passwordInput)
                        .addOnCompleteListener(MainActivity.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {
                                    // Sign in successful
                                    FirebaseUser user = MyAuth.getCurrentUser();
                                    Toast.makeText(MainActivity.this, "Welcome, " + user.getEmail(), Toast.LENGTH_SHORT).show();

                                    // Redirect to Quiz1 activity after successful login
                                    Intent intent = new Intent(MainActivity.this, Quiz1.class);
                                    startActivity(intent);
                                    finish();
                                } else {
                                    // Sign in failed
                                    Toast.makeText(MainActivity.this, "Login failed: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });

        if (Register != null) {// Register text view click listener (already implemented in original code)
        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Resgister.class);
                startActivity(intent);
                finish();
            }
        });
        }
    }
}