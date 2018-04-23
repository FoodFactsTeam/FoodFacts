package foodFactsPackage;


import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;

public class Main 
{
    public static void main(String[] args)
    {
        initializeLibraryFromFile();
        FoodFactsGUI openingFrame = new FoodFactsGUI();
    }

		private static void initializeLibraryFromFile() {
			try{
				ArrayList<Object> tempList1 = FileHandler.readObjectFromFile("IngredientStore.ser");
				for (Object o : tempList1) Library.ingredientStore.add((Ingredient)o);
				System.out.println("Number of items in IngredientStore: " + Library.ingredientStore.size());
			}
			catch (Exception e){
				System.out.println("Exception: " + e);
			}
			try{
				ArrayList<Object> tempList2 = FileHandler.readObjectFromFile("RecipeStore.ser");
				for (Object o : tempList2) Library.recLib.add((Recipe)o);
			}
			catch (Exception e){
				System.out.println("Exception: " + e);
			}
		}
}
