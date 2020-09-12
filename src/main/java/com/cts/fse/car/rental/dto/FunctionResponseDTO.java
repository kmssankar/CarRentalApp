package com.cts.fse.car.rental.dto;

import java.util.List;

public class FunctionResponseDTO {
	
	String message;
	boolean status;
	List<String> respMessages;
	
	
	
	public FunctionResponseDTO(String message, boolean status, List<String> respMessages) {
		super();
		this.message = message;
		this.status = status;
		this.respMessages = respMessages;
	}
	
	public FunctionResponseDTO(String message, boolean status) {
		super();
		this.message = message;
		this.status = status;
	}
	
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public List<String> getRespMessages() {
		return respMessages;
	}
	public void setRespMessages(List<String> respMessages) {
		this.respMessages = respMessages;
	}
	
	

}
