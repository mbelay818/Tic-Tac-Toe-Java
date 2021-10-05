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

         title_panel.setLayout(new BorderLayout());// this sets the titel panel with a border layout
         title_panel.setBounds(0,0,800,100);  //this sets the bounds for the panel

         button_panel.setLayout(new GridLayout(3,3)); // set the grid for the tic-tac-toe board
         button_panel.setBackground(new Color(150,150,150));//sets the background color for the buttons


         for(int i = 0; i < 9; i++){ //using a for loop to create the buttons
             buttons[i] = new JButton(); // for each i in the for loop we create a button
             button_panel.add(buttons[i]); // this adds the button to the button panel
             buttons[i].setFont(new Font("MV Boli",Font.BOLD,120)); // this sets the font for the buttons
             buttons[i].setFocusable(false); // this makes the buttons not focusable
             buttons[i].addActionListener(this); // this adds an action listener to the buttons
         }

         title_panel.add(textField);    // this adds the text field to the title panel
         frame.add(title_panel,BorderLayout.NORTH); // this adds the title panel to the frame and makes the title panel stay at the top of the frame
         frame.add(button_panel);// this adds the button panel to the frame

          firstTurn(); // this calls the fist turn method
     }

    /* We need to use this method because we are implementing
       the ActionListener interface
     */
    @Override
    public void actionPerformed(ActionEvent e) {
            for(int i = 0; i < 9;i++){ // this checks each of the nine buttons when ever a button is clicked
                if(e.getSource() == buttons[i]){ // the condition is checking if the action is being performed at the specified index
                     if(player1_turn){ //checks if its player 1 turn
                        if (buttons[i].getText() == ""){ //checks if there is any text where the button is clicked
                            buttons[i].setForeground(new Color(255,0,0)); // this sets the foreground color for X
                            buttons[i].setText("X"); // this sets an X on the button
                            player1_turn = false; // this changes the turn to the other player
                            textField.setText("O turn"); // this changes the text field to say it is now "O turn"
                            check(); // this calls the check function
                        }

                     }else{
                         if (buttons[i].getText() == ""){ //checks if there is any text where the button is clicked
                             buttons[i].setForeground(new Color(0,0,255)); // this sets the foreground color for O
                             buttons[i].setText("O"); // this sets an O on the button
                             player1_turn = true; // this changes the turn to the  player1
                             textField.setText("X turn"); // this changes the text field to say it is now "X turn"
                             check(); // this calls the check function
                         }
                     }
                }
            }
    }
    //This method will determine who will go first
    public void firstTurn(){
        try {
            Thread.sleep(4000);  //this makes the program delay for 4 seconds before assigning which player turn it is
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (random.nextInt(2) == 0){ // the if condition checks if the random number equals zero
            player1_turn = true; // this mean the condition was true and it is player ones turn
            textField.setText("X turn"); // this will set the text field to say "X turn"
        }else{
            player1_turn = false; // this mean the condition was false and it is player twos turn
            textField.setText("O turn"); // this will set the text field to say "O turn"
        }

    }
    //This method check if any player has won the game
    public void check(){
        // this condtion is trying to figure out if X has any winning conditions
        if ((buttons[0].getText() == "X") &&
                (buttons[1].getText() == "X") &&
                (buttons[2].getText() == "X")
            ){
            xWins(0,1,2);// this calls the method xWins with the winning cordinates
        }
        // this condtion is trying to figure out if X has any winning conditions
        if ((buttons[3].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[5].getText() == "X")
        ){
            xWins(3,4,5);// this calls the method xWins with the winning cordinates
        }
        // this condtion is trying to figure out if X has any winning conditions
        if ((buttons[6].getText() == "X") &&
                (buttons[7].getText() == "X") &&
                (buttons[8].getText() == "X")
        ){
            xWins(6,7,8);// this calls the method xWins with the winning cordinates
        }
        // this condtion is trying to figure out if X has any winning conditions
        if ((buttons[0].getText() == "X") &&
                (buttons[3].getText() == "X") &&
                (buttons[6].getText() == "X")
        ){
            xWins(0,3,6);// this calls the method xWins with the winning cordinates
        }
        // this condtion is trying to figure out if X has any winning conditions
        if ((buttons[1].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[7].getText() == "X")
        ){
            xWins(1,4,7);// this calls the method xWins with the winning cordinates
        }
        // this condtion is trying to figure out if X has any winning conditions
        if ((buttons[2].getText() == "X") &&
                (buttons[5].getText() == "X") &&
                (buttons[8].getText() == "X")
        ){
            xWins(2,5,8);// this calls the method xWins with the winning cordinates
        }
        // this condtion is trying to figure out if X has any winning conditions
        if ((buttons[0].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[8].getText() == "X")
        ){
            xWins(0,4,8);// this calls the method xWins with the winning cordinates
        }
        // this condtion is trying to figure out if X has any winning conditions
        if ((buttons[2].getText() == "X") &&
                (buttons[4].getText() == "X") &&
                (buttons[6].getText() == "X")
        ){
            xWins(2,4,6);// this calls the method xWins with the winning cordinates
        }
        // this condtion is trying to figure out if O has any winning conditions
        if ((buttons[0].getText() == "O") &&
                (buttons[1].getText() == "O") &&
                (buttons[2].getText() == "O")
        ){
            oWins(0,1,2);// this calls the method oWins with the winning cordinates
        }
        // this condtion is trying to figure out if O has any winning conditions
        if ((buttons[3].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[5].getText() == "O")
        ){
            oWins(3,4,5);// this calls the method oWins with the winning cordinates
        }
        // this condtion is trying to figure out if O has any winning conditions
        if ((buttons[6].getText() == "O") &&
                (buttons[7].getText() == "O") &&
                (buttons[8].getText() == "O")
        ){
            oWins(6,7,8);// this calls the method oWins with the winning cordinates
        }
        // this condtion is trying to figure out if O has any winning conditions
        if ((buttons[0].getText() == "O") &&
                (buttons[3].getText() == "O") &&
                (buttons[6].getText() == "O")
        ){
            oWins(0,3,6);// this calls the method oWins with the winning cordinates
        }
        // this condtion is trying to figure out if O has any winning conditions
        if ((buttons[1].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[7].getText() == "O")
        ){
            oWins(1,4,7);// this calls the method oWins with the winning cordinates
        }
        // this condtion is trying to figure out if O has any winning conditions
        if ((buttons[2].getText() == "O") &&
                (buttons[5].getText() == "O") &&
                (buttons[8].getText() == "O")
        ){
            oWins(2,5,8);// this calls the method oWins with the winning cordinates
        }
        // this condtion is trying to figure out if O has any winning conditions
        if ((buttons[0].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[8].getText() == "O")
        ){
            oWins(0,4,8);// this calls the method oWins with the winning cordinates
        }
        // this condtion is trying to figure out if O has any winning conditions
        if ((buttons[2].getText() == "O") &&
                (buttons[4].getText() == "O") &&
                (buttons[6].getText() == "O")
        ){
            oWins(2,4,6);// this calls the method oWins with the winning cordinates
        }


    }
    //This method checks if X wins
    public void xWins(int a, int b, int c){
        buttons[a].setBackground(Color.GREEN); // this sets the winning combinations of buttons with a green background
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i < 9; i++){ // this loops through all the buttons
            buttons[i].setEnabled(false); // this disables all th buttons because we have a winner

        }
        textField.setText("X wins"); // this will set the textfield to say "X wins"

    }
    //This method checks if O wins
    public void oWins(int a, int b, int c){

        buttons[a].setBackground(Color.GREEN); // this sets the winning combinations of buttons with a green background
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0; i < 9; i++){ // this loops through all the buttons
            buttons[i].setEnabled(false); // this disables all th buttons because we have a winner

        }
        textField.setText("O wins"); // this will set the textfield to say "X wins"


    }

}
