package hw4;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RandomUpdate implements UpdateStrategy {

	static final int UPDATEDELAYTIME = 40; // ms 

	@Override
	public void update(ArrayList<ColorObserver> observers) {
		// TODO Auto-generated method stub
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
