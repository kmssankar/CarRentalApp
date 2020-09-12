package com.cts.fse.car.rental.dto;

public class RegisterUser {
	
	String email;
	String userName;
	String password;
	String firstName;
	String phoneNo;
	String lastName;
	String retypeUser;
	String enableVedor;

	
	public String getPhoneNo() {
		return phoneNo;
	}
	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getRetypeUser() {
		return retypeUser;
	}
	public void setRetypeUser(String retypeUser) {
		this.retypeUser = retypeUser;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	public String getEnableVedor() {
		return enableVedor;
	}
	public void setEnableVedor(String enableVedor) {
		this.enableVedor = enableVedor;
	}
	@Override
	public String toString() {
		return "RegisterUser [email=" + email + ", userName=" + userName + ", password=" + password + ", firstName="
				+ firstName + ", phoneNo=" + phoneNo + ", lastName=" + lastName + ", retypeUser=" + retypeUser
				+ ", enableVedor=" + enableVedor + "]";
	}
	
	
}
