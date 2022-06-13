package listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;

import javax.swing.JButton;

import gui.MoneyViewer;
import gui.WindowFrame;
import manager.MoneyManager;

public class ButtonViewerListener implements ActionListener {

	WindowFrame frame;
	
	public ButtonViewerListener(WindowFrame frame) {
		this.frame=frame;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		MoneyViewer moneyViewer=frame.getMoneyviewer();
		MoneyManager moneymanager=getObject("moneymanager.ser");
		moneyViewer.setMoneymanager(moneymanager);
		frame.getContentPane().removeAll();
		frame.getContentPane().add(moneyViewer);
		frame.revalidate();
		frame.repaint();
	}
	
	public static MoneyManager getObject(String fileName) {
		MoneyManager moneymanager=null;
		try {
			FileInputStream file=new FileInputStream(fileName);
			ObjectInputStream in=new ObjectInputStream(file);
			
			moneymanager=(MoneyManager)in.readObject();
			
			in.close();
			file.close();
		}catch(FileNotFoundException e) {
			return moneymanager;
		}catch(IOException e) {
			e.printStackTrace();
		}catch(ClassNotFoundException e) {
			e.printStackTrace();
		}
		return moneymanager;
	}

}
