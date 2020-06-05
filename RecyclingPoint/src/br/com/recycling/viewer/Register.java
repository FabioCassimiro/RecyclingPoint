package br.com.recycling.viewer;

import br.com.recycling.controller.ControllerRegister;
import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

/**
 *
 * @author Fabio Cassimiro
 */
public class Register extends JFrame {

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

    public Register() {
        
        panelRegisterInit();
        setSize(500, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);

    }

    public void panelRegisterInit() {
        add(pnlRegister);
        fields();
        labels();
        buttons();
        components.image(pnlRegister);
    }

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

    public void labels() {
        pnlRegister.add(DefaultComponents.defaultLabels("Recycling", new Font("Arial", Font.BOLD, 40), 150, 20, 200, 45));
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
        JButton btnRegister = DefaultComponents.defaultButton("Register", DefaultComponents.secundaryColor, 175, 700, 150, 35);
        btnRegister.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Colocar a ação de salvar cadastro
            }
        });

        JButton btnLockerSearch = DefaultComponents.defaultButton("", Color.WHITE, 370, 120, 35, 35);
        btnLockerSearch.setIcon(components.searchImage("openlock.png"));
        btnLockerSearch.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Colocar ação da troca de cadeado
            }
        });
        pnlRegister.add(btnRegister);
        pnlRegister.add(btnLockerSearch);
    }

}
