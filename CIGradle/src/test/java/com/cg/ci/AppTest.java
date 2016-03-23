package com.cg.ci;

import org.junit.Test;
import static org.junit.Assert.*;
import com.cg.ci.controller.HomeController;
public class AppTest {

	@Test
    public void testApp(){
        
		HomeController hc = new HomeController();
		String result = hc.home();
		
		assertEquals(result, "CI application, reporting for duty!!!!!!!!!");
		
    }
}
