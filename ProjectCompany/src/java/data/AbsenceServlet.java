package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data.Employee;
import data.Dataoperation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class AbsenceServlet extends HttpServlet {

  
  Dataoperation dop=new Dataoperation();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
               throws ServletException, IOException {  
        response.setContentType("text/html");  
        try (PrintWriter out = response.getWriter()) {
         //   out.println("<a href='index.html'>Add New Employee</a>");
            out.println("<h1>Absences List</h1>");
            
            List<Employee> list=dop.getAbsences();
            
            System.out.println(list);
            // List<Employee> list2=dop.compute();
            // System.out.println(list2);
             out.println("<link rel='stylesheet' href='style.css' type='text/css'>");
               
            out.print("<table border='1' width='100%'");
out.print("<tr><th>Firstname</th><th>Lastname</th><th>Absence</th><th>Absence_P</th><th>  Ill     </th></tr>");    
           
for(Employee e:list){
out.print("<tr><td>"+e.getfirstname()+"</td><td>"+e.getlastname()+
        "</td><td>"+e.getAbsenceA()+"</td> <td>"+e.getAbsenceP()+"</td><td>"+e.getAbsenceI()+"</td> </tr>");
                                                        }
              
       
                            
        }     }    }  
        
        
        
