/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.NamedNativeQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Lachgar
 */
@Entity
@NamedNativeQuery(name = "betweenDate", query = "SELECT p.* FROM produit p inner join lignecommandeproduit l on p.id = l.produit inner join commande c on c.id = l.commande where c.date BETWEEN :d1 and :d2", resultClass = Produit.class)
public class Produit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String reference;
    private double prix;
    @ManyToOne
    private Categorie categorie;

    public Produit() {

    }

    public Produit(int id, String reference, double prix, Categorie categorie) {
        this.id = id;
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return categorie;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Produit(String reference, double prix, Categorie categorie) {
        this.reference = reference;
        this.prix = prix;
        this.categorie = categorie;
    }

    public Produit(String reference, double prix) {
        this.reference = reference;
        this.prix = prix;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }

}
