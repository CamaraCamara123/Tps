/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

/**
 *
 * @author Lachgar
 */
@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private int id;
    private String code;
    private String libelle;
    @OneToMany(cascade=CascadeType.ALL, mappedBy = "categorie", fetch = FetchType.EAGER)
    private List<Produit> produits;
    public Categorie() {
    }

    public Categorie(String code, String libelle) {
        this.code = code;
        this.libelle = libelle;
    }

    public Categorie(int id, String code, String libelle) {
        this.id = id;
        this.code = code;
        this.libelle = libelle;
    }
    

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }
    
}
