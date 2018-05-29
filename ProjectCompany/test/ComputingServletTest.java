/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
public class ComputingServletTest {
    
    public ComputingServletTest() {
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
     * Test of processRequest method, of class ComputingServlet.
     
    @Test
    public void testProcessRequest() throws Exception {
        System.out.println("processRequest");
        HttpServletRequest request = null;
        HttpServletResponse response = null;
        ComputingServlet instance = new ComputingServlet();
        instance.processRequest(request, response);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    */
        @Test
    public void testProcessRequest() throws Exception {
        Dataoperation dop=new Dataoperation();
 ComputingServlet ComputingServlet=new ComputingServlet();
  List<Employee> list2 = null;
        List<Employee> list3 = null;      
                list2 = dop.compute();    assertNotNull(list2);
                list3= dop.compute2();assertNotNull(list3);
          
          
                assertNotNull(list2.get(0).getId( ));
                assertNotNull(list2.get(0).getKids());
                assertNotNull(list2.get(0).getHours());
                 assertNotNull(list2.get(0).getAmount());
                 assertNotNull(list2.get(0).getBonus());
                 
                 
                 
                 
                 
                
    }
    
}
