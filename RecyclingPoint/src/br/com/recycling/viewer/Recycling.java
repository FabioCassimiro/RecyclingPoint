package br.com.recycling.viewer;

import br.com.recycling.utils.ClassInterface;
import br.com.recycling.utils.DefaultComponents;
import br.com.recycling.utils.DefaultPanel;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author Fabio Cassimiro
 */
public class Recycling extends JFrame implements ClassInterface {

    DefaultComponents components = new DefaultComponents();
    DefaultPanel pnlRecycling = new DefaultPanel();
    JLabel imgItem;
    JPanel panel;
    JComboBox cmbItems;
    JSpinner spnAmount;

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
        String[] items = {"Select Item","Glass Bottle","Plastic Bottle","Plastic Cap","Aluminum Cap","Cardboard Roll","Aluminum Can"};
        cmbItems = new JComboBox(items);
        cmbItems.setFont(new Font("Arial",Font.BOLD,15));
        cmbItems.setForeground(DefaultComponents.secundaryColor);
        cmbItems.setBounds(125, 525, 250, 35);
        cmbItems.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                displaysImages();
            }
        });

        spnAmount = new JSpinner(new SpinnerNumberModel(0, 0, 10, 1));
        spnAmount.setBounds(215, 575, 70, 60);
        spnAmount.setBorder(null);
        spnAmount.setFont(new Font("Arial", Font.BOLD, 35));

        pnlRecycling.add(spnAmount);
        pnlRecycling.add(cmbItems);
    }

    @Override
    public void buttons() {
        JButton btnRecycling = DefaultComponents.defaultButton("", Color.WHITE, 210, 675, 80, 80);
        btnRecycling.setContentAreaFilled(false);
        btnRecycling.setIcon(components.searchImage("Recycling.png"));

        pnlRecycling.add(btnRecycling);
    }

    public void panel() {
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(Color.WHITE);
        panel.setBounds(75, 60, 350, 450);
        imgItem = DefaultComponents.defaultLabels("", null,0, 0, 320, 350);
        panel.add(imgItem);
        
        pnlRecycling.add(panel);
    }
    
    public void displaysImages(){
        if(!String.valueOf(cmbItems.getSelectedItem()).equals("Select Item")){
            imgItem.setIcon(components.searchImage(String.valueOf(cmbItems.getSelectedItem()+ ".jpeg")));   
        }else{
            imgItem.setIcon(null);
        } 
    }
    
    public void recycling(){
        
    }

    

}
