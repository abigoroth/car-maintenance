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

    }
