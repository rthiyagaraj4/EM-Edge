<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,org.json.simple.parser.JSONParser,org.json.simple.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eCommon/js/jquery-3.6.3.js"></script> <!-- Added by Sangeetha for GDOH-CRF-0133 -->
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMPractitionerComponent.js'></script>
	<script language='javascript' src='../../eFM/js/FMTransferFile.js'></script>
	<Script language="JavaScript" src ="../../eCommon/js/CommonLookup.js" ></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
	Connection conn			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	String userSecurity 				= "";
	String Dflt_archive_fs_locn_code	= "";
	String Dflt_lost_fs_locn_code		= "";
	String disableyn					= "";
	String accessAll					= "";
	String auto_rec_ward_yn				= "";
	String auto_rec_clinic_yn			= "";
	String auto_rec_pract_yn			= "";
	String auto_rec_dept_yn           ="";
	String user_name					= "";
	String user_name_old="";
	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= (String) session.getValue("login_user");
	//Added by Sangeetha for ML-MMOH-CRF-0345.2 on 17/07/17
	String locale               = (String)session.getAttribute("LOCALE");
	boolean isCurrentFsLocation = false; 
	String patientIdLength	    = "";
	try 
	{
		//Added by Sangeetha for ML-MMOH-CRF-0345.2 on 17/07/17
		isCurrentFsLocation = eCommon.Common.CommonBean.isSiteSpecific(conn,"FM","CURR_FS_LOCATION_SEARCH");
		patientIdLength = eCommon.Common.CommonBean.getPatIdLength(conn);
		patientIdLength = checkForNull(patientIdLength,"0");
%>
<body OnMouseDown="CodeArrest();" onLoad="document.FMTransferFileFrom_form.FS_LOCN_ID.focus();" onKeyDown = 'lockKey();'>
<form name='FMTransferFileFrom_form' id='FMTransferFileFrom_form'>
	<table border='0' cellpadding='3' cellspacing='0' width='100%' align='left'>
	<% //Added by Sangeetha for ML-MMOH-CRF-0345.2 on 17/07/17
	if(isCurrentFsLocation){ %>
		<tr height="60"> 
			<td class=label width="10%">
				<fmt:message key="Common.patientId.label" bundle="${common_labels}"/> 
			</td>
			<td width = '20%' class='fields'>
			<input type='text' maxlength='<%=patientIdLength%>' size='15' name='patient_id' onKeyPress='return(CheckForSpecChars(event))' onBlur='ChangeUpperCase(this);if(validSplchars(this)) validatePatientId(this);fetchCurrFsLocn(this)'><input type="button" class=BUTTON name="patient_search" id="patient_search" value="?" onBlur="fetchCurrFsLocn(patient_id)" onClick="javascript:showLookUp('P')">
			</td>
		</tr>
		<tr><td>&nbsp;</td></tr>
	<%}%>
	<th colspan='2' class='columnheader'><fmt:message key="Common.TransferFrom.label" bundle="${common_labels}"/></th>
	<TR>
		<TD width='30%'  class= 'label'><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></TD>
		<TD width='70%'  class='fields' ><select name="FS_LOCN_ID" id="FS_LOCN_ID" onChange="PopulateFromData(this.value)">
				<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
				<option value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></option> 
			</select>&nbsp;&nbsp;<a href='javascript:GetModeOfTransport();' align=center><fmt:message key="Common.ModeOfTransport.label" bundle="${common_labels}"/></a>
		</TD>
	</TR>
	<TR>
		<TD  class= 'label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
		<TD  class='fields' ><select name='fromfslocn' id='fromfslocn' onChange="setDisabled(this.value);chk_val()">
				<option value=''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img><a href='javascript:GetShowRemarks()' align=center><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></a>
			<input type='hidden' name=p_remarks value=''>
		</TD>
	</TR>
	<tr>
		<td class="LABEL" id="returning"><fmt:message key="Common.TransferFrom.label" bundle="${common_labels}"/></td>
		<td class='fields'><input type="text" name="returning_desc" id="returning_desc" value="" onChange="getValidRecords(this);" onBlur='chk_focus();' disabled><input type="Hidden" name="returning_code" id="returning_code" value="" ><input type="button" name="ret_button" id="ret_button" value="?" class="BUTTON" onClick="getValidRecords(returning_desc);" disabled><img src='../../eCommon/images/mandatory.gif' align='center' id="mandat1"></img></td>
	</tr>
<%
	
			userSecurity				= request.getParameter("userSecurity");
			Dflt_archive_fs_locn_code	= request.getParameter("Dflt_Archive_Locn");
			Dflt_lost_fs_locn_code		= request.getParameter("Dflt_Lost_Locn");
			accessAll					= request.getParameter("accessAll");
			auto_rec_ward_yn			= request.getParameter("auto_rec_ward_yn");
			auto_rec_clinic_yn			= request.getParameter("auto_rec_clinic_yn");
			auto_rec_pract_yn			= request.getParameter("auto_rec_pract_yn");
			auto_rec_dept_yn         = request.getParameter("auto_rec_dept_yn");
			user_name_old=(String)session.getAttribute("user_name");  
			
			if(user_name_old==null || user_name_old.equals("null")) user_name_old="";
			if(user_name_old.equals(""))
		    {
			stmt = conn.createStatement();

		    //rs	 = stmt.executeQuery("select appl_user_name from sm_appl_user where appl_user_id= '"+user_id+"' ");
		 		
			rs	 = stmt.executeQuery("select appl_user_name from sm_appl_user_LANG_VW where appl_user_id= '"+user_id+"' AND LANGUAGE_ID = '"+localeName+"' ");
			while(rs != null && rs.next())
			{
				user_name = rs.getString(1);
			  
			}
			session.setAttribute("user_name",user_name);  
			if(rs != null) rs.close();
			 
			 }else{
     user_name=user_name_old;
		 }
			
			
			if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";
			if(userSecurity.equals("Y")) disableyn = "Disabled";
		%>
		<!--Below line modifed for this SCF ML-MMOH-SCF-0361 -->
		<tr>
			<td class='label' ><fmt:message key="Common.TransferredBy.label" bundle="${common_labels}"/></td>
			<td class='fields' ><input type='text' size='30' maxlength='30' name='transferredbyname' id='transferredbyname' value="<%=user_name%>" readonly><input type='hidden' size='30' maxlength='30' name='transferredby' id='transferredby' value='<%=user_id%>' readonly><input type='button' name='searchuser' id='searchuser' value='?' class='button' align='center' onClick="searchUser(transferredby,'<%=facility_id%>')" <%=disableyn%>></td>
		</tr>
		<%
	if(rs!=null)	rs.close();
	if(stmt!=null)  stmt.close();
	}catch(Exception e){out.println(e);}
	finally
	{		
		ConnectionManager.returnConnection(conn,request);
	}
