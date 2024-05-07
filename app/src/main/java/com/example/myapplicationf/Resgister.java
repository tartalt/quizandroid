package com.example.myapplicationf;




import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class Resgister extends AppCompatActivity {

    TextView name,email,password1,password2;
    Button rg;
    FirebaseAuth MyAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FirebaseApp.initializeApp(getApplicationContext());
        setContentView(R.layout.activity_resgister);
        MyAuth = FirebaseAuth.getInstance();
        name=findViewById(R.id.name);
        email=findViewById(R.id.email);
        password1=findViewById(R.id.password);
        password2=findViewById(R.id.password2);
        rg=findViewById(R.id.button);
        rg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nom = name.getText().toString();
                String mail = email.getText().toString();
                String password = password1.getText().toString();
                String confirmPassword = password2.getText().toString();

                if (nom.isEmpty() || mail.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
                    Toast.makeText(Resgister.this, "Veuillez remplir tous les champs", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (!password.equals(confirmPassword)) {
                    Toast.makeText(Resgister.this, "Les mots de passe ne correspondent pas", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (password.length() < 6) {
                    Toast.makeText(getApplicationContext(), "Le mot de passe doit avoir au moins 6 caractères", Toast.LENGTH_SHORT).show();
                    return;
                }


                MyAuth.createUserWithEmailAndPassword(mail, password)
                        .addOnCompleteListener(Resgister.this, new OnCompleteListener<AuthResult>() {
                            @Override
                            public void onComplete(@NonNull Task<AuthResult> task) {
                                if (task.isSuccessful()) {

                                    Toast.makeText(Resgister.this, "Enregistrement réussi", Toast.LENGTH_SHORT).show();
                                    Intent ig= new Intent(getApplicationContext(), MainActivity.class);
                                    startActivity(ig);
                                    finish();
                                } else {
                                    Toast.makeText(Resgister.this, "Échec de l'enregistrement: " + task.getException().getMessage(), Toast.LENGTH_SHORT).show();
                                }
                            }
                        });
            }
        });
    }
}