<!DOCTYPE html>
<!--
	Created On	: 1/20/2003
	Created By	: Marayan Kumar K.R.
	Module		: File Management (FM)
	Function	: Request File
-->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eFM/js/FMTransferFile.js'></script>
<%
%>
<%
	request.setCharacterEncoding("UTF-8");
	Connection con				= null;
	PreparedStatement pstmt		= null;
	ResultSet rs				= null;

	PreparedStatement pstmt1		= null;
	ResultSet rs1				= null;

	
	String userSecurity 				= "";
	String Dflt_archive_fs_locn_code	= "";
	String Dflt_lost_fs_locn_code		= "";
	String sql2							= "";
	String access_all					= "";
	String locn_code					= "";

	String enc_id						= "";
	String patient_id					= "";
	String flag                        ="";
//     String  fs_locn_code="";  checkstyle changes 35865

	String sql1							="";
	int count						=0;
   int cnt                           =0;
	try  
	{
		con	= ConnectionManager.getConnection(request);
		
		java.util.Properties p	= (java.util.Properties) session.getValue("jdbc" );

		String facility_id		= (String) session.getValue( "facility_id" );
		String user_id			= p.getProperty( "login_user" );

		locn_code					= request.getParameter("locn_code");

		enc_id					= request.getParameter("enc_id");
		patient_id					= request.getParameter("patient_id");

	
		access_all					= request.getParameter("accessAll");
		userSecurity				= request.getParameter("userSecurity");
		Dflt_archive_fs_locn_code	= request.getParameter("Dflt_archive_fs_locn_code");
		Dflt_lost_fs_locn_code		= request.getParameter("Dflt_lost_fs_locn_code");
		flag                               = request.getParameter("flag");
		
		if(flag == null || flag.equals("null")) flag = "";
		if(enc_id == null || enc_id.equals("null")) enc_id = "";
		if(patient_id == null || patient_id.equals("null")) patient_id = "";
		if(locn_code == null || locn_code.equals("null")) locn_code = "";
		if(access_all == null || access_all.equals("null")) access_all = "";
		if(userSecurity == null || userSecurity.equals("null")) userSecurity = "N";
		if(Dflt_archive_fs_locn_code == null || Dflt_archive_fs_locn_code.equals("null")) 					Dflt_archive_fs_locn_code = "";
		if(Dflt_lost_fs_locn_code == null || Dflt_lost_fs_locn_code.equals("null")) 						Dflt_lost_fs_locn_code = "";

		
		 sql1="select encounter_id from pr_encounter where patient_id='"+patient_id+"' and encounter_id='"+enc_id+"'";	
		 		pstmt1 = con.prepareStatement(sql1);				
			rs1 = pstmt1.executeQuery();

		if(rs1 != null && rs1.next())
		{
			count ++;
			
		}
	
		if(!flag.equals("encounter_details") && !flag.equals("Report_encdetails") )
		{
				
	if(userSecurity.equals("Y")) 
		{
			%>
			<SCRIPT>
				var len = parent.frames[1].document.forms[0].fromfslocn.length;
				for (var i=0; i<=len; i++) 
				{
					parent.frames[1].document.forms[0].fromfslocn.remove("fromfslocn");
				}
				var opt	= parent.frames[1].document.createElement('OPTION');
				opt.value =	"";
				opt.text = "      ----- "+getLabel('Common.defaultSelect.label','common')+" -----      ";
				parent.frames[1].document.forms[0].fromfslocn.add(opt);
			</SCRIPT>
			<%
			if(access_all.equals("1")) 
			{
			//	sql2=" Select FS_LOCN_CODE,fm_get_desc.fm_storage_locn (facility_id,FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC from FM_STORAGE_LOCN where facility_id = ?  and LOCN_IDENTITY=? and EFF_STATUS = 'E' and LOCN_IDENTITY in ('C','N','T','E','Y') and (FS_LOCN_CODE != ? and FS_LOCN_CODE != ?)  Order by 2";
				
			sql2=" Select distinct a.fs_Locn_Code,fm_get_desc.fm_storage_locn (a.facility_id,a.fs_Locn_Code,'"+localeName+"',2 ) SHORT_DESC from fm_storage_locn_lang_vw a ,fm_User_Access_Rights b  where a.eff_Status = 'E' and  a.Facility_Id = b.Facility_Id   AND (a.fs_locn_code = b.fs_locn_code OR b.fs_locn_code = '*ALL') and   b.apPl_User_Id = '"+user_id+"' and b.TRANSFER_FILE_YN = 'Y' and a.facility_id = ?  and a.LOCN_IDENTITY=? and a.EFF_STATUS = 'E' and a.LOCN_IDENTITY in ('C','N','T','E','Y','D') and (a.FS_LOCN_CODE != ? and a.FS_LOCN_CODE != ?)  Order by 2";
				
				pstmt	= con.prepareStatement(sql2);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,locn_code);
				pstmt.setString(3,Dflt_archive_fs_locn_code);
				pstmt.setString(4,Dflt_lost_fs_locn_code);
			//	pstmt.setString(4,locn_code);
			//	pstmt.setString(5,localeName);
					
			}
			else 
			{
				//sql2=" Select FS_LOCN_CODE, FS_LOCN_SHORT_DESC SHORT_DESC from FM_USER_ACCESS_RIGHTS_VW Where facility_id = ? and appl_user_id =? and TRANSFER_FILE_YN = 'Y' and LOCN_IDENTITY in ('C','N','T','E','Y') and (FS_LOCN_CODE != ? and FS_LOCN_CODE != ?) AND LOCN_IDENTITY=? order by 2";
				sql2 = "SELECT distinct A.FS_LOCN_CODE ,  (CASE WHEN A.FS_LOCN_CODE = '*ALL' THEN   '*ALL'   ELSE B.SHORT_DESC  END) short_desc  FROM FM_USER_ACCESS_RIGHTS_VW A   , FM_STORAGE_LOCN_LANG_VW B  WHERE A.FACILITY_ID = B.FACILITY_ID(+) AND A.FS_LOCN_CODE = B.FS_LOCN_CODE(+) AND A.FACILITY_ID = ? AND A.appl_user_id = ?  AND A.TRANSFER_FILE_YN = 'Y' AND A.LOCN_IDENTITY IN ('C','N','T','E','Y','D')  AND (A.FS_LOCN_CODE != ? AND A.FS_LOCN_CODE != ?) AND A.LOCN_IDENTITY=?  AND B.LANGUAGE_ID=?  ORDER BY 2 ";
			
				if(pstmt!=null) pstmt.close();
						
					
				pstmt	= con.prepareStatement(sql2);
				pstmt.setString(1,facility_id);
				pstmt.setString(2,user_id);
				pstmt.setString(3,Dflt_archive_fs_locn_code);
				pstmt.setString(4,Dflt_lost_fs_locn_code);
				pstmt.setString(5,locn_code);
				pstmt.setString(6,localeName);
			}
		}
		else
		{
		//	sql2=" Select FS_LOCN_CODE,fm_get_desc.fm_storage_locn (facility_id,FS_LOCN_CODE,'"+localeName+"',2 ) SHORT_DESC from FM_STORAGE_LOCN where facility_id = ? AND LOCN_IDENTITY=?   and EFF_STATUS = 'E' and LOCN_IDENTITY in ('C','N','T','E','Y') and (FS_LOCN_CODE != ? and FS_LOCN_CODE != ?)  order by 2";
			
		sql2=" Select distinct a.fs_Locn_Code,fm_get_desc.fm_storage_locn (a.facility_id,a.fs_Locn_Code,'"+localeName+"',2 ) SHORT_DESC from fm_storage_locn_lang_vw a ,fm_User_Access_Rights b  where a.eff_Status = 'E' and  a.Facility_Id = b.Facility_Id   AND (a.fs_locn_code = b.fs_locn_code OR b.fs_locn_code = '*ALL') and   b.apPl_User_Id = '"+user_id+"' and b.TRANSFER_FILE_YN = 'Y' and a.facility_id = ?  and a.LOCN_IDENTITY=? and a.EFF_STATUS = 'E' and a.LOCN_IDENTITY in ('C','N','T','E','Y','D') and (a.FS_LOCN_CODE != ? and a.FS_LOCN_CODE != ?)  Order by 2";
			
			
			if(pstmt!=null) pstmt.close();
			
			pstmt	= con.prepareStatement(sql2);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,locn_code);
			pstmt.setString(3,Dflt_archive_fs_locn_code);
			pstmt.setString(4,Dflt_lost_fs_locn_code);
		//	pstmt.setString(4,locn_code);
		//	pstmt.setString(5,localeName);
		}
		
		rs		= pstmt.executeQuery();

		while(rs != null && rs.next() ) 
		{
			cnt++;
			%>
			<SCRIPT>
				var opt	= parent.frames[1].document.createElement('OPTION');
				opt.value =	"<%= rs.getString("fs_locn_code") %>";
				opt.text = "<%= rs.getString("short_desc")%>";
				parent.frames[1].document.forms[0].fromfslocn.add(opt);
			</SCRIPT>
			<%
		}
	if(cnt==1)
			{ %>
		<SCRIPT>
parent.frames[1].document.forms[0].fromfslocn.options(1).selected = true;
	setDisabled(parent.frames[1].document.forms[0].fromfslocn.value)
	var Obj=parent.frames[1].document.forms[0].fromfslocn.value;
	var identity = parent.frames[1].document.forms[0].FS_LOCN_ID.value; 
	if(Obj == '') {
		parent.frames[1].document.forms[0].returning_desc.value='';
		parent.frames[1].document.forms[0].returning_code.value='';
		parent.frames[1].document.forms[0].returning_desc.disabled=true;
		parent.frames[1].document.forms[0].ret_button.disabled=true;
	}
	else  if(identity!="D") {
		parent.frames[1].document.forms[0].returning_desc.disabled=false;
		parent.frames[1].document.forms[0].ret_button.disabled=false;
	}
	</SCRIPT>
	<%}
	}else if(count>0)
		{

		}else{
			%>
			<SCRIPT>
						
			var flag="<%=flag%>";
			 	var errors = getMessage('PATIENT_IS_NOT_INPATIENT','FM');
					alert(errors);
				 if(flag=="Report_encdetails")
			{
          parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
		  parent.parent.frames[2].frames[3].document.forms[0].encounter_id.value="";
	      parent.parent.frames[2].frames[3].document.forms[0].encounter_id.focus();		
               }else{
				 parent.deficiency_header.FileDeficiencyMonitoring_header.encounter_id.value="";
				parent.deficiency_header.FileDeficiencyMonitoring_header.encounter_id.focus();
			}
			</SCRIPT>
			<%			
		}

		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
		if(rs1!=null)	rs1.close();
		if(pstmt1!=null) pstmt1.close();
	}catch(Exception e){out.println("Exception e :"+e);e.printStackTrace();}
	finally 
	{		
		ConnectionManager.returnConnection(con,request);
	}
%>
<SCRIPT>
	var flag="<%=flag%>";
	 if(flag=="Report_encdetails"){
 
	 }else{
	parent.frames[5].document.location.href="../../eCommon/jsp/error.jsp";
	 }
</SCRIPT>

