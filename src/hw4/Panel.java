package hw4;

import java.awt.Color;

import javax.swing.JPanel;

/*
 * Represents a panel in the system.
 * each panel represents a panel in the systems GUI.
 * The panel is an observer of a color producer, and will display a color based
 * on the color that is set by that producer
 * 
 */
public class Panel implements ColorObserver {

	// Abs. function:
	// represents a Panel in the system where:
	// panel is the GUI object to be used by the JFrame
	//
	// Rep. Invariant:
	// panel != null

	private JPanel panel;
	
	/**
	 * @modifies this
	 * @effects create the panel, starting with background color "color"
	 */
	public Panel(Color color) {
		panel = new JPanel();
		panel.setBackground(color);
		panel.paintImmediately(panel.getVisibleRect());
		checkRep();
	}

	/**
	 * @modifies this
	 * @effects receive a notice from the color generator telling us that the color has changed.
	 * 			change the background color to fit the new color.
	 */
	@Override
	public void colorChanged() {
		checkRep();
		ColorSubject colorGen = ColorGenerator.getInstance();
		Color newCol = colorGen.getColor();
		panel.setBackground(newCol);
		panel.paintImmediately(panel.getVisibleRect());
		checkRep();
	}
	
	/**
	 * @return JPanel of this Panel
	 */
	public JPanel getJpanel() {
		checkRep();
		return panel;
	}
	
	private void checkRep() {
		assert panel != null : "Panel.panel == null";
	}
}
