package com.example.pizzaapplication.service;

import com.example.pizzaapplication.classes.Produit;
import com.example.pizzaapplication.dao.IDao;

import java.util.List;

public class ProduitService implements IDao<Produit> {

    private List<Produit> produits;

    public ProduitService(List<Produit> produits){
        this.produits=produits;
    }
    @Override
    public boolean create(Produit o) {
        return produits.add(o);
    }

    @Override
    public boolean update(Produit o) {
        return false;
    }

    @Override
    public boolean delete(Produit o) {
        return  produits.remove(o);
    }

    @Override
    public List<Produit> findAll() {
        return produits;
    }

    @Override
    public Produit findByid(int id) {

        for(Produit produit:produits){
            if (produit.getId()==id){
                return produit;
            }
        }
        return null;
    }
}
