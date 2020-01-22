package hw4;

import java.util.ArrayList;

public class ColumnUpdate implements UpdateStrategy {
	
	static final int BOARDSIZE = 5;

	@Override
	public void update(ArrayList<ColorObserver> observers) {
		// TODO Auto-generated method stub
		for (int row = 0; row < BOARDSIZE; ++row) {
			for (int col = 0; col < BOARDSIZE; ++col) {
				(observers.get(row + BOARDSIZE*col)).colorChanged();				
			}
		}
	}

}
