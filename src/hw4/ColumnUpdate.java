package hw4;

import java.util.ArrayList;

/*
 * This class defines a column ordered color update strategy.
 * With this strategy, the order in which the observers in the system receive their updates 
 * will be from top to bottom, left to right, one column at a time.
 */
public class ColumnUpdate implements UpdateStrategy {

	// Abs. function:
	// represents a column ordered update strategy object
	// this object has no state, it simply gives it's implementation for the observer updates
	//
	// Rep. Invariant:
	// none since there is no state
	
	static final int UPDATEDELAYTIME = 40; // ms 
	static final int BOARDSIZE = 5;

	// notify all observers about the color change
	// do it in a column order
	@Override
	public void update(ArrayList<ColorObserver> observers) {
		for (int row = 0; row < BOARDSIZE; ++row) {
			for (int col = 0; col < BOARDSIZE; ++col) {
				(observers.get(row + BOARDSIZE*col)).colorChanged();				
				try {
					Thread.sleep(UPDATEDELAYTIME);
				} catch (InterruptedException e) {
				}
			}
		}
	}

}
