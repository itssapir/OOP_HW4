package hw4;

import java.util.ArrayList;

/*
 * This is the interface used by any object in the system that defines a color update strategy.
 * e.g. In row order, column order, random, etc.
 */
public interface UpdateStrategy {
	public void update(ArrayList<ColorObserver> observers);
}
