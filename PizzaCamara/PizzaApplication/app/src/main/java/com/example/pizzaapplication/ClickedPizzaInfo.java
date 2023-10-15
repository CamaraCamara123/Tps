package com.example.pizzaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pizzaapplication.classes.Produit;

import java.io.Serializable;
import java.util.HashMap;

public class ClickedPizzaInfo extends AppCompatActivity {

    Intent intent;
    ImageView clickedPizzaImage;
    TextView clickedPizzaName;
    TextView clickedPizzaDescription;
    TextView getClickedPizzaIngredients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.clicked_pizza);
        intent=getIntent();
        Serializable serializable=intent.getSerializableExtra("produit");
        if(serializable!=null){
            Produit produit=(Produit)serializable;
            init();
            populateLayout(produit);

        }
    }


    public void init(){
        clickedPizzaImage=findViewById(R.id.clickedPizzaImage);
        clickedPizzaName=findViewById(R.id.clickedPizzaName);
        clickedPizzaDescription=findViewById(R.id.clickedPizzaDescription);
        getClickedPizzaIngredients=findViewById(R.id.clickedPizzaIngredients);
    }
    public void populateLayout(Produit produit){
        clickedPizzaImage.setImageResource(produit.getPhoto());
        clickedPizzaName.setText(produit.getNom());
        clickedPizzaDescription.setText(produit.getDescription());
        getClickedPizzaIngredients.setText(produit.getPreparation());
    }
}