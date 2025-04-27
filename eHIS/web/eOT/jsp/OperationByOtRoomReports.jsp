<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                 
<% String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>                  
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%
	//String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels")+",";
	//String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+",";
	//String status_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels")+",";
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String status_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.status.label","common_labels");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String  sql_ot_status = "SELECT A.STATUS_CODE CODE, A.STATUS_DESC DESCRIPTION FROM OT_STATUS_LANG_VW A  WHERE UPPER(A.STATUS_DESC) LIKE UPPER(?) AND UPPER(A.STATUS_CODE) LIKE UPPER(?) AND A.LANGUAGE_ID ='"+locale+"' ORDER BY 2";

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
		surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}

	}
	catch(Exception e){
		System.err.println("Err Msg OperationListReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }

%>

<html>
<head>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<title></title>
	<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<script src="../../eCommon/js/common.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0' width='100%' align='center'>
<tr> 
	 <td class='label' width='25%'>
		<fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> 
	</td>
	 <td class='fields' width='25%'>
	 <!-- Added against 57892 Starts -->
		  <input type='text' name='param1_disp' id='param1_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>

	 </td>
	 <td class='label' width='25%'>
	 <fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param2_disp' id='param2_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10' >
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2_disp');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param2' id='param2' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	 <!-- Added against 57892 ends -->
	 </td>
	 
</tr>

<tr>
	<td class='label' width='25%'>
	<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
<td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
	
	<td class='label' width='25%'>
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=speciality_title%>' param1 = 'param5'  param2 = 'param6' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLook' id='SpecialityLook' onClick="callCommonLookup(param5_desc);" >
	</td>
</tr>
<tr>
	<td class='label' width='25%'>
	<fmt:message key="Common.status.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%' colspan="3">
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' onBlur="if(this.value!='')searchCode(param7,param7_desc,'<%=status_title%>',document.forms[0].sql_text_3.value); else param7.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='StatusLookUp' id='StatusLookUp' onClick="searchCode(param7,param7_desc,'<%=status_title%>',document.forms[0].sql_text_3.value);" >
	</td>
	<td class='fields' width='25%'>
	 </td>
	 <td class='fields' width='25%'>
	 </td>
</tr>
					 

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTROROPR">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTROROPR">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_ot_status%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>


	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##OperatingRoom" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>


	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Speciality" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled>


	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param3#param4#param5#param6#param7#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>
</body>
</html>

