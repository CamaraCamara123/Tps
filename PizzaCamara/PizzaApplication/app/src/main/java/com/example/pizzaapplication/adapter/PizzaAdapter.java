package com.example.pizzaapplication.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.pizzaapplication.R;
import com.example.pizzaapplication.classes.Produit;

import java.util.List;

public class PizzaAdapter extends ArrayAdapter<Produit> {
    private List<Produit> produits;
    private int ressource;

    public PizzaAdapter(@NonNull Context context, int resource, @NonNull List<Produit> produits) {
        super(context, resource, produits);
        this.produits=produits;
        this.ressource=resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View item=convertView;
        if( convertView==null){
            item=LayoutInflater.from(getContext()).inflate(ressource,parent,false);
        }
        ImageView pizzaImageView=item.findViewById(R.id.pizzaImageView);
        TextView pizzaNbrIngredients=item.findViewById(R.id.pizzaNbrIngredientsTxt);
        TextView pizzaDuree=item.findViewById(R.id.pizaaDureeTxt);
        TextView pizzaId=item.findViewById(R.id.pizzaIdTxt);
        TextView pizzaNom=item.findViewById(R.id.pizzaNomTxt);

        Produit currentProduct=produits.get(position);

        String nom=currentProduct.getNom();
        String id=String.valueOf(currentProduct.getId());
        String nbrIngredients=String.valueOf(currentProduct.getNbrIngredients());
        String duree=currentProduct.getDuree();
        int imageReference=currentProduct.getPhoto();

        pizzaImageView.setImageResource(imageReference);
        pizzaNbrIngredients.setText(nbrIngredients);
        pizzaDuree.setText(duree);
        pizzaId.setText(id);
        pizzaNom.setText(nom);
        return item;
    }
}
