import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.util.Random;

public class GuessingGame implements ActionListener { 
  JTextField jtxtGuess;
  JButton jbtnUserGuess, jbtnPlayAgain;
  JLabel jlblGuess, jlblResult, jlblPreviousGuess;
  Random r = new Random();
  int randomInt;

  GuessingGame(){
    randomInt = r.nextInt(100);

    //Make and setup frame
    // Create a new JFrame container with title Guessing Game. 
    JFrame frame = new JFrame("Guessing Game"); 
    //Set the layout for the frame to be a new FlowLayout. 
    frame.setLayout(new FlowLayout()); 
    // Set the size of the frame to be 240, 120
    frame.setSize(240, 120); 

    //Setup Text field where user will type in their jtxtGuess
    //Initialize your userGuess field to be a new JTextField with size 10
    jtxtGuess = new JTextField(10);
    //Set the action command for your userGuess field to be "myTF"
    jtxtGuess.setActionCommand("myTF");

    //Setup Buttons
    //One button needs to let the user guess, so initialize your guessButton with the name "Button"
    jbtnUserGuess = new JButton("Guess");
    //The other button needs to let the user play again, so initialize your playAgainButton with the name "Play Again"
    jbtnPlayAgain = new JButton("Play Again");

    //Add action listeners to  userGuess text field, guessButton, and playAgainButton
    jtxtGuess.addActionListener(this);
    jbtnUserGuess.addActionListener(this);
    jbtnPlayAgain.addActionListener(this);

    //Setup Labels
    //Ener Guess Label
    jlblGuess = new JLabel("Enter your guess:");
    //2 blank string labels because no guess has been made yet
    jlblPreviousGuess = new JLabel("");
    jlblResult = new JLabel("");

    //Add everything to the frame
    frame.add(jlblGuess);
    frame.add(jtxtGuess);
    frame.add(jbtnUserGuess);
    frame.add(jlblResult);
    frame.add(jlblPreviousGuess);
    frame.add(jbtnPlayAgain);

    // Display the frame. 
      frame.setVisible(true);    
  }

  public void actionPerformed(ActionEvent ae){
    
    if(ae.getActionCommand().equals("Guess")) { 
      int guess = Integer.parseInt(jtxtGuess.getText());
      
      if(guess > randomInt){
        jlblResult.setText("Too High");
      }
      else if(guess < randomInt){
        jlblResult.setText("Too Low");
      }
      else{
        jlblResult.setText("You Got It!");
      }
      
      jlblPreviousGuess.setText("Last guess was " + guess);

    }
    else if(ae.getActionCommand().equals("Play Again")){
       randomInt = r.nextInt(100);
       jlblGuess.setText("Enter your guess:");
       jlblPreviousGuess.setText("");
       jlblResult.setText("");
       jtxtGuess.setText("");
    }
    else{
      jlblResult.setText("You pressed Enter. Please press the Guess Button.");
    }
  }




}