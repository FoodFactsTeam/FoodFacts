/*
 * A09 Team Assignment FoodFacts!!!
 * This is the Measure Enum
 */
package foodFactsPackage;

/**
 * These enums represent a measurement and contain the ratios needed to 
 * convert to the other measurements
 * @author deliapathak
 */
public enum Measure 
{
    //the values contained represent the ratio to convert to the other measurement
    CUP(1, 16, 48), TABLESPOON(.0625, 1, 3), TEASPOON(.0208, .3333, 1), 
    //these don't need an additional ratio as they will just be multiplied by the recipe ratio.
    LB(1), UNIT(1);

    double cup;
    double tablespoon;
    double teaspoon;
    double unit;

    Measure(double unt)
    {
        unit = unt;
    }
    

    Measure (double cp, double tblsp, double tspn)
    {
        cup = cp;
        tablespoon = tblsp;
        teaspoon =tspn;     
    }
    /**
     * returns the ratio necessary to convert to cup
     * @return integer value of cups
     */
    public double getCupRatio()
    {
        return cup;
    }
    
     /**
     * returns the ratio to convert to tablespoon
     * @return integer value of cups
     */
    public double getTablespoonRatio()
    {
        return tablespoon;
    }    

     /**
     * returns the ratio to convert to teaspoons
     * @return integer value of cups
     */
    public double getTeaspoonRatio()
    {
        return teaspoon;
    }    

}
