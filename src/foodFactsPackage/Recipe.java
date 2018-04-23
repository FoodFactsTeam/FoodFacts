/*
 * This is the recipe class. It holds all the ingredients and the amounts needed
 * It also calculates and holds the nutritional content for the entire recipe.
 */
package foodFactsPackage;


import java.io.Serializable;
import java.util.ArrayList;

/** *
 * @author deliapathak
 */
public class Recipe implements Serializable
{
    /**
	 * 
	 */
	private static final long serialVersionUID = 1;
	String title;
    String[] fullElements;
    ArrayList <Ingredient> ingredients = new ArrayList<>();
    ArrayList <Double> quantities = new ArrayList<>();
    ArrayList <String> units = new ArrayList<>();
    ArrayList <String> instructions = new ArrayList<>();
    double totalFiber,servings;
    double totalFat;
    double totalCarbs;
    double totalProtein;
    double totalCalories;
    double index;
    
    public Recipe()
    {
        
    }
    
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
    /**
     * this will return the number of servings per recipe
     * @return double
     */
    public double getServings()
    {
        return servings;
    }
    
    public void setServings(double srv)
    {
        servings = srv;
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
        totalCalories = totalCalories/servings;
        totalFat = totalFat/servings;
        totalFiber = totalFiber/servings;
        totalCarbs = totalCarbs/servings;
        totalProtein = totalProtein/servings;
    }
    /**
     * Returns a formatted string that contains the nutritional Information meant 
     * for the nutritional panel next to the recipe.
     * @return one formatted string
     */
    public String NutritionToString()
    {
           return String.format("Nutrition Information based on %f servings%nCalories:  %.2f%nFat:  "
                   + "%.2f%nFiber:    %.2f%nCarbohydrates:    %.2f"
                   + "%nProtein %.2f",this.servings,this.totalCalories,this.totalFat,this.totalFiber,this.totalCarbs,
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
        //StringBuilder sb = new StringBuilder();
        int i;
        for( i=1; i <ingredients.size(); i++)
        {
        // print the ingredient with the quantity and the unit            
         fullElement = String.format("%.2f %s     %s",this.quantities.get(i),this.units.get(i),
                 this.ingredients.get(i).getName());
         fullElements[i] = fullElement;
        }
        fullElement = " Instructions    ";
        fullElements[i] = fullElement;
        i++;
        for (i = i; i< (ingredients.size()+instructions.size()-1); i++)
        {
            for (int j = 0; j<instructions.size(); j++)
            {
                fullElements[i] = instructions.get(j);
            }
        }
        
        return fullElements;
    }
    
    
    // here is that method. I'm not sure where I pushed.
    public String FullRecipe()
    {
        StringBuilder sb = new StringBuilder();
        sb.append(this.title);
        sb.append("\n");
        sb.append("Ingredients").append("\n");
      for(int i = 0; i<this.ingredients.size(); i++)
            {   
                sb.append(quantities.get(i).toString()).append(" ");
            if(units.get(i).equalsIgnoreCase("Unit")||units.get(i).equalsIgnoreCase("Lb"))
                sb.append(units.get(i)).append("  ");
                sb.append(ingredients.get(i).getName());
                sb.append("\n");
            }
      
      sb.append("Instructions").append("\n");
      for (String e: this.instructions)
      {
          sb.append(e).append("\n");
      }
      String recp = (sb.toString());
      return recp;
    }
    
    
}
