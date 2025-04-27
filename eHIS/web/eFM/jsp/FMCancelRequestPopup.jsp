<!DOCTYPE html>
<%@ page import ="java.sql.*, java.util.*, java.net.*, java.text.*, webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
	<script language='javascript' src='../../eCommon/js/common.js'></script>


<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	

	String access_all	= "";
	String sql			= "";

	try 
	{
		con 	= ConnectionManager.getConnection(request);

		java.util.Properties p		= (java.util.Properties) session.getValue("jdbc");
		String facility_id			= (String) session.getValue("facility_id");
		String user_id				= p.getProperty("login_user");
		
		String locn_code			= request.getParameter("locn_code");
		String userSecurity			= request.getParameter("userSecurity");
		access_all					= request.getParameter("access_all");

		if(access_all == null || access_all.equals("null")) access_all = "";
		if(locn_code == null || locn_code.equals("null")) locn_code = "";
		if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";		
		if(userSecurity.equals("Y")) 
		{
			if(access_all.equals("*ALL")) //Modified by S.Sathish for IN021089 on Friday, April 30, 2010
			{
				//sql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY from FM_STORAGE_LOCN where facility_id = ? and eff_status = 'E' and LOCN_IDENTITY = ? order by 2";
				sql = "SELECT"
					  +"  FS_LOCN_CODE"
					  +"  , SHORT_DESC"
					  +"  , LOCN_IDENTITY "
					  +"FROM"
					  +"  FM_STORAGE_LOCN_LANG_VW "
					  +"WHERE Facility_Id = ? "
					  +"  AND eff_Status = 'E' "
					  +"  AND LOCN_IDENTITY = ? "
					  +"  AND LANGUAGE_id=? "
					  +"ORDER BY"
					  +"  2";

				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locn_code);
				pstmt.setString(3,localeName);
			}
			else
			{
				//sql = "Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC, LOCN_IDENTITY from FM_USER_ACCESS_RIGHTS_VW where facility_id = ? and APPL_USER_ID = ? and CANCEL_REQUEST_YN = 'Y' and LOCN_IDENTITY = ? order by 2";
				sql = "SELECT"
								  +"  a.FS_LOCN_CODE"
								  +"  , ("
								  +"  CASE "
								  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
								  +"  THEN"
								  +"    '*ALL' "
								  +"  ELSE B.SHORT_DESC "
								  +"  END)"
								  +"  , LOCN_IDENTITY "
								  +"FROM"
								  +"  FM_USER_ACCESS_RIGHTS A"
								  +"  , FM_STORAGE_LOCN_LANG_VW B "
								  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
								  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
								  +"  AND A.Facility_Id = ? "
								  +"  AND A.APPL_USER_ID = ? "
								  +"  AND A.CANCEL_REQUEST_YN = 'Y' "
								  +"  AND LOCN_IDENTITY = ? "
								  +"  AND B.LANGUAGE_ID=? "
								  +"ORDER BY 2";
				
				if(pstmt != null) pstmt.close();				
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,user_id);
				pstmt.setString(3,locn_code);
				pstmt.setString(4,localeName);
			}
		}
		else
		{
			//sql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY from FM_STORAGE_LOCN where facility_id = ? and eff_status = 'E' and LOCN_IDENTITY = ? order by 2";
			sql = "SELECT"
					  +"  FS_LOCN_CODE"
					  +"  , SHORT_DESC"
					  +"  , LOCN_IDENTITY "
					  +"FROM"
					  +"  FM_STORAGE_LOCN_LANG_VW "
					  +"WHERE Facility_Id = ? "
					  +"  AND eff_Status = 'E' "
					  +"  AND LOCN_IDENTITY = ? "
					  +"  AND LANGUAGE_id=? "
					  +"ORDER BY 2";


			if(pstmt != null) pstmt.close();
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locn_code);
			pstmt.setString(3,localeName);
		}
		%>
		<SCRIPT>
			parent.frames[1].document.getElementById("CancelFilesHeader_form").querySelector('#fslocation').length = 0 ;
			// var len = parent.frames[1].CancelFilesHeader_form.fslocation.length;
			//for(var i=0; i<=len; i++) 
			//{
			//	parent.frames[1].CancelFilesHeader_form.remove("fslocation");
			//}
			var opt	  = parent.frames[1].document.createElement('OPTION');
			opt.value =	"";
			opt.text  = "-----"+getLabel("Common.defaultSelect.label","common")+"-----";
			parent.frames[1].CancelFilesHeader_form.fslocation.add(opt);
		</SCRIPT>
		<%
		rs = pstmt.executeQuery();
		while(rs != null && rs.next()) 
		{
			String ID	= rs.getString(1);
			String desc	= rs.getString(2);
			String Iden = rs.getString(3);
		%>
		<SCRIPT>
			 var opt	= parent.frames[1].document.createElement('OPTION');
			 opt.value =	"<%=ID%>!<%=Iden%>";
			 opt.text = "<%= desc %>"; 
			 parent.frames[1].CancelFilesHeader_form.fslocation.add(opt);
		</SCRIPT>
		<%
		}
	if(rs!=null)	rs.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){ out.println("Exception e :"+e); }
	finally 
	{			
		ConnectionManager.returnConnection(con,request);		
	}
	%>
<SCRIPT>
	parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp";
</SCRIPT>

