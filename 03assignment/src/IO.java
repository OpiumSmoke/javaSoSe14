import java.util.List;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.FileOutputStream;
import java.util.Map;

public class IO {

	public static List<Question> readQuestions(String filename) {
		ArrayList<Question> questions = new ArrayList<Question>();
		int ra; // right answer index

		BufferedReader reader = null;

		try {
			reader = new BufferedReader(new FileReader(filename));

			String l = reader.readLine(); // throw away the header

			while ((l = reader.readLine()) != null) {
				String[] line = l.split(",");

				if (line.length != 6) {
					continue;
				}
				for (int i = 0; i < line.length; i++) {
					line[i] = line[i].trim();
				}
				try {
					ra = Integer.parseInt(line[5].trim());
				} catch (Exception e) {
					e.printStackTrace();
					continue;
				}
				questions.add(new Question(line[0], Arrays.copyOfRange(line, 1,
						5), ra));
//				System.out.println(questions);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				try {
					reader.close();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
//		System.out.println(questions.get(0).getQuestion());
		return questions;
	}

	public static void saveResult(IStatisticController controller,
			String playername) {
		String filename = playername + "_" + System.currentTimeMillis();
		BufferedWriter writer = null;

		try {
			writer = new BufferedWriter(new OutputStreamWriter(
					new FileOutputStream(filename)));

			writer.write("Player Name: " + playername);
			writer.newLine();
			writer.write("Correct answers:\t" + controller.getRightAnswers());
			writer.newLine();
			writer.write("Wrong answers:\t" + controller.getWrongAnswers());

			writer.newLine();
			writer.newLine();

			Map<Question, String> answers = controller.getAnswers();

			for (Map.Entry<Question, String> entry : answers.entrySet()) {
				writer.write(entry.getKey().getQuestion() + ", "
						+ entry.getValue() + ", "
						+ entry.getKey().checkAnswer(entry.getValue()));
				writer.newLine();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (writer != null) {
					writer.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
