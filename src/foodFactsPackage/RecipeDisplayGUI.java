package foodFactsPackage;

import javax.swing.*;

/**
* Created by julie.kohler on 4/16/2018.
*/
public class RecipeDisplayGUI extends JFrame {
    String recpTtl;
JFrame recipeFrame = new JFrame();
JPanel recipePanel = new JPanel();
JPanel nutritionFactsPanel = new JPanel();

Recipe displayedRecipe = new Recipe();
String ttl = RecipeFrame.
String recipe = displayedRecipe.FullRecipe();
String nutritionFacts = displayedRecipe.NutritionToString();

JTextArea recipeArea = new JTextArea(recipe);
JTextArea nutritionFactsArea = new JTextArea(nutritionFacts);

public void createFrame() {
recipeArea.setEditable(false);
nutritionFactsArea.setEditable(false);

recipeFrame.add(recipePanel);
recipeFrame.add(nutritionFactsPanel);
}

RecipeDisplayGUI(String rt) {
   recpTtl = rt; 
createFrame();
}

public static void main(String[] args) {
RecipeDisplayGUI RDG = new RecipeDisplayGUI();
RDG.setVisible(true);
RDG.setSize(1000, 600);
RDG.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
RDG.setResizable(true);
}
};