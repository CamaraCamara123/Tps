/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.project.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;

@Entity
public class EmployeTache implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private int id;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "tache", referencedColumnName = "id", insertable = false, updatable = false)
    private Tache tache;
    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employe", referencedColumnName = "id", insertable = false, updatable = false)
    private Employe employe;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateDebutRelle;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date dateFinRelle;

    public EmployeTache() {
    }

    public EmployeTache(Date dateDebutRelle, Date dateFinRelle, Tache tache, Employe employe) {
        this.dateDebutRelle = dateDebutRelle;
        this.dateFinRelle = dateFinRelle;
        this.tache = tache;
        this.employe = employe;
    }

    public EmployeTache(Tache tache, Employe employe, Date dateDebutRelle, Date dateFinRelle) {
        this.tache = tache;
        this.employe = employe;
        this.dateDebutRelle = dateDebutRelle;
        this.dateFinRelle = dateFinRelle;
    }
    
    

    public Date getDateDebutRelle() {
        return dateDebutRelle;
    }

    public void setDateDebutRelle(Date dateDebutRelle) {
        this.dateDebutRelle = dateDebutRelle;
    }

    public Date getDateFinRelle() {
        return dateFinRelle;
    }

    public void setDateFinRelle(Date dateFinRelle) {
        this.dateFinRelle = dateFinRelle;
    }

    public Tache getTache() {
        return tache;
    }

    public void setTache(Tache tache) {
        this.tache = tache;
    }

    public Employe getEmploye() {
        return employe;
    }

    public void setEmploye(Employe employe) {
        this.employe = employe;
    }
    
}
