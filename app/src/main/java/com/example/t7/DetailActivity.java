package com.example.t7;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }

        String nom         = getIntent().getStringExtra("nom");
        String tag         = getIntent().getStringExtra("tag");
        String ingredients = getIntent().getStringExtra("ingredients");
        String etapes      = getIntent().getStringExtra("etapes");
        String imageUrl    = getIntent().getStringExtra("imageUrl");

        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(nom);
        }

        ImageView imgRecette = findViewById(R.id.imgRecette);
        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into(imgRecette);

        ((TextView) findViewById(R.id.tvDetailNom)).setText(nom);
        ((TextView) findViewById(R.id.tvDetailTag)).setText(tag);
        ((TextView) findViewById(R.id.tvIngredients)).setText(ingredients);
        ((TextView) findViewById(R.id.tvEtapes)).setText(etapes);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}