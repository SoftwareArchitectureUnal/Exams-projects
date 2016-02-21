/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package webLogic.Servlets;

import dataAccess.Entity.Users;
import java.io.IOException;
import javax.faces.context.FacesContext;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author AndresGutierrez
 */
@WebServlet("/admin/*")
public class Admin extends HttpServlet{
    public void manageRequest(ServletRequest req, ServletResponse res) throws ServletException, IOException{
        Users user = (Users) req.getAttribute("user");

        System.out.println(user!=null?"algo":"good");
        if(user!=null){
            if(!user.getRole().equals("admin")){
                RequestDispatcher rd = req.getRequestDispatcher("/index.xhtml");
                rd.forward(req, res);
            }
        }
        RequestDispatcher rd = req.getRequestDispatcher("/login.xhtml");
        rd.forward(req, res);
        
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        manageRequest(req, res); //To change body of generated methods, choose Tools | Templates.
    }
    
    

    

    
    
    

    
    
    
}
