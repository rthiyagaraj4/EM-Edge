<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE"); %>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %> 

<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
  
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
		System.err.println("Err Msg OtmsBySurgeryType.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }
 
%>

<html>
<head>
	<script language="javascript" src="../../eCommon/js/common.js" ></script>
	<title></title>
	<%
	String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script language="javascript" src="../../eCommon/js/CommonLookup.js"></script>
	<script language="javascript" src="../../eOT/js/OtReports.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
		var speciality_title=getLabel("Common.speciality.label","common");
	</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table border='0' cellpadding=3 cellspacing='0' width='100%'>
<tr> 
	<td class='label' width="25%" ><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> 
	</td>
	  <td class='fields' width="25%">
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onBlur="CheckDate(this);">  <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	  <td class='label' width="25%" ><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width="25%" >
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onBlur="CheckDate(this);">  <image src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <td colspan='8'></td>
</tr>

<tr>
	<td class='label' width="25%"><fmt:message key="Common.speciality.label" bundle="${common_labels}"/></td>
     <td class='fields' width="25%">
		<input type='hidden' name='param10' id='param10' value=""> 
		<input type='hidden' name="param9" id="param9" value=""> 
		<input type='text' name='param9_desc' id='param9_desc' size='15'  >
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="srchCommonCode(param9,param9_desc,param10,speciality_title, document.forms[0].sql_text_2.value );" >
	</td>
	<td class='fields' width="25%"></td>
</tr>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
 	<input type="hidden" name="p_report_id" id="p_report_id" value="OTROPERT">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTROPERT">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_2" id="sql_text_2" value="<%=sql_speciality%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="0" disabled>
	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>
	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="0" disabled>

<!-- 	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param9##Operation Type">
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param10">
 -->
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
 </form>
</body>
</html>

