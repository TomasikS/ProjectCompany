
 
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Lenovo
 */
public class Dataoperation {

     private static java.sql.Connection conn;
    private static String driver = "com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/company";
    private static String username="root";
    private static String password="root";

   
   
   public List<Employee>  getAllEmployees(){
        List<Employee> list = new ArrayList<>();
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            String query = "SELECT * from employee";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){  
                Employee e=new Employee();  
                e.setId(rs.getInt(1));  
                e.setfirstname(rs.getString(2));  
                e.setlastname(rs.getString(3));  
                e.setrc(rs.getString(4));  
                e.setgender(rs.getString(5));  
                list.add(e);  
             
            }  
conn.close();
        }catch(Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }
        return list;
    }
   
    public static int save(Employee e){  
       int status=0;  
        try{  
                 Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(  
                         "insert into employee(firstname,lastname, rc,gender) values (?,?,?,?)");  
            ps.setString(1,e.getfirstname());  
            ps.setString(2,e.getlastname());  
            ps.setString(3,e.getrc());  
            ps.setString(4,e.getgender());  
              
           status=ps.executeUpdate();  
              
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
       return status;  
    }  
    
         public static List compute2() throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException{  
        
          List<Employee> zozp = new ArrayList<>();
       
                 Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
          
           
        String query = "SELECT salary5 from salary_history";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){  
                Employee e=new Employee();  
               e.setHplat(rs.getInt(1));
              
             zozp.add(e);
            }  
              
            conn.close(); 
            return zozp;
            }
        
        
        
         
      public static List compute(){  
        
          List<Employee> zozv = new ArrayList<>();
        try{  
                 Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
          
           
        String query = "SELECT * from employee_details";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){  
                Employee e=new Employee();  
               e.setId(rs.getInt(1));
               e.setKids(rs.getInt(3));
             e.setHours(rs.getInt(4));
             e.setAmount(rs.getInt(5));
             e.setBonus(rs.getInt(6));
             zozv.add(e);
            }  
              
            conn.close(); 
            
            }catch(Exception ex){ex.printStackTrace();} 
              List<Employee> zoz = new ArrayList<>();
         try {
             zoz=compute2();
         } catch (ClassNotFoundException ex) {
             Logger.getLogger(Dataoperation.class.getName()).log(Level.SEVERE, null, ex);
         } catch (SQLException ex) {
             Logger.getLogger(Dataoperation.class.getName()).log(Level.SEVERE, null, ex);
         } catch (InstantiationException ex) {
             Logger.getLogger(Dataoperation.class.getName()).log(Level.SEVERE, null, ex);
         } catch (IllegalAccessException ex) {
             Logger.getLogger(Dataoperation.class.getName()).log(Level.SEVERE, null, ex);
         }
         for (int j=0;j<zoz.size();j++)
        zozv.get(j).hplat=zoz.get(j).getHplat();
         
         
        for (int i=0;i<zozv.size();i++)
            {
             zozv.get(i).plat=   zozv.get(i).getHours()+zozv.get(i).getBonus()+ zozv.get(0).hplat;
zozv.get(i).plat=zozv.get(i).plat*0.19;
        zozv.get(i).plat=zozv.get(i).plat*0.48;
            zozv.get(i).zp=(9.4 /100)*zozv.get(i).plat;
             zozv.get(i).sp=(4.0 /100)*zozv.get(i).plat;
             zozv.get(i).dbonus=20*zozv.get(i).getKids();
                zozv.get(i).zrazky=0.6* zozv.get(i).plat -( zozv.get(i).plat-zozv.get(i).getKids()*1245 -zozv.get(i).plat); 
               zozv.get(i).zrazky=          zozv.get(i).zrazky/3;
               zozv.get(i).pbonus=0.19*(zozv.get(i).plat-    zozv.get(i).sp -   zozv.get(i).zp     );
               if(zozv.get(i).pbonus <0) zozv.get(i).pbonus=0;
               
            
            }
                 
         return zozv; 
        
    }

     public List<Employee>  getAbsences(){
        List<Employee> list = new ArrayList<>();
        try {
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            String query = "SELECT absence.absence, absence.absence_P, absence. ill, employee.firstname, employee.lastname from absence inner join employee on employee.id=absence.idu; ";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
            ResultSet rs=ps.executeQuery();
            while(rs.next()){  
                Employee e=new Employee();  
                e.setAbsenceA(rs.getInt(1));  
                 e.setAbsenceP(rs.getInt(2));  
                 e.setAbsenceI(rs.getInt(3)); 
                  e.setfirstname(rs.getString(4));  
                e.setlastname(rs.getString(5));  
               
                list.add(e);  
             
            }  
conn.close();
        }catch(Exception ex){
            System.out.println("Error: "+ ex.getMessage());
        }
        return list;
    }
    
     
    
    
    
    

}   
 