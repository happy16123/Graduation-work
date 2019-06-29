package com.quiz.dto;

public class QuizDto {
	private int codeno;
	private String title;
	private String content;
	private String codeframe;
	private String answerClassName;
	private String testClassName;
	private String result;
	private String regid;
	private String regdate;
	private int success;
	private int fail;
	
	
	public int getSuccess() {
		return success;
	}
	public void setSuccess(int success) {
		this.success = success;
	}
	public int getFail() {
		return fail;
	}
	public void setFail(int fail) {
		this.fail = fail;
	}
	public int getCodeno() {
		return codeno;
	}
	public void setCodeno(int codeno) {
		this.codeno = codeno;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getCodeframe() {
		return codeframe;
	}
	public void setCodeframe(String codeframe) {
		this.codeframe = codeframe;
	}
	public String getAnswerClassName() {
		return answerClassName;
	}
	public void setAnswerClassName(String answerClassName) {
		this.answerClassName = answerClassName;
	}
	public String getTestClassName() {
		return testClassName;
	}
	public void setTestClassName(String testClassName) {
		this.testClassName = testClassName;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getRegid() {
		return regid;
	}
	public void setRegid(String regid) {
		this.regid = regid;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
	
}
