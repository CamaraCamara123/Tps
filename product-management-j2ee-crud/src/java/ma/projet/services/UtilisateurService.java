/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.services;

import java.util.List;
import ma.projet.dao.IDao;
import ma.projet.entities.Categorie;
import ma.projet.entities.Utilisateur;
import ma.projet.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author hp
 */
public class UtilisateurService implements IDao<Utilisateur>{

    @Override
    public boolean create(Utilisateur o) {
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
    
    public boolean update(Utilisateur o) {
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
    
    public boolean delete(Utilisateur o) {
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

    @Override
    public List<Utilisateur> findAll() {
        List<Utilisateur> utilisateurs = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateurs = session.createQuery("from Utilisateur").list();
            tx.commit();
            return utilisateurs;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return utilisateurs;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Utilisateur getById(int id) {
        Utilisateur utilisateur = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            utilisateur = (Utilisateur) session.get(Utilisateur.class, id);
            tx.commit();
            return utilisateur;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return utilisateur;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }
    
}
