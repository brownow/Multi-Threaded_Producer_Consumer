/*
 * Owen Brown
 * 4838488
 */
package testing;

import java.io.Serializable;
//Bounded Buffer Class
public class BoundedBuffer implements Serializable{

	private static final long serialVersionUID = 1L;
	
	Order[] queue;
	// Create a BoundedBuffer of a specific size
	public BoundedBuffer(int size){
		queue = new Order[size];
	}
	
	// Adds an Order to the BoundedBuffer array queue
	// Returns true if successful
	// Returns false if not successful
	
	synchronized void enqueue(Order o){
		// If there is room on the queue
			if (isFull()){
				try {
					wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
				}
			}
			// Move to the next available space in the queue
			for (int i = 0; i < queue.length; i++){
				 if (queue[i] == null){
					// Add the Order to the queue
					 queue[i] = o;
					 break;
				 }
			}
			
			// TESTING
			System.out.println("Added");
			notify();
	}
	
	// Return the item at the front of the queue if it exists
	// Return null if empty
	synchronized Order dequeue(){
		// If the queue is empty
		if (isEmpty()){
			try {
				wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				return null;
			}
			
		}
		// If the queue is not empty
			Order temp = queue[0];
			shiftElements();
			notify();
			System.out.println("Removed order with date " + temp.fields[0]);
			return temp;
	}
	
	// Returns true if queue is empty, false otherwise
	boolean isEmpty(){
		return (queue[0] == null);
	}
	
	// Returns true if queue has no room, false otherwise
	boolean isFull(){
		return (queue[queue.length-1] != null);
	}
	
	// Shifts all elements down one index position
	void shiftElements(){
		if (queue.length == 1){
			queue[0] = null;
		} // Do nothing, no elements need to be shifted
		else{
			// Shift all non-null index elements to: their current index point - 1
			for (int i = 1; i < queue.length; i++) {                
			    queue[i-1] = queue[i];
			}
		}
	}
	
	//Print the bounded buffer to screen
	void printBuffer(){
		System.out.println("Buffer contents:");
		if (!this.isEmpty()){
			for (Order o: queue){
				System.out.print(
						o.fields[0] + 
						'\n' + o.fields[1] + 
						'\n' + o.fields[2] + 
						'\n' + o.fields[3] + 
						'\n' + o.fields[4] +
						'\n' + o.fields[5] + "\n\n" );
			}
		}
	}
}
