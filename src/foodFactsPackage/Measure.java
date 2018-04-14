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
    CUP(1, 1/16, 1/48), TABLESPOON(1/16, 1, 1/3), TEASPOON(48, 3, 1), 
    //these don't need an additional ratio as they will just be multiplied by the recipe ratio.
    LB(1), UNIT(1);

    int cup;
    int tablespoon;
    int teaspoon;
    int unit;

    Measure(int unt)
    {
        unit = unt;
    }
    

    Measure (int cp, int tblsp, int tspn)
    {
        cup = cp;
        tablespoon = tblsp;
        teaspoon =tspn;     
    }
    /**
     * returns the ratio necessary to convert to cup
     * @return integer value of cups
     */
    public int getCupRatio()
    {
        return cup;
    }
    
     /**
     * returns the ratio to convert to tablespoon
     * @return integer value of cups
     */
    public int getTablespoonRatio()
    {
        return tablespoon;
    }    

     /**
     * returns the ratio to convert to teaspoons
     * @return integer value of cups
     */
    public int getTeaspoonRatio()
    {
        return teaspoon;
    }    

}
