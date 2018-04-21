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
        public static ArrayList <Ingredient> ingredientStore = new ArrayList<>();
        public static ArrayList <Recipe> recLib = new ArrayList<>();
        
        public static ArrayList<String> ingrtNames; 
        public static String[] ingtNames = {"Please Add Ingredient"};
        
        public static void getIngrtNames ()
        {
            for (int i=0; i<ingredientStore.size(); i++)
            {
                ingrtNames.add(ingredientStore.get(i).IngToString());
                ingtNames[i] = ingredientStore.get(i).IngToString();
            }
           
        }
}
