/*
 * This is the ingredient class. It holds the Ingredient name and the nutrition 
 * information. There is a Nutrition Information getter! to get all the nutrition 
 * info at once.
 */
package a09.team.assignment;

/**
 * The ingredient class
 * @author deliapathak
 */
public class Ingredient 
{
    String name;
    /**
     * this is the Measure used to calculate nutrition information
     */
    Measure base;
    int calorie;
    int fat;
    int carbs;
    int fiber;
    int protein;
    /**
     * Creates an Ingredient 
     * @param nm name as a String
     * @param bs base Measure
     * @param cal calories in int
     * @param ft fat as an int
     * @param crb carbohydrates as an int
     * @param fbr fiber as an int
     * @param prtn protein as an int 
     */
    Ingredient(String nm, Measure bs, int cal, int ft, int crb, int fbr, int prtn)
    {
        name = nm;
        base = bs;
        calorie = cal;
        fat = ft;
        carbs = crb;
        fiber = fbr;
        protein = prtn;
    }
  
    /**
     * get the name of the ingredient
     * @return String name
     */
    public String getName()
    {
        return name;
    }
    /**
     * set the name of the ingredient
     * @param nm String
     */
    public void setName (String nm)
    {
        name = nm;
    }
    
    /**
     * get the base Measurement used
     * @return Measure
     */
    public Measure getBase()
    {
        return base;
    }
    /**
     * sets the measure used to calculate nutrition information
     * @param bs 
     */
    public void setBase(Measure bs)
    {
        base = bs;
    }
    
    /**
     * get the calories per baseMeasurement in the ingredient
     * @return Measure
     */
    public int getCalorie()
    {
        return calorie;
    }
    /**
     * set the amount of calories per the base measurement 
     * @param cal as an int
     */
    public void setCalorie(int cal)
    {
        calorie = cal;
    }
    
    /**
     * get the fat content per base measurement
     * @return Measure
     */
    public int getFat()
    {
        return fat;
    }
    /**
     * set the fat content based on measure used
     * @param ft fat as an int
     */
    public void setFat(int ft)
    {
        fat = ft;   
    }
    
    /**
     * get carb content per base measurement
     * @return an int fat
     */
    public int getCarbs()
    {
        return carbs;
    }
    /**
     * set the integer value of carbs per base measurement
     * @param crb carbs as integer
     */
    public void setCarbs(int crb)
    {
        carbs = crb;
    }
    
    /**
     * set the amount of fiber per base measurement
     * @param fbr 
     */
    public void setFiber(int fbr)
    {
        fiber = fbr;
    }
    /**
     * get the amount of fiber contained in base measurement
     * @return int fiber
     */
    public int getFiber()
    {
        return fiber;
    }
    
    /**
     * get the amount of protein per base measurement
     * @return integer value protein
     */
    public int getProtein()
    {
        return protein;
    }
    public void setProtein(int prt)
    {
        protein = prt;
    }
    
}
