package foodFactsPackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;

//import foodFactsPackage.ListDemo.FireListener;
//import foodFactsPackage.ListDemo.HireListener;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import javax.swing.JMenu;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JMenuItem;

public class RecipeFrame extends JFrame{
	JPanel mainPanel,ingredientPanel;
	JLabel instructionsLabel;
	JScrollPane jsPane;
	ArrayList<JTextField> ingNames,ingQuantity;
	ArrayList<JComboBox<Measure>> ingMeasurement;
	ArrayList<JPanel> ingPanel;
	JTextArea instructions;
	
	RecipeFrame(){
		// initialize ArrayList's to hold components that store ingredient info for recipe
		ingNames = new ArrayList<JTextField>();
		ingQuantity = new ArrayList<JTextField>();
		ingMeasurement = new ArrayList<JComboBox<Measure>>();
		ingPanel = new ArrayList<JPanel>();
		
		//create main panel
		mainPanel = new JPanel();
		
		//adds recipe name label and field to main panel...and serving label and field
		JPanel panel1 = new JPanel();
		panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
		JLabel recipeNameLabel = new JLabel("Recipe Name: ");
		panel1.add(recipeNameLabel);
		JTextField recipeNameField = new JTextField(30);
		panel1.add(recipeNameField);
		panel1.add(Box.createRigidArea(new Dimension(50,0)));
		JLabel servingLabel = new JLabel("Number of Servings: ");
		panel1.add(servingLabel);
		JTextField servingField = new JTextField(5);
		panel1.add(servingField);
		panel1.add(Box.createRigidArea(new Dimension(300,0)));
		mainPanel.add(panel1);
		mainPanel.add(Box.createRigidArea(new Dimension(0,100)));
		
		//add JPanel with add ingredient and manage ingredients to main panel
		JPanel btnPanel1 = new JPanel();
		btnPanel1.setLayout(new BoxLayout(btnPanel1,BoxLayout.X_AXIS));
		btnPanel1.add(Box.createRigidArea(new Dimension(150,0)));
		JLabel ingLabel = new JLabel("Ingredients");
		btnPanel1.add(ingLabel);
		btnPanel1.add(Box.createRigidArea(new Dimension(350,0)));
		JButton addIngredientBtn = new JButton("Add Ingredient");
		btnPanel1.add(add(addIngredientBtn));
		btnPanel1.add(Box.createRigidArea(new Dimension(25,0)));
		JButton manageIngredientBtn = new JButton("Manage Ingredients");
		btnPanel1.add(manageIngredientBtn);
		mainPanel.add(btnPanel1);
		mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
		
		// add first ingredient to GUI...user can add more
		ingredientPanel = new JPanel();
		ingredientPanel.setLayout(new BoxLayout(ingredientPanel,BoxLayout.Y_AXIS));
		createIngredientPanel();
		mainPanel.add(ingredientPanel);
		
		//Add JTextArea below ingredients to hold instructions for recipe
		JPanel instructionPanel = new JPanel();
		instructionPanel.setLayout(new BoxLayout(instructionPanel,BoxLayout.X_AXIS));
		instructionsLabel = new JLabel("Recipe Instructions");
		instructionPanel.add(Box.createRigidArea(new Dimension(400,0)));
		instructionPanel.add(instructionsLabel);
		instructionPanel.add(Box.createRigidArea(new Dimension(400,0)));
		JPanel instructionTextPanel = new JPanel();
		instructions = new JTextArea(10,80);
		instructionTextPanel.add(instructions);
		mainPanel.add(instructionPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
		mainPanel.add(instructionTextPanel);
		mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
		
		//add buttons to save and display recipe
		JPanel btnPanel2 = new JPanel();
		JButton saveBtn = new JButton("Save Recipe");
		JButton createBtn = new JButton("Create Recipe");
		btnPanel2.setLayout(new BoxLayout(btnPanel2,BoxLayout.X_AXIS));
		btnPanel2.add(Box.createRigidArea(new Dimension(300,0)));
		btnPanel2.add(saveBtn);
		btnPanel2.add(Box.createRigidArea(new Dimension(100,0)));
		btnPanel2.add(createBtn);
		btnPanel2.add(Box.createRigidArea(new Dimension(300,0)));
		mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
		mainPanel.add(btnPanel2);
		
		jsPane = new JScrollPane();
		//jsPane.add(bg1);
		//jsPane.add(bg2);
		//mainPanel.add(jsPane);
		add(mainPanel);
		
		// create listener for Add IngredientButton
		addIngredientBtn.addMouseListener(new MouseAdapter(){
			public void mouseClicked(MouseEvent e){
                            IngredientFrame additional = new IngredientFrame();
				createIngredientPanel();
				//repaint doesn't cause it to update view 
				ingredientPanel.removeAll();
				ingredientPanel.setLayout(new BoxLayout(ingredientPanel,BoxLayout.Y_AXIS));
				System.out.println(ingPanel.size());
				for (JPanel jp : ingPanel){
					ingredientPanel.add(jp);
			        ingredientPanel.add(Box.createRigidArea(new Dimension(30,0)));
				}
				
				paintComponents(getGraphics());
				//paintAll(getGrapics());
			}
		});
		
	}
	
	public void createIngredientPanel(){
		//System.out.println("createIngredientPanel method is being called by button");
		//initialize components
		Dimension gap = new Dimension(30,0);
		JPanel panel = new JPanel();
		JLabel ingNameLabel = new JLabel("Name: ");
		JTextField ingNameField = new JTextField(30);
		JLabel quantityLabel = new JLabel("Quantity: ");
		JTextField qtyField = new JTextField(5);
		DefaultComboBoxModel<Measure> model = new DefaultComboBoxModel<>(Measure.values());
        JComboBox<Measure> measurementBox = new JComboBox<Measure>(model);
        JButton deleteBtn = new JButton("Delete");
        
        //add components to JPanel
        panel.add(ingNameLabel);
        panel.add(ingNameField);
        panel.add(Box.createRigidArea(gap));
        panel.add(quantityLabel);
        panel.add(qtyField);
        panel.add(measurementBox);
        panel.add(Box.createRigidArea(gap));
        panel.add(Box.createRigidArea(gap));
        panel.add(deleteBtn);
        panel.add(Box.createRigidArea(gap));
        
        //add jtextfields, jcombobox, and panel to ArrayLists for later reference
        ingNames.add(ingNameField);
        ingQuantity.add(qtyField);
        ingMeasurement.add(measurementBox);
        ingPanel.add(panel);
        
        //add panel to mainPanel
        ingredientPanel.add(panel);
        ingredientPanel.add(Box.createRigidArea(gap));
	}
	
	
	
	
	public static void main(String[] args){
		RecipeFrame rf = new RecipeFrame();
		rf.setVisible(true);
		rf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		rf.setSize(1000,600);
		rf.setResizable(true);
	}
}
