<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %> 
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<head>
<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
%>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eFM/js/FMPractitionerComponent.js'></script>
<script language='javascript' src='../../eCommon/js/common.js' ></script>
<script language='javascript' src='../../eFM/js/FMIssueFiles.js' ></script>
<script language='javascript' src='../../eFM/js/FMIssueFilesDoc.js' ></script>
<Script language="JavaScript" src="../../eCommon/js/CommonLookup.js" ></Script>
		
</head>  
<%
	
	
	Connection conn				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs						= null;
	
	String facility_id = (String) session.getValue("facility_id");

	String sql					= "";	
	//String moreCriteria			= "";
	String p_file_no_length	= "";

	StringBuffer FacilityBuffer	= null;
	StringBuffer RequestModeBuffer	= null;
	FacilityBuffer					= new StringBuffer();	
	RequestModeBuffer			= new StringBuffer();	

	String userSecurity		= request.getParameter("userSecurity");
	String resLocnIdentities	= request.getParameter("resLocnIdentities");
	String refresh 				= request.getParameter("refresh ");
	String strLocn				= request.getParameter("strLocn");
	String access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");
//	String file_doc				= request.getParameter("file_doc");	
	String file_type_yn			= request.getParameter("file_type_yn")==null?"N":request.getParameter("file_type_yn");
  String maxLimit= "100";
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
	//	sql = "Select FACILITY_ID, FACILITY_NAME from SM_FACILITY_PARAM_LANG_VW WHERE language_id = '"+localeName+"' order by 2";
	sql = "SELECT   FACILITY_ID,sm_get_desc.sm_facility_param (facility_id,'"+localeName+"', 1) FACILITY_NAME FROM sm_facility_param ORDER BY 2";
		
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
		
		//sql = "Select req_mode, long_desc from FM_MANUAL_REQUEST_MODE where EFF_STATUS='E'";
		sql = "SELECT req_Mode,Long_desc FROM   fm_manual_request_mode_lang_vw WHERE  EFF_STATUS = 'E' AND LANGUAGE_ID='"+localeName+"'";
		rs  = stmt.executeQuery(sql);
		while(rs != null && rs.next())
		{
			String ID	= rs.getString("req_mode");
			String desc	= rs.getString("long_desc");
			RequestModeBuffer.append("<option value='"+ID+"' >"+desc+"</option>");
		}
		%>
	<Script>
	function tab_click1(id) 
	{
		selectTab(id);
		objClick(id);
	}

	function objClick(objName) {
	if(objName == 'page_one_tab') {
		//parent.parent.frames[2].IssueFileFrameSet.rows='6%,4%,33%,*,9%';
		parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
		parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
		parent.parent.frames[2].document.getElementById("issue_tab").style.height = '81vh';
		parent.parent.frames[2].document.getElementById("issue_detail").style.height = 'auto';
		parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh';
					
		parent.frames[2].location.href = '../../eFM/jsp/FMIssueFilesTab.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>&file_type_yn=<%=file_type_yn%>';
		parent.frames[1].document.forms[0].selected_tab.value='page_one_tab';
	} else if(objName == 'page_two_tab') {

					parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
					parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
					parent.parent.frames[2].document.getElementById("issue_tab").style.height = '81vh';
					parent.parent.frames[2].document.getElementById("issue_detail").style.height = '0vh';
					parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh';
				
			parent.frames[2].location.href = '../../eFM/jsp/FMIssueFileManualEntry.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>&file_type_yn=<%=file_type_yn%>';
			parent.frames[1].document.forms[0].selected_tab.value='page_two_tab';
	} else if(objName == 'page_three_tab') {

			parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
			parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
			parent.parent.frames[2].document.getElementById("issue_tab").style.height = '81vh';
			parent.parent.frames[2].document.getElementById("issue_detail").style.height = '0vh';
			parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh';
					
			parent.frames[2].location.href = '../../eFM/jsp/FMIssueFilesViewMain.jsp?file_type_yn=<%=file_type_yn%>&userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>';
			parent.frames[1].document.forms[0].selected_tab.value='page_three_tab';
	}
	}
