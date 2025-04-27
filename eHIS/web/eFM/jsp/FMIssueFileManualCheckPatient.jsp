<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
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
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<body class='message' onKeyDown = 'lockKey()'>
<form name="checkvals" id="checkvals">
<%
	Connection con				= ConnectionManager.getConnection(request);
	PreparedStatement pstmt		= null;
	PreparedStatement pstmt1		= null;
	ResultSet rs				= null;
	ResultSet rs1				= null;
	try
	{
		String sql					= "";
		String pat_line				= "";
		String file_no				= "";
		String p_file_no			= "";
		String file_status			= "";
		String sysdate				= "";
		String remark				= "";		
		String FirstcurrFacility	= "";
		String FirstcurrLocn		= "";
		String FirstcurrIden		= "";
		String FirstcurrDesc		= "";
		String FirstcurrIdDesc		= "";
		String FirstcurrStatDesc	= "";
		String FirstcurrMrLocn		= "";
		String Firstremark			= "";
		String moreCriteria			= "";
		String file_type_desc="";
		//String curr_faCILITY_ID ="";
		//String fs_locn			= "";
		//String pat_id				= "";
		//String currFacility		= "";
		//String currLocn			= "";
		//String currDesc			= "";
		//String currStat			= "";
		//String currStatDesc		= "";
		//String currIden			= "";
		//String currIdDesc			= "";
		//String currMrLocn			= "";
		int rec_count=0;
		String found				= "N";
		String otherFileSel			= "N";
		java.util.Hashtable message;

		StringBuffer SelectSqlBuffer = null;
		SelectSqlBuffer				 = new StringBuffer();

		String  curr_fs_loaction    ="";
		String  perm_fs_loaction    ="";


		int temp			= 1;
		int p_file_no_found = 0;

		String facility_id	= (String) session.getValue("facility_id");
			String user_id		= (String) session.getValue("login_user");

		String userSecurity = request.getParameter("userSecurity");
		String Facility		= request.getParameter("Facility");
		String Patient		= request.getParameter("Patient");
		String selLocn		= request.getParameter("selLocn");
        String fileno=request.getParameter("file_no")==null?"":request.getParameter("file_no");
				
		//12-09-2009 14417
		String issueLocn		= request.getParameter("issueLocn");		
       String file_type  = request.getParameter("file_type")==null?"":request.getParameter("file_type");
		String volume_no  = request.getParameter("volume_no")==null?"":request.getParameter("volume_no");
		
		
		String sql1="";
		if(file_type.equals(""))
		{
	    sql1="select CURR_FS_LOCN_CODE,PERM_FS_LOCN_CODE from FM_CURR_LOCN where facility_id = '"+facility_id+"' AND PATIENT_ID ='"+Patient+"' AND file_no='"+fileno+"' AND volume_no ='"+volume_no+"' "; 
		}
		
		if(fileno.equals(""))
		{
	    sql1="select CURR_FS_LOCN_CODE,PERM_FS_LOCN_CODE from FM_CURR_LOCN where facility_id = '"+facility_id+"' AND PATIENT_ID ='"+Patient+"' AND FILE_TYPE_CODE='"+file_type+"' AND volume_no ='"+volume_no+"' "; 
		}
		
		pstmt1 = con.prepareStatement(sql1);
				
		rs1= pstmt1.executeQuery();

		while(rs1 != null && rs1.next())
		{
		
			curr_fs_loaction = rs1.getString("CURR_FS_LOCN_CODE");
			
			perm_fs_loaction = rs1.getString("PERM_FS_LOCN_CODE");
		}
		if(rs1!=null) rs1.close();
			if(pstmt1!=null) pstmt1.close(); 

		
		pstmt1 = con.prepareStatement("SELECT Count(file_type_code) file_type_codecnt FROM    mr_pat_file_index  WHERE  patient_id ='"+Patient+"' ");
				
		rs1= pstmt1.executeQuery();

		while(rs1 != null && rs1.next())
		{
		
			rec_count = rs1.getInt("file_type_codecnt");
				
		}
		if(rs1!=null) rs1.close();
			if(pstmt1!=null) pstmt1.close(); 
		
		String access_all  = request.getParameter("access_all")==null?"":request.getParameter("access_all");
		String volcount  = request.getParameter("volcount")==null?"":request.getParameter("volcount");
		
				
		boolean invalid_patient = false;
		webbeans.op.PatientData patdata = new webbeans.op.PatientData();
		patdata.setFacility_id(Facility);
		String patient_status = patdata.CheckStatus(con,Patient);
		
		
		if(patient_status.equals("INVALID_PATIENT"))
		{
			invalid_patient = true;
		}

		/*
		pstmt = con.prepareStatement("SELECT curr_faCILITY_ID FROM fm_curr_locn WHERE patient_id='"+Patient+"'  AND volume_no ='"+volume_no+"'  AND FILE_TYPE_CODE='"+file_type+"' AND  FACILITY_ID='"+facility_id+"' ");
		rs = pstmt.executeQuery();
       
		while(rs != null && rs.next())
		{
		curr_faCILITY_ID=rs.getString("curr_faCILITY_ID");
			}
		if(rs!=null) rs.close();

		
		*/

		if(userSecurity.equals("Y"))
		{			

			if (access_all.equals("*ALL"))
			{
				//SelectSqlBuffer.append("Select PATIENT_ID, FILE_NO, FILE_TYPE_CODE, VOLUME_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, CURR_FACILITY_ID, get_patient_line(PATIENT_ID) PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN, DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost','E','Other Facility') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , REMARKS, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW where  PATIENT_ID = ? and CURR_FACILITY_ID = ? AND CURR_FS_LOCN_CODE = MR_PAT_FS_LOCN_CODE AND CURR_FS_LOCN_CODE != ? order by FILE_NO");
				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  PATIENT_ID" );
				SelectSqlBuffer.append("  , FILE_NO" );
				SelectSqlBuffer.append("  , FILE_TYPE_CODE" );
				SelectSqlBuffer.append("  , mr_get_desc.mr_file_type(FACILITY_ID, FILE_TYPE_CODE, '"+localeName+"', 2) File_Type" );
				SelectSqlBuffer.append("  , VOLUME_NO" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_CODE" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
				SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
				SelectSqlBuffer.append("  , Get_patient_line(PATIENT_ID,'"+localeName+"') PLINE" );
				SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
				SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn(CURR_FACILITY_ID,Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
				SelectSqlBuffer.append("  , REMARKS" );
				SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  FM_CURR_LOCN " );
				SelectSqlBuffer.append("WHERE PATIENT_ID = ? " );
				SelectSqlBuffer.append("  AND FACILITY_ID = ? " );
				
				if(file_type.equals(""))
				{
				 //SelectSqlBuffer.append("  AND CURR_FS_LOCN_CODE = PERM_FS_LOCN_CODE " );
				}
				else
				{
					SelectSqlBuffer.append("  AND FILE_TYPE_CODE ='"+file_type+"'" );
				}
				
				if(!fileno.equals(""))
				{
				SelectSqlBuffer.append("  AND file_no ='"+fileno+"'" );
				}
				
				
				
				if(!volume_no.equals(""))
				{
					SelectSqlBuffer.append("  AND volume_no ='"+volume_no+"'" );
				}

				SelectSqlBuffer.append("  AND CURR_FS_LOCN_CODE != ?" );
				SelectSqlBuffer.append("ORDER BY" );
				SelectSqlBuffer.append("  FILE_NO" );
				

				pstmt = con.prepareStatement(SelectSqlBuffer.toString());
				pstmt.setString(1,Patient);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,selLocn);	
			}
			else
			{

				if(Facility.equals(facility_id))
					moreCriteria = " AND ISS_YN = 'Y' ";
				else
					moreCriteria = " AND ISS_ACROSS_FACILITIES_YN = 'Y' ";

				//SelectSqlBuffer.append("Select PATIENT_ID, FILE_NO, FILE_TYPE_CODE, VOLUME_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, CURR_FACILITY_ID, get_patient_line(PATIENT_ID) PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN, DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost','E','Other Facility') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , REMARKS, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW A, FM_USER_ACCESS_RIGHTS B where  PATIENT_ID = ? and A.CURR_FACILITY_ID = ? AND A.CURR_FS_LOCN_CODE = A.MR_PAT_FS_LOCN_CODE AND A.CURR_FACILITY_ID = B.FACILITY_ID AND B.APPL_USER_ID = ? AND FS_LOCN_CODE = CURR_FS_LOCN_CODE AND CURR_FS_LOCN_CODE != ? AND "+moreCriteria+" order by FILE_NO");
				SelectSqlBuffer.append("SELECT" );
				SelectSqlBuffer.append("  PATIENT_ID" );
				SelectSqlBuffer.append("  , FILE_NO" );
				SelectSqlBuffer.append("  , FILE_TYPE_CODE" );
				SelectSqlBuffer.append("  , mr_get_desc.mr_file_type(a.FACILITY_ID, a.FILE_TYPE_CODE, '"+localeName+"', 2) File_Type" );
				SelectSqlBuffer.append("  , VOLUME_NO" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_CODE" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
				SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
				SelectSqlBuffer.append("  , Get_patient_line(PATIENT_ID,'"+localeName+"') PLINE" );
				SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
				SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
				SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn(A.CURR_FACILITY_ID,Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
				SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
				SelectSqlBuffer.append("  , REMARKS" );
				SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
				SelectSqlBuffer.append("FROM" );
				SelectSqlBuffer.append("  FM_CURR_LOCN A" );
				SelectSqlBuffer.append("  , FM_USER_ACCESS_RIGHTS B " );
				SelectSqlBuffer.append("WHERE PATIENT_ID = ? " );
				SelectSqlBuffer.append("  AND A.FACILITY_ID = ? " );
				//SelectSqlBuffer.append("  AND A.CURR_FS_LOCN_CODE = A.PERM_FS_LOCN_CODE " );
				if(file_type.equals(""))
				{
				SelectSqlBuffer.append("  AND A.CURR_FS_LOCN_CODE = A.PERM_FS_LOCN_CODE " );
				}
				else
				{
					SelectSqlBuffer.append("  AND A.FILE_TYPE_CODE ='"+file_type+"'" );
				}
		   
			if(!fileno.equals(""))
				{
				SelectSqlBuffer.append("  AND file_no ='"+fileno+"'" );
				}
				
				if(!volume_no.equals(""))
				{
					SelectSqlBuffer.append("  AND A.volume_no ='"+volume_no+"'" );
				}
				SelectSqlBuffer.append("  AND A.CURR_FACILITY_ID = B.FACILITY_ID " );
				SelectSqlBuffer.append("  AND B.APPL_USER_ID = ?" );
				SelectSqlBuffer.append("  AND B.FS_LOCN_CODE = A.CURR_FS_LOCN_CODE " );
				SelectSqlBuffer.append(" AND A.CURR_FS_LOCN_CODE != ?" );
				SelectSqlBuffer.append(moreCriteria);
				SelectSqlBuffer.append("ORDER BY" );
				SelectSqlBuffer.append("  FILE_NO" );
			
				if(pstmt != null) pstmt.close();

				pstmt = con.prepareStatement(SelectSqlBuffer.toString());
				pstmt.setString(1,Patient);
				pstmt.setString(2,facility_id);
				pstmt.setString(3,user_id);
				pstmt.setString(4,selLocn);
			}
		}
		else if(userSecurity.equals("N"))
		{
			//SelectSqlBuffer.append("Select PATIENT_ID, FILE_NO, FILE_TYPE_CODE, VOLUME_NO, CURR_FS_LOCN_CODE, CURR_FILE_STATUS, CURR_FACILITY_ID, get_patient_line(PATIENT_ID) PLINE, NVL(MR_LOCN_YN,'N') CURR_MR_LOCN_YN, DECODE(CURR_FILE_STATUS,'A','Archive','T','Transit','I','Inside','O','Outside','L','Lost','E','Other Facility') FILE_STATUS_DESC, CURR_FS_LOCN_DESC, CURR_FS_LOCN_IDENTITY,  DECODE(CURR_FS_LOCN_IDENTITY,'D','Department','C','Clinic','N','Nursing Unit','T','Practitioner','E','X','External','E','Procedure Unit','Y','Daycare Unit') LOCN_IDENTITY_DESC , REMARKS, TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE  from FM_CURR_LOCN_VW where  PATIENT_ID = ? and CURR_FACILITY_ID = ? AND CURR_FS_LOCN_CODE = MR_PAT_FS_LOCN_CODE AND CURR_FS_LOCN_CODE != ? order by FILE_NO");
			SelectSqlBuffer.append("SELECT" );
			SelectSqlBuffer.append("  PATIENT_ID" );
			SelectSqlBuffer.append("  , FILE_NO" );
			SelectSqlBuffer.append("  , FILE_TYPE_CODE" );
			SelectSqlBuffer.append("  , mr_get_desc.mr_file_type(FACILITY_ID, FILE_TYPE_CODE, '"+localeName+"', 2) File_Type" );
			SelectSqlBuffer.append("  , VOLUME_NO" );
			SelectSqlBuffer.append("  , CURR_FS_LOCN_CODE" );
			SelectSqlBuffer.append("  , CURR_FILE_STATUS" );
			SelectSqlBuffer.append("  , CURR_FACILITY_ID" );
			SelectSqlBuffer.append("  , Get_patient_line(PATIENT_ID,'"+localeName+"') PLINE" );
			SelectSqlBuffer.append("  , Nvl(MR_LOCN_YN,'N') CURR_MR_LOCN_YN" );
			SelectSqlBuffer.append("  , CURR_FILE_STATUS FILE_STATUS_DESC" );
			SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn(CURR_FACILITY_ID,Curr_fs_Locn_Code,'"+localeName+"',1) CURR_FS_LOCN_DESC" );
			SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY" );
			SelectSqlBuffer.append("  , CURR_FS_LOCN_IDENTITY LOCN_IDENTITY_DESC" );
			SelectSqlBuffer.append("  , REMARKS" );
			SelectSqlBuffer.append("  , TO_CHAR(SYSDATE,'DD/MM/YYYY HH24:MI') SYDATE " );
			SelectSqlBuffer.append("FROM" );
			SelectSqlBuffer.append("  FM_CURR_LOCN " );
			SelectSqlBuffer.append("WHERE PATIENT_ID = ? " );
			SelectSqlBuffer.append("  AND FACILITY_ID = ? " );
			//SelectSqlBuffer.append("  AND CURR_FS_LOCN_CODE = PERM_FS_LOCN_CODE " );
			if(file_type.equals(""))
			{
			//SelectSqlBuffer.append("  AND CURR_FS_LOCN_CODE = PERM_FS_LOCN_CODE " );
			}
			else
			{
				SelectSqlBuffer.append("  AND FILE_TYPE_CODE ='"+file_type+"'" );
			}
			
			if(!fileno.equals(""))
				{
				SelectSqlBuffer.append("  AND file_no ='"+fileno+"'" );
				}
			if(!volume_no.equals(""))
			{
				SelectSqlBuffer.append("  AND volume_no ='"+volume_no+"'" );
			}
			SelectSqlBuffer.append("  AND CURR_FS_LOCN_CODE != ? " );
			SelectSqlBuffer.append("ORDER BY" );
			SelectSqlBuffer.append("  FILE_NO" );

			if(pstmt != null) pstmt.close();
			
			
			
			pstmt = con.prepareStatement(SelectSqlBuffer.toString());
			pstmt.setString(1,Patient);
			pstmt.setString(2,facility_id);
			pstmt.setString(3,selLocn);
		
		}

		rs = pstmt.executeQuery();
		String str = "";
		while(rs != null && rs.next())
		{
			found = "Y";
			file_status = rs.getString("CURR_FILE_STATUS");
			file_type_desc = rs.getString("file_type");
			p_file_no	= rs.getString("FILE_NO");
			FirstcurrStatDesc = rs.getString("FILE_STATUS_DESC");
			Firstremark		= rs.getString("REMARKS");
			FirstcurrDesc = rs.getString("CURR_FS_LOCN_DESC");
			FirstcurrIdDesc = rs.getString("LOCN_IDENTITY_DESC");
			

			

			if(Firstremark == null || Firstremark.equals("null"))
						Firstremark = "";

			if(file_status.equals("I"))
			  Firstremark="";
		
			if(file_type_desc == null || file_type_desc.equals("null"))
						file_type_desc = "";
				
			if(file_status.equals("I")) // || file_status.equals("O"))
			{
				//pat_id		= rs.getString("PATIENT_ID");
				//fs_locn		= rs.getString("CURR_FS_LOCN_CODE");
				//currFacility	= rs.getString("CURR_FACILITY_ID");
				//currMrLocn	= rs.getString("CURR_MR_LOCN_YN");
				//currLocn		= rs.getString("CURR_FS_LOCN_CODE");
				//currDesc		= rs.getString("CURR_FS_LOCN_DESC");
				//currStat		= rs.getString("CURR_FILE_STATUS");
				//currStatDesc	= rs.getString("FILE_STATUS_DESC"); 
				//currIden		= rs.getString("CURR_FS_LOCN_IDENTITY");
				//currIdDesc	= rs.getString("LOCN_IDENTITY_DESC");

				file_no			= rs.getString("FILE_NO");
				str=str + "<option value='"+file_no+"'>"+file_no+"</option>";
				pat_line		= rs.getString("PLINE").substring(0,rs.getString("PLINE").length()-6);
				remark			= rs.getString("REMARKS");
				sysdate			= rs.getString("SYDATE");

				if(temp == 1)
				{
					FirstcurrFacility = rs.getString("CURR_FACILITY_ID");
					FirstcurrLocn = rs.getString("CURR_FS_LOCN_CODE");
					FirstcurrIden = rs.getString("CURR_FS_LOCN_IDENTITY");
					FirstcurrMrLocn = rs.getString("CURR_MR_LOCN_YN");
				//	FirstcurrDesc = rs.getString("CURR_FS_LOCN_DESC");
				//	FirstcurrIdDesc = rs.getString("LOCN_IDENTITY_DESC");
				//	FirstcurrStatDesc = rs.getString("FILE_STATUS_DESC"); 
					//Firstremark		= rs.getString("REMARKS");
					temp++;
					
				} 				
			}

if(!FirstcurrStatDesc.equals(""))
			{
				switch(FirstcurrStatDesc.charAt(0))
				{
					case 'T' : FirstcurrStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

					case 'I' : FirstcurrStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

					case 'L' : FirstcurrStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

					case 'A' : FirstcurrStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

					case 'O' : FirstcurrStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;

					case 'E' : FirstcurrStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.OtherFacility.label","common_labels"); break;
			        
				   case 'R' : FirstcurrStatDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.returned.label","common_labels"); break;
				
				}
			}
if(!FirstcurrIdDesc.equals(""))
		{
			switch(FirstcurrIdDesc.charAt(0))
			{
				case 'D' : FirstcurrIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : FirstcurrIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : FirstcurrIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : FirstcurrIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : FirstcurrIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : FirstcurrIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : FirstcurrIdDesc = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}
			
			
			
			
			else if(file_status.equals("A")) 
			{
			%>
				<script>
					var errors = getMessage('FILE_STATUS_ARCHIVE','FM');			parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
					
					var rec_count=parseInt("<%=volcount%>");
					if("<%=volcount%>"=="1" &&  rec_count==1 ) {
						parent.frames[2].document.forms[0].fileno.value = "";
						//parent.frames[2].document.forms[0].patientid.focus();
						parent.frames[2].document.forms[0].patientid.value="";
						parent.frames[2].document.forms[0].patientid.focus();
						parent.frames[2].document.forms[0].patientid.onblur();
					}
					parent.frames[2].document.forms[0].currfilelocn.value = "";
					parent.frames[2].document.forms[0].filestat.value = "";
					parent.frames[2].document.forms[0].remarks.value = "";
					parent.frames[2].document.getElementById("patline").innerText ="";
					
					
				</script>
			<%
			}		
			else
			{
				otherFileSel = "Y";
			} 		
		}
		
		if(rs!=null) rs.close();
		if(pstmt!=null) pstmt.close();

		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}
		
			
		if(found.equals("N") && !invalid_patient)
		{ 			
       		if(!perm_fs_loaction.equals(issueLocn)) {
			%>								
				<script>
						var errors = getMessage('FILE_IS_NOT_AT_ISS_LOCN','FM');
						
						parent.frames[2].document.forms[0].Curr_file_status.value="";
						var rec_count=parseInt("<%=rec_count%>");
						if("<%=volcount%>"=="1" && rec_count==1){
						 parent.frames[2].document.forms[0].patientid.value="";
						parent.frames[2].document.forms[0].patientid.focus();
						parent.frames[2].document.forms[0].patientid.onblur();
						}else{
						parent.frames[2].document.forms[0].currfilelocn.value = "";
						parent.frames[2].document.forms[0].filestat.value = "";
						parent.frames[2].document.forms[0].remarks.value = "";
						parent.frames[2].document.getElementById("patline").innerText ="";
							
							}
						parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
						//	var errors = getMessage('FILE_ALREADY_EXIST','FM');
			
				
				</script>

			<% } else if(curr_fs_loaction.equals(selLocn)) { 
			%>
			<script>
			var errors = getMessage('FILE_ALREADY_EXIST','FM');
			parent.frames[2].document.forms[0].Curr_file_status.value="O";
			 parent.frames[2].document.forms[0].currfilelocn.value = "";
			 parent.frames[2].document.forms[0].filestat.value = "";
			 parent.frames[2].document.forms[0].remarks.value = "";
			 parent.frames[2].document.getElementById("patline").innerText ="";
			parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
			</script>

		<%	} %>
				<script>
				
						var rec_count=parseInt("<%=rec_count%>");
						if("<%=volcount%>"=="1" && rec_count==1){
						//	parent.frames[2].document.forms[0].fileno.value = ""; 													
							parent.frames[2].document.forms[0].patientid.value="";
							parent.frames[2].document.forms[0].patientid.focus();
							parent.frames[2].document.forms[0].patientid.onblur();

						} 
						parent.frames[2].document.forms[0].currfilelocn.value = "";
						parent.frames[2].document.forms[0].filestat.value = "";
						parent.frames[2].document.forms[0].remarks.value = "";
						parent.frames[2].document.getElementById("patline").innerText ="";
			</script>
		<%
		}
		else
		{
			sql = "";
			sql = "SELECT to_char(A.SENT_DATE_TIME,'dd/mm/rrrr hh:mi AM') FROM FM_TRANSIT_FILE A WHERE A.FACILITY_ID = ? AND A.FILE_NO = ? AND DEST_FACILITY_ID = ? AND DEST_FS_LOCN_CODE = ?";



		    if(!volume_no.equals(""))
			{
				sql = sql+" AND volume_no ='"+volume_no+"'";
			}
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,facility_id);
			pstmt.setString(2,p_file_no);
			pstmt.setString(3,Facility);
			pstmt.setString(4,selLocn);
			
			

			
			rs = pstmt.executeQuery();			

			String p_error_message = "", p_sent_date_time="";
			while(rs != null && rs.next())
			{
				p_file_no_found++;			
				p_sent_date_time = rs.getString(1); 
			}
			if(rs!=null) rs.close();
			if(pstmt!=null) pstmt.close();

			

			if (p_file_no_found ==0)	
			{
				sql = "";
				//sql = "SELECT A.REQ_FS_LOCN_DESC || ' (' || A.REQ_FACILITY_NAME || ')', TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM'),A.REQ_BY_NAME FROM FM_REQ_HDR_VW A, FM_REQ_DTL B WHERE A.REQ_NO=B.REQ_NO AND A.REQ_FS_LOCN_CODE = ? AND A.REQ_FACILITY_ID = ? AND B.FILE_NO= ? AND B.ISS_YN='N' AND B.CANCEL_YN = 'N'";
				sql = "SELECT"
					  +"  fm_Get_desc.Fm_storage_locn('"+facility_id+"',a.REQ_FS_LOCN_CODE,'"+localeName+"',2) ||' (' ||sm_Get_desc.SM_FACILITY_PARAM(a.REQ_FACILITY_ID,'"+localeName+"',1) ||')'"
					  +"  , TO_CHAR(A.ADDED_DATE,'DD/MM/RRRR HH:MI AM')"
					  +"  , SM_GET_DESC.SM_APPL_USER(REQ_USER_ID,'"+localeName+"','1') REQ_BY_NAME "
					  +"FROM"
					  +"  FM_REQ_HDR A"
					  +"  , FM_REQ_DTL B "
					  +"WHERE A.REQ_NO = B.REQ_NO "
					  +"  AND A.REQ_FS_LOCN_CODE = ? "
					  +"  AND A.REQ_FACILITY_ID = ?"
					  +"  AND B.FILE_NO = ? "
					   +"  AND B.VOLUME_NO = ? "
					  +"  AND B.ISS_YN = 'N' "
					  +"  AND B.CANCEL_YN = 'N'";

								
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1,selLocn);
				pstmt.setString(2,Facility);
				pstmt.setString(3,p_file_no);
				pstmt.setString(4,volume_no);
				rs = pstmt.executeQuery();
				
				while(rs != null && rs.next())
				{
					p_file_no_found++;

					//p_error_message =" File no " + p_file_no + " already requested by " + rs.getString(1) + " on " + rs.getString(2) + " by " + rs.getString(3) ;
					//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_REQUSTED","fm_messages");

					message = MessageManager.getMessage(localeName,"FILE_ALREADY_REQUSTED","FM");
					p_error_message = (String) message.get("message");
					
					
                    String addedDate=DateUtils.convertDate(rs.getString(2),"DMYHMA","en",localeName); //this line added for this SCF RUT-SCF-0360 [IN:046675]
                

					p_error_message=p_error_message.replace("$",p_file_no);
					p_error_message=p_error_message.replace("#",rs.getString(1));
					p_error_message=p_error_message.replace("~",addedDate);//this line modified for this SCF RUT-SCF-0360 [IN:046675]
					p_error_message=p_error_message.replace("%",rs.getString(3)); 
										
				}
			}
			else
			{
				//p_error_message =" File no " + p_file_no + " is already been issued on " + p_sent_date_time  ;
				//p_error_message=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"FILE_ALREADY_ISSUED","fm_messages");

				message = MessageManager.getMessage(localeName,"FILE_ALREADY_ISSUED","FM");
				p_error_message = (String) message.get("message"); 				
           
		      
			    String issueDate=DateUtils.convertDate(p_sent_date_time,"DMYHMA","en",localeName); //this line added for this SCF RUT-SCF-0360 [IN:046675]

				p_error_message=p_error_message.replace("$",p_file_no);
				p_error_message=p_error_message.replace("#",issueDate); 
			}
			%>			
			<script> 
			//	if('<%=file_status%>' == "T")
				//{
					if(parseInt('<%=p_file_no_found%>') > 0 )
				 	{
						alert(getMessage('FILE_ALREADY_REQUESTED','FM')+"\n"+ "<%=p_error_message%>");
						var p_file_no_length = parent.frames[2].document.forms[0].p_file_no_length.value ;
                        parent.frames[2].document.forms[0].Curr_file_status.value="requested";
						var rec_count=parseInt("<%=rec_count%>");
						if("<%=volcount%>"=="1" && rec_count==1){
							parent.frames[2].document.forms[0].fileno.value = "";				
							parent.frames[2].document.forms[0].patientid.value="";
							parent.frames[2].document.forms[0].patientid.focus();
							parent.frames[2].document.forms[0].patientid.onblur();

						}
						
						parent.frames[2].document.forms[0].currfilelocn.value='';
						parent.frames[2].document.forms[0].filestat.value='';
						parent.frames[2].document.forms[0].remarks.value='';						
						parent.frames[2].document.getElementById("patline").innerText ="";						
					}
					else if(('<%=file_status%>' == "T" || '<%=file_status%>' == "E") && ('<%=file_type%>' !="" || '<%=fileno%>' !=""))
					{						
						var errors="";
						//if('<%=file_type%>' !== "")
					//	{
						errors = getMessage('FILE_STATUS_TRANSIT','FM');
					   //  }	
						
						parent.frames[2].document.forms[0].Curr_file_status.value="T";
						var rec_count=parseInt("<%=volcount%>");
						
						var rec_count=parseInt("<%=rec_count%>");
						
							if("<%=volcount%>"=="1" && rec_count==1){
											
							parent.frames[2].document.forms[0].fileno.value = ""; 							
							parent.frames[2].document.forms[0].patientid.value="";
							parent.frames[2].document.forms[0].patientid.focus();
							parent.frames[2].document.forms[0].patientid.onblur();

						}
						
						parent.frames[2].document.forms[0].currfilelocn.value = "";
						parent.frames[2].document.forms[0].filestat.value = "";
						parent.frames[2].document.forms[0].remarks.value = "";
						parent.frames[2].document.getElementById("patline").innerText ="";
						parent.frames[4].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
						
					} 			
				
				else if(parseInt('<%=p_file_no_found%>') ==0)
				{
					if('<%=file_type%>' !="" || '<%=fileno%>' !="" )
					{
						
						if("<%=FirstcurrDesc%>" != "" && "<%=FirstcurrIdDesc%>" != "")
						parent.frames[2].document.forms[0].currfilelocn.value = "<%=FirstcurrDesc%> (<%=FirstcurrIdDesc%>)";
						parent.frames[2].document.forms[0].filestat.value = "<%=FirstcurrStatDesc%>";
					parent.frames[2].document.forms[0].remarks.readOnly=false;
					parent.frames[2].document.forms[0].remarks.value = "<%=Firstremark%>";
					parent.frames[2].document.forms[0].Curr_file_status.value="";
					}	else{
                  
					  parent.frames[2].document.forms[0].remarks.value ="" ;
					    parent.frames[2].document.forms[0].remarks.readOnly=true;
					}
					parent.frames[2].document.forms[0].Req_on.value = "<%=sysdate%>";
					parent.frames[2].document.forms[0].Curr_facility_id.value = "<%=FirstcurrFacility%>";
					parent.frames[2].document.forms[0].Curr_locn_code.value = "<%=FirstcurrLocn%>";
					parent.frames[2].document.forms[0].Curr_locn_desc.value = "<%=FirstcurrDesc%>";
					parent.frames[2].document.forms[0].Curr_locn_iden.value = "<%=FirstcurrIden%>";
					parent.frames[2].document.forms[0].Curr_locn_mr_locn.value = 
					"<%=FirstcurrMrLocn%>";								
					parent.frames[2].document.forms[0].patient_file_type_desc.value = 
					"<%=file_type_desc%>";
					var pat_line= "<%=pat_line%>";
					pat_line=encodeURIComponent(pat_line,"UTF-8")
					parent.frames[2].document.forms[0].Pat_line.value =pat_line;
					parent.frames[2].document.forms[0].remarks.focus();
					
					
					if("<%=otherFileSel%>" == "N")
					{
				}
			}
			</script>
		<%
		}
		%>
		<script>
			
			if("<%=file_type%>"=="")
			{
				
				//parent.frames[2].document.forms[0].flag.value='';
	//	alert("frame name:"+parent.frames[2].name);
	//parent.frames[2].populateDynamicValues(parent.frames[2].document.forms[0].patientid.value);
			}
		
		//parent.frames[2].document.forms[0].Curr_file_status.value="<%=file_status%>";
		
		
		</script>
	<%
	if(rs!=null) rs.close();
	if(rs1!=null) rs1.close();
	if(pstmt!=null) pstmt.close();
	if(pstmt1!=null) pstmt1.close();

	}catch(Exception e){ 
		e.printStackTrace();
		}
	finally
	{		
		ConnectionManager.returnConnection(con,request);
	}
	%>
	</form>
</body>
</html>

