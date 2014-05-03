public class TextUI {

	private static final int stdrounds = 10;
	private static final String stdplayer = "NickyKatz";
	private static final String stdfile = "dummy.csv";

	private IStatisticController controller;
	private int maxrounds;
	private String player;

	public TextUI(IStatisticController controller, String player, int maxrounds) {
		this.controller = controller;
		this.player = player;
		this.maxrounds = maxrounds;
	}

	public TextUI(String filename, String player, int maxrounds) {
		this(new SimpleController(IO.readQuestions(filename)), player,
				maxrounds);
	}

	public TextUI() {
		this(new SimpleController(IO.readQuestions(stdfile)), stdplayer,
				stdrounds);
	}

	public void playGame() {
		maxrounds = controller.getNumberOfQuestions() < maxrounds ? controller
				.getNumberOfQuestions() : maxrounds;
		for (int rounds = 1; rounds <= maxrounds; rounds++) {
			System.out.println("\n\nRound " + rounds);
			Question question = controller.getQuestion();
			System.out.println(question.getQuestion());
			for (int i = 0; i < 4; i++) {
				System.out.println("\t" + i + ") " + question.getAnswers()[i]);
			}
			System.out.println("\nChoose your answer: ");
			while (true) {
				int choice = -1;
				try {
					choice = new java.util.Scanner(System.in).nextInt();
					System.out.println(controller.addDataSet(question,
							question.getAnswers()[choice]));
				} catch (Exception e) {
					// e.printStackTrace();
				}
				if (choice >= 0 && choice <= 3) {
					break;
				}
				System.out.println("Choose an integer from 0 to 3::");
			}
		}
		System.out.println("\n\nCorrect Answers:\t"
				+ controller.getRightAnswers());
		System.out.println("Wrong Answers:\t" + controller.getWrongAnswers());
		IO.saveResult(controller, player);
	}

}
