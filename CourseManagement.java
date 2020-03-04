import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Checkbox;
import java.awt.Color;
import java.awt.Container;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.RowSorter;
import javax.swing.SortOrder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

public class CourseManagement implements ActionListener{
	String result;
	CardLayout cards;
	JPanel cardPanel;
	JPanel firstCard;
	JPanel fourthCard;
	String myText;
	JTextField passwordTxt;
	JTextField nameTxt;
	JPanel secondCard;
	JLabel label2;
	JPanel thirdCard;
	JLabel label4;
	JButton loginButton;
	JButton nextButton;
	JButton backButton1;
	JButton backButton2;
	JButton nextButton3;
	JButton backButton3;
	DefaultTableModel model;
	JTable myTable;
	JButton myAddDataButton;
	JButton myRemoveDataButton;
	JTextField nameTextField;
	JTextField surnameTextField;
	JTextField IDTextField;
	DefaultTableModel model2;
	JTable myTable2;



	public CourseManagement() {
		
		JFrame frame = new JFrame();
		frame.setTitle("Deniz OKTAY");
		
		Container cp = frame.getContentPane();
		cp.setLayout(new BorderLayout());
		
		// Create the "Deck of Cards"
		cards = new CardLayout();
		cardPanel = new JPanel();
		cardPanel.setLayout(cards);
		
		// Create the First panel
		firstCard = new JPanel();
		firstCard.setLayout(new BorderLayout());
			//Yellow Panel
			JPanel yellowPanel = new JPanel();
			yellowPanel.setBackground(Color.pink);
			JLabel label1 = new JLabel("Course Management System");
			yellowPanel.add(label1);
			//Grey Panel
			JPanel greyPanel = new JPanel();
			Box b0 = new Box(BoxLayout.Y_AXIS);
			Box b1 = new Box(BoxLayout.Y_AXIS);
			
			JLabel nameLabel = new JLabel("User Name");
			nameTxt = new JTextField(20);
			JLabel passwordLabel = new JLabel("Password");
			passwordTxt = new JTextField(20);
			
			b0.add(nameLabel);
			b1.add(nameTxt);
			b0.add(passwordLabel);
			b1.add(passwordTxt);
			JPanel greyPanel2 = new JPanel();
			greyPanel2.setBackground(Color.white);
			greyPanel2.add(b0);
			greyPanel2.add(b1);
			
			greyPanel.setBackground(Color.white);
			greyPanel.setLayout(new BorderLayout());
			ImageIcon icon1 = new ImageIcon("Images\\\\teacher2.png");
			JLabel imagelabel1 = new JLabel();
			imagelabel1.setIcon(icon1);
			greyPanel.add(greyPanel2, BorderLayout.NORTH);
			greyPanel.add(imagelabel1, BorderLayout.CENTER);
			
			//Login Button
			loginButton = new JButton("LOGIN");
			loginButton.addActionListener(this);
		
		firstCard.add(yellowPanel, BorderLayout.NORTH);
		firstCard.add(greyPanel, BorderLayout.CENTER);
		firstCard.add(loginButton, BorderLayout.SOUTH);
		
		// Create the Second panel
		secondCard = new JPanel();
		secondCard.setLayout(new BorderLayout());
			
			//Green Panel
			JPanel greenPanel = new JPanel();
			greenPanel.setBackground(Color.gray);
			label2 = new JLabel("Welcome");
			greenPanel.add(label2);
			
			//New Panel
			JPanel newPanel = new JPanel();
			newPanel.setLayout(new BorderLayout());
				//NewPanel2
				JPanel newPanel2 = new JPanel();
				newPanel2.setLayout(new GridLayout(2, 1));
			
				// Yellow Panel
						JPanel yellowPanel2 = new JPanel();
						yellowPanel2.setLayout(new FlowLayout());
						yellowPanel2.setBackground(Color.pink);
						JLabel nameLabel2 = new JLabel("Name");
						nameTextField = new JTextField(20);
						JLabel surnameLabel = new JLabel("Surname");
						surnameTextField = new JTextField(20);
						JLabel IDLabel = new JLabel("ID");
						IDTextField = new JTextField(20);
						
						yellowPanel2.add(IDLabel);
						yellowPanel2.add(IDTextField);
						yellowPanel2.add(nameLabel2);
						yellowPanel2.add(nameTextField);
						yellowPanel2.add(surnameLabel);
						yellowPanel2.add(surnameTextField);
						myAddDataButton = new JButton("Add Student in Order");
						myAddDataButton.addActionListener(this);
						
						myRemoveDataButton = new JButton("Delete Last Student");
						myRemoveDataButton.addActionListener(this);
						
						JPanel buttonsPanel2 = new JPanel();
						buttonsPanel2.setLayout(new GridLayout(1, 2));
						buttonsPanel2.add(myAddDataButton);
						buttonsPanel2.add(myRemoveDataButton);
						
					newPanel2.add(yellowPanel2);
					newPanel2.add(buttonsPanel2);
						model = new DefaultTableModel(new String[]{"ID","Name", "Surname"}, 0);
			            model.addRow(new Object[]{"A345","Tom", "Smith"});
			     		model.addRow(new Object[]{"A567","Mary", "Brown"});
			     		model.addRow(new Object[]{"A123","Terry", "Brown"});

			            myTable = new JTable(model);
			            TableRowSorter<TableModel> sorter = new TableRowSorter<TableModel>(myTable.getModel());
			            myTable.setRowSorter(sorter);

			            List<RowSorter.SortKey> sortKeys = new ArrayList<>(25);
			            sortKeys.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
			            sortKeys.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
			            sorter.setSortKeys(sortKeys);	
						
			            JScrollPane scroll = new JScrollPane(myTable);

						
						
					
				newPanel.add(newPanel2,BorderLayout.NORTH);
				newPanel.add(scroll,BorderLayout.CENTER);
			
			
			//Button's Panel
			JPanel buttonsPanel = new JPanel();
			buttonsPanel.setLayout(new GridLayout(1,2));
			nextButton = new JButton("Next");
			nextButton.addActionListener(this);
			backButton1 = new JButton("Back");
			backButton1.addActionListener(this);
			buttonsPanel.add(backButton1);
			buttonsPanel.add(nextButton);
					
		secondCard.add(buttonsPanel, BorderLayout.SOUTH);
		secondCard.add(greenPanel, BorderLayout.NORTH);
		secondCard.add(newPanel,BorderLayout.CENTER);
		secondCard.add(buttonsPanel, BorderLayout.SOUTH);
		
		// Create the Third panel
		thirdCard = new JPanel();
		thirdCard.setLayout(new BorderLayout());
		//newPanel3	
		JPanel newPanel3 = new JPanel();
		newPanel3.setLayout(new BorderLayout());
		//Pink Panel
			JPanel pinkPanel = new JPanel();
			pinkPanel.setBackground(Color.orange);
			label4 = new JLabel("Good Bye");
			pinkPanel.add(label4);
		//ImagePanel
			JPanel imagePanel = new JPanel();
			imagePanel.setBackground(Color.orange);
			ImageIcon icon2 = new ImageIcon("Images\\\\bye.jpg");
			JLabel imagelabel2 = new JLabel();
			imagelabel2.setIcon(icon2);
			imagePanel.add(imagelabel2);
		newPanel3.add(pinkPanel, BorderLayout.NORTH);
		newPanel3.add(imagePanel, BorderLayout.CENTER);
			
			//Back Button 2
			backButton2 = new JButton("Back");
			backButton2.addActionListener(this);
		
		thirdCard.add(newPanel3, BorderLayout.CENTER);
		thirdCard.add(backButton2, BorderLayout.SOUTH);
		
		// Create the Fourth panel
				fourthCard = new JPanel();
				fourthCard.setLayout(new BorderLayout());
				
				JPanel listPanel = new JPanel();
				listPanel.setLayout(new GridLayout(2,1));
				JLabel listLabel = new JLabel("Names in Alphabetical Order:");
				
				Random rnd = new Random();
				model2 = new DefaultTableModel(new Object[]{"Name", "Surname","Attendance"}, 0) {
			         @Override
			         public Class getColumnClass(int columnIndex) {
			             if (columnIndex==0)
			        	      return String.class;
			             if (columnIndex==1)
			        	      return String.class;
			             if (columnIndex==2)
			            	 return Boolean.class;
						return String.class;
			         }
			      };
			     
			  
				
				
	            model2.addRow(new Object[]{"Tom", "Smith",true});
	     		model2.addRow(new Object[]{"Mary", "Brown",true});
	     		model2.addRow(new Object[]{"Terry", "Brown",true});
	     		

	            myTable2 = new JTable(model2);
	            TableRowSorter<TableModel> sorter2 = new TableRowSorter<TableModel>(myTable2.getModel());
	            myTable2.setRowSorter(sorter2);

	            List<RowSorter.SortKey> sortKeys2 = new ArrayList<>(25);
	            sortKeys2.add(new RowSorter.SortKey(0, SortOrder.ASCENDING));
	            sortKeys2.add(new RowSorter.SortKey(1, SortOrder.ASCENDING));
	            sorter2.setSortKeys(sortKeys2);	
				
	            JScrollPane scroll2 = new JScrollPane(myTable2);
				
				
	            JButton btn=new JButton("Take Attendance");
	            btn.addActionListener(new ActionListener() {

	              @Override
	              public void actionPerformed(ActionEvent arg0) {
	                // TODO Auto-generated method stub

	                //GET SELECTED ROW
	                for(int i=0;i<myTable2.getRowCount();i++)
	                {
	                  Boolean checked=Boolean.valueOf(myTable2.getValueAt(i, 2).toString());
	                  String col=myTable2.getValueAt(i, 0).toString()+" "+myTable2.getValueAt(i, 1).toString();
	                  result ="Absent Students:";
	                  //DISPLAY
	                  if(!checked)
	                  {
	                	  result =result+"\n"+col;
	                	  JOptionPane.showMessageDialog(null, result);

	                  }
	                  
	                }
	                

	              }
	            });
	            
				//Button's Panel
				JPanel buttonsPanel3 = new JPanel();
				buttonsPanel3.setLayout(new GridLayout(1,2));
				nextButton3 = new JButton("Next");
				nextButton3.addActionListener(this);
				backButton3 = new JButton("Back");
				backButton3.addActionListener(this);
				buttonsPanel3.add(backButton3);
				buttonsPanel3.add(nextButton3);
			
				
			listPanel.add(listLabel);
			listPanel.add(btn);
			fourthCard.add(buttonsPanel3, BorderLayout.SOUTH);
			fourthCard.add(scroll2,BorderLayout.CENTER);
			fourthCard.add(listPanel, BorderLayout.NORTH);
		
		//Add to the cardPanel here
		cardPanel.add(firstCard, "first");
		cardPanel.add(secondCard, "second");
		cardPanel.add(fourthCard, "fourth");
		cardPanel.add(thirdCard, "third");
		
		
		cp.add(cardPanel,BorderLayout.CENTER);
		
		frame.setSize(900, 560);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) 
	{	
		if (e.getSource() ==loginButton) 
		{	
			 myText = passwordTxt.getText();
			 if (myText.equals("secret123")) 
			 {
				label2.setText("Welcome "+nameTxt.getText());
				label4.setText("Good Bye "+nameTxt.getText());
				cards.next(cardPanel);
			 } 
			 else 
			 {
				 JOptionPane.showMessageDialog(null, "Invalid Password \nTry Again", "Warning",JOptionPane.WARNING_MESSAGE);	
				 passwordTxt.setText(null);
			 }
		}
	
		if (e.getSource() == nextButton) 
		{	
			cards.next(cardPanel);
		}	
		if (e.getSource() == backButton1) 
		{	
			cards.previous(cardPanel);
		}	
		if (e.getSource() == backButton2) 
		{	
			cards.previous(cardPanel);
		}	
		if (e.getSource() == nextButton3) 
		{	
			cards.next(cardPanel);
		}	
		if (e.getSource() == backButton3) 
		{	
			cards.previous(cardPanel);
		}	
		if(e.getSource()==myAddDataButton)
		{
			model.addRow(new Object[]{IDTextField.getText(),nameTextField.getText(), surnameTextField.getText()});
			model2.addRow(new Object[]{nameTextField.getText(), surnameTextField.getText(),true});
		}
		
		
		if(e.getSource()==myRemoveDataButton)
		{
			int row;
			row = model.getRowCount();
			model.removeRow(row-1);
			int row2;
			row2 = model2.getRowCount();
			model2.removeRow(row-1);
			
			
		}
		
	}
	
	public static void main(String[] args) {
		
		CourseManagement myUsing_CardLayout = new CourseManagement();
	}

}