<!DOCTYPE html>
<%@ page contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%-- JSP Page specific attributes start --%>
<%@page import="java.util.*, eCA.* ,eCommon.Common.*" %>
<%-- JSP Page specific attributes end --%>   

<%-- Mandatory declarations start --%>
<%-- Remarks --This gives handle to  CommonMultipleHandler Bean with id=>mh--%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %> 
<%-- Mandatory declarations end --%>

 
<html>
<head>
<%
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079 
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085 
%>
 	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<!-- NO Iestyle sheet is used, that is why this piece of code is kept here -->
	<style type='text/css'>
		ADDRESS{font-style: NORMAL;} 
	</style>
  </head>

   <title><fmt:message key="eCA.PreviewTemplate.label" bundle="${ca_labels}"/></title>
<body onload='FocusFirstElement()' onMouseDown="CodeArrest()" onKeyDown="lockKey()" >

<%
	eCA.SecTempOutputFormBean CA_SecTempOutputFormBean = (eCA.SecTempOutputFormBean)getObjectFromBean("CA_SecTempOutputFormBean","eCA.SecTempOutputFormBean",session);		

  	String details		= (String)CA_SecTempOutputFormBean.getEditorContent();
 	if(details==null)	details ="";
	details				= "<img src='../../eCommon/images/Entilogo.jpg' align='center'></img>"  +details  ;


%>
<form name="editor_preview" id="editor_preview" method="post" target="messageFrame">


<table cellpadding=3 cellspacing=0 border=0 width="100%" align=center>
	<tr>
		<td align=left ></td>
	</tr>
  	<tr>
		<td align=left ><%=details%></td>
	</tr>
	<tr>
		<td align=left ></td>
	</tr>
</table>
 
</form>
<%putObjectInBean("CA_SecTempOutputFormBean",CA_SecTempOutputFormBean,session);%>
</body>

</html>

