package assignment1;

import java.util.ArrayList;

public class SimulationDriver {

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
