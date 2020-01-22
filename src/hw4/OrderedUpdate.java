package hw4;

import java.util.ArrayList;

public class OrderedUpdate implements UpdateStrategy {

	@Override
	public void update(ArrayList<ColorObserver> observers) {
		// TODO Auto-generated method stub
		for (int i = 0; i < observers.size(); ++i) {
			(observers.get(i)).colorChanged();
		}
		
	}

}
