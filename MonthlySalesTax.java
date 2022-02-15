/* Program: MonthlySalesTax
   Date: April 30, 2018
   Author: Jonathan Price
   
   This program is designed to ask the user to
   enter the amount of money earned in sales for
   a month, then calculate the amount of sales tax
   due on the entered amount. When run, this program
   will display a window with a textbox for the user
   to enter a dollar amount with instructions to enter
   the sales for the month in the textbox and a button
   to calculate the total sales tax due. After being 
   executed, this program needs the user to enter a
   dollar amount into the textbox, click the button
   labeled "Calculate" to get the sales tax for the amount,
   then click the button labeled "OK" to close the pop-up.
   
*/

import javax.swing.*;   //Needed for Swing classes
import java.awt.event.*;   //Needed for ActionListener Interface

/**
   The MonthlySalesTax class displays a JFrame that
   lets the user enter the total sales for the month
   into a text field. When the Calculate button is
   clicked, a dialog box is displayed with the total
   sales tax (country + state)
*/

public class MonthlySalesTax extends JFrame
{
   private JPanel panel;   //To reference a panel
   private JLabel messageLabel;  //To reference a label
   private JTextField textField; //To reference a text field
   private JButton calcButton;   //To reference a button
   private final int WINDOW_HEIGHT = 350; //Window height
   private final int WINDOW_WIDTH = 150;  //Window width
   
   /**
      Constructor
   */
   
   public MonthlySalesTax()
   {
      //Set the window title
      setTitle("Sales Tax Calculator");
      
      //Set the size of the window
      setSize(WINDOW_HEIGHT, WINDOW_WIDTH);
      
      //Specify what happens when close button is clicked
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      
      //Build the panel and add it to the frame
      buildPanel();
      
      //Add the panel to the frame's content pane
      add(panel);
      
      //Display the window
      setVisible(true);
   }
   
   /**
      The buildPanel method adds a label, text field, and button to a panel
   */
   
   private void buildPanel()
   {
      //Create label to display instructions
      messageLabel = new JLabel("Enter the sales " +
                                "for this month");
      
      //Create a text field 10 characters wide                 
      textField = new JTextField(10);
      
      //Create a button with the caption "Calculate"
      calcButton = new JButton("Calculate");
      
      //Add an action listener to the button
      calcButton.addActionListener(new CalcButtonListener());
      
      //Create a JPanel object and let the panel field reference it
      panel = new JPanel();
      
      //Add the label, text field, and button components to the panel
      panel.add(messageLabel);
      panel.add(textField);
      panel.add(calcButton);
   }
   
   /**
      CalcButtonListener is an action listener class for the Calculate button
   */
   
    private class CalcButtonListener implements ActionListener
   {
      /**
         The actionPerformed method executed when the user clicks on the
         Calculate button.
         @param e The event object
      */
      
      public void actionPerformed(ActionEvent e)
      {
         final double COUNTRY_SALES_TAX = 0.02; //Hold the country sales tax
         final double STATE_SALES_TAX = 0.04;   //Hold the state sales tax
         String input;  //Hold the user's input
         double total_tax; //Hold the total sales tax
         
         //Get the text entered by the user into the text field
         input = textField.getText();
                            
         //Calculate the total tax
         total_tax = (Double.parseDouble(input) * COUNTRY_SALES_TAX) + 
                 (Double.parseDouble(input) * STATE_SALES_TAX);
         
         //Display the result
         JOptionPane.showMessageDialog(null, "The total tax is $" + total_tax);
      }
   }  //End of CalcButtonListener class
   
   /**
      The main method creates an instance of the MonthlySalesTax
      class which displays its window on the screen
   */
   
   public static void main(String[] args)
   {
      new MonthlySalesTax();
   }
}