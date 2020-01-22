package hw4;

import java.util.ArrayList;

/*
 * This class defines a row ordered color update strategy.
 * With this strategy, the order in which the observers in the system receive their updates 
 * will be from left to right, from top to bottom, one row at a time.
 */
public class OrderedUpdate implements UpdateStrategy {

	// Abs. function:
	// represents a row ordered update strategy object
	// this object has no state, it simply gives it's implementation for the observer updates
	//
	// Rep. Invariant:
	// none since there is no state

	static final int UPDATEDELAYTIME = 40; // ms 

	/**
	 * @effects notify all observers about a change in the subject.
	 * 			does so in a row order
	 */
	@Override
	public void update(ArrayList<ColorObserver> observers) {
		for (int i = 0; i < observers.size(); ++i) {
			(observers.get(i)).colorChanged();
			try {
				Thread.sleep(UPDATEDELAYTIME);
			} catch (InterruptedException e) {
			}
		}
		
	}

}
