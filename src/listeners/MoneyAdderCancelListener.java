package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.MoneyAdder;
import gui.MoneyViewer;
import gui.WindowFrame;

public class MoneyAdderCancelListener implements ActionListener {

	WindowFrame frame;
	
	public MoneyAdderCancelListener(WindowFrame frame) {
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		frame.getContentPane().removeAll();
		frame.getContentPane().add(frame.getMenuselction());
		frame.revalidate();
		frame.repaint();
	}

}
