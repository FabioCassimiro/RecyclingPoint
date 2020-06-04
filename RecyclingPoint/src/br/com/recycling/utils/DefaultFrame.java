package br.com.recycling.utils;

import javax.swing.JFrame;

/**
 *
 * @author WINDOWS
 */
public class DefaultFrame extends JFrame {
    
    
    public DefaultFrame(){
        setSize(500,800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }
}
