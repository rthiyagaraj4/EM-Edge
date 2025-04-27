<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" %>            
<% String locale = (String)session.getAttribute("LOCALE"); 
locale=locale.toLowerCase();
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% request.setCharacterEncoding("UTF-8");%>

<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript'>
function changeReportId(obj)
{
 var frmObj=document.forms[0];
 if(obj.value=='D')
	{
	   frmObj.p_report_id.value='OTRAVPRD';
	   frmObj.pgm_id.value='OTRAVPRD';
	}
else  if(obj.value=='S')
	{
	   frmObj.p_report_id.value='OTRAVPRS';
	   frmObj.pgm_id.value='OTRAVPRS';
	}
}
</script>
<%
	String operationroom_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String surgeon_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String speciality_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	//String  sql_oper_room = "SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM WHERE OPERATING_FACILITY_ID = '"+facility_id+"'  AND  UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";

	String  sql_oper_room = "SELECT OPER_ROOM_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_ROOM_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND OPERATING_FACILITY_ID = '"+facility_id+"'  AND  UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_ROOM_CODE) LIKE UPPER(?) ORDER BY 2";

	String  sql_procedure = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";
// String  sql_role_type = "SELECT ROLE_TYPE CODE, nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF) DESCRIPTION FROM OT_ROLE_TYPE WHERE ROLE_TYPE IN ('OS', 'AS') AND UPPER(nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF)) LIKE UPPER(?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) ORDER BY 2";

	String  sql_role_type = "SELECT ROLE_TYPE CODE, nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF) DESCRIPTION FROM OT_ROLE_TYPE_LANG_VW WHERE ROLE_TYPE IN ('OS', 'AS') AND UPPER(nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF)) LIKE UPPER(?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) AND LANGUAGE_ID='"+locale+"' ORDER BY 2";
  
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			//surgery_date = rst.getString("CURRENT_DATE");
			//Buddhist date conversion (Thai Locale)
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);

		}

	}
	catch(Exception e){
		System.err.println("Err Msg SummaryOfOperByOtRoomReports.jsp "+e.getMessage());
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
	<script src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
	<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
	<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%'>

<tr> 
	  <td class='label' width='25%'><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		 
	  <td class='label' width='25%'><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
	  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'> 
	  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
</tr>

  
<tr>
	<td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
     <td class='fields' width='25%'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='proc5_desc' id='proc5_desc' size='20' title='<%=procedure_title%>' param1 = 'param5'  param2 = 'param6' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else callClearParam(param5,param6); " colspan="2" maxlength='70'>
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(proc5_desc);" >
	</td>
<!-- 	<td class='label' align='right' nowrap>To Procedure &nbsp;</td> 
	 <td align='left'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param6_desc' id='param6_desc' size='30' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param6,param6_desc, 'To Procedure', document.forms[0].sql_text_2.value);" >
	 </td> 
 -->
	  <td class='label' width='25%'>
	  <fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>
	  </td>
	  <td class='fields' width='25%'>
		  <select name="param7" id="param7"  OnChange="changeReportId(this)">  
		  <option value="S" >
		  <fmt:message key="Common.Summary.label" bundle="${common_labels}"/> </option>
		  <option value="D" >
		  <fmt:message key="Common.Detail.label" bundle="${common_labels}"/> </option>
		  </select>
 	  	  <img src='../../eCommon/images/mandatory.gif'></img>   
	  </td>
</tr>
<!--/* this Code is only for Siriraj Purpose*/ <tr>
	<td class='label' width='25%'>
	<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='param8' id='param8'> 
		<input type='hidden' name='param9' id='param9'> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' title='<%=surgeon_title%>' param1 = 'param8'  param2 = 'param9' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param8.value='',param9.value='' " > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param8_desc);" >
	</td>

	<td class='label' width='25%'>
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='param10' id='param10'> 
		<input type='hidden' name='param11' id='param11'> 
		<input type='text' name='param10_desc' id='param10_desc' size='20' title='<%=speciality_title%>' param1 = 'param10'  param2 = 'param11' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param10.value='',param11.value='' " > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param10_desc);" >
	</td>
</tr> -->

<tr>
	<td class='label' width='25%'><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
     <td class='fields' width='25%' colspan='3'>
		<input type='hidden' name='param3' id='param3'> 
		<input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=operationroom_title%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else callClearParam(param3,param4)" colspan="2" maxlength='70'>
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
</tr>
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRAVPRS">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRAVPRS">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_1" id="sql_text_1" value="<%=sql_oper_room%>" disabled>
	<input type="hidden" name="sql_text_2" id="sql_text_2" value="<%=sql_procedure%>" disabled>
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_role_type%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="1" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param5##Procedure" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param6" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

