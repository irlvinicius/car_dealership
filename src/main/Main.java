package main;

// import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import Controller.ClienteController;

import GUI.FormGUI;


public class Main {

	public static void main(String[] args) {
		ClienteController pessoaCtrl = new ClienteController();
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				FormGUI frame = new FormGUI(pessoaCtrl);
				frame.setVisible(true);	
	


				
				
			}
		});
	}
}
