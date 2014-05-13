import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

public class Actions {

	public static ActionListener exit = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	};

	public static ActionListener help = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			final JOptionPane optionPane = new JOptionPane(
					"You are on your own!", JOptionPane.INFORMATION_MESSAGE);
			final JDialog dialog = new JDialog(GUI.window, "Help", true);
			dialog.setContentPane(optionPane);
			dialog.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
			dialog.addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent we) {
				}
			});
			optionPane.addPropertyChangeListener(new PropertyChangeListener() {
				public void propertyChange(PropertyChangeEvent e) {
					String prop = e.getPropertyName();

					if (dialog.isVisible() && (e.getSource() == optionPane)
							&& (JOptionPane.VALUE_PROPERTY.equals(prop))) {
						// If you were going to check something
						// before closing the window, you'd do
						// it here.
						dialog.setVisible(false);
					}
				}
			});
			dialog.pack();
			dialog.setLocationRelativeTo(GUI.window);
			dialog.setVisible(true);
		}
	};

	public static ActionListener newquiz = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			clearAll();
			StartNEW start = new StartNEW();
			start.showWindow();
		}
	};

	public static ActionListener startnew = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			File f = new File((String) StartNEW.path.getSelectedItem());
			if (f.exists()) {
				setAll();
				StartNEW.start.dispose();
				TextUI tui = new TextUI(
						(String) StartNEW.path.getSelectedItem(),
						StartNEW.name_field.getText(),
						Integer.parseInt((String) StartNEW.round_field
								.getSelectedItem()));
				tui.playGame();
			} else {
				System.err.println("Couldn't find file: " + f.getPath());
				final JOptionPane optPane = new JOptionPane(
						"Choose a .csv file with quiz questions!",
						JOptionPane.ERROR_MESSAGE);
				final JDialog warning = new JDialog(GUI.window, "Help", true);
				warning.add(optPane);
				warning.setDefaultCloseOperation(JDialog.DO_NOTHING_ON_CLOSE);
				warning.addWindowListener(new WindowAdapter() {
					public void windowClosing(WindowEvent we) {
					}
				});
				optPane.addPropertyChangeListener(new PropertyChangeListener() {
					public void propertyChange(PropertyChangeEvent e) {
						String prop = e.getPropertyName();
						if (warning.isVisible() && (e.getSource() == optPane)
								&& (JOptionPane.VALUE_PROPERTY.equals(prop))) {
							// If you were going to check something
							// before closing the window, you'd do
							// it here.
							warning.setVisible(false);
						}
					}
				});
				warning.pack();
				warning.setLocationRelativeTo(StartNEW.start);
				warning.setVisible(true);
			}
		}
	};

	public static ActionListener choose = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			final JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new File("src/"));
			fc.showOpenDialog(fc);

			int returnVal = fc.showOpenDialog(fc);
			if (returnVal == JFileChooser.APPROVE_OPTION) {
				System.out.println("blabla");
				File file = fc.getSelectedFile();
				System.out.println("File:" + file.getPath());
				StartNEW.path.addItem(file.getPath());
				StartNEW.path.setSelectedItem(file.getPath());
			} else if (returnVal == JFileChooser.CANCEL_OPTION) {
				System.out.println("No file opened");
			}
		}
	};
	
	public static ActionListener clickA = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public static ActionListener clickB = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public static ActionListener clickC = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};
	
	public static ActionListener clickD = new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			
		}
		
	};

	private static void clearAll() {
		GUI.answerA.setBackground(null);
		GUI.answerB.setBackground(null);
		GUI.answerC.setBackground(null);
		GUI.answerD.setBackground(null);
		GUI.textA.setText(null);
		GUI.textB.setText(null);
		GUI.textC.setText(null);
		GUI.textD.setText(null);
		GUI.questiontext.setText(null);
		GUI.correct.setText("0");
		GUI.outof.setText("0");
		GUI.name.setText(null);
		GUI.next.setEnabled(false);
	}

	private static void setAll() {
		GUI.name.setText(StartNEW.name_field.getText());
		GUI.outof.setText((String) StartNEW.round_field.getSelectedItem());
		GUI.answerA.setEnabled(true);
		GUI.answerB.setEnabled(true);
		GUI.answerC.setEnabled(true);
		GUI.answerD.setEnabled(true);
		GUI.next.setEnabled(true);
	}
}