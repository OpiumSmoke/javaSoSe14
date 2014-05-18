package gui;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class EndGame extends JFrame {
	public Dimension winsize = new Dimension(400, 200);
	public Dimension condim = new Dimension(400, 120);
	public Dimension btnsdim = new Dimension(400, 80);
	
	Color green = new Color(0, 250, 0);
	Color red = new Color(250, 0, 0);
	Color blue = new Color(0, 0, 250);
	Color purple = new Color(100, 0, 100);

	static JFrame end = new JFrame("Game over!");
	JPanel container = new JPanel();
	JPanel buttons = new JPanel();
	JButton save = new JButton("Save results");
	JButton exit = new JButton("Exit application");
	JButton again = new JButton("Play again");

	static JLabel name = new JLabel("name");
	JLabel youhave = new JLabel("you have answered");
	static JLabel right = new JLabel("X");
	JLabel outof = new JLabel("out of");
	static JLabel all = new JLabel("Y");
	JLabel questions = new JLabel("questions!");
	JLabel wanna = new JLabel("What do you want to do now?");
	FlowLayout w_layout = new FlowLayout(FlowLayout.CENTER);

	public EndGame() {
	}

	public JFrame End(String playername, int correct, int rounds) {
		end.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		end.setPreferredSize(winsize);
		end.setIconImage(new ImageIcon("src/icon.png").getImage());
		end.setSize(winsize);
		end.setLocationRelativeTo(null);
		end.setResizable(false);

		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] { 1, 1, 1, 1, 1 };
		layout.rowHeights = new int[] { 1, 1, 1, 1 };
		layout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		layout.rowWeights = new double[] { 1.0, 0.0, 0.0, Double.MIN_VALUE };

		GridBagConstraints name_c = new GridBagConstraints();
		name_c.insets = new Insets(5, 5, 5, 5);
		name_c.gridwidth = 5;
		name_c.gridheight = 1;
		name_c.fill = GridBagConstraints.BOTH;
		name_c.anchor = GridBagConstraints.CENTER;
		name_c.gridx = 1;
		name_c.gridy = 0;

		GridBagConstraints yh_c = new GridBagConstraints();
		yh_c.insets = new Insets(5, 40, 0, 5);
		yh_c.gridwidth = 1;
		yh_c.gridheight = 1;
		yh_c.fill = GridBagConstraints.BOTH;
		yh_c.anchor = GridBagConstraints.CENTER;
		yh_c.gridx = 0;
		yh_c.gridy = 1;

		GridBagConstraints rght_c = new GridBagConstraints();
		rght_c.insets = new Insets(5, 5, 0, 5);
		rght_c.gridwidth = 1;
		rght_c.gridheight = 1;
		rght_c.fill = GridBagConstraints.BOTH;
		rght_c.anchor = GridBagConstraints.CENTER;
		rght_c.gridx = 1;
		rght_c.gridy = 1;

		GridBagConstraints oo_c = new GridBagConstraints();
		oo_c.insets = new Insets(5, 5, 0, 5);
		oo_c.gridwidth = 1;
		oo_c.gridheight = 1;
		oo_c.fill = GridBagConstraints.BOTH;
		oo_c.anchor = GridBagConstraints.CENTER;
		oo_c.gridx = 2;
		oo_c.gridy = 1;

		GridBagConstraints all_c = new GridBagConstraints();
		all_c.insets = new Insets(5, 5, 0, 5);
		all_c.gridwidth = 1;
		all_c.gridheight = 1;
		all_c.fill = GridBagConstraints.BOTH;
		all_c.anchor = GridBagConstraints.CENTER;
		all_c.gridx = 3;
		all_c.gridy = 1;

		GridBagConstraints q_c = new GridBagConstraints();
		q_c.insets = new Insets(5, 5, 0, 5);
		q_c.gridwidth = 1;
		q_c.gridheight = 1;
		q_c.fill = GridBagConstraints.BOTH;
		q_c.anchor = GridBagConstraints.CENTER;
		q_c.gridx = 4;
		q_c.gridy = 1;

		GridBagConstraints wanna_c = new GridBagConstraints();
		wanna_c.insets = new Insets(5, 100, 5, 5);
		wanna_c.gridwidth = 5;
		wanna_c.gridheight = 1;
		wanna_c.fill = GridBagConstraints.BOTH;
		wanna_c.anchor = GridBagConstraints.CENTER;
		wanna_c.gridx = 0;
		wanna_c.gridy = 2;

		GridBagConstraints btns_c = new GridBagConstraints();
		btns_c.insets = new Insets(0, 0, 0, 0);
		btns_c.gridwidth = 5;
		btns_c.gridheight = 1;
		btns_c.fill = GridBagConstraints.BOTH;
		btns_c.anchor = GridBagConstraints.CENTER;
		btns_c.gridx = 0;
		btns_c.gridy = 3;
		
		save.addActionListener(Actions.save);
		exit.addActionListener(Actions.exit);
		again.addActionListener(Actions.newquiz);
		
		name.setText(playername);
		right.setText(String.valueOf(correct));
		all.setText(String.valueOf(rounds));
		
		container.setPreferredSize(condim);
		container.setLayout(layout);
		
		container.add(name, name_c);
		container.add(youhave, yh_c);
		container.add(right, rght_c);
		container.add(outof, oo_c);
		container.add(all, all_c);
		container.add(questions, q_c);
		container.add(wanna, wanna_c);
		
		buttons.setPreferredSize(btnsdim);
		buttons.add(save);
		buttons.add(again);
		buttons.add(exit);
		
		end.setLayout(w_layout);
		end.add(container);
		end.add(buttons);

		end.pack();
		end.setVisible(true);

		return end;
	}

}
