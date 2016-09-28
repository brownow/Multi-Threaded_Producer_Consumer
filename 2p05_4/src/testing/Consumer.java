/*
 * Owen Brown
 * 4838488
 */
package testing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

//Consumer Class
public class Consumer extends Thread implements ActionListener, Runnable{

	ConsumerForm form;
	BoundedBuffer buff;
	boolean okayPressed = false, quitPressed = false;
	
	public Consumer(ConsumerForm cf, BoundedBuffer bb){
		this.form = cf;
		this.buff = bb;
		
		form.Ok.addActionListener(this);
		form.Quit.addActionListener(this);
	}
	// Listener and sets boolean values
	@Override
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getActionCommand() == "OK"){
			okayPressed = true;
		}
		if (arg0.getActionCommand() == "Quit"){
			quitPressed = true;
			this.interrupt();
		}
	}
	
	public void process(){
			Order temp = buff.dequeue();
			if (!quitPressed){			// Handles case where thread is interrupted by QUIT (and NULL is returned)
				printToForm(temp);
			}
	}
	
	// Print the Order object's data to the form for display
		private void printToForm(Order o){
			form.dateField.setText(o.fields[0]);
			form.timeField.setText(o.fields[1]);
			form.orderField.setText(o.fields[2]);
			form.itemField.setText(o.fields[3]);
			form.quantityField.setText(o.fields[4]);
			form.addressText.setText(o.fields[5]);
		}

		
		// Sleep while no form interactions
		// Quit if quit pressed
		// Process form data if Okay pressed
		@Override
		public void run() {
			while(true){
				System.out.print("Consumer Running!");
				while (!okayPressed & !quitPressed){
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						break;
					}
				}
				if (quitPressed){
					break;
				}
				process();
				okayPressed = false;
			}
			form.setVisible(false);
			form.dispose();
		}
}
