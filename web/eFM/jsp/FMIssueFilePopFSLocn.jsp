<!DOCTYPE html>
<!--
	Created On	: 1/20/2003
	Created By	: Marayan Kumar K.R.
	Module		: File Management (FM)
	Function	: Issue File Search
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	try 
	{
		con	= ConnectionManager.getConnection(request);

		String fac_id	= (String) session.getValue("facility_id");
		Properties p	= (Properties) session.getValue("jdbc");

		String addedById	= p.getProperty("login_user");
		String popmode		= request.getParameter("popmode");

		String sql	= "";
		
		if(popmode.equals("1"))
		{
			String locn_code			= request.getParameter("locn_code");
			String p_user_security_yn	= request.getParameter("userSecurity")==null?"":request.getParameter("userSecurity");
			String p_access_all			= request.getParameter("access_all")==null?"":request.getParameter("access_all");

			if(p_user_security_yn.equals("Y"))
			{
				if(p_access_all.equals("*ALL"))
				{
					//sql = "select a.fs_locn_code, a.short_desc from fm_storage_locn a  where a.eff_status='E' and a.facility_id = ? and LOCN_IDENTITY = ? order by 2";
				//	sql = "SELECT   a.fs_Locn_Code, a.Short_desc FROM FM_STORAGE_LOCN_LANG_VW a WHERE    a.eff_Status = 'E' AND a.Facility_Id =? AND LOCN_IDENTITY = ? AND LANGUAGE_ID=? ORDER BY 2  ";
			sql = "SELECT   fs_Locn_Code,fm_get_desc.fm_storage_locn (facility_id, fs_locn_code, '"+localeName+"',2 ) Short_desc FROM FM_STORAGE_LOCN a WHERE    a.eff_Status = 'E' AND a.Facility_Id =? AND LOCN_IDENTITY = ?  ORDER BY 2  ";
					
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,fac_id);
					pstmt.setString(2,locn_code);
					//pstmt.setString(3,localeName);
				}
				else
				{
					//sql = "select a.fs_locn_code, a.short_desc from fm_storage_locn a , fm_user_access_rights b where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id = ? and b.facility_id = ? and (b.req_yn='Y' or b.req_across_facilities_yn='Y' ) and LOCN_IDENTITY = ? order by 2";
					sql = "SELECT a.fs_Locn_Code,fm_get_desc.fm_storage_locn (a.facility_id, a.fs_locn_code, '"+localeName+"',2 ) Short_desc FROM FM_STORAGE_LOCN  a, fm_User_Access_Rights b WHERE a.eff_Status = 'E' AND a.Facility_Id = b.Facility_Id AND a.fs_Locn_Code = b.fs_Locn_Code AND b.apPl_User_Id = ? AND b.Facility_Id = ? AND (b.req_yn = 'Y' OR b.req_Across_faciLities_yn = 'Y') AND LOCN_IDENTITY = ?   ORDER BY 2";
					if(pstmt!=null) pstmt.close();
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1,addedById);
					pstmt.setString(2,fac_id);
					pstmt.setString(3,locn_code);
					//pstmt.setString(4,localeName);
				}
			}
			else
			{
				//sql = "select a.fs_locn_code, a.short_desc from fm_storage_locn a,fm_parameter b where a.eff_status='E' and a.facility_id = ? and a.facility_id=b.facility_id and a.fs_locn_code not in (b.dflt_archive_fs_locn_code,b.dflt_lost_fs_locn_code) and LOCN_IDENTITY = ? order by 2";
				sql = "SELECT a.fs_Locn_Code,fm_get_desc.fm_storage_locn (a.facility_id, a.fs_locn_code, '"+localeName+"',2 ) Short_desc FROM FM_STORAGE_LOCN a, fm_Parameter b WHERE a.eff_Status = 'E' AND a.Facility_Id = ? AND a.Facility_Id = b.Facility_Id AND a.fs_Locn_Code NOT IN (b.dflt_Archive_fs_Locn_Code, b.dflt_Lost_fs_Locn_Code) AND LOCN_IDENTITY = ? ORDER BY 2";
				if(pstmt!=null) pstmt.close();
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,fac_id);
				pstmt.setString(2,locn_code);
			//	pstmt.setString(3,localeName);
			}
		
			rs  = pstmt.executeQuery();
			if(rs != null) 
			{
				%>
				<SCRIPT>
					var len = parent.issue_tab.document.FileIsuueTab.fs_locn_name.length;
					for(var i=0; i<=len; i++)
					{
						parent.issue_tab.document.FileIsuueTab.fs_locn_name.remove("fs_locn_name");
					}
					var opt	= parent.issue_header.document.createElement('OPTION');
					opt.value =	"";
					opt.text = "----------"+getLabel("Common.defaultSelect.label","common")+"----------";
					parent.issue_tab.document.FileIsuueTab.fs_locn_name.add(opt);
				</SCRIPT>
				<%
				while(rs != null && rs.next()) 
				{
					%>
					<SCRIPT>
						var opt	= parent.issue_tab.document.createElement('OPTION');
						opt.value =	"<%= rs.getString("fs_locn_code") %>";
						opt.text = "<%= rs.getString("short_desc")%>";
						parent.issue_tab.document.FileIsuueTab.fs_locn_name.add(opt);
					</SCRIPT>
					<%
				}
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();
		}
		if(popmode.equals("2"))
		{
			String storage_location	= request.getParameter("storage_location");
			sql = "";
			sql  = "SELECT a.NARRATION_CODE FROM FM_STORAGE_LOCN a , FM_NARRATION b WHERE  a.FS_LOCN_CODE = ? and a.facility_id = ? and a.narration_code=b.narration_code and b.eff_status = 'E' ";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,storage_location);
			pstmt.setString(2,fac_id);

			while(rs != null && rs.next()) 
			{
				%>
				<SCRIPT>
					parent.issue_tab.document.FileIsuueTab.fs_narration.value="<%= rs.getString( "NARRATION_CODE" ) %>";
				</SCRIPT>
				<%
			}
		}

		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
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
<SCRIPT>
					parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num=";
</SCRIPT>

