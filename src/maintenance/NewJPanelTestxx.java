/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintenance;
import org.junit.*; 
import static org.junit.Assert.*;  
 
/**
 *
 * @author troubleshoot
 */
public class NewJPanelTestxx {
    public static void main(String[] args){
        //testMultiply();
        //System.out.println("nape x keluar pape?");
        //assertNotNull("mende ni x leh null",NewJPanel.testPanel());
        //String var[] = NewJPanel.testPanel();
       //System.out.println( var[0].equals("") );
        //assertNotSame(5 , 6);
        //noNullElements(NewJPanel.testPanel());
        //assertNotSame(NewJPanel.testPanel()[0],"");
        //assertNotNull(NewJPanel.testPanel()[0]);
        assertFalse("message",NewJPanel.testPanel()[0].equals(""));
    }
     public static void testMultiply() { 
         //System.out.println("Inside testMultiply");
       assertEquals("message ni keluar x?",4, Arithmetic.multiply(2, 2)); 
       assertEquals("x keluar pon",-15, Arithmetic.multiply(3, -5)); 
    } 

    
    public void testIsPositive() { 
       assertTrue(Arithmetic.isPositive(5)); 
       assertFalse(Arithmetic.isPositive(-5)); 
       assertFalse(Arithmetic.isPositive(0)); 
    }

}
class Arithmetic{
     public static int multiply(int a,int b){
         return a*b;
     }
     public static boolean isPositive(int a){
         if (a > 0){
             return true;
         }
         return false;
     }
}


 
 
 
 
 
 
 
 
 
 
 
   
   