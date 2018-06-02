/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import data.Dataoperation;
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
public class ServletTest {
    
    public ServletTest() {
    }
    
   

    /**
     * Test of doGet method, of class Servlet.
     */
    @Test
    public void testDoGet() throws Exception {
  Dataoperation dop=new Dataoperation();
             assertNotNull(dop);
  
    }
    
}
