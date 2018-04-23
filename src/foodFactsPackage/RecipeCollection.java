package foodFactsPackage;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.util.ArrayList;

/**
 * Created by julie.kohler on 4/23/2018.
 */
public class RecipeCollection {
    JFrame collectionFrame = new JFrame();
    JPanel mainPanel = new JPanel();
    JTextArea recipes = new JTextArea();
    ArrayList <String> recipeArray = new ArrayList<>();
    Border border = BorderFactory.createLineBorder(Color.LIGHT_GRAY);
    JPanel tempPanel = new JPanel();
    JScrollPane recipeScrollPane = new JScrollPane(tempPanel);

    public RecipeCollection() {
        initComponents();
    }

    public void initComponents() {
        BoxLayout boxLayout = new BoxLayout(tempPanel, BoxLayout.Y_AXIS);
        collectionFrame.setSize(1000, 900);
        collectionFrame.setBackground(new Color(210, 180, 140));
        recipeScrollPane.setPreferredSize(new Dimension(1000, 900));
        tempPanel.setLayout(boxLayout);
        for (int i = 2; i < Library.recLib.size() - 1; i++) {
            JLabel recipeLabel = new JLabel(Library.recLib.get(i).title);
            recipeLabel.setFont(new Font("Perpetua", Font.BOLD, 18));
            tempPanel.add(recipeLabel);
            if (Library.recLib.get(i).FullRecipe() != null) {
                JTextArea recipeArea = new JTextArea(Library.recLib.get(i).FullRecipe());
                recipeArea.setBackground(new Color(210, 180, 140));
                recipeArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                tempPanel.add(recipeArea);
            }
            if (Library.recLib.get(i).FullRecipe() != null) {
                JTextArea nutritionFactsArea = new JTextArea(Library.recLib.get(i).NutritionToString());
                nutritionFactsArea.setBackground(new Color(210, 180, 140));
                nutritionFactsArea.setFont(new Font("Times New Roman", Font.PLAIN, 18));
                tempPanel.add(nutritionFactsArea);
            }
            tempPanel.setBorder(BorderFactory.createCompoundBorder(border, BorderFactory.createEmptyBorder(15, 15, 15, 15)));
            collectionFrame.add(recipeScrollPane);
        }
        collectionFrame.pack();
        collectionFrame.setVisible(true);
        collectionFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
