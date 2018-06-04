package data;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data.Dataoperation;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Lenovo
 */
 

public class SaveServlet extends HttpServlet { 



    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public String getS3() {
        return s3;
    }

    public String getS4() {
        return s4;
    }
    
  public  String s1,s2,s3,s4;

    public void setS1(String s1) {
     this.s1=s1;
    
    }

    public void setS2(String s2) {
        this.s2 = s2;
    }

    public void setS3(String s3) {
        this.s3 = s3;
    }

    public void setS4(String s4) {
        this.s4 = s4;
    }
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response)   
         throws ServletException, IOException {  
        response.setContentType("text/html");  
        PrintWriter out=response.getWriter();  
          
        String s1=request.getParameter("Firstname");  
        String s2=request.getParameter("Lastname");  
        String s3=request.getParameter("RC");  
        String s4=request.getParameter("Gender");
                int s5=Integer.parseInt(request.getParameter("AM"));  
        int s6=Integer.parseInt(request.getParameter("HH"));
                int s7=Integer.parseInt(request.getParameter("KK"));  
  String s8=request.getParameter("GR");
        boolean b=validate(s1);
        boolean bb=validate(s2);
              /// if(s1.length() > 2 && s2.length() > 2&& s3.length() > 9&& s4.length() > 0 &&b==true && bb==true) {
                  
              if((b==true) && (bb==true)  && (s8.equals("on")))
              {
              Employee e=new Employee();
    
        
        e.setfirstname(s1);  
        e.setlastname(s2);  
        e.setrc(s3);  
        e.setgender(s4);  
       e.setAmount(s5);
               e.setHours(s6);
        e.setHours(s7);
        
          setS1(s1);
               setS3(s3);
                setS2(s2);
                 setS4(s4);
                 int status = 0;
        
                   
                 
                
                 status= Dataoperation.save(e); 
                    status= Dataoperation.save2(e); 
                 
        if(status>0){  
           out.print("<p>Record saved successfully!</p>");  
           request.getRequestDispatcher("index.html").include(request, response);  
       }else{  
            out.println("failed save");  
       }  
          }
           else{  
            out.println("Sorry! WRONG INPUT");  
       }    
               
               
        out.close();  
    } 



boolean validate(String h){
  String pattern = "([A-Z][a-zA-Z]*)";
         Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(h);
       if (m.find( )) {
    return true;
      }else {
         return false;
      }
}

}  
  
  
