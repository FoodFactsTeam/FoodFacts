package foodFactsPackage;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

public class RecipeFrame {
	JFrame frame;
	JPanel mainPanel;
	Color bgColor;
	Font guiFont,inputFont;
	
	
	RecipeFrame(){
		frame = new JFrame();
		bgColor = new Color(210,180,140);
		guiFont = new Font("Times New Roman",Font.BOLD,24);
		inputFont = new Font("SanSerif",Font.PLAIN,24);
        
        
		// Generic ingredient Panel that can be added multiple times
		JPanel ingredientPanel = new JPanel();
		ingredientPanel.setOpaque(true);
		//ingredientPanel.setBackground(bgColor);
		ingredientPanel.setLayout(new BoxLayout(ingredientPanel,BoxLayout.X_AXIS));
		ingredientPanel.add(Box.createRigidArea(new Dimension(25,0)));
		JLabel ingredientLabel = new JLabel("Name: ");
		ingredientLabel.setFont(guiFont);
		ingredientPanel.add(ingredientLabel);
		ingredientPanel.add(Box.createRigidArea(new Dimension(5,0)));
		JTextField nameField = new JTextField("",30);
        nameField.setFont(inputFont);
        ingredientPanel.add(nameField);
        ingredientPanel.add(Box.createRigidArea(new Dimension(25,0)));
		JLabel quantityLabel = new JLabel("Quantity: ");
		quantityLabel.setFont(guiFont);
		ingredientPanel.add(quantityLabel);
		ingredientPanel.add(Box.createRigidArea(new Dimension(5,0)));
		JTextField quantityField = new JTextField();
		quantityField.setFont(inputFont);
		ingredientPanel.add(quantityField);
		ingredientPanel.add(Box.createRigidArea(new Dimension(25,0)));
		DefaultComboBoxModel<Measure> model = new DefaultComboBoxModel<>(Measure.values());
        JComboBox<Measure> measurementBox = new JComboBox<Measure>(model);
        measurementBox.setFont(guiFont);
        ingredientPanel.add(measurementBox);
        ingredientPanel.add(Box.createRigidArea(new Dimension(25,0)));
		JButton deleteIngredientButton = new JButton("DELETE");
		deleteIngredientButton.setFont(guiFont);
		ingredientPanel.add(deleteIngredientButton);
		ingredientPanel.add(Box.createRigidArea(new Dimension(25,0)));
		
		JScrollPane scrollPane = new JScrollPane();
		
		
		mainPanel = new JPanel();
		mainPanel.setLayout(new BoxLayout(mainPanel,BoxLayout.Y_AXIS));
		mainPanel.add(Box.createRigidArea(new Dimension(0,100)));
		mainPanel.add(ingredientPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0,1000)));
		frame.add(mainPanel);
		frame.setSize(1400,800);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	public static void main(String[] args) {
		RecipeFrame rf = new RecipeFrame();
	}

}
