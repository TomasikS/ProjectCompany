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
public class ComputeServlet extends HttpServlet {
 Dataoperation dop=new Dataoperation();
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            
            List<Employee> list2=dop.compute();
             System.out.println(list2);
             out.println("<link rel='stylesheet' href='style.css' type='text/css'>");
               
             out.print("</table>");
                                 out.print("<br>"); 
                                 out.print("<br>"); 
                          //   out.print(list2); 
                            
                              out.println("<h1>Salaries List</h1>");
                                
                                out.print("<br>"); 
                                
            out.print("<table border='1' width='100%'");                
              out.print("<tr><th>Id</th><th>Salary</th> <th>Social levies</th> <th>Health levies</th> </tr>"); 

for(int i=0;i<list2.size();i++)
              
//out.print("<tr><td>" +list2.get(i).getId()+"</td><td><td>"+  list2.get(i).getSp() +"</td></td><td><td>" +  list2.get(i).getZp()+"  </td></td></tr>"             );

 
  out.print("<tr><td>" +list2.get(i).getId()+ "</td> <td>" +list2.get(i).getPlat()+ "</td>   <td>" +list2.get(i).getSp()+ "</td>    <td>" +list2.get(i).getZp()+ "</td>  </tr>"       );
      
                           out.print("</table>");
        
                            
         out.print("<br>"); out.print("<br>"); out.print("<br>"); out.print("<br>"); 
                            
          out.print("<table border='1' width='100%'");                
             out.print("<tr><th>Id</th>  <th>Denactious payout</th> <th>taxbonus</th> <th> Bonus</th> </tr>"); 
for(int i=0;i<list2.size();i++)
              
//out.print("<tr><td>" +list2.get(i).getId()+"</td><td><td>"+  list2.get(i).getSp() +"</td></td><td><td>" +  list2.get(i).getZp()+"  </td></td></tr>"             );

 
    out.print("<tr><td>" +list2.get(i).getId()+"</td><td>" +list2.get(i).getZrazky()+ "</td> <td>" +list2.get(i).getDbonus()+ "</td>     <td>" +list2.get(i).getPbonus()+ "</td>  </tr>"       );
      
                            out.print("</table>");
                            
        }
    }                 
                            
                            
                            
                            
                            
                            
                            
                            
                            
        
 

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
