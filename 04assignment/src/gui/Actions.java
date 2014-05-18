package gui;

import quiz.IO;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import model.Game;
import model.Question;

public class Actions {
	public static boolean active;
	private static Color green = new Color(0, 255, 100);
	private static Color red = new Color(250, 0, 0);

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
			EndGame.end.dispose();
			start.showWindow();
		}
	};

	public static ActionListener startnew = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			File f = new File((String) StartNEW.path.getSelectedItem());
			if (f.exists()) {
				setAll();
				StartNEW.start.dispose();

				Game.name = StartNEW.name_field.getText();
				Game.maxrounds = Integer.parseInt((String) StartNEW.round_field
						.getSelectedItem());
				Game.qlist = IO.readQuestions((String) StartNEW.path
						.getSelectedItem());
				Game.controller.initialize(Game.qlist);
				Game.question = Game.controller.getQuestion();
				showQuestion(Game.question);
				enable();
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
		@SuppressWarnings("unchecked")
		public void actionPerformed(ActionEvent e) {
			final JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new File("src/"));
			int returnVal = fc.showOpenDialog(fc);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				System.out.println("File:" + file.getPath());
				StartNEW.path.addItem(file.getPath());
				StartNEW.path.setSelectedItem(file.getPath());
			} else if (returnVal == JFileChooser.CANCEL_OPTION) {
				System.out.println("No file opened");
			}
		}
	};

	public static ActionListener next = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			if (Game.maxrounds > Game.round) {
				reset();
				Game.round++;
				GUI.currentround.setText(String.valueOf(Game.round));
				Game.question = Game.controller.getQuestion();
				showQuestion(Game.question);
				enable();
			} else {
				System.out.println("Game over!");
				EndGame end = new EndGame();
				end.End(Game.name + ",", Game.controller.getRightAnswers(),
						Game.maxrounds);
			}
		}

	};

	public static MouseListener clickA = new MouseListener() {

		public void mousePressed(MouseEvent e) {
			// System.out.println("Mouse pressed.");
			GUI.answerA.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		}

		public void mouseReleased(MouseEvent e) {
			// System.out.println("Mouse released.");
			GUI.answerA.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		}

		@Override
		public void mouseClicked(MouseEvent arg0) {
			if (active == true) {
				Game.controller.addDataSet(Game.question, GUI.textA.getText());
				disable();
				active = false;
				showAnswers(Game.question, GUI.textA);
			} else if (active == false) {
				System.out.println("Already clicked!");
			}
		}

		@Override
		public void mouseEntered(MouseEvent arg0) {
		}

		@Override
		public void mouseExited(MouseEvent arg0) {
		}
	};

	public static MouseListener clickB = new MouseListener() {
		@Override
		public void mouseClicked(MouseEvent e) {
			if (active == true) {
				Game.controller.addDataSet(Game.question, GUI.textB.getText());
				disable();
				active = false;
				showAnswers(Game.question, GUI.textB);
			} else if (active == false) {
				System.out.println("Already clicked!");
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			GUI.answerB.setBorder(BorderFactory.createLoweredSoftBevelBorder());

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			GUI.answerB.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		}

	};

	public static MouseListener clickC = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (active == true) {
				Game.controller.addDataSet(Game.question, GUI.textC.getText());
				disable();
				active = false;
				showAnswers(Game.question, GUI.textC);
			} else if (active == false) {
				System.out.println("Already clicked!");
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			GUI.answerC.setBorder(BorderFactory.createLoweredSoftBevelBorder());

		}

		@Override
		public void mouseReleased(MouseEvent e) {
			GUI.answerC.setBorder(BorderFactory.createRaisedSoftBevelBorder());

		}

	};

	public static MouseListener clickD = new MouseListener() {

		@Override
		public void mouseClicked(MouseEvent e) {
			if (active == true) {
				Game.controller.addDataSet(Game.question, GUI.textD.getText());
				disable();
				active = false;
				showAnswers(Game.question, GUI.textD);
			} else if (active == false) {
				System.out.println("Already clicked!");
			}
		}

		@Override
		public void mouseEntered(MouseEvent e) {
		}

		@Override
		public void mouseExited(MouseEvent e) {
		}

		@Override
		public void mousePressed(MouseEvent e) {
			GUI.answerD.setBorder(BorderFactory.createLoweredSoftBevelBorder());
		}

		@Override
		public void mouseReleased(MouseEvent e) {
			GUI.answerD.setBorder(BorderFactory.createRaisedSoftBevelBorder());
		}

	};

	public static ActionListener save = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent arg0) {
			final JFileChooser fc = new JFileChooser();
			fc.setCurrentDirectory(new File("src/"));

			String path = new String("src/" + Game.name + "_"
					+ System.currentTimeMillis() + ".txt");
			fc.setSelectedFile(new File(path));
//			fc.setCurrentDirectory(new File(path));

			int returnVal = fc.showSaveDialog(fc);

			if (returnVal == JFileChooser.APPROVE_OPTION) {
				File file = fc.getSelectedFile();
				System.out.println("Saving: " + file.getName());
				IO.saveResult(Game.controller, Game.name, path);
			} else {
				System.out.println("No file was saved.");
			}

		}

	};

	public static void showQuestion(Question question) {
		System.out.println(question.getQuestion());
		for (int i = 0; i < 4; i++) {
			System.out.println("\t" + i + ") " + question.getAnswers()[i]);
		}
		GUI.questiontext.setText(question.getQuestion());
		GUI.textA.setText(question.getAnswers()[0]);
		GUI.textB.setText(question.getAnswers()[1]);
		GUI.textC.setText(question.getAnswers()[2]);
		GUI.textD.setText(question.getAnswers()[3]);
	}

	public static void showAnswers(Question question, JLabel selected) {
		String correct = question.answers[question.rightanswer];
		if (correct == selected.getText()) {
			GUI.correct.setText(String.valueOf(Game.controller
					.getRightAnswers()));
			if (selected == GUI.textA) {
				GUI.answerA.setBackground(green);
			} else if (selected == GUI.textB) {
				GUI.answerB.setBackground(green);
			} else if (selected == GUI.textC) {
				GUI.answerC.setBackground(green);
			} else if (selected == GUI.textD) {
				GUI.answerD.setBackground(green);
			}
		} else if (correct != selected.getText()) {
			if (selected == GUI.textA) {
				GUI.answerA.setBackground(red);
				if (correct == GUI.textB.getText()) {
					GUI.answerB.setBackground(green);
				} else if (correct == GUI.textC.getText()) {
					GUI.answerC.setBackground(green);
				} else if (correct == GUI.textD.getText()) {
					GUI.answerD.setBackground(green);
				}
			} else if (selected == GUI.textB) {
				GUI.answerB.setBackground(red);
				if (correct == GUI.textA.getText()) {
					GUI.answerA.setBackground(green);
				} else if (correct == GUI.textC.getText()) {
					GUI.answerC.setBackground(green);
				} else if (correct == GUI.textD.getText()) {
					GUI.answerD.setBackground(green);
				}
			} else if (selected == GUI.textC) {
				GUI.answerC.setBackground(red);
				if (correct == GUI.textB.getText()) {
					GUI.answerB.setBackground(green);
				} else if (correct == GUI.textA.getText()) {
					GUI.answerA.setBackground(green);
				} else if (correct == GUI.textD.getText()) {
					GUI.answerD.setBackground(green);
				}
			} else if (selected == GUI.textD) {
				GUI.answerD.setBackground(red);
				if (correct == GUI.textB.getText()) {
					GUI.answerB.setBackground(green);
				} else if (correct == GUI.textC.getText()) {
					GUI.answerC.setBackground(green);
				} else if (correct == GUI.textA.getText()) {
					GUI.answerA.setBackground(green);
				}
			}
		}
		GUI.next.setEnabled(true);
	}

	public static void disable() {
		active = false;
		GUI.answerA.addMouseListener(null);
		GUI.answerB.addMouseListener(null);
		GUI.answerC.addMouseListener(null);
		GUI.answerD.addMouseListener(null);
	}

	public static void enable() {
		active = true;
		GUI.answerA.addMouseListener(Actions.clickA);
		GUI.answerB.addMouseListener(Actions.clickB);
		GUI.answerC.addMouseListener(Actions.clickC);
		GUI.answerD.addMouseListener(Actions.clickD);
	}

	public static void reset() {
		GUI.questiontext.setText(null);
		GUI.answerA.setBackground(null);
		GUI.answerB.setBackground(null);
		GUI.answerC.setBackground(null);
		GUI.answerD.setBackground(null);
		GUI.textA.setText(null);
		GUI.textB.setText(null);
		GUI.textC.setText(null);
		GUI.textD.setText(null);
		GUI.next.setEnabled(false);
	}

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
		GUI.currentround.setText(String.valueOf(Game.round));
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
	}
}