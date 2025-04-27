<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8"%>                             
<% request.setCharacterEncoding("UTF-8");%>
<%@ page  import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<script language='javascript'>
function changeReportId(obj)
{
 var frmObj=document.forms[0];
// alert(obj.value);
 if(obj.value=='P')
	{
	   frmObj.p_report_id.value='OTRWTLSP';
	   frmObj.pgm_id.value='OTRWTLSP';
	}
else  if(obj.value=='S')
	{
	   frmObj.p_report_id.value='OTRWTLSU';
	   frmObj.pgm_id.value='OTRWTLSU';
	}
else  if(obj.value=='D')
	{
	   frmObj.p_report_id.value='OTRWTLDT';
	   frmObj.pgm_id.value='OTRWTLDT';
	}

//	alert(frmObj.p_report_id.value+"  and  "+frmObj.pgm_id.value);
}
</script>




<%
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
    String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
	String preferreddatefrom=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PreferredDateFrom.label","common_labels");
	String preferreddateto=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eIP.PreferredDateTo.label","ip_labels");
	String reporttype=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.reporttype.label","common_labels");
	String surgery_date = "";
		
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
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
 -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp"  target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%'>
<%
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
%>
<tr> 
	<td class='label' width='25%'><fmt:message key="Common.PreferredDateFrom.label" bundle="${common_labels}"/> </td>
	  <!--td class='fields' width='25%'>
		  <input type='text' name='p1' id='p1' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('p1');"><img src='../../eCommon/images/mandatory.gif'></img>
	 </td-->
	 <!--057883 starts -->
	 <td class='fields' width='25%'>
		  <input type='text' name='p1_disp' id='p1_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('p1_disp');"><img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='p1' id='p1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	 </td>
		
	<td class='label' width='25%'><fmt:message key="eIP.PreferredDateTo.label" bundle="${ip_labels}"/> </td>
	 <td class='fields' width='25%'>
		  <input type='text' name='p2_disp' id='p2_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);">  
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('p2_disp');"><img src='../../eCommon/images/mandatory.gif'></img>
		  <input type='hidden' name='p2' id='p2' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	 </td>
	 <!--057883 ends-->
</tr>

<tr>
	<td class='label' width='25%'><fmt:message key="Common.Procedure.label" bundle="${common_labels}"/></td>
   <td class='fields' width='25%'>
		<input type='hidden' name='p9' id='p9' value=""> 
		<input type='hidden' name="p8" id="p8" value=""> 
		<input type='text' name='p8_desc' id='p8_desc' size='20' title='<%=procedure_title%>' param1 = 'p8'  param2 = 'p9' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else p8.value='',p9.value=''  " > 
		 <input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(p8_desc);" >
	</td>
	 
		
	<!-- <td class='label' align='right'nowrap>To Procedure</td>
     <td align='left'>
		<input type='hidden' name='p9' id='p9' value=""> 
		<input type='text' name='p9_desc' id='p9_desc' size='30' > 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="searchCode(p9,p9_desc, 'To Procedure', document.forms[0].sql_text.value );" >
	</td> -->
	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
		 <input type='hidden' name='p4' id='p4'> 
		<input type='hidden' name='p3' id='p3'> 
		<input type='text' name='p3_desc' id='p3_desc' size='20' title='<%=speciality_title%>' param1 = 'p3'  param2 = 'p4' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else p3.value='',p4.value='' " > 
		 <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(p3_desc);" >
	</td>
	

	<!-- <td class='label' align='right' nowrap>To Speciality </td>
	 <td align='left'>
		 <input type='hidden' name='p4' id='p4'> 
		<input type='text' name='p4_desc' id='p4_desc' size='15' > 
		 <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(p4,p4_desc, 'To Speciality', document.forms[0].sql_text_2.value);" >
	 </td> -->
</tr>

<tr>
	<td class='label' width='25%'> <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
    <td class='fields' width='25%'>
	    <input type='hidden' name='p6' id='p6' value=''> 
		<input type='hidden' name='p5' id='p5' value=''> 
		<input type='text' name='p5_desc' id='p5_desc' size='20' title='<%=surgeon_title%>' param1 = 'p5'  param2 = 'p6' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else p5.value='',p6.value='' "> 
	    <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(p5_desc);" >
	</td>
	<!--<td class='label' align='right' nowrap>To Surgeon </td>
	 <td align='left'>
		 <input type='hidden' name='p6' id='p6'> 
		<input type='text' name='p6_desc' id='p6_desc' size='15' > 
		 <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchCode(p6,p6_desc, 'To Surgeon', document.forms[0].sql_text_3.value);" >
	 </td>-->
	

	  <td class='label' width='25%'> <fmt:message key="Common.reporttype.label" bundle="${common_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <select name="param15" id="param15"  OnChange="changeReportId(this)">  
		  <option value="D" ><fmt:message key="Common.ByDate.label" bundle="${common_labels}"/> </option>
		  <option value="P" ><fmt:message key="eOT.BySpeciality.Label" bundle="${ot_labels}"/> </option>
		  <option value="S" ><fmt:message key="eOT.BySurgeon.Label" bundle="${ot_labels}"/> </option>
		  </select>
 	  	  <img src='../../eCommon/images/mandatory.gif'></img>   
	  </td>
	 
</tr>



	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">

	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRWTLDT">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRWTLDT">

	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
  	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2">
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="p1##<%=preferreddatefrom%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="p2##<%=preferreddateto%>" disabled>
	<input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="param15##<%=reporttype%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1">
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="p1##Preferred Date">
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="p2">

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2">
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="p8##Procedure">
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="p9">

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="p3##Speciality">
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="p4">
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
	<input type='hidden' name='reportParams' id='reportParams' value="p1#p2#p9#p8#p4#p3#p6#p5#param15#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>

</body>
</html>

