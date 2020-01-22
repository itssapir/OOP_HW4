package hw4;

import java.awt.Color;

public class Panel implements ColorObserver {

	Color panelColor;
	int id; // TODO: remove id from this class
	
	public Panel(Color color, int id) {
		panelColor = color;
		this.id = id;
	}

	@Override
	public void colorChanged() {
		ColorSubject colorGen = ColorGenerator.getInstance();
		panelColor = colorGen.getColor();
		System.out.println("Panel number " + id + " is color " + panelColor);
	}

	// TODO: GUI stuff
}
