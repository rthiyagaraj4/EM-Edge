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
	<script language='javascript' src='../../eFM/js/FMReturnMRDFile.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form>
<%
	Connection con					= ConnectionManager.getConnection(request);
	java.sql.Statement stmt		= null;
	PreparedStatement pstmt		= null;
	ResultSet rs						= null;
	
	String facilityid		= (String) session.getValue("facility_id");
	String str			=	"";
	
	String p_facility_id	= request.getParameter("p_facility_id");
	String p_curr_fs_loc = request.getParameter("p_curr_fs_loc");
	String param_num		= request.getParameter("param_num");
	String locn_code		= request.getParameter("locn_code");
	String p_fs_locn_id   = request.getParameter("p_fs_locn_id");
   String out_fcy   = request.getParameter("out_fcy");
	String p_code		 = "";
	String p_desc		 = "";
	if(out_fcy==null) out_fcy="";
	try
	{
		stmt = con.createStatement();

		if (param_num.equals("1"))
		{                                  
			str = "";
			//str = "select a.fs_locn_code,a.short_desc from fm_storage_locn a , fm_parameter b where a.facility_id = ? and a.fs_locn_code != ? and a.eff_status='E' and a.facility_id=b.facility_id and LOCN_IDENTITY = ? order by 2" ;
			str = "SELECT"
					  +"  a.fs_Locn_Code"
					  +"  , fm_get_desc.fm_storage_locn (a.facility_id, a.fs_Locn_Code,'"+localeName+"',2 ) Short_desc "
					  +"FROM"
					  +"  fm_Storage_Locn a"
					  +"  , fm_Parameter b "
					  +"WHERE a.Facility_Id = b.Facility_Id "
					  +"  AND a.Facility_Id = ? "
					  +"  AND a.fs_Locn_Code != ? "
					  +"  AND a.eff_Status = 'E' "
					  +"  AND Locn_Identity = ? "
					 // +"  AND a.language_id = ? "
					  +"ORDER BY"
					  +"  2";
			
			pstmt = con.prepareStatement(str);
			pstmt.setString(1,p_facility_id);
			pstmt.setString(2,p_curr_fs_loc);
			pstmt.setString(3,locn_code);
		//	pstmt.setString(4,localeName);
			rs = pstmt.executeQuery();

			while(rs != null && rs.next())
			{
				p_code	= rs.getString("fs_locn_code");
				p_desc	= rs.getString("short_desc");
				
				%>
				<script>
					var temp = "<%=p_code%>";
					var temp1="<%=p_desc%>";
					var opt=parent.frames[2].document.createElement("OPTION");
					opt.text=temp1;
					opt.value=temp;
					parent.frames[2].document.forms[0].p_out_fsloc.add(opt);
				</script>
				<%
			}
			if(rs!=null) rs.close();
			if(pstmt != null) pstmt.close();
		}
		else if(param_num.equals("2"))
		{
			str = "";
			//str = "select facility_id,facility_name from sm_facility_param order by 2" ;
		//	str = "select facility_id,facility_name from sm_facility_param_LANG_VW WHERE language_id = '"+localeName+"' order by 2" ;
	str = "SELECT   facility_id,sm_get_desc.sm_facility_param (facility_id,'"+localeName+"' ,1)  facility_name FROM sm_facility_param ORDER BY 2 " ;
			
			rs	= stmt.executeQuery(str);
		
			if(rs != null)
			{
				while(rs.next())
				{
					p_code	= rs.getString("facility_id");
					p_desc  = rs.getString("facility_name");

					%>
					<script>
						var temp = "<%=p_code%>";
						var temp1="<%=p_desc%>";
						var opt=parent.frames[2].document.createElement("OPTION");
						opt.text=temp1;
						opt.value=temp;
						parent.frames[2].document.forms[0].p_out_fcy.add(opt);
					</script>
					<%
				}
				%>
				<script>
					parent.frames[2].document.forms[0].p_out_fcy.value='<%=facilityid%>';
				</script>
				<%
		  }
	%>
	<%--	<script>
				var temp = "<%=p_code%>";
				var temp1="<%=p_desc%>";
				var opt=parent.frames[2].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.frames[2].document.forms[0].p_out_fsloc.add(opt);
		</script>
--%>
<%

	}
	else if(param_num.equals("3")) // This is for the Query File Not Received at MRD FS Locn Population
	{
		str = "";
		//str = "select a.fs_locn_code,a.short_desc from fm_storage_locn a  where a.facility_id = ? and a.fs_locn_code != ? and a.eff_status='E' order by 2";
		 str = "SELECT"
				  +"  a.fs_Locn_Code"
				  +"  ,fm_get_desc.fm_storage_locn (a.facility_id, a.fs_Locn_Code,'"+localeName+"',2 ) Short_desc "
				  +"FROM"
				  +"  fm_Storage_Locn a "
				  +"WHERE a.Facility_Id = ? "
				  +"  AND a.fs_Locn_Code != ? "
				//  +"  AND a.language_id = ? "
				  +"  AND a.eff_Status = 'E'";

		

		
		pstmt = con.prepareStatement(str);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_curr_fs_loc);
	//	pstmt.setString(3,localeName);
		rs = pstmt.executeQuery();

		while(rs != null && rs.next())
		{
			p_code				= rs.getString("fs_locn_code");
			p_desc				= rs.getString("short_desc");
			%>
			<script>
				var temp = "<%=p_code%>";
				var temp1="<%=p_desc%>";
				var opt=parent.frames[1].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.frames[1].document.forms[0].out_fs_locn.add(opt);
			</script>
			<%
		}
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	else if(param_num.equals("4")) //from QueryFMFileNotReturnedToMRDSearch.jsp
	{	
		
		str = "";
		//str = "SELECT a.fs_locn_code,a.short_desc FROM fm_storage_locn a,fm_parameter b WHERE a.facility_id = ? AND a.fs_locn_code != ? AND a.eff_status='E' AND a.facility_id=b.facility_id AND LOCN_IDENTITY = ? ORDER BY 2" ;
		str = "SELECT"
					  +"  a.fs_Locn_Code"
					  +"  , fm_get_desc.fm_storage_locn (a.facility_id, a.fs_Locn_Code,'"+localeName+"',2 )  Short_desc "
					  +"FROM"
					  +"  fm_Storage_Locn a"
					  +"  , fm_Parameter b "
					  +"WHERE a.Facility_Id = b.Facility_Id "
					  +"  AND a.Facility_Id = ? "
					  +"  AND a.fs_Locn_Code != ? "
					  +"  AND a.eff_Status = 'E' "
					  +"  AND Locn_Identity = ? "
					//  +"  AND a.language_id = ? "
					  +"ORDER BY"
					  +"  2";
		
		if(!out_fcy.equals(""))
		{
        p_facility_id=out_fcy;
		}
		pstmt = con.prepareStatement(str);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_curr_fs_loc);
		pstmt.setString(3,p_fs_locn_id);
		//pstmt.setString(4,localeName);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			p_code				= rs.getString("fs_locn_code");
			p_desc				= rs.getString("short_desc");
			%>
			<script>
				var temp = "<%=p_code%>";
				var temp1="<%=p_desc%>";
				var opt=parent.frames[1].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.frames[1].document.forms[0].out_fs_locn.add(opt);
			</script>
			<%
		}
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	else if(param_num.equals("5"))  //from RepStatisticsFileNotReturnedFrame.jsp
	{ 
		str = "";
		//str = "SELECT a.fs_locn_code,a.short_desc FROM fm_storage_locn a,fm_parameter b WHERE a.facility_id = ? AND a.fs_locn_code != ? AND a.eff_status='E' AND a.facility_id=b.facility_id AND LOCN_IDENTITY = ? ORDER BY 2" ;
		str = "SELECT"
			  +"  a.fs_Locn_Code"
			  +"  , fm_get_desc.fm_storage_locn (a.facility_id, a.fs_Locn_Code,'"+localeName+"',2 ) Short_desc "
			  +"FROM"
			  +"  fm_Storage_Locn a"
			  +"  , fm_Parameter b "
			  +"WHERE a.Facility_Id = b.Facility_Id "
			  +"  AND a.Facility_Id = ? "
			  +"  AND a.fs_Locn_Code != ? "
			  +"  AND a.eff_Status = 'E' "
			  +"  AND Locn_Identity = ? "
		//	  +"  AND a.language_id = ? "
			  +"ORDER BY"
			  +"  2";
		
		pstmt = con.prepareStatement(str);
		pstmt.setString(1,p_facility_id);
		pstmt.setString(2,p_curr_fs_loc);
		pstmt.setString(3,p_fs_locn_id);
	//	pstmt.setString(4,localeName);
		rs = pstmt.executeQuery();
		
		while(rs.next())
		{
			p_code	= rs.getString("fs_locn_code");
			p_desc	= rs.getString("short_desc");
			%>
			<script>
				var temp = "<%=p_code%>";
				var temp1="<%=p_desc%>";
				var opt=parent.frames[1].document.createElement("OPTION");
				opt.text=temp1;
				opt.value=temp;
				parent.frames[1].document.forms[0].outstndFSLocn.add(opt);
			</script>
			<%
		}
		if(rs!=null) rs.close();
		if(pstmt != null) pstmt.close();
	}
	if(rs!=null) rs.close();
	if(stmt!=null) stmt.close();
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
</form>
</body>
</html>

