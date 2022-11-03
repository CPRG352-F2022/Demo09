
package dataaccess;

import javax.persistence.EntityManager;
import models.User;

public class UserDB {
    
    public User getUser(String email) throws Exception {
        EntityManager em = DBUtil.getEmFactory().createEntityManager();
        
        try{
            User user = em.find(User.class, email);
            return user;
        } finally {
            em.close();
        }
    }
    
}
