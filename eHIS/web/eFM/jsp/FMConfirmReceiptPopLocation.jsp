<!DOCTYPE html>
<!--
	Created On	: 1/20/2003
	Created By	: Marayan Kumar K.R.
	Module		: File Management (FM)
	Function	: Request File
-->


<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<%
	request.setCharacterEncoding("UTF-8");
	String facility_id	= (String) session.getValue( "facility_id" ) ;
	Properties p		= (Properties) session.getValue("jdbc" ) ;
	

	String locn_code	= request.getParameter("locn_code");
	String user_id		= p.getProperty( "login_user" ) ;

	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;
	
	try 
	{
		con 	= ConnectionManager.getConnection(request);
				
		String access_all					= "";
		String userSecurity					= "";
		String auto_rec_ward				= "";
		String auto_rec_clinic				= "";
		String auto_rec_pract				= "";
		String auto_rec_dept				= "";
		//String Auto_rec_external			= "";
		String Dflt_archive_fs_locn_code	= "";
		String Dflt_lost_fs_locn_code		= "";
		String moreCriteria					= "";
		String SelectSql					= "";
		String auto_rec_procedure_yn		= "", auto_rec_daycare_yn = "";
		
		access_all					= request.getParameter("accessAll");
		userSecurity				= request.getParameter("userSecurity");
		auto_rec_ward				= request.getParameter("auto_rec_ward");
		auto_rec_clinic				= request.getParameter("auto_rec_clinic");
		auto_rec_procedure_yn		= request.getParameter("auto_rec_daycare_yn");
		auto_rec_daycare_yn			= request.getParameter("auto_rec_daycare_yn");
		auto_rec_pract				= request.getParameter("auto_rec_pract");
		auto_rec_dept				= request.getParameter("auto_rec_dept");
		//Auto_rec_external			= request.getParameter("Auto_rec_external");
		Dflt_archive_fs_locn_code	= request.getParameter("Dflt_archive_fs_locn_code");
		Dflt_lost_fs_locn_code		= request.getParameter("Dflt_lost_fs_locn_code");
		
		if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";
		
		if(locn_code.equals("N")) 
		{
			if(auto_rec_ward.equals("N")) moreCriteria = "'N'";
		}

		if(locn_code.equals("C")) 
		{
			if(auto_rec_clinic.equals("N")) moreCriteria = "'C'";
		}

		if(locn_code.equals("E")) 
		{
			if(auto_rec_procedure_yn.equals("N")) 	moreCriteria = "'E'";
		}

		if(locn_code.equals("Y")) 
		{
			if(auto_rec_daycare_yn.equals("N")) moreCriteria = "'Y'";
		}

		if(locn_code.equals("T")) 
		{
			if(auto_rec_pract.equals("N")) moreCriteria = "'T'";
		}
		
		if(locn_code.equals("D")) 
		{
			if(auto_rec_dept.equals("N")) moreCriteria = "'D'";
		}

		

		if(userSecurity.equals("Y")) 
		{
			if(access_all.equals("*ALL"))  //Modified by S.Sathish for IN021089 on Friday, April 30, 2010
			{
				//SelectSql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY from FM_STORAGE_LOCN where facility_id = '"+facility_id+"' and eff_status = 'E' and LOCN_IDENTITY IN ("+moreCriteria+") and (FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' and FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"') order by 2";
				 SelectSql = "SELECT"
						  +"  FS_LOCN_CODE"
						  +"  ,fm_get_desc.fm_storage_locn (facility_id, FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC"
						  +"  , LOCN_IDENTITY "
						  +"FROM"
						  +"  FM_STORAGE_LOCN_LANG_VW "
						  +"WHERE Facility_Id = '"+facility_id+"' "
						  +"  AND LANGUAGE_ID='"+localeName+"' "
						  +"  AND eff_Status = 'E' "
						  +"  AND LOCN_IDENTITY IN ("+moreCriteria+") "
						  +"  AND "
						  +"  ("
						  +"    FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' "
						  +"    AND FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"'"
						  +"  ) "
						  +"ORDER BY"
						  +"  2";

				
			}
			else
			{
				//SelectSql = "Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC, LOCN_IDENTITY from FM_USER_ACCESS_RIGHTS_VW where facility_id = '"+facility_id+"' and APPL_USER_ID = '"+user_id+"' and CONFIRM_RECEIPT_FILE_YN = 'Y' and LOCN_IDENTITY IN ("+moreCriteria+") and (FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' and FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"') order by 2";
				 SelectSql = "SELECT"
							  +"  a.FS_LOCN_CODE"
							  +"  , ("
							  +"  CASE "
							  +"  WHEN A.FS_LOCN_CODE = '*ALL' "
							  +"  THEN"
							  +"    '*ALL' "
							  +"  ELSE B.SHORT_DESC "
							  +"  END)"
							  +"  , b.LOCN_IDENTITY "
							  +"FROM"
							  +"  FM_USER_ACCESS_RIGHTS A"
							  +"  , FM_STORAGE_LOCN_LANG_VW B "
							  +"WHERE A.FACILITY_ID = B.FACILITY_ID(+) "
							  +"  AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) "
							  +"  AND a.Facility_Id = '"+facility_id+"' "
							  +"  AND a.APPL_USER_ID = '"+user_id+"' "
							  +"  AND a.CONFIRM_RECEIPT_FILE_YN = 'Y' "
							  +"  AND b.LOCN_IDENTITY IN ("+moreCriteria+") "
							  +"  AND "
							  +"  ("
							  +"    a.FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' "
							  +"    AND a.FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"'"
							  +"  ) "
							  +"  AND B.LANGUAGE_ID='"+localeName+"' "
							  +"ORDER BY"
							  +"  2";

			}
		}
		else
		{
			//SelectSql = "Select FS_LOCN_CODE, SHORT_DESC, LOCN_IDENTITY from FM_STORAGE_LOCN where facility_id = '"+facility_id+"' and eff_status = 'E' and LOCN_IDENTITY IN ("+moreCriteria+") and (FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' and FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"') order by 2";
			 SelectSql = "SELECT"
						  +"  FS_LOCN_CODE"
						  +"  ,fm_get_desc.fm_storage_locn (facility_id, FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC"
						  +"  , LOCN_IDENTITY "
						  +"FROM"
						  +"  FM_STORAGE_LOCN_LANG_VW "
						  +"WHERE Facility_Id = '"+facility_id+"' "
						  +"  AND LANGUAGE_ID='"+localeName+"' "
						  +"  AND eff_Status = 'E' "
						  +"  AND LOCN_IDENTITY IN ("+moreCriteria+") "
						  +"  AND "
						  +"  ("
						  +"    FS_LOCN_CODE != '"+Dflt_archive_fs_locn_code+"' "
						  +"    AND FS_LOCN_CODE != '"+Dflt_lost_fs_locn_code+"'"
						  +"  ) "
						  +"ORDER BY"
						  +"  2";

		}

		
		%>
		<SCRIPT>
		    //console.log(parent.receipt_header.document.getElementById("fslocation"));
		   // var len = parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.length;
		    var len = parent.receipt_header.document.getElementById("fslocation").length;
			for(var i=0; i<=len; i++) 
			{
				//parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.remove("fslocation");
				parent.receipt_header.document.getElementById("fslocation").remove("fslocation");
			}
			//var opt	= parent.frames[1].ConfirmReceiptHeader_form.document.createElement('OPTION');
			   var opt	= parent.receipt_header.document.createElement('OPTION');
			opt.value =	"";
			opt.text = "----- "+getLabel("Common.defaultSelect.label","common")+" -----";
			//parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.add(opt);
			parent.receipt_header.document.getElementById("fslocation").add(opt);
		</SCRIPT>
		<%
		
		pstmt = con.prepareStatement(SelectSql);
		rs = pstmt.executeQuery();
		while(rs != null && rs.next()) 
		{
			String ID	= rs.getString(1);
			String desc	= rs.getString(2);
			String Iden = rs.getString(3);
			%>
			<SCRIPT>
				//var opt	= parent.frames[1].ConfirmReceiptHeader_form.document.createElement('OPTION');
				var opt	= parent.receipt_header.document.createElement('OPTION');
				opt.value =	"<%=ID%>!<%=Iden%>";
				opt.text = "<%= desc %>";
				//parent.frames[1].ConfirmReceiptHeader_form.document.forms[0].fslocation.add(opt);
			    parent.receipt_header.document.getElementById("fslocation").add(opt);
			</SCRIPT>
			<%
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
		parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp";
	</SCRIPT>

