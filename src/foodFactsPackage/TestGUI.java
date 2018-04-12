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

public class TestGUI extends JFrame{
	public TestGUI() {
		
		JPanel panel = new JPanel();
		getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);
		
		JLabel lblFoodFacts = new JLabel("Food Facts");
		lblFoodFacts.setFont(new Font("SansSerif", Font.BOLD, 64));
		lblFoodFacts.setHorizontalAlignment(SwingConstants.CENTER);
		lblFoodFacts.setBounds(204, 115, 446, 112);
		panel.add(lblFoodFacts);
		
		JLabel lblNutritional = new JLabel("Nutritional Information and Recipe Collection");
		lblNutritional.setFont(new Font("Times New Roman", Font.ITALIC, 32));
		lblNutritional.setHorizontalAlignment(SwingConstants.CENTER);
		lblNutritional.setBounds(124, 264, 603, 65);
		panel.add(lblNutritional);
		
		JButton btnNewButton = new JButton("ADD RECIPE");
		btnNewButton.setFont(new Font("Perpetua", Font.BOLD, 20));
		btnNewButton.setBounds(112, 376, 295, 135);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("OPEN RECIPE COLLECTION");
		btnNewButton_1.setFont(new Font("Perpetua", Font.BOLD, 20));
		btnNewButton_1.setBounds(463, 376, 305, 135);
		panel.add(btnNewButton_1);
	}
	
	public static void main(String[] args){
		TestGUI tg = new TestGUI();
		tg.setVisible(true);
		tg.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		tg.setSize(1000,600);
		tg.setResizable(false);
	}
}
