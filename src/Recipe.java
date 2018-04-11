/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package a09.team.assignment;

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
     * @param indx 
     */
    public void removeIngredient(int indx)
    {
        ingredients.remove(indx);
        quantities.remove(indx);
        units.remove(indx);
    }
    
    public void calcNutrition()
    {
        //Iterate through the Ingredient List 
    }
            
}
