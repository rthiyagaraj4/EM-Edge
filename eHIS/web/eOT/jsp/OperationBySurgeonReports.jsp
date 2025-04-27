<!DOCTYPE html>
<%@ page  import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ page contentType="text/html;charset=UTF-8"%>
<% String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
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
	   frmObj.p_report_id.value='OTROPRSC';
	   frmObj.pgm_id.value='OTROPRSC';
	}
else  if(obj.value=='D')
	{
	   frmObj.p_report_id.value='OTROPRSD';
	   frmObj.pgm_id.value='OTROPRSD';
	}
}
</script>
						 

<%
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String position_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Position.label","common_labels");
	String roleType_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.RoleType.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");

	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String  sql_role_type = "SELECT A.ROLE_TYPE CODE, A.ROLE_TYPE_DESC DESCRIPTION FROM OT_ROLE_TYPE_LANG_VW A  WHERE ROLE_TYPE IN ('OS', 'AS') AND UPPER(A.ROLE_TYPE_DESC) LIKE UPPER(?) AND UPPER(A.ROLE_TYPE) LIKE UPPER(?) AND A.LANGUAGE_ID='"+locale+"' ORDER BY 2";

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
<head><title></title>
<%
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'/>	<script src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<tr> 
	  <td class='label' width='25%'>
		<fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/>
	  </td>
	  <td class='fields' width='25%'>
	  <!-- Added against 57893 Starts -->
		  <input type='text' name='param1_disp' id='param1_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	 </td>
		
	  <td class='label' width='25%'>
		<fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param2_disp' id='param2_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2_disp');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='param2' id='param2' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
 	  <!-- Added against 57893 Ends -->
	 </td>
	
</tr>

<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
	    <input type='hidden' name='param11' id='param11'>
		<input type='hidden' name='param10' id='param10'> 
		<input type='text' name='param10_desc' id='param10_desc' size='20' title='<%=surgeon_title%>' param1 = 'param10'  param2 = 'param11' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param10.value='',param11.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param10_desc);" >
	</td>
	<!--<td class='label' align='right' nowrap>To Surgeon &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param11' id='param11'> 
		<input type='text' name='param11_desc' id='param11_desc' size='20' > 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchCode(param11,param11_desc, 'To Surgeon', document.forms[0].sql_text_3.value);" >-->

	 </td>

	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param6' id='param6'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=speciality_title%>' param1 = 'param5'  param2 = 'param6' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
    
<!-- 	<td class='label' align='right' nowrap>To Speciality &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param6_desc' id='param6_desc' size='20' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param6,param6_desc, 'To Speciality', document.forms[0].sql_text_2.value);" >
	 </td> -->
</tr>

<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.Position.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
	    <input type='hidden' name='param4' id='param4'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=position_title%>' param1 = 'param3'  param2 = 'param4' key ='POSITION' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='PositionLookUp' id='PositionLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
   
<!-- 	<td class='label' align='right' nowrap>To Position &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param4_desc' id='param4_desc' size='20' > 
		<input type='button' class='button' value='?' name='PositionLookUp' id='PositionLookUp' onClick="searchCode(param4,param4_desc, 'To Position', document.forms[0].sql_text_1.value);" >
	 </td> -->

	<td class='label' width='25%'>
		<fmt:message key="Common.RoleType.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' onBlur="if(this.value!='')searchCode(param7,param7_desc,'<%=roleType_title%>',document.forms[0].sql_text_4.value);else param7.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='RoleTypeLookUp' id='RoleTypeLookUp' onClick="searchCode(param7,param7_desc,'<%=roleType_title%>',document.forms[0].sql_text_4.value);" >
	</td>
    
</tr>

<tr> 
	  <td class='label' width='25%'>
		<fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>
		</td>
	  <td class='fields' width='25%'>
		  <select name="param8" id="param8"  OnChange="changeReportId(this)">  
		  <option value="D" >
		  <fmt:message key="Common.ByDate.label" bundle="${common_labels}"/> </option>
		  <option value="C" >
		  <fmt:message key="eOT.Cumulative.Label" bundle="${ot_labels}"/> </option>
		  </select>
 	  	  <img src='../../eCommon/images/mandatory.gif'></img>   
	  </td>
	 <td colspan='2'></td>
</tr>


	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTROPRSD">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTROPRSD">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_4" id="sql_text_4" value="<%=sql_role_type%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Procedure" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Speciality" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param6" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param11#param10#param5#param6#param4#param3#param7#param8#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>
</body>
</html>

