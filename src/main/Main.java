package main;

import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import controller.MainController;
import model.Model;
import views.MainFrame;

public class Main {

	public static void main(String[] args) {
		//To make sure that everything with GUI is done from event dispatch thread
		//There won't be any background tasks or heavy calculations
		SwingUtilities.invokeLater(() -> {
			Main main = new Main();
			main.run();
		});
	}
	
	private void run() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (Exception e) { } //ignore it
		
		
		MainFrame mainFrame = new MainFrame();
		Model model = new Model();
		new MainController(mainFrame, model);
	}
}
