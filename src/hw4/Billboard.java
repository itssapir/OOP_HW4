package hw4;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Billboard extends JFrame implements ActionListener {
	static final int NUMROW = 5;
	static final int NUMCOL = 5;
	static final int NUMPANELS = NUMCOL * NUMROW;
	static final Color DEFAULTCOL = Color.BLUE;
	static final int PANELLEN = 600;
	static final int PANELHIEGH= 400;

	List<Panel> panels = new ArrayList<>();
	private JMenuBar menuBar;
	private JMenu strategyMenu;
	private JMenuItem AscendingStrat, ColumnStrat, OddEvenStrat, RandomStrat;
	
	public Billboard() {
		super("Billboard Beggins");
		createBackground();
		createMenuBar();
		
		ColorSubject colorGen = ColorGenerator.getInstance();
		for (int i = 0; i < NUMPANELS; ++i) {
			Panel panel = new Panel(DEFAULTCOL);
			panels.add(panel);
			colorGen.attach(panel);
			add(panel.getJpanel());
		}
	}

	private void createMenuBar() {
		
		menuBar = new JMenuBar();
		strategyMenu = new JMenu("strategy Menu");
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

	private void createBackground() {
		setBackground(Color.WHITE);
        setSize(new Dimension(PANELLEN, PANELHIEGH));
		setLayout(new GridLayout(NUMROW,NUMCOL));	
	}

	public static void main(String[] args) {
		Billboard board = new Billboard();
		board.setVisible (true);
		board.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent stratEvent) {
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
			assert false;
		}
	}

}
