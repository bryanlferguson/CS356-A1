package assignment1;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultipleAnswerQuestion extends Question{

	private Map<String, Answer[]> answers;
	private List<Answer> correct;

	public MultipleAnswerQuestion(String q) {
		super(q);
		answers = new HashMap<String, Answer[]>();
	}

	public boolean setAnswers(Student s, Answer[] a) {
		for (Answer ans : a) {
			if (!getPossibleAnswers().contains(ans))
				return false;
		}
		answers.put(s.getID(), a);
		return true;
	}

	@Override
	public boolean setAnswers(Student s, Answer a) {
		return false;
	}

	@Override
	public void addCorrectAnswer(Answer a) {
		correct.add(a);
	}
	
	public void addAnswerChoice(Answer a, boolean c) {
		if (c)
			correct.add(a);
		addAnswerChoice(a);
	}

	public int getNumberCorrect() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Map<String, Integer> getResults() {
		// TODO Auto-generated method stub
		return null;
	}

}
