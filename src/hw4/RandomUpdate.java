package hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * This class defines a random color update strategy.
 * With this strategy, the order in which the observers in the system receive their updates 
 * will be random each time.
 */
public class RandomUpdate implements UpdateStrategy {

	// Abs. function:
	// represents a random update strategy object
	// this object has no state, it simply gives it's implementation for the observer updates
	//
	// Rep. Invariant:
	// none since there is no state
	
	static final int UPDATEDELAYTIME = 40; // ms 

	/**
	 * @effects notify all observers about a change in the subject.
	 * 			does so in a random order
	 */
	@Override
	public void update(ArrayList<ColorObserver> observers) {
		List<ColorObserver> randList = new ArrayList<>(observers);
		Collections.shuffle(randList);
		for (ColorObserver observer : randList) {
			observer.colorChanged();
			try {
				Thread.sleep(UPDATEDELAYTIME);
			} catch (InterruptedException e) {
			}
		}
	}

}
