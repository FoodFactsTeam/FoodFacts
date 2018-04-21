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
        public static ArrayList <Ingredient> ingredientStore;
        public static ArrayList <Recipe> recLib;

        public static ArrayList<String> ingrtNames = new ArrayList<>(); 
        /**
         * String array of Ingredient names
         */
        public static String[] ingtNames = {"Please Add Ingredient"};
        
        public static void getIngrtNames ()
        {
           ingtNames = new String[ingredientStore.size()];
           for (int i=0; i<ingredientStore.size(); i++)
            {
                ingtNames[i] = ingredientStore.get(i).toString();
            }
           
        }
}
