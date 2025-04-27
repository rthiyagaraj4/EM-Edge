<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page import="com.ehis.alertutils.*" contentType="text/plain"%>
<%!

/**
 * Method to get the unacknowledged alert count for the user
 * 
 * @param userId
 * @return count of unacknowledged alerts  
 * 
 */
public static String getUnacknowledgedAlerts(String userId) {
	return AlertUtils.getUnacknowledgedAlerts(userId) ;
}
%>
<%
	String methodName = request.getParameter("methodName");
	methodName = (methodName==null)?"":methodName;
	methodName = methodName.toUpperCase();
	String userId = request.getParameter("userId");
	userId = (userId==null)?"":userId; 
	
	if(methodName.equals("GETUNACKNOWLEDGEDALERTS")){
		out.print(getUnacknowledgedAlerts(userId));
	}
%>
