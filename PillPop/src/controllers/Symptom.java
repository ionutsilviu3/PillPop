package controllers;

public class Symptom {
	String question, description, imgSrc, correctAns, wrongAns;

	public Symptom(String question, String imgSrc, String correctAns, String wrongAns) {
		super();
		this.question = question;
		this.imgSrc = imgSrc;
		this.correctAns = correctAns;
		this.wrongAns = wrongAns;
	}
	
	public Symptom(String question, String description, String imgSrc, String correctAns, String wrongAns) {
		super();
		this.question = question;
		this.description = description;
		this.imgSrc = imgSrc;
		this.correctAns = correctAns;
		this.wrongAns = wrongAns;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getImgSrc() {
		return imgSrc;
	}

	public void setImgSrc(String imgSrc) {
		this.imgSrc = imgSrc;
	}

	public String getCorrectAns() {
		return correctAns;
	}

	public void setCorrectAns(String correctAns) {
		this.correctAns = correctAns;
	}

	public String getWrongAns() {
		return wrongAns;
	}

	public void setWrongAns(String wrongAns) {
		this.wrongAns = wrongAns;
	}

}
