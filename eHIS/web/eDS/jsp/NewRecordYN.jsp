<!DOCTYPE html>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<%@  page language="java" import = "eCommon.XSSRequestWrapper" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<html locale="true">
	<%      
	        //Added Against MMS Vulnerability Issue - Starts
            request= new XSSRequestWrapper(request);
            response.addHeader("X-XSS-Protection", "1; mode=block");
            response.addHeader("X-Content-Type-Options", "nosniff");
	        //Added Against MMS Vulnerability Issue - Ends 
			String sStyle = ((session.getAttribute("PREFERRED_STYLE") != null) || (session
			.getAttribute("PREFERRED_STYLE") != "")) ? (String) session.getAttribute("PREFERRED_STYLE")
			:"IeStyle.css" ;
			if(sStyle==null)sStyle="IeStyle.css";
			String recordId = (String) request.getParameter("id");
			System.out.println("recordIdddd"+recordId);
	%>
<head>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script src='../../eCommon/js/messages.js' language='javascript'></script>
	<Script language="JavaScript" src="../../eDS/js/MealOrderForStaffs.js"></Script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>

	<title>Confirm</title>
</head>
<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<form name="NewRecord" id="NewRecord">
		<table border='0' cellspacing='0' width='100%' height="100%" align='center'>
			<tr>
				<td colspan="4">
					<fmt:message key="eOT.mealOrderForStaff.displayMessage" bundle="${ot_labels}"/>
				</td>
			</tr>
			<tr>
				<td colspan="4">
				</td>
			</tr>
			<tr>
				<td colspan="4">
				</td>
			</tr>
			<tr>
				<td>
					<input type="button" value="Create New" property="Create New" onclick="createNewRecord()" styleClass="BUTTON" />
				</td>
				<td>
					<input type="button" value="Cancel" property="Cancel" onclick="cancelTransaction()" styleClass="BUTTON" />
				</td>
				<td>

				</td>
				<td>

				</td>
			</tr>
			<tr>
				<td colspan="4">
				</td>
			</tr>
			<tr>
				<td colspan="4">
				</td>
			</tr>
			<input type="hidden" name="recordId" id="recordId" value="<%=recordId%>"/>
			</form>
</body>
</html>

