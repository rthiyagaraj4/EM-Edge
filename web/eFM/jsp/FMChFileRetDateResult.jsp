<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	01/07/2002
	Module			:	FM - File Storage Location for Bed.
	Function		:	This function is used split into three frame structure.
--> 
<%@ page import="java.sql.*, java.util.*,java.text.*,webbeans.eCommon.*,eCommon.Common.*,com.ehis.util.*,eFM.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html> 
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/CommonCalendar.css'></link>
	<Script language="JavaScript" src="../../eCommon/js/CommonCalendar.js" ></Script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMChFileRetDate.js'></script>
	<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
</head>
<%
Connection con				=	null;
java.sql.Statement stmt		=	null;
PreparedStatement pstmt		=	null;
ResultSet rs				=	null;
ResultSet prs				=	null;

//Added for this CRF HSA-CRF-0306.1
PreparedStatement pstmt1 = null;
ResultSet rset = null;
StringBuffer query_result = null;

String str					 = "";
String facility_id			 = "";
String curr_file_status      = "";
String curr_fs_locn_code     = "";
String curr_fs_locn_identity = "";
String short_desc            = "";
String login_user            = "";
String user_id               = "";
String curr_holder_name      = "";
String iss_date_time		 = "", return_date_time = "";
String user_security_yn      = "N";
String remarks				 = "", file_no = "", curr_facility_name = ""; 
String volume_no			 = "", sys_date = "";
String p_access_all			 = "";
String curr_file_status_old="";
String patient_id="";
String  volume_no1="";
String filenum="";
String str1="";
String curr_file_status1="";
String current_fs_location=""; //Added for this CRF HSA-CRF-0306.1
boolean isCurrentFsLocation=false;//Added for this CRF HSA-CRF-0306.1
String curr_locn_id="";//Added for this CRF HSA-CRF-0306.1
try
{
	con		= ConnectionManager.getConnection(request);
	
	isCurrentFsLocation = CommonBean.isSiteSpecific(con,"FM","CURRENT_FS_LOCATION");//Added for this CRF HSA-CRF-0306.1
	
	stmt	= con.createStatement();

	query_result	= new StringBuffer();
	
	facility_id	= (String)session.getValue("facility_id");
	login_user	= (String)session.getValue("login_user");
	
	str					= request.getParameter("whereClause"); 
	user_id				= request.getParameter("user_id");
	user_security_yn	= request.getParameter("user_security_yn");
	p_access_all		= request.getParameter("p_access_all");
	sys_date			= request.getParameter("sysDate");

	patient_id			= request.getParameter("patient_id");
	volume_no1			= request.getParameter("volume_no");
	filenum			= request.getParameter("filenum");
	
	//Added for this CRF HSA-CRF-0306.1
	current_fs_location=request.getParameter("current_fs_location");
	if(current_fs_location==null || current_fs_location.equals("null"))current_fs_location="";
	
	if(patient_id == null || patient_id.equals("null")) patient_id = ""; 
	if(volume_no1 == null || volume_no1.equals("null")) volume_no1 = ""; 
	if(filenum == null || filenum.equals("null")) filenum = ""; 
	
	if(user_security_yn == null || user_security_yn.equals("null")) user_security_yn = "N"; 
	if(p_access_all == null || p_access_all.equals("null")) p_access_all = ""; 
	if(sys_date == null || sys_date.equals("null")) sys_date = ""; 
	if(str == null) str = "";

	   if(!filenum.equals(""))
     { 
      str1="select curr_file_status from fm_curr_locn where facility_id = '"+facility_id+"' and patient_id='"+patient_id+"' AND file_no='"+filenum+"' and volume_no='"+volume_no1+"' ";
     
		
		pstmt	= con.prepareStatement(str1);
	rs		= pstmt.executeQuery();
	if(rs != null)
	{
		if(rs.next())
		{
	     curr_file_status1=rs.getString("curr_file_status");
		
		}
	}	
	
	}

	
  if(rs!=null)	rs.close();
  if(pstmt != null) pstmt.close();
	if(!curr_file_status1.equals("L"))
	{
	if(user_security_yn.equals("Y"))
	{
		if(p_access_all.equals("*ALL"))/*Modified by Sangeetha S on 26-SEP-2016 against ML-MMOH-SCF-0442*/
		{
			/*query_result.append("SELECT decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status, curr_fs_locn_code , decode(curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, curr_fs_locn_desc short_desc, curr_holder_name, TO_CHAR(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time, file_no,file_type_code, TO_CHAR(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, remarks,(CASE WHEN a.curr_facility_id<>a.facility_id THEN '/ (' || curr_facility_name ||')' ELSE '' END )curr_facility_name,volume_no FROM fm_curr_locn_vw a WHERE a.facility_id = ? AND curr_file_status NOT IN ('T','L','A','R') AND  ((curr_file_status = 'I' AND mr_pat_fs_locn_code != curr_fs_locn_code ) OR (curr_file_status = 'O' ))  ");*/
			query_result.append("SELECT" );
			query_result.append("  Curr_File_Status" );
			query_result.append("  , Curr_fs_Locn_Code" );
			query_result.append("  , Curr_fs_Locn_Identity" );
			query_result.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',1) Short_desc" );
			query_result.append("  , SM_GET_DESC.SM_APPL_USER(CURR_HOLDER_USER_ID,'"+localeName+"','1') Curr_Holder_Name" );
			query_result.append("  , TO_CHAR(Iss_Date_Time,'dd/mm/yyyy hh24:mi') Iss_Date_Time" );
			query_result.append("  , File_No" );
			query_result.append("  , File_Type_Code" );
			query_result.append("  , TO_CHAR(Return_Date_Time,'dd/mm/yyyy hh24:mi') Return_Date_Time" );
			query_result.append("  , Remarks" );
			query_result.append("  , (" );
			query_result.append("  CASE " );
			query_result.append("  WHEN a.Curr_Facility_Id <> a.Facility_Id " );
			query_result.append("  THEN" );
			query_result.append("    '/ (' ||SM_GET_DESC.SM_FACILITY_PARAM(CURR_FACILITY_ID,'"+localeName+"','1') ||')' " );
			query_result.append("  ELSE '' " );
			query_result.append("  END) Curr_Facility_Name" );
			query_result.append("  , Volume_No ,curr_locn_id " );
			query_result.append("FROM" );
			query_result.append("  fm_Curr_Locn a " );
			query_result.append("WHERE a.Facility_Id = ? " );
			query_result.append("  AND Curr_File_Status NOT IN ('T', 'A', 'R') " );
			query_result.append("  AND " );
			query_result.append("  (" );
			query_result.append("    " );
			query_result.append("    (" );
		//	query_result.append("      Curr_File_Status IN( 'I','L') " );
			query_result.append("      Curr_File_Status IN('L') " );
			query_result.append("      AND PERM_FS_LOCN_CODE != Curr_fs_Locn_Code" );
			query_result.append("    ) " );
			query_result.append("  OR " );
			query_result.append("    (" );
			query_result.append("      Curr_File_Status = 'O'" );
			query_result.append("    )" );
			query_result.append("  )" );
			query_result.append(str);
			//out.println(query_result.toString());
			pstmt	= con.prepareStatement(query_result.toString());
						
			pstmt.setString(1,facility_id);
		}
		else
		{
			//query_result.append("SELECT decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status, curr_fs_locn_code , decode(curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit')curr_fs_locn_identity, curr_fs_locn_desc short_desc, curr_holder_name, to_char(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time,file_no,file_type_code, to_char(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, remarks,(CASE WHEN a.curr_facility_id<>a.facility_id THEN '/ (' || curr_facility_name ||')' ELSE '' END )curr_facility_name,volume_no FROM fm_curr_locn_vw a, fm_user_access_rights d WHERE return_date_time is not null and  a.facility_id = ? and curr_file_status NOT IN ('T','L','A','R') AND  ((curr_file_status = 'I' AND mr_pat_fs_locn_code != curr_fs_locn_code ) OR (curr_file_status = 'O' )) AND a.facility_id=d.facility_id AND a.mr_pat_fs_locn_code=d.fs_locn_code AND d.change_return_date_yn='Y' AND d.appl_user_id = ? ");
			query_result.append("SELECT" );
			query_result.append("  Curr_File_Status" );
			query_result.append("  , Curr_fs_Locn_Code" );
			query_result.append("  , Curr_fs_Locn_Identity" );
			query_result.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',1) Short_desc" );
			query_result.append("  , SM_GET_DESC.SM_APPL_USER(CURR_HOLDER_USER_ID,'"+localeName+"','1') Curr_Holder_Name" );
			query_result.append("  , TO_CHAR(Iss_Date_Time,'dd/mm/yyyy hh24:mi') Iss_Date_Time" );
			query_result.append("  , File_No" );
			query_result.append("  , File_Type_Code" );
			query_result.append("  , TO_CHAR(Return_Date_Time,'dd/mm/yyyy hh24:mi') Return_Date_Time" );
			query_result.append("  , Remarks" );
			query_result.append("  , (" );
			query_result.append("  CASE " );
			query_result.append("  WHEN a.Curr_Facility_Id <> a.Facility_Id " );
			query_result.append("  THEN" );
			query_result.append("    '/ (' ||SM_GET_DESC.SM_FACILITY_PARAM(CURR_FACILITY_ID,'"+localeName+"','1') ||')' " );
			query_result.append("  ELSE '' " );
			query_result.append("  END) Curr_Facility_Name" );
			query_result.append("  , Volume_No ,curr_locn_id " );
			query_result.append("FROM" );
			query_result.append("  fm_Curr_Locn a" );
			query_result.append("  , fm_User_Access_Rights d " );
			query_result.append("WHERE" );/*Modified by Sangeetha S on 26-SEP-2016 against ML-MMOH-SCF-0442*/
//			query_result.append("WHERE Return_Date_Time IS" );
//			query_result.append("  NOT NULL " );
			query_result.append("  a.Facility_Id = ? " );
			query_result.append("  AND Curr_File_Status NOT IN ('T','A', 'R') " );
			query_result.append("  AND " );
			query_result.append("  (" );
			query_result.append("    " );
			query_result.append("    (" );
			//query_result.append("      Curr_File_Status IN( 'I','L') " );
			query_result.append("      Curr_File_Status IN('L') " );
			query_result.append("      AND PERM_FS_LOCN_CODE != Curr_fs_Locn_Code" );
			query_result.append("    ) " );
			query_result.append("  OR " );
			query_result.append("    (" );
			query_result.append("      Curr_File_Status = 'O'" );
			query_result.append("    )" );
			query_result.append("  ) " );
			query_result.append("  AND a.Facility_Id = d.Facility_Id " );
		//	query_result.append("  AND a.PERM_FS_LOCN_CODE = d.fs_Locn_Code " );
			query_result.append("  AND d.Change_Return_Date_yn = 'Y' " );
			query_result.append("  AND d.apPl_User_Id = ?" );

			query_result.append(str);
			
			if(pstmt != null) pstmt.close();
			pstmt	= con.prepareStatement(query_result.toString());
			pstmt.setString(1,facility_id);
			pstmt.setString(2,login_user);
		}
	}
	else if(user_security_yn.equals("N"))
	{
		//query_result.append("SELECT decode(curr_file_status, 'T', 'In Transit', 'I', 'Inside', 'L','Lost','A', 'Archived','O', 'Outside') curr_file_status, curr_fs_locn_code , DECODE(curr_fs_locn_identity, 'D','Department','T','Practitioner','C','Clinic','N','Nursing Unit','X','External','E','Procedure Unit','Y','Daycare Unit') curr_fs_locn_identity, curr_fs_locn_desc short_desc, curr_holder_name,file_no,file_type_code, to_char(iss_date_time,'dd/mm/yyyy hh24:mi')iss_date_time, to_char(return_date_time,'dd/mm/yyyy hh24:mi')return_date_time, remarks, file_no,(CASE WHEN curr_facility_id<>facility_id THEN '/ (' || curr_facility_name ||')' ELSE '' END )curr_facility_name,volume_no FROM fm_curr_locn_vw  WHERE return_date_time IS NOT NULL AND  facility_id = ? AND curr_file_status NOT IN ('T','L','A','R') AND  ((curr_file_status = 'I' AND mr_pat_fs_locn_code != curr_fs_locn_code) OR (curr_file_status = 'O' and mr_pat_fs_locn_code !=  curr_fs_locn_code)) ");

		query_result.append("SELECT" );
		query_result.append("  Curr_File_Status" );
		query_result.append("  , Curr_fs_Locn_Code" );
		query_result.append("  , Curr_fs_Locn_Identity" );
		query_result.append("  , fm_Get_desc.Fm_storage_locn('"+facility_id+"',Curr_fs_Locn_Code,'"+localeName+"',1) Short_desc" );
		query_result.append("  , SM_GET_DESC.SM_APPL_USER(CURR_HOLDER_USER_ID,'"+localeName+"','1') Curr_Holder_Name" );
		query_result.append("  , File_No" );
		query_result.append("  , File_Type_Code" );
		query_result.append("  , TO_CHAR(Iss_Date_Time,'dd/mm/yyyy hh24:mi') Iss_Date_Time" );
		query_result.append("  , TO_CHAR(Return_Date_Time,'dd/mm/yyyy hh24:mi') Return_Date_Time" );
		query_result.append("  , Remarks" );
		query_result.append("  , File_No" );
		query_result.append("  , (" );
		query_result.append("  CASE " );
		query_result.append("  WHEN Curr_Facility_Id <> Facility_Id " );
		query_result.append("  THEN" );
		query_result.append("    '/ (' ||SM_GET_DESC.SM_FACILITY_PARAM(CURR_FACILITY_ID,'"+localeName+"','1') ||')' " );
		query_result.append("  ELSE '' " );
		query_result.append("  END) Curr_Facility_Name" );
		query_result.append("  , Volume_No ,curr_locn_id " );
		query_result.append("FROM" );
		query_result.append("  fm_Curr_Locn " );
		query_result.append("WHERE" );/*Modified by Sangeetha S on 26-SEP-2016 against ML-MMOH-SCF-0442*/
	//	query_result.append("WHERE Return_Date_Time IS" );
	//	query_result.append("  NOT NULL " );
		query_result.append("  Facility_Id = ? " );
		query_result.append("  AND Curr_File_Status NOT IN ('T','A', 'R') " );
		query_result.append("  AND " );
		query_result.append("  (" );
		query_result.append("    " );
		query_result.append("    (" );
		//query_result.append("      Curr_File_Status IN ( 'I','L') " );
		query_result.append("      Curr_File_Status IN ('L') " );
		query_result.append("      AND PERM_FS_LOCN_CODE != Curr_fs_Locn_Code" );
		query_result.append("    ) " );
		query_result.append("  OR " );
		query_result.append("    (" );
		query_result.append("      Curr_File_Status = 'O' " );
		query_result.append("      AND PERM_FS_LOCN_CODE != Curr_fs_Locn_Code" );
		query_result.append("    )" );
		query_result.append("  )" );

		query_result.append(str);
		
		if(pstmt != null) pstmt.close();
		pstmt	= con.prepareStatement(query_result.toString());
		pstmt.setString(1,facility_id);
	}
	
	System.out.println(" ********************* Inside FMChFileRetDateResult 279 query_result : "+query_result);
	prs		= pstmt.executeQuery();
	if(prs != null)
	{
		if(prs.next())
		{
			curr_file_status		=	prs.getString("curr_file_status");
			curr_fs_locn_code		=	prs.getString("curr_fs_locn_code");
			curr_fs_locn_identity	=	prs.getString("curr_fs_locn_identity");
			short_desc				=	prs.getString("short_desc");
			curr_holder_name		=	prs.getString("curr_holder_name");
			iss_date_time			=	prs.getString("iss_date_time");
			return_date_time		=	prs.getString("return_date_time");
			remarks					=	prs.getString("remarks");
			file_no					=	prs.getString("file_no");
			curr_facility_name		=	prs.getString("curr_facility_name");
			volume_no		        =	prs.getString("volume_no");
			curr_locn_id            =	prs.getString("curr_locn_id"); //Added for this CRF HSA-CRF-0306.1
			
			if(curr_locn_id==null || curr_locn_id.equals("null")) curr_locn_id=""; //Added for this CRF HSA-CRF-0306.1
			
			if(curr_file_status == null || curr_file_status.equals("null")) curr_file_status="";
			if(curr_fs_locn_code == null || curr_fs_locn_code.equals("null")) curr_fs_locn_code="";
			if(curr_fs_locn_identity == null || curr_fs_locn_identity.equals("null")) curr_fs_locn_identity="";
			if(short_desc == null || short_desc.equals("null")) short_desc="";
			if(curr_holder_name == null || curr_holder_name.equals("null")) curr_holder_name="";
		curr_file_status_old=curr_file_status;
			if(iss_date_time != null)
			{
				iss_date_time=DateUtils.convertDate(iss_date_time,"DMYHM","en",localeName);
			}
			else
				iss_date_time="";


			if(return_date_time != null)
			{
				return_date_time=DateUtils.convertDate(return_date_time,"DMYHM","en",localeName);
			}
			else
				return_date_time="";
			if(remarks == null || remarks.equals("null")) remarks="";
			if(curr_facility_name == null || curr_facility_name.equals("null")) curr_facility_name="";

			if(!curr_fs_locn_identity.equals(""))
		{
			switch(curr_fs_locn_identity.charAt(0))
			{
				case 'D' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.department.label","common_labels"); break;

				case 'C' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clinic.label","common_labels"); break;

				case 'N' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.nursingUnit.label","common_labels"); break;

				case 'T' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.practitioner.label","common_labels"); break;

				case 'X' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.external.label","common_labels"); break;

				case 'E' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.ProcedureUnit.label","common_labels"); break;

				case 'Y' : curr_fs_locn_identity = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.DaycareUnit.label","common_labels"); break;
		
			}
		}

		if(!curr_file_status.equals(""))
		{
			switch(curr_file_status.charAt(0))
			{
				case 'T' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileInTransit.label","fm_labels"); break;

				case 'I' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisInside.label","fm_labels"); break;

				case 'L' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisLost.label","fm_labels"); break;

				case 'A' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisArchived.label","fm_labels"); break;

				case 'O' : curr_file_status = com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.FileisOutside.label","fm_labels"); break;
		
			}
		}
%>
<body onMouseDown='CodeArrest()' onLoad='document.forms[0].return_date_time.focus()' onKeyDown = 'lockKey();'>
<center>
<form name='FMChFileRetDateResultFrame' id='FMChFileRetDateResultFrame'>
<table cellpadding='3' cellspacing='0' border='0' width='100%'>
<tr>
	<td class='label' width='25%'><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></td>
	<td class='fields' width='25%'><input type='text' name='curr_file_status' id='curr_file_status' value='<%=curr_file_status%>' size='30'  disabled > </td>
<!-- </tr>
<tr> -->
	<td class='label' width='25%'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
	<td class='fields' width='25%'><input type='text' name='curr_fs_locn_desc' id='curr_fs_locn_desc'
	value='<%=short_desc%> (<%=curr_fs_locn_identity%>)' size ='30' maxlength='45' disabled ><input type='hidden' name='curr_fs_locn_code' id='curr_fs_locn_code' value='<%=curr_fs_locn_code%>'><font size=1><%=curr_facility_name%></font></td>
</tr>
<tr>
	<td class='label'><fmt:message key="eFM.HolderName.label" bundle="${fm_labels}"/></td>
	<td class='fields' ><input type='text' name='curr_holder_name' id='curr_holder_name' value='<%=curr_holder_name%>' size='30' disabled ></td>
<!-- </tr>
<tr> -->
	<td class='label'><fmt:message key="eFM.IssueDateTime.label" bundle="${fm_labels}"/></td>
	<td class='fields' ><input type='text' name='iss_date_time' id='iss_date_time' value='<%=iss_date_time%>' size='16' disabled></td>
</tr>
<tr>
	<!--Modified by Ashwini on 18-Jul-2017 for ML-MMOH-SCF-0763-->
	<td class='label'><fmt:message key="eFM.ReturnDueDateTime.label" bundle="${fm_labels}"/></td>
	<td class='fields' ><input type='text' id ='returndatetime' name='return_date_time' id='return_date_time' value='<%=return_date_time%>' size='16' maxlength='16' onBlur='validDateObj(this,"DMYHM","<%=localeName%>");<%if(isCurrentFsLocation){%>holidayvalidation("<%=facility_id%>","<%=file_no%>","<%=volume_no%>","<%=patient_id%>","<%=current_fs_location%>");<%}%>'><input type="image" src="../../eCommon/images/CommonCalendar.gif"  onClick="return showCalendar('returndatetime', null, 'hh:mm');"><img src='../../eCommon/images/mandatory.gif'></img></td>
	<td class='label' colspan='2'>&nbsp;</td>
</tr>
<tr>
	<td class='label' ><fmt:message key="Common.remarks.label" bundle="${common_labels}"/></td>
	<td class='fields' colspan='2' ><textarea style='resize:none'; rows='3' cols='35' name='remarks'  onkeypress="checkMaxLimit(this,100)" onBlur="makeValidString(this);CheckMaxLen('Remarks',this,100,parent.parent.frames[2])" ><%=remarks%></textarea></td>
	<td class='label' >&nbsp;</td>
</tr>
<input type='hidden' name='file_no' id='file_no' value='<%=file_no%>'>
<input type='hidden' name='volume_no' id='volume_no' value='<%=volume_no%>'>
<input type='hidden' name='sys_date' id='sys_date' value='<%=sys_date%>'>
<input type='hidden' name='user_id' id='user_id' value='<%=user_id%>'>
<input type='hidden' name='localeName' id='localeName' value='<%=localeName%>'> <!-- Added for this CRF HSA-CRF-0306.1 -->
<input type='hidden' name='return_date_time_defaulted' id='return_date_time_defaulted' value='<%=return_date_time%>'> <!-- Added for this CRF HSA-CRF-0306.1 -->
<input type='hidden' name='isCurrentFsLocation' id='isCurrentFsLocation' value='<%=isCurrentFsLocation%>'> <!-- Added for this CRF HSA-CRF-0306.1 --> 
<input type='hidden' name='current_fs_locn_code' id='current_fs_locn_code' value='<%=curr_fs_locn_code%>'>  <!-- Added for this CRF HSA-CRF-0306.1 --> 
<input type='hidden' name='curr_locn_id' id='curr_locn_id' value='<%=curr_locn_id%>'> 
</table>
</form>
</center>
</body>
</html>
<script>
	parent.frames[0].document.forms[0].p_curr_fs_loc.disabled=true;
	parent.frames[0].document.forms[0].patient_id.disabled=true;
	parent.frames[0].document.forms[0].pat_search.disabled=true;
	if(parent.frames[0].document.forms[0].file_no != null)
		parent.frames[0].document.forms[0].file_no.disabled=true;
	if(parent.frames[0].document.forms[0].file_type_code != null)
		parent.frames[0].document.forms[0].file_type_code.disabled=true;
	parent.frames[0].document.forms[0].reset1.disabled=false;
	parent.frames[0].document.forms[0].search_dtl.disabled=false;
	parent.frames[0].document.forms[0].pat_search.disabled=false;
	parent.frames[0].document.forms[0].p_curr_fs_loc.disabled=false;
</script>
		<%
			

}
		else
		{
			%>
			<script>
				var msg = getMessage('FILE_RET_DATE_NOT_CHANGE','FM');
				parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;			
				parent.frames[0].document.forms[0].reset1.disabled=false;
				parent.frames[0].document.forms[0].search_dtl.disabled=false;
				parent.frames[0].document.forms[0].pat_search.disabled=false;
				parent.frames[0].document.forms[0].p_curr_fs_loc.disabled=false;
			</script>
			<%
		}
	
	
	}
	if((query_result != null) && (query_result.length() > 0))
	{
		query_result.delete(0,query_result.length());
	}
	
	}else{
   
	%>
			<script>
				var msg = getMessage('FILE_IS_LOST','FM');
				parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp?err_num='+msg;			
				parent.frames[0].document.forms[0].reset1.disabled=false;
				parent.frames[0].document.forms[0].search_dtl.disabled=false;
				parent.frames[0].document.forms[0].pat_search.disabled=false;
				parent.frames[0].document.forms[0].p_curr_fs_loc.disabled=false;
			</script>
			<%
		}
	
	if(rs!=null)	rs.close();
	if(prs!=null)	prs.close();
	if(stmt!= null) stmt.close();
	if(pstmt!= null)pstmt.close();
}catch(Exception e){out.println("Exception e :"+e);}
finally
{	
	ConnectionManager.returnConnection(con, request);
}
%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString == null) ? "" :	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString == null) || (inputString == "") ||(inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

