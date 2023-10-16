/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.service;

import java.util.ArrayList;
import java.util.List;
import ma.project.dao.IDao;
import ma.project.entity.Employe;
import ma.project.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

/**
 *
 * @author Lachgar
 */
public class EmployeService implements IDao<Employe> {

    @Override
    public boolean create(Employe o) {
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
    public boolean delete(Employe o) {
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
    public boolean update(Employe o) {
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
    public List<Employe> findAll(Employe o) {
        List<Employe> employes = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employes = session.createQuery("from Employe").list();
            tx.commit();
            return employes;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return employes;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public Employe findById(int id) {
        Employe employe = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employe = (Employe) session.get(Employe.class, id);
            tx.commit();
            return employe;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return employe;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}
