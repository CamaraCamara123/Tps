/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.gestion_project;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import ma.project.entity.Employe;
import ma.project.entity.EmployeTache;
import ma.project.entity.Projet;
import ma.project.entity.Tache;
import ma.project.service.EmployeService;
import ma.project.service.EmployeTacheService;
import ma.project.service.ProjetService;
import ma.project.service.TacheService;


public class Gestion_project {

    public static void main(String[] args) {
        EmployeService es = new EmployeService();
        TacheService ts = new TacheService();
        ProjetService ps = new ProjetService();
        EmployeTacheService ets = new EmployeTacheService();
        List<Tache> taches = new ArrayList<Tache>();
        
        es.create(new Employe("Abdul", "Kader", "05142637"));
        es.create(new Employe("Raim", "Nader", "051416537"));
        es.create(new Employe("Diawara", "Moussa", "07142637"));
        
//        ts.create(new Tache("conception",new Date(2023,9,1),new Date(2023,9,20),15000));
//        ts.create(new Tache("Analyse",new Date(2023,9,20),new Date(2023,9,25),8000));
//        ts.create(new Tache("Developpement",new Date(2023,9,4),new Date(2023,9,10),20000));
//        ts.create(new Tache("Test",new Date(2023,9,25),new Date(2023,11,20),10000));
//        taches.add(ts.findById(1));
//        taches.add(ts.findById(2));
//        taches.add(ts.findById(3));
//        taches.add(ts.findById(4));
//
//        ps.create(new Projet("App reconnaissance faciale",new Date(2023,9,1),new Date(2023,11,30),taches,es.findById(1)));
//        ps.create(new Projet("App Assistance aux dermatologue",new Date(2023,10,1),new Date(2023,11,30),taches,es.findById(1)));
//        ps.create(new Projet("App de gestion des rdv",new Date(2023,8,1),new Date(2023,9,30),taches,es.findById(2)));
//
//        ets.create(new EmployeTache(new Date(2023,9,1), new Date(2023,9,20), ts.findById(1), es.findById(2)));
//        ets.create(new EmployeTache(new Date(2023,9,10), new Date(2023,9,20), ts.findById(3), es.findById(1)));
//        ets.create(new EmployeTache(new Date(2023,9,11), new Date(2023,9,20), ts.findById(4), es.findById(2)));
//        ets.create(new EmployeTache(new Date(2023,9,1), new Date(2023,9,20), ts.findById(2), es.findById(3)));


    }
    
}
