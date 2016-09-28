/*
 * Owen Brown
 * 4838488
 */

package testing;
import javax.swing.*;

public class ConsumerForm extends JFrame{

	private static final long serialVersionUID = -2290993147453887151L;
	
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
	
	public ConsumerForm(){
		
		this.setTitle("Consumer");
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
		dateField.setEditable(false);
		
		// TIME FIELD ***************************************
		Time = new JLabel("Time");
		Time.setBounds(263, 11, 46, 14);
		this.getContentPane().add(Time);
		
		timeField = new JTextField();
		timeField.setBounds(319, 8, 160, 20);
		this.getContentPane().add(timeField);
		timeField.setColumns(10);
		timeField.setEditable(false);
		
		// ORDER NUM FIELD ***************************************
		OrderNum = new JLabel("Order #");
		OrderNum.setBounds(10, 42, 46, 14);
		this.getContentPane().add(OrderNum);
		
		orderField = new JTextField();
		orderField.setBounds(76, 39, 160, 20);
		this.getContentPane().add(orderField);
		orderField.setColumns(10);
		orderField.setEditable(false);
		
		// QUANTITY FIELD ***************************************
		Quantity = new JLabel("Quantity");
		Quantity.setBounds(10, 73, 46, 14);
		this.getContentPane().add(Quantity);
		
		quantityField = new JTextField();
		quantityField.setBounds(76, 70, 160, 20);
		this.getContentPane().add(quantityField);
		quantityField.setColumns(10);
		quantityField.setEditable(false);
		
		// ITEM NUM FIELD ***************************************
		ItemNum = new JLabel("Item #");
		ItemNum.setBounds(263, 42, 46, 14);
		this.getContentPane().add(ItemNum);
		
		itemField = new JTextField();
		itemField.setBounds(319, 39, 160, 20);
		this.getContentPane().add(itemField);
		itemField.setColumns(10);
		itemField.setEditable(false);
		
		// ADDRESS FIELD ***************************************
		Address = new JLabel("Address");
		Address.setBounds(10, 161, 61, 14);
		this.getContentPane().add(Address);
		
		addressText = new JTextArea();
		addressText.setBounds(81, 130, 398, 83);
		this.getContentPane().add(addressText);
		addressText.setEditable(false);
		
		// OK BUTTON ***************************************
		Ok = new JButton("OK");
		this.getRootPane().setDefaultButton(Ok);
		Ok.setBounds(118, 228, 89, 23);
		this.getContentPane().add(Ok);
		
		// QUIT BUTTON ***************************************
		Quit = new JButton("Quit");
		Quit.setBounds(220, 228, 89, 23);
		this.getContentPane().add(Quit);
	}

}
