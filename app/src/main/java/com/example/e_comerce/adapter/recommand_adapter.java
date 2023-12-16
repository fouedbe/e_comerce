package com.example.e_comerce.adapter;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_comerce.R;
import com.example.e_comerce.domaine.recommend_dom;

import java.util.ArrayList;

public class recommand_adapter extends RecyclerView.Adapter<recommand_adapter.viewHolder>{
    ArrayList<recommend_dom> recommande_domains;

    public recommand_adapter(ArrayList<recommend_dom> recommande_domains) {
        this.recommande_domains= recommande_domains;
    }

    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_recommande,parent,false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, @SuppressLint("RecyclerView") int position) {
        holder.title.setText(recommande_domains.get(position).getTitle());
        holder.prix.setText(String.valueOf(recommande_domains.get(position).getFee()));


        int drawableResourceId=holder.itemView.getContext().getResources()
                .getIdentifier(recommande_domains.get(position).getPic(),"drawable",holder.itemView.getContext().getPackageName());


        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.pic);

    }

    @Override
    public int getItemCount() {
        return recommande_domains.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView title,prix;
        ImageView pic;
        TextView addbn;
        public viewHolder(@NonNull View itemView) {
            super(itemView);
            title=itemView.findViewById(R.id.title1);
            prix=itemView.findViewById(R.id.fee);
            pic=itemView.findViewById(R.id.pic);
            addbn=itemView.findViewById(R.id.addbn);
        }
    }
}
