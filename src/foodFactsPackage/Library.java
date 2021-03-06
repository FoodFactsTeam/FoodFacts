/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package foodFactsPackage;

import java.util.ArrayList;

/**
 *Library Class. We need a way to access just the names of the ingredients so we 
 * can display them in combo boxes.
 * @author deliapathak
 */
public class Library 
{
        /**
         * an array list of Ingredients
         */
        public static ArrayList <Ingredient> ingredientStore = new ArrayList<>();
        public static ArrayList <Recipe> recLib = new ArrayList<>();

        public static ArrayList<String> ingrtNames ; 
        /**
         * String array of Ingredient names
         */
        public static String[] ingtNames = {"Please Add Ingredient"};
        
        public static void getIngrtNames ()
        {
           ingtNames = new String[ingredientStore.size()+1];
           ingtNames[0] = "Please Add Ingredient";
           for (int i=0; i<ingredientStore.size(); i++)
            {
                ingtNames[i+1] = ingredientStore.get(i).toString();
            }
           
        }

        public static Recipe getRecipeByName(String title) {
            for (int i = 0; i < recLib.size(); i++) {
                if (recLib.get(i).title.equals(title)) {
                    return Library.recLib.get(i);
                }
            }
            return null;
        }

}
