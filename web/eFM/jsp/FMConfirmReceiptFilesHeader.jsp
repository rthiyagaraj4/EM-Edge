<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMConfirmReceiptFiles.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<body OnMouseDown="CodeArrest();" onLoad="document.ConfirmReceiptHeader_form.FS_LOCN_ID.focus();" onKeyDown = 'lockKey();'>
<form name='ConfirmReceiptHeader_form' id='ConfirmReceiptHeader_form'>
	<table border='0' cellpadding='3' cellspacing='0' width='98%' align='left'>
<%

	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;		
		
	String facility_id	= (String) session.getValue("facility_id");
	String user_id		= (String) session.getValue("login_user");

	String username						= "";
	String userButtAttr					= "";
	String userSecurity					= "";
	String datetime						= "";
	String auto_rec_ward_yn				= "", auto_rec_clinic_yn = "", auto_rec_pract_yn = "";
	String auto_rec_dept_yn				= "";
	String doc_or_file					= "";
	String sql							= "";
	String AUTO_REC_PROCEDURE_YN		= "", AUTO_REC_DAYCARE_YN = "";     
	String auto_rec_external_yn			= "";
	String dflt_archive_fs_locn_code	= "";
	String dflt_lost_fs_locn_code		= "";
	String accessAll					= "";
     String value="";
	try
	{
		doc_or_file					= checkForNull(request.getParameter("doc_or_file"));
		accessAll					= checkForNull(request.getParameter("accessAll"));
		auto_rec_ward_yn			= checkForNull(request.getParameter("auto_rec_ward_yn"), "N");
		auto_rec_clinic_yn			= checkForNull(request.getParameter("auto_rec_clinic_yn"),"N");
		AUTO_REC_PROCEDURE_YN		= checkForNull(request.getParameter("auto_rec_procedure_yn"),"N");
		AUTO_REC_DAYCARE_YN			= checkForNull(request.getParameter("auto_rec_daycare_yn"),"N");    
		auto_rec_pract_yn			= checkForNull(request.getParameter("auto_rec_pract_yn"),"N");
		auto_rec_dept_yn			= checkForNull(request.getParameter("auto_rec_dept_yn"),"N");
		userSecurity				= checkForNull(request.getParameter("USER_SECURITY_YN"),"N");
		auto_rec_external_yn		= checkForNull(request.getParameter("AUTO_REC_EXTERNAL_YN"));
		dflt_archive_fs_locn_code	= checkForNull(request.getParameter("DFLT_ARCHIVE_FS_LOCN_CODE"));
		dflt_lost_fs_locn_code		= checkForNull(request.getParameter("DFLT_LOST_FS_LOCN_CODE"));
		
		stmt		= con.createStatement();
		
		//sql = "select appl_user_name,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') sydate from sm_appl_user where appl_user_id='"+user_id+"' ";
		value=(String)session.getAttribute("username");
		
		if(value==null) value="";
       if(value.equals(""))
		{
	   sql = "select appl_user_name,TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') sydate from sm_appl_user_LANG_VW where appl_user_id='"+user_id+"' AND LANGUAGE_ID = '"+localeName+"'";
		rs	= stmt.executeQuery(sql);
		while(rs != null && rs.next()) 
		{
			username = rs.getString("appl_user_name");
			datetime = rs.getString("sydate");
		} if(rs!=null)	rs.close();
		datetime=DateUtils.convertDate(datetime,"DMYHM","en",localeName);
		session.setAttribute("username",username);
		}else{
         username=value;
		}
		%>

		<tr>
			<TD width='25%' class= 'label'><fmt:message key="eFM.ReceivingFSLocationIdentity.label" bundle="${fm_labels}"/></TD>
			<TD class='fields' width='25%' >
				<select name="FS_LOCN_ID" id="FS_LOCN_ID"  onChange="PopulateData(this.value)">
					<option value="">------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------</option>
					<% if(auto_rec_clinic_yn.equals("N")) %>
						<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
					<% if(auto_rec_ward_yn.equals("N")) %>
						<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
					<% if(AUTO_REC_PROCEDURE_YN.equals("N")) %>
						<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
					<% if(AUTO_REC_DAYCARE_YN.equals("N")) %>
						<option value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
					<% if(auto_rec_pract_yn.equals("N")) %>
						<option value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
					<% if(auto_rec_dept_yn.equals("N")) %>
						<option value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></option>
				</select>
			</TD>
		<!-- </TR>
		<TR> -->
			<TD width='25%' class= 'label'><fmt:message key="eFM.ReceivingFSLocation.label" bundle="${fm_labels}"/></TD>
			<TD width='25%' class='fields' >
			<select name='fslocation' id='fslocation' onChange="showcriteria(this.value);">
					<option value=''>------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-------------</option>
					<% if(userSecurity.equals("Y")) userButtAttr = "Disabled"; %>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>  
			</td>
		</tr>
		<!--Below line modifed for this SCF ML-MMOH-SCF-0361 -->
		<tr>
			<td class='label' ><fmt:message key="Common.ReceivingDateTime.label" bundle="${common_labels}"/></td>
			<td   class='fields'><input type='text'  name='receivedate' id='receivedate' maxlength='20' size='17' value='<%=datetime%>' readonly></td>
			<td class='label' width='15%'><fmt:message key="eFM.ReceiverName.label" bundle="${fm_labels}"/></td>
			<td class='fields'><input type='text' name='username1' id='username1'  size='30' value="<%=username%>" readonly><input type='hidden' name='username' id='username' size='30' value='<%=user_id%>' readonly><input type='button' name='searchuser' id='searchuser' value='?' class='button' valign='center' onClick="searchUser(username,'<%=facility_id%>')" <%=userButtAttr%>></td>
		</tr>
		<tr>
				<td class='label' colspan='3'>&nbsp;</td>
				<td class='button'><input type='button' class='button' name='clear' id='clear' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%> ' onClick="clearValues();"></td>
		</tr>
		</table>
	<%
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();
	}catch(Exception e){out.println(e);}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
	%>
	<input type='hidden' name='hdrec_locn_code' id='hdrec_locn_code' value=''>
	<input type='hidden' name='hdrec_locn_iden' id='hdrec_locn_iden' value=''>
	<input type='hidden' name='hdrec_user_id' id='hdrec_user_id' value=''>
	<input type='hidden' name='doc_or_file' id='doc_or_file' value='<%=doc_or_file%>'>
	<input type='hidden' name='accessAll' id='accessAll' value='<%=accessAll%>'>
	<input type='hidden' name='userSecurity' id='userSecurity' value='<%=userSecurity%>'>
	<input type='hidden' name='Auto_rec_ward' id='Auto_rec_ward' value='<%=auto_rec_ward_yn%>'>
	<input type='hidden' name='Auto_rec_clinic' id='Auto_rec_clinic' value='<%=auto_rec_clinic_yn%>'>
	<input type='hidden' name='AUTO_REC_PROCEDURE_YN' id='AUTO_REC_PROCEDURE_YN' value='<%=AUTO_REC_PROCEDURE_YN%>'>
	<input type='hidden' name='AUTO_REC_DAYCARE_YN' id='AUTO_REC_DAYCARE_YN' value='<%=AUTO_REC_DAYCARE_YN%>'>
	<input type='hidden' name='Auto_rec_pract' id='Auto_rec_pract' value='<%=auto_rec_pract_yn%>'>
	<input type='hidden' name='Auto_rec_dept' id='Auto_rec_dept' value='<%=auto_rec_dept_yn%>'>
	<input type='hidden' name='Auto_rec_external' id='Auto_rec_external' value='<%=auto_rec_external_yn%>'>
	<input type='hidden' name='Dflt_archive_fs_locn_code' id='Dflt_archive_fs_locn_code' value='<%=dflt_archive_fs_locn_code%>'>
	<input type='hidden' name='Dflt_lost_fs_locn_code' id='Dflt_lost_fs_locn_code' value='<%=dflt_lost_fs_locn_code%>'>
	</form>
<%!

public static String checkForNull(String inputString)
{
	return ( ( (inputString == null) || (inputString.equals("null") ) ) ? "" : inputString );
}

public static String checkForNull(String inputString, String defaultValue)
{
	return ( ( (inputString == null) || (inputString.equals("null") ) ) ? defaultValue : inputString );
}
%>
</body>
</html>

