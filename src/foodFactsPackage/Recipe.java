/*
 * This is the recipe class. It holds all the ingredients and the amounts needed
 * It also calculates and holds the nutritional content for the entire recipe.
 */
package foodFactsPackage;


import java.util.ArrayList;

/** *
 * @author deliapathak
 */
public class Recipe 
{
    String title;
    String[] fullElements;
    ArrayList <Ingredient> ingredients = new ArrayList<>();
    ArrayList <Double> quantities = new ArrayList<>();
    ArrayList <String> units = new ArrayList<>();
    ArrayList <String> instructions = new ArrayList<>();
    double totalFiber;
    double totalFat;
    double totalCarbs;
    double totalProtein;
    double totalCalories;
    double index;
    
    /**
     * get the title of the recipe
     * @return String Title of the recipe
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
     * @param ingr an Ingredient object with nutritional information
     * @param quant double relating to amount of ingredient called for
     * @param unt measurement unit used in the recipe
     */
    public void addIngredient(Ingredient ingr, double quant, String unt)
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
        for(int i = 0; i < ingredients.size()&& i<quantities.size()&& i<units.size(); i++)
        {
            double ratio=1;
            //use the unit called for in the recipe to get the correct ratio out of each baseMeasure
            if (units.get(i).equals("cup"))  
                ratio = ingredients.get(i).getBase().getCupRatio();
            if (units.get(i).equals("tablespoon"))
                ratio = ingredients.get(i).getBase().getTablespoonRatio();
            if (units.get(i).equals("teaspoon"))
                ratio = ingredients.get(i).getBase().getTeaspoonRatio();    
            //the amount of the unit used in the recipe
            ratio = ratio * quantities.get(i);
                // call all the get methods for each of the nutritional values 
                //& multiply the ratio and add to recipe's total count
            totalCalories += ingredients.get(i).getCalorie() *ratio;  
            totalFat += ingredients.get(i).getFat() *ratio;
            totalFiber += ingredients.get(i).getFiber() *ratio;
            totalCarbs += ingredients.get(i).getCarbs() *ratio;
            totalProtein += ingredients.get(i).getProtein() *ratio;
        }
    }
    /**
     * Returns a formatted string that contains the nutritional Information meant 
     * for the nutritional panel next to the recipe.
     * @return one formatted string
     */
    public String NutritionToString()
    {
           return String.format("Calories:  %.2f%nFat:  %.2f%nFiber:    %.2f%nCarbohydrates:    %.2f"
                   + "%nProtein %.2f",this.totalCalories,this.totalFat,this.totalFiber,this.totalCarbs,
                   this.totalProtein);      
    }
    
    /**
     * Returns a String array that lists all the Ingredients within a recipe
     * @return String array 
     */
    public String[] RecipeInfo()
    {   
        String fullElement;
        fullElements = new String[ingredients.size()+1];
        //print a header
        fullElements[0] = "     Ingredients  ";
        //circle through the arrayLists
        StringBuilder sb = new StringBuilder();
        for(int i=0; i <ingredients.size(); i++)
        {
        // print the ingredient with the quantity and the unit            
         fullElement = String.format("%.2f %s     %s",this.quantities.get(i),this.units.get(i),
                 this.ingredients.get(i).getName());
         fullElements[i+1] = fullElement;
        }
        return fullElements;
    }

    public String FullRecipe()
    {
        this.RecipeInfo();
        
        StringBuilder fullRec = new StringBuilder();
            for(String e: fullElements)
            {
                fullRec.append("%n");
                fullRec.append(e);                
            }
       
       return fullRec.toString();
    }
    
    
}
