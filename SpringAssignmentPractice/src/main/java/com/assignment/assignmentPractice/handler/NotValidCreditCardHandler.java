package com.assignment.assignmentPractice.handler;

public class NotValidCreditCardHandler extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	String message;
	
	
	public NotValidCreditCardHandler() {
		super();
		// TODO Auto-generated constructor stub
	}

	public NotValidCreditCardHandler(String message) {
		super();
		this.message = message;
	}
	
	
	
	

}
