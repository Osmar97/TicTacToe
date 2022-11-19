import javax.swing.*;
import javax.tools.Tool;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicTacToe extends Quadro {
    private JLabel vitoriasX;
    private JLabel derrotasX;
    private JLabel vitoriasO;
    private JLabel derrotasO;
    private JLabel vez;
    public JPanel mainPanel;
    private JButton sairButton;
    private JButton reiniciarButton;
    private JPanel btnPanel;

     JButton [] buttons;
    public TicTacToe(int tabuleiro, String vezDe) {


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
                TicTacToe.super.mudarQuadro("Definições",tabuleiro,vezDe);


            }
        });
    }







}
