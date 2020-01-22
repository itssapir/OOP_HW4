package hw4;

import java.awt.Color;

import javax.swing.JPanel;

public class Panel implements ColorObserver {

	private JPanel panel;
	
	public Panel(Color color) {
		panel = new JPanel();
		panel.setBackground(color);
		panel.paintImmediately(panel.getVisibleRect());
	}

	@Override
	public void colorChanged() {
		ColorSubject colorGen = ColorGenerator.getInstance();
		Color newCol = colorGen.getColor();
		panel.setBackground(newCol);
		panel.paintImmediately(panel.getVisibleRect());
	}
	
	public JPanel getJpanel() {
		return panel;
	}
}
