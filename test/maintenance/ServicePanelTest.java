/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maintenance;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akob
 */
public class ServicePanelTest {
    
    public ServicePanelTest() {
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
     * Test of addVisit method, of class ServicePanel.
     */
    @Test
    public void testAddVisit() {
        System.out.println("addVisit");
        String datetime = "";
        ServicePanel.addVisit(datetime);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addService method, of class ServicePanel.
     */
    @Test
    public void testAddService() {
        System.out.println("addService");
        String s = "";
        ServicePanel.addService(s);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delService method, of class ServicePanel.
     */
    @Test
    public void testDelService() {
        System.out.println("delService");
        int idx = 0;
        ServicePanel.delService(idx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of delVisit method, of class ServicePanel.
     */
    @Test
    public void testDelVisit() {
        System.out.println("delVisit");
        int idx = 0;
        ServicePanel.delVisit(idx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateTotalCost method, of class ServicePanel.
     */
    @Test
    public void testUpdateTotalCost() {
        System.out.println("updateTotalCost");
        double[] c = null;
        ServicePanel.updateTotalCost(c);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
