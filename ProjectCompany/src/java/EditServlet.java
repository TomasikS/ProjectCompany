/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.*; 

/**
 *
 * @author Lenovo
 */
public class EditServlet extends HttpServlet 
{

        
 
         @Override
         protected void    doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
    // set String foo to the form element named "foo"
  String s1=request.getParameter("Firstname");  System.out.println("s1"+s1);
        String s2=request.getParameter("Lastname");  
        String s3=request.getParameter("RC");  
        String s4=request.getParameter("Gender");  
           PrintWriter out=response.getWriter();  
        Employee e=new Employee();  
        e.setfirstname(s1);  
        e.setlastname(s2);  
        e.setrc(s3);  
        e.setgender(s4);
 int status=
                
                
                Dataoperation.save(e);  
        if(status>0){  
           out.print("<p>Record saved successfully!</p>");  
           request.getRequestDispatcher("index.html").include(request, response);  
       }else{  
            out.println("Sorry! unable to save record");  
       }  
          
        out.close();  
    }
    
    
    
    
    
         }
        
        
        
  
