/*
 * Owen Brown
 * 4838488
 */
package testing;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Producer Class
public class Producer extends Thread implements ActionListener, Runnable{

		ProducerForm form;
		BoundedBuffer buff;
		boolean okayPressed = false, quitPressed = false;
		
		public Producer(ProducerForm producerForm, BoundedBuffer bb){
			
			this.form = producerForm;
			this.buff = bb;
			
			form.Ok.addActionListener(this);
			form.Quit.addActionListener(this);
		}
		
		// Listener and sets boolean values
		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (arg0.getActionCommand() == "OK"){
				if (form.checkFields()){
					okayPressed = true;
				}
			}
			if (arg0.getActionCommand() == "Quit"){
				quitPressed = true;
				this.interrupt();
			}
		}
		
		// Adds order item to the bounded buffer
		// Clears the form for further interaction
		public void process(){
				buff.enqueue(getOrder());
				form.clearForm();
		}
		
		// Gets text from order object
		public Order getOrder(){
			Order temp = new Order();
			temp.fields[0] = form.dateField.getText();
			temp.fields[1] = form.timeField.getText();
			temp.fields[2] = form.orderField.getText();
			temp.fields[3] = form.itemField.getText();
			temp.fields[4] = form.quantityField.getText();
			temp.fields[5] = form.addressText.getText();
			return temp;
		}
		
		// Sleep while no form interactions
		// Quit if quit pressed
		// Process form data if Okay pressed
		@Override
		public void run() {
			while(true){
				System.out.print("Producer Running!");
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
	
