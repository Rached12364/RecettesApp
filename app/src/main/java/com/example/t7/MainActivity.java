package com.example.t7;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecetteAdapter adapter;
    private final List<Recette> toutesLesRecettes = new ArrayList<>();
    private String categorieActive = "Tout";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        chargerRecettes();

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new RecetteAdapter(this, new ArrayList<>(toutesLesRecettes));
        recyclerView.setAdapter(adapter);

        EditText searchBar = findViewById(R.id.searchBar);
        searchBar.setHintTextColor(ContextCompat.getColor(this, R.color.texte_secondaire));
        searchBar.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                filtrer(s.toString());
            }
            public void afterTextChanged(Editable s) {}
        });

        String[] categories = {"Tout", "Vegan", "Végétarien", "Poisson", "Dessert"};
        LinearLayout filterContainer = findViewById(R.id.filterContainer);
        for (String cat : categories) {
            filterContainer.addView(creerChip(cat, cat.equals("Tout")));
        }
    }

    private TextView creerChip(String label, boolean selected) {
        TextView chip = new TextView(this);
        chip.setText(label);
        chip.setPadding(32, 14, 32, 14);
        chip.setTextSize(12f);

        if (selected) {
            chip.setBackground(ContextCompat.getDrawable(this, R.drawable.chip_selected));
            chip.setTextColor(ContextCompat.getColor(this, R.color.blanc));
        } else {
            chip.setBackground(ContextCompat.getDrawable(this, R.drawable.chip_unselected));
            chip.setTextColor(ContextCompat.getColor(this, R.color.blanc));
        }

        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.WRAP_CONTENT,
                LinearLayout.LayoutParams.WRAP_CONTENT);
        params.setMarginEnd(8);
        chip.setLayoutParams(params);

        chip.setOnClickListener(v -> {
            categorieActive = label;
            filtrer(((EditText) findViewById(R.id.searchBar)).getText().toString());
            mettreAJourChips((LinearLayout) v.getParent(), (TextView) v);
        });
        return chip;
    }

    private void mettreAJourChips(LinearLayout container, TextView selected) {
        for (int i = 0; i < container.getChildCount(); i++) {
            TextView chip = (TextView) container.getChildAt(i);
            if (chip == selected) {
                chip.setBackground(ContextCompat.getDrawable(this, R.drawable.chip_selected));
            } else {
                chip.setBackground(ContextCompat.getDrawable(this, R.drawable.chip_unselected));
            }
        }
    }

    private void filtrer(String query) {
        List<Recette> filtre = new ArrayList<>();
        for (Recette r : toutesLesRecettes) {
            boolean matchCat = categorieActive.equals("Tout") || r.getTag().equals(categorieActive);
            boolean matchQuery = r.getNom().toLowerCase().contains(query.toLowerCase())
                    || r.getDescription().toLowerCase().contains(query.toLowerCase());
            if (matchCat && matchQuery) filtre.add(r);
        }
        adapter.mettreAJour(filtre);
    }

    private void chargerRecettes() {
        toutesLesRecettes.add(new Recette(
                "Sandwichs Kale/Citron",
                "Délicieux et sain, aussi bon que nutritif. Le citron apporte une saveur presque sucrée.",
                "Végétarien",
                "• 2 tranches de pain de campagne\n• Feuilles de kale frais\n• 1 citron (jus + zeste)\n• 1 c.à.s d'huile d'olive\n• Sel, poivre\n• Avocat en tranches",
                "1. Rincer et sécher le kale, retirer les tiges.\n2. Mélanger jus de citron, huile, sel et poivre.\n3. Faire revenir le kale 3 min avec la vinaigrette.\n4. Assembler avec l'avocat.\n5. Servir avec un filet de citron.",
                "https://images.unsplash.com/photo-1540420773420-3366772f4999?w=800&q=80",
                15, 320, 4.2f));

        toutesLesRecettes.add(new Recette(
                "Salade Mangue-Haricots Blancs",
                "Tout le monde adore cette recette ! Fonctionne aussi comme salsa. Notre recette d'été préférée.",
                "Vegan",
                "• 1 boîte haricots blancs\n• 1 mangue mûre en dés\n• 1/2 oignon rouge\n• Jus de 1 citron vert\n• Coriandre fraîche\n• Sel, piment",
                "1. Égoutter et rincer les haricots.\n2. Couper la mangue et l'oignon en petits dés.\n3. Mélanger tous les ingrédients.\n4. Assaisonner avec citron vert, sel et piment.\n5. Laisser reposer 10 min avant de servir.",
                "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=800&q=80",
                10, 210, 4.7f));

        toutesLesRecettes.add(new Recette(
                "Soupe Patate Douce & Lentilles",
                "Si quelqu'un hésite avec la cuisine végétale, c'est le plat qui convainc à tous les coups.",
                "Vegan",
                "• 2 patates douces\n• 150g lentilles corail\n• 1 oignon\n• 2 gousses d'ail\n• 1 c.à.c curcuma\n• 1 L bouillon légumes\n• Champignons shiitake",
                "1. Faire revenir l'oignon et l'ail dans l'huile.\n2. Ajouter les patates douces en cubes et les champignons.\n3. Incorporer les lentilles et le bouillon.\n4. Assaisonner avec le curcuma, sel et poivre.\n5. Laisser mijoter 25 min, mixer partiellement.",
                "https://images.unsplash.com/photo-1547592180-85f173990554?w=800&q=80",
                35, 280, 4.8f));

        toutesLesRecettes.add(new Recette(
                "Mousse au Citron Vert",
                "Fabuleuse nature ou en gâteau. Prête en quelques minutes. Dosez le citron selon votre goût !",
                "Dessert",
                "• 3 citrons verts (jus + zeste)\n• 200ml crème fraîche\n• 100g sucre\n• 3 oeufs\n• 1 sachet gélatine",
                "1. Fouetter les oeufs avec le sucre jusqu'à blanchissement.\n2. Ajouter le jus et zeste de citron vert.\n3. Incorporer la gélatine dissoute.\n4. Monter la crème en chantilly et l'incorporer délicatement.\n5. Réfrigérer 2h minimum avant de servir.",
                "https://images.unsplash.com/photo-1464305795204-6f5bbfc7fb81?w=800&q=80",
                20, 380, 4.5f));

        toutesLesRecettes.add(new Recette(
                "Tilapia Parmesan Grillé",
                "Recette familiale rapide et savoureuse avec une croûte de parmesan crémeuse impressionnante.",
                "Poisson",
                "• 4 filets de tilapia\n• 50g parmesan râpé\n• 2 c.à.s mayonnaise\n• 1 c.à.s jus de citron\n• Sel, poivre\n• Persil frais",
                "1. Préchauffer le gril du four.\n2. Mélanger parmesan, mayo et citron.\n3. Assaisonner les filets de sel et poivre.\n4. Étaler la crème parmesan sur chaque filet.\n5. Griller 10-12 min jusqu'à dorure.\n6. Servir avec du persil frais.",
                "https://images.unsplash.com/photo-1519708227418-c8fd9a32b7a2?w=800&q=80",
                25, 350, 4.6f));
    }
}