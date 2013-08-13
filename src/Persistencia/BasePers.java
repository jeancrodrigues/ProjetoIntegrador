/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Persistencia;

import Util.EntityManagerUtil;
import javax.persistence.EntityManager;

/**
 *
 * @author Jean
 */
class BasePers {

    private EntityManager em;
    
    protected BasePers(){
        em = EntityManagerUtil.getEntityManager();
    }

    protected EntityManager getEm() {
        return em;
    }    
    
    public void beginTransaction(){
        em.getTransaction().begin();
    }
    
    public void cancelTransaction(){
        em.getTransaction().rollback();
    }   
    
    public void commitTransaction(){
        em.getTransaction().commit();
    }
    
}
