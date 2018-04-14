/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodFactsPackage;

import java.util.ArrayList;

/**
 *
 * @author deliapathak
 */
public class Recipe 
{
    String title;
    ArrayList <Ingredient> ingredients = new ArrayList<>();
    ArrayList <Integer> quantities = new ArrayList<>();
    ArrayList <String> units = new ArrayList<>();
    ArrayList <String> instructions = new ArrayList<>();
    int totalFiber;
    int totalFat;
    int totalCarbs;
    int totalProtein;
    int totalCalories;
    int index;
    
    /**
     * get the title of the recipe
     * @return String
     */
    public String getTitle()
    {
        return title;
    }
    /**
     * set the title of the recipe
     * @param ttl 
     */
    public void setTitle(String ttl)
    {
        title = ttl;
    }
    
    /**
     * This will add an element of the recipe(the ingredient, quantity and measurement)
     * @param ingr type Ingredient
     * @param quant type integer
     * @param unt type string (cup, tablespoon, teaspoon)
     */
    public void addIngredient(Ingredient ingr, Integer quant, String unt)
    {
        ingredients.add(ingr);
        quantities.add(quant);
        units.add(unt);        
    }
    /**
     * removes the items using the same index from each ArrayList
     * @param indx I'm thinking the index should be the number next to each line item in the recipe.
     */
    public void removeIngredient(int indx)
    {
        ingredients.remove(indx);
        quantities.remove(indx);
        units.remove(indx);
    }
    
    public void calcNutrition()
    {
        //Iterate through the Recipe's Ingredient List 
        for(int i = 0; i < ingredients.size()-1&& i<quantities.size()-1&& i<units.size(); i++)
        {
            //calculate and store the ratio for each ingredient
            //the unit the recipe calls for
            units.get(i).g
                //(the measure from the enum, 
            ingredients.get(i).getBase();
            //what unit the recipe calls for and the amount of the unt)
                // call all the get methods for each of the nutritional values & multiply the ration add to recipe's cal
        }   
    }
            
}
