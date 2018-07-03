package assignment1;

import java.util.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MultipleAnswerQuestion extends Question{

	private Map<String, ArrayList<Answer>> answers;
	private List<Answer> correct;

	public MultipleAnswerQuestion(String q) {
		super(q);
		answers = new HashMap<String, ArrayList<Answer>>();
		correct = new ArrayList<Answer>();
	}

	public boolean setAnswers(Student s, ArrayList<Answer> a) {
		for (Answer ans : a) {
			if (!getPossibleAnswers().contains(ans))
				return false;
		}
		answers.put(s.getID(), a);
		return true;
	}

	public boolean setAnswers(Student s, Answer a) {
		ArrayList<Answer> temp;
		if (answers.get(s.getID()) == null)
			temp = new ArrayList<Answer>();
		else
			temp = answers.get(s.getID());
		temp.add(a);
		answers.put(s.getID(), temp);
		return true;
	}

	public void addCorrectAnswer(Answer a) {
		correct.add(a);
	}
	
	public void addAnswerChoice(Answer a, boolean c) {
		if (c)
			correct.add(a);
		addAnswerChoice(a);
	}

	public Map<String, Integer> getResults() {
		Map<String, Integer> ret = new HashMap<String, Integer>();
		for (ArrayList<Answer> al: answers.values()) {
			for (Answer value: al ) {
				int temp = ret.get(value.toString()) == null ? 0 : ret.get(value.toString());
				temp++;
				ret.put(value.toString(), temp);
			}
		}
		return ret;
	}

	public ArrayList<Answer> getCorrect() {
		return (ArrayList<Answer>) correct;
	}

}