%>
</table>
	<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
	<input type='hidden' name='Dflt_Archive_Locn' id='Dflt_Archive_Locn' value='<%=Dflt_archive_fs_locn_code%>'>
	<input type='hidden' name='Dflt_Lost_Locn' id='Dflt_Lost_Locn' value='<%=Dflt_lost_fs_locn_code%>'>
	<input type='hidden' name='userSecurity' id='userSecurity' value='<%=userSecurity%>'>
	<input type='hidden' name='accessAll' id='accessAll' value='<%=accessAll%>'>
	<input type='hidden' name='auto_rec_ward_yn' id='auto_rec_ward_yn' value='<%=auto_rec_ward_yn%>'>
	<input type='hidden' name='auto_rec_clinic_yn' id='auto_rec_clinic_yn' value='<%=auto_rec_clinic_yn%>'>
	<input type='hidden' name='auto_rec_pract_yn' id='auto_rec_pract_yn' value='<%=auto_rec_pract_yn%>'>
	<input type='hidden' name='auto_rec_dept_yn' id='auto_rec_dept_yn' value='<%=auto_rec_dept_yn%>'>
	<input type='hidden' name='Hiddenfile_transport_mode' id='Hiddenfile_transport_mode' value=''>
	<input type='hidden' name='Hiddencarried_by_name' id='Hiddencarried_by_name' value=''>
	<!-- Added by Sangeetha for ML-MMOH-CRF-0345.2 on 17/07/17 -->
	<input type='hidden' name='lang_id' id='lang_id' value='<%=locale%>'>
</form>
</body>
</html>
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

