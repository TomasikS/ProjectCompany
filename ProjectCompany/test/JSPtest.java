
 
import data.Employee;
import com.mysql.jdbc.PreparedStatement;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestSuite;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

 public class JSPtest{

 
 
  

  public static List compute(){  
               String sql ="select * from  salary_history";
String driver = "com.mysql.jdbc.Driver";
String url = "jdbc:mysql://localhost:3306/company";
String database = "company";
String username = "root";
String password = "root";
  java.sql.Connection conn;
          List<Employee> zozv = new ArrayList<>();
        try{  
                 Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
          
           
        String query = "SELECT * from salary_history";
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
         
                 
         return zozv; 
        
    }
 
 @Test
   
	public void testSetContentTypeWithNoEncoding() throws ClassNotFoundException, SQLException {

        
                List<Employee> list2=compute();
                 assertNotNull(list2);
	}
     
}