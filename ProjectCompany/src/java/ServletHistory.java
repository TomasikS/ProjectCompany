/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import com.mysql.jdbc.PreparedStatement;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
public class ServletHistory extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
      private static java.sql.Connection conn;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/company";
    private static String username="root";
    private static String password="root";
         List<Employee> list = new ArrayList<>();
         List<Employee> list2 = new ArrayList<>();
    /**
     *
     * @param request
     * @param response
     * @return
     * @throws ServletException
     * @throws IOException
     */
      @Override
  protected void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
          
              response.setContentType("text/html");
              PrintWriter out=response.getWriter();
              String colname="";
              String s1=request.getParameter("isTitles");
              String s=s1;
              String s2=s1;
        s1="salary"+s;
           // out.print(s2);
                 if(s2.equals("1"))colname="januar";
                  if(s2.equals("2"))colname="februar";
                   if(s2.equals("3"))colname="march";
                    if(s2.equals("4"))colname="april";
                     if(s2.equals("5"))colname="may";
                      if(s2.equals("6"))colname="jun";
                       if(s2.equals("7"))colname="july";
                        if(s2.equals("8"))colname="august";
                         if(s2.equals("9"))colname="september";
                          if(s2.equals("10"))colname="october";
                           if(s2.equals("11"))colname="november";
                            if(s2.equals("12"))colname="december";
                 
           // out.print(colname);       
                 
                 
                 
                 
                 
                 
             
          try {
              Class.forName(driver).newInstance();
          } catch (ClassNotFoundException ex) {
              Logger.getLogger(ServletHistory.class.getName()).log(Level.SEVERE, null, ex);
          } catch (InstantiationException ex) {
              Logger.getLogger(ServletHistory.class.getName()).log(Level.SEVERE, null, ex);
          } catch (IllegalAccessException ex) {
              Logger.getLogger(ServletHistory.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              conn = DriverManager.getConnection(url,username,password);
          } catch (SQLException ex) {
              Logger.getLogger(ServletHistory.class.getName()).log(Level.SEVERE, null, ex);
          }
            String query2 = "SELECT absence_history."+  colname       +", employee.id, employee. firstname, employee.lastname from absence_history inner join employee on employee.id=absence_history.idu";   
            PreparedStatement pss = null;
          try {
              pss = (PreparedStatement) conn.prepareStatement(query2);
          } catch (SQLException ex) {
              Logger.getLogger(ServletHistory.class.getName()).log(Level.SEVERE, null, ex);
          }
          try {
              ResultSet rs=pss.executeQuery();
              
                 while(rs.next()){ 
                     Employee e=new Employee();
                     
                 e.setAbsence(rs.getInt(1));       
            e.setId(rs.getInt(2));
         e.setfirstname(rs.getString(3));  
                   e.setlastname(rs.getString(4)); 
                list2.add(e);  
             }
              
          } catch (SQLException ex) {
              Logger.getLogger(ServletHistory.class.getName()).log(Level.SEVERE, null, ex);
          }
     
          //out.println(list2.toString());
           out.print("<H1>History of absence</H1>");
          
          out.println("<link rel='stylesheet' href='style.css' type='text/css'>");
           out.print("<table border='1' width='100%'");
        
        out.print("<tr><th>Id</th><th>Firstname</th><th>Lastname</th><th>Absence</th></tr>");    
          
          
          
          for(Employee e:list2){
out.print("<tr><td>"+e.getId()+"</td><td>"+e.getfirstname()  +"</td><td>"+e.getlastname()+"</td><td>"+e.getAbsence()        );
        
        
        
        }
           out.print("</table>");
        
        
     //   out.close();
          
            out.print("<br>");
             out.print("<br>");
              out.print("<br>");
               out.print("<br>"); out.print("<br>");
               
                out.print("<H1> History of salary</H1>");
               
                   out.print("<br>");
          
          
          
          
          
            
          try {
              conn.close();
          } catch (SQLException ex) {
              Logger.getLogger(ServletHistory.class.getName()).log(Level.SEVERE, null, ex);
          }
              
             try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            String query = "SELECT Salary_history. salary1, employee.id, employee. firstname, employee.lastname from Salary_history inner join employee on employee.id=Salary_history.idu;";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){  
                Employee e=new Employee();  
                e.setOldv(rs.getInt(1));  
                 e.setId(rs.getInt(2));
         e.setfirstname(rs.getString(3));  
                   e.setlastname(rs.getString(4)); 
                list.add(e);  
             
            }  
conn.close();
        }catch(Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        } //out.print(list);  
        
        out.println("<link rel='stylesheet' href='style.css' type='text/css'>");
               
            out.print("<table border='1' width='100%'");
        
        out.print("<tr><th>Id</th><th>Firstname</th><th>Lastname</th><th>Salary</th></tr>");    
           
for(Employee e:list){
out.print("<tr><td>"+e.getId()+"</td><td>"+e.getfirstname()  +"</td><td>"+e.getlastname()+"</td><td>"+e.getOldv()         );
        
        
        
        }
           out.print("</table>");
        
        
        out.close(); }
              
         
              
              
 
               
              
            
              //ArrayList s1=new ArrayList();s1.add(request.getParameter("isTitles"));out.print(s1.toString());
              
        
      

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
 

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */


    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
  
   
}
 

