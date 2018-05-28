/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.junit.Assert.*;
import org.springframework.mock.web.MockHttpServletResponse;
import java.util.Set;
import javax.servlet.http.HttpServletResponse;
import org.junit.Test;
import org.springframework.web.util.WebUtils;
/**
 *
 * @author Lenovo
 */
public class ComputeServletTest {
    
    public ComputeServletTest() {
    }
    
  

 
    @Test
   
	public void testSetContentTypeWithNoEncoding() {

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
