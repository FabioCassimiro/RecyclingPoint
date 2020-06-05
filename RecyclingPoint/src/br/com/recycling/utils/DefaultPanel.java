package br.com.recycling.utils;

import java.awt.Font;
import java.awt.event.MouseAdapter;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author Fabio Cassimiro
 */

public class DefaultPanel extends JPanel {
    
    public DefaultPanel() {
        setSize(500, 800);
        setBackground(DefaultComponents.primaryColor);
        buttonClose();
        setLayout(null);
        
    }
    
    private void buttonClose(){
        JLabel buttonClose = new JLabel("X");
        buttonClose.setFont(DefaultComponents.fontText);
        buttonClose.setBounds(470, 10, 25, 25);
        buttonClose.setForeground(DefaultComponents.textColor);
        buttonClose.addMouseListener(new MouseAdapter() {
             @Override
             public void mousePressed(java.awt.event.MouseEvent evt) {
                System.exit(0);
            }
        });
        
        add(DefaultComponents.defaultLabels("Recycling", new Font("Arial", Font.BOLD, 40), 150, 20, 200, 45));
        add(buttonClose);
    }
}
