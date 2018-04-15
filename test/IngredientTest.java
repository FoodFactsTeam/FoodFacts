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
public class IngredientTest {
    
    public IngredientTest() {
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
	public void testIngredient() {
		Ingredient first = new Ingredient("Apple",Measure.CUP,95,0.3,25,4.4,.5);
		assertEquals("Apple",first.getName());
  
	}
}
