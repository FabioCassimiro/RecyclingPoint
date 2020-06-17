package br.com.recycling.viewer;

import br.com.recycling.controller.ControllerRecycling;
import br.com.recycling.exception.FieldValueNotInformed;
import br.com.recycling.exception.MinimumQuantityOfFieldNotReported;
import br.com.recycling.utils.ClassInterface;
import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Fabio Cassimiro
 */
public class Recycling extends JFrame implements ClassInterface {

    private DefaultComponents components = new DefaultComponents();
    private DefaultPanel pnlRecycling = new DefaultPanel();
    private ControllerRecycling controller = new ControllerRecycling();
    private JLabel imgItem;
    private JPanel panelItem;
    private JComboBox cmbItems;
    private JSpinner spnQuantity;

    public Recycling() {
        panelInit();
        setSize(500, 800);
        setLocationRelativeTo(null);
        setUndecorated(true);
        setVisible(true);
    }

    @Override
    public void panelInit() {
        pnlRecycling.add(DefaultComponents.montaBtnMinimizar(this));
        add(pnlRecycling);
        labels();
        buttons();
        fields();
        panelItem();
        components.image(pnlRecycling);
    }

    @Override
    public void labels() {
    }

    @Override
    public void fields() {
        String[] items = {"Select Item", "Glass Bottle", "Plastic Bottle", "Plastic Cap", "Aluminum Cap", "Cardboard Roll", "Aluminum Can"};
        cmbItems = new JComboBox(items);
        cmbItems.setFont(new Font("Arial", Font.BOLD, 15));
        cmbItems.setForeground(DefaultComponents.secundaryColor);
        cmbItems.setBounds(125, 525, 250, 35);
        cmbItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaysImages();
            }
        });

        spnQuantity = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        spnQuantity.setBounds(215, 575, 70, 60);
        spnQuantity.setBorder(null);
        spnQuantity.setFont(new Font("Arial", Font.BOLD, 35));

        pnlRecycling.add(spnQuantity);
        pnlRecycling.add(cmbItems);
    }

    @Override
    public void buttons() {
        JButton btnRecycling = DefaultComponents.defaultButton("", Color.WHITE, 210, 675, 80, 80);
        btnRecycling.setContentAreaFilled(false);
        btnRecycling.setIcon(components.searchImage("Recycling.png"));
        btnRecycling.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    validRecycling();
                    recycling();
                    dispose();
                    new Loading();
                } catch (FieldValueNotInformed ex) {
                    Logger.getLogger(Recycling.class.getName()).log(Level.SEVERE, null, ex);
                }

            }
        });

        pnlRecycling.add(btnRecycling);
    }

    public void panelItem() {
        panelItem = new JPanel();
        panelItem.setLayout(null);
        panelItem.setBackground(Color.WHITE);
        panelItem.setBounds(75, 60, 350, 450);
        imgItem = DefaultComponents.defaultLabels("", null, 15, 50, 320, 350);
        panelItem.add(imgItem);

        pnlRecycling.add(panelItem);
    }

    public void displaysImages() {
        if (!String.valueOf(cmbItems.getSelectedItem()).equals("Select Item")) {
            imgItem.setIcon(components.searchImage(String.valueOf(cmbItems.getSelectedItem() + ".png")));
        } else {
            imgItem.setIcon(null);
        }
    }

    public void validRecycling() throws FieldValueNotInformed {
        try {
            controller.validItem(String.valueOf(cmbItems.getSelectedItem()));
            controller.validValue(String.valueOf(spnQuantity.getValue()));
        } catch (FieldValueNotInformed | MinimumQuantityOfFieldNotReported ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "RecyclingPoint", JOptionPane.WARNING_MESSAGE);
            throw new FieldValueNotInformed("it was not possible to recycle");
        }
    }

    public void recycling() {
        try {
            controller.Recycling(String.valueOf(cmbItems.getSelectedItem()), String.valueOf(spnQuantity.getValue()));
        } catch (FieldValueNotInformed ex) {
            JOptionPane.showMessageDialog(null, ex.getMessage(), "RecyclingPoint", JOptionPane.WARNING_MESSAGE);
        }
    }

}
