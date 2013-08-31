/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Jean
 */
public class EntityManagerUtil {

    private static EntityManager em;
    private static EntityManagerFactory emf;
    
    private EntityManagerUtil(){
    }
    
    private static void inicializaEntityManager(){        
        if(emf==null||!emf.isOpen()){
            emf = Persistence.createEntityManagerFactory("ProjetoIntegradorPU");
        }                
        em = emf.createEntityManager();
    }    
    
    public static EntityManager getEntityManager(){
        testaEntityManager();
        return em;
    }
    
    private static void testaEntityManager(){
        if(em==null||!em.isOpen()){
            inicializaEntityManager();
        }
    }
    
    public static void finalizaEntityManager(){
        if(em != null ){
            em.close();
        }
        if(emf != null){
            emf.close();
        }
    }
    
    /* 
    public static void beginTransaction(){
        testaEntityManager();        
        em.getTransaction().begin();
    }
    
    public static void cancelTransaction(){
        em.getTransaction().rollback();
    }   
    
    public static void commitTransaction(){
        em.getTransaction().commit();
    }
     */
}
