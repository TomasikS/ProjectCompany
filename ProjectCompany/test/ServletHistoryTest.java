/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class ServletHistoryTest {
                private static String driver = "com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/company";
    private static String username="root";
    private static String password="root";
          private static java.sql.Connection conn;
          
    public ServletHistoryTest() {
    }
 

    /**
     * Test of doPost method, of class ServletHistory.
     */
    @Test
    public void testDoPost() throws Exception {
        Statement statement = null;
         boolean pass = false;
    ResultSet resultSet = null;
  Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
        assertEquals(conn!= null, true);
 
     statement = conn.createStatement();
    resultSet = statement.executeQuery("SELECT absence_history.jun, employee.id, employee. firstname, employee.lastname from absence_history inner join employee on employee.id=absence_history.idu");
   
    if (resultSet == null) {
        pass = true;
        assertEquals(pass, true);
    }
    }
      @Test
    public void testDoPost2() throws Exception {
        Statement statement = null;
         boolean pass = false;
    ResultSet resultSet = null;
  Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
        assertEquals(conn!= null, true);
 
     statement = conn.createStatement();
    resultSet = statement.executeQuery("SELECT absence_history.april, employee.id, employee. firstname, employee.lastname from absence_history inner join employee on employee.id=absence_history.idu");
   
    if (resultSet == null) {
        pass = true;
        assertEquals(pass, true);
    }
    }  
}
