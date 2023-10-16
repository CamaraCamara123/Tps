/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.service;

import java.util.ArrayList;
import java.util.List;
import ma.project.dao.IDao;
import ma.project.entity.EmployeTache;
import ma.project.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class EmployeTacheService implements IDao<EmployeTache> {

    @Override
    public boolean create(EmployeTache o) {
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
    public boolean delete(EmployeTache o) {
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
    public boolean update(EmployeTache o) {
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
    public List<EmployeTache> findAll(EmployeTache o) {
        List<EmployeTache> employeTaches = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTaches = session.createQuery("from EmployeTache").list();
            tx.commit();
            return employeTaches;
        } catch (HibernateException ex) {
            if(tx != null)
                tx.rollback();
            return employeTaches;
        } finally {
            if(session != null)
                session.close();
        }
    }

    @Override
    public EmployeTache findById(int id) {
        EmployeTache employeTache = null;
        Session session = null;
        Transaction tx = null;
        try {
            session = HibernateUtil.getSessionFactory().openSession();
            tx = session.beginTransaction();
            employeTache = (EmployeTache) session.get(EmployeTache.class, id);
            tx.commit();
            return employeTache;
        } catch (HibernateException ex) {
            if (tx != null) {
                tx.rollback();
            }
            return employeTache;
        } finally {
            if (session != null) {
                session.close();
            }
        }
    }

}

