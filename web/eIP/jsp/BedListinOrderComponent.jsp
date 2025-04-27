<!DOCTYPE html>
<%@ page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff"); 
	//MMS-ME-SCF-0096 vulnerability Issue
	String name= request.getParameter("attribute");
	request.setCharacterEncoding("UTF-8");
%>
 <select name='<%=name%>' id='<%=name%>' onchange = 'getBedListinOrder(this)'  >
	<option value='' selected>---&nbsp<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>&nbsp---</option>
	<option value='specialty_short_desc'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></option>
	<option value='bed_type_short_desc'><fmt:message key="Common.bedtype.label" bundle="${common_labels}"/></option>
	<option value='room_long_desc'><fmt:message key="Common.RoomCubicle.label" bundle="${common_labels}"/></option>
	</select>

