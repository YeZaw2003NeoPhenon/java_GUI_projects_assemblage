import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FilenameFilter;
import java.io.PrintWriter;
import java.util.Scanner;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.SwingUtilities;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.swing.filechooser.FileNameExtensionFilter;

public class textEditor extends JFrame implements ActionListener {

	JTextArea textArea ;
	JScrollPane scrollPane;
	JSpinner fontSize;
	JButton ColorButton;
	JComboBox fontBox;
	 JMenuBar menuBar;
	 JMenu fileMenu;
	 JMenuItem openMenu;
	 JMenuItem saveMenu;
	 JMenuItem exitMenu;
	 JLabel fontLabel;
	 
	
	textEditor(){
		
		this.setSize(500,550);
		this.setTitle("Provocative TextEditor ");
		this.setLayout(new FlowLayout());
		
		
		textArea = new JTextArea();
		textArea.setFont(new Font(" Arial",Font.BOLD,20));
		textArea.setWrapStyleWord(true);
		textArea.setLineWrap(true);
		
		fontLabel = new JLabel("text Size");
		fontLabel.setForeground(Color.DARK_GRAY);
		
		scrollPane = new JScrollPane(textArea);
		scrollPane.setPreferredSize(new Dimension(450,450));
		scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS );
		scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
				
		fontSize = new JSpinner();
		fontSize.setPreferredSize(new Dimension(50,25));
		fontSize.setValue(30);
		
		fontSize.addChangeListener(new ChangeListener() {

			
			public void stateChanged(ChangeEvent e) {
				
			textArea.setFont(new Font(textArea.getFont().getFamily() , Font.PLAIN,(int) fontSize.getValue()));
				
			}
			
		});
		
		 ColorButton = new JButton("Color");
		 ColorButton.setFocusable(false);
		 ColorButton.addActionListener(this);
		
		String[] fonts = GraphicsEnvironment.getLocalGraphicsEnvironment().getAvailableFontFamilyNames();
		
		
		 fontBox = new JComboBox(fonts);
		 fontBox.setSelectedItem("Arial");
		 fontBox.addActionListener(this);
		 
		 menuBar = new JMenuBar();
		 fileMenu = new JMenu("File");
		 openMenu = new JMenuItem("Open File ");
		 saveMenu = new JMenuItem(" Save File ");
		 exitMenu = new JMenuItem("Exit File");
		 
		 
		 fileMenu.add(openMenu);
		 fileMenu.add(saveMenu);
		 fileMenu.add(exitMenu);
		 menuBar.add(fileMenu);
		 
		 openMenu.addActionListener(this);
		 saveMenu.addActionListener(this);
		 exitMenu.addActionListener(this);
		 
		 
		this.add(menuBar);
		this.add(fontLabel);
		this.add(fontSize);
		this.add(fontBox);
		this.add(ColorButton);
		this.add(scrollPane);
		this.getContentPane().setBackground(Color.gray);
		this.setLocationRelativeTo(null);
		
		this.setVisible(true);
		
	}
	
	public void actionPerformed(ActionEvent e) {
		
		if(e.getSource() == ColorButton ) {
			
			JColorChooser colorChooser = new JColorChooser();
			Color color = JColorChooser.showDialog(null, " Pick out color ", Color.BLACK);
			textArea.setForeground(color);
		}
		
		if(e.getSource()== fontBox ) {
			
			textArea.setFont(new Font((String) fontBox.getSelectedItem(),Font.PLAIN , textArea.getFont().getSize()));
			
		}
		if(e.getSource() == openMenu ) {
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			
			FileNameExtensionFilter filter = new FileNameExtensionFilter("Text File ", "//txt.file//Neo//ImmaculateFile//");
			
			fileChooser.setFileFilter(filter);
			
			int rs = fileChooser.showOpenDialog(null);
			if(rs == JFileChooser.APPROVE_OPTION ) {
				File file ;
				Scanner inputFile ;
				file = new File(fileChooser.getSelectedFile().getAbsolutePath());
				
				try {
					inputFile = new Scanner(file);
					if(file.isFile()) {
						while(inputFile.hasNextLine()) {
							String liner = inputFile.nextLine();
							textArea.append(liner);
						}
					}
				} catch (FileNotFoundException e1) {
					
					e1.printStackTrace();
				}
				
				}
					
			}
			
		
		if(e.getSource() == saveMenu ) {
			
			JFileChooser fileChooser = new JFileChooser();
			fileChooser.setCurrentDirectory(new File("."));
			
			int rs = fileChooser.showSaveDialog(null);
			if(rs == JFileChooser.APPROVE_OPTION) {
				File fileInput ;  
				PrintWriter fileOut = null;
				
			 fileInput = new File(fileChooser.getSelectedFile().getAbsolutePath());
			 try {
				fileOut = new PrintWriter(fileInput);
				
				fileOut.println(textArea.getText());
			} catch (FileNotFoundException e1) {
				
				e1.printStackTrace();
			}
			 finally {
				 fileOut.close();
			 }
			}
		}
		if(e.getSource() == exitMenu ) {
			
			System.exit(0);
		}
		
	}
	
   public static void main(String[] args ) {
	 SwingUtilities.invokeLater(new Runnable() {

		public void run() {
			new textEditor();
			
		}
		 
	 });
}
}

