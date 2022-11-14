import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class Settings extends Jogo {

    private JLabel PLAYERS;
    public JPanel mainPanel;

    static JFrame frame;
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
        super.setTabuleiro(9);

         comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
                String size = (String)cb.getSelectedItem();
                int tabuleiro=(int)Math.pow(Integer.parseInt(String.valueOf(size.charAt(0))),2);
                Settings.super.setTabuleiro(tabuleiro);
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(frame!=null) {
                    frame.setVisible(false);
                    frame.dispose();
                }

                frame = new JFrame("TicTacToe");
                frame.setVisible(false);
                frame.dispose();
                Toolkit tk=Toolkit.getDefaultToolkit();
                int xSize=(int ) tk.getScreenSize().getWidth();
                int ySize= (int) tk.getScreenSize().getHeight();
                frame.setSize(xSize,ySize-50);
                frame.setContentPane(new TicTacToe(Settings.super.getTabuleiro(),"x").mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }



    public static void main(String[] args) {

        frame = new JFrame("Definições");
        frame.setContentPane(new Settings().mainPanel);
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xSize=(int ) tk.getScreenSize().getWidth();
        int ySize= (int) tk.getScreenSize().getHeight();
        frame.setSize(xSize,ySize-50);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);

     }

}
