package gui;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.KeyEvent;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class GUI extends JFrame {
	private Color green = new Color(0, 250, 0);
	private Color green1 = new Color(0, 200, 100);
	private Color red = new Color(250, 0, 0);
	// private Color blue = new Color(0, 0, 250);
	// private Color purple = new Color(100, 0, 100);
	// private Color white = new Color(255, 255, 255);

	private Dimension winsize = new Dimension(800, 600);
	private Dimension infosize = new Dimension(800, 100);
	private Dimension bottomsize = new Dimension(800, 200);
	private Dimension boxsize = new Dimension(750, 300);
	private Dimension answersize = new Dimension(350, 100);
	/*
	 * window contents
	 */
	public static JFrame window = new JFrame("Uni-Quiz");
	JPanel container = new JPanel();
	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	JPanel spacer = new JPanel();
	JLabel player = new JLabel("Player:");
	static JLabel name = new JLabel("Player Name");
	JLabel score = new JLabel("Score:");
	JLabel question = new JLabel("Question:");
	static JLabel correct = new JLabel("X");
	static JLabel outof = new JLabel("Y");
	JLabel dash = new JLabel(" / ");
	static JLabel questiontext = new JLabel("This is a default guestion text.");
	JLabel builtby = new JLabel("Uni-Quiz is built by Nicky =^-^=");
	/*
	 * menu
	 */
	JMenuBar menubar = new JMenuBar();
	JMenu quiz = new JMenu("Quiz");
	JMenuItem newquiz = new JMenuItem("New");
	JMenuItem help = new JMenuItem("Help");
	JMenuItem exit = new JMenuItem("Exit");
	/*
	 * buttons
	 */
	static JButton next = new JButton("Next");
	static JPanel answerA = new JPanel();
	static JPanel answerB = new JPanel();
	static JPanel answerC = new JPanel();
	static JPanel answerD = new JPanel();
	static JLabel textA = new JLabel("Answer A");
	static JLabel textB = new JLabel("Answer B");
	static JLabel textC = new JLabel("Answer C");
	static JLabel textD = new JLabel("Answer D");

	public GUI() {
	};

	public JFrame Window() {
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setPreferredSize(winsize);
		window.setResizable(false);
		window.setIconImage(new ImageIcon("src/icon.png").getImage());
		// icon from: http://zh.wikipedia.org/wiki/File:Icon_apps_query.svg
		window.setSize(winsize);
		window.setLocationRelativeTo(null);

		menubar.setPreferredSize(new Dimension(800, 20));
		menubar.setOpaque(true);

		exit.setMnemonic(KeyEvent.VK_C);
		exit.setToolTipText("Exit application");
		exit.addActionListener(Actions.exit);

		help.setMnemonic(KeyEvent.VK_C);
		help.setToolTipText("Get help");
		help.addActionListener(Actions.help);

		newquiz.setMnemonic(KeyEvent.VK_C);
		newquiz.setToolTipText("Start a new quiz");
		newquiz.addActionListener(Actions.newquiz);
		menubar.add(quiz);
		quiz.add(newquiz);
		quiz.add(help);
		quiz.addSeparator();
		quiz.add(exit);

		/*
		 * window layout
		 */
		FlowLayout w_layout = new FlowLayout(FlowLayout.CENTER);
		/*
		 * question container layout
		 */
		GridBagLayout q_layout = new GridBagLayout();
		q_layout.columnWidths = new int[] { 1, 1, 1, 1 };
		q_layout.rowHeights = new int[] { 1, 1, 1 };
		q_layout.columnWeights = new double[] {0.0, 1.0, 1.0, 0.0, Double.MIN_VALUE };
		q_layout.rowWeights = new double[] { 1.0, 1.0, 1.0, Double.MIN_VALUE };

		/*
		 * question:
		 */
		GridBagConstraints qq = new GridBagConstraints();
		qq.insets = new Insets(10, 10, 10, 10);
		qq.gridwidth = 1;
		qq.gridheight = 1;
		qq.fill = GridBagConstraints.BOTH;
		qq.anchor = GridBagConstraints.CENTER;
		qq.gridx = 0;
		qq.gridy = 0;
		/*
		 * question text constraints
		 */
		GridBagConstraints qt = new GridBagConstraints();
		qt.insets = new Insets(10, 10, 10, 10);
		qt.gridwidth = 3;
		qt.gridheight = 1;
		qt.fill = GridBagConstraints.BOTH;
		qt.anchor = GridBagConstraints.CENTER;
		qt.gridx = 1;
		qt.gridy = 0;
		/*
		 * answerA constraints
		 */
		GridBagConstraints aA = new GridBagConstraints();
		aA.insets = new Insets(5, 5, 5, 5);
		aA.gridwidth = 2;
		aA.gridheight = 1;
		// aA.fill = GridBagConstraints.NONE;
		aA.anchor = GridBagConstraints.CENTER;
		aA.gridx = 0;
		aA.gridy = 1;
		/*
		 * answerB constraints
		 */
		GridBagConstraints aB = new GridBagConstraints();
		aB.insets = new Insets(5, 5, 5, 5);
		aB.gridwidth = 2;
		aB.gridheight = 1;
		aB.fill = GridBagConstraints.NONE;
		aB.anchor = GridBagConstraints.CENTER;
		aB.gridx = 2;
		aB.gridy = 1;
		/*
		 * answerC constraints
		 */
		GridBagConstraints aC = new GridBagConstraints();
		aC.insets = new Insets(5, 5, 5, 5);
		aC.gridwidth = 2;
		aC.gridheight = 1;
		aC.fill = GridBagConstraints.NONE;
		aC.anchor = GridBagConstraints.CENTER;
		aC.gridx = 0;
		aC.gridy = 2;
		/*
		 * answerD constraints
		 */
		GridBagConstraints aD = new GridBagConstraints();
		aD.insets = new Insets(5, 5, 5, 5);
		aD.gridwidth = 2;
		aD.gridheight = 1;
		aD.fill = GridBagConstraints.NONE;
		aD.anchor = GridBagConstraints.CENTER;
		aD.gridx = 2;
		aD.gridy = 2;

//		answerA.setBackground(red);
		answerA.setPreferredSize(answersize);
		answerA.setMaximumSize(answersize);
		answerA.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		answerA.add(textA);
		answerA.setEnabled(false);
//		answerB.setBackground(green);
		answerB.setPreferredSize(answersize);
		answerB.setMaximumSize(answersize);
		answerB.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		answerB.add(textB);
		answerB.setEnabled(false);
		answerC.setPreferredSize(answersize);
		answerC.setMaximumSize(answersize);
		answerC.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		answerC.add(textC);
		answerC.setEnabled(false);
		answerD.setPreferredSize(answersize);
		answerD.setMaximumSize(answersize);
		answerD.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		answerD.add(textD);
		answerD.setEnabled(false);

		correct.setForeground(green1);
		spacer.setPreferredSize(new Dimension(400, 10));
		top.setLayout(new BoxLayout(top, BoxLayout.X_AXIS));
		top.setPreferredSize(infosize);
		top.add(Box.createRigidArea(new Dimension(50, 0)));
		top.add(player);
		top.add(Box.createRigidArea(new Dimension(10, 0)));
		top.add(name);
		top.add(Box.createRigidArea(new Dimension(450, 0)));
		top.add(score);
		top.add(Box.createRigidArea(new Dimension(10, 0)));
		top.add(correct);
		top.add(dash);
		top.add(outof);

		container.setLayout(q_layout);
		container.setPreferredSize(boxsize);
		container.add(question, qq);
		container.add(questiontext, qt);
		container.add(answerA, aA);
		container.add(answerB, aB);
		container.add(answerC, aC);
		container.add(answerD, aD);

		next.setEnabled(false);
		next.addActionListener(Actions.next);
		bottom.setLayout(new BoxLayout(bottom, BoxLayout.LINE_AXIS));
		bottom.setPreferredSize(bottomsize);
		bottom.add(Box.createRigidArea(new Dimension(50, 0)));
		bottom.add(builtby);
		bottom.add(Box.createRigidArea(new Dimension(400, 0)));
		bottom.add(next);
		// bottom.add(Box.createRigidArea(new Dimension(5,0)));

		/*
		 * build and make visible
		 */
		window.setLayout(w_layout);
		window.setJMenuBar(menubar);
		window.add(top);
		window.add(container);
		window.add(bottom);
		window.pack();
		window.setVisible(true);

		return window;
	}

	public void showWindow() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				Window();
			}
		});
	}
}
