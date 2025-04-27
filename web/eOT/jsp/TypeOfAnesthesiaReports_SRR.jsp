<!DOCTYPE html>

<%@ page import= "java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*,java.net.URLEncoder" %>
<%@ page contentType="text/html;charset=UTF-8"%>              
<% String locale = (String)session.getAttribute("LOCALE");
locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript'>
function changeReportId(obj)
{
 var frmObj=document.forms[0];
 if(obj.value=='C')
	{ 
	   frmObj.p_report_id.value='ATRTYANC';
	   frmObj.pgm_id.value='ATRTYANC';
	}
else  if(obj.value=='D')
	{
	   frmObj.p_report_id.value='ATRTYAND';
	   frmObj.pgm_id.value='ATRTYAND';
	}

}
</script>
						 

<%
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String anaesthetist_title=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Anaesthetist.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String fromoperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromOperationDate.Label","ot_labels");
	String tooperationdate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToOperationDate.Label","ot_labels");
//	String allAnaesthesia= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.Allanaesthesia.Label","ot_labels");
//	allAnaesthesia=java.net.URLEncoder.encode(allAnaesthesia,"UTF-8");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String surgery_date = "";
	if(facility_id == null) facility_id="";
	String  sql_speciality = "SELECT A.SPECIALITY_CODE CODE, B.SHORT_DESC DESCRIPTION FROM OT_SPECIALITIES A,  AM_SPECIALITY B WHERE A.SPECIALITY_CODE =  B.SPECIALITY_CODE AND UPPER(B.SHORT_DESC) LIKE UPPER(?) AND UPPER(A.SPECIALITY_CODE) LIKE UPPER(?) ORDER BY 2";
	String  sql_surgeon = "SELECT PHYSICIAN_ID CODE, SHORT_NAME DESCRIPTION FROM SY_PHYSICIAN_MAST WHERE FACILITY_ID = '"+facility_id+"' AND PRACT_TYPE IN ('AN') AND UPPER(SHORT_NAME) LIKE UPPER(?) AND UPPER(PHYSICIAN_ID) LIKE UPPER(?) ORDER BY 2";
	String  sql_anes_type = "SELECT ANAESTHESIA_CODE CODE, SHORT_DESC DESCRIPTION FROM AM_ANAESTHESIA  WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(ANAESTHESIA_CODE) LIKE UPPER(?) ORDER BY 2";
//	String  sql_anes_type = "SELECT '"+allAnaesthesia+"' description1,'ALL' code1 FROM dual  UNION  SELECT  initcap(SHORT_DESC) escription2,ANAESTHESIA_CODE code2 FROM AM_ANAESTHESIA_lang_vw where language_id='"+locale+"' ORDER BY 2";
	String  sql_oper_procedure = "SELECT OPER_CODE CODE, SHORT_DESC DESCRIPTION FROM OT_OPER_MAST WHERE UPPER(SHORT_DESC) LIKE UPPER(?) AND UPPER(OPER_CODE) LIKE UPPER(?) ORDER BY 2";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_lang_vw where language_id = ? ORDER BY 2";
	

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


</head>
<body OnMouseDown="CodeArrest()">
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%' align="centre">
<tr> 
	  <td class='label' width='25%'>
	  <fmt:message key="eOT.FromOperationDate.Label" bundle="${ot_labels}"/>
	  </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='param1' id='param1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
		
	  <td class='label' width='25%'>
	  <fmt:message key="eOT.ToOperationDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param2' id='param2' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2');">
		  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
</tr>

<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width='25%'>
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='hidden' name="param3" id="param3" value=""> 
		<input type='text' name='param3_desc' id='param3_desc' size='20' title='<%=procedure_title%>' param1 = 'param3'  param2 = 'param4' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
