<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                        
<% String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String procedure_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
		String speciality_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
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
<head>
	<script type='text/javascript' src='../../eCommon/js/common.js'></script>
<title></title>
	<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>
	<script src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script language="javascript" src="../../eOT/js/OTReportsLkupSQL.js"> </script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


	<script>
		var procedure_title=getLabel("Common.Procedure.label","Common");
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
	</script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr> 
	  <td class='label' width='25%'>
		<fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/>
	  </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');">
		
	 </td>
	  <td class='label' width='25%'>
			<fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/>
	  </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);"  maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');">
			
	 </td>
	 
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20'  maxlength='30' title='<%=surgeon_title%>' param1 = 'param3'  param2 = 'param4' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		   <input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
	<td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20'  maxlength='30' title='<%=procedure_title%>' param1 = 'param5'  param2 = 'param6' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		   <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
</tr>


<tr>
	<td class='label' width='25%'><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param8' id='param8'> 
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' maxlength='30' title='<%=surgeon_title%>' param1 = 'param7'  param2 = 'param8' key ='SURGERY_TYPE' onBlur="if(this.value!='')callSurgeryType(); else param7.value='',param8.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		   <input type='button' class='button' value='?' name='SurgeryType' id='SurgeryType' onClick="callSurgeryType();" >
	</td>

	<td align="right" width="25%" class="label"><fmt:message key="Common.ViewBy.label" bundle="${common_labels}"/> &nbsp;</td>
			<td align="left">
			<select name="P_VIEW_BY" id="P_VIEW_BY" tabindex="3">
				<option value="B"><fmt:message key="Common.Both.label" bundle="${common_labels}"/></option>
				<option value="P"><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></option>
				<option value="S"><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></option>
			</select>
			</td>
</tr>
<!-- <tr>
	<td class='label' width='25%'>
	<fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='param9' id='param9'> 
		<input type='hidden' name='param10' id='param10'> 
		<input type='text' name='param9_desc' id='param9_desc' size='20' title='<%=speciality_title%>' param1 = 'param9'  param2 = 'param10' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param9.value='',param10.value='' " > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param9_desc);" >
	</td>
	<td class='label' width='25%'></td>
	<td class='label' width='25%'></td>

</tr> -->

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRSAVGT">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRSAVGT">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="0" disabled>

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

