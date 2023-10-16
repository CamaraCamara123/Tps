
package ma.projet.test;

import ma.projet.util.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Lenovo
 */
public class Heritage2 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Session session = HibernateUtil.getSessionFactory().openSession();
    }
    
}
