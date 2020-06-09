package br.com.recycling.viewer;

import br.com.recycling.controller.ControllerRecycling;
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
 * @author Fabio Cassimiro
 */
public class Loading extends JFrame implements ClassInterface {

    private DefaultComponents components = new DefaultComponents();
    private DefaultPanel pnlLoading = new DefaultPanel();
    private JLabel loadingMessage;
    private JLabel trashCan;
    private JLabel imageItem;
    private JLabel imageRecycling;
    private JProgressBar pgbLoading;
    private JButton btnNext;

    public Loading() {
        panelInit();
        loadingBar();
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
        loadingMessage = DefaultComponents.defaultLabels("", DefaultComponents.fontTextLabel, 50, 420, 300, 30);
        trashCan = DefaultComponents.defaultLabels("", null, 340, 200, 110, 160);
        imageItem = DefaultComponents.defaultLabels("", null, 60, 200, 110, 160);
        imageRecycling = DefaultComponents.defaultLabels("", null, 202, 250, 96, 96);

        pnlLoading.add(loadingMessage);
        pnlLoading.add(trashCan);
        pnlLoading.add(imageItem);
        pnlLoading.add(imageRecycling);
    }

    @Override
    public void fields() {
        pgbLoading = new JProgressBar(0, 100);
        pgbLoading.setBorder(null);
        pgbLoading.setBackground(DefaultComponents.secundaryColor);
        pgbLoading.setForeground(Color.WHITE);
        pgbLoading.setBounds(50, 450, 400, 50);

        pnlLoading.add(pgbLoading);
    }

    @Override
    public void buttons() {
        btnNext = DefaultComponents.defaultButton("Next", DefaultComponents.secundaryColor, 175, 700, 150, 35);
        btnNext.setVisible(false);
        btnNext.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new Score();
            }
        });

        pnlLoading.add(btnNext);
    }

    public void loadingWords(int index) {
        String[] words = {"Loading", "Choosing", "Processing", "Recycling", "Finished"};
        loadingMessage.setText(words[index]);
    }

    public void setTrashCan() {
        trashCan.setIcon(components.searchImage(ControllerRecycling.finalValues.get(1) + ".png"));
    }

    public void setImageItem() {
        imageItem.setIcon(components.searchImage(ControllerRecycling.finalValues.get(0) + "-Small.png"));
    }

    public void setImageRecycling() {
        imageRecycling.setIcon(components.searchImage("Recycling.png"));
    }

    public void loading(int index) {
        try {
            pgbLoading.setValue(index);
            Thread.sleep(50);

            switch (index) {
                case 0:
                    loadingWords(0);
                    
                    break;
                case 30:
                    loadingWords(1);
                    setImageItem();
                    break;
                case 60:
                    loadingWords(2);
                    setTrashCan();
                    break;
                case 80:
                    loadingWords(3);
                    setImageRecycling();
                    break;
                case 100:
                    loadingWords(4);
                    btnNext.setVisible(true);
                    break;
            }
        } catch (InterruptedException ex) {
        }
    }

    public void loadingBar() {
        Thread loading = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i <= 100; i++) {
                    loading(i);
                }
            }
        });
        loading.start();
    }

}
