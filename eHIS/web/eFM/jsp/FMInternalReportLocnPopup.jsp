<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.* "  contentType="text/html; charset=UTF-8" %>
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
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>
	
</head>
<body class='message' onKeyDown = 'lockKey()'>



<%
			Connection con		=	null;
			Statement stmt		=	null;
			ResultSet rs		=	null;
	try
{			con		= ConnectionManager.getConnection(request);
			stmt	= con.createStatement();
		//	java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" ) ;	
			String facilityid 	= (String) session.getValue("facility_id");
			String locn_code	= request.getParameter("locn_code");		
			String sql			=	"";			

sql = "select a.fs_locn_code fs_locn_code, a.short_desc long_desc from fm_storage_locn_lang_vw a, fm_parameter b where a.facility_id='"+facilityid+"' and a.facility_id=b.facility_id and a.eff_status='E' and a.fs_locn_code <> b.dflt_archive_fs_locn_code and a.fs_locn_code <> b.dflt_lost_fs_locn_code and a.locn_identity = '"+locn_code+"' and a.language_id='"+localeName+"' order by 2";

	rs = stmt.executeQuery(sql);
	if(rs != null)
	{
%>
	<SCRIPT>
		var len = parent.frames[2].document.forms[0].fs_locn_code.length;
		for (var i=0; i<=len; i++) {
			parent.frames[2].document.forms[0].fs_locn_code.remove("fslocation");
		}
		var opt	= parent.frames[2].document.forms[0].document.createElement('OPTION');
		opt.value =	"";
		opt.text = "        --- "+getLabel('Common.defaultSelect.label','common')+" ---        ";
		parent.frames[2].document.forms[0].fs_locn_code.add(opt);

	</SCRIPT>
<%

	while (rs.next())
	{
%>
	<script>
		var opt=parent.frames[2].document.createElement("OPTION");
		opt.value = "<%=rs.getString("fs_locn_code")%>";
		opt.text="<%=rs.getString("long_desc")%>";
		parent.frames[2].document.forms[0].fs_locn_code.add(opt);
	
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

