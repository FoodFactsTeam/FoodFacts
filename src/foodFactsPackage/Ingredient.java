/*
 * This is the ingredient class. It holds the Ingredient name and the nutrition 
 * information. There is a Nutrition Information getter! to get all the nutrition 
 * info at once.
 */
package foodFactsPackage;

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
    double calorie;
    double fat;
    double carbs;
    double fiber;
    double protein;
    /**
     * Creates an Ingredient 
     * @param nm name of ingredient as a String
     * @param bs base Measurement used for nutritional information
     * @param cal calories per base measurement
     * @param ft fat per base measurement
     * @param crb carbohydrates per base Measurement
     * @param fbr fiber per base measurement
     * @param prtn protein per base measurement
     */
    public Ingredient(String nm, Measure bs, double cal, double ft, double crb, double fbr, double prtn)
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
    public double getCalorie()
    {
        return calorie;
    }
    /**
     * set the amount of calories per the base measurement 
     * @param cal as an double
     */
    public void setCalorie(int cal)
    {
        calorie = cal;
    }
    
    /**
     * get the fat content per base measurement
     * @return Measure
     */
    public double getFat()
    {
        return fat;
    }
    /**
     * set the fat content based on measure used
     * @param ft fat in grams per base measurement
     */
    public void setFat(double ft)
    {
        fat = ft;   
    }
    
    /**
     * get carb content per base measurement
     * @return carbs per base measurement
     */
    public double getCarbs()
    {
        return carbs;
    }
    /**
     * set the integer value of carbs per base measurement
     * @param crb carbs as integer
     */
    public void setCarbs(double crb)
    {
        carbs = crb;
    }
    
    /**
     * set the amount of fiber per base measurement
     * @param fbr 
     */
    public void setFiber(double fbr)
    {
        fiber = fbr;
    }
    /**
     * get the amount of fiber contained in base measurement
     * @return fiber in grams per Base measurement
     */
    public double getFiber()
    {
        return fiber;
    }
    
    /**
     * get the amount of protein per base measurement
     * @return integer value protein
     */
    public double getProtein()
    {
        return protein;
    }
    /**
     * This allows the protein information to be updated
     * @param prt grams per the base measurement used.
     */
    public void setProtein(double prt)
    {
        protein = prt;
    }
    
    public String IngToString()
    {
        return String.format("%s   %s",this.name,this.getBase().toString());
    }
}
