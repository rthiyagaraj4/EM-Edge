<!DOCTYPE html>
<%
/*
----------------------------------------------------------------------------------------------------------------------------------------------------------
Date       Edit History      Name        	Rev.Date		Rev.Name		Description
----------------------------------------------------------------------------------------------------------------------------------------------------------
20/03/2019   IN067724        Ramya Maddena   20/03/2019       Ramesh G		ML-BRU-CRF-0518
--------------------------------------------------------------------------------------------------------------------
*/
%>
<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	request.setCharacterEncoding("UTF-8");
	String p_facility_id = (String)session.getValue("facility_id");
	String p_login_user  = (String)session.getValue("login_user");
	if(p_facility_id == null)p_facility_id="";
	if(p_login_user == null)p_login_user="";
	java.util.Properties p = (java.util.Properties) session.getValue( "jdbc" ) ;


	String locale = (String) p.getProperty("LOCALE");
	//out.println("<scrip>alert('"+locale+"')</script>");
%>
<html>
<head><title></title>
<%

String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

String loginUser	= (String)session.getValue("login_user");
if(loginUser!="" || loginUser!=null)
{
loginUser=(String)session.getValue("login_user");
}
String currDate = com.ehis.util.DateUtils.getCurrentDate("DMY",locale);
Connection con 					= null;
PreparedStatement 		pstmt	= null;
ResultSet reslt			        = null; 	
String sql= "";
try {
	con	= ConnectionManager.getConnection(); 
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
<script src="../../eCommon/js/CommonLookup.js"></script>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCA/js/PatChartAccessAuditTrailReport.js" language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script type="text/javascript" src="../../eCommon/js/CommonCalendar.js"></script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>
<body class='CONTENT' OnMouseDown='CodeArrest()'  onKeyDown = 'lockKey()'>
<form name='patAudittrailFrm' id='patAudittrailFrm' action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<br><br><br><br>
<table align='center' cellpadding='3' cellspacing='0' width='90%' border='0' >
	<tr>
		<th class="columnheader"  colspan='4' align="left">
			<fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
	</tr>
	<tr>
    <td class='label' width='10%'><fmt:message key="eCA.RestrictTo.label" bundle="${ca_labels}"/></td>
    <td class='fields' width='20%'>
		<!--<select name='p_facility_id' id='p_facility_id'>	--><!--IN067724-->
		<select name='facility_id' id='facility_id'>	
		<!-- <option value="">&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option> -->
		
		<option value='ALL' selected>-----<fmt:message key="Common.all.label" bundle="${common_labels}"/>-----</option> <!--IN067724-->
		<%
			//Query is modified by Channaveer B to fix 21082 on 30/04/2010
			/*sql="SELECT b.facility_id, SM_GET_DESC.SM_FACILITY_PARAM(b.facility_id,?,1) facility_name"+      
			"  FROM sm_facility_for_user a, sm_facility_param b "+
			" WHERE a.facility_id = b.facility_id "+
			"   AND a.appl_user_id = ? ;*/
			sql="SELECT b.facility_id, SM_GET_DESC.SM_FACILITY_PARAM(b.facility_id,?,1) facility_name"+      
			"  FROM sm_facility_for_user a, sm_facility_param b "+
			" WHERE a.facility_id = b.facility_id "+
			"   AND a.appl_user_id = ? order by facility_name asc";//	IN067724				
			pstmt=con.prepareStatement(sql);
			pstmt.setString(1,locale);
			pstmt.setString(2,loginUser);			
			reslt=pstmt.executeQuery();
			while(reslt.next())
			{			
			%>
				<!--<option value='<%=reslt.getString(1)%>' <%if(p_facility_id.equals(reslt.getString(1))){%>selected<%}%>><%=reslt.getString(2)%></option>-->
				<option value='<%=reslt.getString(1)%>' ><%=reslt.getString(2)%></option><!--IN067724-->
			<%
			}
			if(reslt != null)reslt.close();
			if(pstmt != null)pstmt.close();
			%>
		</select>
	</td>
</tr>
<tr>
    <td class='label' width='10%'>
		<fmt:message key="eCA.AuditTrailBy.label" bundle="${ca_labels}"/>
	</td>
    <td class='fields' width='25%'>
		<select name='st_auditTrial' id='st_auditTrial' onchange="fnChangeCriteria(this.value);">	
			<option value="PAT" selected><fmt:message key="Common.patient.label" bundle="${common_labels}"/></option>
			<option value="PRAC"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>	
			<option value="SPL"><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></option>	
		</select>
	</td>
</tr>
<tr id="patid_row">
	<td class='label' width='10%'>
		<fmt:message key="Common.patientId.label" bundle="${common_labels}"/>
	</td>
	<td>
		<input type='text' name='p_patient_id' id='p_patient_id' readonly value=""/><input type='button' value='?' name='btnPracLookup' id='btnPracLookup' onclick='callPatientSearch();'><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>
<tr id="Pract_row" align="left" style="display:none">
	<td class='label' width='10%' >
		<fmt:message key="Common.practitioner.label" bundle="${common_labels}"/>
	</td>
	<td>
		<input type='text' name='Practitioner_Name' id='Practitioner_Name' maxlength="30" onblur="fnGetPractitionerId(this);" value=""/><input type='hidden' name='p_practitioner_id' id='p_practitioner_id' value=""/><input type='button' value='?' name='btnPracLookup' id='btnPracLookup' onclick='fnGetPractitionerId();'><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr>

<tr id="Splty_row" style="display:none">
    <td class='label'  width='10%' ><fmt:message key="Common.Specialty.label" bundle="${common_labels}"/></td>
    <td class='fields' width='20%'>
		<input type='text' name='speciality_name' id='speciality_name' onblur="getSpeciality(this);" maxlength="15" value=""/><input type='hidden' name='p_specialty_code' id='p_specialty_code' value=""/><input type='button' value='?' name='btnSpltyLookup' id='btnSpltyLookup' onclick='getSpeciality();'><img id="splty_man_img" src='../../eCommon/images/mandatory.gif' style="display:none">
	</td>
    <td class='label'  width='10%' >
		<fmt:message key="Common.relationship.label" bundle="${common_labels}"/>
	</td>
    <td class='fields' width='25%'>
		<input type='text' name='relationship_name' id='relationship_name' maxlength="30" onblur="getRelationship(this);"  value=""/><input type='hidden' name='p_pract_reln_id' id='p_pract_reln_id' value=""/><input type='button' value='?' name='btnSpltyLookup' id='btnSpltyLookup' onclick='getRelationship();'>
	</td>
</tr>
<!--<tr><td colspan='4'>&nbsp;</td></tr>-->
<tr id="PatClass_row" style="display:none">
	<td width='10%'  class='label'>
		<fmt:message key="Common.patientclass.label" bundle="${common_labels}"/>
	</td>
	<td>
		<select name='p_patient_class' id='p_patient_class' onchange="fnClearLocation(this)">	
		<option value="">&nbsp;&nbsp;-----<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----&nbsp;&nbsp;</option>
		<%
			sql="select patient_class, short_desc  from  am_patient_class_lang_vw where language_id=?  order by 2";						
			pstmt=con.prepareStatement(sql);			
			pstmt.setString(1,locale);
			reslt=pstmt.executeQuery();
			while(reslt.next())
			{			
			%>
				<option value='<%=reslt.getString("patient_class")%>'><%=reslt.getString("short_desc")%></option>
			<%
			}
			if(reslt != null)reslt.close();
			if(pstmt != null)pstmt.close();
			%>
		</select>
	</td>
	
	<td width='10%'  class='label'><fmt:message key="Common.Location.label" bundle="${common_labels}"/></td>
	<td class='fields' width='25%'>
		<input type='text' name='Location_Name' id='Location_Name' maxlength="30" onblur="getLocation(this);"  value=""/><input type='hidden' name='p_locn_code' id='p_locn_code' value=""/><input type='button' value='?' name='btnLocLookup' id='btnLocLookup' onclick='getLocation();'>
	</td>
	
</tr>
<tr>
	<td  colspan=1 class="label">
		<fmt:message key="Common.DateRange.label" bundle="${common_labels}"/> :
	</td>
	<td colspan=2 >
		<input type="textbox" size="11" maxlength="10" name="p_start_date_time" id="p_start_date_time" value="<%=currDate%>" onblur='Check_Date(this,"DMY","<%=locale%>");'><img valign="middle" src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_start_date_time');" ><img src='../../eCommon/images/mandatory.gif'>&nbsp;-&nbsp;<input type="textbox" size="11" maxlength="10" name="p_end_date_time" id="p_end_date_time" value="<%=currDate%>" onblur='return checkingDate(this,"DMY","<%=locale%>")'><img valign="middle" src="../../eCommon/images/CommonCalendar.gif" onclick="return showCalendarValidate('p_end_date_time');" ><img src='../../eCommon/images/mandatory.gif'>
	</td>
</tr> 
</table>


<input type="hidden" name="p_language_id" id="p_language_id"	value="<%=locale%>">
<input type="hidden" name="p_user_name" id="p_user_name"		value="<%=p_login_user%>">
<input type="hidden" name="p_module_id" id="p_module_id" 	value="CA">
<input type="hidden" name="p_report_id" id="p_report_id" 	value="">
<input type="hidden" name="report" id="report" 	value="">
<input type="hidden" name="p_facility_id" id="p_facility_id"	value="<%=p_facility_id%>"><!--IN067724-->

</form>
</body>
<%}catch(Exception e){
	//out.println("Exception  :  "+e.getMessage());//common-icn-0181
	e.printStackTrace();//COMMON-ICN-0181
}finally{
	try{
		if(con != null)con.close();	
	}catch(Exception ee){
		//out.println("Exception in Finally block :  "+ee.getMessage());//COMMON-ICN-0181
		 ee.printStackTrace();//COMMON-ICN-0181
	}
}%>
</html>

