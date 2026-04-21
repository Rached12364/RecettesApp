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
            getSupportActionBar().setTitle(getIntent().getStringExtra("nom"));
        }

        String nom         = getIntent().getStringExtra("nom");
        String tag         = getIntent().getStringExtra("tag");
        String ingredients = getIntent().getStringExtra("ingredients");
        String etapes      = getIntent().getStringExtra("etapes");
        String imageUrl    = getIntent().getStringExtra("imageUrl");
        int duree          = getIntent().getIntExtra("duree", 0);
        int calories       = getIntent().getIntExtra("calories", 0);
        float note         = getIntent().getFloatExtra("note", 0f);

        Glide.with(this)
                .load(imageUrl)
                .placeholder(R.drawable.ic_launcher_background)
                .centerCrop()
                .into((ImageView) findViewById(R.id.imgRecette));

        ((TextView) findViewById(R.id.tvDetailNom)).setText(nom);
        ((TextView) findViewById(R.id.tvDetailTag)).setText(tag);
        ((TextView) findViewById(R.id.tvIngredients)).setText(ingredients);
        ((TextView) findViewById(R.id.tvEtapes)).setText(etapes);
        ((TextView) findViewById(R.id.tvDetailDuree)).setText(duree + " min");
        ((TextView) findViewById(R.id.tvDetailCalories)).setText(calories + " kcal");
        ((TextView) findViewById(R.id.tvDetailNote)).setText(getEtoiles(note) + "  " + note + "/5");
    }

    private String getEtoiles(float note) {
        int plein = (int) note;
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < 5; i++) sb.append(i < plein ? "★" : "☆");
        return sb.toString();
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}