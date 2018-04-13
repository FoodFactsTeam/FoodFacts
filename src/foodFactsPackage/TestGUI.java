package foodFactsPackage;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Insets;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;
import java.awt.Rectangle;
import javax.swing.border.BevelBorder;

import foodFactsPackage.ListDemo.FireListener;
import foodFactsPackage.ListDemo.HireListener;

import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.AbstractListModel;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.DefaultListModel;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import javax.swing.JComboBox;

public class TestGUI extends JFrame{
	public TestGUI() {
		DefaultListModel listModel = new DefaultListModel();
        listModel.addElement("Jane Doe");
        listModel.addElement("John Smith");
        listModel.addElement("Kathy Green");
 
        //Create the list and put it in a scroll pane.
        JList list = new JList(listModel);
        list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        list.setSelectedIndex(0);
        //list.addListSelectionListener(this);
        list.setVisibleRowCount(5);
        JScrollPane listScrollPane = new JScrollPane(list);
 
        JButton hireButton = new JButton("hire");
        //HireListener hireListener = new HireListener(hireButton);
       // hireButton.setActionCommand(");
       // hireButton.addActionListener(hireListener);
        hireButton.setEnabled(false);
 
        JButton fireButton = new JButton("fire");
        //fireButton.setActionCommand(fireString);
        //fireButton.addActionListener(new FireListener());
 
        JTextField employeeName = new JTextField(10);
        //employeeName.addActionListener(hireListener);
        //employeeName.getDocument().addDocumentListener(hireListener);
        String name = listModel.getElementAt(
                              list.getSelectedIndex()).toString();
 
        //Create a panel that uses BoxLayout.
        JPanel buttonPane = new JPanel();
        buttonPane.setLayout(new BoxLayout(buttonPane,
                                           BoxLayout.LINE_AXIS));
        buttonPane.add(fireButton);
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(new JSeparator(SwingConstants.VERTICAL));
        buttonPane.add(Box.createHorizontalStrut(5));
        buttonPane.add(employeeName);
        buttonPane.add(hireButton);
        buttonPane.setBorder(BorderFactory.createEmptyBorder(5,5,5,5));
 
        add(listScrollPane, BorderLayout.CENTER);
        add(buttonPane, BorderLayout.PAGE_END);
	}
	
	public static void main(String[] args){
		TestGUI tg = new TestGUI();
		tg.setVisible(true);
		tg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tg.setSize(1000,600);
		tg.setResizable(false);
	}
}
