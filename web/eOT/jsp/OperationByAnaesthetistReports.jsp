<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>                      

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

<script language='javascript'>
function changeReportId(obj)
{
 var frmObj=document.forms[0];          
// alert(obj.value);
 if(obj.value=='C')
	{
	   frmObj.p_report_id.value='OTROPRAC';
	   frmObj.pgm_id.value='OTROPRAC';
	}
else  if(obj.value=='D')
	{
	   frmObj.p_report_id.value='OTRANOPR';
	   frmObj.pgm_id.value='OTRANOPR';
	}

//	alert(frmObj.p_report_id.value+"  and  "+frmObj.pgm_id.value);
}
</script>
						 

<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String anesthetist_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthetist.label","common_labels");
	String anaesthesiacode_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.AnaesthesiaCode.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String position_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Position.label","common_labels");
	String surgery_date = "";
	String  sql_role_type = "SELECT A.ROLE_TYPE CODE, A.ROLE_TYPE_DESC DESCRIPTION FROM OT_ROLE_TYPE_LANG_VW A  WHERE ROLE_TYPE IN ('MA', 'AA') AND UPPER(A.ROLE_TYPE_DESC) LIKE UPPER(?) AND UPPER(A.ROLE_TYPE) LIKE UPPER(?) AND A.LANGUAGE_ID='"+locale+"' ORDER BY 2";
	
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
		System.err.println("Err Msg OperationByAnaesthetistReports.jsp "+e.getMessage());
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
 	<script src="../../eCommon/js/common.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0' width='100%'>
<tr> 
	   <td class='label' width='25%'><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
	  <!-- Added against 57894 Starts -->
		  <input type='text' name='param1_disp' id='param1_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');"><img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	 </td>
		
	   <td class='label' width='25%'><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param2_disp' id='param2_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2_disp');"><img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param2' id='param2' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	  <!-- Added against 57894 Ends -->
	 </td>
	 
</tr>

<tr>
	 <td class='label' width='25%'><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
	 <input type='hidden' name='param11' id='param11'>
		<input type='hidden' name='param10' id='param10'> 
		<input type='text' name='param10_desc' id='param10_desc' size='20' title='<%=anesthetist_title%>' param1 = 'param10'  param2 = 'param11' key ='ANAESTHETIST' onBlur="if(this.value!='')callCommonLookup(this); else param10.value='',param11.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param10_desc);" >
	
	 <td class='label' width='25%'><fmt:message key="Common.AnaesthesiaCode.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param13' id='param13'> 
		<input type='hidden' name='param12' id='param12'> 
		<input type='text' name='param12_desc' id='param12_desc' size='20' title='<%=anaesthesiacode_title%>' param1 = 'param12'  param2 = 'param13' key ='ANAESTHESIA' onBlur="if(this.value!='')callCommonLookup(this); else param12.value='',param13.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param12_desc);" >
	</td>
</tr>

<tr>
	 <td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
	    <input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=speciality_title%>' param1 = 'param5'  param2 = 'param6' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>

	 <td class='label' width='25%'><fmt:message key="Common.Position.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
		 <input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=position_title%>' param1 = 'param3'  param2 = 'param4' key ='POSITION' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='PositionLookUp' id='PositionLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
</tr>
<tr>
	 <td class='label' width='25%'><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' onBlur="if(this.value!='')searchCode(param7,param7_desc,'Role Type',document.forms[0].sql_text_4.value);else param7.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='RoleTypeLookUp' id='RoleTypeLookUp' onClick="searchCode(param7,param7_desc,'Role Type',document.forms[0].sql_text_4.value);" >
	</td>
	 <td class='label' width='25%'><fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td>
	 <td class='fields' width='25%'>
		  <select name="param8" id="param8"  OnChange="changeReportId(this)">  
		  <option value="D" ><fmt:message key="Common.ByDate.label" bundle="${common_labels}"/> </option>
		  <option value="C" ><fmt:message key="eOT.Cumulative.Label" bundle="${ot_labels}"/> </option>
		  </select>
 	  	  <img src='../../eCommon/images/mandatory.gif'></img>   
	  </td>
</tr>


	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRANOPR">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRANOPR">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_role_type%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="3" disabled>

	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param12##Anaesthesia" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param13" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param3##Position" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param4" disabled>

	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param5##Speciality" disabled>
    <input type="hidden" name="compare_to_3" id="compare_to_3" value="param6" disabled>

	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
    <input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param11#param10#param12#param13#param5#param6#param4#param3#param7#param8#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>
</body>
</html>

