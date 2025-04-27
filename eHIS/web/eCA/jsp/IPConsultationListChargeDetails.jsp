<!DOCTYPE html>

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
	<head>
		<title></title>

	<%
		  request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MOHE-SCF-0153
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
		  String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
		%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="Javascript" src="../../eCommon/js/ValidateControl.js"></script>
		<script src='../../eCommon/js/common.js' language='javascript'></script>
		<script Language="JavaScript" src='../../eCA/js/IPConsultationList.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

		</head>
 <%
	String total_amt ="";
	String total_pat_payable ="";
	String aproval_reqd ="";
	String rownum ="";
	String checked ="";

	total_amt = request.getParameter("total_amt")==null?"":request.getParameter("total_amt");
	total_pat_payable = request.getParameter("total_pat_payable")==null?"":request.getParameter("total_pat_payable");
	aproval_reqd = request.getParameter("aproval_reqd")==null?"":request.getParameter("aproval_reqd");
	rownum = request.getParameter("rownum")==null?"":request.getParameter("rownum");

	

	if(aproval_reqd.equals("Yes"))
	{
		checked="checked";
	}
	else if(aproval_reqd.equals("No"))
	{
		checked="";
	}

 %>

 <body onKeyDown = 'lockKey()'>
		<form name='IPConsultationListChargeDetailsForm' id='IPConsultationListChargeDetailsForm' method='post' target='messageFrame' action=''>
		<table border="1" cellpadding="3" cellspacing="0" width="100%" align="center" name="resultTable" id="resultTable" id="resultTable">
		
		<tr>
			<th><fmt:message key='Common.defaultSelect.label' bundle='${common_labels}'/></th>
			<th>Rate</th>
			<th>Practitioner/Staff Type</th>
			<th>Practitioner/Staff</th>
			<th>Total Payable</th>
			<th>Patient Payable</th>
			<th>Patient Paid</th>
			<th>Preapproved Reqd</th>
			<th>&nbsp;</th>
		</tr>

		<tr>
		<td><input type='checkbox' name='chkSelect' id='chkSelect'></td>
		<td><input type='text' size=10 maxlength='10' name='rate' id='rate' disabled onblur ="calcRate(this,'<%=rownum%>')"></td>
		<td><input type='text' size=10 maxlength='10' name='pract_type' id='pract_type' onblur =""></td>
		<td><input type='text' size=10 maxlength='10' name='pract_name' id='pract_name' onblur =""></td>
		<td><input type='text' size=10 maxlength='10' name='total_payable' id='total_payable' value='<%=total_amt%>' onblur ="" readOnly ></td>
		<td><input type='text' size=10 maxlength='10' name='patient_payable' id='patient_payable' value='<%=total_pat_payable%>' onblur ="" readOnly ></td>
		<td><input type='text' size=10 maxlength='10' name='patient_paid' id='patient_paid' onblur ="" readOnly ></td>
		<td><input type='checkbox' name='chk_apprReqd' id='chk_apprReqd' value='<%=aproval_reqd%>' <%=checked%> onClick="apprvlReqd(this);" ></td>
		<td>&nbsp;</td>
		</tr>

		</table>
			<input type='hidden' name='rownum' id='rownum' value="<%=rownum%>">
		</form>
		
  </body>
</html>

