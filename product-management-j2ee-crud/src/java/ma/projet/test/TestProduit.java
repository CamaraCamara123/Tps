/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.util.Date;
import ma.projet.entities.Categorie;
import ma.projet.entities.Produit;
import ma.projet.services.CategorieService;
import ma.projet.services.ProduitService;

/**
 *
 * @author Lachgar
 */
public class TestProduit {

    public static void main(String[] args) {

        ProduitService ps = new ProduitService();
        CategorieService cs = new CategorieService();

        cs.create(new Categorie("pc", "pc"));
        cs.create(new Categorie("imprimante", "imprimante"));
        ps.create(new Produit("produit1", 200, cs.getById(1)));
        ps.create(new Produit("produit2", 300, cs.getById(2)));
        ps.create(new Produit("produit3", 400, cs.getById(3)));
        ps.create(new Produit("produit4", 500, cs.getById(4)));

        for (Produit p : ps.findBetweenDate(new Date("2021/01/01"), new Date("2023/01/01"))) {
            System.out.println(p.getReference());
        }

        ps.update(new Produit(17, "ref2", 120, cs.getById(5)));

    }

}
