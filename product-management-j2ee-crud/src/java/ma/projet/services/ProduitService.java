/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entities.Commande;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.entities.Produit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lachgar
 */
public class ProduitService implements IDao<Produit> {

    @Override
    public boolean create(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.save(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
public boolean update(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.update(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    public boolean delete(Produit o) {
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            session.delete(o);
            tx.commit();
            return true;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return false;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    public List<Produit> findBetweenDate(Date d1, Date d2) {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.getNamedQuery("betweenDate").setParameter("d1", d1).setParameter("d2", d2).list();
            tx.commit();
            return produits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return produits;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public List<Produit> findAll() {
        List<Produit> produits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produits = session.createQuery("from Produit").list();
            tx.commit();
            return produits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return produits;
        } finally {
            if(session != null)
                session.close();
        }
    }



    @Override
    public Produit getById(int id) {
        Produit produit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            produit = (Produit) session.get(Produit.class, id);
            tx.commit();
            return produit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return produit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
    
    public void findProduitByCommande(Commande c){
        SimpleDateFormat format = new SimpleDateFormat();
        System.out.println("Commande: " + c.getId() + "\t\tDate: " + format.format(c.getDate()));
        System.out.println("Liste des produits :");
        
        List<LigneCommandeProduit> commandeProduits = null;
        Session session = null;
        Transaction tx = null;
        String query = "select l FROM LigneCommandeProduit l "
                + "join l.produit Produit "
                + "join l.commande Commande "
                + "where Commande.id = :id";
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            //commandeProduits = session.getNamedQuery("findByCommande").setParameter("id", c.getId()).list();
            commandeProduits =  session.createQuery(query)
                    .setParameter("id", c.getId()).list();
            
           
            
            tx.commit();
            System.out.println("\tRéférence\t\tPrix\t\tQuantité");
            for(LigneCommandeProduit l : commandeProduits){
                System.out.println("\t" + l.getProduit().getReference() + "\t\t" + l.getProduit().getPrix() + " DH" + "\t\t" + l.getQuantite());
            }
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
        } finally {
            if(session != null)
                session.close();
        }
       
    }
    
    
}
