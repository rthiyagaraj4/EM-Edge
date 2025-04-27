<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	//String patientId_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.patientId.label","common_labels")+",";
 	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	String  sql_patient = "SELECT PATIENT_ID CODE, decode('"+locale+"','en',PATIENT_NAME, NVL(C.PATIENT_NAME_LOC_LANG,C.PATIENT_NAME)) DESCRIPTION FROM MP_PATIENT WHERE  UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PATIENT_ID) LIKE UPPER(?) ORDER BY 2";

	if(facility_id == null) facility_id="";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date = rst.getString("CURRENT_DATE");
		}
	}
	catch(Exception e){
		System.err.println("Err Msg OperationNotesReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }

%>
<html>
<head><title></title>
	<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script language="JavaScript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm'  action="../../eOT/jsp/CallNotes.jsp"  target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0' width='100%'>
	
<tr>
	<td class='label' width="25%" nowrap>
		<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width="25%" >
		<input type='hidden' name="param3" id="param3" value=""> 
		<input type='text' name='param3_name' id='param3_name' size='60' > 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="searchCode(param3,param3_name,patientId_title, document.forms[0].sql_text.value );" >
	</td>
   <td colspan='2'></td>
<tr>

<tr>
	<td class='label' width="25%" nowrap>
		<fmt:message key="eOT.FromOperationNO.Label" bundle="${ot_labels}"/>
	</td>
     <td class='fields' width="25%" >
		<input type='hidden' name="param4" id="param4" value=""> 
		<input type='text' name='param4_desc' id='param4_desc' size='15' > 
	</td>
		
	<td class='label' width="25%" nowrap>
		<fmt:message key="eOT.ToOperationNo..Label" bundle="${ot_labels}"/>
	</td>
     <td class='fields' width="25%" >
		<input type='hidden' name='param5' id='param5' value=""> 
		<input type='text' name='param5_desc' id='param5_desc' size='15' > 
	</td>
</tr>


<tr> 
	  <td class='label' width="25%" nowrap>
		<fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width="25%" >
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' > 
		  <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	  <td class='label' width="25%" nowrap>
		<fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/>
	</td>
	  <td class='fields' width="25%"  >
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' >  <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <td colspan='2'></td>
</tr>													 
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRNOTES">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRNOTES">
	<input type="hidden" name="sql_text" id="sql_text" value="<%=sql_patient%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="0" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="0" disabled>
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

