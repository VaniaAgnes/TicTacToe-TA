import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;


public class TicTacToe implements ActionListener {
    Random randomizer = new Random();
    JFrame frames = new JFrame();
    JPanel panel_title = new JPanel();
    JButton hold_button = new JButton();
    JLabel label = new JLabel();
    // it's 9 because tictactoe has 9 squares
    JButton[] buttons = new JButton[9];
    boolean player1_turn;
    TicTacToe(){
        frames.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frames.setSize(700,700);
        frames.getContentPane().setBackground(new Color(50,50,50));
        frames.setLayout(new BorderLayout());
        frames.setVisible(true);

        label.setBackground(new Color(0,0,0));
        label.setForeground(new Color(220,208,255));
        label.setFont(new Font("Serif",Font.BOLD, 80));
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setText("Tic Tac Toe");
        label.setOpaque(true);

        panel_title.setLayout(new BorderLayout());
        panel_title.setBounds(0,0,700,100);

        hold_button.setLayout((new GridLayout(3,3)));
        hold_button.setBackground(new Color(255,255,255));

        for(int i=0; i < 9; i++){
            buttons[i] = new JButton();
            hold_button.add(buttons[i]);
            buttons[i].setFont(new Font("Serif", Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }

        panel_title.add(label);
        frames.add(panel_title, BorderLayout.NORTH);
        frames.add(hold_button);

        firstTurn();

    }
    @Override
    public void actionPerformed(ActionEvent b){
        for (int i = 0;i < 9;i++){
            if(b.getSource()==buttons[i]){
                if(player1_turn){
                    if (buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,192,203));
                        buttons[i].setText("X");
                        player1_turn = false;
                        label.setText("O's Turn");
                        checks();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(177,156,217));
                        buttons[i].setText("O");
                        player1_turn = true;
                        label.setText("X's Turn");
                        checks();
                    }
                }
            }
        }

    }
// method that will determine who's turn is first :)
    public void firstTurn(){

        try{
            Thread.sleep(2000);
        } catch (InterruptedException f){
            f.printStackTrace();
        }

        if(randomizer.nextInt(2)==0){
            player1_turn = true;
            label.setText("X's turn");
        }
        else {
            player1_turn = false;
            label.setText("O's turn");
        }
    }
    // to see the winning conditions
    public void checks() {
        // checks the winning condition of X
        if (
           (buttons[0].getText()=="X") &&
           (buttons[1].getText()=="X") &&
           (buttons[2].getText()=="X")
           ) {
            winsOfx(0,1,2);
        }
        if (
           (buttons[3].getText()=="X") &&
           (buttons[4].getText()=="X") &&
           (buttons[5].getText()=="X")
           ) {
            winsOfx(3,4,5);
        }
        if (
           (buttons[6].getText()=="X") &&
           (buttons[7].getText()=="X") &&
           (buttons[8].getText()=="X")
           ) {
            winsOfx(6,7,8);
        }


        if (
           (buttons[0].getText()=="X") &&
           (buttons[3].getText()=="X") &&
           (buttons[6].getText()=="X")
           ) {
            winsOfx(0,3,6);
        }
        if (
           (buttons[1].getText()=="X") &&
           (buttons[4].getText()=="X") &&
           (buttons[7].getText()=="X")
           ) {
            winsOfx(1,4,7);
        }
        if (
           (buttons[2].getText()=="X") &&
           (buttons[5].getText()=="X") &&
           (buttons[8].getText()=="X")
           ) {
            winsOfx(2,5,8);
        }
        if (
           (buttons[0].getText()=="X") &&
           (buttons[4].getText()=="X") &&
           (buttons[8].getText()=="X")
           ) {
            winsOfx(0,4,8);
        }
        if (
           (buttons[2].getText()=="X") &&
           (buttons[4].getText()=="X") &&
           (buttons[6].getText()=="X")
           ) {
            winsOfx(2,4,6);
        }
        if (
           (buttons[0].getText()=="O") &&
           (buttons[1].getText()=="O") &&
           (buttons[2].getText()=="O")
           ) {
            winsOfo(0,1,2);
        }
        if (
           (buttons[3].getText()=="O") &&
           (buttons[4].getText()=="O") &&
           (buttons[5].getText()=="O")
           ) {
            winsOfo(3,4,5);
        }
        if (
           (buttons[6].getText()=="O") &&
           (buttons[7].getText()=="O") &&
           (buttons[8].getText()=="O")
           ) {
            winsOfo(6,7,8);
        }


        if (
           (buttons[0].getText()=="O") &&
           (buttons[3].getText()=="O") &&
           (buttons[6].getText()=="O")
           ) {
            winsOfo(0,3,6);
        }
        if (
           (buttons[1].getText()=="O") &&
           (buttons[4].getText()=="O") &&
           (buttons[7].getText()=="O")
           ) {
            winsOfo(1,4,7);
        }
        if (
           (buttons[2].getText()=="O") &&
           (buttons[5].getText()=="O") &&
           (buttons[8].getText()=="O")
           ) {
            winsOfo(2,5,8);
        }
        if (
           (buttons[0].getText()=="O") &&
           (buttons[4].getText()=="O") &&
           (buttons[8].getText()=="O")
           ) {
            winsOfo(0,4,8);
        }
        if (
           (buttons[2].getText()=="O") &&
           (buttons[4].getText()=="O") &&
           (buttons[6].getText()=="O")
           ) {
            winsOfo(2,4,6);
        }



    }

    public void winsOfx(int v, int w, int x) {
        buttons[v].setBackground(Color.PINK);
        buttons[w].setBackground(Color.PINK);
        buttons[x].setBackground(Color.PINK);

        for (int i= 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        label.setText("X wins");
    }

    public void winsOfo(int v, int w, int x) {

        buttons[v].setBackground(Color.PINK);
        buttons[w].setBackground(Color.PINK);
        buttons[x].setBackground(Color.PINK);

        for (int i= 0; i < 9; i++){
            buttons[i].setEnabled(false);
        }
        label.setText("O wins");
    }
}
