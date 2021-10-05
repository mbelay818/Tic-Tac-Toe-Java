import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;

public class TicTacToe implements ActionListener{
    Random random = new Random(); // This will help us when deciding who goes first randomly
    JFrame frame = new JFrame(); // This will hold our game
    JPanel title_panel = new JPanel(); // holds the title
    JPanel button_panel = new JPanel(); // holds all of the buttons
    JLabel textField = new JLabel(); // display a messages
    JButton[] buttons = new JButton[9]; // for the X's and O's on the board
    boolean player1_turn; // if it is true it is player ones turn and false if its player twos turn

     TicTacToe(){
         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//this creates the JFrame
         frame.setSize(800,800);//this sets the size of the frame
         frame.getContentPane().setBackground(new Color(50,50,50));// This sets the background color of the frame to a lighter shade of black
         frame.setLayout(new BorderLayout()); // This sets the layout for the frame
         frame.setVisible(true);

         textField.setBackground(new Color(25,25,25));//sets the background color for the text field
         textField.setForeground(new Color(25,255,0)); // This sets the text color
         textField.setFont(new Font("Ink Free",Font.BOLD,75)); // This set the font to ink free, make the font bold and the size to 75
         textField.setHorizontalAlignment(JLabel.CENTER);// This sets the horizontal alignment
         textField.setText("Tic-Tac-Toe");//This sets the text to tic-tac-toe
         textField.setOpaque(true); //sets the textfield to opaque

         title_panel.setLayout(new BorderLayout());//






     }

    /* We need to use this method because we are implementing
       the ActionListener interface
     */
    @Override
    public void actionPerformed(ActionEvent e) {

    }
    //This method will determine who will go first
    public void firstTurn(){

    }
    //This method check if any player has won the game
    public void check(){

    }
    //This method checks if X wins
    public void xWins(int a, int b, int c){

    }
    //This method checks if O wins
    public void oWins(int a, int b, int c){

    }

}
