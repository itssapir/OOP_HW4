package hw4;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Billboard extends JFrame implements ActionListener {
	static final int NUMROW = 5;
	static final int NUMCOL = 5;
	static final int NUMPANELS = NUMCOL * NUMROW;
	static final Color DEFAULTCOL = Color.BLACK;
	static final int PANELLEN = 600;
	static final int PANELHIEGH= 400;

	List<Panel> panels = new ArrayList<>();
	private JMenuBar menuBar;
	private JMenu strategyMenu;
	private JMenuItem AscendingStrat, ColumnStrat, OddEvenStrat, RandomStrat;
	
	public Billboard() {
		super("Billboard Beggins");
		createBackground();
		createMenuBar();// TODO: setJMenuBar(menuBar) in createMenuBar
		
		ColorSubject colorGen = ColorGenerator.getInstance();
		for (int i = 0; i < NUMPANELS; ++i) {
			Panel panel = new Panel(DEFAULTCOL);
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

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
