package foodFactsPackage;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import static javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE;

/**
* Created by julie.kohler on 4/16/2018.
*/
public class RecipeDisplayGUI {
    JFrame recipeFrame;
    JPanel mainPanel;
    JTextArea recipeArea;
    JTextArea nutritionFactsArea;
    JButton backBtn;
    JButton exportBtn;
    JLabel recipeLabel;
    JLabel nutritionFactsLabel;

    public void initComponents(String recipeTitle) {
        recipeFrame = new JFrame();
        recipeFrame.setBackground(new Color(210,180,140));

        mainPanel = new JPanel();
        BoxLayout boxLayout = new BoxLayout(mainPanel, BoxLayout.Y_AXIS);
        mainPanel.setLayout(boxLayout);
        mainPanel.setBorder(new EmptyBorder(new Insets(50, 50, 100, 100)));


        Recipe displayedRecipe = Library.getRecipeByName(recipeTitle);
        String recipe = displayedRecipe.FullRecipe();
        String nutritionFacts = displayedRecipe.NutritionToString();

        ImageIcon backIcon = new ImageIcon("backIcon.png", "Go to home page");
        backBtn = new JButton(backIcon);
        backBtn.setOpaque(true);
        backBtn.setPreferredSize(new Dimension(40, 40));
        backBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                recipeFrame.setVisible(false);
            }
        });

        exportBtn = new JButton("Export Recipe");
        exportBtn.setOpaque(true);
        exportBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                FileHandler.writeStringToFile(recipeTitle, recipe + "\n\n" + nutritionFacts);
            }
        });

        recipeArea = new JTextArea(recipe);
        nutritionFactsArea = new JTextArea(nutritionFacts);

        nutritionFactsLabel = new JLabel("Nutrition Facts");
        recipeLabel = new JLabel("Recipe");

        recipeLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 10, 0));
        nutritionFactsLabel.setBorder(BorderFactory.createEmptyBorder(50, 0, 10, 0));
        nutritionFactsArea.setBorder(BorderFactory.createEmptyBorder(0, 0, 50, 0));

        mainPanel.setOpaque(true);

        mainPanel.setBackground(new Color(210,180,140));
        nutritionFactsArea.setBackground(new Color(210,180,140));
        recipeArea.setBackground(new Color(210,180,140));

        nutritionFactsArea.setFont(new Font("Times New Roman",Font.PLAIN,24));
        recipeArea.setFont(new Font("Times New Roman",Font.PLAIN,24));
        nutritionFactsLabel.setFont(new Font("Perpetua",Font.BOLD,36));
        recipeLabel.setFont(new Font("Perpetua",Font.BOLD,36));

        recipeArea.setEditable(false);
        nutritionFactsArea.setEditable(false);

        backBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        exportBtn.setAlignmentX(Component.LEFT_ALIGNMENT);
        recipeLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        recipeArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        nutritionFactsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        nutritionFactsArea.setAlignmentX(Component.LEFT_ALIGNMENT);
        mainPanel.setAlignmentX(Component.LEFT_ALIGNMENT);

        mainPanel.add(backBtn);
        mainPanel.add(recipeLabel);
        mainPanel.add(recipeArea);
        mainPanel.add(nutritionFactsLabel);
        mainPanel.add(nutritionFactsArea);
        mainPanel.add(exportBtn);

        recipeFrame.add(mainPanel);

        recipeFrame.setVisible(true);
        recipeFrame.setSize(1000, 900);
        recipeFrame.setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        recipeFrame.setResizable(true);
        recipeFrame.pack();
    }

    RecipeDisplayGUI(String recipeTitle) {
        initComponents(recipeTitle);
    }
};