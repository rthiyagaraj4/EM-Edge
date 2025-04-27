<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,eDR.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/FMLostFound.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<%
	Connection con				= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	ResultSet rs				= null;
	
	String facilityid 	= (String) session.getValue("facility_id");	
	String locn_code	= request.getParameter("locn_code");		
	String sql			= "";
		
	try
	{
		stmt	=	con.createStatement();

		//sql = "select a.fs_locn_code fs_locn_code, a.short_desc long_desc from fm_storage_locn a, fm_parameter b where a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and a.eff_status='E' and a.fs_locn_code <> b.dflt_archive_fs_locn_code and a.fs_locn_code <> b.dflt_lost_fs_locn_code and a.locn_identity = '"+locn_code+"'order by 2";
		sql = "SELECT a.fs_Locn_Code fs_Locn_Code,  a.Short_desc Long_desc FROM FM_STORAGE_LOCN_LANG_VW a,  fm_Parameter b WHERE a.Facility_Id = '"+facilityid+"'  AND A.LANGUAGE_ID='"+localeName+"'  AND a.Facility_Id = b.Facility_Id  AND a.eff_Status = 'E'  AND a.fs_Locn_Code <> b.dflt_Archive_fs_Locn_Code  AND a.fs_Locn_Code <> b.dflt_Lost_fs_Locn_Code  AND a.Locn_Identity = '"+locn_code+"' ORDER BY 2";

			
		rs = stmt.executeQuery(sql);
		if(rs != null)
		{
		%>
			<SCRIPT>
				var len = parent.frames[3].fm_change_status_lost_found.p_fs_location.length;
				for (var i=0; i<=len; i++) {
					parent.frames[3].fm_change_status_lost_found.p_fs_location.remove("p_fs_location");
				}
				var opt	= parent.frames[3].fm_change_status_lost_found.document.createElement('OPTION');
				opt.value =	"";
				opt.text = "        ---"+getLabel("Common.defaultSelect.label","common")+"---        ";
				parent.frames[3].fm_change_status_lost_found.p_fs_location.add(opt);

			</SCRIPT>
			<%
			while(rs.next())
			{
				%>
				<script>
					var opt=parent.frames[3].document.createElement("OPTION");
					opt.value = "<%=rs.getString("fs_locn_code")%>";
					opt.text="<%=rs.getString("long_desc")%>";
					parent.frames[3].document.forms[0].p_fs_location.add(opt);
				</script>
				<%
			}
		}
		if(rs!=null) rs.close();
		if(stmt!=null) stmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e :"+e);
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
	%>
</body>
</html>

