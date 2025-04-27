<!DOCTYPE html>
<%@ page import ="java.sql.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
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
	<script src='../../eIP/js/IPQueryCommon.js' language='javascript'></script>
	<script src='../../eFM/js/FMFileDeficiencyMonitoring.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body OnMouseDown="CodeArrest()" onKeyDown = 'lockKey();' onLoad="encounter_disable();">
	<form name='FileDeficiencyMonitoring_header' id='FileDeficiencyMonitoring_header'>
		<table border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
		<%
		Connection con			= ConnectionManager.getConnection(request);
		PreparedStatement pstmt	= null;
		ResultSet rs			= null;
		
		String facility_id		= (String) session.getValue("facility_id");
		String user_id			= (String) session.getValue("login_user");
		
		String userSecurity  = request.getParameter("userSecurity")==null?"N":request.getParameter("userSecurity");
		String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
		//String dflt_incomplete_fs_locn_code = request.getParameter("dflt_incomplete_fs_locn_code")==null?"":request.getParameter("dflt_incomplete_fs_locn_code"); checkstyle changes for 35865
		String mntr_fldfcy_inc_fslocn_ntdf_yn = request.getParameter("mntr_fldfcy_inc_fslocn_ntdf_yn")==null?"":request.getParameter("mntr_fldfcy_inc_fslocn_ntdf_yn");
		
        String sql_query="";		
		StringBuffer FSLocationBuffer	= null;		
		FSLocationBuffer				= new StringBuffer();
		String ID="";

		int x	= 0;
		
		try
		{

	if (mntr_fldfcy_inc_fslocn_ntdf_yn.equals("N"))
			{
		  /*Query Modified by Senthil on 3-oct-2011 for this incident[IN:029134]*/	
		sql_query="SELECT a.FS_LOCN_CODE , a.SHORT_DESC FROM FM_STORAGE_LOCN_LANG_VW a , fm_Parameter b WHERE a.Facility_Id = '"+facility_id+"' AND a.EFF_STATUS = 'E' AND A.LANGUAGE_ID='"+localeName+"' AND a.Facility_Id = b.Facility_Id AND b.DFLT_INCOMPLETE_FS_LOCN_CODE = a.FS_LOCN_CODE ORDER BY 2";
			} else{
		if(userSecurity.equals("Y"))
		{
			if (!access_all.equals(""))
			{
         /*Query Modified and above if condtion changed by Senthil on 3-oct-2011 for this incident[IN:029134] */	
				sql_query="SELECT a.FS_LOCN_CODE , (CASE WHEN A.FS_LOCN_CODE = '*ALL' THEN '*ALL' ELSE B.SHORT_DESC END) SHORT_DESC FROM FM_USER_ACCESS_RIGHTS_VW A , FM_STORAGE_LOCN_LANG_VW B , fm_Parameter c WHERE A.FACILITY_ID = B.FACILITY_ID(+)AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) AND a.Facility_Id = c.Facility_Id AND c.DFLT_INCOMPLETE_FS_LOCN_CODE = a.FS_LOCN_CODE AND a.Facility_Id = '"+facility_id+"' AND a.apPl_User_Id = '"+user_id+"' AND a.DEFICIENCY_CHECK_YN = 'Y' AND B.LANGUAGE_ID='"+localeName+"' ORDER BY 2";
				
		  }
	     }

			}
		
		pstmt = con.prepareStatement(sql_query);
		rs = pstmt.executeQuery();
		while(rs != null && rs.next())
		{
			x++;
			ID	= rs.getString(1);
			String desc	= rs.getString(2);
			FSLocationBuffer.append("<option value='"+ID+"'>"+desc+"</option>");
		}
			
		%>
		<%if (mntr_fldfcy_inc_fslocn_ntdf_yn.equals("Y")) { %>
		<input type='hidden' name="cuurfslocn" id="cuurfslocn" value=''>
        <%}else{%>
		<tr><td class='label' width="25%"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
		<td class='fields' colspan='3'><select name='cuurfslocn' id='cuurfslocn' onChange='clearvalues(this.value);'>
		<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option> 
		<%=FSLocationBuffer.toString()%>
		</select>
		</td>
		</tr>
		<%}%>
		</tr><td colspan="4">
		<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="frame_name" value="parent.deficiency_header"/>
				<jsp:param name="form_name" value="FileDeficiencyMonitoring_header"/>
				<jsp:param name="messageframe_name" value="parent.messageFrame"/>
				<jsp:param name="patientid_name" value="patient_id"/>
				<jsp:param name="fileno_name" value="file_no"/>
				<jsp:param name="filetype_name" value="file_type_code"/>
				<jsp:param name="volumeno_name" value="volume_no"/>
				<jsp:param name="table_width" value="100"/>
				<jsp:param name="tablealign" value="center"/>
				<jsp:param name="volume_mandatory_yn" value="Y"/>
				<jsp:param name="locn_code" value="f_curr_fs_locn"/>
				<jsp:param name="cuurfslocn" value='<%=ID%>'/>
				<jsp:param name="function_name" value="FileDeficiencyMonitoring"/>

			</jsp:include></td>
		<tr>
			<td class='label' width='25%' ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class='fields' width='25%' ><input type='text'  size='12'  maxlength='12' name='encounter_id' id='encounter_id' onKeyPress="return allowValidNumber(this,event,12,0)" onBlur="validSplchars1(this);CheckNum(this);checkEncounter(this);"><input type="button" name='encounter_id_search' id='encounter_id_search' value="?" class="button" onclick="callSearchScreen1('E');"><img src='../../eCommon/images/mandatory.gif' align='center'></img></td>
			<td class='button' colspan="4" align="right"><input type='button' class='button' name='search' id='search' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='searchData();'></td>
			<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
		</tr>
		<%		
		if((FSLocationBuffer != null) && (FSLocationBuffer.length() > 0))
		{
			FSLocationBuffer.delete(0,FSLocationBuffer.length());
		}
	if(rs!=null)	rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){
	e.printStackTrace();
	}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
</table>
<script>
if ('<%=mntr_fldfcy_inc_fslocn_ntdf_yn%>'!='Y')
	{
		if(<%=x%> == 1)
		{
			parent.frames[1].document.forms[0].cuurfslocn.options[1].selected = true;
		}
		else if(<%=x%> == 0)
		{
			alert(getMessage("PERM_LOCN_TO_BE_SPECIFIED","FM")); 
			parent.parent.frames[2].location.href='../../eCommon/jsp/dmenu.jsp'; 
		}
	}
</script>
<input type='hidden' name="userSecurity" id="userSecurity" value='<%=userSecurity%>'>
<input type='hidden' name="access_all" id="access_all" value='<%=access_all%>'>
<input type='hidden' name="mntr_fldfcy_inc_fslocn_ntdf_yn" id="mntr_fldfcy_inc_fslocn_ntdf_yn" value='<%=mntr_fldfcy_inc_fslocn_ntdf_yn%>'>
	<input type='hidden' name='flagadd' id='flagadd' value=''>
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

