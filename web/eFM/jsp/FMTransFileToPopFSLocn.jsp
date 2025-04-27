<!DOCTYPE html>
<!--
	Created On	: 1/20/2003
	Created By	: Marayan Kumar K.R.
	Module		: File Management (FM)
	Function	: Request File
-->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/common.js'></script>

<%
	request.setCharacterEncoding("UTF-8");
	Connection con			= ConnectionManager.getConnection(request);
	PreparedStatement pstmt	= null;
	ResultSet rs			= null;
	String facility_id	= (String) session.getValue("facility_id");
	
	String sql			= "";

	String Dflt_Archive_Locn	= request.getParameter("Dflt_Archive_Locn");
	String Dflt_Lost_Locn		= request.getParameter("Dflt_Lost_Locn");
	String from_locn_code		= request.getParameter("From_locn_code");
	String returning_desc		= request.getParameter("returning_desc");
	String from_fs_locn_id  = request.getParameter("from_fs_locn_id");
	String locn_code 			= request.getParameter("locn_code");
 	if(from_locn_code == null || from_locn_code.equals("null")) from_locn_code = "NOTDEFINED";
	if(returning_desc == null || returning_desc.equals("null")) returning_desc = "";
	if(Dflt_Archive_Locn == null || Dflt_Archive_Locn.equals("null")) Dflt_Archive_Locn = "";
	if(Dflt_Lost_Locn == null || Dflt_Lost_Locn.equals("null")) Dflt_Lost_Locn = "";
	if(locn_code == null || locn_code.equals("null")) locn_code = "";
	if(from_fs_locn_id == null || from_fs_locn_id.equals("null")) from_fs_locn_id = "";
	try 
	{
		if(!(from_locn_code.equals("NOTDEFINED")) && (!(returning_desc.equals("")) || from_fs_locn_id.equals("D") ))
		{
			sql = "SELECT FS_LOCN_CODE ,fm_get_desc.fm_storage_locn (facility_id,fs_locn_code,'"+localeName+"',2 ) SHORT_DESC FROM FM_STORAGE_LOCN   WHERE Facility_Id = ?  AND LOCN_IDENTITY = ?   AND EFF_STATUS = 'E' and LOCN_IDENTITY in ('C','N','T','E','Y','D') AND (FS_LOCN_CODE != ?  AND FS_LOCN_CODE != ?  AND FS_LOCN_CODE != ?)   ORDER BY   2 ";
	
			
			
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locn_code);
			pstmt.setString(3,from_locn_code);
			pstmt.setString(4,Dflt_Archive_Locn);
			pstmt.setString(5,Dflt_Lost_Locn);
			rs	= pstmt.executeQuery();

			%>
			<SCRIPT>
				var len = parent.frames[2].document.forms[0].tofslocn.length;
				for(var i=0; i<=len; i++) 
				{
					parent.frames[2].document.forms[0].tofslocn.remove("tofslocn");
				}
				var opt		= parent.frames[2].document.createElement('OPTION');
				opt.value	= "";
				opt.text	= "      ----- "+getLabel('Common.defaultSelect.label','common')+" -----      ";
				parent.frames[2].document.forms[0].tofslocn.add(opt);
			</SCRIPT>
			<%
			while(rs != null && rs.next()) 
			{
				%>
				<SCRIPT>
					var opt	= parent.frames[2].document.createElement('OPTION');
					opt.value =	"<%= rs.getString("fs_locn_code") %>";
					opt.text = "<%= rs.getString("short_desc")%>";
					parent.frames[2].document.forms[0].tofslocn.add(opt);
				</SCRIPT>
			<%
			}
		}
	if(rs!=null) rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("Exception e:"+e);}
	finally
	{			
			ConnectionManager.returnConnection(con,request);		
	}
%>
<SCRIPT>
	parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp";
</SCRIPT>

