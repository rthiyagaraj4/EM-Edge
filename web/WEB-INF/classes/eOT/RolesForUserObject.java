/*******************************************************************************
 * Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 *  
 * Warning: This computer program is protected by copyright law and international treaties.
 * Unauthorized reproduction or distribution of this program, or any portion of it, 
 * may result in severe civil and criminal penalties, and will be prosecuted to 
 * the maximum extent possible under the law.
 ******************************************************************************/
package eOT;

import java.io.Serializable;

import eOT.Common.OTAdapter;

public class RolesForUserObject extends OTAdapter implements Serializable
{

	private static final long serialVersionUID = 1L;

	private String user = "";
	private String userName = "";
	private String role = "";
	private String roleDesc = "";
	private String roleTypeDesc = "";//IN:050706
	private String applicability = "";
	private String isDefault = "";
//IN:050706 start
	public String getRoleTypeDesc() {
			return roleTypeDesc;
	}
	public void setRoleTypeDesc(String roleTypeDesc) {
			this.roleTypeDesc = roleTypeDesc;
	}
//IN:050706 end
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getRoleDesc() {
		return roleDesc;
	}
	public void setRoleDesc(String roleDesc) {
		this.roleDesc = roleDesc;
	}
	public String getApplicability() {
		return applicability;
	}
	public void setApplicability(String applicability) {
		this.applicability = applicability;
	}
	public String getIsDefault() {
		return isDefault;
	}
	public void setIsDefault(String isDefault) {
		this.isDefault = isDefault;
	}
}
