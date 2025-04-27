<!DOCTYPE html>
<!-- Added against AMRI-CRF-0294-->
<%@ page contentType="text/html;charset=UTF-8" %>     
<% 
	String locale = (String)session.getAttribute("LOCALE");
	locale=locale.toLowerCase();
%>
<% request.setCharacterEncoding("UTF-8");%>
<%@ include file="../../eOT/jsp/StringUtil.jsp" %>
<%@ page import ="java.sql.Connection,java.sql.PreparedStatement,java.sql.ResultSet,webbeans.eCommon.ConnectionManager,eOT.*,eOT.Common.*" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language="JavaScript" src="../../eCommon/js/common.js"></script>
<script language="Javascript" src="../../eCommon/js/DateUtils.js"></script>

<%
	String procedure_title =com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Procedure.label","common_labels");
	String operationRoom_title = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.OperationRoom.Label","ot_labels");
	String facility_id = (String)session.getValue("facility_id");
	String user_id = (String)session.getValue("login_user");
	String fromsurgerydate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.FromSurgeryDate.Label","ot_labels");
	String tosurgerydate= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eOT.ToSurgeryDate.Label","ot_labels");
	String surgerytype= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.SurgeryType.label","common_labels");
	String surgeon_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Surgeon.label","common_labels");
	String speciality_title= com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.speciality.label","common_labels");
	String surgery_date = "";
	String PatIDLen="";
	String strPatientName="";
	String strPatientId = checkForNull(request.getParameter("p_patient_id"));
	if(facility_id == null) facility_id="";
	String sql_surgery_type = "SELECT NATURE_CODE, SHORT_DESC FROM OT_NATURE_OF_SURGERY_LANG_VW WHERE LANGUAGE_ID='"+locale+"'  ORDER BY 2";
	Connection con = null;
	PreparedStatement pstmt = null;
	ResultSet rst = null;
	PreparedStatement pstmt1 = null;
	ResultSet rst1 = null;
	try{
		con = ConnectionManager.getConnection(request);
		pstmt = con.prepareStatement(OTRepository.getOTKeyValue("SQL_OT_SYSDATE_SELECT1")) ;
		rst = pstmt.executeQuery();
		while(rst.next()){
			surgery_date =com.ehis.util.DateUtils.convertDate(rst.getString("CURRENT_DATE"),"DMY","en",locale);
		}
		pstmt.close();
		rst.close();
		pstmt = con.prepareStatement(sql_surgery_type);
		rst = pstmt.executeQuery();

	try{
		String sqlLen ="SELECT PATIENT_ID_LENGTH FROM MP_PARAM ";
		pstmt1=con.prepareStatement(sqlLen);
		rst1=pstmt1.executeQuery();
		while(rst1.next() && rst1!=null)
		{
			PatIDLen   = (rst1.getString("PATIENT_ID_LENGTH")==null)?"0":rst1.getString("PATIENT_ID_LENGTH");
		}
		if(rst1!=null) rst1.close();
		if(pstmt1!=null) pstmt1.close();
		}catch(Exception  ee)
		{
			ee.printStackTrace();
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
	<script language="JavaScript" src="../../eOT/js/OTReportsLkupSQL.js" ></script>
	<link rel="stylesheet" type="text/css" href="../../eCommon/html/CommonCalendar.css" />
	<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
	<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>
<form name='OtReportOptionsForm' id='OtReportOptionsForm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table border='0' cellpadding='3' cellspacing='0' width='100%' align="centre" > 

<tr>
	<td class='label' width='25%'>
		<fmt:message key="eOT.FromSurgeryDate.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type='text' name='P_FROM_DATE' id='P_FROM_DATE' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('P_FROM_DATE');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>
	<td class='label' width='25%'>
		<fmt:message key="eOT.ToSurgeryDate.Label" bundle="${ot_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type='text' name='P_TO_DATE' id='P_TO_DATE' size='8'  value='<%=surgery_date%>' onkeypress="return checkForSpecCharsforID(event);" onBlur="isValidDate(this);" maxlength='10'>  
		<img src='../../eCommon/images/CommonCalendar.gif'onClick="return showCalendar('P_TO_DATE');">
		<img src='../../eCommon/images/mandatory.gif'></img>
	</td>	 
</tr>

<tr> 
<td  class='label'  width="25%">
	<fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
	<td align='left'>
		<input type='text' name='p_patient_id' id='p_patient_id' maxlength='<%=PatIDLen%>' size='<%=PatIDLen%>' value= "<%=strPatientId%>" onBlur="if(this.value!='')callPatientSearch();else clearDesc();" onkeypress="return CheckForSpecChars(event)">
		<input type='button' class='button' value='?' name='surButton' id='surButton' onClick="callPatientSearch();" maxlength='70'>
	</td>

	<td  class='label'  width="25%">
		<fmt:message key="Common.PatientName.label" bundle="${common_labels}"/>
	</td>
	<td align='left'>
		<input type='text' name='patientname' id='patientname' maxlength='60' size='30' value= "<%=strPatientName%>" readonly>
	</td>
		<td class='label' width='25%' ></td>
</tr>

<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.Procedure.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type='hidden' name='p_oper_code' id='p_oper_code' value=""> 
		<input type='hidden' name="param11" id="param11" value=""> 
		<input type='text' name='param11_desc' id='param11_desc' size='20'  title='<%=procedure_title%>' param1 = 'param11'  param2 = 'p_oper_code' key ='PROCEDURE' onBlur="if(this.value!='')callCommonLookup(this); else param11.value='',p_oper_code.value='' " > 
		<input type='button' class='button' value='?' name='OperCodeLookUp' id='OperCodeLookUp' onClick="callCommonLookup(param11_desc);" >
	</td>

	<td class='label' width='25%'>
		<fmt:message key="Common.speciality.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<input type='hidden' name='p_specialty_code' id='p_specialty_code'> 
		<input type='hidden' name='param5' id='param5'> 
		<input type='text' name='param5_desc' id='param5_desc' size='20' title='<%=speciality_title%>' param1 = 'param5'  param2 = 'p_specialty_code' key ='SPECIALITY' onBlur="if(this.value!='')callCommonLookup(this); else param5.value='',p_specialty_code.value='' " > 
		<input type='button' class='button' value='?' name='SpecialityLookUp' id='SpecialityLookUp' onClick="callCommonLookup(param5_desc);" >
	</td>
</tr>

<tr>
	<td class='label' width='25%'>
		<fmt:message key="Common.OperatingRoom.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
		<input type='hidden' name='p_oper_room_code' id='p_oper_room_code'> 
		<input type='hidden' name='p3' id='p3'> 
		<input type='text' name='from_oper_room_desc' id='from_oper_room_desc' size='20' title='<%=operationRoom_title%>' param1 = 'p3'  param2 = 'p_oper_room_code' key ='OPER_ROOM' onBlur="if(this.value!='')callCommonLookup(this); else callClearParam(p3,p_oper_room_code); " maxlength='70'> 
		<input type='button' class='button' value='?' name='OperRoomLookUp' id='OperRoomLookUp' onClick="callCommonLookup(from_oper_room_desc);" >
	</td>
	
	<td class='label' width='25%'>
		<fmt:message key="Common.SurgeryType.label" bundle="${common_labels}"/>
	</td>
	<td class='fields' width='25%'>
		<select name="p_surgery_type" id="p_surgery_type" >  
		<option value= "" >
		<fmt:message key="Common.all.label" bundle="${common_labels}"/> 
		</option> 
<% while(rst.next()){ %>
		<option value='<%=rst.getString(1)%>'> <%=rst.getString(2)%> 
		</option>
<%   }//end of while-loop
	}catch(Exception e){
		System.err.println("Err Msg CancelledRegistrationsReports.jsp "+e.getMessage());
	}finally{
		if(rst!=null)rst.close();
		if(pstmt!=null)pstmt.close();
		if(con!=null)
		ConnectionManager.returnConnection(con,request); 
	}
%>
	 </select>
	 </td>	 
</tr>
<tr>
	<td class='label' width='25%'><fmt:message key="Common.Surgeon.label" bundle="${common_labels}"/></td>
    <td class='fields' width='25%'>
		<input type='hidden' name='p_surgeon_code' id='p_surgeon_code'> 
		<input type='hidden' name='param3' id='param3'> 
		<input type='text' name='param3_desc' id='param3_desc' size='20'  maxlength='30' title='<%=surgeon_title%>' param1 = 'param3'  param2 = 'p_surgeon_code' key ='SURGEON' onBlur="if(this.value!='')callCommonLookup(this); else param3.value='',p_surgeon_code.value=''" maxlength='70' onkeypress="return CheckForSpecChars_local(event);"> 
		   <input type='button' class='button' value='?' name='OperTypeLookUp' id='OperTypeLookUp' onClick="callCommonLookup(param3_desc);" >
	</td>
</tr>

	<input type="hidden" name="facility_id" id="facility_id"	value="<%=facility_id%>">
	<!--<input type="hidden" name="p_patient_id" id="p_patient_id"	value="<%=strPatientId%>">-->
	<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=facility_id%>">
	<input type="hidden" name="p_user_id" id="p_user_id"	value="<%=user_id%>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%=user_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"  value="OT">
	<input type="hidden" name="p_report_id" id="p_report_id" value="OTCANEQP"> 
	<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>" >
	<input type="hidden" name="pgm_id" id="pgm_id" value="OTCANEQP">
	<input type="hidden" name="user_id" id="user_id"	value="<%=user_id%>">
	<input type="hidden" name="sql_text" id="sql_text" value="<%=sql_surgery_type%>" disabled>
	<input type="hidden" name="no_of_mandatory_fields" id="no_of_mandatory_fields" value="2" disabled>
	<input type="hidden" name="mandatory_fm_1" id="mandatory_fm_1" value="P_FROM_DATE##<%=fromsurgerydate%>" disabled>
    <input type="hidden" name="mandatory_fm_2" id="mandatory_fm_2" value="P_TO_DATE##<%=tosurgerydate%>" disabled>

	<input type="hidden" name="no_of_compare_date_fields" id="no_of_compare_date_fields" value="1" disabled>
	<input type="hidden" name="compare_date_fm_1" id="compare_date_fm_1" value="P_FROM_DATE##Surgery Date" disabled>
    <input type="hidden" name="compare_date_to_1" id="compare_date_to_1" value="P_TO_DATE" disabled>

	<input type="hidden" name="compare_fm_3" id="compare_fm_3" value="param11##Procedure" disabled>
    <input type="hidden" name="compare_to_3" id="compare_to_3" value="p_oper_code" disabled>

	<input type="hidden" name="no_of_comparison_fields" id="no_of_comparison_fields" value="1" disabled>
	<input type="hidden" name="compare_fm_1" id="compare_fm_1" value="p3##Operation Room" disabled>
    <input type="hidden" name="compare_to_1" id="compare_to_1" value="p_oper_room_code" disabled>

	<input type="hidden" name="compare_fm_2" id="compare_fm_2" value="param5##Speciality" disabled>
    <input type="hidden" name="compare_to_2" id="compare_to_2" value="p_specialty_code" disabled>
	<input type='hidden' name='locale' id='locale' value="<%=locale%>">
</form>
</body>
</html>

