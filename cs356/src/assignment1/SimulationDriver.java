package assignment1;

import java.util.ArrayList;

public class SimulationDriver {
	
	/**
	 * This section of code is used to simulate question creation and student voting.
	 * The question has a 50% chance of being multiple answer, or single answer. 
	 * The amount of students is random from 0 to 100.
	 * Answer choices are fixed at A,B,C,D. Correct answer(s) are random.
	 * Students will vote randomly. 
	 * When the program is run, it will display whether or not it was a single or multiple
	 * answer, what the correct answers are, the results of the votes, and the number
	 * correct and incorrect answers. Rerun to see different results.
	 */
	public static void main(String[] args) {
		
		IVoteService IVS = new IVoteService();
		
		boolean multipleAnswers = Math.random() < .5;
		
		System.out.println(multipleAnswers ? "Multiple answers" : "Single answer");
		IVS.setQuestion("Template question?", multipleAnswers);
	
		if (multipleAnswers) {
			IVS.setABCDMultiple();
			String[] randAnswers = { "A", "B", "C", "D" };
			int numStudents = (int) (Math.random() * 100);
			for (int i = 0; i < numStudents; i++) {
				Student temp = IVS.addRandomStudent();
				for (int j = 0; j < 4; j++) {
					int randomChoice = (int) (Math.random() * 4);
					IVS.vote(temp, new Answer(randAnswers[randomChoice]));
				}
			}
		}
		else {
			IVS.setABCDSingle();
			String[] randAnswers = { "A", "B", "C", "D" };
			int numStudents = (int) (Math.random() * 100);
			for (int i = 0; i < numStudents; i++) {
				Student temp = IVS.addRandomStudent();
				int randomChoice = (int) (Math.random() * 4);
				IVS.vote(temp, new Answer(randAnswers[randomChoice]));
			
			}
		}
		ArrayList<Answer> a = IVS.getQuestion().getCorrect();
		System.out.print("Answers: ");
		for (Answer ans: a) {
			System.out.print(ans.getAnswer() + " ");
		}
		System.out.println();
		IVS.printResults();

	}

}
