<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<% request.setCharacterEncoding("UTF-8"); %>
<select name='gender' id='gender' tabIndex='0'>
	<option value='' selected>--- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/> ---</option>	
	<option value='M'><fmt:message key="Common.male.label" bundle="${common_labels}"/></option>
	<option value='F'><fmt:message key="Common.female.label" bundle="${common_labels}"/></option>
	<option value='U'><fmt:message key="Common.unknown.label" bundle="${common_labels}"/></option>
</select>

