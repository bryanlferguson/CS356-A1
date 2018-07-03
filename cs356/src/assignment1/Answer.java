package assignment1;

public class Answer {
	
	private String answer;
	private int index;
	
	public Answer(String a) {
		answer = a;
	}
	
	public String getAnswer() {
		return answer;
	}
	
	public void setAnswer(String a) {
		answer = a;
	}
	
	public int getIndex() {
		return index;
	}
	
	public String toString() {
		return answer;
	}
	
	public boolean equals(Answer a) {
		return a.getAnswer() == answer;
	}
}
