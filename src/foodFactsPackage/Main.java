package foodFactsPackage;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Main 
{
        // static ArrayList <Ingredient> ingredientStore = new ArrayList<>();
        //public static ArrayList <Recipe> recLib = new ArrayList<>();
        
    public static void main(String[] args) 
    {
        initializeLibraryFromFile();
        FoodFactsGUI openingFrame = new FoodFactsGUI();
        
        //openingFrame.createOpeningFrame();
        //openingFrame.createIngredientFrame();
        
    }

		private static void initializeLibraryFromFile() {
			try{
				ArrayList<Object> tempList1 = FileHandler.readObjectFromFile("IngredientStore.ser");
				for (Object o : tempList1) Library.ingredientStore.add((Ingredient)o);
				System.out.println("Number of items in IngredientStore: " + Library.ingredientStore.size());
			}
			catch (Exception e){
				
			}
			try{
				ArrayList<Object> tempList2 = FileHandler.readObjectFromFile("RecipeStore.ser");
				for (Object o : tempList2) Library.recLib.add((Recipe)o);
			}
			catch (Exception e){
				
			}
		}
}
// I will need to update this class. I will create an array list for all the recipes.
// an array list for all the ingredients
// call all the frames 
//RECIPE INPUT CLASS
//

//RECIPE DISPLAY CLASS
//To string method for Recipe class should could display entire string