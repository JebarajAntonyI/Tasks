package classroom;

public class Doubts 
{
	private int number;
	private String question;
	private String answer;
	
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getQuestion() {
		return question;
	}
	public void setQuestion(String question) {
		this.question = question;
	}
	public String getAnswer() {
		return answer;
	}
	public void setAnswer(String answer) {
		this.answer = answer;
	}
	
	@Override
	public String toString() {
		return "Doubts [number=" + number + ", question=" + question + ", answer=" + answer + "]";
	}
}
