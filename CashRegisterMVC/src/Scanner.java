// This window emulates the scanning of an item. Every time the buttom is pressed
// it will send a notification of a UPC code

import javax.swing.*;
import java.awt.*;
import java.util.Random;

import java.util.List;


public class Scanner {
	// Scanner uses Swing framework to create a UPC code
	 private JFrame frame;
	 private JPanel scannerPanel;
	 private JButton scanButton;

     private Controller controller;
	 private CashRegisterModel cashRegisterModel;

	 public Scanner(Controller controller, CashRegisterModel cashRegisterModel) {
         this.controller = controller;
		 this.cashRegisterModel = cashRegisterModel;
		  frame = new JFrame("Scanner");
		  frame.getContentPane().setLayout(new BorderLayout());
		  frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		  frame.setSize(100, 100);
		  frame.setLocation(300,50);
		  frame.setVisible(true);
		  
		  
		  // Create UI elements
		  scanButton = new JButton("Scan");
		  scannerPanel = new JPanel();
		  
		  // Add UI element to frame
		  scannerPanel.add(scanButton);
		  frame.getContentPane().add(scannerPanel);
		  
		  scanButton.addActionListener(e -> controller.scanItem(this.generateUPC()));
	 }

	private int generateUPC() {
         Random r = new Random();
         List<Integer> validUpcs = cashRegisterModel.getValidUpcs();
         int index = r.nextInt(validUpcs.size());
         return validUpcs.get(index);
	}

	public JFrame getFrame() {
		return frame;
	}

	public void setFrame(JFrame frame) {
		this.frame = frame;
	}

	public JPanel getScannerPanel() {
		return scannerPanel;
	}

	public void setScannerPanel(JPanel scannerPanel) {
		this.scannerPanel = scannerPanel;
	}

	public JButton getScanButton() {
		return scanButton;
	}

	public void setScanButton(JButton scanButton) {
		this.scanButton = scanButton;
	}	 
	 

}
