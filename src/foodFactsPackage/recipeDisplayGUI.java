package foodFactsPackage;

import javax.swing.*;
import java.awt.*;

/**
* Created by julie.kohler on 4/16/2018.
*/
public class RecipeDisplayGUI extends JFrame {
    JFrame recipeFrame;
    JPanel recipePanel;
    JPanel nutritionFactsPanel;
    JTextArea recipeArea;
    JTextArea nutritionFactsArea;

    public void initComponents(String recipeTitle) {
        recipeFrame = new JFrame();

        recipePanel = new JPanel();
        recipePanel.setLayout(new FlowLayout());

        nutritionFactsPanel = new JPanel();
        nutritionFactsPanel.setLayout(new FlowLayout());

        Recipe displayedRecipe = Library.getRecipeByName(recipeTitle);
        String recipe = displayedRecipe.FullRecipe();
        System.out.println("RECIPE " + recipe);
        String nutritionFacts = displayedRecipe.NutritionToString();

        recipeArea = new JTextArea(recipe);
        nutritionFactsArea = new JTextArea(nutritionFacts);

        recipeArea.setEditable(false);
        nutritionFactsArea.setEditable(false);

        recipePanel.add(recipeArea);

        nutritionFactsPanel.add(nutritionFactsArea);

        nutritionFactsPanel.setBackground(new Color(210,180,140));
        recipeFrame.add(recipePanel);
        recipeFrame.add(nutritionFactsPanel);

        recipeFrame.setVisible(true);
    }

    RecipeDisplayGUI(String recipeTitle) {
        initComponents(recipeTitle);
    }
};