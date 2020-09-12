package com.cts.fse.car.rental.dto;

import java.util.List;

public class ManageRoleDTO {
	
	int manageId;
	String activeFlag;
	List<Integer> userRoles;
	
	
	public int getManageId() {
		return manageId;
	}
	public void setManageId(int manageId) {
		this.manageId = manageId;
	}
	public String getActiveFlag() {
		return activeFlag;
	}
	public void setActiveFlag(String activeFlag) {
		this.activeFlag = activeFlag;
	}
	public List<Integer> getUserRoles() {
		return userRoles;
	}
	public void setUserRoles(List<Integer> userRoles) {
		this.userRoles = userRoles;
	}
	@Override
	public String toString() {
		return "ManageRoleDTO [manageId=" + manageId + ", activeFlag=" + activeFlag + ", userRoles=" + userRoles + "]";
	}
	
	
}
