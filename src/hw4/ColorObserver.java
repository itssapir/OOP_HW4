package hw4;

/*
 * This is the interface to be implemented by all objects that intend to observe
 * the color of the color generator in the system.
 * the color generator will notify all its observers by calling their colorChanged() method.
 */
public interface ColorObserver {
	public void colorChanged();
}
