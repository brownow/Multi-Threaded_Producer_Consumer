/*
 * Owen Brown
 * 4838488
 */
package testing;

import java.io.IOException;

public class Main {
	
	public static void main(String[] args) {
		Serializer s = new Serializer();
		// *** SIZE OF THE BUFFER ***
		int bufferSize = 5;
		
		BoundedBuffer buffer = new BoundedBuffer(bufferSize);
		
		// Load in buffer from saved file
		try {
			System.out.print("Loading buffer...");
			buffer = s.loadBuffer("savedBuffer");
			System.out.println("Loading successful!");
		} catch (ClassNotFoundException | IOException | NullPointerException e1) {
			System.out.println("Error loading selected buffer!\nStarting new buffer...\n");
		}
		
		// GUI
		ProducerForm pf = new ProducerForm();
		ConsumerForm cf = new ConsumerForm();
		
		// Producer and Consumer 
		Producer p = new Producer(pf, buffer);
		Consumer c = new Consumer(cf, buffer);
		
		p.start();
		c.start();
		
		// Set GUI to visible
		pf.setVisible(true);
		cf.setVisible(true);
		 
		System.out.print("Waiting for threads...");
		try {
			p.join();
			c.join();
		} catch (InterruptedException e) {
		}
		System.out.println("Threads terminated!");
		
		buffer.printBuffer();
		
		// Save buffer to file
		try {
			System.out.print("Saving buffer...");
			s.saveBuffer(buffer, "savedBuffer");
			System.out.print("Save successful!");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.print("Error saving buffer!");
		}
		catch(NullPointerException e){
			BoundedBuffer emptyBuffer = new BoundedBuffer(bufferSize);
			try {
				s.saveBuffer(emptyBuffer, "savedBuffer");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
