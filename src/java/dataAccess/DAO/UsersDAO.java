/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess.DAO;

import dataAccess.Entity.Users;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author AndresGutierrez
 */
public class UsersDAO {
    public EntityManagerFactory emf = 
            Persistence.createEntityManagerFactory("softwareArchitectureExamsPU");
    
   public Users persist(Users user){
       EntityManager em = emf.createEntityManager();
       em.getTransaction().begin();
       try{
           em.persist(user);
           em.getTransaction().commit();
       }catch(Exception e){
           em.getTransaction().rollback();
           return null;
       }finally{
           return user;
       }
   }
   
   public Users searchUserByUsername(String username){
       EntityManager em = emf.createEntityManager();
       Users users = null;
       try{
           
           users = em.find(Users.class, username);
       }catch(Exception e){}
       finally{
           return users;
       }
   }
    
}
