<!DOCTYPE html>
 
<%-- JSP Page specific attributes start --%>
<%@page contentType="text/html;charset=UTF-8" import="ePH.*, ePH.Common.*,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>

<%-- Mandatory declarations start --%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- Mandatory declarations end --%>
<html>
<head>

<% 
	request.setCharacterEncoding("UTF-8");

String sStyle=(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?
(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css"; 
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>'type='text/css'></link>
	
</head>

<Form name = "EDLAssociateLookUpButtons">
	<p align="right"> <input type="button" class="button" VALUE='<fmt:message key="Common.close.label" bundle="${common_labels}"/>' onClick="const dialogTag = parent.parent.document.getElementById('dialog_tag').close();"> </p>
</form>
</html> 

