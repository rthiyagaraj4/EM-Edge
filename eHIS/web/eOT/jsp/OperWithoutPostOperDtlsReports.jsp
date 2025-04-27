<!DOCTYPE html>
 <%@ page contentType="text/html;charset=UTF-8"%>              
<% String locale = (String)session.getAttribute("LOCALE"); 
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String fromregistrationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromRegistrationDate.Label","ot_labels");
	String toregistrationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToRegistrationDate.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgery_date = "";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){

			//Buddhist date conversion (Thai Locale)
			//surgery_date = rst.getString("CURRENT_DATE");
			surgery_date=com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
			
		}
	}
	catch(Exception e){
		System.err.println("Err Msg SpecimenRegisterReports.jsp "+e.getMessage());
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
	<script language="JavaScript" src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<script language="JavaScript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script language="JavaScript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<script>
			var speciality_title=getLabel("Common.speciality.label","common");
			
	</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%'>

<tr> 
	  <td class='label' width='25%'><fmt:message key="eOT.FromRegistrationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);"> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	 <td class='label' width='25%'><fmt:message key="eOT.ToRegistrationDate.Label" bundle="${ot_labels}"/> </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);"> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=speciality_title%>' param1 = 'param3'  param2 = 'param4' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
<td colspan='2'></td>
<!-- 	<td class='label' align='right' nowrap>To Speciality </td>
	 <td align='left'>
		 <input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param4_desc' id='param4_desc' size='20' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param4,param4_desc, 'To Speciality', document.forms[0].sql_text_1.value);" >
	 </td>
 --></tr>

						   						        

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRNOPOP">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRNOPOP">
	
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromregistrationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=toregistrationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Registration Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="1" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Speciality" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
    <input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param4#param3#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>
</body>
</html>

