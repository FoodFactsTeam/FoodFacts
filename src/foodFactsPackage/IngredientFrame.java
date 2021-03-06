package foodFactsPackage;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

public class IngredientFrame {
	JFrame frame;
	JPanel listPanel,btnPanel,mainPanel,labelPanel,fieldPanel, headerPanel;
	DefaultListModel<String> model;
	JList<String> list;
	JScrollPane scrollPane;
	JButton addBtn,removeBtn,backBtn;
	JLabel nameLabel,measurementLabel,caloriesLabel,fatLabel,carbohydratesLabel,fiberLabel,proteinLabel;
	JTextField nameField,caloriesField,fatField,carbohydratesField,fiberField,proteinField;
	Font labelFont,fieldFont;
        
	DefaultComboBoxModel<Measure> cModel;
	JComboBox<Measure> measurementBox;
        Measure bsMsr;
        
	//Recipe userRecipe;

        
	IngredientFrame(){
        //create list to hold existing ingredients
        model = new DefaultListModel<String>();
        System.out.println(Library.ingredientStore.size());
        for (int i = 0; i < Library.ingredientStore.size(); i++){
        	System.out.println(Library.ingredientStore.get(i).toString());
        }
        for (Ingredient i : Library.ingredientStore){
        	model.addElement(i.toString());
        }
        list = new JList<String>(model);
        list.setVisibleRowCount(10);
        list.setFixedCellHeight(20);
        list.setFixedCellWidth(140);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

        ImageIcon backIcon;


        scrollPane = new JScrollPane(list);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        listPanel = new JPanel(new BorderLayout());
        listPanel.add(scrollPane,BorderLayout.CENTER);

        //create JPanel to hold buttons that go below list of ingredients
        btnPanel = new JPanel();
        btnPanel.setOpaque(true);
        btnPanel.setBackground(new Color(210,180,140));
        addBtn = new JButton("ADD");
        btnPanel.add(addBtn);
        removeBtn = new JButton("REMOVE");
        btnPanel.add(removeBtn);
        listPanel.add(btnPanel,BorderLayout.SOUTH);
        
        // JLabel ingredient panel
        labelFont = new Font("Times New Roman",Font.BOLD,52);
        labelPanel = new JPanel();
        labelPanel.setOpaque(true);
        labelPanel.setBackground(new Color(210,180,140));
        labelPanel.setLayout(new BoxLayout(labelPanel,BoxLayout.Y_AXIS));
        labelPanel.add(Box.createRigidArea(new Dimension(0,50)));
        nameLabel = new JLabel("Name: ");
        nameLabel.setFont(labelFont);
        labelPanel.add(nameLabel);
        labelPanel.add(Box.createRigidArea(new Dimension(0,50)));
//        
        measurementLabel = new JLabel("Base Measure: ");
        measurementLabel.setFont(labelFont);
        labelPanel.add(measurementLabel);
        labelPanel.add(Box.createRigidArea(new Dimension(0,25)));

        caloriesLabel = new JLabel("Calories: ");
        caloriesLabel.setFont(labelFont);
        labelPanel.add(caloriesLabel);
        labelPanel.add(Box.createRigidArea(new Dimension(0,25)));
        fatLabel = new JLabel("Fat: ");
        fatLabel.setFont(labelFont);
        labelPanel.add(fatLabel);
        labelPanel.add(Box.createRigidArea(new Dimension(0,25)));
        carbohydratesLabel = new JLabel("Carbs: ");
        carbohydratesLabel.setFont(labelFont);
        labelPanel.add(carbohydratesLabel);
        labelPanel.add(Box.createRigidArea(new Dimension(0,25)));
        fiberLabel = new JLabel("Fiber: ");
        fiberLabel.setFont(labelFont);
        labelPanel.add(fiberLabel);
        labelPanel.add(Box.createRigidArea(new Dimension(0,25)));
        proteinLabel = new JLabel("Protein: ");
        proteinLabel.setFont(labelFont);
        labelPanel.add(proteinLabel);
        labelPanel.add(Box.createRigidArea(new Dimension(0,100)));
        nameField = new JTextField();
        nameField.setEditable(true);
        nameField.setColumns(30);
        
     // JTextField ingredient panel
        fieldFont = new Font("Times New Roman",Font.PLAIN,24);
        fieldPanel = new JPanel();
        fieldPanel.setOpaque(true);
        fieldPanel.setBackground(new Color(210,180,140));
        fieldPanel.setLayout(new BoxLayout(fieldPanel,BoxLayout.Y_AXIS));
        fieldPanel.add(Box.createRigidArea(new Dimension(0,50)));
        nameField = new JTextField();
        nameField.setFont(fieldFont);
        fieldPanel.add(nameField);
        fieldPanel.add(Box.createRigidArea(new Dimension(0,50)));
//
        cModel = new DefaultComboBoxModel<>(Measure.values());         
        measurementBox = new JComboBox<Measure>(cModel);
        measurementBox.setFont(fieldFont);
        fieldPanel.add(measurementBox);
        fieldPanel.add(Box.createRigidArea(new Dimension(0,25)));


        caloriesField = new JTextField();
        caloriesField.setFont(fieldFont);
        fieldPanel.add(caloriesField);
        fieldPanel.add(Box.createRigidArea(new Dimension(0,25)));
        fatField = new JTextField();
        fatField.setFont(fieldFont);
        fieldPanel.add(fatField);
        fieldPanel.add(Box.createRigidArea(new Dimension(0,25)));
        carbohydratesField = new JTextField();
        carbohydratesField.setFont(fieldFont);
        fieldPanel.add(carbohydratesField);
        fieldPanel.add(Box.createRigidArea(new Dimension(0,25)));
        fiberField = new JTextField();
        fiberField.setFont(fieldFont);
        fieldPanel.add(fiberField);
        fieldPanel.add(Box.createRigidArea(new Dimension(0,25)));
        proteinField = new JTextField();
        proteinField.setFont(fieldFont);
        fieldPanel.add(proteinField);
        fieldPanel.add(Box.createRigidArea(new Dimension(0,100)));

        //measurementBox.addActionListener(new measurementBoxListener());
       
        //Set action commands and add listeners to buttons
        addBtn.setActionCommand("addIngredient");
        removeBtn.setActionCommand("removeIngredient");
        addBtn.addActionListener(new IngredientListener());
        removeBtn.addActionListener(new IngredientListener());

        backIcon = new ImageIcon("backIcon.png", "Go back");
        backBtn = new JButton(backIcon);
        backBtn.setActionCommand("goHome");
        backBtn.setOpaque(true);
        backBtn.setPreferredSize(new Dimension(40, 40));
        backBtn.addActionListener(new IngredientListener());

        headerPanel = new JPanel();
        headerPanel.setOpaque(true);
        headerPanel.setBackground(new Color(30,144,255));
        headerPanel.setLayout(new GridLayout(4,1));
        //headerPanel.add(backBtn);


        //add components to JPanel
        mainPanel = new JPanel();
        mainPanel.setOpaque(true);
        mainPanel.setBackground(new Color(210,180,140));
        mainPanel.add(backBtn);
        mainPanel.add(headerPanel);
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
        mainPanel.add(Box.createRigidArea(new Dimension(100,0)));
        mainPanel.add(labelPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(50,0)));
        mainPanel.add(fieldPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(300,0)));
        mainPanel.add(listPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(25,0)));

        //create JFrame and set basic settings
        frame = new JFrame("Manage Ingredients Screen");
        frame.add(headerPanel);
        frame.add(mainPanel);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.setVisible(true);

        // = new Recipe();
	}
                    private class measurementBoxListener implements ActionListener
        {
        public void actionPerformed(ActionEvent e)
        {
            JComboBox cb = new JComboBox();
            cb = (JComboBox)e.getSource();
        }
        }
    private class IngredientListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            Ingredient ing;
            if (command.equals("addIngredient")) {
                String name = nameField.getText();
                bsMsr = (Measure)measurementBox.getSelectedItem();
                double calorie = Double.parseDouble(caloriesField.getText());               
                double fat = Double.parseDouble(fatField.getText());
                double carbs = Double.parseDouble(carbohydratesField.getText());
                double fiber = Double.parseDouble(fiberField.getText());
                double protein = Double.parseDouble(proteinField.getText());
                ing = new Ingredient(name, bsMsr, calorie, fat, carbs, fiber, protein);
                Library.ingredientStore.add(ing); 
                String ingDis = ing.toString();
                
                //clear fields after saving an ingredient
                nameField.setText("");
                measurementBox.setSelectedIndex(0);
                caloriesField.setText("");
                fatField.setText("");
                carbohydratesField.setText("");
                fiberField.setText("");
                proteinField.setText("");
                
                model.addElement(ingDis); //JULIE, ADD BASE MEASURE
            } else if (command.equals("removeIngredient")) {
                int ind = list.getSelectedIndex();
                Library.ingredientStore.remove(ind);
                model.removeElementAt(ind);
            } else if (command.equals("goHome")) {
                frame.setVisible(false);
                Library.getIngrtNames();
            }
            
        }
    }

            public static void main(String[] args) 
    {
        FoodFactsGUI openingFrame = new FoodFactsGUI();
        openingFrame.createOpeningFrame();
        openingFrame.createIngredientFrame();
        
    }
	
}