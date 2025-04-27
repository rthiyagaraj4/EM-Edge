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
			Connection con = ConnectionManager.getConnection(request);
			Statement stmt		=	null;
			ResultSet rs		=	null;
			stmt				=	con.createStatement();

			java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;
			String addedById	= p.getProperty( "login_user" ) ;
			String facilityid 	= (String) session.getValue("facility_id");
			

			String p_new_status	= request.getParameter("p_new_status");		
			String sql			=	"";
			String p_code		=	"";
			String p_desc		=	"";
			String p_user_security_yn = "";
try
{

if (p_new_status.equals("O") || p_new_status.equals("I"))
{

	sql = "select user_security_yn from fm_parameter where facility_id='"+facilityid+"' ";

	rs  = stmt.executeQuery(sql);

	while (rs.next())
	{
		p_user_security_yn	= rs.getString("user_security_yn");
	}
	if (rs!=null) rs.close();
	
	if (p_user_security_yn.equals("Y"))
	{
		if (p_new_status.equals("I"))
		{
			//sql = "select a.fs_locn_code,a.short_desc long_desc from fm_storage_locn a , fm_user_access_rights b,fm_parameter c where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id='"+addedById+"' and b.facility_id='"+facilityid+"' and a.mr_locn_yn='Y' and a.facility_id=c.facility_id and a.fs_locn_code != c.dflt_lost_fs_locn_code and a.fs_locn_code != c.dflt_archive_fs_locn_code order by 2	";
			sql = "SELECT a.fs_Locn_Code,  a.Short_desc Long_desc FROM FM_STORAGE_LOCN_LANG_VW a,  fm_User_Access_Rights b,  fm_Parameter c WHERE  a.eff_Status = 'E'  AND A.LANGUAGE_ID='"+localeName+"'  AND a.Facility_Id = b.Facility_Id  AND a.fs_Locn_Code = b.fs_Locn_Code  AND b.apPl_User_Id = '"+addedById+"'  AND b.Facility_Id = '"+facilityid+"'  AND a.mr_Locn_yn = 'Y'  AND a.Facility_Id = c.Facility_Id  AND a.fs_Locn_Code != c.dflt_Lost_fs_Locn_Code  AND a.fs_Locn_Code != c.dflt_Archive_fs_Locn_Code ORDER BY 2	";
		}
		else
		{
			//sql = "select a.fs_locn_code,a.short_desc long_desc from fm_storage_locn a , fm_user_access_rights b ,fm_parameter c where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id='"+addedById+"' and b.facility_id='"+facilityid+"' and a.mr_locn_yn <> 'Y' and a.facility_id=c.facility_id and a.fs_locn_code != c.dflt_lost_fs_locn_code and a.fs_locn_code != c.DFLT_ARCHIVE_FS_LOCN_CODE  order by 2	";
			sql = "SELECT a.fs_Locn_Code,  a.Short_desc Long_desc FROM FM_STORAGE_LOCN_LANG_VW a,  fm_User_Access_Rights b,  fm_Parameter c WHERE a.eff_Status = 'E'  AND A.LANGUAGE_ID='"+localeName+"'  AND a.Facility_Id = b.Facility_Id  AND a.fs_Locn_Code = b.fs_Locn_Code  AND b.apPl_User_Id = '"+addedById+"'  AND b.Facility_Id = '"+facilityid+"'  AND a.mr_Locn_yn <> 'Y'  AND a.Facility_Id = c.Facility_Id  AND a.fs_Locn_Code != c.dflt_Lost_fs_Locn_Code  AND a.fs_Locn_Code != c.DFLT_ARCHIVE_FS_LOCN_CODE ORDER BY 2	";
		}
	}
	else
	{
		//sql = "select a.fs_locn_code,a.short_desc long_desc from fm_storage_locn a where a.eff_status='E' and a.facility_id='"+facilityid+"' order by 2";
		sql = "SELECT a.fs_Locn_Code,  a.Short_desc Long_desc FROM FM_STORAGE_LOCN_LANG_VW a WHERE a.eff_Status = 'E'  AND A.LANGUAGE_ID='"+localeName+"'  AND a.Facility_Id = '"+facilityid+"' ORDER BY 2";
	}
}
else if (p_new_status.equals("L"))
{
	//sql = " select a.dflt_lost_fs_locn_code fs_locn_code,b.short_desc long_desc  from fm_parameter a,fm_storage_locn b where a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and  a.dflt_lost_fs_locn_code=b.fs_locn_code ";	
	sql = "SELECT a.dflt_Lost_fs_Locn_Code fs_Locn_Code,  b.Short_desc Long_desc FROM fm_Parameter a,  FM_STORAGE_LOCN_LANG_VW b WHERE a.Facility_Id = '"+facilityid+"'  AND a.Facility_Id = b.Facility_Id  AND a.dflt_Lost_fs_Locn_Code = b.fs_Locn_Code  AND B.LANGUAGE_ID='"+localeName+"' ";	

}
else if (p_new_status.equals("A"))
{
	//sql = " select a.dflt_archive_fs_locn_code fs_locn_code ,b.short_desc long_desc  from fm_parameter a,fm_storage_locn b where a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and a.dflt_archive_fs_locn_code=b.fs_locn_code ";	
	sql = "SELECT a.dflt_Archive_fs_Locn_Code fs_Locn_Code,  b.Short_desc Long_desc FROM fm_Parameter a,  FM_STORAGE_LOCN_LANG_VW b WHERE a.Facility_Id = '"+facilityid+"'  AND a.Facility_Id = b.Facility_Id  AND a.dflt_Archive_fs_Locn_Code = b.fs_Locn_Code  AND B.LANGUAGE_ID='"+localeName+"'";	
}
else if ((p_new_status.equals("F")) || (p_new_status.equals("R")) )
{
	//sql = "select a.fs_locn_code fs_locn_code, a.short_desc long_desc from fm_storage_locn a, fm_parameter b where a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and a.eff_status='E' and a.fs_locn_code <> b.dflt_archive_fs_locn_code and a.fs_locn_code <> b.dflt_lost_fs_locn_code";	
	sql = "SELECT a.fs_Locn_Code fs_Locn_Code,  a.Short_desc Long_desc FROM FM_STORAGE_LOCN_LANG_VW a,  fm_Parameter b WHERE a.Facility_Id = '"+facilityid+"'  AND a.Facility_Id = b.Facility_Id  AND a.eff_Status = 'E'  AND A.LANGUAGE_ID='"+localeName+"'  AND a.fs_Locn_Code <> b.dflt_Archive_fs_Locn_Code  AND a.fs_Locn_Code <> b.dflt_Lost_fs_Locn_Code";	
}
	rs = stmt.executeQuery(sql);

	if(rs != null)
	{

	while (rs.next())
	{
		p_code	= rs.getString("fs_locn_code");
		p_desc	= rs.getString("long_desc");


%>
		<script>
				var temp = "<%=p_code%>";
				var temp1="<%=p_desc%>";
				var opt=parent.frames[3].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.frames[3].document.forms[0].p_fs_location1.add(opt);
				if('<%=p_new_status%>' == 'L' || '<%=p_new_status%>' == 'A' )
				{
					parent.frames[3].document.forms[0].p_fs_location1.options[1].selected = true;
					
				}
				else
				{
					parent.frames[3].document.forms[0].p_fs_location1.disabled = false;
				}
				var errors = '' ;		

		</script>

<%
	}
 }
if (rs!=null) rs.close();
if (stmt!=null) stmt.close();
}
catch (Exception e)
{}
finally
{
	ConnectionManager.returnConnection(con,request);
}
%>
</body>
</html>

