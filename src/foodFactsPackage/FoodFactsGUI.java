package foodFactsPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

public class FoodFactsGUI {
	//member variables for opening frame
	JFrame openingFrame;
	JPanel openingPanel;
	JLabel title;
	Font titleFont;
	JLabel subTitle;
	Font subTitleFont;
	JButton addRecipe;
	JButton openRecipeBook;

	//member variables for Ingredients Frame
	JFrame ingredientFrame;
	JPanel ingredientPanel;
	
	FoodFactsGUI(){
		createOpeningFrame();
		createIngredientFrame();
	}
	
	public void createIngredientFrame(){
		int[] frameSize = {1400,900};
		ingredientFrame = new JFrame();

		ingredientFrame.setSize(frameSize[0], frameSize[1]);
		ingredientPanel = new JPanel();
		ingredientPanel.setLayout(new BorderLayout());
		ingredientFrame.add(ingredientPanel);

		ingredientFrame.setVisible(false);
		ingredientFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public void createOpeningFrame(){
		int[] frameSize = {1000,600};
		int[] titleLabelSize = {750,100};
		int[] subTitleLabelSize = {600,70};
		int[] btnLabelSize = {300,150};
		
		openingFrame = new JFrame();
		openingPanel = new JPanel();
		openingPanel.setLayout(null);
		openingPanel.setOpaque(true);
		openingPanel.setBackground(new Color(210,180,140));
		
		title = new JLabel("Food Facts");
		titleFont = new Font("San Serif",Font.BOLD,128);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(titleFont);
		title.setBounds((frameSize[0]-titleLabelSize[0])/2, (frameSize[1]-titleLabelSize[1])/2 - 100, titleLabelSize[0], titleLabelSize[1]);
		
		subTitle = new JLabel("Nutritional Information and Recipe Collection");
		subTitleFont = new Font("Times New Roman", Font.ITALIC, 32);
		subTitle.setHorizontalAlignment(JLabel.CENTER);
		subTitle.setHorizontalAlignment(JLabel.CENTER);
		subTitle.setFont(subTitleFont);
		subTitle.setBounds((frameSize[0]-subTitleLabelSize[0])/2, (frameSize[1]-subTitleLabelSize[1])/2, subTitleLabelSize[0], subTitleLabelSize[1]);
		
		addRecipe = new JButton("ADD RECIPE");
		addRecipe.setFont(new Font("Perpetua", Font.BOLD, 20));
		addRecipe.setHorizontalAlignment(JLabel.CENTER);
		addRecipe.setVerticalAlignment(JLabel.CENTER);
		int arX = (frameSize[0]-2*btnLabelSize[0])*1/4;
		addRecipe.setBounds(150, 350, btnLabelSize[0], btnLabelSize[1]);
		addRecipe.setActionCommand("add");
		addRecipe.addActionListener(new ButtonClickListener());
		
		openRecipeBook = new JButton("OPEN RECIPE COLLECTION");
		openRecipeBook.setFont(new Font("Perpetua", Font.BOLD, 20));
		openRecipeBook.setHorizontalAlignment(JLabel.CENTER);
		openRecipeBook.setVerticalAlignment(JLabel.CENTER);
		openRecipeBook.setBounds(550, 350, btnLabelSize[0], btnLabelSize[1]);
		openRecipeBook.setActionCommand("open");
		openRecipeBook.addActionListener(new ButtonClickListener());


		openingPanel.add(title);
		openingPanel.add(subTitle);
		openingPanel.add(addRecipe);
		openingPanel.add(openRecipeBook);
		openingFrame.add(openingPanel);
		
		
		openingFrame.setSize(frameSize[0], frameSize[1]);
		openingFrame.setVisible(true);
                    //instead of default exit on close, set serialize ingredients and recipes when closing
		openingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

        //I'm not sure what this for. I couldn't find it anywhere, but I used the
        // same name in MAIN and in the ingredient Frame.
	//List<Ingredient> ingredientStore = new ArrayList<>();

	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("add")) {
				openingFrame.setVisible(false);
				ingredientFrame.setVisible(true);
			} else if (command.equals("open")) {
				openingFrame.setVisible(false);
				ingredientFrame.setVisible(true);
			}
		}
	}
 
	
}