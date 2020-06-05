package br.com.recycling.viewer;

import br.com.recycling.utils.ClassInterface;
import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JSpinner;

/**
 *
 * @author Fabio Cassimiro
 */
public class Recycling extends JFrame implements ClassInterface {

    DefaultComponents components = new DefaultComponents();
    DefaultPanel pnlRecycling = new DefaultPanel();

    public Recycling() {
        panelInit();
        setSize(500, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void panelInit() {
        add(pnlRecycling);
        labels();
        buttons();
        fields();
        panel();
        components.image(pnlRecycling);
    }

    @Override
    public void labels() {
    }

    @Override
    public void fields() {
        JComboBox cmbItems = new JComboBox();
        cmbItems.setBounds(125, 525, 250, 35);

        JSpinner spnAmount = new JSpinner();
        spnAmount.setBounds(215, 575, 70, 60);
        spnAmount.setBorder(null);
        spnAmount.setFont(new Font("Arial", Font.BOLD, 35));

        pnlRecycling.add(spnAmount);
        pnlRecycling.add(cmbItems);
    }

    @Override
    public void buttons() {
        JButton btnRecycling = DefaultComponents.defaultButton("", Color.WHITE, 210, 675, 80, 80);
        btnRecycling.setIcon(components.searchImage("Recycling.png"));

        pnlRecycling.add(btnRecycling);
    }

    public void panel() {
        JPanel panel = new JPanel();
        panel.setBackground(Color.WHITE);
        panel.setBounds(75, 60, 350, 450);
        pnlRecycling.add(panel);
    }

}
