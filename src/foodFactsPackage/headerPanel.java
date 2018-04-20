package foodFactsPackage;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by julie.kohler on 4/17/2018.
 */
public class headerPanel {
    JPanel hP;
    JButton homeBtn, screen1Btn, screen2Btn;
    ImageIcon homeIcon;
    JFrame topFrame;
    String screen1, screen2;

    headerPanel(String screen1, String screen2) {
        hP = new JPanel();
        hP.setOpaque(true);
        hP.setBackground(new Color(30,144,255));
        hP.setLayout(new GridLayout(4,1));

//        JFrame topFrame = (JFrame) SwingUtilities.getWindowAncestor(this);

        homeIcon = new ImageIcon("homeIcon.png", "Go to home page");
        homeBtn = new JButton(homeIcon);
        homeBtn.setActionCommand("goHome");
        homeBtn.setOpaque(true);
        homeBtn.setPreferredSize(new Dimension(40, 40));
//        homeBtn.addActionListener(new IngredientListener());

        screen1Btn = new JButton(screen1);
        screen1Btn.setActionCommand(screen1);
        screen1Btn.setOpaque(true);

        screen2Btn = new JButton(screen2);
        screen2Btn.setActionCommand(screen2);
        screen2Btn.setOpaque(true);

        hP.add(homeBtn);
    }

    public String getScreen1() {
        return screen1;
    }

    public String getScreen2() {
        return screen2;
    }

    private class screenButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e)
        {
            String screen1 = headerPanel.getScreen1();
//          frame.setVisible(false);
            screen1.setVisible(true);

        }
    }
}
