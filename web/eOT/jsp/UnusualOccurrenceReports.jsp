<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>                             
<% request.setCharacterEncoding("UTF-8");%>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String anaesthetist_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthetist.label","common_labels");
	String preferreddatefrom=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreferredDateFrom.label","common_labels");
	String preferreddateto=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PreferredDateTo.label","ip_labels");
	String surgery_date = "";
		
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
		System.err.println("Err Msg WaitlistReports.jsp "+e.getMessage());
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
	<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<script>
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
		var speciality_title=getLabel("Common.speciality.label","Common");
		var procedure_title=getLabel("Common.Procedure.label","Common");
		
</script>

</head>
<body OnMouseDown="CodeArrest()">
<form name='OtReportOptionsForm' id='OtReportOptionsForm'>
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<%
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
%>
<tr> 
	<td class='label' width='25%'><fmt:message key="Common.fromdate.label" bundle="${common_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	<td class='label' width='25%'><fmt:message key="Common.todate.label" bundle="${ip_labels}"/> </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10' >  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
</tr>
<tr>
	<td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param9' id='param9' value=""> 
		<input type='hidden' name="param10" id="param10" value=""> 
		<input type='text' name='param10_desc' id='param10_desc' size='20' title='<%=procedure_title%>' param1 = 'param9'  param2 = 'param10' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param9.value='',param10.value=''  " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		 <input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param10_desc);" >
	</td>
<!--	<td class='label' width='25%'><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param3' id='param3'> 
		<input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param4_desc' id='param4_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' "> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param4_desc);"  >
	</td>-->
	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param5' id='param5'> 
		<input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param6_desc' id='param6_desc' size='20' title='<%=speciality_title%>' param1 = 'param5'  param2 = 'param6' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param6_desc);" >
	</td>
</tr>
<tr>
	<td class='label' width='25%'><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param3' id='param3'> 
		<input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param4_desc' id='param4_desc' size='20' title='<%=operationRoom_title%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param4_desc);"  >
	</td>
	<td class='label' width='25%'> <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
	    <input type='hidden' name='param7' id='param7' value=''> 
		<input type='hidden' name='param8' id='param8' value=''> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' title='<%=surgeon_title%>' param1 = 'param7'  param2 = 'param8' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
	    <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param8_desc);" >
	</td>
<!--	<td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param9' id='param9' value=""> 
		<input type='hidden' name="param10" id="param10" value=""> 
		<input type='text' name='param10_desc' id='param10_desc' size='20' title='<%=procedure_title%>' param1 = 'param9'  param2 = 'param10' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param9.value='',param10.value=''  " > 
		 <input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param10_desc);" >
	</td>-->
	 

</tr>
<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
	    <input type='hidden' name='param11' id='param11' value="">
		<input type='hidden' name='param12' id='param12' value=""> 
		<input type='text' name='param12_desc' id='param12_desc' size='20' title='<%=anaesthetist_title%>' param1 = 'param11'  param2 = 'param12' key ='ANAESTHETIST' onBlur="if(this.value!='')callCommonLookup(this); else param11.value='',param12.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param12_desc);" >
	</td><td></td>
</tr>
	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">

	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRUNUOR">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRUNUOR">

	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
  	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2">
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=preferreddatefrom%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=preferreddateto%>" disabled>
	
	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1">
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Preferred Date">
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2">

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2">
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param9##Procedure">
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param10">

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param3##Speciality">
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param4">
<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

