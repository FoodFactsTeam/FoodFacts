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
			File dir = new File(".");
			File[] files = dir.listFiles();
			boolean ingExists = false;
			boolean recExists = false;
			for (File f : files){
				if (f.getName() == "IngredientStore.ser") ingExists = true;
				else if (f.getName() == "RecipeStore.ser") recExists = true;
			}
			if (ingExists){
				ArrayList<Object> tempList1 = FileHandler.readObjectFromFile("IngredientStore.ser");
				for (Object o : tempList1) Library.ingredientStore.add((Ingredient)o);
			}
			if (recExists){
				ArrayList<Object> tempList2 = FileHandler.readObjectFromFile("RecipeStore.ser");
				for (Object o : tempList2) Library.recLib.add((Recipe)o);
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