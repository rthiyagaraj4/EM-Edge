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
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String anaesthetist_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthetist.label","common_labels");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('MD', 'SG') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	String  sql_anaesthetist = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('AN') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";

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
		System.err.println("Err Msg OperativeMortalityReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
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
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eOT/js/OtReports.js" ></script>
<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
<script src="../../eCommon/js/common.js" ></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<script>
		var speciality_title=getLabel("Common.speciality.label","Common");
		var surgeon_title=getLabel("Common.Surgeon.label","Common");
		var anaesthetist_title=getLabel("Common.Anaesthetist.label","Common");
</script>
</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr> 
	   <td class='label' width='25%'><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/></td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	   <td class='label' width='25%'><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);"  maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	
</tr>

<tr>
	 <td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=speciality_title%>' param1 = 'param3'  param2 = 'param4' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' "> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
		

<!-- 	<td class='label' align='right' nowrap>To Speciality </td>
	 <td align='left'>
		 <input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param4_desc' id='param4_desc' size='20' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param4,param4_desc, 'To Speciality', document.forms[0].sql_text_2.value);" >
	 </td>
 -->
	 <td class='label' width='25%'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
	     <input type='hidden' name='param5' id='param5'> 
		<input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=surgeon_title%>' param1 = 'param5'  param2 = 'param6' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
		
</tr>


<tr>
	 <td class='label' width='25%'><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
	    <input type='hidden' name='param7' id='param7'> 
		<input type='hidden' name='param8' id='param8'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' title='<%=anaesthetist_title%>' param1 = 'param7'  param2 = 'param8' key ='ANAESTHETIST' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='AnaesthetistLookUp' id='AnaesthetistLookUp' onClick="callCommonLookup(param7_desc);" >
	</td>
	 <td colspan='2'></td>
</tr>


	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTROPRMT">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTROPRMT">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_2" id="sql_text_2" value="<%=sql_speciality%>" disabled>
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_surgeon%>" disabled>
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_anaesthetist%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="1" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Speciality" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
    <input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param4#param3#param5#param6#param7#param8#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>
</body>
</html>

