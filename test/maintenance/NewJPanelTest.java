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
import java.util.List;
import java.util.ArrayList;

/**
 *
 * @author akob
 */
public class NewJPanelTest {
    // here we declare a class level variable so that this variable can we accessed by all methods.
    static String [] customer_value;
    static Object [] car_detail;
    public NewJPanelTest() {
    }
    
    // BeforeClass are fired once as this test class are executed.
    @BeforeClass
    public static void setUpClass() {        
    }
    
    
    @AfterClass
    public static void tearDownClass() {
    }

    @Test
    public void testEmptyName(){
        // we are using assert true so that it will fail if the expected error message is not found.
        Owner c = new Owner( "", "no 26", "0122222222");
        List<String> owner_error_messages = c.validates();
        String expected_error_message = "Name must not be empty. [name]";
        assertTrue("Validation for empty name checking failed", owner_error_messages.contains(expected_error_message));
    }
    
    @Test
    public void testEmptyAddress(){
        // same as above
        Owner c = new Owner( "Ahmad", "", "0122222222");
        List<String> owner_error_messages = c.validates();
        String expected_error_message = "Address must not be empty. [address]";
        assertTrue("Validation for empty address checking failed", owner_error_messages.contains(expected_error_message));
    }
    
    @Test
    public void testEmptyPhone(){
        // same as above
        Owner c = new Owner( "Ahmad", "no 26", "");
        List<String> owner_error_messages = c.validates();
        String expected_error_message = "Phone must not be empty. [phone]";
        assertTrue("Validation for empty phone checking failed", owner_error_messages.contains(expected_error_message));
    }
    
    @Test
    public void testPhoneNotInteger(){
        // same as above
        Owner c = new Owner( "Ahmad", "no 26", "asdf");
        List<String> owner_error_messages = c.validates();
        String expected_error_message = "Phone number must be all Integer. [phone]";
        assertTrue("Validation for integer phone checking failed", owner_error_messages.contains(expected_error_message));
    }
//    
//    @Test
//    public void testCarDetailModel(){
//        assertFalse("Car model cannot be empty",car_detail[0].equals(""));
//    }
//    
//    @Test
//    public void testCarDetailYear(){
//        // test whether app allow user to enter only integer or not for car year input.
//        // test will fail if app allow non integer input.
//        try{
//            Integer.parseInt( car_detail[1].toString() ); 
//        } catch(NumberFormatException e) { 
//            fail("Car year does not contain all number");
//        }
//    }
//    
//    @Test
//    public void testCarDetailRegNo(){
//        assertFalse("Car registration no cannot be empty",car_detail[2].equals(""));        
//    }
//    
//    @Test
//    public void testCarDetailColor(){
//        assertFalse("Car color cannot be empty",car_detail[3].equals(""));
//    }
//    
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
