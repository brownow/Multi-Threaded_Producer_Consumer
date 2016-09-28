/*
 * Owen Brown
 * 4838488
 */
package testing;


import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.swing.*;

//Producer Form Class
public class ProducerForm extends JFrame implements FocusListener{

	static final long serialVersionUID = -7878728037416530018L;
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String DATE_PATTERN = "^(0?[1-9]|1[012])/(0?[1-9]|[12][0-9]|3[01])/([1-9][1-9])$";
	private static final String TIME_PATTERN = "^([01]?[0-9]|2[0-3]):([0-5][0-9])$";
	private static final String INTEGER_PATTERN = "^\\d+$";
	private static final String ITEMNUM_PATTERN = "([0-9][0-9])-([0-9][0-9])-([0-9][0-9])$";
	
	public JTextField dateField;
	public JTextField timeField;
	public JTextField orderField;
	public JTextField quantityField;
	public JTextField itemField;
	public JTextArea addressText;
	public JLabel ItemNum;
	public JLabel Address;
	public JLabel Quantity;
	public JLabel Date;
	public JLabel Time;
	public JLabel OrderNum;
	public JButton Ok;
	public JButton Quit;
	
	public ProducerForm(){
		
		this.setTitle("Producer");
		this.setBounds(100, 100, 515, 300);
		this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		this.getContentPane().setLayout(null);
		
		// DATE FIELD ***************************************
		Date = new JLabel("Date");
		Date.setBounds(10, 11, 46, 14);
		this.getContentPane().add(Date);
		
		dateField = new JTextField();
		dateField.setBounds(76, 8, 160, 20);
		this.getContentPane().add(dateField);
		dateField.setColumns(10);
		
		// TIME FIELD ***************************************
		Time = new JLabel("Time");
		Time.setBounds(263, 11, 46, 14);
		this.getContentPane().add(Time);
		
		timeField = new JTextField();
		timeField.setBounds(319, 8, 160, 20);
		this.getContentPane().add(timeField);
		timeField.setColumns(10);
		
		// ORDER NUM FIELD ***************************************
		OrderNum = new JLabel("Order #");
		OrderNum.setBounds(10, 42, 46, 14);
		this.getContentPane().add(OrderNum);
		
		orderField = new JTextField();
		orderField.setBounds(76, 39, 160, 20);
		this.getContentPane().add(orderField);
		orderField.setColumns(10);
		
		// QUANTITY FIELD ***************************************
		Quantity = new JLabel("Quantity");
		Quantity.setBounds(10, 73, 46, 14);
		this.getContentPane().add(Quantity);
		
		quantityField = new JTextField();
		quantityField.setBounds(76, 70, 160, 20);
		this.getContentPane().add(quantityField);
		quantityField.setColumns(10);
		
		// ITEM NUM FIELD ***************************************
		ItemNum = new JLabel("Item #");
		ItemNum.setBounds(263, 42, 46, 14);
		this.getContentPane().add(ItemNum);
		
		itemField = new JTextField();
		itemField.setBounds(319, 39, 160, 20);
		this.getContentPane().add(itemField);
		itemField.setColumns(10);
		
		// ADDRESS FIELD ***************************************
		Address = new JLabel("Address");
		Address.setBounds(10, 161, 61, 14);
		this.getContentPane().add(Address);
		
		addressText = new JTextArea();
		addressText.setBounds(81, 130, 398, 83);
		this.getContentPane().add(addressText);
		
		// OK BUTTON ***************************************
		Ok = new JButton("OK");
		this.getRootPane().setDefaultButton(Ok);
		Ok.setBounds(118, 228, 89, 23);
		this.getContentPane().add(Ok);
		
		// QUIT BUTTON ***************************************
		Quit = new JButton("Quit");
		Quit.setBounds(220, 228, 89, 23);
		this.getContentPane().add(Quit);
		
		// Add all Focus Listeners
		dateField.addFocusListener(this);
		timeField.addFocusListener(this);
		quantityField.addFocusListener(this);
		itemField.addFocusListener(this);
		orderField.addFocusListener(this);
		addressText.addFocusListener(this);
	}
	
	public void clearForm(){
		dateField.setText("");
		timeField.setText("");
		orderField.setText("");
		itemField.setText("");
		quantityField.setText("");
		addressText.setText("");
	}
	
	@Override
	public void focusGained(FocusEvent arg0) {
		checkFields();
	}

	@Override
	public void focusLost(FocusEvent arg0) {
		checkFields();
	}
	
	// Check all fields for formatting
			public boolean checkFields(){
				return (checkDate() & checkTime() & checkOrderNum() & checkItemNum() & checkQuantity() & checkAddress());
			}
			// Check that the Date is properly formatted
			private boolean checkDate(){
				pattern = Pattern.compile(DATE_PATTERN);
				matcher = pattern.matcher(dateField.getText());
				// IF NO MATCH, COLOR RED
				if (!matcher.matches()){
					Date.setForeground(Color.RED);
					return false;
				}
				// IF FALSE, COLOR RED
				else{
					Date.setForeground(Color.BLACK);
					return true;
				}
			}
			// Check that the Time is properly formatted
			private boolean checkTime(){
				// CHECK USING REGEX IF PATTERN MATCH
				pattern = Pattern.compile(TIME_PATTERN);
				matcher = pattern.matcher(timeField.getText());
				// IF NO MATCH, COLOR RED
				if (!matcher.matches()){
					Time.setForeground(Color.RED);
					return false;
				}
				// IF FALSE, COLOR RED
				else{
					Time.setForeground(Color.BLACK);
					return true;
				}
				
			}
			// Check that the Order Number is properly formatted
			private boolean checkOrderNum(){
				// CHECK USING REGEX IF PATTERN MATCH
				pattern = Pattern.compile(INTEGER_PATTERN);
				matcher = pattern.matcher(orderField.getText());
				// IF NO MATCH, COLOR RED
				if (!matcher.matches()){
					OrderNum.setForeground(Color.RED);
					return false;
				}
				// IF FALSE, COLOR RED
				else{
					OrderNum.setForeground(Color.BLACK);
					return true;
				}
			}
			// Check that the Item Number is properly formatted
			private boolean checkItemNum(){
				// CHECK USING REGEX IF PATTERN MATCH
				pattern = Pattern.compile(ITEMNUM_PATTERN);
				matcher = pattern.matcher(itemField.getText());
				// IF NO MATCH, COLOR RED
				if (!matcher.matches()){
					ItemNum.setForeground(Color.RED);
					return false;
				}
				// IF FALSE, COLOR RED
				else{
					ItemNum.setForeground(Color.BLACK);
					return true;
				}
			}
			// Check that the Quantity is properly formatted
			private boolean checkQuantity(){
				// CHECK USING REGEX IF PATTERN MATCH
				pattern = Pattern.compile(INTEGER_PATTERN);
				matcher = pattern.matcher(quantityField.getText());
				// IF NO MATCH, COLOR RED
				if (!matcher.matches()){
					Quantity.setForeground(Color.RED);
					return false;
				}
				// IF FALSE, COLOR RED
				else{
					Quantity.setForeground(Color.BLACK);
					return true;
				}
			}
			// Check that the Address is properly formatted
			private boolean checkAddress(){
				// CHECK IF FIELD BLANK
				// RED IF BLANK
				if (addressText.getText().trim().compareTo("") == 0){
					Address.setForeground(Color.RED);
					return false;
				}
				// BLACK IF NON-BLANK
				else{
					Address.setForeground(Color.BLACK);
					return true;
				}
			}
}


