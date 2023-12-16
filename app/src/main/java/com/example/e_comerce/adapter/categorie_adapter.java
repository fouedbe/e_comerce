package com.example.e_comerce.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.e_comerce.R;
import com.example.e_comerce.domaine.categorie_dom;

import java.util.ArrayList;

public class categorie_adapter  extends RecyclerView.Adapter<categorie_adapter.viewHolder> {
    ArrayList<categorie_dom> category_domains;

    public categorie_adapter(ArrayList<categorie_dom> category_domains) {
        this.category_domains = category_domains;
    }

    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholdercat, parent, false);
        return new viewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        holder.categoryname.setText(category_domains.get(position).getTitle());
        holder.categorypic.setText(category_domains.get(position).getPic());

  /*
        int drawableResourceId = holder.itemView.getContext().getResources()
                .getIdentifier(category_domains.get(position).getPic(), "drawable", holder.itemView.getContext().getPackageName());


        Glide.with(holder.itemView.getContext()).load(drawableResourceId).into(holder.categorypic);

   */

    }

    @Override
    public int getItemCount() {
        return category_domains.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView categoryname;
        TextView categorypic;
        ConstraintLayout mainlayout;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            categoryname = itemView.findViewById(R.id.categoryname);
            categorypic = itemView.findViewById(R.id.categorypic);
            mainlayout = itemView.findViewById(R.id.mainlayaout);
        }
    }
}

