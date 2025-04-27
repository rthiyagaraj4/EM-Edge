<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8"%>         
<% String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.Common.OTRepository" %>

<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
	
	String roletype_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoleType.label","common_labels");
	String anaesthetist_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthetist.label","common_labels");
	String anaesthesia_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthesia.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");

	if(facility_id == null) facility_id="";
	String  sql_role_type = "SELECT ROLE_TYPE CODE, nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF) DESCRIPTION FROM OT_ROLE_TYPE_LANG_VW WHERE LANGUAGE_ID='"+locale+"' AND ROLE_TYPE IN ('MA', 'AA') AND UPPER(nvl(ROLE_TYPE_DESC,ROLE_TYPE_DESC_SYSDEF)) LIKE UPPER(?) AND UPPER(ROLE_TYPE) LIKE UPPER(?) ORDER BY 2";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_lang_vw where language_id = ? ORDER BY 2";

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
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		pstmt = con.prepareStatement(sql_surgery_type);
		pstmt.setString(1,locale);
		rst = pstmt.executeQuery();


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
	<script language="JavaScript" src="../../eCommon/js/common.js"></script>
	<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language="Javascript" src="../../eOT/js/OTCommon.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



	<script>
		var roleType_title=getLabel("Common.RoleType.label","common");
		var anaesthesia_title=getLabel("Common.Anaesthesia.label","common");
		var speciality_title=getLabel("Common.speciality.label","common");
		var anaesthetist_title=getLabel("Common.Anaesthetist.label","common");
	</script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0' width='100%'>
<tr> 
	  <td class='label' width='25%'><fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <td class='label' width='25%'><fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);"> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 <td colspan='2'></td>
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
	     <input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=anaesthetist_title%>' param1 = 'param3'  param2 = 'param4' key ='ANAESTHETIST' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " > 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
		
	<!--<td class='label' align='right'nowrap>To Anaesthetist </td>
     <td align='left'>
		<input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param4_desc' id='param4_desc' size='20' > 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="searchCode(param4,param4_desc,'To Anaesthetist', document.forms[0].sql_text_1.value);" >
	</td>-->

	<td class='label' width='25%'><fmt:message key="Common.AnaesthesiaCode.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param9' id='param9'> 
		<input type='hidden' name='param8' id='param8'> 
		<input type='text' name='param8_desc' id='param8_desc' size='20' title='<%=anaesthesia_title%>' param1 = 'param8'  param2 = 'param9' key ='ANAESTHESIA' onBlur="if(this.value!='')callCommonLookup(this); else param8.value='',param9.value='' " > 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param8_desc);" >
	</td>

<!-- 	<td class='label' align='right'nowrap>To Anaesthesia Code </td>
     <td align='left'>
		<input type='hidden' name='param9' id='param9'> 
		<input type='text' name='param9_desc' id='param9_desc' size='20' > 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="searchCode(param9,param9_desc,'To Anaesthesia', document.forms[0].sql_text_4.value);" >
	</td> -->
 <td colspan='2'></td>
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=speciality_title%>' param1 = 'param5'  param2 = 'param6' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' "> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>

<!-- 	<td class='label' align='right' nowrap>To Speciality </td>
	 <td align='left'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param6_desc' id='param6_desc' size='20' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param6,param6_desc, 'To Speciality', document.forms[0].sql_text_2.value);" >
	 </td> -->
	<td class='label' width='25%'><fmt:message key="Common.RoleType.label" bundle="${common_labels}"/></td>
     <td class='fields' width='25%' colspan='3'>
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' onBlur="if(this.value!='')searchCode(param7,param7_desc,'<%=roletype_title%>',document.forms[0].sql_text_3.value);else param7.value=''"> 
		<input type='button' class='button' value='?' name='StatusLookUp' id='StatusLookUp' onClick="searchCode(param7,param7_desc,'<%=roletype_title%>',document.forms[0].sql_text_3.value);" >
	</td>
</tr>
<tr>
	<td class='label' align='left' nowrap><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/> &nbsp;</td>
		<td align='left'>
		 <select name="p_surgery_type" id="p_surgery_type" >  
		<option value= "" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<% while(rst.next()){ %>
		  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
<%   }%>

	</td>
</tr>
<%
}
	catch(Exception e){
		System.err.println("Err Msg SmryOfOperByAnaesthetistReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(rst!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request);
  }
%>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRANGRP">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRANGRP">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_role_type%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2" disabled>

	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param8##Anaesthesia Type" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param9" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Speciality" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
    <input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param4#param3#param8#param9#param6#param5#param7#p_surgery_type#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">


</form>
</body>

</html>

