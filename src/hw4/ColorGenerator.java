package hw4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

import javax.swing.*;
/*
 * ColorGenerator implements a Singleton, concreteSubject of Color Generator and a Context for Update Order Strategy,
 * the ColorGenerator object change it's color every defined time 
 * and update the observers about it according to the current update policy  
 */
public class ColorGenerator extends ColorSubject {
	// Abs. Function:
	// represents a singleton concreteSubject for ColorSubject who need to update it's observers about it's color
	// according to it's Update Order Strategy, with:
	//		reference to the unique object at this.inst
	//		observers update order strategy at this.strategy
	// Rep. Invariant:
	//		strategy != null 
	
	static private ColorGenerator inst = null;
	private UpdateStrategy strategy;

	/**
	 * @modifies this
	 * @effects create new instance of ColorGenerator, change it's color to random color every
	 * 			2 seconds, and notify all the observers about the change.
	 */	
	private ColorGenerator() {
		//set strategy default value
		strategy = new OrderedUpdate();
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
				notifyAllObservers();
            }
        });
        timer.start();
        checkRep();
	}
	
	/**
	 * @modifies this
	 * @effects if strategy != null :set a new update order strategy to this
	 */	
	public void setStrategy(UpdateStrategy strategy) {
        checkRep();
        if (strategy == null) {
        	return;
        }
		this.strategy = strategy;
        checkRep();
	}

	/**
	 * @effects notify all the observers according to the current update order strategy
	 */	
	public void notifyAllObservers() {
        checkRep();
		strategy.update(observers);
        checkRep();
	}

	/**
	 * @modifies this
	 * @effects if ColorGenerator never created before: create a new instance of ColorGenerator, and update that was created
	 * 			and in any case return instance of the unique ColorGenerator object.
	 */	
	static public ColorGenerator getInstance() {
		// Singleton
		if (inst == null) {
			inst = new ColorGenerator();
		}
		inst.checkRep();
		return inst;
	}
	
	private void checkRep() {
		assert strategy != null : "the strategy is null";
	}
}
