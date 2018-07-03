package assignment1;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class SingleAnswerQuestion extends Question{

	private Map<String, Answer> answers;
	private Answer correct;
	
	public SingleAnswerQuestion(String q) {
		super(q);
		answers = new HashMap<String, Answer>();
	}

	public boolean setAnswers(Student s, Answer a) {
		if (!getPossibleAnswers().contains(a))
			return false;
		answers.put(s.getID(), a);
		return true;
	}

	@Override
	public void addCorrectAnswer(Answer a) {
		correct = a;
		
	}

	public void addAnswerChoice(Answer a, boolean c) {
		if (c)
			correct = a;
		addAnswerChoice(a);
	}

	
	public ArrayList<Answer> getCorrect() {
		ArrayList<Answer> ret = new ArrayList<Answer>();
		ret.add(correct);
		return ret;
	}

	public Map<String, Integer> getResults() {
		Map<String, Integer> ret = new HashMap<String, Integer>();
		for (Answer value: answers.values()) {
			int temp = ret.get(value.toString()) == null ? 0 : ret.get(value.toString());
			temp++;
			ret.put(value.toString(), temp);
		}
		return ret;
	}
	
}
