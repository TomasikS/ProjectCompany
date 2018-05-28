/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Lenovo
 */
public class DataoperationTest {
            private static String driver = "com.mysql.jdbc.Driver";
    private static String url="jdbc:mysql://localhost:3306/company";
    private static String username="root";
    private static String password="root";
        private static java.sql.Connection conn;
        
    public DataoperationTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getAllEmployees method, of class Dataoperation.
     */
    @Test
    public void testGetAllEmployees() throws Exception {
         Statement statement = null;
         boolean pass = false;
    ResultSet resultSet = null;
  Class.forName(driver).newInstance();
            conn = DriverManager.getConnection(url,username,password);
        assertEquals(conn!= null, true);
 
     statement = conn.createStatement();
    resultSet = statement.executeQuery("SELECT * from employee");
   
    if (resultSet == null) {
        pass = true;
        assertEquals(pass, true);
    }
    } 
    
    
      @Test
    public void testcompute() throws SQLException{
    Statement statement = null;
         boolean pass = false;
    ResultSet resultSet = null;
                try {
                    Class.forName(driver).newInstance();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DataoperationTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(DataoperationTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DataoperationTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            conn = DriverManager.getConnection(url,username,password);
        assertEquals(conn!= null, true);
 
     statement = conn.createStatement();
    resultSet = statement.executeQuery("SELECT * from employee_details");
   
    if (resultSet == null) {
        pass = true;
        assertEquals(pass, true);
    }
    
    }
    
    @Test
     public void getAbsences() throws SQLException{
       Statement statement = null;
         boolean pass = false;
    ResultSet resultSet = null;
                try {
                    Class.forName(driver).newInstance();
                } catch (ClassNotFoundException ex) {
                    Logger.getLogger(DataoperationTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (InstantiationException ex) {
                    Logger.getLogger(DataoperationTest.class.getName()).log(Level.SEVERE, null, ex);
                } catch (IllegalAccessException ex) {
                    Logger.getLogger(DataoperationTest.class.getName()).log(Level.SEVERE, null, ex);
                }
            conn = DriverManager.getConnection(url,username,password);
        assertEquals(conn!= null, true);
 
     statement = conn.createStatement();
    resultSet = statement.executeQuery("SELECT absence.absence, absence.absence_P, absence. ill, employee.firstname, employee.lastname from absence inner join employee on employee.id=absence.idu; ");
   
    if (resultSet == null) {
        pass = true;
        assertEquals(pass, true);
    }
     
     }
            
            
    }
    

