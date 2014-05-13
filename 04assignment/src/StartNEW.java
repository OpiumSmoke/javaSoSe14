import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class StartNEW extends JFrame {
	/**
	 * initializing main variables: size and color
	 */
	public Dimension winsize = new Dimension(400, 200);

	Color green = new Color(0, 250, 0);
	Color red = new Color(250, 0, 0);
	Color blue = new Color(0, 0, 250);
	Color purple = new Color(100, 0, 100);

	/**
	 * initialize main parts
	 */
	static JFrame start = new JFrame("Start a new quiz");
	JPanel container = new JPanel();
	JLabel name = new JLabel("Name:");
	JLabel rounds = new JLabel("Round count:");
	static JTextField name_field = new JTextField(25);
	static String[] count = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
	static JComboBox round_field = new JComboBox(count);
	// JTextField path = new JTextField(50);
	static String[] defpath = { "Choose file..." };
	static JComboBox path = new JComboBox(defpath);
	JButton startquiz = new JButton("Start quiz");

	public JFrame StartNEW() {
		start.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		start.setPreferredSize(winsize);
		start.setIconImage(new ImageIcon("bin/icon.png").getImage());
		start.setSize(winsize);
		start.setLocationRelativeTo(null);
		start.setResizable(false);

		GridBagLayout layout = new GridBagLayout();
		layout.columnWidths = new int[] { 1, 1, 1, 1, 1 };
		layout.rowHeights = new int[] { 1, 1, 1 };
		layout.columnWeights = new double[] { 0.0, 1.0, 1.0, 1.0, 1.0,
				Double.MIN_VALUE };
		layout.rowWeights = new double[] { 0.0, 0.0, 0.0, Double.MIN_VALUE };

		GridBagConstraints name_c = new GridBagConstraints();
		name_c.insets = new Insets(10, 5, 5, 5);
		name_c.gridwidth = 1;
		name_c.gridheight = 1;
		name_c.fill = GridBagConstraints.BOTH;
		name_c.anchor = GridBagConstraints.CENTER;
		name_c.gridx = 0;
		name_c.gridy = 0;

		GridBagConstraints namef_c = new GridBagConstraints();
		namef_c.insets = new Insets(10, 5, 5, 5);
		namef_c.gridwidth = 2;
		namef_c.gridheight = 1;
		namef_c.fill = GridBagConstraints.BOTH;
		namef_c.anchor = GridBagConstraints.CENTER;
		namef_c.gridx = 1;
		namef_c.gridy = 0;

		GridBagConstraints rc_c = new GridBagConstraints();
		rc_c.insets = new Insets(10, 5, 5, 5);
		rc_c.gridwidth = 1;
		rc_c.gridheight = 1;
		rc_c.fill = GridBagConstraints.BOTH;
		rc_c.anchor = GridBagConstraints.CENTER;
		rc_c.gridx = 3;
		rc_c.gridy = 0;

		GridBagConstraints rf_c = new GridBagConstraints();
		rf_c.insets = new Insets(10, 5, 5, 5);
		rf_c.gridwidth = 1;
		rf_c.gridheight = 1;
		rf_c.fill = GridBagConstraints.BOTH;
		rf_c.anchor = GridBagConstraints.CENTER;
		rf_c.gridx = 4;
		rf_c.gridy = 0;

		GridBagConstraints path_c = new GridBagConstraints();
		path_c.insets = new Insets(10, 5, 5, 5);
		path_c.gridwidth = 5;
		path_c.gridheight = 1;
		path_c.fill = GridBagConstraints.BOTH;
		path_c.anchor = GridBagConstraints.CENTER;
		path_c.gridx = 0;
		path_c.gridy = 1;

		GridBagConstraints start_c = new GridBagConstraints();
		start_c.insets = new Insets(50, 5, 5, 5);
		start_c.gridwidth = 2;
		start_c.gridheight = 1;
		start_c.fill = GridBagConstraints.BOTH;
		start_c.anchor = GridBagConstraints.CENTER;
		start_c.gridx = 3;
		start_c.gridy = 2;

		container.setPreferredSize(winsize);
		container.setLayout(layout);
		// container.setBackground(green);

		start.add(container);

		path.setEditable(true);
		path.addActionListener(Actions.choose);
		name_field.setSize(new Dimension(200, 20));
		name_field.setText("Generic player");
		round_field.setSelectedIndex(2);
		startquiz.addActionListener(Actions.startnew);

		container.add(name, name_c);
		container.add(name_field, namef_c);
		container.add(rounds, rc_c);
		container.add(round_field, rf_c);
		container.add(path, path_c);
		container.add(startquiz, start_c);

		start.pack();
		start.setVisible(true);

		return start;
	}

	public void showWindow() {
		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				StartNEW();
			}
		});
	}

}
