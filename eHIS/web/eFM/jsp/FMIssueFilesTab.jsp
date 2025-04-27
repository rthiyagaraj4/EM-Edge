<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*,eCommon.Common.*" contentType="text/html; charset=UTF-8"%>

<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<jsp:useBean id="FMIssueFileAddBean" scope="session" class="eFM.FMIssueFileAddBean"/>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	String facility_id				= (String) session.getValue("facility_id");
	Connection con	 = null;
	try 
	{
		FMIssueFileAddBean.clearCart();
	con								= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs						= null;

	String userSecurity = request.getParameter("userSecurity");
	String resLocnIdentities = request.getParameter("resLocnIdentities");
	String strLocn = request.getParameter("strLocn");
//out.println("<script>alert('" +strLocn+"')</script>");
	String refresh = request.getParameter("refresh");
	String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
	String file_type_yn = request.getParameter("file_type_yn");
	/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start*/
	String issue_file_refresh_interval	= (request.getParameter("issue_file_refresh_interval")=="" || request.getParameter("issue_file_refresh_interval")==null)?"":request.getParameter("issue_file_refresh_interval");
	Boolean isRefreshIntervalAvailable 	 = CommonBean.isSiteSpecific(con, "FM","ISSUE_FILE_AUTO_REFRESH");	
	Boolean isAutoPopulateAvailable		 = CommonBean.isSiteSpecific(con, "FM","ISSUE_FILE_AUTO_POPULATE");
	Boolean isOutStandingReqAvialble	 = CommonBean.isSiteSpecific(con, "FM","ISSUE_FILE_OUT_STND_REQ");;
	
	/*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End*/
	if(strLocn == null || strLocn.equals("null")) strLocn = "SelectAll";
	String NarrationCode		= "";
	String NarationShortDesc= "";
	String sys_date				= "";	
	StringBuffer ReasonForBurrowBuffer	= new StringBuffer();

	stmt = con.createStatement();		
	
	
	String sql = "SELECT Narration_Code, Short_desc FROM fm_narration_lang_vw WHERE eff_Status = 'E' AND LANGUAGE_ID='"+localeName+"' ORDER BY 2";
		
	rs 	= stmt.executeQuery(sql);
	while(rs != null && rs.next())
	{
		NarrationCode			= rs.getString("narration_code");
		NarationShortDesc	= rs.getString("short_desc");
		ReasonForBurrowBuffer.append("<OPTION value='"+NarrationCode+"'>"+NarationShortDesc+"</OPTION>");
	} if(rs != null) rs.close();
	String sys_date_query="select to_char(sysdate,'dd/mm/yyyy') from dual";
	rs 	= stmt.executeQuery(sys_date_query);
	if(rs != null && rs.next())
	{
		sys_date = rs.getString(1);
	} if(rs != null) rs.close();
	if(sys_date == null || sys_date.equals("null")) sys_date = "";
%>
	<link rel='stylesheet' type ='text/css' href='../../eCommon/html/Tabs.css'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMIssueFiles.js' ></script>
	<script language='javascript' src='../../eFM/js/checkSystemDate.js'></script>
	<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
	<script language='javascript' src='../../eCommon/js/dchk.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



	<Script>
		function tab_click1(id) 
		{
			selectTab(id);
			objClick(id);
		}
		function objClick(objName) 
		{
			
			if(objName == 'page_one_tab') { 
				if(document.forms[0].isOutStandingReqAvialble.value=="true"){
					parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
					parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
					parent.parent.frames[2].document.getElementById("issue_tab").style.height = '4';
					parent.parent.frames[2].document.getElementById("issue_detail").style.height = 'auto';
					parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh'
				

				parent.frames[3].location.href = '../../eFM/jsp/FMIssueFileOutstandingReq.jsp?isOutStandingReqAvialble=<%=isOutStandingReqAvialble%>&userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>&file_type_yn=<%=file_type_yn%>';
				}else{
					parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
					parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
					parent.parent.frames[2].document.getElementById("issue_tab").style.height = '31vh';
					parent.parent.frames[2].document.getElementById("issue_detail").style.height = '48vh';
					parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh';
				}
				parent.frames[1].document.forms[0].selected_tab.value='page_one_tab';
			} else if(objName == 'page_two_tab') {
					parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
					parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
					parent.parent.frames[2].document.getElementById("issue_tab").style.height = '81vh';
					parent.parent.frames[2].document.getElementById("issue_detail").style.height = '0vh';
					parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh'
					parent.frames[2].location.href = '../../eFM/jsp/FMIssueFileManualEntry.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>&file_type_yn=<%=file_type_yn%>';
					parent.frames[3].location.href = "../../eCommon/html/blank.html";
					parent.frames[1].document.forms[0].selected_tab.value='page_two_tab';
			} else if(objName == 'page_three_tab') {
					parent.parent.frames[2].document.getElementById("commontoolbarFrame").style.height = '6vh';
					parent.parent.frames[2].document.getElementById("issue_header").style.height = '4vh';
					parent.parent.frames[2].document.getElementById("issue_tab").style.height = '81vh';
					parent.parent.frames[2].document.getElementById("issue_detail").style.height = '0vh';
					parent.parent.frames[2].document.getElementById("messageFrame").style.height = '9vh'
					parent.frames[2].location.href = '../../eFM/jsp/FMIssueFilesViewMain.jsp?file_type_yn=<%=file_type_yn%>&userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>&file_type_yn=<%=file_type_yn%>';
					parent.frames[1].document.forms[0].selected_tab.value='page_three_tab';
			} 
		}
</Script>
</head>
<!-- onLoad="submitAllDetails();"  added for MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 5th 2014 -->

<!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start-->
<%
String onLoadFunction		= "";
if(isAutoPopulateAvailable){
	onLoadFunction	= "submitAllDetails();";
}
if(isOutStandingReqAvialble){
	onLoadFunction	= "objClick('page_one_tab');";
}
%>
<!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End-->


<body OnMouseDown="CodeArrest();" onLoad="<%=onLoadFunction%>" onKeyDown = 'lockKey();'>
	<form name='FileIsuueTab' id='FileIsuueTab' >
	<input type="hidden" name="userSecurity" id="userSecurity" value="<%=userSecurity%>">
	<input type="hidden" name="access_all" id="access_all" value="<%=access_all%>">
	<input type="hidden" name="resLocnIdentities" id="resLocnIdentities" value="<%=resLocnIdentities%>">
	<input type="Hidden" name="patient_file_type" id="patient_file_type" value="" >
	<input type="Hidden" name="sys_date" id="sys_date" value="<%=sys_date%>" >
	<input type="Hidden" name="file_type_yn" id="file_type_yn" value="<%=file_type_yn%>" >
	<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
   <input type='hidden' name='file_no_concat' id='file_no_concat' value=''>
	<input type='hidden' name='volume_no_concat' id='volume_no_concat' value=''>	
	<!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 Start-->
	<input type='hidden' name='issue_file_refresh_interval' id='issue_file_refresh_interval' value='<%=issue_file_refresh_interval%>'>
	<input type='hidden' name='isRefreshIntervalAvailable' id='isRefreshIntervalAvailable' value='<%=isRefreshIntervalAvailable%>'>	
	<input type='hidden' name='isAutoPopulateAvailable' id='isAutoPopulateAvailable' value='<%=isAutoPopulateAvailable%>'>		
	
	<!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 21st 2014 End-->
<a name='OutStandingReq'></a>

		<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
		<tr>
		<td width= "85%" class="white">
		<ul id="tablist" class="tablist" style="padding-left: 5px;">
			<li class="tablistitem" title="Outstanding Request">
				<a onclick="tab_click1('page_one_tab')" class="tabClicked" id="page_one_tab" >
					<span class="tabSpanclicked" id="page_one_tabspan"><fmt:message key="eFM.OutstandingRequest.label" bundle="${fm_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Manual Request">
				<a onclick="tab_click1('page_two_tab')" class="tabA" id="page_two_tab" >
					<span class="tabAspan" id="page_two_tabspan"><fmt:message key="eFM.ManualRequest.label" bundle="${fm_labels}"/></span>
				</a>
			</li>	
			<li class="tablistitem" title="Issue File">
				<a onclick="tab_click1('page_three_tab')" class="tabA" id="page_three_tab" >
					<span class="tabAspan" id="page_three_tabspan"><fmt:message key="eFM.IssueFile.label" bundle="${fm_labels}"/></span>
				</a>
			</li>	
		</ul>
	<!-- The below line is required to change the select state of 'Outstanding Request' tab initially selected -->
	<script>prevTabObj='page_one_tab'</script>
	</td>
	</tr>
	</table>
	<%if(!isOutStandingReqAvialble){ %>
	
	<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
			<td colspan='7' class='COLUMNHEADER'><fmt:message key="eFM.RequestedFileDetails.label" bundle="${fm_labels}"/></td>
			
			<tr>
				<td width='1%'></td><td id="patLineID" colspan="6" class="OTHLANGLABEL" style="font-weight:Bolder;"></td>
			</tr>
		</table>
		<table border="0" cellpadding="3" cellspacing="0" width="100%" align="center">
		<tr>
			<td width="25%" class="label"><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></TD>
			<TD width="25%" class='fields'><SELECT name="fs_locn_id" id="fs_locn_id" onChange="PopulateData(this.value)" TABINDEX="4">
					<OPTION VALUE="">---- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----</OPTION>
					<OPTION VALUE="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></OPTION>
					<OPTION VALUE="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></OPTION>
				</SELECT>
			</TD>
			<TD  width="25%" CLASS="label"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
			<TD width="25%" class='fields'><SELECT name="fs_locn_name" id="fs_locn_name" onChange="PopulateIdentity(this)" TABINDEX="5">
					<OPTION VALUE="">----- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</OPTION>
				</SELECT>
			</TD>
		</TR>
		<TR>
			<TD width="25%" CLASS="label"><fmt:message key="eFM.ReasonForBorrowing.label" bundle="${fm_labels}"/></TD>
			<TD width="25%" class='fields'><SELECT name="fs_narration" id="fs_narration" TABINDEX="6">
					<OPTION VALUE=''>-------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>--------</OPTION>
					<%=ReasonForBurrowBuffer.toString()%>
				</SELECT>
			</TD>
			<TD width="25%" CLASS="label"><fmt:message key="eFM.RequestedOnDate.label" bundle="${fm_labels}"/></TD>
			<TD width="25%" class='fields'><INPUT TYPE="text" id='issuefiledate' name="request_date" id="request_date" SIZE="10" MAXLENGTH="10" TABINDEX="7" onBlur="validDateObj(this,'DMY',localeName);validDateSys(this,'<%= sys_date %>')" <%if(isAutoPopulateAvailable){ %>value="<%= sys_date %>" <%}%>><img src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('issuefiledate');"> <%if(isAutoPopulateAvailable){ %><img src='../../eCommon/images/mandatory.gif' align='center'></img><%}%>
			</TD>
		</TR>
		<TR>
			<TD CLASS="label"><fmt:message key="Common.RequestedBy.label" bundle="${common_labels}"/></TD>
			<TD class='fields'><INPUT TYPE="text" name="request_by_name" id="request_by_name" SIZE="30" MAXLENGTH="60" value="" TABINDEX="8"  onKeyPress="return CheckForSpecChars(event);" onChange="searchRequestedByUser('<%= facility_id %>')" ><INPUT TYPE="button" name="searchuser" id="searchuser" value="?" class="button" valign="center" TABINDEX="9" onClick="searchRequestedByUser('<%= facility_id %>')">
				<INPUT TYPE="hidden" name="request_by_id" id="request_by_id" VALUE="">
			</TD>
			<%if(isAutoPopulateAvailable){ %>
			<TD width="25%" CLASS="label"><fmt:message key="eFM.IncludePreviousDayRequest.label" bundle="${fm_labels}"/></TD>
			<TD width="25%" class='fields'><INPUT TYPE="checkbox" id='ChkIncludePreviousDayRequest' name="ChkIncludePreviousDayRequest" id="ChkIncludePreviousDayRequest" > 
			</TD>
			<%}else{ %>
			
			<td colspan="2">&nbsp;</td>
			<%} %>
		</TR>
		<tr>
				<td colspan="7">
					<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
						<jsp:param name="frame_name" value="parent.issue_tab"/>
						<jsp:param name="form_name" value="FileIsuueTab"/>
						<jsp:param name="messageframe_name" value="parent.messageFrame"/>
						<jsp:param name="patientid_name" value="patient_id"/>
						<jsp:param name="fileno_name" value="file_no"/>
						<jsp:param name="filetype_name" value="file_type"/>
						<jsp:param name="volumeno_name" value="volume_no"/>
						<jsp:param name="table_width" value="100"/>
						<jsp:param name="patline_yn" value="N"/>
						<jsp:param name="patientid_mandatory_yn" value="N"/>
						<jsp:param name="file_mandatory_yn" value="N"/>
						<jsp:param name="patline_ID" value="patLineID"/>
						<jsp:param name="locn_code" value="f_curr_fs_locn"/>
					</jsp:include></td>
			</tr>
			<tr>
			<TD CLASS="button" COLSPAN="4" align='right'><INPUT TYPE="button" CLASS="button" name="okbutton" id="okbutton" VALUE=" <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%> " onClick="submitAllDetails()">
				<INPUT TYPE="button" CLASS="button" name="cancelbutton" id="cancelbutton" VALUE="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.cancel.label","common_labels")%>" onClick="clearResult()">
			</TD>
		</TR>
		</TABLE>
	<%}%>
<!-- The following tab has been introduced to keep chk of the tab which is clicked. If the the Issue Files Tab is selected then only the file can be isued; in other cases the value of the hidden field tab_check will be 0 -->
	
		<input type='hidden' name='tab_check' id='tab_check' value='0'>
  <input type='hidden' name='added_rem_remarks' id='added_rem_remarks' value=''>
	<input type='hidden' name='added_rem_remarks_values' id='added_rem_remarks_values' value=''>
	<input type='hidden' name='pat_file_vol' id='pat_file_vol' value=''>
		<a name='ManualStandingReq'></a>
	<input type='hidden' name='isOutStandingReqAvialble' id='isOutStandingReqAvialble' value='<%=isOutStandingReqAvialble%>'/>
	</form>
	
	
</body>
</html>
<%
if((ReasonForBurrowBuffer != null) && (ReasonForBurrowBuffer.length() > 0))
	{
		ReasonForBurrowBuffer.delete(0,ReasonForBurrowBuffer.length());
	}

	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();

	}
	catch(Exception e)
	{
		out.println(e);
		e.printStackTrace();
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
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

