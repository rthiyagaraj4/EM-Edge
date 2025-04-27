<!DOCTYPE html>
<!--
	Developed by 	:	Prakash.S
	Created on 		:	17/06/2002
	Module			:	FM - Change File Return Date
	Function		:	This function is used for Search Criteria.
-->

<%@ page import="java.sql.*, java.util.*, java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<%

Connection con			=	null;
PreparedStatement pstmt =	null;
ResultSet	rs			=	null;

String addedById	= (String) session.getValue("login_user" ) ;
String facilityid 	= (String) session.getValue("facility_id");

String appl_user_name	= "", user_security_yn = "";
String p_access_all		= "";
String sql1				= "";
String p_code			= "";
String p_desc			= "";
String sysDate			= "";

int count = 0;

StringBuffer SelectSqlBuffer = null;

try
{
	con		=	ConnectionManager.getConnection(request);
	
	SelectSqlBuffer = new StringBuffer();

	
	user_security_yn	= request.getParameter("user_security_yn");
	p_access_all		= request.getParameter("p_accass_all");
	
	if(user_security_yn == null || user_security_yn.equals("null")) user_security_yn="N";
	if(p_access_all == null || p_access_all.equals("null")) p_access_all="";
	
%>
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
	%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eFM/js/FMChFileRetDate.js'></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	
	<script>
	function fetchResults(val)
{  
 var obj=val;
 var patient_id="";
 var filenum="";
 var volume_no="";
 var to_proceed=true;
	var file_type_appl_yn = FMChFileRetDateCriteriaForm.file_type_appl_yn.value;	
	var doc_or_file = FMChFileRetDateCriteriaForm.maintain_doc_or_file.value;
	if(doc_or_file == 'D')
	{
		var fields = new Array ( FMChFileRetDateCriteriaForm.p_curr_fs_loc,FMChFileRetDateCriteriaForm.doc_folder_id,FMChFileRetDateCriteriaForm.doc_type_id);
		var issfsloc= getLabel("Common.Issue.label","Common") + getLabel("eFM.FSLocation.label","FM");
		var names = new Array ( issfsloc, getLabel("eFM.DocumentFolder.label","FM"), getLabel("Common.documenttype.label","common"));	
	}
	else if(doc_or_file == 'F')
	{
		if(file_type_appl_yn == 'N')
		{
			var fields = new Array ( FMChFileRetDateCriteriaForm.p_curr_fs_loc,FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.file_no,FMChFileRetDateCriteriaForm.volume_no);
			var issfsloc= getLabel("Common.Issue.label","Common") + getLabel("eFM.FSLocation.label","FM");
			var names = new Array ( issfsloc , getLabel("Common.patientId.label","common"), getLabel("Common.fileno.label","common"),getLabel("eFM.VolumeNo.label","FM"));	
		}
		else if(file_type_appl_yn == 'Y')
		{
			var fields = new Array ( FMChFileRetDateCriteriaForm.p_curr_fs_loc,FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.patient_file_type,FMChFileRetDateCriteriaForm.volume_no);
			var issfsloc= getLabel("Common.Issue.label","Common") + getLabel("eFM.FSLocation.label","FM");
			var names = new Array ( issfsloc , getLabel("Common.patientId.label","common"), getLabel("Common.filetype.label","common"),getLabel("eFM.VolumeNo.label","FM"));	
		}
	}
	
	var errors = "";
	for( var i=0; i<fields.length; i++ ) 
	{
		if(trimCheck(fields[i].value)) 
		{
			fields[i].value = trimString(fields[i].value);
		}
		else	
		{	
			//errors = errors + "APP-000001 " + names[i] + " cannot be blank..." + "<br>" ;
			errors=errors + getMessage("CAN_NOT_BE_BLANK","common") + "<br>";
			errors=errors.replace('$',names[i]);
		}
	}
	if ( errors.length != 0 ) 
	{
		parent.parent.frames[2].document.location.href="../../eCommon/jsp/error.jsp?err_num="+errors ;
		to_proceed = false;
		return false ;
	}
	var whereClause="and";
	var selectClause="";
	var strand = "";
	var empty = 0;
	var count_sql = "";
	var i=0;
	
	if(obj=='search')
	{
		if(doc_or_file == 'D')
		{
			var fields = new Array(FMChFileRetDateCriteriaForm.file_no, FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.patient_file_type);
		}
		else if(doc_or_file == 'F')
		{
		if(file_type_appl_yn == 'N')
		{
			var fields = new Array(FMChFileRetDateCriteriaForm.file_no, FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.volume_no);
		}
		else if(file_type_appl_yn == 'Y')
		{
			var fields = new Array(FMChFileRetDateCriteriaForm.file_no, FMChFileRetDateCriteriaForm.patient_id,FMChFileRetDateCriteriaForm.volume_no,FMChFileRetDateCriteriaForm.patient_file_type);
		}
		}
	}
	
	  patient_id=FMChFileRetDateCriteriaForm.patient_id.value;
	  filenum=FMChFileRetDateCriteriaForm.file_no.value;
	  volume_no=FMChFileRetDateCriteriaForm.volume_no.value;
	
	for(i=0;i<fields.length;i++) 
	{
		if(fields[i] != null)
		{
			if(trimCheck(fields[i].value))  empty++;
		}
	}
	if(empty != 0) 
	{
		flag=true;
		if(fields[0] != null)
        {
			if(trimCheck(fields[0].value)) 
			{
				whereClause = whereClause + " file_no = trim('" + fields[0].value + "') and ";
			}
		}
		if(fields[1] != null)
        {
			if( trimCheck(fields[1].value)) 
			{
				whereClause = whereClause + " patient_id = trim('" + fields[1].value + "') and ";
			}
		}
		if(doc_or_file != 'D')
		{
			if(fields[2] != null)
			{
				if(trimCheck(fields[2].value)) 
				{
					whereClause = whereClause + " volume_no = trim('" + fields[2].value + "') and ";
				}
			}
		}
		if(file_type_appl_yn == 'Y')
		{
			if(fields[3] != null)
			{
				if(trimCheck(fields[3].value)) 
				{
					whereClause = whereClause + " file_type_code = trim('" + fields[3].value + "') and ";
				}
			}
		}
		var p_curr_fs_loc = FMChFileRetDateCriteriaForm.p_curr_fs_loc.value;
		var user_id		  = FMChFileRetDateCriteriaForm.user_id.value;	
		//whereClause = whereClause + " mr_pat_fs_locn_code = trim('" + p_curr_fs_loc+ "') and ";
		whereClause = whereClause + " PERM_FS_LOCN_CODE = trim('" + p_curr_fs_loc+ "') and ";

		whereClause = whereClause + strand;
		var replace_url		= 	/%/g ;
		whereClause   	= whereClause.replace(replace_url,"~" );
		if(whereClause.lastIndexOf("and") != -1)
		whereClause = whereClause.substring(0,whereClause.lastIndexOf("and"));

		var user_security_yn = document.forms[0].user_security_yn.value;			
		var p_access_all	 = document.forms[0].p_access_all.value;			
		var sysDate			 = document.forms[0].sysDate.value;			
				
		if(obj=='search')
		{
			FMChFileRetDateCriteriaForm.search_dtl.disabled=true;
			FMChFileRetDateCriteriaForm.reset1.disabled=true;
			if(doc_or_file != 'D')
			{
				FMChFileRetDateCriteriaForm.pat_search.disabled=true;
			}
			FMChFileRetDateCriteriaForm.p_curr_fs_loc.disabled=true;
			
			if(doc_or_file == 'D')
			{
				parent.FMChFileRetDateResultFrame.location.href='../../eFM/jsp/DTChFileRetDateResult.jsp?whereClause='+whereClause+'&user_security_yn='+user_security_yn+'&p_access_all='+p_access_all+'&sysDate='+sysDate+'&patient_id='+patient_id+'&filenum='+filenum+'&volume_no='+volume_no+'&user_id='+user_id;
			}
			else if(doc_or_file == 'F')
			{
				parent.FMChFileRetDateResultFrame.location.href='../../eFM/jsp/FMChFileRetDateResult.jsp?whereClause='+whereClause+'&user_security_yn='+user_security_yn+'&p_access_all='+p_access_all+'&sysDate='+sysDate+'&patient_id='+patient_id+'&filenum='+filenum+'&volume_no='+volume_no+'&user_id='+user_id+'&current_fs_location='+p_curr_fs_loc; //Modified this line HSA-CRF-0306.1
			}
			parent.parent.frames[2].location.href='../../eCommon/jsp/error.jsp';
		}
		return true;
	}
	else
	{
		if(doc_or_file == 'D')
		{
		var msg =	getMessage('DOC_CAN_NOT_BE_BLANK','FM');
		}
		else if(doc_or_file == 'F')
		{
		var msg =	getMessage('FILE_CAN_NOT_BE_BLANK','FM');
		}
		if(msg!="")
		{
			parent.parent.messageFrame.location.href="../../eCommon/jsp/error.jsp?err_num="+msg+"&err_value=0";
			return false;
		}
	}
	
}
	function clearvalue(obj)
{
FMChFileRetDateCriteriaForm.patient_id.value="";
FMChFileRetDateCriteriaForm.patient_id.onblur();

}
	</script>
	

</head>
<body  onMouseDown='CodeArrest()' onLoad="document.FMChFileRetDateCriteriaForm.p_curr_fs_loc.focus();" onKeyDown = 'lockKey();'>
<form name='FMChFileRetDateCriteriaForm' id='FMChFileRetDateCriteriaForm' action='' method=''>
<%
	//sql1 = "select appl_user_name, TO_CHAR(sysdate,'dd/mm/yyyy hh24:mi') from sm_appl_user where appl_user_id = ? ";
	sql1 = "select appl_user_name, TO_CHAR(sysdate,'dd/mm/yyyy hh24:mi') from sm_appl_user_LANG_VW where appl_user_id = ? AND LANGUAGE_ID = ? ";
	
	pstmt = con.prepareStatement(sql1);
	pstmt.setString(1,addedById);
	pstmt.setString(2,localeName);
	rs = pstmt.executeQuery();
	while(rs != null && rs.next())
	{
		appl_user_name = rs.getString(1);
		sysDate		   = rs.getString(2);
	} 
	if(rs!=null)	rs.close();
	if(pstmt!=null) pstmt.close();	
		
	if(user_security_yn.equals("Y"))
	{
		if (p_access_all.equals("*ALL"))
		//if (p_access_all.equals("1"))
		{
		//	SelectSqlBuffer.append("select a.fs_locn_code,a.short_desc fs_locn_desc,a.narration_code from fm_storage_locn a  where a.eff_status='E' and a.facility_id='"+facilityid+"' and a.permanent_file_area_yn='Y' order by 2");
			SelectSqlBuffer.append("SELECT" );
			SelectSqlBuffer.append("  a.fs_Locn_Code" );
			SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facilityid+"',a.fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc" );
			SelectSqlBuffer.append("  , a.Narration_Code " );
			SelectSqlBuffer.append("FROM" );
			SelectSqlBuffer.append("  fm_storage_locn  a " );
			SelectSqlBuffer.append("WHERE a.eff_Status = 'E' " );
			//SelectSqlBuffer.append("  AND LANGUAGE_ID='"+localeName+"' " );
			SelectSqlBuffer.append("  AND a.Facility_Id = '"+facilityid+"' " );
			SelectSqlBuffer.append("  AND a.Permanent_File_Area_yn = 'Y' " );
			SelectSqlBuffer.append("ORDER BY" );
			SelectSqlBuffer.append("  2" );
		}
		else
		{
			//SelectSqlBuffer.append("select a.fs_locn_code,a.short_desc fs_locn_desc,a.narration_code from fm_storage_locn a , fm_user_access_rights b where a.eff_status='E' and a.facility_id=b.facility_id and a.fs_locn_code=b.fs_locn_code and b.appl_user_id='"+addedById+"' and b.facility_id='"+facilityid+"' and b.change_return_date_yn='Y'  order by 2");
			
			SelectSqlBuffer.append("SELECT" );
			SelectSqlBuffer.append("  a.fs_Locn_Code" );
			SelectSqlBuffer.append("  , a.Short_desc fs_Locn_desc" );
			SelectSqlBuffer.append("  , a.Narration_Code " );
			SelectSqlBuffer.append("FROM" );
			SelectSqlBuffer.append("  fm_storage_locn_lang_vw a" );
			SelectSqlBuffer.append("  , fm_User_Access_Rights b " );
			SelectSqlBuffer.append("WHERE a.eff_Status = 'E' " );
			SelectSqlBuffer.append("  AND a.LANGUAGE_ID='"+localeName+"'" );
			SelectSqlBuffer.append("  AND a.Facility_Id = b.Facility_Id " );
			SelectSqlBuffer.append("  AND a.fs_Locn_Code = b.fs_Locn_Code " );
			SelectSqlBuffer.append("  AND b.apPl_User_Id = '"+addedById+"' " );
			SelectSqlBuffer.append("  AND b.Facility_Id = '"+facilityid+"' " );
			SelectSqlBuffer.append("  AND b.Change_Return_Date_yn = 'Y' " );
			SelectSqlBuffer.append("ORDER BY" );
			SelectSqlBuffer.append("  2" );

		}
	}
	else
	{
		//SelectSqlBuffer.append("select a.fs_locn_code,a.short_desc fs_locn_desc from fm_storage_locn a where a.eff_status='E' and a.facility_id='"+facilityid+"' and a.permanent_file_area_yn='Y' order by 2");
		SelectSqlBuffer.append("SELECT" );
		SelectSqlBuffer.append("  a.fs_Locn_Code" );
		SelectSqlBuffer.append("  , fm_Get_desc.Fm_storage_locn('"+facilityid+"',a.fs_Locn_Code,'"+localeName+"',2) fs_Locn_desc " );
		SelectSqlBuffer.append("FROM" );
		SelectSqlBuffer.append("  fm_storage_locn  a " );
		SelectSqlBuffer.append("WHERE a.eff_Status = 'E' " );
		//SelectSqlBuffer.append("  AND A.LANGUAGE_ID='"+localeName+"'" );
		SelectSqlBuffer.append("  AND a.Facility_Id = '"+facilityid+"'" );
		SelectSqlBuffer.append("  AND a.Permanent_File_Area_yn = 'Y'" );
		SelectSqlBuffer.append("ORDER BY" );
		SelectSqlBuffer.append("  2" );

	}

	
	pstmt = con.prepareStatement(SelectSqlBuffer.toString());	

	
	
	rs	  = pstmt.executeQuery();
