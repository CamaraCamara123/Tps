/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ma.projet.entity;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author Lachgar
 */
@Entity
public class Employe extends User  {

    public Employe() {
    }

    public Employe(String email, String password) {
        super(email, password);
    }
  
    @Override
    public String toString() {
        return "ma.projet.entity.Employe[ id=" + id + " ]";
    }
    
}
