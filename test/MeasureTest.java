/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import foodFactsPackage.Ingredient;
import foodFactsPackage.Measure;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author deliapathak
 */
public class MeasureTest {
    
    public MeasureTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    		
		      	@Test
	public void testMeasure() 
        {
		Measure first = Measure.CUP;
                assertEquals((1), first.getCupRatio());
		assertEquals(16, first.getTablespoonRatio());
                assertEquals("48",System.out.printf("%.2f",first.getTeaspoonRatio()));
                
                Measure second = Measure.TABLESPOON;
                assertEquals(".0625",System.out.printf("%.2f",second.getCupRatio()));
		assertEquals("1", System.out.printf("%.2f", second.getTablespoonRatio()));
                assertEquals("3",System.out.printf("%.2f",second.getTeaspoonRatio()));
                
                Measure third = Measure.TEASPOON;
                assertEquals(".0208",System.out.printf("%.2f",third.getCupRatio()));
		assertEquals(".3333", System.out.printf("%.2f", third.getTablespoonRatio()));
                assertEquals("1",System.out.printf("%.2f",third.getTeaspoonRatio()));
	}
}