%>
<table cellpadding='2' cellspacing='0' border='0' width='100%' align='CENTER'>
	<tr>
		<td class='label' width="25%"><fmt:message key="eFM.IssueFSLocation.label" bundle="${fm_labels}"/></td>
		<td class='fields' width="25%"><select name='p_curr_fs_loc' id='p_curr_fs_loc' onchange='clearvalue(this.value);'>
				<option value=''>------ <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------</option>
				<%
				while(rs.next())
				{
					count++;
					p_code = rs.getString("fs_locn_code");
					p_desc = rs.getString("fs_locn_desc");
					%>
					<option value=<%=p_code%>><%=p_desc%></option>
					<%
				}
				%>
			</select><img src='../../eCommon/images/mandatory.gif' align='center'></img>
		</td>
		<td class='label' width="25%"><fmt:message key="Common.Changedby.label" bundle="${common_labels}"/></td>
		<!--Below line modifed for this SCF ML-MMOH-SCF-0361 -->
		<td class='fields' width='25%'>
		<%
			if(user_security_yn.equals("Y"))
			{
				%>
				<input type='text' name='appl_user_id1' id='appl_user_id1' value="<%=appl_user_name%>" readonly size='30' ><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=addedById%>' disabled readonly size='40' maxlength=30><input type=button name=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facilityid%>')" disabled>
				<%
			}
			else
			{
				%>
				<input type='text' name='appl_user_id1' id='appl_user_id1' value="<%=appl_user_name%>"  readonly size='30' ><input type='hidden' name='appl_user_id' id='appl_user_id' value='<%=addedById%>' readonly size='40' maxlength=30><input type=button name=searchcode value='?' class=button onClick="searchCode(appl_user_id,'<%=facilityid%>')">
				<%
			}
		%>
		</td>
	</tr>
	<tr><td colspan="4">
		<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name="frame_name" value="parent.f_query_add_mod.FMChFileRetDateCriteriaFrame"/>
			<jsp:param name="frame_name1" value="parent.FMChFileRetDateCriteriaFrame"/>
			<jsp:param name="form_name" value="FMChFileRetDateCriteriaForm"/>
			<jsp:param name="messageframe_name" value="parent.parent.messageFrame"/>
			<jsp:param name="patientid_name" value="patient_id"/>
			<jsp:param name="fileno_name" value="file_no"/>
			<jsp:param name="filetype_name" value="file_type_code"/>
			<jsp:param name="volumeno_name" value="volume_no"/>
			<jsp:param name="table_width" value="100"/>
			<jsp:param name="tablealign" value="CENTER"/>
			<jsp:param name="volume_mandatory_yn" value="Y"/>
			<jsp:param name="locn_code" value="p_curr_fs_loc"/>
		</jsp:include>
	</td>
	</tr>
	<tr align="right">
		<td colspan='4' class='button' ><input type='button' class='button' name='search_dtl' id='search_dtl' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.search.label","common_labels")%>' onClick='return fetchResults("search");'><input type='button' class='button' name='reset1' id='reset1' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>' onClick='clearAll()'><input type='hidden' name='user_id' id='user_id' value=''></td>
	</tr>
</table>
	<%
		if((SelectSqlBuffer != null) && (SelectSqlBuffer.length() > 0))
		{
			SelectSqlBuffer.delete(0,SelectSqlBuffer.length());
		}

		if(rs!=null)	rs.close();
		if(pstmt!=null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception e" + e.toString());
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);	
	}
%>
<script>
	if("<%=count%>" == 1)
	{
		FMChFileRetDateCriteriaForm.p_curr_fs_loc.options(1).selected = true;
	}
</script>
<input type='hidden' name='user_security_yn' id='user_security_yn' value='<%=user_security_yn%>'>
<input type='hidden' name='p_access_all' id='p_access_all' value='<%=p_access_all%>'>
<input type='hidden' name='sysDate' id='sysDate' value='<%=sysDate%>'>
</form>
</body>
</html>

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

