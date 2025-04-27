<!DOCTYPE html>
<%--
Copyright 1999-2015, Computer Sciences Corporation. All rights reserved.
 
Warning: This computer program is protected by copyright law and international treaties.
Unauthorized reproduction or distribution of this program, or any portion of it, 
may result in severe civil and criminal penalties, and will be prosecuted to 
the maximum extent possible under the law.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>                                   
<% request.setCharacterEncoding("UTF-8");%>
<%@ page import= "eOT.*, eOT.Common.*,eCommon.Common.*,java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>
<%


	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
    String locale = (String)session.getAttribute("LOCALE");


	String operationRoom_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String speciality_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgeon_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String fromadmissiondate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromAdmissionDate.Label","ot_labels");
	String toadmissiondate = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToAdmissionDate.Label","ot_labels");
	String patientstatus = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.PatientStatus.label","common_labels");
	//Variable Used.....
	String surgery_date ="";


	
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
	<link rel="StyleSheet" href="../../eCommon/html/<%=sStyle%>" type="text/css"/>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script src="../../eCommon/js/CommonLookup.js"></script>
	<script src="../../eOT/js/OtReports.js" ></script>
	<script src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<!-- <form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame"> -->
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eOT/jsp/OTReportsIntermediate.jsp" target="messageFrame">
<table border='0' cellpadding=3  cellspacing='0' width='100%'>

<tr> 
	  <td class='label' width='25%'><fmt:message key="eOT.FromAdmissionDate.Label" bundle="${ot_labels}"/> </td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param1_disp' id='param1_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);"> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param1_disp');"><img src='../../eCommon/images/mandatory.gif'></img>
		  <!-- Added against IN057882 -->
		  <input type='hidden' name='param1' id='param1' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	 </td>
		
	  <td class='label' width='25%'><fmt:message key="eOT.ToAdmissionDate.Label" bundle="${ot_labels}"/></td>
	  <td class='fields' width='25%'>
		  <input type='text' name='param2_disp' id='param2_disp' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);"> 
		  <img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('param2_disp');"><img src='../../eCommon/images/mandatory.gif'></img>
		  <!-- Added against IN057882 -->
		  <input type='hidden' name='param2' id='param2' value='<%=DateUtils.convertDate(surgery_date,"DMY",locale,"en")%>'>
	 </td>
</tr>
<tr>
	  <td class='label' width='25%'><fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/></td>
     <td class='fields' width='25%'>
	    <input type='hidden' name='param4' id='param4' value=''>
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20'  title='<%=operationRoom_title%>' param1 = 'param3'  param2 = 'param4' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',param4.value='' " > 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
		 
	
<!-- 	<td class='label' align='right'nowrap>To Operation Room</td>
     <td align='left'>
		<input type='hidden' name='param4' id='param4'> 
		<input type='text' name='param4_desc' id='param4_desc' size='15' > 
		<input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="srchCommonCode(param4,param4_desc,'To Operation Room', document.forms[0].sql_text_1.value);" >
	</td>  --> 

	<td class='label' width='25%'> <fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/> </td>
     <td class='fields' width='25%'>
	    <input type='hidden' name='param10' id='param10' value=''>
		<input type='hidden' name='param9' id='param9' value=''> 
		<input type='text' name='param9_desc' id='param9_desc' size='20' title='<%=surgeon_title%>' param1 = 'param9'  param2 = 'param10' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param9.value='',param10.value='' " > 
		 <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="callCommonLookup(param9_desc);" >
	</td>
	 
<!-- 	<td class='label' align='right' nowrap>To Surgeon </td>
	 <td align='left'>
		 <input type='hidden' name='param10' id='param10'> 
		<input type='text' name='param10_desc' id='param10_desc' size='15' > 
		 <input type='button' class='button' value='?' name='SurgeonLookUp' id='SurgeonLookUp' onClick="searchCode(param10,param10_desc, 'To Surgeon', document.forms[0].sql_text_3.value);" >
	 </td>
 -->	 
</tr>


<tr>
	<td class='label' width='25%'><fmt:message key="Common.speciality.label" bundle="${common_labels}"/> </td>
      <td class='fields' width='25%'>
		<input type='hidden' name='param8' id='param8'> 
		<input type='hidden' name='param7' id='param7'> 
		<input type='text' name='param7_desc' id='param7_desc' size='20' title='<%=speciality_title%>' param1 = 'param7'  param2 = 'param8' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param7.value='',param8.value='' " > 
		 <input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param7_desc);" >
	</td>
		

<!-- 	<td class='label' align='right' nowrap>To Speciality </td>
	 <td align='left'>
		 <input type='hidden' name='param8' id='param8'> 
		<input type='text' name='param8_desc' id='param8_desc' size='15' > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="searchCode(param8,param8_desc, 'To Speciality', document.forms[0].sql_text_2.value);" >
	 </td> -->
	 <td class='label' width='25%'><fmt:message key="Common.PatientStatus.label" bundle="${common_labels}"/> </td>
	   <td class='fields' width='25%'>
		  <select name="param11" id="param11" >  
		  <option value="A" ><fmt:message key="Common.all.label" bundle="${common_labels}"/> </option>
		  <option value="Y" ><fmt:message key="Common.Admitted.label" bundle="${common_labels}"/> </option>
		  <option value="N" ><fmt:message key="eOT.NotAdmitted.Label" bundle="${ot_labels}"/> </option>
		  </select>
	  	  <img src='../../eCommon/images/mandatory.gif'></img>
	 </td>
	 
</tr>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTRADMIT">
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTRADMIT">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >

	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="param1##<%=fromadmissiondate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="param2##<%=toadmissiondate%>" disabled>
	<input type="hidden" name="mandatory_fm_3" id="mandatory_fm_3" value="param11##<%=patientstatus%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="param1##Booking Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="param2" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="2" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="param3##Procedure" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="param4" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param7##Speciality" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="param8" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
    <input type='hidden' name='reportParams' id='reportParams' value="param1#param2#param3#param4#param9#param10#param7#param8#param11#p_facility_id#p_user_id#p_user_name#p_module_id#p_report_id#pgm_id#user_id#p_language_id">

</form>
</body>

</html>

