/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entities;

import java.io.Serializable;
import javax.persistence.Embeddable;

/**
 *
 * @author Lachgar
 */
@Embeddable
public class LigneCommandeProduitPK implements Serializable{
    
    private int produit;
    
    private int commande;

    public LigneCommandeProduitPK() {
    }

    public LigneCommandeProduitPK(int produit, int commande) {
        this.produit = produit;
        this.commande = commande;
    }

    public int getProduit() {
        return produit;
    }

    public void setProduit(int produit) {
        this.produit = produit;
    }

    public int getCommande() {
        return commande;
    }

    public void setCommande(int commande) {
        this.commande = commande;
    }
    
    
    
}
