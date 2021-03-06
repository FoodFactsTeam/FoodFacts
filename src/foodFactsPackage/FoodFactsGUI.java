package foodFactsPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.*;

import sun.awt.WindowClosingListener;

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

	RecipeCollection recipeCollection;

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

	public void createRecipeCollectionFrame(){
		recipeCollection = new RecipeCollection();
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
		
		addRecipe = new JButton("Add a Recipe");
		addRecipe.setFont(new Font("Perpetua", Font.BOLD, 20));
		addRecipe.setHorizontalAlignment(JLabel.CENTER);
		addRecipe.setVerticalAlignment(JLabel.CENTER);
		int arX = (frameSize[0]-2*btnLabelSize[0])*1/4;
		addRecipe.setBounds(150, 350, btnLabelSize[0], btnLabelSize[1]);
		addRecipe.setActionCommand("add");
		addRecipe.addActionListener(new ButtonClickListener());
		
		openRecipeBook = new JButton("Open Recipe Collection");
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
		class CustomCloseAction extends WindowAdapter{
			public void windowClosing(WindowEvent evt) {
				FileHandler.writeObjectToFile("IngredientStore.ser", Library.ingredientStore);
				System.out.printf("%d Ingredients from store serialized.",Library.ingredientStore.size());
				FileHandler.writeObjectToFile("RecipeStore.ser", Library.recLib);
				System.exit(0);
			}
		}
		openingFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		openingFrame.addWindowListener(new CustomCloseAction());
//		openingFrame.addWindowListener(new WindowAdapter() {
//			public void windowClosing(WindowEvent evt) {
//				
//			}
//			
//		});
	}

        //I'm not sure what this for. I couldn't find it anywhere, but I used the
        // same name in MAIN and in the ingredient Frame.
	//List<Ingredient> ingredientStore = new ArrayList<>();

	private class ButtonClickListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String command = e.getActionCommand();
			if (command.equals("add")) {
				//openingFrame.setVisible(false);
				//ingredientFrame.setVisible(true);
                RecipeFrame rf = new RecipeFrame();
		rf.setVisible(true);
		rf.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		rf.setSize(1000,750);
		rf.setResizable(true);
			} else if (command.equals("open")) {
				openingFrame.setVisible(false);
				createRecipeCollectionFrame();
			}
		}
	}
 
	
}