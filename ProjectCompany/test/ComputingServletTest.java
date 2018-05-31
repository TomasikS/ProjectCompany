/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
import java.util.List;
import static org.junit.Assert.assertNotNull;
import org.junit.Test;

/**
 *
 * @author Lenovo
 */
public class ComputingServletTest {
    
    public ComputingServletTest() {
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
               
               for(int i=0;i<list3.size();i++)
               
              assertNotNull(list3.get(i).hplat);
          
                           for(int i=0;i<list2.size();i++)
                           {
               
             assertNotNull(list2.get(i).getId( ));
           assertNotNull(list2.get(i).getKids());
              assertNotNull(list2.get(i).getHours());
              assertNotNull(list2.get(i).getAmount());
              assertNotNull(list2.get(i).getBonus());
                 
                   assertNotNull(list2.get(i).getSp());
                 assertNotNull(list2.get(i).getZp());
                  assertNotNull(list2.get(i).getPbonus());
                 assertNotNull(list2.get(i).getZrazky());
                 assertNotNull(list2.get(i).dbonus);
    }
    
    
    }
    
}
