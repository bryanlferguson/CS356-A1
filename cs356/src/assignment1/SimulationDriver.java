package assignment1;

public class SimulationDriver {

	public static void main(String[] args) {
		IVoteService IVS = new IVoteService();
		IVS.setQuestion("What is my name?", true);
		IVS.setABCD();
		
		String[] randAnswers = { "A", "B", "C", "D" };
		int numStudents = (int) (Math.random() * 100);
		for (int i = 0; i < numStudents; i++) {
			for (int j = 0; j < 4; j++) {
				Student temp = IVS.addRandomStudent();
				int randomChoice = (int) (Math.random() * 4);
				IVS.vote(temp, new Answer(randAnswers[randomChoice]));
			}
		}
		IVS.printResults();

	}

}
