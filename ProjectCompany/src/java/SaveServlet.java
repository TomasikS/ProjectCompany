/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
 

public class SaveServlet extends HttpServlet {  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String s1=request.getParameter("Firstname");  
        String s2=request.getParameter("Lastname");  
        String s3=request.getParameter("RC");  
        String s4=request.getParameter("Gender");  
        
        Employee e=new Employee();
      //  e.setId(RequestServlet.getDataID());
        e.setfirstname(s1);  
        e.setlastname(s2);  
        e.setrc(s3);  
        e.setgender(s4);  
          
       int status=
                
                
                Dataoperation.save2(e);  
        if(status>0){  
           out.print("<p>Record saved successfully!</p>");  
           request.getRequestDispatcher("index.html").include(request, response);  
       }else{  
            out.println("Sorry! unable to save record");  
       }  
          
        out.close();  
    }  
  
}  
