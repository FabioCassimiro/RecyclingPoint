/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.recycling.viewer;

import br.com.recycling.utils.ClassInterface;
import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JProgressBar;

/**
 *
 * @author WINDOWS
 */
public class Loading extends JFrame implements ClassInterface {

    DefaultComponents components = new DefaultComponents();
    DefaultPanel pnlLoading = new DefaultPanel();
    JLabel loadingMessage;
    JLabel trashCan;

    public Loading() {
        panelInit();
        setSize(500, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void panelInit() {
        add(pnlLoading);
        labels();
        fields();
        buttons();
        components.image(pnlLoading);

    }

    @Override
    public void labels() {
        loadingMessage = DefaultComponents.defaultLabels("Loading", DefaultComponents.fontTextLabel, 50, 420, 300, 30);
        trashCan = DefaultComponents.defaultLabels("", null, 195, 200, 110, 160);
        trashCan.setIcon(components.searchImage("lataVidro.png")); //provisorio
        
        pnlLoading.add(loadingMessage);
        pnlLoading.add(trashCan);

    }

    @Override
    public void fields() {
        JProgressBar pgbLoading = new JProgressBar(0,100);
        pgbLoading.setValue(50);//provisorio
        pgbLoading.setBorder(null);
        pgbLoading.setBackground(DefaultComponents.secundaryColor);
        pgbLoading.setForeground(Color.WHITE);
        
        pgbLoading.setBounds(50, 450, 400, 50);
        
        pnlLoading.add(pgbLoading);
    }

    @Override
    public void buttons() {
        JButton btnNext = DefaultComponents.defaultButton("Next", DefaultComponents.secundaryColor, 175, 700, 150, 35);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Colocar a ação ir para a tela de resultados
            }
        });
        
        pnlLoading.add(btnNext);
    }

}
