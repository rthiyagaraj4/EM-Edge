<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	String prev_menu			= request.getParameter("prev_menu");	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src="../../eCommon/js/CommonCalendar.js" language="JavaScript"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script src='../../eFM/js/FMIssueFiles.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	<jsp:useBean id="FMIssueFilesCart" scope="session" class="webbeans.eFM.FMFilesIssueCart"/>
	<jsp:useBean id="FMIssueFileAddBean" scope="session" class="eFM.FMIssueFileAddBean"/>
	<script>
		if("<%=prev_menu%>"==getLabel('Common.hideMenu.label','common'))
		{
			parent.commontoolbarFrame.document.getElementById("home").value= getLabel('Common.hideMenu.label','common');
		}
	</script>
</head>
<%
	Connection con				= ConnectionManager.getConnection(request);
	PreparedStatement pstmt		= null;

	ResultSet rs				 = null;
	
	String facility_id				= (String) session.getValue("facility_id");
	String user_id				= (String) session.getValue("login_user");

	String userSecurity		= request.getParameter("userSecurity");
	String resLocnIdentities	= request.getParameter("resLocnIdentities");
	String refresh				= request.getParameter("refresh");
	String file_doc				= request.getParameter("file_doc");	
	String file_type_yn			= request.getParameter("file_type_yn")==null?"N":request.getParameter("file_type_yn");
	String access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");
	String p_tracer_card_yn  = request.getParameter("p_tracer_card_yn")==null?"N":request.getParameter("p_tracer_card_yn");
	String issue_file_refresh_interval	= (request.getParameter("issue_file_refresh_interval")=="" || request.getParameter("issue_file_refresh_interval")==null)?"":request.getParameter("issue_file_refresh_interval"); /*Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014*/
