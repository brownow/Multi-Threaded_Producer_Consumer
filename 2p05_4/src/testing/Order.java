/*
 * Owen Brown
 * 4838488
 */
package testing;

import java.io.Serializable;

//Order Class
public class Order implements Serializable {

	private static final long serialVersionUID = -3905772701902269468L;
	// Holds data values from all fields
	public String[] fields;
	
	// Default constructor
	Order(){
		fields = new String[6];
	};
	
	// Constructor that passes all parameter info as object data upon creation
	Order(String date, String time, String orderNum, String quantity, String itemNum, String address){
		fields = new String[6];
		fields[0] = date;
		fields[1] = time;
		fields[2] = orderNum;
		fields[3] = itemNum;
		fields[4] = quantity;
		fields[5] = address;
	}
}
