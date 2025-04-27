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

<%try{
			
String attchmnt=request.getParameter("attchmnt")==null?"N":request.getParameter("attchmnt");
String beanKey=request.getParameter("beanKey")==null?"":request.getParameter("beanKey");
String reportType=request.getParameter("p_report_type")==null?"":request.getParameter("p_report_type");

eCA.EmailRepBodyTxtBean CA_EmailRepBodyTxtBean = (eCA.EmailRepBodyTxtBean)getObjectFromBean(beanKey,"eCA.EmailRepBodyTxtBean",session);
  	String details		= "";
	if(attchmnt.equals("Y")){
		details		= (String)CA_EmailRepBodyTxtBean.getReportText();

		if(details==null)	details ="";
	}else{
  		details		= (String)CA_EmailRepBodyTxtBean.getEditorContent();
		if(details==null)	details ="";
		details				= "<img src='../../eCommon/images/Entilogo.jpg' align='center'></img>"  +details  ;
	}
 	
%>
<form name="editor_preview" id="editor_preview" method="post" target="messageFrame">

<%
	if(reportType.equals("T"))
	{
%>
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
<%
	}
	else if(reportType.equals("H"))
	{
		out.println(details);
	}
%> 
</form>
<%putObjectInBean(beanKey,CA_EmailRepBodyTxtBean,session);
}catch(Exception e){
	
	e.printStackTrace();
}%>
</body>

</html>