%>
<body OnMouseDown="CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'>
<form name='IssueFilesHeader' id='IssueFilesHeader'>
	<table border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<%
		String username			= "";
		String userButtAttr		= "";
		String sql				= "";
		String sql1				= "";		
        String value       ="";
		StringBuffer IssueFSLocnBuffer	= null;
		IssueFSLocnBuffer				= new StringBuffer();

		int selects = 0;

		try
		{
			FMIssueFilesCart.clearCart();
			FMIssueFileAddBean.clearCart();
				
			value=(String)session.getAttribute("username");
			if(value==null) value="";
			
			if(value.equals(""))
			{
			sql1= "SELECT apPl_User_Name FROM   sm_appl_user_lang_vw WHERE  apPl_User_Id = ? AND LANGUAGE_ID=?" ;
			pstmt = con.prepareStatement(sql1);
			pstmt.setString(1,user_id);
			pstmt.setString(2,localeName);
			rs = pstmt.executeQuery();
			while(rs != null && rs.next())
			{
				username = rs.getString("appl_user_name");
			
				}
					
				session.setAttribute("username",username);
			}else{
    username=value;
			}
			
			if(rs!=null)	rs.close();
			if(pstmt!=null) pstmt.close();
				
			if(userSecurity.equals("Y"))
			{
				userButtAttr = "Disabled";				
							
				if (access_all.equals("*ALL"))
				{
					
				//	sql = "SELECT FS_LOCN_CODE, SHORT_DESC FS_LOCN_SHORT_DESC FROM FM_STORAGE_LOCN_LANG_VW WHERE Facility_Id = '"+facility_id+"' 		 AND LANGUAGE_ID='"+localeName+"' AND eff_Status = 'E' AND PERMANENT_FILE_AREA_YN = 'Y' ORDER BY 2 ";
				
				sql = "SELECT   fs_locn_code, fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"', 2 ) fs_locn_short_desc  FROM fm_storage_locn  WHERE facility_id ='"+facility_id+"'  AND fs_locn_code LIKE '%%'      AND eff_status = 'E'     AND permanent_file_area_yn = 'Y' ORDER BY 2";
				
				}
				else
				{
					
					sql = "SELECT A.FS_LOCN_CODE, (CASE WHEN A.FS_LOCN_CODE = '*ALL' THEN '*ALL' ELSE B.SHORT_DESC END) FS_LOCN_SHORT_DESC FROM FM_USER_ACCESS_RIGHTS_VW A, FM_STORAGE_LOCN_LANG_VW B WHERE A.FACILITY_ID = B.FACILITY_ID(+) 	 AND B.LANGUAGE_ID='"+localeName+"' AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) AND A.Facility_Id = '"+facility_id+"'  AND (Iss_yn = 'Y' OR ISS_ACROSS_FACILITIES_YN = 'Y') AND A.PERMANENT_FILE_AREA_YN = 'Y' and a.APPL_USER_ID='"+user_id+"'   ORDER BY 2";
				}
			}
			else
			{
				
				//sql = "SELECT   FS_LOCN_CODE, SHORT_DESC FROM FM_STORAGE_LOCN_LANG_VW WHERE    Facility_Id = '"+facility_id+"' AND EFF_STATUS = 'E' AND  PERMANENT_FILE_AREA_YN = 'Y' AND LANGUAGE_ID='"+localeName+"' ORDER BY 2";
		    	sql = "SELECT   fs_locn_code, fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"', 2 ) fs_locn_short_desc  FROM fm_storage_locn  WHERE facility_id ='"+facility_id+"'  AND fs_locn_code LIKE '%%'      AND eff_status = 'E'     AND permanent_file_area_yn = 'Y'   ORDER BY 2";
			
			}
			
			pstmt	= con.prepareStatement(sql);
			rs		= pstmt.executeQuery();
			
			while(rs != null && rs.next())
			 {
				selects++;
				String ID		= rs.getString(1);
				String desc	= rs.getString(2);
				IssueFSLocnBuffer.append("<option value='"+ID+"'>"+desc+"</option>");
			}

			%>
			<!--Below line modifed for this SCF ML-MMOH-SCF-0361 -->
			<tr>
				<td class='label' width='25%'><fmt:message key="eFM.IssueFSLocation.label" bundle="${fm_labels}"/></td>
				<td width='25%' class='fields'>
				<select name='issuetype' id='issuetype' onChange='refresh();'>
					<option value='SelectAll'>------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
					<%=IssueFSLocnBuffer.toString()%>
				</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
				</td>
				<td class='label' width='25%'><fmt:message key="Common.issuedby.label" bundle="${common_labels}"/></td>
				<td width='25%' class='fields'>
				<input type='text' size='30' maxlength='30' name='username1' id='username1' value="<%=username%>" readonly><input type='hidden' size='30' maxlength='30' name='username' id='username' value='<%=user_id%>' readonly><input type='button' name='searchuser' id='searchuser' value='?' class='button' valign='center' onClick="searchIssueFileHeaderUser(username,'<%=facility_id%>')" <%=userButtAttr%>>
			</td>
	      </tr>
	
	<%
	if((IssueFSLocnBuffer != null) && (IssueFSLocnBuffer.length() > 0))
	{
		IssueFSLocnBuffer.delete(0,IssueFSLocnBuffer.length());
	}
	
	if(rs!=null)	rs.close();
	if(pstmt!=null)	pstmt.close();

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


	<input type="hidden" name="issue_select" id="issue_select" value="N">
	<input type="hidden" name="file_doc" id="file_doc" value="<%=file_doc%>">
	<input type="hidden" name="file_type_yn" id="file_type_yn" value="<%=file_type_yn%>">
	<input type="hidden" name="print_tracer_card" id="print_tracer_card" value="<%=p_tracer_card_yn%>">
	<input type="hidden" name="file_type_appl_yn" id="file_type_appl_yn" value="<%=file_type_yn%>">
	<INPUT type="hidden" name="selected_tab" id="selected_tab" value="O" >
	<INPUT type="hidden" name="username_desc" id="username_desc" value="<%=username%>" >
	<!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014 Start-->
	<input type='hidden' name='issue_file_refresh_interval' id='issue_file_refresh_interval' value='<%=issue_file_refresh_interval%>'>	
	<!--Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014 End-->
	
</form>
<script>
	if("<%=selects%>" == 1)
	{	
		IssueFilesHeader.issuetype.options(1).selected = true;
		refresh();
	}

	function refresh() { 
	var strLocn = IssueFilesHeader.issuetype.value;
	if(strLocn == "SelectAll") 
	{ 
		parent.frames[2].location.href = '../../eCommon/html/blank.html';
		parent.frames[3].location.href = '../../eCommon/html/blank.html';
	}
	else
	{ 
		if(parent.frames[1].document.forms[0].file_doc.value=="F") 
		{
			// issue_file_refresh_interval Added For MMS-QH-CRF-0146 [IN:043836] by Dharma on Feb 18th 2014*/
			parent.frames[2].location.href = '../../eFM/jsp/FMIssueFilesTab.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&refresh=<%=refresh%>&file_doc=<%=file_doc%>&file_type_yn=<%=file_type_yn%>&access_all=<%=access_all%>&strLocn='+strLocn+'&issue_file_refresh_interval=<%=issue_file_refresh_interval%>';
			
			parent.frames[1].document.forms[0].issuetype.disabled = true;
	    } 
	    else if(parent.frames[1].document.forms[0].file_doc.value == "D") 
		{
		   parent.frames[2].location.href = '../../eFM/jsp/DTIssueFilesTab.jsp?userSecurity=<%=userSecurity%>&resLocnIdentities=<%=resLocnIdentities%>&refresh=<%=refresh%>&file_doc=<%=file_doc%>&file_type_yn=<%=file_type_yn%>&access_all=<%=access_all%>&strLocn='+strLocn;
			parent.frames[1].document.forms[0].issuetype.disabled = true;
		}
	}
}
</script>

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


