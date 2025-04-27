<!DOCTYPE html>
<%@page import="eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
		<title><fmt:message key="eCP.PatientAssessmentError.label" bundle="${cp_labels}"/></title>
		<script src='../../eCP/js/PatientAssessment.js' language='javascript'></script>
		<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
	</head>
	<body>
		<form name='patAssessErrorForm' id='patAssessErrorForm'>
			<%
			//This file is saved on 18/10/2005.
			request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
				String error_num = request.getParameter("err_num");
				String error_value = request.getParameter("err_value");
				
			//	if(error_value.equals("1"))
				/* {
					out.println("<script language='javascript'>onSuccess(\""+error_num+"\",\""+error_value+"\");</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>


");
				} */
				{
			        out.println("<script language='javascript'>");
			        out.println("    onSuccess(\"" + error_num + "\", \"" + error_value + "\");");
			        out.println("</script>");
			        out.println("<script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></script>");
			    }
			%>
		</form>
	</body>
</html>

