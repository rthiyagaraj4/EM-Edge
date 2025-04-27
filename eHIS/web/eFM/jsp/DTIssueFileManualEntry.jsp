<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language='javascript' src='../../eFM/js/FMIssueFiles.js' ></script>
<script language='javascript' src='../../eFM/js/FMIssueFilesDoc.js' ></script>
<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js" ></Script>
</head> 
<%
	Connection conn				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
	
	String facility_id = (String) session.getValue("facility_id");

	String sql				= "";	
	String moreCriteria		= "";
	String p_file_no_length = "";

	StringBuffer FacilityBuffer		= null;
	StringBuffer RequestModeBuffer	= null;
	FacilityBuffer					= new StringBuffer();	
	RequestModeBuffer				= new StringBuffer();	

	String userSecurity			= request.getParameter("userSecurity");
//	String resLocnIdentities	= request.getParameter("resLocnIdentities");
	String strLocn				= request.getParameter("strLocn");
	String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");

	try
	{
		stmt = conn.createStatement();

		String p_separate_file_no_yn = "";
		String p_no_rec_in_facility  = "N";

		int pat_id_length	= 0;

		sql = "select patient_id_length,separate_file_no_yn  from mp_param";
		rs  = stmt.executeQuery(sql);
		while(rs != null && rs.next())
		{
			pat_id_length		= rs.getInt("patient_id_length");
			p_file_no_length	= rs.getString("separate_file_no_yn");
		} if(rs!=null)	rs.close();
		
		sql = "";
		sql = "select separate_file_no_yn from mp_param_for_facility where facility_id = '"+facility_id+"'" ;
		rs = stmt.executeQuery(sql);
		if(rs != null && rs.next())
		{
			p_separate_file_no_yn	= rs.getString("separate_file_no_yn");
			p_no_rec_in_facility	= "Y";
		} if(rs!=null)	rs.close();

		if(p_no_rec_in_facility.equals("Y"))
		{
			if(p_separate_file_no_yn.equals("N")) p_file_no_length =  Integer.toString(pat_id_length);
			else p_file_no_length	=	"20";
		}
		else
		{
			if(p_file_no_length.equals("N")) p_file_no_length =  Integer.toString(pat_id_length);
			else p_file_no_length	=	"20";
		}
		
		sql = "";
		sql = "Select FACILITY_ID, FACILITY_NAME from SM_FACILITY_PARAM "+moreCriteria+" order by 2";
		rs  = stmt.executeQuery(sql);
		while(rs != null && rs.next())
		{
			String desc	= rs.getString("FACILITY_NAME");
			String ID	= rs.getString("FACILITY_ID");
			if(ID.equals(facility_id))
			{
				FacilityBuffer.append("<option value='"+ID+"' selected>"+desc+"</option>");
			}
			else
			{
				FacilityBuffer.append("<option value='"+ID+"'>"+desc+"</option>");
			}
		} if(rs != null) rs.close();
		
		sql = "Select req_mode, long_desc from FM_MANUAL_REQUEST_MODE where EFF_STATUS='E'";
		rs  = stmt.executeQuery(sql);
		while(rs != null && rs.next())
		{
			String ID	= rs.getString("req_mode");
			String desc	= rs.getString("long_desc");
			RequestModeBuffer.append("<option value='"+ID+"' >"+desc+"</option>");
		}

		%>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
		<form name='ManualEntry_form' id='ManualEntry_form' method='post' target='messageFrame' action='../../eFM/jsp/FMIssueFilesUpdateBean.jsp'>
		<table border='0' cellpadding='1' cellspacing='0' width='95%' align='center'>
			<td colspan='4' class='columnheader'><fmt:message key="eFM.RequesterDetails.label" bundle="${fm_labels}"/></td>
			<tr>
				<td class='label' width='10%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td  width='40%' class='fields'><select name='facility' id='facility' onChange="populateUsers(this.value);">
						<option value=''>------------------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------</option>
						<%=FacilityBuffer.toString()%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
				<td  class='label' width='10%'><fmt:message key="eFM.AccountablePerson.label" bundle="${fm_labels}"/></td>
				<td  width='40%' class='fields'><input type='text' size='30' name='username1' id='username1' value="" onChange="searchUser(username,'<%=facility_id%>');"><input type='hidden' name='username' id='username' value="" ><input type='button' name='searchuser' id='searchuser' value='?' class='button' valign='center' onClick="searchUser(username,'<%=facility_id%>')" >&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
			</tr>
			<TR>
				<TD colspan='2'></TD>
				<TD class='label' width='10%' id='td1' ></TD>
				<TD class='label' width='40%' id='td2' ></TD>
			</TR>
			<TR>
				<TD colspan='2'></TD>
				<TD class='label' width='10%' id='td3' ></TD>
				<TD class='label' width='40%' id='td4' ></TD>
			</TR>
			<tr>
				<td class='label' width='10%' nowrap><fmt:message key="eFM.ThirdPartyName.label" bundle="${fm_labels}"/></td>
				<td width='40%' colspan="3" class='fields'><textarea rows="2" cols="85" name="third_party_name" onBlur="CheckMaxLength('Third Party Name', this, '200', parent.frames[4].document);"></textarea> 
			    </td>
			</tr>
			<tr>
				<td class='label'  nowrap width='15%'><fmt:message key="Common.RequestMode.label" bundle="${common_labels}"/></td>
				<td class='fields' ><select name='req_mode' id='req_mode' >
						<option value=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</option>
						<%=RequestModeBuffer.toString()%>
					</select></td>
					<td  class='label' width='10%' nowrap><fmt:message key="eFM.ReasonForBorrowing.label" bundle="${fm_labels}"/></td>
					<td class='fields' width='40%' ><select name='narration' id='narration'>
							<option value=''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option></select>
					</td>
				</tr> 
				<tr>
					<TD width='30%' class= 'label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/> </TD>
					<TD width='70%' class='fields' ><select name="locations" id="locations" onChange="assignValues(this.value);">
						<option value=''>-------------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------------</option></select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
					</TD>
					<TD width='30%' class= 'label' id='id1'><fmt:message key="eFM.Requesting.label" bundle="${fm_labels}"/></TD>
					<TD width='70%' class='fields' ><input type=text size=30 maxlength=30 name='returning_desc' id='returning_desc' onChange="getValidRecords(this);" disabled onBlur="enableFiles(this.value);"><input type='button' class='button' name='requesting_btn' id='requesting_btn' value='?'  onClick="getValidRecords(returning_desc);" disabled><img src='../../eCommon/images/mandatory.gif' align='center'></img><input type='hidden' name='returning_code' id='returning_code'> 
					</TD> 
				</tr>
				<tr><td class='button'  colspan='4'>
					<input type='button' class='button' name='files' id='files' value=' Documents ' onClick='showFiles();' disabled>
					<input type='button' class='button' name='close' id='close' value=' Clear ' onClick='Cls();'>
				</td>
				</tr>
			</table>
			<div name='detaillayer' id='detaillfields' style='position:absolute; width:100%; visibility:hidden;'>
			<table border='0' cellpadding='2' cellspacing='0' width='95%' align='center'>
				<tr><td colspan='7' class='columnheader' ><fmt:message key="eFM.RequestedDocumentDetails.label" bundle="${fm_labels}"/></td></tr>
				<tr>
					<td colspan='7'>
						<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name="frame_name" value="parent.frames[3]"/>
							<jsp:param name="form_name" value="ManualEntry_form"/>
							<jsp:param name="messageframe_name" value="parent.messageFrame"/>
							<jsp:param name="patientid_name" value="patientid"/>
							<jsp:param name="fileno_name" value="fileno"/>
							<jsp:param name="filetype_name" value="file_type"/>
							<jsp:param name="document_type_name" value="doc_type_code"/>
							<jsp:param name="document_folder_id_name" value="doc_folder_id"/>
							<jsp:param name="volumeno_name" value="volume_no"/>
							<jsp:param name="volume_mandatory_yn" value="Y"/>
							<jsp:param name="table_width" value="95"/>
							<jsp:param name="patline_yn" value="Y"/>
							<jsp:param name="patline_ID" value="patline"/>	<jsp:param name="doctype_appl_yn" value="Y"/>	 
							<jsp:param name="patient_id_function" value="getValidFiles(event,document.forms[0].fileno.value);"/>
							<jsp:param name="locn_code" value="f_curr_fs_locn"/>
						</jsp:include>
					</td>
				</tr>
			</table>
			<table border='0' cellpadding='2' cellspacing='0' width='95%' align='center'>
				<tr><td colspan='1'>&nbsp;</td>
				<td  class='OTHLANGLABEL' width='50%' id="patline" style='font-weight:bolder'></td><td colspan='2'></td></tr>
				<tr>
					<td  class='label' width='20%' nowrap><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
					<td width='25%' id="filelocnid" colspan="3" class='fields'><input type='text' name='currfilelocn' id='currfilelocn' size='86' maxlength='100' value='' readonly></td>
				</tr>
				<tr>
					<td class='label' width='20%'><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></td>
					<td  width='25%' colspan='3' id="filestatusid" class='fields'><input type='text' name='filestat' id='filestat' size='20' maxlength='20' value='' readonly>
					</td>
				</tr>
				<tr>
					<td class='label' width='20%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td  width='35%' class='fields' colspan='3'><input type='text' name='remarks' id='remarks' size='86' maxlength='100' value='' onBlur="makeValidString(this);">
					</td>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" align='right' width='50%'>
					<td class='button' >
					<input type='button' class='button' name='add' id='add' value='Add for Issue' onClick='AddDoc()'>
					</td>
			</table>
			</div>
			<%
			if((FacilityBuffer != null) && (RequestModeBuffer.length() > 0))
			{
				FacilityBuffer.delete(0,FacilityBuffer.length());
			}
			if((RequestModeBuffer != null) && (RequestModeBuffer.length() > 0))
			{
				RequestModeBuffer.delete(0,RequestModeBuffer.length());
			}
		if(rs!=null)	rs.close();
		if(stmt!=null)	stmt.close();
		}catch(Exception e)
		{
			out.println("Exception e :"+e);
		}
		finally
		{			
			ConnectionManager.returnConnection(conn,request);
		}
	%>
		<input type='hidden' name='facility_id' id='facility_id' value='<%=facility_id%>'>
		<input type='hidden' name='strLocn' id='strLocn' value='<%=strLocn%>'>
		<input type='hidden' name='ManualReq' id='ManualReq' value='Y'>
		<input type='hidden' name='Req_on' id='Req_on' value=''>
		<input type='hidden' name='Req_fac_id' id='Req_fac_id' value=''>
		<input type='hidden' name='Req_fac_name' id='Req_fac_name' value=''>
		<input type='hidden' name='Req_locn_code' id='Req_locn_code' value=''>
		<input type='hidden' name='Req_locn_desc' id='Req_locn_desc' value=''>
		<input type='hidden' name='Req_locn_iden' id='Req_locn_iden' value=''>
		<input type='hidden' name='Req_locn_mr_locn' id='Req_locn_mr_locn' value=''>
		<input type='hidden' name='No_Of_Days' id='No_Of_Days' value=''>
		<input type='hidden' name='Req_by' id='Req_by' value=''>
		<input type='hidden' name='Req_by_name' id='Req_by_name' value=''>
		<input type='hidden' name='Narration_code' id='Narration_code' value=''>
		<input type='hidden' name='Narration_desc' id='Narration_desc' value=''>
		<input type='hidden' name='Curr_facility_id' id='Curr_facility_id' value=''>
		<input type='hidden' name='Curr_locn_code' id='Curr_locn_code' value=''>
		<input type='hidden' name='Curr_locn_desc' id='Curr_locn_desc' value=''>
		<input type='hidden' name='Curr_locn_iden' id='Curr_locn_iden' value=''>
		<input type='hidden' name='Curr_locn_mr_locn' id='Curr_locn_mr_locn' value=''>
		<input type='hidden' name='Pat_line' id='Pat_line' value=''>
		<input type='hidden' name='Issue_user_id' id='Issue_user_id' value=''>
		<input type='hidden' name='flag' id='flag' value=''>
		<input type='hidden' name='p_file_no_length' id='p_file_no_length' value='<%=p_file_no_length%>'>
		<input type='hidden' name='userSecurity' id='userSecurity' value='<%=userSecurity%>'>
		<input type='hidden' name='access_all' id='access_all' value='<%=access_all%>'>	
		<input type='hidden' name='Req_req_mode' id='Req_req_mode' value=''>
		<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
	</form>
	</body>
</html>

