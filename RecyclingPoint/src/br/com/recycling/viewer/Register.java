package br.com.recycling.viewer;

import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author WINDOWS
 */
public class Register extends JFrame {
    public boolean enableFields = true;
    DefaultPanel pnlRegister = new DefaultPanel();
    JTextField txfCPF;
    JTextField txfName;
    JTextField txfLastName;
    JTextField txfEmailAddress;
    JTextField txfUsername;
    JPasswordField pwdPassword;
    JPasswordField pwdConfirmPassword;

    public Register() {
        panelRegister();
        add(pnlRegister);
        setSize(500, 800);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

    }

    public void panelRegister() {
        fields();
        labels();
        buttons();

        //pnlRegister.add(nome);
    }

    public void fields() {
        txfCPF = new JFormattedTextField(DefaultComponents.mask("###.###.###-##"));
        txfCPF.setBounds(140, 120, 220, 35);
        txfCPF.setFont(DefaultComponents.fontTextFields);
        txfCPF.setBackground(Color.WHITE);
        txfCPF.setForeground(DefaultComponents.secundaryColor);
        txfCPF.setBorder(null);

        txfName = DefaultComponents.defaultFields(30, 215);
        txfName.setEnabled(enableFields);
        txfLastName = DefaultComponents.defaultFields(30, 290);
        txfLastName.setEnabled(enableFields);
        txfEmailAddress = DefaultComponents.defaultFields(30, 365);
        txfEmailAddress.setEnabled(enableFields);
        txfUsername = DefaultComponents.defaultFields(30, 440);
        txfUsername.setEnabled(enableFields);
        pwdPassword = DefaultComponents.defaultFieldsPassword(30, 515);
        pwdPassword.setEnabled(enableFields);
        pwdConfirmPassword = DefaultComponents.defaultFieldsPassword(30, 590);

        pnlRegister.add(txfCPF);
        pnlRegister.add(txfName);
        pnlRegister.add(txfLastName);
        pnlRegister.add(txfEmailAddress);
        pnlRegister.add(txfUsername);
        pnlRegister.add(pwdPassword);
        pnlRegister.add(pwdConfirmPassword);
    }

    public void labels() {
        pnlRegister.add(DefaultComponents.defaultLabels("CPF:", DefaultComponents.fontTextLabel, 90, 120, 60, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Name:", DefaultComponents.fontTextLabel, 30, 185, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Last Name:", DefaultComponents.fontTextLabel, 30, 260, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Email:", DefaultComponents.fontTextLabel, 30, 335, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Username:", DefaultComponents.fontTextLabel, 30, 410, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Password:", DefaultComponents.fontTextLabel, 30, 485, 100, 30));
        pnlRegister.add(DefaultComponents.defaultLabels("Confirm Password:", DefaultComponents.fontTextLabel, 30, 560, 200, 30));
    }

    public void buttons() {
        DefaultComponents components = new DefaultComponents();
        JButton btnCadastrar = DefaultComponents.defaultButton("Register", DefaultComponents.secundaryColor, 175, 700, 150, 35);
        JButton btnLockerSearch = DefaultComponents.defaultButton("", Color.WHITE, 370, 120, 35, 35);
        btnLockerSearch.setIcon(components.searchImage("openlock.png"));
        btnLockerSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (txfCPF.isEnabled() == true) {
                    btnLockerSearch.setIcon(components.searchImage("locked.png"));
                    txfCPF.setEnabled(false);
                } else {
                    btnLockerSearch.setIcon(components.searchImage("openlock.png"));
                    txfCPF.setEnabled(true);
                }

            }
        });
        pnlRegister.add(btnCadastrar);
        pnlRegister.add(btnLockerSearch);
    }

}
