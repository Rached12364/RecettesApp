package com.example.t7;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.bumptech.glide.Glide;
import java.util.List;

public class RecetteAdapter extends RecyclerView.Adapter<RecetteAdapter.ViewHolder> {

    private final Context context;
    private final List<Recette> recettes;

    public RecetteAdapter(Context context, List<Recette> recettes) {
        this.context = context;
        this.recettes = recettes;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context)
                .inflate(R.layout.item_recette, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Recette recette = recettes.get(position);
        holder.tvNom.setText(recette.getNom());
        holder.tvDescription.setText(recette.getDescription());
        holder.tvTag.setText(recette.getTag());

        Glide.with(context)
                .load(recette.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(holder.imgRecette);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("nom",         recette.getNom());
            intent.putExtra("tag",         recette.getTag());
            intent.putExtra("ingredients", recette.getIngredients());
            intent.putExtra("etapes",      recette.getEtapes());
            intent.putExtra("imageUrl",    recette.getImageUrl());
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() { return recettes.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNom, tvDescription, tvTag;
        ImageView imgRecette;

        ViewHolder(View itemView) {
            super(itemView);
            tvNom         = itemView.findViewById(R.id.tvNom);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvTag         = itemView.findViewById(R.id.tvTag);
            imgRecette    = itemView.findViewById(R.id.imgRecette);
        }
    }
}