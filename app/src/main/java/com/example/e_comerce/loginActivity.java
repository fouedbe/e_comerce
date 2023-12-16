package com.example.e_comerce;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_comerce.domaine.Users;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

public class loginActivity extends AppCompatActivity {
   private Button login;
   private  EditText email,password;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        login=findViewById(R.id.buttonlog);
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        LoginUser();
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emaill = email.getText().toString();
                if(emaill.equals("admins@gmail.com"))
                {
                    Intent intent = new Intent(loginActivity.this,admin.class);

                    startActivity(intent);
                }
            }
        });

    }



        private void LoginUser()
        {


                String emaill = email.getText().toString();

                String passwordd = password.getText().toString();


            if (TextUtils.isEmpty(emaill))
            {
                Toast.makeText(this, "Please write your phone number...", Toast.LENGTH_SHORT).show();
            }
            else if (TextUtils.isEmpty(passwordd))
            {
                Toast.makeText(this, "Please write your password...", Toast.LENGTH_SHORT).show();
            }
            else
            {
                AllowAccessToAccount(emaill, passwordd);
            }
            if(emaill.equals("admins@gmail.com"))
            {
                Intent intent = new Intent(loginActivity.this,admin.class);

                startActivity(intent);
            }
        }
        private void AllowAccessToAccount(final String emaill, final String passwordd)
        {


            FirebaseAuth mAuth = FirebaseAuth.getInstance();

            mAuth.signInWithEmailAndPassword(emaill, passwordd)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information
                                FirebaseUser user = mAuth.getCurrentUser();
                                updateUI(user);
                            } else {
                                // If sign in fails, display a message to the user.
                                Toast.makeText(loginActivity.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();
                                updateUI(null);
                            }   
                        }

                        private void updateUI(FirebaseUser user) {
                        }


                    });



    }
}