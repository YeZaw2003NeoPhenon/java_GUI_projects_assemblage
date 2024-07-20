import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class toDoList extends JFrame implements ActionListener  {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	DefaultListModel<String>todolistModel;
	JList<String>todoList;
	JTextField TextnewItem;
	JScrollPane scrollItem;
	JButton addButton;
	JButton removeButton;
	JButton colorButton;
	JSpinner wordsSipnner;
	JMenuBar menuBar ;
	JMenu menu;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem exitItem;
	
	toDoList (){
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle(" to do list ");
		this.setLayout(new BorderLayout());
		this.getContentPane().setBackground(Color.GRAY);
		
		todolistModel = new DefaultListModel<>();
		
		todoList = new JList<>(todolistModel);
		todoList.setFont(new Font("Arial",Font.BOLD,18));
		
		scrollItem = new JScrollPane(todoList);
		
		JPanel inputPanel = new JPanel();
		inputPanel.setLayout(new FlowLayout());
		inputPanel.setBorder(BorderFactory.createLineBorder(new Color(0x00FF00)));
		
		TextnewItem = new JTextField(20);
		TextnewItem.setFont(new Font("Arial",Font.BOLD,18));
		inputPanel.setBackground(Color.gray);
		inputPanel.add(TextnewItem);
		
		
		 colorButton = new JButton("pickout color");
		 colorButton.setFocusable(false);
		 colorButton.addActionListener(this);
		 inputPanel.add(colorButton);
		 
		 
		 JButton addButton = new JButton("Add");
		addButton.setFocusable(false);
		addButton.addActionListener(this);
		inputPanel.add(addButton);
		
		JButton removeButton = new JButton("Remove");
		 removeButton.setFocusable(false);
		 removeButton.addActionListener(this);
		 inputPanel.add(removeButton);
		
		 wordsSipnner = new JSpinner();
		 wordsSipnner.setValue(18);
		 wordsSipnner.addChangeListener(new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				
				TextnewItem.setFont(new Font(TextnewItem.getFont().getFamily(),Font.BOLD, (int) wordsSipnner.getValue()));
				
			}
			 
		 });
		 inputPanel.add(wordsSipnner);
		 
		 
		 
		 this.add(todoList);
		this.add(inputPanel, BorderLayout.SOUTH);
		this.add(scrollItem , BorderLayout.CENTER);
		
		this.pack();
		this.setVisible(true);
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		if(e.getSource() == colorButton ) {
			JColorChooser colorChooser = new JColorChooser();
			Color color = JColorChooser.showDialog(colorChooser, "pick out color ", Color.BLACK);
			
			TextnewItem.setForeground(color);
			
		}
		
		if(e.getSource() == addButton ) {
			
			String newItem = TextnewItem.getText();
			
			if(!newItem.isEmpty() ) {
				TextnewItem.setText("");
				todolistModel.addElement(newItem);
			}
		}
			else if(e.getSource()== removeButton ){
			
			int selecedIndex = todoList.getSelectedIndex();
			
			if(selecedIndex != -1  ) {
				todolistModel.remove(selecedIndex);
			}
		}
  }
			
	

	public static void main(String[]args ) {
		
		SwingUtilities.invokeLater(new Runnable () {

			@Override
			public void run() {
				toDoList list = new toDoList();
				list.setVisible(true);
			}
			
		});
		
		
	}
	
	
}
