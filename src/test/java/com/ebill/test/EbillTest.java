package com.ebill.test;


//import static org.junit.Assert.assertEquals;
import org.junit.Test;

import com.ebill.service.EbillService;

import static org.junit.Assert.assertEquals;
//import static org.junit.jupiter.api.Assertions.assertEquals;


public class EbillTest {
    //Write JUNIT Test Code
    
    EbillService bill = null;
    
    @Test
    public void testCalculateBillAmount_Input_0() {
        System.out.println("Custom");
        bill = new EbillService(0);
        
        assertEquals(0, bill.calculateBillAmount(), 0.001);
    }
    
    @Test
    public void testCalculateBillAmount_Input_50() {
        bill = new EbillService(50);
        assertEquals(130, bill.calculateBillAmount(), 0.001);
    }
    
    @Test
    public void testCalculateBillAmount_Input_100() {
        bill = new EbillService(100);
        assertEquals(292.5, bill.calculateBillAmount(), 0.001);
    }
    
    @Test
    public void testCalculateBillAmount_Input_200() {
        bill = new EbillService(200);
        assertEquals(818.5, bill.calculateBillAmount(), 0.001);
    }
    
    @Test
    public void testCalculateBillAmount_Input_1000() {
        bill = new EbillService(1000);
        assertEquals(7018.5, bill.calculateBillAmount(), 0.001);
    }
    
    @Test
    public void testCalculateBillAmount_Input_5000() {
        bill = new EbillService(5000);
        assertEquals(47018.5, bill.calculateBillAmount(), 0.001);
    }
 
}