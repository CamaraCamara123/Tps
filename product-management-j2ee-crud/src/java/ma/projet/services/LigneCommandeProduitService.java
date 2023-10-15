/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entities.LigneCommandeProduit;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lachgar
 */
public class LigneCommandeProduitService implements IDao<LigneCommandeProduit> {
     @Override
    public boolean create(LigneCommandeProduit o) {
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

   
   

    @Override
    public List<LigneCommandeProduit> findAll() {
        List<LigneCommandeProduit> ligneCommandeProduits = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            ligneCommandeProduits = session.createQuery("from LigneCommandeProduit").list();
            tx.commit();
            return ligneCommandeProduits;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return ligneCommandeProduits;
        } finally {
            if(session != null)
                session.close();
        }
    }


        public boolean update(LigneCommandeProduit o) {
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
    @Override
    public LigneCommandeProduit getById(int id) {
        LigneCommandeProduit ligneCommandeProduit = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            ligneCommandeProduit = (LigneCommandeProduit) session.get(LigneCommandeProduit.class, id);
            tx.commit();
            return ligneCommandeProduit;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return ligneCommandeProduit;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

    
}

