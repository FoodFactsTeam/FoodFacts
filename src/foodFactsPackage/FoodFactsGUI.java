package foodFactsPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

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
	
	FoodFactsGUI(){
		createOpeningFrame();
	}
	
	public void createOpeningFrame(){
		openingFrame = new JFrame();
		openingPanel = new JPanel();
		openingPanel.setLayout(null);
		openingPanel.setOpaque(true);
		openingPanel.setBackground(new Color(210,180,140));
		
		title = new JLabel("Food Facts");
		titleFont = new Font("San Serif",Font.BOLD,64);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(titleFont);
		
		subTitle = new JLabel("Nutritional Information and Recipe Collection");
		titleFont = new Font("Times New Roman", Font.ITALIC, 32);
		title.setHorizontalAlignment(JLabel.CENTER);
		title.setFont(titleFont);
		
		
		openingPanel2 = new JPanel();
		openingPanel2.setLayout(new BorderLayout());
		addRecipe = new JButton("Add Recipe");
		openRecipeBook = new JButton("Open Your Recipe Book");
		//openingPanel2.add(addRecipe, BorderLayout.WEST);
		//openingPanel2.add(openRecipeBook, BorderLayout.EAST);
		
		
		openingPanel.add(title, BorderLayout.CENTER);
		//openingPanel.add(openingPanel2,BorderLayout.CENTER);
		openingFrame.add(openingPanel);
		
		
		openingFrame.setSize(1000, 600);
		openingFrame.setVisible(true);
		//instead of default exit on close, set serialize ingredients and recipes when closing
		openingFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args){
		FoodFactsGUI gui = new FoodFactsGUI();
	}
}
