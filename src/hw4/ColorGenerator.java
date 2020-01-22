package hw4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;

public class ColorGenerator extends ColorSubject {

	static private ColorGenerator inst = null;
	private UpdateStrategy strategy;

	private ColorGenerator() {
		// start with default color
		Random rand = new Random();
		color = new Color(rand.nextInt());

		// set timer to change color every 2 seconds
        Timer timer = new Timer(2000, new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
				// generate new color
            	Color newCol;
				do {
					newCol = new Color(rand.nextInt());
				} while (newCol.equals(color));
				color = newCol;
				System.out.println("ColorGenerator.color = " + color);
				notifyAllObservers();
            }
        });
        timer.start();
	}
	

	public void setStrategy(UpdateStrategy strategy) {
		this.strategy = strategy;
	}

	public void notifyAllObservers() {
		strategy.update(observers);
	}

	static public ColorGenerator getInstance() {
		// Singleton
		if (inst == null) {
			inst = new ColorGenerator();
		}
		return inst;
	}
	
}
