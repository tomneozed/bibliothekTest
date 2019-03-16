package com.responses;

import java.util.List;

public class AbstractResponse {
	/* 
	 * errorType = 0 : no error
	 * errorType = 1 : technical error (IDK what it is)
	 * errorType = 2 : functionnal error (I know what it is)
	 */
	private int errorType;
	
	private String errorMessage;
	
	public AbstractResponse() {
		
	}

	public int getErrorType() {
		return errorType;
	}
	
	public void setErrorType(int errorType) {
		this.errorType = errorType;
	}
	
	public String getErrorMessage() {
		return errorMessage;
	}

	public void setErrorMessage(String errorMessage) {
		this.errorMessage = errorMessage;
	}
}
