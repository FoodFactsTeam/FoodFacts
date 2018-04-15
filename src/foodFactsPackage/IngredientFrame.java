package foodFactsPackage;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.ScrollPaneConstants;

public class IngredientFrame {
	JFrame frame;
	JPanel listPanel,btnPanel,mainPanel,labelPanel,fieldPanel;
	DefaultListModel<String> model;
	JList<String> list;
	JScrollPane scrollPane;
	JButton addBtn,removeBtn,editBtn;
	JLabel nameLabel,measurementLabel,caloriesLabel,fatLabel,carbohydratesLabel,fiberLabel,proteinLabel;
	JTextField nameField,caloriesField,fatField,carbohydratesField,fiberField,proteinField;
	Font labelFont,fieldFont;
	DefaultComboBoxModel<Measure> cModel;
	JComboBox<Measure> measurementBox;
	
	IngredientFrame(){
		//create list to hold existing ingredients
		model = new DefaultListModel<String>();
		list = new JList<String>(model);
		list.setVisibleRowCount(10);
		list.setFixedCellHeight(20);
		list.setFixedCellWidth(140);
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
        editBtn = new JButton("EDIT");
        btnPanel.add(editBtn);
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
        
        
        
        //add components to JPanel
        mainPanel = new JPanel();
        mainPanel.setOpaque(true);
        mainPanel.setBackground(new Color(210,180,140));
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
        frame.add(mainPanel);
        frame.setSize(1400, 800);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
        
	}
	
	public static void main(String[] args){
		IngredientFrame ingF = new IngredientFrame();
	}
}