package br.com.recycling.viewer;

import br.com.recycling.controller.ControllerLogin;
import br.com.recycling.exception.FieldValueNotInformed;
import br.com.recycling.exception.UserNotFound;
import br.com.recycling.utils.ClassInterface;
import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Fabio Cassimiro
 */

public class Login extends JFrame implements ClassInterface {

    private DefaultPanel pnlLogin = new DefaultPanel();
    private DefaultComponents components = new DefaultComponents();
    private ControllerLogin controller = new ControllerLogin();
    private JTextField txfUsername;
    private JPasswordField pwdPassword;

    public Login() {
        panelInit();
        setSize(500, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void panelInit() {
        pnlLogin.add(DefaultComponents.montaBtnMinimizar(this));
        add(pnlLogin);
        labels();
        buttons();
        fields();
        components.image(pnlLogin);
    }

    @Override
    public void labels() {
        pnlLogin.add(DefaultComponents.defaultLabels("Welcome!!", new Font("Arial", Font.BOLD, 35), 50, 170, 200, 40));
        pnlLogin.add(DefaultComponents.defaultLabels("Come help us save the planet.", new Font("Arial", Font.BOLD, 22), 140, 200, 350, 30));
        pnlLogin.add(DefaultComponents.defaultLabels("Username:", DefaultComponents.fontTextLabel, 100, 320, 100, 30));
        pnlLogin.add(DefaultComponents.defaultLabels("Password:", DefaultComponents.fontTextLabel, 100, 390, 100, 30));
    }

    @Override
    public void buttons() {
        JButton btnRegister = DefaultComponents.defaultButton("Register", DefaultComponents.secundaryColor, 175, 700, 150, 35);
        btnRegister.setContentAreaFilled(false);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Register();
            }
        });

        JButton btnLogin = DefaultComponents.defaultButton("Enter", new Color(0, 255, 127), 125, 500, 250, 35);
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    controller.validCredentials(txfUsername.getText(), pwdPassword.getText());
                    controller.searchCredentials(txfUsername.getText(), pwdPassword.getText());
                    dispose();
                    new Recycling();
                    JOptionPane.showMessageDialog(null, "Successfully logged in", "RecyclingPoint", JOptionPane.INFORMATION_MESSAGE);
                } catch (UserNotFound | FieldValueNotInformed ex) {
                    JOptionPane.showMessageDialog(null, ex.getMessage(), "RecyclingPoint", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        pnlLogin.add(btnRegister);
        pnlLogin.add(btnLogin);
    }

    @Override
    public void fields() {
        txfUsername = DefaultComponents.defaultFields(100, 350);
        txfUsername.setSize(300, 35);
        pwdPassword = DefaultComponents.defaultFieldsPassword(100, 425);
        pwdPassword.setSize(300, 35);

        pnlLogin.add(txfUsername);
        pnlLogin.add(pwdPassword);
    }

}
