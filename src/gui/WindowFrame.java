package gui;

import javax.swing.JFrame;
import javax.swing.JPanel;

import manager.MoneyManager;

public class WindowFrame extends JFrame {

	MoneyManager moneymanager;
	
	MenuSelection menuselction;
	MoneyAdder moneyadder;
	MoneyViewer moneyviewer;
	
	
	
	public WindowFrame(MoneyManager moneymanager) {
	
		
		this.setSize(500,300);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("My Frame");
		
		this.moneymanager=moneymanager;
		this.menuselction=new MenuSelection(this);
		this.moneyadder=new MoneyAdder(this,this.moneymanager);
		moneyviewer=new MoneyViewer(this,this.moneymanager);
		
		
		
		this.setupPanel(menuselction);
		
		this.setVisible(true);
	}
	
	public void setupPanel(JPanel panel) {
		this.getContentPane().removeAll();
		this.getContentPane().add(panel);
		this.revalidate();
		this.repaint();
	}
	
	public MenuSelection getMenuselction() {
		return menuselction;
	}

	public void setMenuselction(MenuSelection menuselction) {
		this.menuselction = menuselction;
	}

	public MoneyAdder getMoneyadder() {
		return moneyadder;
	}

	public void setMoneyadder(MoneyAdder moneyadder) {
		this.moneyadder = moneyadder;
	}

	public MoneyViewer getMoneyviewer() {
		return moneyviewer;
	}

	public void setMoneyviewer(MoneyViewer moneyviewer) {
		this.moneyviewer = moneyviewer;
	}


}