</Script>
		<body OnMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
		<form name='ManualEntry_form' id='ManualEntry_form' method='post' target='messageFrame' action='../../eFM/jsp/FMIssueFilesUpdateBean.jsp'>
		<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
		<tr>
		<td width= "85%" class="white">
		<ul id="tablist" class="tablist" style="padding-left: 5px;">
			<li class="tablistitem" title="Outstanding Request">
				<a onclick="tab_click1('page_one_tab')" class="tabA" id="page_one_tab" >
					<span class="tabAspan" id="page_one_tabspan"><fmt:message key="eFM.OutstandingRequest.label" bundle="${fm_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Manual Request">
				<a onclick="tab_click1('page_two_tab')" class="tabClicked" id="page_two_tab" >
					<span class="tabSpanclicked" id="page_two_tabspan"><fmt:message key="eFM.ManualRequest.label" bundle="${fm_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title="Issue File">
				<a onclick="tab_click1('page_three_tab')" class="tabA" id="page_three_tab" >
					<span class="tabAspan" id="page_three_tabspan"><fmt:message key="eFM.IssueFile.label" bundle="${fm_labels}"/></span>
				</a>
			</li>	
		</ul>
	 </tr>
	 </table>
	<!-- The below line is required to change the select state of 'Outstanding Request' tab initially selected -->
	<script>prevTabObj='page_two_tab'</script>

		<table border='0' cellpadding='3' cellspacing='0' width='100%' align='center'>
			<td colspan='4' class='COLUMNHEADER'><fmt:message key="eFM.RequesterDetails.label" bundle="${fm_labels}"/></td>
			<tr>
				<td class='label' width='25%'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></td>
				<td width='25%' class='fields'><select name='facility' id='facility' onChange="populateUsers(this.value);">
						<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<%=FacilityBuffer.toString()%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
				<td class='label' width='25%'><fmt:message key="eFM.AccountablePerson.label" bundle="${fm_labels}"/></td>
				<td width='25%' class='fields'><input type='text' size='30' name='username1' id='username1' value="" onChange="searchUser(username,'<%=facility_id%>');"><input type='hidden' name='username' id='username' value="" ><input type='button' name='searchuser' id='searchuser' value='?' class='button' valign='center' onClick="searchUser(username,'<%=facility_id%>')" ><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
			</tr>
			<TR>
				<!-- <TD colspan='2'></TD> -->
				<TD class='label' id='td1' ></TD>
				<TD class='querydata' id='td2' ></TD>
				<TD class='label' id='td3' ></TD>
				<TD class='querydata'id='td4' ></TD>
			</TR>
			<tr>
				<td  class='label' nowrap><fmt:message key="eFM.ThirdPartyName.label" bundle="${fm_labels}"/></td>
				<td  colspan="3" class='fields'><textarea rows="2" cols="85" name="third_party_name" onBlur="CheckMaxLength('Third Party Name', this, '200', parent.frames[4].document);"></textarea> 
			    </td>
			</tr>
			<tr>
				<td class='label'  nowrap><fmt:message key="Common.RequestMode.label" bundle="${common_labels}"/></td>
				<td class='fields'><select name='req_mode' id='req_mode' >
						<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
						<%=RequestModeBuffer.toString()%>
					</select></td>
					 <!-- Below line(s) added by venkatesh.S against ML-MMOH-CRF-0393-IN057159 -->
					<td class='label' nowrap><fmt:message key="eFM.ReasonForBorrowing.label" bundle="${fm_labels}"/></td>
					<td class='fields'  ><select name='narration' id='narration'  onchange='enableReason(this)' >
							<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option></select></td> 
				</tr> 
				<tr>
				<td></td> 
				<td></td>  
			 <td class='label' ><label id='remark_visible'  style='visibility:hidden' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></label></td>
			 <td class='field'> 
    		 <textarea  name='reason' rows='1' cols='24'  align='left'  onblur="makeValidString(this);checkMaxLen(this);enableFiles(this.value);" onkeypress="return checkValidCharacter(this,'100', event.keyCode);" style='visibility:hidden'></textarea> 
			 <img src='../../eCommon/images/mandatory.gif' align='center' id="mandatory" style='visibility:hidden'></img> 
			 </td> 
				</tr>
				<!--end ML-MMOH-CRF-0393-IN057159 -->
				<tr>
					<TD class= 'label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/> </TD>
					<TD class='fields' ><select name="locations" id="locations" onChange="assignValues(this.value);">
						<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option></select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
					</TD>
					<TD class= 'label' id='id1'><fmt:message key="eFM.Requesting.label" bundle="${fm_labels}"/></TD>
					<TD class='fields' ><input type=text size=30 maxlength=30 name='returning_desc' id='returning_desc' onChange="getValidRecords(this,'<%=localeName%>');" disabled onBlur="enableFiles(this.value);"><input type='button' class='button' name='requesting_btn' id='requesting_btn' value='?'  onClick="getValidRecords(returning_desc,'<%=localeName%>');" disabled><img src='../../eCommon/images/mandatory.gif' align='center'></img><input type='hidden' name='returning_code' id='returning_code'> 
					</TD> 
				</tr>
				<tr><td class='button' colspan='4' align="right">
					<input type='button' class='button' name='files' id='files' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.Files.label","fm_labels")%> ' onClick='showFiles();' disabled><input type='button' class='button' name='close' id='close' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%> ' onClick='Cls();'>
				</td>
				</tr>
			</table>
			<div name='detaillayer' id='detaillfields' style='position:absolute; width:100%; visibility:hidden;'>
			<table border='0' cellpadding='2' cellspacing='0' width='95%' align='center'>
				<tr><td class='COLUMNHEADER' colspan='4' ><fmt:message key="eFM.RequestedFileDetails.label" bundle="${fm_labels}"/></td></tr>
				<tr>
					<td colspan='4'>
						<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
							<jsp:param name="frame_name" value="parent.frames[2]"/>
							<jsp:param name="form_name" value="ManualEntry_form"/>
							<jsp:param name="messageframe_name" value="parent.messageFrame"/>
							<jsp:param name="patientid_name" value="patientid"/>
							<jsp:param name="fileno_name" value="fileno"/>
							<jsp:param name="filetype_name" value="file_type"/>
							<jsp:param name="volumeno_name" value="volume_no"/>
							<jsp:param name="volume_mandatory_yn" value="Y"/>
							<jsp:param name="table_width" value="100"/>
							<jsp:param name="patline_yn" value="N"/>
							<jsp:param name="patline_ID" value="patline"/>
							<jsp:param name="locn_code" value="f_curr_fs_locn"/> 
							<jsp:param name="volume_no_function" value="CheckPatientExists1(document.forms[0].patientid.value);"/> 
														
						</jsp:include>
						<%-- param name="patient_id_function" value="getValidDatas(event,document.forms[0].patientid.value);" --%>
					</td>
				</tr>
			</table>
			<table border='0' cellpadding='2' cellspacing='0' width='95%' align='center'>
				<td  class='OTHLANGLABEL' width='25%' id="patline" style='font-weight:bolder' colspan='2'></td>
				<td colspan='2'></td></tr>
				<tr>
					<td class='label' width='25%' nowrap><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
					<td id="filelocnid" colspan="3"  class='fields'>
						<input type='text' name='currfilelocn' id='currfilelocn' size='86' maxlength='100' value='' readonly></td>
				</tr>
				<tr>
					<td class='label' width='25%'><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></td>
					<td  class='fields' colspan='3' id="filestatusid"><input type='text' name='filestat' id='filestat' size='20' maxlength='20' value='' readonly>
					</td>
				</tr>
				<tr>
					<td class='label' width='25%'><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
					<td  class='fields' colspan='3'><input type='text' name='remarks' id='remarks' onKeyPress="return checkMaxLimit1(this,'<%=maxLimit%>', event.keyCode);"  size='86' maxlength='100'  value=''      onBlur="makeValidString(this);" >
					</td>
				</tr>
			</table>
			<table border="0" cellpadding="0" cellspacing="0" align='center' width='95%'>
					<td class='button' align="right"><input type='button' class='button' name='add' id='add' value='<fmt:message key="Common.Add.label" bundle="${common_labels}"/> <fmt:message key="Common.for.label" bundle="${common_labels}"/> <fmt:message key="Common.Issue.label" bundle="${common_labels}"/>' onClick='Add()'></td>
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
		<input type='hidden' name='Curr_file_status' id='Curr_file_status' value=''>
		<input type='hidden' name='Borrowing_Reason' id='Borrowing_Reason' value=''>

	</form>
	</body>
</html>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

