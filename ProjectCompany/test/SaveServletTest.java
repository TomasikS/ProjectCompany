/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.BeforeClass;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

/**
 *
 * @author Lenovo
 */
public class SaveServletTest {
    
    public SaveServletTest() {
    }

 
     

    /**
     * Test of SaveServlet method, of class SaveServlet.
     */
    @Test
    public void testSaveServlet() throws Exception {
        HttpServletRequest request = null;
        
        HttpServletResponse response = null;
        System.out.println("SaveServlet");
 SaveServlet SaveServlet =new SaveServlet ();
 
 
SaveServlet.setS1("aa");
 String s1=SaveServlet.getS1();
    
    assertNotNull(s1);
    SaveServlet.setS2("aa");
    SaveServlet.setS3("aa");
    SaveServlet.setS4("aa");
    
     String s2=SaveServlet.getS2();
      String s3=SaveServlet.getS3();
       String s4=SaveServlet.getS4();
    
 assertNotNull(s2);
    assertNotNull(s3);
    assertNotNull(s4);
    }
    
}
