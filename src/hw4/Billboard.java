package hw4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

/*
 * Represents a billboard in the system.
 * the billboard is a GUI interface that contains 25 panels.
 * each panel's background is updated when the systems color generator
 * chooses a new color. it is possible to change the color update order of the different panels.
 */
public class Billboard extends JFrame implements ActionListener {
	
	// Abs. function:
	// represents a billboard GUI window in the system where:
	// 		panels holds all of the panels in the system
	// 		menuBar is the object representing the menu bar of the GUI window
	//		strategyMenu is a drop down menu option in the menu bar
	//		AscendingStrat, ColumnStrat, OddEvenStrat, RandomStrat are the drop down menu options
	//
	// Rep. Invariant:
	// panels != null && panels.size() == 25
	// menuBar != null
	// strategyMenu != null
	// AscendingStrat != null, ColumnStrat != null, OddEvenStrat != null, RandomStrat != null
	// menuBar contains strategyMenu
	// strategyMenu contains all four strategies

	static final int NUMROW = 5;
	static final int NUMCOL = 5;
	static final int NUMPANELS = NUMCOL * NUMROW;
	static final Color DEFAULTCOL = Color.BLUE;
	static final int PANELLEN = 600;
	static final int PANELHIEGH= 400;

	private List<Panel> panels = new ArrayList<>();
	private JMenuBar menuBar;
	private JMenu strategyMenu;
	private JMenuItem AscendingStrat, ColumnStrat, OddEvenStrat, RandomStrat;
	
	/**
	 * @modifies this
	 * @effects create a new instance of a billboard,
	 * 			which contains 25 panels in a 5x5 grid,
	 * 			the color of the panels is determined by the color generator of the system.
	 */
	public Billboard() {
		super("Billboard Beggins");
		// create the basic GUI window, with a grid and a menu bar
		createBackground();
		createMenuBar();
		
		// create the panels for the window, add them as observers to the color generator
		ColorSubject colorGen = ColorGenerator.getInstance();
		for (int i = 0; i < NUMPANELS; ++i) {
			Panel panel = new Panel(DEFAULTCOL);
			panels.add(panel);
			colorGen.attach(panel);
			add(panel.getJpanel());
		}
		checkRep();
	}

	/**
	 * @modifies this
	 * @effects create the menu bar and all of the options inside of it
	 */
	private void createMenuBar() {
		menuBar = new JMenuBar();
		strategyMenu = new JMenu("Update order");
		menuBar.add(strategyMenu);
		
		AscendingStrat = new JMenuItem("Ascending order");
		ColumnStrat = new JMenuItem("Column order");
		OddEvenStrat = new JMenuItem("OddEven order");
		RandomStrat = new JMenuItem("Random order");
		
		strategyMenu.add(AscendingStrat);
		AscendingStrat.addActionListener(this);
		
		strategyMenu.add(ColumnStrat);
		ColumnStrat.addActionListener(this);
		
		strategyMenu.add(OddEvenStrat);
		OddEvenStrat.addActionListener(this);
		
		strategyMenu.add(RandomStrat);
		RandomStrat.addActionListener(this);
		
        setJMenuBar(menuBar);
		
	}

	/**
	 * @modifies this
	 * @effects create the base GUI window with a grid layout
	 */
	private void createBackground() {
		setBackground(Color.WHITE);
        setSize(new Dimension(PANELLEN, PANELHIEGH));
		setLayout(new GridLayout(NUMROW,NUMCOL));	
	}

	/**
	 * @effects main function, creates the billboard and makes the GUI visible
	 */
	public static void main(String[] args) {
		Billboard board = new Billboard();
		board.setVisible (true);
		board.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}

	/**
	 * @modifies ColorGenerator
	 * @effects when a strategy is selected in the GUI,
	 * 			this will change the color generator's strategy
	 * 			to the new one
	 */
	@Override
	public void actionPerformed(ActionEvent stratEvent) {
		checkRep();
		JMenuItem event = (JMenuItem)(stratEvent.getSource());
		ColorGenerator colorGen = ColorGenerator.getInstance();
		if (event.equals(AscendingStrat)) {
			colorGen.setStrategy(new OrderedUpdate());
		} else if (event.equals(ColumnStrat)) {
			colorGen.setStrategy(new ColumnUpdate());
		} else if (event.equals(OddEvenStrat)) {
			colorGen.setStrategy(new OddEvenUpdate());
		} else if (event.equals(RandomStrat)) {
			colorGen.setStrategy(new RandomUpdate());
		} else { //error
			assert false : "Unfamiliar action performed";
		}
		checkRep();
	}

	private void checkRep() {
		assert (panels != null && panels.size() == 25) : "Billboard missing panels";
		assert menuBar != null : "Billboard missing menuBar";
		assert strategyMenu != null : "Billboard missing strategyMenu";
		assert ( (AscendingStrat != null) &&
				 (ColumnStrat != null)    &&
				 (OddEvenStrat != null)   &&
				 (RandomStrat != null) )	: "Billboard missing a strategy object";
		assert (menuBar.getMenu(0) == strategyMenu) : "Billboard menu bar is missing a strategy menu";
		assert (strategyMenu.getItem(0) == AscendingStrat) : "Billboard strategy menu missing ascending strat";
		assert (strategyMenu.getItem(0) == ColumnStrat) : "Billboard strategy menu missing column strat";
		assert (strategyMenu.getItem(0) == OddEvenStrat) : "Billboard strategy menu missing odd-even strat";
		assert (strategyMenu.getItem(0) == RandomStrat) : "Billboard strategy menu missing random strat";
	}
}
