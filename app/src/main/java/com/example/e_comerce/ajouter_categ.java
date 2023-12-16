package com.example.e_comerce;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.e_comerce.domaine.categorie_dom;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class ajouter_categ extends AppCompatActivity {
     private EditText title,pic;
     private Button ajouter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ajouter_categ);
        title=findViewById(R.id.editTextTextPersonName2);
        pic=findViewById(R.id.catgimg);
        ajouter=findViewById(R.id.button);


        ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String name= title.getText().toString();

                String image = pic.getText().toString();
                DatabaseReference databaseRef = FirebaseDatabase.getInstance().getReference();
                DatabaseReference categRef = databaseRef.child("categorie");
                categorie_dom categorie=new categorie_dom(name,image);

                categRef.push().setValue(categorie);
                Toast.makeText(ajouter_categ.this, "categorie add", Toast.LENGTH_SHORT).show();

            }
        });
    }
}