package foodFactsPackage;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
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
	JPanel listPanel,btnPanel,mainPanel,editPanel;
	DefaultListModel model;
	JList list;
	JScrollPane scrollPane;
	JButton addBtn,removeBtn,editBtn;
	JLabel nameLabel,caloriesLabel,fatLabel,carbohydratesLabel,fiberLabel,proteinLabel;
	JTextField nameField,caloriesField,fatField,carbohydratesField,fiberField,proteinField;
	
	IngredientFrame(){
		//create list to hold existing ingredients
		model = new DefaultListModel();
		list = new JList(model);
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
        addBtn = new JButton("ADD");
        btnPanel.add(addBtn);
        editBtn = new JButton("EDIT");
        btnPanel.add(editBtn);
        removeBtn = new JButton("REMOVE");
        btnPanel.add(removeBtn);
        listPanel.add(btnPanel,BorderLayout.SOUTH);
        
        // Add/Edit ingredient panel
        editPanel = new JPanel();
        
        nameLabel = new JLabel("Name: ");
        nameField = new JTextField();
        nameField.setEditable(true);
        nameField.setColumns(30);
        editPanel.add(nameLabel);
        editPanel.add(nameField);
        
        //add components to JPanel
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.LINE_AXIS));
        mainPanel.add(Box.createRigidArea(new Dimension(100,0)));
        mainPanel.add(editPanel);
        mainPanel.add(Box.createRigidArea(new Dimension(400,0)));
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
