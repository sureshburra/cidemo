package main.java;

import junit.framework.TestCase;

import org.junit.Test;

public class TestRPNCal extends TestCase{

    
    @Test
    public void testAdd(){
        Operations ops = new Operations();
        String cal = "2 3 +";
        double result = ops.calculate(cal);
        
        assertEquals(5.0, result);
    }
    
    @Test
    public void testSubtract(){
        Operations ops = new Operations();
        String cal = "3 2 -";
        double result = ops.calculate(cal);
        
        assertEquals(1.0, result);
    }
    
    @Test
    public void testMultiply(){
        Operations ops = new Operations();
        String cal = "3 2 *";
        double result = ops.calculate(cal);
        
        assertEquals(6.0, result);
    }
    
    @Test
    public void testDivide(){
        Operations ops = new Operations();
        String cal = "3 2 /";
        double result = ops.calculate(cal);
        
        assertEquals(1.5, result);
    }
    

    /*@Test
    public void testComplex(){
        Operations ops = new Operations();
        String cal = "3 2 + 4 3 - ^";
        double result = ops.calculate(cal);
        
        assertEquals(125.0, result);
    }*/
    
    
    @Test
    public void testComplex1(){
        Operations ops = new Operations();
        String cal = "3 2 1 + 2 - /";
        double result = ops.calculate(cal);
        
        assertEquals(3.0, result);
    }
    
    @Test(expected = Exception.class)
    public void testFail(){
        Operations ops = new Operations();
        String cal = "";
        double result = ops.calculate(cal);
    }
    
    @Test
    public void testperc(){
        Operations ops = new Operations();
        String cal = "5%";
        double result = ops.calculate(cal);
        
        assertEquals(0.05, result);
    }
    
    @Test
    public void testfact(){
        Operations ops = new Operations();
        String cal = "5!";
        double result = ops.calculate(cal);
        
        assertEquals(120.0, result);
    }
    
}
