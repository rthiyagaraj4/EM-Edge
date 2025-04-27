<!DOCTYPE html>

<%@ page import="java.util.*, java.sql.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%
	String facility_id="", user_id="", fs_locn_code="", fs_locn_desc="";
	String user_name="";
	Connection con	=	null;
	java.sql.Statement stmt	=	null;
	ResultSet rs	=	null;

	java.sql.Statement stmt2	=	null;
	ResultSet rs2	=	null;		
	
	try
	{
		con			=	ConnectionManager.getConnection(request);
		facility_id	=	(String)session.getValue("facility_id");
		user_id		=	(String)session.getValue("login_user");
	//	stmt		=	con.createStatement();

		String user_security_yn  = request.getParameter("user_security_yn")==null?"N":request.getParameter("user_security_yn");
		String access_all  = request.getParameter("access_all")==null?"N":request.getParameter("access_all");

		String fs_locn_query = "";
		if(user_security_yn.equals("Y"))
		{
			
			if (access_all.equals("*ALL"))
			{
				//fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
				fs_locn_query="SELECT   fs_Locn_Code,fm_get_desc.fm_storage_locn (facility_id,fs_Locn_Code,'"+localeName+"',2 ) fs_Locn_desc FROM FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"' AND eff_Status = 'E' AND PERMANENT_FILE_AREA_YN = 'Y'  ORDER BY 2";
			}
			else
			{
				//fs_locn_query="SELECT fs_locn_code, fs_locn_short_desc fs_locn_desc FROM fm_user_access_rights_vw WHERE facility_id = '"+facility_id+"' AND appl_user_id='"+user_id+"'  AND TRACK_OUT_TO_OPD='Y' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
				/*fs_locn_query = "SELECT"
							  +"  a.fs_Locn_Code"
							  +"  , ("
							  +"  CASE "
							  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
							  +"  THEN"
							  +"    '*ALL' "
							  +"  ELSE B.SHORT_DESC "
							  +"  END) fs_Locn_desc "
							  +"FROM"
							  +"  FM_USER_ACCESS_RIGHTS_VW A"
							  +"  , FM_STORAGE_LOCN_LANG_VW B "
							  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
							  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
							  +"  AND A.Facility_Id = '"+facility_id+"' "
							  +"  AND A.apPl_User_Id = '"+user_id+"' "
							  +"  AND A.TRACK_OUT_TO_OPD = 'Y' "
							  +"  AND A.PERMANENT_FILE_AREA_YN = 'Y' "
							  +"  AND B.LANGUAGE_ID='"+localeName+"' "
							  +"ORDER BY 2";*/
						fs_locn_query="SELECT"
						  +"  A.FS_LOCN_CODE,"
						  +"  DECODE"
						  +"  (a.fs_locn_code,"
						  +"   '*ALL', '*ALL',"
						  +"  fm_get_desc.fm_storage_locn(a.facility_id, "
						  +"   a.fs_locn_code, "
						  +" '"+localeName+"', "
						  +"  '2') ) fs_locn_short_desc, "
						  +"   A.LOCN_IDENTITY"
						  +"  , A.MR_LOCN_YN "
						  +"  FROM"
						  +"  FM_USER_ACCESS_RIGHTS_VW A"			
						  +"  WHERE A.FACILITY_ID = '"+facility_id+"' "
						  +"  AND A.APPL_USER_ID = '"+user_id+"' "
						  +"  AND A.TRACK_OUT_TO_IPW = 'Y' "
						  +"  AND A.PERMANENT_FILE_AREA_YN = 'Y' "
						  +"ORDER BY"
						  +"  2 ";
			}
		}
		else
		{
			//fs_locn_query="SELECT fs_locn_code, short_desc fs_locn_desc FROM fm_storage_locn WHERE facility_id = '"+facility_id+"' AND eff_status='E' AND PERMANENT_FILE_AREA_YN = 'Y' Order by 2";
			fs_locn_query="SELECT   fs_Locn_Code,fm_get_desc.fm_storage_locn (facility_id,fs_Locn_Code,'"+localeName+"',2 ) fs_Locn_desc FROM FM_STORAGE_LOCN WHERE Facility_Id = '"+facility_id+"' AND eff_Status = 'E' AND PERMANENT_FILE_AREA_YN = 'Y'   ORDER BY 2";
		}
	%>
<html>
	<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
		
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eFM/js/FMIPGeneratePullList.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onLoad="FocusFirstElement()"onMouseDown='CodeArrest()' onKeyDown = 'lockKey();'>
	<form name='FMGenPullListCriteriaForm' id='FMGenPullListCriteriaForm'>
	<table cellpadding='0' cellspacing='0' width='100%' border='0' align='center'>
	 <tr><td colspan='4'>&nbsp;<td></tr> 
	<tr>
	<%
			if(stmt != null) stmt=null;
			stmt =	con.createStatement();
			//String appl_str ="select appl_user_name from sm_appl_user where appl_user_id = '"+user_id+"'";
			String appl_str ="select appl_user_name from sm_appl_user_lang_vw where appl_user_id = '"+user_id+"' and LANGUAGE_ID='"+localeName+"'";

			rs = stmt.executeQuery(appl_str);
			while(rs!=null && rs.next())
			{
	         user_name = rs.getString(1);
			}
			if(rs != null)		rs.close();		
	%>
	<td class='label' width='25%'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
		<td class='fields' width='25%'><select name='fs_locn_code' id='fs_locn_code' onChange='fetchResult(this);'><option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
		<%
			rs = stmt.executeQuery(fs_locn_query);
			int count=0;
			while(rs.next())
			{
				count++;
				fs_locn_code	=	rs.getString(1);
				fs_locn_desc	=	rs.getString(2);

				if(fs_locn_code == null)fs_locn_code="";
				if(fs_locn_desc == null)fs_locn_desc="";
					
				out.println("<option value="+fs_locn_code+" >"+fs_locn_desc+"</option>");
			}
		%>
		</select><img align='center' src='../../eCommon/images/mandatory.gif'></img></td>
		<td class='label' width='25%'><fmt:message key="eFM.GeneratedBy.label" bundle="${fm_labels}"/></td>
		<td class='fields' width='25%'>
		<%
			if(user_security_yn.equals("Y"))
			{
		%>
				<input type='text' name='appl_user_name' id='appl_user_name' value="<%=user_name%>" size='30' maxlength=60 disabled readonly><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=user_id%>' size='40' maxlength=30 ><input type=button name=searchcode id=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facility_id%>',appl_user_name);" disabled></td>
		<%
			}
			else
			{
	
		%>
				<input type='text' name='appl_user_name' id='appl_user_name' value="<%=user_name%>" readonly size='30' maxlength=60><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=user_id%>' readonly size='40' maxlength=30><input type=button name=searchcode id=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facility_id%>',appl_user_name)"></td>
		<%
			}
		%>
	</tr>
	<tr><td colspan='4'>&nbsp;<td></tr>
	</table>
		<script>

		var val = '<%=fs_locn_code%>';

		if ('<%=count%>'==1)
		{
		document.forms[0].fs_locn_code.value = '<%=fs_locn_code%>';
		parent.frames[1].location.href="../../eFM/jsp/FMIPGeneratePullListResult.jsp?fs_locn_code="+val;
		parent.frames[2].location.href="../../eFM/jsp/FMIPGeneratePullListNote.jsp";

		}

		</script>
	</form>
	</body>
</html>
	
<%
	if(rs != null)		rs.close();
	if(stmt != null)	stmt.close();
	if(rs2 != null)		rs2.close();
	if(stmt2 != null)	stmt2.close();
	}
	catch(Exception e)
	{
		out.println("Exception in main try"+e);
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

