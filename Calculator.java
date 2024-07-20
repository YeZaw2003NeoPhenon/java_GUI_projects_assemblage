import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.*;
import java.util.*;

public class Calculator implements ActionListener {

	JFrame frame ;
	JButton[] functionButton = new JButton[9];
	JButton[] numberButton = new JButton[10];
	JButton addButton , subButton , mulButton , divButton ;
	JButton delButton , clrButton , decButton , equButton , negButton ;
	JTextField textfield ;
	JPanel panel ;
	double n1 , n2 ;
	double result ;
	char operator ;
	 Font myfont = new Font(" Ink Free ",Font.BOLD , 35 );
	
	Calculator()  {
		frame = new JFrame(" Mesmerizing Calculator ");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setLayout(null);
		frame.setSize(420 , 550 );
		frame.getContentPane().setBackground(Color.darkGray);
		// Mesmerizing one so flamboyantly exquisite .
		textfield = new JTextField();
		textfield.setBounds(50 , 25 , 300 , 50 );
		textfield.setFont(myfont);
		
		
		addButton = new JButton("+");
		subButton = new JButton("-");
		mulButton = new JButton("*");
		divButton = new JButton("/");
		decButton = new JButton(".");
		equButton = new JButton("=");
		clrButton = new JButton("Clear");
		delButton = new JButton("Delete");
		negButton = new JButton("(-)");
		
		// immaculately dexterously mixed up with the indexes of unction buttons .
		functionButton[0] = addButton ;
		functionButton[1] = subButton ;
		functionButton[2] = mulButton ;
		functionButton[3] = divButton ;
		functionButton[4] = decButton ;
		functionButton[5] = equButton ;
		functionButton[6] = clrButton ;
		functionButton[7] = delButton ;
		functionButton[8] = negButton ;
		
		// time to sophisticatedly put out trasparent functionalities .
		for( int i = 0 ; i < 9 ; ++i ) {
			
			functionButton[i].addActionListener(this);
			functionButton[i].setFont(new Font ("Tahoma ",Font.PLAIN,35));
			functionButton[i].setFocusable(false);
			
		}
		for( int i = 0 ; i < 10 ; ++i ) {// almost missed out one crucial fact .
			numberButton[i] = new JButton(String.valueOf(i));
			numberButton[i].addActionListener(this);
			numberButton[i].setFont(new Font("Tahoma ",Font.PLAIN,35));
			numberButton[i].setFocusable(false);
		}
		
		panel = new JPanel();
		panel.setBounds(50, 100, 300, 300);
		panel.setLayout(new GridLayout(4 , 4 , 10 , 10));
		
		
		
		negButton.setBounds(50,430,100,50);
		delButton.setBounds(150,430,100,50);
		clrButton.setBounds(250,430,100,50);
		
		panel.add(numberButton[1]);
		panel.add(numberButton[2]);
		panel.add(numberButton[3]);
		panel.add(addButton);
		panel.add(numberButton[4]);
		panel.add(numberButton[5]);
		panel.add(numberButton[6]);
		panel.add(subButton);
		panel.add(numberButton[7]);
		panel.add(numberButton[8]);
		panel.add(numberButton[9]);
		panel.add(mulButton);
		panel.add(mulButton);
		panel.add(numberButton[0]);
		panel.add(equButton);
		panel.add(divButton);
		
		frame.add(textfield);
		frame.add(panel);
		frame.add(delButton);
		frame.add(clrButton);
		frame.add(negButton);
		frame.setVisible(true);
		
	}
	public static void main(String[] args ) {
		Calculator cal = new Calculator();
	}
	@Override
	public void actionPerformed(ActionEvent e) {
	
	for( int i = 0 ; i < 10 ; ++i ) {
	 if(e.getSource() == numberButton[i]) {
		 textfield.setText(textfield.getText().concat(String.valueOf(i)));
	 }
	}

	if(e.getSource() == decButton) {
		textfield.setText(textfield.getText().concat("."));
	}
	if(e.getSource() == addButton ) {
		n1 = Double.parseDouble(textfield.getText());
		operator = '+';
		textfield.setText("");
	}
	if(e.getSource() == subButton ) {
		n1 = Double.parseDouble(textfield.getText());
		operator = '-';
		textfield.setText("");
	}
	if(e.getSource() == mulButton ) {
		n1 = Double.parseDouble(textfield.getText());
		operator = '*';
		textfield.setText("");
	}
	if(e.getSource() == divButton ) {
		n1 = Double.parseDouble(textfield.getText());
		operator = '/';
		textfield.setText("");
	}
	if(e.getSource() == equButton ) {
		n2 = Double.parseDouble(textfield.getText());
		switch(operator) {
		case '+' :
			result = n1 + n2 ;
			break;
		case '-' :
			result = n1 - n2 ;
			break;
	    case '*' :
		result = n1 * n2 ;
	  break;
	    case '/' :
		result = n1 / n2 ;
		break;
	}
		textfield.setText(String.valueOf(result));
		result = n1;
		// it eventuallly gregarously worked out and SpellBlinding .
	}
	
	if(e.getSource() == clrButton ) {
		textfield.setText("");
	}
	if(e.getSource() == delButton) {
		String effort = textfield.getText();
		StringBuilder builder = new StringBuilder();
		
		textfield.setText("");
		// tremendously indespensible to loop through 
		for( int i = 0 ; i < effort.length() - 1 ; ++i ) {
			int index = effort.charAt(i);
			// to decrementally break down the length of numbers.
			builder.append(effort.length());
			textfield.setText(textfield.getText()+index);
			
		}
	}
	
	if(e.getSource() == negButton) {
	 
		double temp = Double.parseDouble(textfield.getText());
		
		temp *= -1 ;
		textfield.setText(String.valueOf(temp));
	}
	}
}  
