package hw4;

import java.awt.Color;
import java.util.ArrayList;

abstract public class ColorSubject {

	protected ArrayList<ColorObserver> observers = new ArrayList<>();
	protected Color color;

	public void attach(ColorObserver observer) {
		observers.add(observer);
	}

	public void detach(ColorObserver observer) {
		observers.remove(observer);
	}
	
	public Color getColor() {
		return color;
	}

	abstract public void notifyAllObservers();
}
