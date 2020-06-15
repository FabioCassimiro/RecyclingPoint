package br.com.recycling.utils;

import java.awt.Color;
import java.awt.Font;
import java.text.ParseException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author WINDOWS
 */
public class DefaultComponents {

    public static Color primaryColor = new Color(32, 178, 170);
    public static Color secundaryColor = new Color(0, 139, 139);
    public static Color textColor = new Color(255, 255, 255);
    public static Font fontText = new Font("Arial", Font.BOLD, 30);
    public static Font fontTextLabel = new Font("Arial", Font.BOLD, 18);
    public static Font fontTextButtons = new Font("Arial", Font.BOLD, 20);
    public static Font fontTextFields = new Font("Arial", Font.BOLD, 16);

    public static MaskFormatter mask(String mask) {
        MaskFormatter maskFormatter = null;
        try {
            return maskFormatter = new MaskFormatter(mask);
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static JTextField defaultFields(int positionX, int positionY) {
        JTextField txfDefault = new JTextField();
        txfDefault.setBounds(positionX, positionY, 440, 35);
        txfDefault.setFont(DefaultComponents.fontTextFields);
        txfDefault.setBackground(Color.WHITE);
        txfDefault.setForeground(DefaultComponents.secundaryColor);
        txfDefault.setBorder(null);

        return txfDefault;
    }

    public static JPasswordField defaultFieldsPassword(int positionX, int positionY) {
        JPasswordField pwdDefault = new JPasswordField();
        pwdDefault.setBounds(positionX, positionY, 440, 35);
        pwdDefault.setFont(DefaultComponents.fontTextFields);
        pwdDefault.setBackground(Color.WHITE);
        pwdDefault.setForeground(DefaultComponents.secundaryColor);
        pwdDefault.setBorder(null);

        return pwdDefault;
    }

    public static JLabel defaultLabels(String text, Font font, int positionX, int positionY, int width, int height) {
        JLabel lblDefault = new JLabel(text);
        lblDefault.setFont(font);
        lblDefault.setForeground(textColor);
        lblDefault.setBounds(positionX, positionY, width, height);
        return lblDefault;
    }

    public ImageIcon searchImage(String filename) {
        ImageIcon imageIcon = new ImageIcon(getClass().getResource("/br/com/recycling/image/" + filename));
        return imageIcon;
    }

    public static JButton defaultButton(String text, Color color, int positionX, int positionY, int width, int height) {
        JButton btnDefault = new JButton(text);
        btnDefault.setBounds(positionX, positionY, width, height);
        btnDefault.setBackground(color);
        btnDefault.setForeground(Color.WHITE);
        btnDefault.setBorder(null);
        btnDefault.setFocusPainted(false);
        btnDefault.setFont(fontTextButtons);

        return btnDefault;
    }

    public void image(JPanel panel) {
        JLabel imageTree = new JLabel(searchImage("Tree.png"));
        imageTree.setBounds(200, 500, 400, 400);
        JLabel imageInvertedTree = new JLabel(searchImage("InvertedTree.png"));
        imageInvertedTree.setBounds(-100, -80, 400, 400);

        panel.add(imageTree);
        panel.add(imageInvertedTree);
    }

    public static JLabel montaBtnMinimizar(JFrame janela) {
        JLabel minimizar = new JLabel("_");
        minimizar.setForeground(Color.WHITE);
        minimizar.setFont(new Font("Arial", Font.BOLD, 30));
        minimizar.setBounds(440, -7, 20, 30);
        minimizar.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mousePressed(java.awt.event.MouseEvent evt) {
                janela.setExtendedState(JFrame.ICONIFIED);
            }
        });
        return minimizar;
    }
}
