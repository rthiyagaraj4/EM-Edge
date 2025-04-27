<!DOCTYPE html>
<%//@ page import ="java.sql.*,java.util.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,eOT.*,eOT.Common.*"  %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); 
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>      
<%@ page  import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String fromdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.fromdate.label","common_labels");
	String todate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.todate.label","common_labels");
	String speciality_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String surgery_date = "";

	if(facility_id == null) facility_id="";

	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//Buddhist date conversion (Thai Locale)
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			
			//surgery_date = rst.getString("CURRENT_DATE");
		}
	}
	catch(Exception e){
		System.err.println("Err Msg TheatreUtilizationReports.jsp "+e.getMessage());
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
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="JavaScript" src="../../eOT/js/OtReports.js" ></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>

	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>


<!-- 	<script src="../../eOT/js/OTMessages.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

 --></head>
<body OnMouseDown="CodeArrest()">
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%'>

<tr> 
	  <td class='label' width='25%'><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/></td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	  <td class='label' width='25%'><fmt:message key="Common.todate.label" bundle="${common_labels}"/></td>
	  <td class='fields' width='25%'>
	  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'> 
	  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img> 
	 </td>
	 <td colspan='2'></td>
</tr>
 
<!-- /* this Code is only for Siriraj Purpose*/<tr>
	<td class='label' width='25%'>
	<fmt:message key="eOT.FromOperationRoom.Label" bundle="${ot_labels}"/></td>
<td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " > 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
	
<td class='label' width='25%'>
	<fmt:message key="eOT.ToOperationRoom.Label" bundle="${ot_labels}"/></td>
<td class='fields' width='25%'>
		<input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param5'  param2 = 'param6' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " > 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
	
</tr>
<tr>

	<td class='label' width='25%'>
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='param7' id='param7'> 
		<input type='hidden' name='param8' id='param8'> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' title='<%=speciality_title%>' param1 = 'param7'  param2 = 'param8' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value='' " > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param8_desc);" >
	</td>
	<td class='label' width='25%'></td>
	<td class='label' width='25%'></td>
</tr>
 -->
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRTHUTL">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRTHUTL">

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=todate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<!--/* this Code is only for Siriraj Purpose*/ <input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Operation Room" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Operation Room" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled> -->

<input type='hidden' name='locale' id='locale' value="<%=locale%>">

</form>
</body>
</html>

