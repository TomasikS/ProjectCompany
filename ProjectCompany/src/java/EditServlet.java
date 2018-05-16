/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class EditServlet extends HttpServlet {  
    
    Dataoperation dao=new Dataoperation();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)   
           throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
        out.println("<h1>Update Employee</h1>");  
        String sid=request.getParameter("id");  
        int id=Integer.parseInt(sid);  
           List<Employee> list=dao.getAllEmployees();
        Employee e=dao.getEmployeeById(id);  
          
        out.print("<form action='RequestServlet' method='post'>");  
        out.print("<table>");  
        out.print("<tr><th>Id</th><th>Firstname</th><th>Lastname</th><th>RC</th><th>Gender</th></tr>");
        
        
        for(Employee z:list){
out.print("<tr><td>"+z.getId()+"</td><td>"+z.getfirstname()+
        "</td><td>"+z.getlastname()+"</td> <td>"+z.getrc()+"</td><td>"+z.getgender()+"</td><td>id="+z.getId()+ "</td></tr>");
                                                        } 
        out.print("<tr><td colspan='2'><input type='submit' value='Edit & Save '/></td></tr>");  
        out.print("</table>");  
        out.print("</form>");  
          
        out.close();  
    }  
}  
