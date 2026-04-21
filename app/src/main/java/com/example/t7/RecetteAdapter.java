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
    private List<Recette> recettes;

    public RecetteAdapter(Context context, List<Recette> recettes) {
        this.context = context;
        this.recettes = recettes;
    }

    public void mettreAJour(List<Recette> nouvelles) {
        this.recettes = nouvelles;
        notifyDataSetChanged();
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
        Recette r = recettes.get(position);

        holder.tvNom.setText(r.getNom());
        holder.tvDescription.setText(r.getDescription());
        holder.tvTag.setText(r.getTag());
        holder.tvDuree.setText(r.getDuree() + " min");
        holder.tvCalories.setText(r.getCalories() + " kcal");
        holder.tvNote.setText(getEtoiles(r.getNote()) + " " + r.getNote());

        Glide.with(context)
                .load(r.getImageUrl())
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(holder.imgRecette);

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("nom",         r.getNom());
            intent.putExtra("tag",         r.getTag());
            intent.putExtra("ingredients", r.getIngredients());
            intent.putExtra("etapes",      r.getEtapes());
            intent.putExtra("imageUrl",    r.getImageUrl());
            intent.putExtra("duree",       r.getDuree());
            intent.putExtra("calories",    r.getCalories());
            intent.putExtra("note",        r.getNote());
            context.startActivity(intent);
        });
    }

    private String getEtoiles(float note) {
        int plein = (int) note;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) sb.append(i < plein ? "★" : "☆");
        return sb.toString();
    }

    @Override
    public int getItemCount() { return recettes.size(); }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNom, tvDescription, tvTag, tvDuree, tvCalories, tvNote;
        ImageView imgRecette;

        ViewHolder(View itemView) {
            super(itemView);
            tvNom         = itemView.findViewById(R.id.tvNom);
            tvDescription = itemView.findViewById(R.id.tvDescription);
            tvTag         = itemView.findViewById(R.id.tvTag);
            tvDuree       = itemView.findViewById(R.id.tvDuree);
            tvCalories    = itemView.findViewById(R.id.tvCalories);
            tvNote        = itemView.findViewById(R.id.tvNote);
            imgRecette    = itemView.findViewById(R.id.imgRecette);
        }
    }
}