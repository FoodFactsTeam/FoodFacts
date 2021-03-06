package foodFactsPackage;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.*;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;

//import foodFactsPackage.ListDemo.FireListener;
//import foodFactsPackage.ListDemo.HireListener;

import java.awt.GridLayout;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Random;

public class RecipeFrame extends JFrame{
    JPanel mainPanel,ingredientPanel;
    JLabel instructionsLabel;
    JScrollPane jsPane;
    //this is the array list holding all the ingQuantities
    ArrayList<JTextField> ingQuantity;
    //this is the
    ArrayList<JComboBox<String>> ingNames;
    ArrayList<JComboBox<Measure>> ingMeasurement;
    Ingredient [] recpIng;
    ArrayList<JPanel> ingPanel;
    JTextArea instructions;
    JScrollPane ingScrollPane,instructionScrollPane;
    Color bgColor;

    RecipeFrame(){
        //create background color for gui
        bgColor = new Color(210,180,140);
        // initialize ArrayList's to hold components that store ingredient info for recipe
        ingNames = new ArrayList<>();
        ingQuantity = new ArrayList<>();
        ingMeasurement = new ArrayList<>();
        ingPanel = new ArrayList<>();

        //create main panel
        mainPanel = new JPanel();
        mainPanel.setBackground(bgColor);

        //adds recipe name label and field to main panel...and serving label and field
        JPanel panel1 = new JPanel();
        panel1.setBackground(bgColor);
        panel1.setLayout(new BoxLayout(panel1,BoxLayout.X_AXIS));
        JLabel recipeNameLabel = new JLabel("Recipe Name: ");
        panel1.add(recipeNameLabel);
        //LOOK HERE for User'Recipe Name
        JTextField recipeNameField = new JTextField(30);
        panel1.add(recipeNameField);
        panel1.add(Box.createRigidArea(new Dimension(50,0)));
        JLabel servingLabel = new JLabel("Number of Servings: ");
        panel1.add(servingLabel);
        JTextField servingField = new JTextField(5);
        panel1.add(servingField);
        panel1.add(Box.createRigidArea(new Dimension(300,0)));
        ImageIcon homeIcon = new ImageIcon("homeIcon.png", "Go to home page");
        JButton homeBtn = new JButton(homeIcon);
        homeBtn.setActionCommand("goHome");
        homeBtn.setOpaque(true);
        homeBtn.setPreferredSize(new Dimension(40, 40));
        homeBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                mainPanel.getParent().getParent().getParent().getParent().setVisible(false);
            }
        });
        panel1.add(homeBtn);
        mainPanel.add(panel1);
        mainPanel.add(Box.createRigidArea(new Dimension(0,100)));

        //add JPanel with add ingredient and manage ingredients to main panel
        JPanel btnPanel1 = new JPanel();
        btnPanel1.setBackground(bgColor);
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
        manageIngredientBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //create a new Ingredient Frame
                IngredientFrame additional = new IngredientFrame();
            }
        });
        mainPanel.add(btnPanel1);
        mainPanel.add(Box.createRigidArea(new Dimension(0,50)));

        // add first ingredient to GUI...user can add more
        ingredientPanel = new JPanel();
        ingredientPanel.setBackground(bgColor);
        //ingredientPanel.setLayout(new BoxLayout(ingredientPanel,BoxLayout.Y_AXIS));
        //createIngredientPanel();
        //mainPanel.add(ingredientPanel);
        //create JScrollPane for ingreadient list
        ingScrollPane = new JScrollPane(ingredientPanel);
        ingScrollPane.setPreferredSize(new Dimension(900,200));
        ingScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        ingScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(ingScrollPane);

        //Add JTextArea below ingredients to hold instructions for recipe
        JPanel instructionPanel = new JPanel();
        instructionPanel.setBackground(bgColor);
        instructionPanel.setLayout(new BoxLayout(instructionPanel,BoxLayout.X_AXIS));
        instructionsLabel = new JLabel("Recipe Instructions");
        instructionPanel.add(Box.createRigidArea(new Dimension(400,0)));
        instructionPanel.add(instructionsLabel);
        instructionPanel.add(Box.createRigidArea(new Dimension(400,0)));
        JPanel instructionTextPanel = new JPanel();
        instructions = new JTextArea(12,80);
        instructionTextPanel.add(instructions);
        instructionScrollPane = new JScrollPane(instructionTextPanel);
        instructionScrollPane.setPreferredSize(new Dimension(900,200));
        instructionScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        instructionScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        mainPanel.add(ingScrollPane);
        mainPanel.add(instructionPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
        mainPanel.add(instructionScrollPane);
        mainPanel.add(Box.createRigidArea(new Dimension(0,50)));

        //add buttons to save and display recipe
        JPanel btnPanel2 = new JPanel();
        btnPanel2.setBackground(bgColor);
        JButton saveBtn = new JButton("Save Recipe");


        JButton createBtn = new JButton("Create Recipe");
        btnPanel2.setLayout(new BoxLayout(btnPanel2,BoxLayout.X_AXIS));
        btnPanel2.add(Box.createRigidArea(new Dimension(300,0)));
        btnPanel2.add(saveBtn);
        btnPanel2.add(Box.createRigidArea(new Dimension(100,0)));
        btnPanel2.add(createBtn);

        createBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {

                System.out.println(recipeNameField.getText() );
                System.out.println(Library.recLib);
                RecipeDisplayGUI displayRecp = new RecipeDisplayGUI(recipeNameField.getText());
            }
        });
        btnPanel2.add(Box.createRigidArea(new Dimension(300,0)));
        mainPanel.add(Box.createRigidArea(new Dimension(0,50)));
        mainPanel.add(btnPanel2);

        // add entire panel holding all components to JFrame
        add(mainPanel);

        // create listener for Add IngredientButton
        addIngredientBtn.addMouseListener(new MouseAdapter(){
            public void mouseClicked(MouseEvent e){
                //ingMeasurement = new ArrayList<>();

                createIngredientPanel();
                //repaint doesn't cause it to update view
                ingredientPanel.removeAll();
                ingredientPanel.setLayout(new BoxLayout(ingredientPanel,BoxLayout.Y_AXIS));
                for (JPanel jp : ingPanel){
                    ingredientPanel.add(jp);
                    ingredientPanel.add(Box.createRigidArea(new Dimension(30,0)));
                }

                paintComponents(getGraphics());
                //paintAll(getGrapics());
            }
        });
        /**
         * This Button will save a recipe by adding it to recpLib
         */
        saveBtn.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent e)
            {
                Recipe firstR = new Recipe();
                String recpName = recipeNameField.getText();
                firstR.setTitle(recpName);
                //these arrays hold the entire recipe's lists of specified info
                Ingredient[] recpIng = new Ingredient[ingNames.size()];
                Double [] recpQuants = new Double[ingQuantity.size()];
                String[] recpUnits = new String[ingMeasurement.size()];
                //this loop gets an array of Ingredient objects.
                //it takes the names and unit and compares this with the object to String.
                for (int i = 0; i<ingNames.size(); i++)
                {
                    Object purple;
                    purple = ingNames.get(i).getSelectedItem();
                    for(Ingredient ing: Library.ingredientStore)
                    {
                        if (ing.toString().equals(purple.toString()))
                            recpIng[i]=ing;
                    }
                }
                // This for loop gets the quantity called for in the recipe
                for (int i=0; i<ingQuantity.size(); i++)
                {
                    JTextField rq;
                    String rqtx;
                    double pink = 0;
                    rq = ingQuantity.get(i);
                    rqtx = rq.getText();
                    //System.out.println(rqtx);
                    pink = Double.parseDouble(rqtx);
                    recpQuants[i] = pink;
                }
                //this loop gets the units used in the recipe it pulls if from a Measure object
                for (int i = 0; i<ingMeasurement.size(); i++)
                {
                    Object pri = ingMeasurement.get(i).getSelectedItem();
                    Measure fir = ((Measure)pri);
                    recpUnits[i] = pri.toString();
                }
                for (int j = 0; j<ingNames.size(); j++)
                { //adds the "ingredient" to the recipe complete with Ingredient, quant and unit
                    firstR.addIngredient(recpIng[j],recpQuants[j],recpUnits[j]);
                } //we add the recipe to the library class
                firstR.stringInstructions = instructions.getText();
                firstR.servings = Double.parseDouble(servingField.getText());
                Library.recLib.add(firstR);
            }
        });

        //set properties of JFrame
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(1000,900);
        setResizable(false);

        //when leaving ingredient frame, this method is called to update values populating components
        class WindowFocusHandler extends WindowAdapter {
            @Override
            public void windowActivated(WindowEvent e){
                //update list to add add to JComboBox's
                Library.getIngrtNames();
                String[] newList = Library.ingtNames;
                //for each ingComboBox in recipe ingredient list
                for (JComboBox<String> jcb : ingNames){
                    String currentlySelectedText = (String)jcb.getSelectedItem();
                    jcb.removeAllItems();
                    for (int i = 0; i < newList.length; i++){
                        jcb.addItem(newList[i]);
                        if (currentlySelectedText == newList[i]){
                            jcb.setSelectedIndex(i);
                        }
                    }


                }
                //update list of ingredient names


            }
        }
        addWindowListener(new WindowFocusHandler());

    }

    public void createIngredientPanel(){
        //initialize components
        Dimension gap = new Dimension(30,0);
        JPanel panel = new JPanel();
        panel.setBackground(bgColor);
        JLabel ingNameLabel = new JLabel("Name: ");
        //I added Library.ingtNames to the parameters to try to fill this box
        JComboBox<String> ingNameComboBox = new JComboBox<>(Library.ingtNames);
        ingNameComboBox.setPrototypeDisplayValue("ingredient approximately 30 characters "
                + "long plus some space");
        //JTextField ingNameField = new JTextField(30);
        JLabel quantityLabel = new JLabel("Quantity: ");
        JTextField qtyField = new JTextField(5);
        DefaultComboBoxModel<Measure> model = new DefaultComboBoxModel<>(Measure.values());
        JComboBox<Measure> measurementBox = new JComboBox<Measure>(model);

        JButton deleteBtn = new JButton("Delete");
        //random int assigned to actionCommand will be used to find index of that delete button.
        //this index will be used to delete everything related to an ingredient when the delete
        //button is pressed.
        Random rand = new Random();
        String actCmnd = Integer.toString(rand.nextInt());
        System.out.println(actCmnd);
        deleteBtn.setActionCommand(actCmnd);
        ingNameComboBox.setActionCommand(actCmnd);


        deleteBtn.addActionListener(new ActionListener()
        {
            public void actionPerformed(ActionEvent e)
            {
                //find index of this button in ingredient list of recipe
                JButton b = (JButton)e.getSource();
                String id = b.getActionCommand();
                int index = -1;
                for (int n = 0; n < ingNames.size(); n++){
                    if (ingNames.get(n).getActionCommand() == id){
                        index = n;
                        System.out.println("Delete index: " + n);
                    }
                }
                // using the value of index, delete everything in that position
                ingPanel.remove(index);
                ingNames.remove(index);
                ingQuantity.remove(index);
                ingMeasurement.remove(index);

                //update the display of the Recipe Frame
                ingredientPanel.removeAll();
                ingredientPanel.setLayout(new BoxLayout(ingredientPanel,BoxLayout.Y_AXIS));
                for (JPanel jp : ingPanel){
                    ingredientPanel.add(jp);
                    ingredientPanel.add(Box.createRigidArea(new Dimension(30,0)));
                }
                paintComponents(getGraphics());

                //remove an ingredient from the ingredient panel
                //ingNames.remove(ingNameComboBox);
                //ingNames.add(ingNameField);
                //ingQuantity.remove(qtyField);
                //this just stores one measurement box. We need to get the item at the time of selection
                //ingMeasurement.remove(measurementBox);
                //ingPanel.remove(panel);

                //create new panel w/out the removed components
                    /*createIngredientPanel();
			//repaint doesn't cause it to update view
			ingredientPanel.removeAll();
			ingredientPanel.setLayout(new BoxLayout(ingredientPanel,BoxLayout.Y_AXIS));
			for (JPanel jp : ingPanel)
                        {
				ingredientPanel.add(jp);
			        ingredientPanel.add(Box.createRigidArea(new Dimension(30,0)));
			}

		paintComponents(getGraphics());*/

            }
        });

        //add components to JPanel
        panel.add(ingNameLabel);
        panel.add(ingNameComboBox);
        //panel.add(ingNameField);
        panel.add(Box.createRigidArea(gap));
        panel.add(quantityLabel);
        panel.add(qtyField);
        panel.add(measurementBox);
        panel.add(Box.createRigidArea(gap));
        panel.add(Box.createRigidArea(gap));
        panel.add(deleteBtn);
        panel.add(Box.createRigidArea(gap));

        //add jtextfields, jcombobox, and panel to ArrayLists for later reference
        ingNames.add(ingNameComboBox);
        //ingNames.add(ingNameField);
        ingQuantity.add(qtyField);
        //this just stores one measurement box. We need to get the item at the time of selection
        ingMeasurement.add(measurementBox);
        ingPanel.add(panel);

        //add panel to mainPanel
        ingredientPanel.add(panel);
        ingredientPanel.add(Box.createRigidArea(gap));
    }
}