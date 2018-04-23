package foodFactsPackage;

import javax.swing.*;
import java.awt.*;

/**
* Created by julie.kohler on 4/16/2018.
*/
public class RecipeDisplayGUI extends JFrame {
    JFrame recipeFrame = new JFrame();
    JPanel recipePanel = new JPanel();
    JPanel nutritionFactsPanel = new JPanel();

    RecipeDisplayGUI(String recipeTitle) {
        setLayout(new FlowLayout());

        Recipe displayedRecipe = Library.getRecipeByName(recipeTitle);
        String recipe = displayedRecipe.FullRecipe();
        String nutritionFacts = displayedRecipe.NutritionToString();

        JTextArea recipeArea = new JTextArea(recipe);
        JTextArea nutritionFactsArea = new JTextArea(nutritionFacts);


        recipeArea.setEditable(false);
        nutritionFactsArea.setEditable(false);

        recipePanel.add(recipeArea);
        nutritionFactsPanel.add(nutritionFactsArea);

        recipePanel.setVisible(true);

        recipeFrame.add(recipePanel);
        recipeFrame.add(nutritionFactsPanel);
    }
};