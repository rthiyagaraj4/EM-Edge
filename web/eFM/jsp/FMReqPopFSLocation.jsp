<!DOCTYPE html>
<!--
	Created On	: 1/20/2003
	Created By	: Narayan Kumar K.R.
	Module		: File Management (FM)
	Function	: Request File
-->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;	
	java.sql.Statement stmt2	= null;	
	ResultSet rs2				= null;

	try 
	{
		con		= ConnectionManager.getConnection(request);
		stmt2	= con.createStatement();

		String fac_id  				= (String) session.getValue("facility_id"); 
		Properties p				= (Properties) session.getValue("jdbc");
		String addedById			= p.getProperty("login_user");
		
		String locn_code			= request.getParameter("locn_code");
		String p_user_security_yn	= request.getParameter("p_user_security_yn");
		String p_access_all			= request.getParameter("p_access_all");
				
		String sql2					= "";		
		
		if(!(locn_code.equals(""))) 
		{			
			if(p_user_security_yn.equals("Y")) 
			{
				if(p_access_all.equals("*ALL")) 
				{
					//sql2 = "select a.fs_locn_code, a.short_desc from fm_storage_locn a  where a.eff_status='E' and a.facility_id='"+fac_id+"' and LOCN_IDENTITY='"+locn_code+"' order by 2";
					 sql2 = "SELECT"
							  +"   a.fs_Locn_Code"
							  +"   ,fm_get_desc.fm_storage_locn (a.facility_id, a.fs_locn_code, '"+localeName+"',2 ) Short_desc "
							  +"FROM"
							  +"   FM_STORAGE_LOCN a "
							  +"WHERE a.eff_Status = 'E' "
							//  +"   AND A.LANGUAGE_ID='"+localeName+"' "
							  +"   AND a.Facility_Id = '"+fac_id+"' "
							  +"   AND LOCN_IDENTITY = '"+locn_code+"' "
							  +"ORDER BY"
							  +"   2";
				}
				else 
				{
					//sql2 = "select a.fs_locn_code, a.short_desc from fm_storage_locn a , fm_user_access_rights b where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code  and b.facility_id='"+fac_id+"' and (b.req_yn='Y' or b.req_across_facilities_yn='Y' ) and LOCN_IDENTITY='"+locn_code+"' and b.appl_user_id='"+addedById+"' order by 2";
					sql2 = "SELECT"
							  +"   a.fs_Locn_Code"
							  +"   ,fm_get_desc.fm_storage_locn (a.facility_id, a.fs_locn_code, '"+localeName+"',2 )  Short_desc "
							  +"FROM"
							  +"   FM_STORAGE_LOCN a"
							  +"   , fm_User_Access_Rights b "
							  +"WHERE a.eff_Status = 'E' "
							  +"   AND a.Facility_Id = b.Facility_Id "
							  +"   AND a.fs_Locn_Code = b.fs_Locn_Code "
							 // +"   AND A.LANGUAGE_ID='"+localeName+"' "
							  +"   AND b.Facility_Id = '"+fac_id+"' "
							  +"   AND "
							  +"   ("
							  +"      b.req_yn = 'Y' "
							  +"   OR b.req_Across_faciLities_yn = 'Y'"
							  +"   ) "
							  +"   AND LOCN_IDENTITY = '"+locn_code+"' "
							  +"   AND b.apPl_User_Id = '"+addedById+"' "
							  +"ORDER BY"
							  +"   2";
				}
			}
			else 
			{
				//sql2 = "select a.fs_locn_code, a.short_desc from fm_storage_locn a,fm_parameter b where a.eff_status='E' and a.facility_id='"+fac_id+"' and a.facility_id=b.facility_id and a.fs_locn_code not in (b.dflt_archive_fs_locn_code,b.dflt_lost_fs_locn_code) and LOCN_IDENTITY='"+locn_code+"' order by 2";
				sql2 = "SELECT"
						  +"   a.fs_Locn_Code"
						  +"   ,fm_get_desc.fm_storage_locn (a.facility_id, a.fs_locn_code, '"+localeName+"',2 ) Short_desc "
						  +"FROM"
						  +"   FM_STORAGE_LOCN a"
						  +"   , fm_Parameter b "
						  +"WHERE a.eff_Status = 'E' "
						//  +"   AND A.LANGUAGE_ID='"+localeName+"'"
						  +"   AND a.Facility_Id = '"+fac_id+"' "
						  +"   AND a.Facility_Id = b.Facility_Id "
						  +"   AND a.fs_Locn_Code NOT IN (b.dflt_Archive_fs_Locn_Code, b.dflt_Lost_fs_Locn_Code) "
						  +"   AND LOCN_IDENTITY = '"+locn_code+"' "
						  +"ORDER BY"
						  +"   2";
			}

			rs2  = stmt2.executeQuery(sql2) ;
			if(rs2 != null) 
			{
				%>
				<SCRIPT>
			//		var len = parent.frames[1].request_file_details.document.forms[0].req_location.length;
	var len = parent.frames[1].document.getElementById('req_location').length;
					for(var i=0; i<=len; i++) 
					{
						parent.frames[1].document.getElementById('req_location').remove("req_location");
					}
					var opt	= parent.frames[1].document.createElement('OPTION');
					opt.value =	"";
					opt.text = "----- "+getLabel('Common.defaultSelect.label','common')+" -----";
					parent.frames[1].document.getElementById('req_location').add(opt);
				</SCRIPT>
				<%
				while(rs2.next()) 
				{
					%>
					<SCRIPT>
						var opt	= parent.frames[1].document.createElement('OPTION');
						opt.value =	"<%= rs2.getString("fs_locn_code") %>";
						opt.text = "<%= rs2.getString("short_desc")%>";
						parent.frames[1].document.getElementById('req_location').add(opt);
					</SCRIPT>
					<%
				}
			}
		}
		if(rs2!=null)	rs2.close();
		if(stmt2!=null) stmt2.close();
	
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
	parent.frames[6].document.location.href="../../eCommon/jsp/error.jsp";
</SCRIPT>

