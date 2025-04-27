<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
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

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<%
	String userSecurity = request.getParameter("userSecurity");
	String resLocnIdentities = request.getParameter("resLocnIdentities");
	String strLocn = request.getParameter("strLocn");
	String refresh = request.getParameter("refresh");
	String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
%>

<script>	
function add()
{
}
function objClick(objName)
{
	if(objName == 'page_one_tab')
	{		
		
		parent.frames[3].location.href = '../../eFM/jsp/DTIssueFileOutstandingReq.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>';
		parent.frames[2].document.getElementById("tab1").style.display="none";
		document.forms[0].tab_check.value="0";
	}
		else if(objName == 'page_two_tab') {
		parent.frames[3].location.href = '../../eFM/jsp/DTIssueFileManualEntry.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>';
		parent.frames[2].document.getElementById("tab1").style.display="none";
		document.forms[0].tab_check.value="0";
	}
	else if(objName == 'page_three_tab')
	{		
		parent.frames[3].location.href = '../../eFM/jsp/DTIssueFilesViewMain.jsp';
		document.forms[0].tab_check.value="1";		
		
	}else if(objName == 'page_four_tab') {
		parent.frames[2].document.getElementById("tab1").style.display="none";
		document.forms[0].tab_check.value="0";
		var dialogHeight	= "23" ;
		var dialogWidth		= "50" ;
		var dialogTop		= "155" ;
		var dialogLeft		= "55" ;
		var center			= "0" ;
		var status			= "no";
		var features		= "dialogHeight:" + dialogHeight + "; dialogWidth:" + dialogWidth + "; center: " + center + "; status: " + status + "; dialogTop :" + dialogTop + ";dialogLeft:" + dialogLeft;
		var arguments		= "" ;
		retVal				= window.showModalDialog( "../../eFM/jsp/FMIssueFileSearchFrames.jsp?access_all=<%=access_all%>&userSecurity=<%=userSecurity%>", arguments, features );

		var s_file_no			='';
		var s_fs_locn_code		='';
		var s_fs_narration		='';
		var s_request_date		='';
		var s_request_by_id		='';
		var s_fs_locn_identity	='';
		var s_file_type			='';
		var s_volume_no			='';

		if(!(retVal == null)) {
			var retVal=unescape(retVal);
			arr=retVal.split("::");
		    s_file_no			= arr[0];
			s_fs_locn_code		= arr[1];
		    s_fs_narration		= arr[2];
			s_request_date		= arr[3];
		    s_request_by_id		= arr[4];
			s_fs_locn_identity	= arr[5];
			s_file_type			= arr[6];
			s_volume_no			= arr[7];
			
			parent.frames[3].location.href = '../../eFM/jsp/DTIssueFileOutstandingReq.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>&s_file_no='+s_file_no+'&s_fs_locn_code='+s_fs_locn_code+'&s_fs_narration='+s_fs_narration+'&s_request_date='+s_request_date+'&s_request_by_id='+s_request_by_id+'&s_fs_locn_identity='+s_fs_locn_identity+'&s_file_type='+s_file_type+'&s_volume_no='+s_volume_no;
		} else {
			parent.frames[3].location.href = '../../eFM/jsp/DTIssueFileOutstandingReq.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&strLocn=<%=strLocn%>&refresh=<%=refresh%>&access_all=<%=access_all%>&s_file_no='+s_file_no+'&s_fs_locn_code='+s_fs_locn_code+'&s_fs_narration='+s_fs_narration+'&s_request_date='+s_request_date+'&s_request_by_id='+s_request_by_id+'&s_fs_locn_identity='+s_fs_locn_identity+'&s_file_type='+s_file_type+'&s_volume_no='+s_volume_no;
		}
	}
}
</script>
<body OnMouseDown="CodeArrest();" onLoad="objClick('page_one_tab');" onKeyDown = 'lockKey();'>
<form name='FileIsuueTab' id='FileIsuueTab'>
<table border="0" cellpadding="0" cellspacing="0" align='center' width='100%'>
<tr>
 <td width= "85%" class="white">
		<ul id="tablist" class="tablist" >
			<li class="tablistitem" title="Outstanding Request">
				<a onclick="tab_click1('page_one_tab')" class="tabClicked" id="page_one_tab" >
					<span class="tabSpanclicked" id="page_one_tabspan"><fmt:message key="eFM.OutstandingRequest.label" bundle="${fm_labels}"/></span>
				</a>
			</li>
			<li class="tablistitem" title="Search Criteria">
				<a onclick="tab_click1('page_four_tab')" class="tabA" id="page_four_tab" >
					<span class="tabAspan" id="page_four_tabspan"><fmt:message key="Common.SearchCriteria.label" bundle="${common_labels}"/></span>
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
	<td width="10%"  class='button' id="tab1"><input type='button' class='button' name='add' id='add' value='Mode of Transport' onClick="javascript:GetRemarks(); ">
		<input type="hidden" name="file_transport_mode" id="file_transport_mode" value="">
		<input type="hidden" name="carried_by_name" id="carried_by_name" value="">
	</td>
 <td width="10%" class='button'>
	<input type='button' class='button' name='add' id='add' value='Refresh' onClick="javascript:objClick('page_one_tab'); ">
 </td>

</tr>
</table>
<!-- The following tab has been introduced to keep chk of the tab which is clicked. If the the Issue Documents Tab is selected then only the Document can be isued; in other cases the value of the hidden field tab_check will be 0 -->
<input type='hidden' name='tab_check' id='tab_check' value='0'>
</form>
</body>
</html>