<!-- 	<td class='label' align='right'nowrap>To Procedure&nbsp;</td>
     <td align='left'>
		<input type='hidden' name='param4' id='param4' value=""> 
		<input type='text' name='param4_desc' id='param4_desc' size='30' > 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="searchCode(param4,param4_desc, 'To Procedure', document.forms[0].sql_text_1.value );" >
	</td>
 -->
	<td class='label' width='25%'>
		<fmt:message key="Common.Anaesthetist.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
	    <input type='hidden' name='param6' id='param6' value="">
		<input type='hidden' name='param5' id='param5' value=""> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=anaesthetist_title%>' param1 = 'param5'  param2 = 'param6' key ='ANAESTHETIST' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',param6.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
	<!--<td class='label' align='right' nowrap>To Anaesthetist &nbsp;</td>
	 <td align='left'>
		 <input type='hidden' name='param6' id='param6'> 
		<input type='text' name='param6_desc' id='param6_desc' size='15' > 
		<input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchCode(param6,param6_desc, 'To Anaesthetist', document.forms[0].sql_text_3.value);" >

	 </td>-->
	</tr>

<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.AnaesthesiaCode.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
		<input type='hidden' name='param8' id='param8' value=""> 
		<input type='hidden' name='param7' id='param7' value=""> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' onBlur="if(this.value!='')callAnaesthesia(this,param7); else param7.value='',param8.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callAnaesthesia(param7_desc,param7);" >
	</td>
	<!-- <td class='label' align='right'nowrap>To Anaesthesia Code &nbsp;</td>
     <td align='left'>
		<input type='hidden' name='param8' id='param8'> 
		<input type='text' name='param8_desc' id='param8_desc' size='15' > 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="searchCode(param8,param8_desc,'To Anaesthesia', document.forms[0].sql_text_5.value);" >
	</td> -->
	<td class='label' width='25%'>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
     <td class='fields' width='25%'>
	    <input type='hidden' name='param10' id='param10'> 
		<input type='hidden' name='param9' id='param9'> 
		<input type='text' name='param9_desc' id='param9_desc' size='20' title='<%=speciality_title%>' param1 = 'param9'  param2 = 'param10' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param9.value='',param10.value='' " maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param9_desc);" >
	</td>

<tr> 
	  <td class='label' width='25%'>
	  <fmt:message key="Common.reporttype.label" bundle="${common_labels}"/>
	  </td>
	 <td class='fields' width='25%' >
		  <select name="param11" id="param11"  OnChange="changeReportId(this)">  
		  <option value="D" >
		  <fmt:message key="Common.ByDate.label" bundle="${common_labels}"/> </option>
		  <option value="C" >
		  <fmt:message key="eOT.Cumulative.Label" bundle="${ot_labels}"/> </option>
		  </select>
 	  	  <img src='../../eCommon/images/mandatory.gif'></img>   
	  </td>

	<td class='label' align='right' nowrap><fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/> &nbsp;</td>
	<td align='left'>
	 <select name="param12" id="param12" >  
	<option value= "" ><fmt:message key="Common.all.label" bundle="${common_labels}"/></option>
	<% while(rst.next()){ %>
		  <option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> </option>
<%   }//end of while-loop
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
	 </select>
	 &nbsp;
	 </td>
	 <td colspan='2'></td>
</tr>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="ATRTYAND">
	
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="ATRTYAND">
	
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text_1" id="sql_text_1" value="<%=sql_oper_procedure%>" disabled>
	<input type="hidden" name="sql_text_2" id="sql_text_2" value="<%=sql_speciality%>" disabled>
	<input type="hidden" name="sql_text_3" id="sql_text_3" value="<%=sql_surgeon%>" disabled>
	<input type="hidden" name="sql_text_5" id="sql_text_5" value="<%=sql_anes_type%>" disabled>

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromoperationdate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=tooperationdate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Operation Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="4" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Procedure" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param7##Anaesthesia" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param8" disabled>

	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param9##Speciality" disabled>
    <input type="hidden" name="compare_to_3" id="compare_to_3" value="param10" disabled>

	<input type="hidden" name="compare_fm_4" id="compare_fm_4" value="param5##Anaesthetist" disabled>
    <input type="hidden" name="compare_to_4" id="compare_to_4" value="param6" disabled>


	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param3#param4#param5#param6#param7#param8#param9#param10#param11#param12#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">


</form>
</body>
</html>

