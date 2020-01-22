package hw4;

import java.util.ArrayList;

/*
 * This class defines a checker board pattern ordered color update strategy.
 * With this strategy, the order in which the observers in the system receive their updates 
 * will be: all odd numbered panels first, and then all even numbers
 */
public class OddEvenUpdate implements UpdateStrategy {

	// Abs. function:
	// represents a checker board pattern ordered update strategy object
	// this object has no state, it simply gives it's implementation for the observer updates
	//
	// Rep. Invariant:
	// none since there is no state

	static final int UPDATEDELAYTIME = 40; // ms 

	// notify all observers about the color change
	// first notify odd numbered panels, and then even
	@Override
	public void update(ArrayList<ColorObserver> observers) {
		for (int i = 0; i < 2; ++i) {
			for (int j = 0; (j + i) < observers.size(); j += 2) {
				(observers.get(j + i)).colorChanged();
				try {
					Thread.sleep(UPDATEDELAYTIME);
				} catch (InterruptedException e) {
				}
			}
		}
		
	}

}
