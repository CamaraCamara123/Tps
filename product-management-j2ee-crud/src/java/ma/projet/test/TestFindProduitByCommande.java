/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import ma.projet.services.CommandeService;
import ma.projet.services.LigneCommandeProduitService;
import ma.projet.services.ProduitService;

/**
 *
 * @author Lachgar
 */
public class TestFindProduitByCommande {
    public static void main(String[] args) {
        CommandeService cs = new CommandeService();
        ProduitService ps = new ProduitService();
        LigneCommandeProduitService lcps = new LigneCommandeProduitService();
        
        ps.findProduitByCommande(cs.getById(1));
    }
}
