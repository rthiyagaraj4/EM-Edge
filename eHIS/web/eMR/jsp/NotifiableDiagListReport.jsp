<!DOCTYPE html>
<!--
CRF/SCF Reference No 	:  ML-MMOH-CRF-2030
Detected Release  No  	:  SEPTEMBER 2023 Release 
File prepared by      	:  Lakshmanan P
File prepared date    	:  1-07-2023
Purpose of the Script   :  Query Criteria to get Notifiable diagnosis which is recorded in record diagnosis function using e-notifikasi interface   
Script Applicable for   :  Beta/Production/Both(Beta and Production)  - Applicable to All ML Sites	
-->

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>


<html>
<head>
 <%String sStyle	=
    (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></Script>
	<script src="../../eCommon/js/ValidateControl.js"></script>
	<script src="../../eCommon/js/common.js"></script>
	<script src='../js/MRReports.js' language='javascript'></script>
	<script src="../../eCommon/js/DateUtils.js"></script>
	<script src='../../eCommon/js/CommonLookup.js' language='javascript'></script>
	<script language='javascript' src="../js/PatientBHT.js"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</HEAD>
	<%
 
	request.setCharacterEncoding("UTF-8"); 
	String p_module_id		= "MR" ;
	String p_report_id		= "MRNODIAG";
	String p_facility_id	= (String) session.getValue( "facility_id" ) ;
	String p_user_name		= (String) session.getValue( "login_user" ) ;
	String locale = (String)session.getAttribute("LOCALE");
	Connection con =null;
	ResultSet rs   = null;
	ResultSet rs1   = null;
	Statement stmt = null;
	PreparedStatement pstmt	= null;
	String currentDate="";
	String pat_length="";	 
	try {
        con  =  ConnectionManager.getConnection(request);
		stmt=con.createStatement();
		rs=stmt.executeQuery("select patient_id_length,  to_char(sysdate,'dd/mm/yyyy') from mp_param");
		if (rs!=null&&rs.next()) {
			pat_length = checkForNull(rs.getString(1));
			currentDate= checkForNull(rs.getString(2));
		}
			if(stmt!=null) stmt.close();
			if(rs!=null) rs.close();
		} 	
	catch(Exception e) 
		{  
		e.printStackTrace();
		}
	finally
		{
		ConnectionManager.returnConnection(con,request);
		}
	%>
<body  OnMouseDown="CodeArrest()" onLoad="FocusFirstElement()"  onKeyDown = 'lockKey()'>
<br>
<br>
<form name="NotifiableDiagListReport" id="NotifiableDiagListReport" action="../../eCommon/jsp/report_options.jsp" target="messageFrame">
<table width='80%' align='center' valign='top' border='0'>
		<th align='left'> <fmt:message key="Common.reportcritera.label" bundle="${common_labels}"/>
		</th>
		<tr>
		<td width="100%" class="Border" align='center'>
			<table width='80%' cellPadding="0" cellSpacing="0"  align='center' border="0" >
				<tr>
					<td align="center" width="30%">&nbsp;</td>
					<td class="label" width="20%"><fmt:message key="Common.from.label" bundle="${common_labels}"/></td>
					<td width="30%" >&nbsp;</td>
					<td class="label" width="20%"><fmt:message key="Common.to.label" bundle="${common_labels}"/></td>
				</tr>	
				</tr>								
				<tr>
						<td align='right' class="label"><fmt:message key="Common.DateRange.label" bundle="${common_labels}"/> &nbsp;</td>
						<td>
							<input type=text id="P_FM_DATE"  name='P_FM_DATE' id='P_FM_DATE' size="10" maxlength="10" align="center" onBlur="if(validDateObj(this,'DMY','<%=locale%>'))validateFromDate_MR(this);"><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_FM_DATE');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
						<td>&nbsp;</td>
						<td > 
							<input type=text id="P_TO_DATE"  name='P_TO_DATE' id='P_TO_DATE' size="10" maxlength="10" align="center"  onBlur="if(validDateObj(this,'DMY','<%=locale%>'))validateToDate_MR(this);" ><img  src='../../eCommon/images/CommonCalendar.gif' onClick="return showCalendar('P_TO_DATE');"/>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
						</td>
				</tr>
				<tr> <td colspan='4'> &nbsp; </td>
				</tr>
				<tr>
					<td width="22%" class="label" ><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
		<td class="fields">
		 
				<select name="p_enc_type" id="p_enc_type" id="p_enc_type" onChange="getLocationType(this);">
				<option value = ''>---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
				<%
				try {
				con  =  ConnectionManager.getConnection(request);
				pstmt = con.prepareStatement("select PATIENT_CLASS, short_desc from AM_PATIENT_CLASS_LANG_VW WHERE PATIENT_CLASS in ('EM','DC','OP','IP') and language_id='"+locale+"' order by 1");
				rs1	=pstmt.executeQuery();
				if(rs1 != null) {									
					while (rs1.next()) {	
				%>
						<option value='<%=rs1.getString("PATIENT_CLASS")%>'><%=rs1.getString("short_desc")%></option>
				<%	}
				}
				if(rs1!=null) rs1.close();		
				if(pstmt!=null) pstmt.close();						
				}
				catch(Exception e)
					{
						e.printStackTrace();	
					}				
			%>
		</select></td>
				</tr>
				<tr> <td colspan='4'> &nbsp; </td>
				</tr>
				<tr>
					<td class="label" width='25%'><fmt:message key="Common.locationtype.label" bundle="${common_labels}" /></td>
	<td class="fields">
		<select name='locationType' id='locationType'  tabindex=1>
			<option style='align: center' value="" >------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}" />------						
	</select>
	</td>
					<td class="label"><fmt:message key="Common.patientId.label" bundle="${common_labels}"/></td>
					<td class='fields'>
						<input type=text  name='p_patient_id' id='p_patient_id' size=<%=pat_length%> maxlength=<%=pat_length%> onBlur="ChangeUpperCase(this);disbutt(this)" align="center"><input type='button' name='patient_id' id='patient_id' value='?' class='button' onclick='callSearchScreen_MR()'>
					</td>
				</tr>						
				</table>	
	</td>
</tr>
</table>
		
	<input type="hidden" name="P_facility_id" id="P_facility_id" value="<%=p_facility_id%>">
	<input type="hidden" name="p_module_id" id="p_module_id"	value="<%= p_module_id %>">
	<input type="hidden" name="p_report_id" id="p_report_id"	value="<%= p_report_id %>">
	<input type="hidden" name="p_user_name" id="p_user_name"	value="<%= p_user_name %>">	
	<input type="hidden" name="language" id="language" value="<%=locale%>">
	<input type="hidden" name="CurrentDate" id="CurrentDate" value="<%=currentDate%>">


</form>
</BODY>
</HTML>


<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

