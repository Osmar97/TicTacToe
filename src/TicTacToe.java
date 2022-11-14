import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends Jogo {
    private JLabel vitoriasX;
    private JLabel derrotasX;
    private JLabel vitoriasO;
    private JLabel derrotasO;
    private JLabel vez;
    public JPanel mainPanel;
    private JButton sairButton;
    private JButton reiniciarButton;
    private JPanel btnPanel;

    static JFrame frame;
    int tabuleiro;
    String vezDe;
    JButton [] buttons;
    public TicTacToe(int tabuleiro, String vezDe) {


        this.tabuleiro = tabuleiro;
        this.vezDe = vezDe;

        buttons = new JButton[tabuleiro];
        int lxc=(int)Math.sqrt(tabuleiro);

        btnPanel.setLayout(new GridLayout(lxc,lxc));
        btnPanel.setBackground(new Color(255,255,255));
        vez.setText("VEZ DO JOGADOR: "+ vezDe);

         for(int i=0;i<tabuleiro;i++) {

            buttons[i] = new JButton();
            btnPanel.add(buttons[i]);
            buttons[i].setFont(new Font("Pepsi",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].setBorder(BorderFactory.createLineBorder(new Color(80, 80, 77), 3));
            buttons[i].setBackground(new Color(255, 255, 255));

        }


        sairButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(frame!=null) {
                    frame.setVisible(false);
                    frame.dispose();
                }

                frame = new JFrame("Definições");
                frame.setVisible(false);
                frame.dispose();

                Toolkit tk=Toolkit.getDefaultToolkit();
                int xSize=(int ) tk.getScreenSize().getWidth();
                int ySize= (int) tk.getScreenSize().getHeight();
                frame.setSize(xSize,ySize-50);
                frame.setContentPane(new Settings().mainPanel);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                frame.setVisible(true);
            }
        });
    }



    public static void main(String[] args) {
        Toolkit tk=Toolkit.getDefaultToolkit();
        int xSize=(int ) tk.getScreenSize().getWidth();
        int ySize= (int) tk.getScreenSize().getHeight();
        frame = new JFrame("TicTacToe");
        frame.setAlwaysOnTop(true);
        frame.setSize(xSize,ySize);
        frame.setContentPane(new TicTacToe(25,"x").mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.pack();
        frame.setVisible(true);
    }
}
