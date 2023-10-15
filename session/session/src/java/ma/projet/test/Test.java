/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.test;

import java.time.LocalDate;
import java.util.Date;
import ma.projet.entity.Client;
import ma.projet.entity.Employe;
import ma.projet.service.ClientService;
import ma.projet.service.EmployeService;
import ma.projet.util.HibernateUtil;
import org.hibernate.Hibernate;

/**
 *
 * @author Lachgar
 */
public class Test {

    public static void main(String[] args) {
        ClientService cs = new ClientService();
        cs.create(new Client("bennane", "ilyass", new Date(2022,03, 15), "bennane.i@gmail.com", "azer1234"));
        EmployeService es = new EmployeService();
        es.create(new Employe("admin@admin.com", "azerty"));
    }
}
