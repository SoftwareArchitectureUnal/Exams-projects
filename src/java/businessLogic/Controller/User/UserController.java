/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package businessLogic.Controller.User;

import dataAccess.DAO.UsersDAO;
import dataAccess.Entity.Users;

/**
 *
 * @author AndresGutierrez
 */
public class UserController {
    public Users login(String username,String password){
        UsersDAO usersDAO = new UsersDAO();
        Users users = usersDAO.searchUserByUsername(username);
        if(users!=null){
            if(users.getPassword().equals(password)){
                return users;
            }
            return null;
            
        }
        return null;
    }
    public Users register(String username,String name,String email,String password, 
            int gender,String role ){
           System.out.println(username+" "+name+" "+email+" "+password+" "+gender+" "+role);
           UsersDAO usersDAO = new UsersDAO();
           Users user = new Users();
           user.setEmail(email);
           user.setName(name);
           user.setUserId(username);
           user.setGender(gender);
           user.setPassword(password);
           user.setRole(role);
           Users temp = usersDAO.persist(user);
           return temp;
    
    }
}
