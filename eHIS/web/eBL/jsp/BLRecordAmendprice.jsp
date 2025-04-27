<!DOCTYPE html>
<!-- Page Added by Nandhini for Price Discount Create Record -->    
<!-- 
Sr No        Version              TFS              SCF/CRF           		   Developer Name
-----------------------------------------------------------------------------------------------
1            V210217            14525 	       	MMS-QH-CRF-0128.2		       Nandhini M 
--> 

<%@page import="eBL.BlServiceDiscPriceBean"%>
<%@page import="webbeans.eCommon.ConnectionManager"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.ResultSet"%>
<%@page import="java.sql.Connection"%>

<%@page import="eBL.Common.BlRepository"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%!
    private String checkForNull(String inputString)
	{	
		if(inputString == null || inputString == "null"){
			//inputString=="";
			System.err.println("28===>");
			return "";
		}
		else{
			System.err.println("27===>");
			return inputString;
		}
		
	}
%>
<%
	String sStyle = (session.getAttribute("PREFERRED_STYLE") != null)
			|| (session.getAttribute("PREFERRED_STYLE") != "") ? (String) session
			.getAttribute("PREFERRED_STYLE") : "IeStyle.css";
			int tableIndex = 1; // added against 128.2

	String mode=request.getParameter("mode")==null?"":request.getParameter("mode");
	System.err.println(mode);
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css"></link>
<script language="javascript" src="../../eCommon/js/common.js"></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js' ></script>
<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
<script language="javascript" src="../../eBL/js/BLServiceDiscountPrice.js"></script>
<script language='javascript' src='../../eCommon/js/jquery-3.6.3.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body onKeyDown= "lockKey();" onMouseDown="CodeArrest();">
	<form name = 'discbulkupd' id='discbulkupd' >	
      	<table name='RecordAmend' id='RecordAmend' id='RecordAmend' width='100%' cellpadding='3'  cellspacing='0' align="center" >
			<div id="tableContainer">
		<tr>
      		<td colspan='4'>
      		</td>
      		<td width='25%' nowrap class='fields'>
      			&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
      			<input type='button' class='button' id='record_btn' name="record_btn" id="record_btn" onclick='fnRecord();' value='<fmt:message key="Common.record.label" bundle="${common_labels}"></fmt:message>' tabindex='2'>      				
      			&nbsp;&nbsp;&nbsp;&nbsp;
      			<input type='button' class='button' id='cancel_btn' name="cancel_btn" id="cancel_btn" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"></fmt:message>'  onClick="parent.parent.document.getElementById('dialog_tag').close(); " tabindex='2'>
      		</td>
      		</tr>
	</table>
      			
				<input type='hidden' name='lastRowIndex' id='lastRowIndex' id='lastRowIndex' value='<%=tableIndex%>'>
				<input type='hidden' name='inclRowCount' id='inclRowCount' value='<%=tableIndex -1 %>'>
				<input type='hidden' name='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' id='discDtls<%=tableIndex%>' value=''>
	</form>
	</body>
	</html>

