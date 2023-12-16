package com.example.e_comerce;

import static android.content.ContentValues.TAG;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.example.e_comerce.adapter.categorie_adapter;
import com.example.e_comerce.adapter.recommand_adapter;
import com.example.e_comerce.domaine.categorie_dom;
import com.example.e_comerce.domaine.recommend_dom;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;

public class home_activity extends AppCompatActivity {
    private RecyclerView.Adapter adapter,adapter2;
    private RecyclerView recyclerViewcategories,recyclerViewrecommend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        recyclerViewcateg();
        recyclerViewrecom();

    }

    private void recyclerViewcateg() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewcategories=findViewById(R.id.recyclerView);
        recyclerViewcategories.setLayoutManager(linearLayoutManager);
        ArrayList<categorie_dom> categorylist=new ArrayList<>();
        adapter=new categorie_adapter(categorylist);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("categorie");


        // Read from the database
       myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                categorylist.clear();

                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    categorie_dom catego = userSnapshot.getValue(categorie_dom.class);
                    categorylist.add(catego);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });



        recyclerViewcategories.setAdapter(adapter);

    }
    private void recyclerViewrecom() {
        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false);
        recyclerViewrecommend=findViewById(R.id.view2);
        recyclerViewrecommend.setLayoutManager(linearLayoutManager);
        ArrayList<recommend_dom>recomdlist=new ArrayList<>();
        FirebaseDatabase database = FirebaseDatabase.getInstance();
       DatabaseReference myRef = database.getReference("produit");
        adapter2=new recommand_adapter(recomdlist);
        recyclerViewrecommend.setAdapter(adapter2);
        // Read from the database
        myRef.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                recomdlist.clear();

                for (DataSnapshot userSnapshot : dataSnapshot.getChildren()) {
                    recommend_dom user = userSnapshot.getValue(recommend_dom.class);
                    recomdlist.add(user);
                }

                adapter.notifyDataSetChanged();

            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                // Failed to read value
                Log.w(TAG, "Failed to read value.", error.toException());
            }
        });

       recomdlist.add(new recommend_dom("chemise","img","fhhfhhfhfhfhhfhf","9.97"));
        recomdlist.add(new recommend_dom("pull","img","kkkkkkkkkkkkkkkkkkkkkk","8.6"));
        recomdlist.add(new recommend_dom("pull-short","img","jjjjjjjjjjjjj","10.2"));


    }

}