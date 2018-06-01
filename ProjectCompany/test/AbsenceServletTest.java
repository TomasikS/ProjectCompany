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
public class AbsenceServletTest {
    
    public AbsenceServletTest() {
    }
    
  

    /**
     * Test of doGet method, of class AbsenceServlet.
     */
    @Test
    public void testDoGet() throws Exception {
 Dataoperation dop=new Dataoperation();
  List<Employee> list=dop.getAbsences();
   assertNotNull(list);
   
   
    }
    
}
