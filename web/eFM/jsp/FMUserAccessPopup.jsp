<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con			= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;

	try 
	{
		con = ConnectionManager.getConnection(request);
		stmt = con.createStatement();

		String facilityid	= (String) session.getValue("facility_id");
		String locn_code	= request.getParameter("locn_code");

		String sql	= "SELECT A.FS_LOCN_CODE,A.SHORT_DESC,A.LOCN_IDENTITY FROM FM_STORAGE_LOCN A ,FM_PARAMETER B WHERE A.EFF_STATUS='E' AND A.FACILITY_ID='"+facilityid+"' AND A.FACILITY_ID=B.FACILITY_ID AND A.FS_LOCN_CODE NOT IN (B.DFLT_ARCHIVE_FS_LOCN_CODE,B.DFLT_LOST_FS_LOCN_CODE) AND A.LOCN_IDENTITY = DECODE('"+locn_code+"','P','D','"+locn_code+"') AND PERMANENT_FILE_AREA_YN = DECODE('"+locn_code+"','P','Y', 'D','N', A.PERMANENT_FILE_AREA_YN)  order by A.SHORT_DESC";
		rs  = stmt.executeQuery(sql) ;

		%>
		<SCRIPT>
			var len = parent.f_query_add_mod.fm_user_access_form.storage_location.length;
			for (var i=0; i<=len; i++) 
			{
				parent.f_query_add_mod.fm_user_access_form.storage_location.remove("storage_location");
			}
			var opt	= parent.frames[1].document.createElement('OPTION');
			opt.value =	"";
			opt.text = "        --- "+getLabel('Common.defaultSelect.label','common')+" ---        ";
			parent.f_query_add_mod.fm_user_access_form.storage_location.add(opt);
		</SCRIPT>
		<SCRIPT>
			var fs_locn_codes='';
			<%
			if(rs != null) 
			{
				while(rs.next())
				{
					%>
					var opt	= parent.frames[1].document.createElement('OPTION');
					opt.value =	"<%= rs.getString("fs_locn_code") %>";
					opt.text = "<%= rs.getString("short_desc")%>";
					parent.f_query_add_mod.fm_user_access_form.storage_location.add(opt);
					
					fs_locn_codes = fs_locn_codes + "|" + opt.value;
					<%
				}
			}
			%>
			parent.f_query_add_mod.fm_user_access_form.all_fs_locn_codes.value = fs_locn_codes;
	</SCRIPT>
<%
	if(rs!=null)	rs.close();
	if(stmt!=null) stmt.close();	
}
catch(Exception e)
{
	out.println("Exception e :"+e.toString());
}
finally 
{		
	ConnectionManager.returnConnection(con,request);
}
%>
<SCRIPT>
	parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp";
</SCRIPT>

