package com.example.pizzaapplication.classes;

import java.io.Serializable;

public class Produit implements Serializable {

    private  int id;
    private String nom;
    private int nbrIngredients;
    private int photo;
    private String duree;

    private String detaisIngred;
    private String description;
    private String preparation;
    private  static int comp;

    public Produit(String nom, int nbrIngredients, int photo, String duree, String detaisIngred, String description, String preparation) {
        this.id=++comp;
        this.nom = nom;
        this.nbrIngredients = nbrIngredients;
        this.photo = photo;
        this.duree = duree;
        this.detaisIngred = detaisIngred;
        this.description = description;
        this.preparation = preparation;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbrIngredients() {
        return nbrIngredients;
    }

    public void setNbrIngredients(int nbrIngredients) {
        this.nbrIngredients = nbrIngredients;
    }

    public int getPhoto() {
        return photo;
    }

    public void setPhoto(int photo) {
        this.photo = photo;
    }

    public String getDuree() {
        return duree;
    }

    public void setDuree(String duree) {
        this.duree = duree;
    }

    public String getDetaisIngred() {
        return detaisIngred;
    }

    public void setDetaisIngred(String detaisIngred) {
        this.detaisIngred = detaisIngred;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPreparation() {
        return preparation;
    }

    public void setPreparation(String preparation) {
        this.preparation = preparation;
    }
    public static int getComp() {
        return comp;
    }

    @Override
    public String toString() {
        return "Produit{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbrIngredients='" + nbrIngredients + '\'' +
                ", photo=" + photo +
                ", duree=" + duree +
                ", detaisIngred='" + detaisIngred + '\'' +
                ", description='" + description + '\'' +
                ", preparation='" + preparation + '\'' +
                '}';
    }
}
