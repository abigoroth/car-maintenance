/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package maintenance;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author akob
 */
public class NewJPanelTest {
    // here we declare a class level variable so that this variable can we accessed by all methods.
    static String [] customer_value;
    public NewJPanelTest() {
    }
    
    // BeforeClass are fired once as this test class are executed.
    @BeforeClass
    public static void setUpClass() {
        // below is how we obtain and store the value inside the variable
        // the value are coming from dialog box input entered by the user.
        customer_value = NewJPanel.enterCustomer();
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testName(){
        // we are using assert false so that it will fail if the supplied valued is true.
        // at first we tried using customer_value[0] == null but we found out that
        // it was not null but an empty string ""
        assertFalse("Name cannot be empty",customer_value[0].equals(""));
    }
    
    @Test
    public void testAddress(){
        // same as above
        assertFalse("Address cannot be empty",customer_value[1].equals(""));
    }
    
    @Test
    public void testPhoneEmpty(){
        // same as above
        assertFalse("Phone cannot be empty",customer_value[2].equals(""));
    }
    
    @Test
    public void testPhoneNotNumber(){
        // by trying to convert or parsing the string into integer and by catching it if it throws an error
        // we are able to know whether the string is a number or not.
        // By catching it, we know that conversion / parsing is fail and we just raise a fail on that.
        try{
            Integer.parseInt(customer_value[2]); 
        } catch(NumberFormatException e) { 
            fail("Phone number does not contain all number");
        }
    }
            
//    /**
//     * Test of addCar method, of class NewJPanel.
//     */
//    @Test
//    public void testAddCar() {
//        System.out.println("addCar");
//        String c = "";
//        NewJPanel.addCar(c);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delCar method, of class NewJPanel.
//     */
//    @Test
//    public void testDelCar() {
//        System.out.println("delCar");
//        int idx = 0;
//        NewJPanel.delCar(idx);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of addOwner method, of class NewJPanel.
//     */
//    @Test
//    public void testAddOwner() {
//        System.out.println("addOwner");
//        String o = "";
//        NewJPanel.addOwner(o);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of delOwner method, of class NewJPanel.
//     */
//    @Test
//    public void testDelOwner() {
//        System.out.println("delOwner");
//        int idx = 0;
//        NewJPanel.delOwner(idx);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
//
//    /**
//     * Test of testPanel method, of class NewJPanel.
//     */
//    @Test
//    public void testTestPanel() {
//        System.out.println("testPanel");
//        String[] expResult = null;
//        String[] result = NewJPanel.testPanel();
//        assertArrayEquals(expResult, result);
//        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
//    }
    
}
