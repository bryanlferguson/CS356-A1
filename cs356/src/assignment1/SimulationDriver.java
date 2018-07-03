package assignment1;

public class SimulationDriver {

	public static void main(String[] args) {
		IVoteService IVS = new IVoteService();
		IVS.setQuestion("What is my name?", false);
		IVS.getQuestion().addAnswerChoice(new Answer("Anthony"));
		IVS.getQuestion().addAnswerChoice(new Answer("Bryan"));
		IVS.getQuestion().addAnswerChoice(new Answer("Steve"));
		
		IVS.getQuestion().addCorrectAnswer(new Answer("Bryan"));
		
		Student s1 = IVS.addRandomStudent();
		Student s2 = IVS.addRandomStudent();
		Student s3 = IVS.addRandomStudent();
		Student s4 = IVS.addRandomStudent();
		
		IVS.vote(s1, new Answer("Anthony"));
		IVS.vote(s2, new Answer("Bryan"));
		IVS.vote(s3, new Answer("Bryan"));
		IVS.vote(s4, new Answer("Bryan"));
		IVS.vote(s4, new Answer("Steve"));
		
		IVS.printResults();

	}

}
