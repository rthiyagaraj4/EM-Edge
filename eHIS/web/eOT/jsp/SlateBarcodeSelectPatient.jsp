<!DOCTYPE html>
<%@ page  import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,java.sql.Clob,webbeans.eCommon.ConnectionManager" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%//@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,java.util.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% request.setCharacterEncoding("UTF-8"); %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>

<title>Scan Patient</title>
<head>
<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
	
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></SCRIPT>
	<script src='../../eOT/js/Barcode.js' language='javascript'></script>
	<script src='../../eOT/js/OTpatientSearch.js' language='javascript'></script>
	<script src='../../eOT/js/ScanPatient.js' language='javascript'></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name="SlateBarcodeSelectPatientForm" id="SlateBarcodeSelectPatientForm">
<% 	
	String theatre_date=request.getParameter("theatre_date");
	String theatre_date_from=request.getParameter("theatre_date_from");
	String function_id=request.getParameter("function_id");
	String PatIDLen="";
	Connection con = ConnectionManager.getConnection(request);
	PreparedStatement pstmt = null;
	ResultSet rs=null;

try{
	 String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
	 pstmt=con.prepareStatement(sqlLen);
	 rs=pstmt.executeQuery();
	 while(rs.next() && rs!=null)
	{
     PatIDLen   = (rs.getString("PATIENT_ID_LENGTH")==null)?"0":rs.getString("PATIENT_ID_LENGTH");

	}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	 }catch(Exception  ee){}finally{
		try{
		
			if(con!=null)
			ConnectionManager.returnConnection(con,request);
		}catch(Exception e){}
	}
%>
<br>
<table border='0' cellpadding='3' cellspacing='0' align='center' width='100%' >
<tr>
	<td class="label" ><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td class="fields" >
			<input type='text' name='patient_id' id='patient_id'maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' onkeypress="return CheckForSpecChars(event)"  align='right'  value="" onBlur="if(this.value!='')callPatSearch(); else clearDesc(); " >
			<input type='button' class='Button'  name='quest2' id='quest2' value='?' onClick='callPatSearch();'>
			<img src='../../eCommon/images/mandatory.gif'></img>


	</td>
</tr>
<tr>
<%if(function_id.equals("OT_CHECK_IN")){
%>
	<td class="label" ><fmt:message key="eOT.ApptRefnum.Label" bundle="${ot_labels}"/></td>
	<td class="fields" >
		<input type="text" name="appt_ref_num" id="appt_ref_num" size="10" value="" maxlength="10" readonly>
		<input type="button" class="button" name="appt_num_search" id="appt_num_search" value="?" onclick="searchApptRefNum(); " >
		<input type="hidden" name="appt_ref_code" id="appt_ref_code" value="?" disabled>
	</td>
<%}else if(function_id.equals("OT_CHECKIN_TO_OR")) {%>
		<td class="label" ><fmt:message key="eOT.OperNum.Label" bundle="${ot_labels}"/></td>
		<td class="fields" >
		<input type="text" name="oper_num" id="oper_num" size="10" value="" maxlength="10" readonly>
		<input type="button" class="button" name="oper_num_search" id="oper_num_search" value="?" onclick="searchOperNum(); " >
		<input type="hidden" name="oper_code" id="oper_code" value="?" disabled>
	</td>
<%}%>
</tr>
<tr>
	<td class="fields">
		<input type="button" class="button" name="OK" id="OK" value='<fmt:message key="Common.ok.label" bundle="${common_labels}"/>' onclick="callBarcodeFunction();if(window.returnValue!='INVALID_PATIENT')window.close();">
		<input type="button" class="button" name="Cancel" id="Cancel" value='<fmt:message key="Common.cancel.label" bundle="${common_labels}"/>' onclick="closeWindow();">
	</td>
</tr>
</table>
	<input type='hidden' name='params' id='params' value="<%=request.getQueryString()%>" >
	<input type='hidden' name='url_desc' id='url_desc' value="<%=request.getParameter("url_desc")%>" >
	<input type='hidden' name='login_user' id='login_user' value="<%=session.getAttribute("login_user")%>" >
	<input type='hidden' name='theatre_date' id='theatre_date' value="<%=theatre_date%>" >
	<input type='hidden' name='theatre_date_from' id='theatre_date_from' value="<%=theatre_date_from%>" >
	<input type='hidden' name='function_id' id='function_id' value="<%=function_id%>" >
	<input type='hidden' name='sch_type' id='sch_type' value="" >
	<input type='hidden' name='operation_number' id='operation_number' value="" >
	<input type='hidden' name='order_id' id='order_id' value="" >
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>



