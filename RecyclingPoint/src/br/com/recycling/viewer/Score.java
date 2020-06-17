package br.com.recycling.viewer;

import br.com.recycling.controller.ControllerRecycling;
import br.com.recycling.utils.ClassInterface;
import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

/**
 *
 * @author Fabio Cassimiro
 */

public class Score extends JFrame implements ClassInterface {

    private DefaultPanel pnlScore = new DefaultPanel();
    private DefaultComponents components = new DefaultComponents();
    private JLabel trashCan;
    private JLabel lblItem;
    private JLabel lblScore;

    public Score() {
        panelInit();
        setSize(500, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void panelInit() {
        pnlScore.add(DefaultComponents.montaBtnMinimizar(this));
        add(pnlScore);
        labels();
        buttons();
        fields();
        components.image(pnlScore);

    }

    @Override
    public void labels() {
        pnlScore.add(DefaultComponents.defaultLabels("Congratulations on your beautiful attitude.", new Font("Arial", Font.BOLD, 20), 45, 650, 405, 30));
        pnlScore.add(DefaultComponents.defaultLabels("Generated Score:", new Font("Arial", Font.BOLD, 30), 120, 100, 255, 35));
        pnlScore.add(DefaultComponents.defaultLabels("Item:", new Font("Arial", Font.BOLD, 30), 210, 250, 80, 35));
        pnlScore.add(DefaultComponents.defaultLabels("Trash Can:", new Font("Arial", Font.BOLD, 30), 165, 370, 170, 35));

        lblScore = DefaultComponents.defaultLabels(ControllerRecycling.finalValues.get(2), new Font("Arial", Font.BOLD, 30), 215, 140, 100, 35);
        lblItem = DefaultComponents.defaultLabels(ControllerRecycling.finalValues.get(0), new Font("Arial", Font.BOLD, 25), 160, 290, 180, 27);
        lblItem.setForeground(DefaultComponents.secundaryColor);

        trashCan = DefaultComponents.defaultLabels("", null, 195, 410, 110, 160);
        trashCan.setIcon(components.searchImage(ControllerRecycling.finalValues.get(1) + ".png"));

        pnlScore.add(trashCan);
        pnlScore.add(lblItem);
        pnlScore.add(lblScore);
    }

    @Override
    public void fields() {
    }

    @Override
    public void buttons() {
        JButton btnNext = DefaultComponents.defaultButton("Next", DefaultComponents.secundaryColor, 175, 700, 150, 35);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new FinalThanks();

            }
        });

        pnlScore.add(btnNext);
    }
}
