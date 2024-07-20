
import javax.swing.*;
import java.util.Random;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

public class TicTacToeWithGUI  implements ActionListener {
	
	Random rand = new Random();
	
	JFrame frame ;
	JPanel titlePanel;
	JPanel buttonPanel;
	JLabel textField;
	JButton[]buttons = new JButton[9];
	boolean firstTurn;
	
	TicTacToeWithGUI(){
		
		frame = new JFrame("Engrossing and Exuberant Tic Tac Toe Game ");
		frame.setSize(700,600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(new BorderLayout());
		frame.getContentPane().setBackground(new Color(50,50,50));
		
		textField = new JLabel();
		textField.setBackground(new Color(25,25,25));
		textField.setForeground(new Color(25,255,0));
		textField.setFont(new Font("Ink Free",Font.BOLD,60));
		textField.setHorizontalAlignment(JLabel.CENTER);
		textField.setText(" Tic Tac Toe (:");
		textField.setOpaque(false);
		
		
		titlePanel = new JPanel();
		titlePanel.setBounds(0,0,800,100);
		titlePanel.setBackground(Color.BLACK);
		titlePanel.setLayout(new BorderLayout());
		
		
		buttonPanel = new JPanel();
		buttonPanel.setLayout(new GridLayout(3,3));
		buttonPanel.setBackground(new Color(150,150,150));
		
		for(int i = 0 ; i < 9 ; ++i ) {
			buttons[i] = new JButton();
			buttonPanel.add(buttons[i]);
			buttons[i].setFont(new Font(" Mov bi", Font.BOLD,120));
			buttons[i].addActionListener(this);
			buttons[i].setFocusable(false);
		}
		
		titlePanel.add(textField);
		frame.add(titlePanel, BorderLayout.NORTH);
		frame.add(buttonPanel);
		
		frame.setVisible(true);
		
		 First_Turn();
	}
	
	public static void main(String[] args ) {
		
		TicTacToeWithGUI ttc = new TicTacToeWithGUI();
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		for( int i =0 ; i < 9 ; ++i ) {
			
			if(e.getSource() == buttons[i]) {
				if(firstTurn) {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color( 255 , 0 , 0 ));
						buttons[i].setText("X");
						firstTurn = false ;
						textField.setText("O turn");
						check();
					}
				}
			
				else {
					if(buttons[i].getText() == "") {
						buttons[i].setForeground(new Color( 0 , 0 , 255 ));
						buttons[i].setText("O");
						firstTurn = true ;
						textField.setText("X turn");
						check();
			}
				
		}
				}
			
			}
	}
	
	public  void First_Turn() {
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		if(rand.nextInt(2)==0 ) {
			firstTurn = true;
			textField.setText("X turn");
			 
		}
		else {
			
			firstTurn = false;
			textField.setText("O turn");
			 
		}
	}
	public void check() {

		if(
				(buttons[0].getText()=="X" &&buttons[1].getText()=="X" && buttons[2].getText()=="X")
		   ) {
			xWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="X" &&buttons[4].getText()=="X" && buttons[5].getText()=="X")
		   ) {
			xWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="X" &&buttons[7].getText()=="X" && buttons[8].getText()=="X")
		   ) {
			xWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="X" &&buttons[3].getText()=="X" && buttons[6].getText()=="X")
		   ) {
			xWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="X" &&buttons[4].getText()=="X" && buttons[7].getText()=="X")
		   ) {
			xWins(1,4,7);
		}
		if(
			(buttons[2].getText()=="X" &&buttons[5].getText()=="X" && buttons[8].getText()=="X")
		   ) {
			xWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="X" &&buttons[4].getText()=="X" && buttons[8].getText()=="X")
		   ) {
			xWins(0,4,8);
		}
		
		
		if(
				(buttons[0].getText()=="O" &&buttons[1].getText()=="O" && buttons[2].getText()=="O")
		   ) {
			oWins(0,1,2);
		}
		if(
				(buttons[3].getText()=="O" &&buttons[4].getText()=="O" && buttons[5].getText()=="O")
		   ) {
			oWins(3,4,5);
		}
		if(
				(buttons[6].getText()=="O" &&buttons[7].getText()=="O" && buttons[8].getText()=="O")
		   ) {
			oWins(6,7,8);
		}
		if(
				(buttons[0].getText()=="O" &&buttons[3].getText()=="O" && buttons[6].getText()=="O")
		   ) {
			oWins(0,3,6);
		}
		if(
				(buttons[1].getText()=="O" &&buttons[4].getText()=="O" && buttons[7].getText()=="O")
		   ) {
			oWins(1,4,7);
		}
		if(
			(buttons[2].getText()=="O" &&buttons[5].getText()=="O" && buttons[8].getText()=="O")
		   ) {
			oWins(2,5,8);
		}
		if(
				(buttons[0].getText()=="O" &&buttons[4].getText()=="O" && buttons[8].getText()=="O")
		   ) {
			oWins(0,4,8);
		}
		
	}
	public  void xWins(int a , int b , int c ) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for( int i = 0 ; i < 9 ; ++i ) {
    // looping through impeccably .
			buttons[i].setEnabled(false);
		}
		textField.setText("X wins! Awesome");
			
	}
	public  void oWins(int a , int b , int c ) {
		buttons[a].setBackground(Color.green);
		buttons[b].setBackground(Color.green);
		buttons[c].setBackground(Color.green);
		
		for( int i = 0 ; i < 9 ; ++i ) {
    // looping through impeccably .
			buttons[i].setEnabled(false);
		}
		textField.setText("O wins! Awesome ");
	}
}
