package br.com.recycling.viewer;

import br.com.recycling.model.ConsultDAO;
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

/**
 *
 * @author Fabio Cassimiro
 */
public class FinalThanks extends JFrame implements ClassInterface {

    private DefaultPanel pnlFinalThanks = new DefaultPanel();
    private DefaultComponents components = new DefaultComponents();

    public FinalThanks() {
        panelInit();
        setSize(500, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void panelInit() {
        pnlFinalThanks.add(DefaultComponents.montaBtnMinimizar(this));
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
        pnlFinalThanks.add(DefaultComponents.defaultLabels("New Score: "+ConsultDAO.consultScore(), new Font("Arial", Font.BOLD, 25), 137, 100, 210, 30));
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
                dispose();
                new Recycling();
            }
        });

        JButton btnExit = DefaultComponents.defaultButton("Exit", Color.RED, 300, 720, 150, 35);
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (JOptionPane.showConfirmDialog(null, "Do you really want to leave?", "RecyclingPoint", JOptionPane.YES_OPTION, JOptionPane.QUESTION_MESSAGE) == 0) {
                    System.exit(0);
                }
            }
        });

        pnlFinalThanks.add(btnExit);
        pnlFinalThanks.add(btnContinue);
    }

}
