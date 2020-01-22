package hw4;

import java.awt.Color;
import java.util.ArrayList;
/*
 * ColorSubject implements an abstract Subject of Observer-Design pattern,
 * consist modifiable list of observers objects and self-state: the current color 
 */
abstract public class ColorSubject {
	// Abs. Function:
	// represents a Subject for concreteSubjects who need to update observers about their color, with:
	//		observers list at this.observers
	//		self color at this.color
	// Rep. Invariant:
	//		color != null 
	
	protected ArrayList<ColorObserver> observers = new ArrayList<>();
	protected Color color;

	/*
	 * @modifies this
	 * @effects if observer != null and observer not in observers: insert observer to the observers list.
	 */
	public void attach(ColorObserver observer) {
		checkRep();
		if (observer == null) {
			return;
		}
		observers.add(observer);
		checkRep();
	}

	/*
	 * @modifies this
	 * @effects if observer != null and observer in observers: remove observer to the observers list.
	 */
	public void detach(ColorObserver observer) {
		checkRep();
		if (observer == null) {
			return;
		}
		observers.remove(observer);
		checkRep();
	}

	/*
	 * @return the color of the ColorSubject
	 */
	public Color getColor() {
		checkRep();
		return color;
	}

	/*
	 * @effects notify all of the observers.
	 */
	abstract public void notifyAllObservers();
	
	private void checkRep() {
		assert color != null : "ColorSubject.color == null";
	}
}
