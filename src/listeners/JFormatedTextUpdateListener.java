package listeners;

import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

public class JFormatedTextUpdateListener implements DocumentListener {
	
	private Runnable callback;
	
	public JFormatedTextUpdateListener(Runnable callback) {
		this.callback = callback;
	}
	
	@Override
	public void insertUpdate(DocumentEvent e) {
		clearArithmeticInput();
	}

	@Override
	public void removeUpdate(DocumentEvent e) {
		clearArithmeticInput();
	}

	@Override
	public void changedUpdate(DocumentEvent e) {
		clearArithmeticInput();
	}
	
	private void clearArithmeticInput() {
		callback.run();;
	}
}
