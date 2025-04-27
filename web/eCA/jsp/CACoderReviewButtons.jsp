<!DOCTYPE html>
<%
/*
-------------------------------------------------------------------------------------------------------------------------------------
Date		Edit History	Name				Rev.Date		Rev.Name		Description
-------------------------------------------------------------------------------------------------------------------------------------
03/06/2020 	  		Ramesh Goli												AAKH-CRF-0122.2
01/07/2020 	  		Chandrashekar											AAKH-CRF-0122.2
-------------------------------------------------------------------------------------------------------------------------------------
*/ 
%>
<%@ page import="java.sql.*,webbeans.eCommon.*,eCA.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8"%> 
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%@include file="../../eCommon/jsp/GetPersistenceBean.jsp" %>
<html>
<%
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
%>
<head>
<%
String sStyle =			(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script language='javascript' src='../../eCA/js/CACodersReview.js'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head> 

<body  onload='FocusFirstElement()'  onMouseDown="CodeArrest()" onKeyDown="lockKey()">

<%
String bean_id				= "CACoderFunction" ;
	String bean_name			= "eCA.CACoderFunction";
	CACoderFunction bean	= (CACoderFunction)getBeanObject( bean_id, bean_name , request) ;
	String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
	String from_date = request.getParameter("from_date")==null?"":request.getParameter("from_date");
	String to_date = request.getParameter("to_date")==null?"":request.getParameter("to_date");
	System.err.println("excel result@@==="+patient_id+"from_date=="+from_date+"to_date=="+to_date);
  
%>
<form name='PendingOrdersBottom' id='PendingOrdersBottom' action='../../servlet/eCA.CoderReviewDataExcelBookServlet' method = 'post' target='messageFrame' >
<table cellpadding=3 cellspacing=0 border=0 width="100%" height="100%" align=center>
	<tr>
		<td width ='80%'class='button'>
		<INPUT TYPE="button" value='<fmt:message key="eCA.RecordCompletion.label" bundle="${ca_labels}"/>' class='button' onClick='record()'>
		
		<INPUT TYPE="button" value='<fmt:message key="eCA.Export.label" bundle="${ca_labels}"/>' class='button' onclick='getExcelSheet()'>
		</td>
	</tr>

</table>
             <input type="hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">	
			<input type='hidden' name='from_date' id='from_date' value='<%=from_date%>'/>
			<input type='hidden' name='to_date' id='to_date' value='<%=to_date%>'/>

</form>
</body>
</html>

