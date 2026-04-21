package com.example.t7;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Recette> recettes = new ArrayList<>();

        recettes.add(new Recette(
                "Sandwichs Kale/Citron",
                "Délicieux et sain, ce sandwich est aussi bon que nutritif. Le citron apporte une saveur presque sucrée. Soyez généreux !",
                "Végétarien",
                "• 2 tranches de pain de campagne\n• Feuilles de kale frais\n• 1 citron (jus + zeste)\n• 1 c.à.s d'huile d'olive\n• Sel, poivre\n• Avocat en tranches",
                "1. Rincer et sécher le kale, retirer les tiges.\n2. Mélanger jus de citron, huile, sel et poivre.\n3. Faire revenir le kale 3 min avec la vinaigrette.\n4. Assembler avec l'avocat.\n5. Servir avec un filet de citron.",
                "https://images.unsplash.com/photo-1540420773420-3366772f4999?w=800&q=80"
        ));

        recettes.add(new Recette(
                "Salade Mangue-Haricots Blancs",
                "Tout le monde adore cette recette ! Elle disparaît en un éclair et fonctionne aussi comme salsa. Notre recette d'été préférée.",
                "Vegan",
                "• 1 boîte haricots blancs\n• 1 mangue mûre en dés\n• 1/2 oignon rouge\n• Jus de 1 citron vert\n• Coriandre fraîche\n• Sel, piment",
                "1. Égoutter et rincer les haricots.\n2. Couper la mangue et l'oignon en petits dés.\n3. Mélanger tous les ingrédients.\n4. Assaisonner avec le citron vert, sel et piment.\n5. Laisser reposer 10 min avant de servir.",
                "https://images.unsplash.com/photo-1512621776951-a57141f2eefd?w=800&q=80"
        ));

        recettes.add(new Recette(
                "Soupe Patate Douce & Lentilles",
                "Cette soupe est si bonne ! Si quelqu'un hésite avec la cuisine végétale, c'est le plat qui convainc à tous les coups.",
                "Vegan",
                "• 2 patates douces\n• 150g lentilles corail\n• 1 oignon\n• 2 gousses d'ail\n• 1 c.à.c curcuma\n• 1 L bouillon légumes\n• Champignons shiitake",
                "1. Faire revenir l'oignon et l'ail dans l'huile.\n2. Ajouter les patates douces en cubes et les champignons.\n3. Incorporer les lentilles et le bouillon.\n4. Assaisonner avec le curcuma, sel et poivre.\n5. Laisser mijoter 25 min, mixer partiellement.",
                "https://images.unsplash.com/photo-1547592180-85f173990554?w=800&q=80"
        ));

        recettes.add(new Recette(
                "Mousse au Citron Vert",
                "Fabuleuse nature ou en gâteau. Prête en quelques minutes. Dosez le citron vert selon votre goût !",
                "Dessert",
                "• 3 citrons verts (jus + zeste)\n• 200ml crème fraîche\n• 100g sucre\n• 3 œufs\n• 1 sachet gélatine",
                "1. Fouetter les œufs avec le sucre jusqu'à blanchissement.\n2. Ajouter le jus et zeste de citron vert.\n3. Incorporer la gélatine dissoute.\n4. Monter la crème en chantilly et l'incorporer délicatement.\n5. Réfrigérer 2h minimum avant de servir.",
                "https://images.unsplash.com/photo-1464305795204-6f5bbfc7fb81?w=800&q=80"
        ));

        recettes.add(new Recette(
                "Tilapia Parmesan Grillé",
                "Recette familiale rapide et savoureuse. Le tilapia est grillé avec une croûte de parmesan crémeuse impressionnante.",
                "Poisson",
                "• 4 filets de tilapia\n• 50g parmesan râpé\n• 2 c.à.s mayonnaise\n• 1 c.à.s jus de citron\n• Sel, poivre\n• Persil frais",
                "1. Préchauffer le gril du four.\n2. Mélanger parmesan, mayo et citron.\n3. Assaisonner les filets de sel et poivre.\n4. Étaler la crème parmesan sur chaque filet.\n5. Griller 10-12 min jusqu'à dorure.\n6. Servir avec du persil frais.",
                "https://images.unsplash.com/photo-1519708227418-c8fd9a32b7a2?w=800&q=80"
        ));

        RecetteAdapter adapter = new RecetteAdapter(this, recettes);
        recyclerView.setAdapter(adapter);
    }
}