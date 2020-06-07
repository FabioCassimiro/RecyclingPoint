package br.com.recycling.viewer;

import br.com.recycling.controller.ControllerRegister;
import br.com.recycling.exception.FieldValueNotInformed;
import br.com.recycling.exception.InvalidEmailAddress;
import br.com.recycling.exception.InvalidRegistration;
import br.com.recycling.exception.PasswordsDontMatch;
import br.com.recycling.exception.RegisteredUserException;
import br.com.recycling.utils.ClassInterface;
import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Fabio Cassimiro
 */
public class Register extends JFrame implements ClassInterface {

    public boolean enableFields = true;
    DefaultPanel pnlRegister = new DefaultPanel();
    ControllerRegister controller = new ControllerRegister();
    DefaultComponents components = new DefaultComponents();
    JTextField txfCPF;
    JTextField txfName;
    JTextField txfLastName;
    JTextField txfEmailAddress;
    JTextField txfUsername;
    JPasswordField pwdPassword;
    JPasswordField pwdConfirmPassword;
    JButton btnLockerSearch;

    public Register() {

        panelInit();
        setSize(500, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

    }

    @Override
    public void panelInit() {
        add(pnlRegister);
        fields();
        labels();
        buttons();
        components.image(pnlRegister);
    }

    @Override
    public void fields() {
        txfCPF = new JFormattedTextField(DefaultComponents.mask("###.###.###-##"));
        txfCPF.setBounds(140, 120, 220, 35);
        txfCPF.setFont(DefaultComponents.fontTextFields);
        txfCPF.setBackground(Color.WHITE);
        txfCPF.setForeground(DefaultComponents.secundaryColor);
        txfCPF.setBorder(null);

        txfName = DefaultComponents.defaultFields(30, 215);
        txfLastName = DefaultComponents.defaultFields(30, 290);
        txfEmailAddress = DefaultComponents.defaultFields(30, 365);
        txfUsername = DefaultComponents.defaultFields(30, 440);
        pwdPassword = DefaultComponents.defaultFieldsPassword(30, 515);
        pwdConfirmPassword = DefaultComponents.defaultFieldsPassword(30, 590);

        pnlRegister.add(txfCPF);
        pnlRegister.add(txfName);
        pnlRegister.add(txfLastName);
        pnlRegister.add(txfEmailAddress);
        pnlRegister.add(txfUsername);
        pnlRegister.add(pwdPassword);
        pnlRegister.add(pwdConfirmPassword);
    }

    @Override
    public void labels() {
        pnlRegister.add(DefaultComponents.defaultLabels("CPF:", DefaultComponents.fontTextLabel, 90, 120, 60, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Name:", DefaultComponents.fontTextLabel, 30, 185, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Last Name:", DefaultComponents.fontTextLabel, 30, 260, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Email:", DefaultComponents.fontTextLabel, 30, 335, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Username:", DefaultComponents.fontTextLabel, 30, 410, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Password:", DefaultComponents.fontTextLabel, 30, 485, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Confirm Password:", DefaultComponents.fontTextLabel, 30, 560, 200, 30));
    }

    @Override
    public void buttons() {
        JButton btnRegister = DefaultComponents.defaultButton("Register", DefaultComponents.secundaryColor, 175, 700, 150, 35);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createUser();
            }
        });

        btnLockerSearch = DefaultComponents.defaultButton("", Color.WHITE, 370, 120, 35, 35);
        btnLockerSearch.setIcon(components.searchImage("openlock.png"));
        btnLockerSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                verifyCPFUser();
            }
        });
        pnlRegister.add(btnRegister);
        pnlRegister.add(btnLockerSearch);
    }
    
    

    public void veriftUser() throws InvalidRegistration {
        try {
            controller.validNameLastname(txfName.getText(), txfLastName.getText());
            controller.validEmailAddress(txfEmailAddress.getText());
            controller.UserRegistered(txfUsername.getText());
            controller.validPassword(pwdPassword.getText(), pwdConfirmPassword.getText());
        } catch (RegisteredUserException | InvalidEmailAddress | PasswordsDontMatch | FieldValueNotInformed ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(),"RecyclingPoint",JOptionPane.WARNING_MESSAGE);
            throw new InvalidRegistration("Error when registering");
        }

    }

    public void createUser() {

        try {
            veriftUser();
            String[] informations = {txfCPF.getText(), txfName.getText(), txfLastName.getText(),
                "", txfUsername.getText(), pwdPassword.getText(), "06/06"};
            controller.createUser(informations);
            dispose();
            new Login();
        } catch (InvalidRegistration ex) {
            Logger.getLogger(Register.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void verifyCPFUser() {

        if (!txfCPF.getText().equals("   .   .   -  ")) {

            try {

                if (btnLockerSearch.getIcon().toString().endsWith("openlock.png")) {
                    controller.CPFRegistered(txfCPF.getText());
                    txfCPF.setEnabled(false);
                    btnLockerSearch.setIcon(components.searchImage("locked.png"));
                } else if (btnLockerSearch.getIcon().toString().endsWith("locked.png") && JOptionPane.showConfirmDialog(null,
                        "Exit", "RecyclingPoint", JOptionPane.YES_OPTION) == 0) {
                    txfCPF.setEnabled(true);
                    txfCPF.setText("");
                    btnLockerSearch.setIcon(components.searchImage("openlock.png"));
                }

            } catch (RegisteredUserException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage(), "RecyclingPoint", JOptionPane.ERROR_MESSAGE);

            }

        } else {
            JOptionPane.showMessageDialog(null, "Inform your CPF", "RecyclingPoint", JOptionPane.WARNING_MESSAGE);
        }
    }
}
