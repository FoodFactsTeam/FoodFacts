package foodFactsPackage;


import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Main 
{
        public static ArrayList <Ingredient> ingredientStore = new ArrayList<>();
        public static ArrayList <Recipe> recLib = new ArrayList<>();
        
    public static void main(String[] args) 
    {
        FoodFactsGUI openingFrame = new FoodFactsGUI();
        openingFrame.createOpeningFrame();
        openingFrame.createIngredientFrame();
        
    }
}
// I will need to update this class. I will create an array list for all the recipes.
// an array list for all the ingredients
// call all the frames 
//RECIPE INPUT CLASS
//

//RECIPE DISPLAY CLASS
//To string method for Recipe class should could display entire string