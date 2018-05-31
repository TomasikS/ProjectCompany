/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.sql.SQLException;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Test;
/**
 *
 * @author Lenovo
 */
public class ComputeServletTest {
    
    public ComputeServletTest() {
    }
    
  

 
    @Test
   
	public void testSetContentTypeWithNoEncoding() throws ClassNotFoundException, SQLException {

          Dataoperation dop=new Dataoperation();
                List<Employee> list2=dop.compute();
                 assertNotNull(list2);
	}



    /**
     * Test of doGet method, of class ComputeServlet.
     */
 

    /**
     * Test of doPost method, of class ComputeServlet.
     */
 
    
}
