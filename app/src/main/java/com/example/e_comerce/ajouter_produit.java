package com.example.e_comerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_comerce.domaine.categorie_dom;
import com.example.e_comerce.domaine.recommend_dom;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ajouter_produit extends AppCompatActivity {
    private EditText title,prix,description,image;
    private Button ajouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_produit);
        title=findViewById(R.id.editTextTextPersonName3);
        prix=findViewById(R.id.editTextTextPersonName4);
        description=findViewById(R.id.editTextTextPersonName5);
        ajouter=findViewById(R.id.button2);
        image=findViewById(R.id.editTextTextPersonName6);


        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= title.getText().toString();
                String descriptio = description.getText().toString();
                String prixx = prix.getText().toString();
                String img=image.getText().toString();
                DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference categRef = databaseRef.child("produit");
                recommend_dom produit=new recommend_dom(descriptio,prixx,img,name);

                categRef.push().setValue(produit);
                Toast.makeText(ajouter_produit.this, "categorie add", Toast.LENGTH_SHORT).show();

            }
        });
    }
}