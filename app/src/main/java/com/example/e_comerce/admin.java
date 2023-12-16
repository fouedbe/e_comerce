package com.example.e_comerce;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class admin extends AppCompatActivity {
    Button ajouter_pro,ajouter_cat;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin);
        ajouter_cat=findViewById(R.id.ajout_cat);
        ajouter_pro=findViewById(R.id.ajouetr_pro);
        ajouter_pro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this,ajouter_produit.class);

                startActivity(intent);
            }
        });
        ajouter_cat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(admin.this,ajouter_categ.class);

                startActivity(intent);
            }
        });

    }
}