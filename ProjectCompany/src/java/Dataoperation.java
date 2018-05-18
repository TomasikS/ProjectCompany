
 
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
    
    public static int save2(Employee e){  
       int status=0;  
        try{  
                 Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(  
                    "update employee set firstname=?,lastname=?,rc=?,gender=? ");  
            ps.setString(1,e.getfirstname());  
            ps.setString(2,e.getlastname());  
            ps.setString(3,e.getrc());  
            ps.setString(4,e.getgender());  
              
           status=ps.executeUpdate();  
              
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
       return status;  
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
           
        
        for (int i=0;i<zozv.size();i++)
            {
             zozv.get(i).plat=   zozv.get(i).getHours()+zozv.get(i).getBonus();
zozv.get(i).plat=zozv.get(i).plat*0.19;
        zozv.get(i).plat=zozv.get(i).plat*0.48;
            zozv.get(i).zp=9.4/100*zozv.get(i).plat;
             zozv.get(i).sp=4/100*zozv.get(i).plat;
            }
                 
         return zozv; 
        
    }  

   public static Employee getEmployeeById(int id){  
        Employee e=new Employee();  
          
        try{  
             Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            
            
             String query = "select * from employee where id=?";
            PreparedStatement ps = (PreparedStatement) conn.prepareStatement(query);
   
            ps.setInt(1,id);  
            ResultSet rs=ps.executeQuery();  
            if(rs.next()){  
                e.setId(rs.getInt(1));  
             
                  e.setfirstname(rs.getString(2));  
                e.setlastname(rs.getString(3));  
                e.setrc(rs.getString(4));  
                e.setgender(rs.getString(5));  
            }  
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return e;  
    }

    public static int update(Employee e){  
        int status=0;  
        try{  
           
            Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
            PreparedStatement ps=(PreparedStatement) conn.prepareStatement(  
                         "update employee set firstname=?,lastname=?,rc=?,gender=? where id=?");  
            ps.setString(2,e.getfirstname());  
            ps.setString(3,e.getlastname());  
            ps.setString(4,e.getrc());  
            ps.setString(5,e.getgender());  
           ps.setInt(5,e.getId());  
              
            status=ps.executeUpdate();  
              
            conn.close();  
        }catch(Exception ex){ex.printStackTrace();}  
          
        return status;  
    }  
    
     
    
    
    
    

}   
 