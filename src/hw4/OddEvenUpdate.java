package hw4;

import java.util.ArrayList;

public class OddEvenUpdate implements UpdateStrategy {

	static final int UPDATEDELAYTIME = 40; // ms 

	@Override
	public void update(ArrayList<ColorObserver> observers) {
		// TODO Auto-generated method stub
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
