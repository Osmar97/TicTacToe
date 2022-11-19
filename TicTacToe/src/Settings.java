import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings extends Quadro {

    private JLabel PLAYERS;
    public JPanel mainPanel;

    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton startButton;
    private JRadioButton normalRadioButton;
    private JRadioButton randomTurnRadioButton;
    private JRadioButton misereRadioButton;


    public Settings() {

        ButtonGroup group = new ButtonGroup();

        group.add(misereRadioButton);
        group.add(randomTurnRadioButton);
        group.add(normalRadioButton);

        String[] tabulSizes = { "3x3", "4x4", "5x5", "6x6", "7x7", "8x8", "9x9" };
        for (int i=0;i<tabulSizes.length;i++){
            comboBox1.addItem(tabulSizes[i]);
        }

        mainPanel.setSize(1650,1080);

        comboBox1.setSelectedIndex(0);
        final int[] tabuleiro = {9};
        final String[] vezDe = {new String()};

         comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String size = (String)cb.getSelectedItem();
                tabuleiro[0] =(int)Math.pow(Integer.parseInt(String.valueOf(size.charAt(0))),2);
             }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Settings.super.mudarQuadro("TicTacToe", tabuleiro[0], vezDe[0]);

            }
        });
    }






}
