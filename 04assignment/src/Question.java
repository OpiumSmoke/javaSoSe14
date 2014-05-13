public class Question {

	public String question; // question string
	public String[] answers = new String[4]; // array of answers
	public int rightanswer; // index of the right answer

	public Question(String q, String[] a, int ra) {
		this.question = q;
		this.rightanswer = ra;

		for (int i = 0; i < a.length; i++) {
			this.answers[i] = a[i];
		}
	}
	
	public String getQuestion() {
		return this.question;
	}
	
	public String[] getAnswers() {
		return this.answers;
	}
	
	public int getIndex() {
		return this.rightanswer;
	}

	public boolean checkAnswer(String answer) {
		String correct = this.answers[this.rightanswer];
		
		if (correct == answer) {
			System.out.println("You're right!");
			return true;
		} else if (correct != answer) {
			System.out.println("You're wrong!");
			return false;
		} else {
			System.out.println("Oops, something went wrong");
			return false;
		}
	}

}
