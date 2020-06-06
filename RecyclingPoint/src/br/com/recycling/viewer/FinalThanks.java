package br.com.recycling.viewer;

import br.com.recycling.utils.ClassInterface;
import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;

/**
 *
 * @author WINDOWS
 */
public class FinalThanks extends JFrame implements ClassInterface{
    DefaultPanel pnlFinalThanks = new DefaultPanel();
    DefaultComponents components = new DefaultComponents();

    public FinalThanks() {
        panelInit();
        setSize(500, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void panelInit() {
        add(pnlFinalThanks);
        labels();
        buttons();
        fields();
        components.image(pnlFinalThanks);
    }

    @Override
    public void labels() {
        pnlFinalThanks.add(DefaultComponents.defaultLabels("Thank you very much!", new Font("Arial", Font.BOLD, 42), 25, 220, 450, 45));
        pnlFinalThanks.add(DefaultComponents.defaultLabels("From: Planet", new Font("Arial", Font.PLAIN, 25), 300, 260, 200, 30));
        pnlFinalThanks.add(DefaultComponents.defaultLabels("Want to continue recycling?", new Font("Arial", Font.BOLD, 25), 80, 450, 340, 30));
    }

    @Override
    public void fields() {
    }

    @Override
    public void buttons() {
        JButton btnContinue = DefaultComponents.defaultButton("Yes I want", DefaultComponents.secundaryColor, 175, 500, 150, 35);
        btnContinue.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Colocar a ação ir para a tela de resultados
            }
        });
        
        JButton btnExit = DefaultComponents.defaultButton("Exit", Color.RED, 300, 720, 150, 35);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //Colocar a ação ir para a tela de resultados
            }
        });
        
        pnlFinalThanks.add(btnExit);
        
        pnlFinalThanks.add(btnContinue);
    }
    
    
}
