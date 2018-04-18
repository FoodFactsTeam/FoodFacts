package foodFactsPackage;


import javax.swing.*;
import java.awt.*;

public class Main2 {

    public static void main(String[] args) 
    {	/*Measure first = Measure.CUP;
                System.out.println(first.getCupRatio());
		System.out.println(first.getTablespoonRatio());
                System.out.println(first.getTeaspoonRatio());
                
                        		Measure second = Measure.TABLESPOON;
                System.out.println(second.getCupRatio());
		System.out.println(second.getTablespoonRatio());
                System.out.println(second.getTeaspoonRatio());
                
                        		Measure third = Measure.TEASPOON;
                System.out.println(third.getCupRatio());
		System.out.println(third.getTablespoonRatio());
                System.out.println(third.getTeaspoonRatio());
                
               Ingredient firstIn = new Ingredient("Apple",Measure.CUP,95,0.3,25,4.4,.5);
		System.out.println("name " +firstIn.getName());
                System.out.println("calorie of apple "+firstIn.getCalorie());
                System.out.println("fat in apple " +firstIn.getFat());
                System.out.println("carbs in apple "+firstIn.getCarbs());
                System.out.println("protein in apple " +firstIn.getProtein());
                System.out.println("fiber in apple "+firstIn.getFiber());
                System.out.println();
                Ingredient secondIn = new Ingredient("Sugar ", Measure.CUP,773,200,0, 0,0);
                System.out.println("name " +secondIn.getName());
                System.out.println("calorie of sugar "+secondIn.getCalorie());
                System.out.println("fat in sugar " +secondIn.getFat());
                System.out.println("carbs in sugar "+secondIn.getCarbs());
                System.out.println("protein in sugar " +secondIn.getProtein());
                System.out.println("fiber in sugar "+secondIn.getFiber());
                System.out.println();
                Recipe applePie = new Recipe();
                applePie.addIngredient(firstIn, 3, "unit");
                applePie.addIngredient(secondIn, 3, "cup");
                
                applePie.calcNutrition();
                System.out.println("Total Fat " + applePie.totalFat);
                System.out.println("Total Calories "+ applePie.totalCalories);
                System.out.println("Total Carbs " + applePie.totalCarbs);
                System.out.println("Total Fiber  "+applePie.totalFiber);
                System.out.println("Total Protein " + applePie.totalProtein);
                for(int i =0; i<applePie.ingredients.size(); i++)
                {
                    System.out.println(applePie.ingredients.get(i).getName());
                }
                
                System.out.println(applePie.units.get(1));
                
                applePie.removeIngredient(2*/
        		Measure first = Measure.CUP;
                System.out.println(first.getCupRatio());
		System.out.println(first.getTablespoonRatio());
                System.out.println(first.getTeaspoonRatio());
                
                        		Measure second = Measure.TABLESPOON;
                System.out.println(second.getCupRatio());
		System.out.println(second.getTablespoonRatio());
                System.out.println(second.getTeaspoonRatio());
                
                        		Measure third = Measure.TEASPOON;
                System.out.println(third.getCupRatio());
		System.out.println(third.getTablespoonRatio());
                System.out.println(third.getTeaspoonRatio());
                
               Ingredient firstIn = new Ingredient("Apple",Measure.CUP,95,0.3,25,4.4,.5);
		System.out.println("name " +firstIn.getName());
                System.out.println("calorie of apple "+firstIn.getCalorie());
                System.out.println("fat in apple " +firstIn.getFat());
                System.out.println("carbs in apple "+firstIn.getCarbs());
                System.out.println("protein in apple " +firstIn.getProtein());
                System.out.println("fiber in apple "+firstIn.getFiber());
                System.out.println();
                Ingredient secondIn = new Ingredient("Sugar ", Measure.CUP,773,200,0, 0,0);
                System.out.println("name " +secondIn.getName());
                System.out.println("calorie of sugar "+secondIn.getCalorie());
                System.out.println("fat in sugar " +secondIn.getFat());
                System.out.println("carbs in sugar "+secondIn.getCarbs());
                System.out.println("protein in sugar " +secondIn.getProtein());
                System.out.println("fiber in sugar "+secondIn.getFiber());
                System.out.println();
                Recipe applePie = new Recipe();
                applePie.addIngredient(firstIn, 3, "unit");
                applePie.addIngredient(secondIn, 3, "cup");
                
                applePie.calcNutrition();
                System.out.println("Total Fat " + applePie.totalFat);
                System.out.println("Total Calories "+ applePie.totalCalories);
                System.out.println("Total Carbs " + applePie.totalCarbs);
                System.out.println("Total Fiber  "+applePie.totalFiber);
                System.out.println("Total Protein " + applePie.totalProtein);
                for(int i =0; i<applePie.ingredients.size(); i++)
                {
                    System.out.println(applePie.ingredients.get(i).getName());
                }
                
                System.out.println(applePie.units.get(1));
                
                applePie.removeIngredient(1);
                System.out.print(applePie.NutritionToString());
    }
}
//RECIPE INPUT CLASS
//

//RECIPE DISPLAY CLASS
//To string method for Recipe class should could display entire string