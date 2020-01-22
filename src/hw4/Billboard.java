package hw4;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

public class Billboard {

	static final int NUMPANELS = 25;
	static final Color DEFAULTCOL = Color.WHITE;
	List<Panel> panels = new ArrayList<>();
	
	public Billboard() {
		ColorSubject colorGen = ColorGenerator.getInstance();
		for (int i = 0; i < NUMPANELS; ++i) {
			Panel panel = new Panel(DEFAULTCOL,i);
			panels.add(panel);
			colorGen.attach(panel);
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Billboard board = new Billboard();
		ColorGenerator colorGen = ColorGenerator.getInstance();
		colorGen.setStrategy(new OrderedUpdate());
		while(true);
	}

}
