package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import gui.MoneyViewer;
import gui.WindowFrame;

public class ButtonViewListener implements ActionListener {

	WindowFrame frame;
	
	public ButtonViewListener(WindowFrame frame) {
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton b=(JButton) e.getSource();
		System.out.println(b.getText());
		MoneyViewer viewer=frame.getMoneyviewer();
		frame.setupPanel(viewer);
	}

}
