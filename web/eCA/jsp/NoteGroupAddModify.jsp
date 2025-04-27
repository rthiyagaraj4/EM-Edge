<!DOCTYPE html>
<%
/*
--------------------------------------------------------------------------------------------------------------------------
Date			Edit History	Name			Rev.Date		Rev.Name			Description
--------------------------------------------------------------------------------------------------------------------------
20/07/2018		IN067717		Ramesh G		20/07/2018			Ramesh G			ML-MMOH-CRF-0898.1
--------------------------------------------------------------------------------------------------------------------------
*/	
%>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<%
request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/NoteGroup.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



<%
	Connection con=null;
	PreparedStatement stmt=null;
	//PreparedStatement stmt1=null;
	ResultSet rs=null;
	//ResultSet rs1=null;

	String sql="";
	String status="";
	String mode="";
	String note_group_id="";
	String enabled_checked="";
	String note_group_id1="";
	String note_group_desc1="";
	String applic_task1="";
	String note_encounter1="";	
	String role_base1="";	
	String precondition_recording1="";	
	String report_header1="";
	String effective_status1="";
	String sel="";
	String enabled_checked1="";
	String app_code="";
	String app_desc="";
	String readOnly = "";
	String system_user_define="";
	String status1="";
	String disbl_appl_task="";
	String trans_checked="";
	String cutoff_period="";
	String transcription_yn="";
	String trans_val="";
	//String applic_task_desc="";
	String sqlSpec="";
	String transcription_yn1="";
	String disNotePerEnc = "";//IN067717
	String disPreRec = "";//IN067717

	

	String license_rights = "";

	if( (eCA._ca_license_rights.getKey()).equals("CACLDC") )
	{
		license_rights= "FULL";
	}
	else if((eCA._ca_license_rights.getKey()).equals("CABASIC"))
	{
		license_rights= "BASIC";
	}
	else if((eCA._ca_license_rights.getKey()).equals("CAMINI"))
	{
		license_rights= "MINI";
	}

	mode		=(request.getParameter("mode")==null)?"":request.getParameter("mode");

	note_group_id=(request.getParameter("note_group_id")==null)?"":request.getParameter("note_group_id");
	
	 sqlSpec = "select APPL_TASK_ID,APPL_TASK_DESC, TRANSCRIPTION_YN from ca_appl_task where note_spec_yn='Y'";
	
	if(mode=="insert" || mode.equals("insert") || mode == null) 
	{
		mode="insert";
		enabled_checked1 = "checked";
	}




	try
	{
		
		con =	ConnectionManager.getConnection(request);
		if(mode.trim().equalsIgnoreCase("update")) 
		{
			//sql ="select * from ca_note_group where note_group='"+ note_group_id + "'" ;//common-icn-0180
			sql ="select * from ca_note_group where note_group=?" ;//common-icn-0180
			stmt=con.prepareStatement(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,
                                      ResultSet.CONCUR_UPDATABLE);
			stmt.setString(1, note_group_id);//common-icn-0180
			rs = stmt.executeQuery();
			 
			if(rs.next())
			{
				 note_group_id1				=(rs.getString("NOTE_GROUP")==null)?"":rs.getString("NOTE_GROUP");
				 note_group_desc1			=(rs.getString("NOTE_GROUP_DESC")==null)?"":rs.getString("NOTE_GROUP_DESC");
				 applic_task1				=(rs.getString("APPL_TASK_ID")==null)?"":rs.getString("APPL_TASK_ID");
				 
				 system_user_define			=(rs.getString("SYS_USER_DEF_IND")==null)?"":rs.getString("SYS_USER_DEF_IND");
				 note_encounter1			=(rs.getString("NO_OF_REC_PER_ENC")==null)?"":rs.getString("NO_OF_REC_PER_ENC");
				 role_base1					=(rs.getString("ROLE_BASED_ACCESS_YN")==null)?"":rs.getString("ROLE_BASED_ACCESS_YN"); 
				 precondition_recording1	=(rs.getString("PRE_COND_FOR_REC")==null)?"":rs.getString("PRE_COND_FOR_REC");
				 report_header1				=(rs.getString("REPORT_HEADER")==null)?"":rs.getString("REPORT_HEADER");
				 cutoff_period				=(rs.getString("CUT_OFF_DAYS")==null)?"":rs.getString("CUT_OFF_DAYS");
				transcription_yn				=(rs.getString("TRANSCRIPTION_YN")==null)?"N":rs.getString("TRANSCRIPTION_YN");
				  if(transcription_yn.equals(""))
		          {
			        transcription_yn="N";
		           }
				 effective_status1			=(rs.getString("EFF_STATUS")==null)?"":rs.getString("EFF_STATUS");
	
				 if(role_base1.equals("Y"))
					enabled_checked = "checked";
				 else
					enabled_checked="";
				
				 if(effective_status1.equals("E"))
					enabled_checked1="checked";
				 else
					enabled_checked1="";

			}

			if(rs!=null)  rs.close(); 
			if(stmt!=null)  stmt.close();
	}
}

catch(Exception e)
{
	//out.println("Exception@1: "+e.toString());//COMMON-ICN-0181
	e.printStackTrace();//COMMON-ICN-0181
}

%>
<%if(mode.trim().equalsIgnoreCase("insert")){%>
<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='FocusFirstElement();' onKeyDown="lockKey()">
<%}else{%>

<body  class='CONTENT' OnMouseDown="CodeArrest()" onload='DisplayTrans();' onKeyDown="lockKey()">
<%}%>
<BR>

<form name="notegroup_form" id="notegroup_form" action="../../servlet/eCA.NoteGroupServlet" method="post" target="messageFrame">
<BR><BR><BR><BR><BR><BR><BR><BR><BR>
<table border=0 cellspacing=0 cellpadding='3' width='90%' align=center>

<tr>
	<%
	
	if(mode.trim().equalsIgnoreCase("update")) 
	{
		disbl_appl_task="disabled";
	}
	else
	{
		disbl_appl_task="";
	}
	
	if(mode.trim().equalsIgnoreCase("update")&& (effective_status1.equals("E"))) 
	{
		status="enabled" ;readOnly = ""; 
	}
	else
	{
		status="disabled"; 
		readOnly = "readonly";
	}
	if(mode.trim().equalsIgnoreCase("update")&& (system_user_define.equals("S"))) 
	{status1="disabled" ;}else{status1=""; }
	if(mode.trim().equalsIgnoreCase("insert")){status="enabled";readOnly = "";}
	%>
	
	<td class=label><fmt:message key="Common.identification.label" bundle="${common_labels}"/></td>
   <% if(mode.trim().equalsIgnoreCase("update")) { %>
	   <td class='fields' >&nbsp;<input type="text" name="note_group_id" id="note_group_id" value="<%=note_group_id1%>" readonly 
	 <%=status1%> size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  
	onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
		<%}else{%>
	 <td class='fields'>&nbsp;<input type="text" name="note_group_id" id="note_group_id" value="<%=note_group_id1%>" <%=status%>  
	 <%=status1%> size=10 maxlength=10 onkeypress="return CheckForSpecChars(event)"  
	onBlur="ChangeUpperCase(this)" ><img src='../../eCommon/images/mandatory.gif'></td>
		<%}%>
</tr>
<tr>
	<td class=label ><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
	<td class='fields' >&nbsp;<input type="text" name="note_group_desc" id="note_group_desc" value="<%=note_group_desc1%>" <%=status%> <%=status1%>  size=30 maxlength=30  onBlur="checkdefalultdesc();return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>
<tr>
		<td class=label ><fmt:message key="eCA.ApplicableTask.label" bundle="${ca_labels}"/></td>
		<td class='fields' >&nbsp;<select name='applic_task' id='applic_task'  onchange='transApplicable(this)' <%=disbl_appl_task%>>
		<option value="">---------------------------------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>------------------------------------------</option>
	
	<%
	try
{
		
	stmt= con.prepareStatement(sqlSpec);
	rs = stmt.executeQuery();
	while(rs!=null && rs.next())
	{

		//app_code=rs.getString("APPL_TASK_ID");
		//app_desc=rs.getString("APPL_TASK_DESC");
	    app_code				=(rs.getString("APPL_TASK_ID").equals(""))?"":rs.getString("APPL_TASK_ID");
	    app_desc				=(rs.getString("APPL_TASK_DESC").equals(""))?"":rs.getString("APPL_TASK_DESC");
		transcription_yn1				=(rs.getString("TRANSCRIPTION_YN")==null)?"N":rs.getString("TRANSCRIPTION_YN");
       if(transcription_yn1.equals(""))
		{
			transcription_yn1="N";

		}
		if(mode.trim().equalsIgnoreCase("update"))
		{
		   if(transcription_yn1.equals("Y"))
		   {
			 if(transcription_yn.equalsIgnoreCase("Y"))
		     {
			   trans_checked = "checked";
			   trans_val = "Y";
		     }
		     else
		      {
			   trans_checked = "";
			   trans_val = "N";
		      }
	       }
	       else
		   {
		    trans_checked = "";
		   }
	   }
		if(applic_task1.equals(app_code))
		{
			sel="selected";
		}	
		else
		{
			sel="";
		}
		if(license_rights.equals("BASIC"))
		{
			if(!app_code.equals("CLINICAL_NOTES_NEW") && !app_code.equals("CLINICAL_NOTES"))
			{
				out.println("<option value='"+app_code+"~"+transcription_yn1+"' "+sel+" >"+app_desc+"</option>");
			}
		}
		else
		{
			out.println("<option value='"+app_code+"~"+transcription_yn1+"' "+sel+" >"+app_desc+"</option>");
		}
	}
	

	
	if(rs!=null)  rs.close(); 
	if(stmt!=null)  stmt.close();
}//try 

catch(Exception eg)
{
   //out.println("Exception="+eg.toString());//COMMON-ICN-0181
	eg.printStackTrace();//COMMON-ICN-0181
}
finally
{
	if (con!= null)
	ConnectionManager.returnConnection(con,request);
} 

%>	
</select><img src='../../eCommon/images/mandatory.gif'>
</td>
</tr>
<!--IN067717 starts-->
<%
if(app_code.equals("BIRTH_REG_NOTES")){
disNotePerEnc="disabled";
disPreRec="disabled";
}
%>
<!--IN067717 ends-->
<tr>
	<td class=label ><fmt:message key="eCA.NumofNotePerEncounter.label" bundle="${ca_labels}"/></td>
	<td class='fields'>&nbsp;<input type="text" name="note_encounter" id="note_encounter" value="<%=note_encounter1%>" <%=status%> <%=disNotePerEnc%> size=4 maxlength=4 onkeypress="return allowValidNumber(this,event,6,0)"
	onblur="return checkForMinus(this)">
</tr>
<tr>
		<td class=label ><fmt:message key="eCA.PreconditionforRecording.label" bundle="${ca_labels}"/></td>
		<td class='fields'>&nbsp;<select name='precondition_recording' id='precondition_recording' <%=status%> <%=disPreRec%>>
			<option value="" >-------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------</option>
			<%if (precondition_recording1.equals("D")) sel="selected"; else sel="";%>
			<option value="D" <%=sel%> ><fmt:message key="Common.DischargeAdvice.label" bundle="${common_labels}"/></option>
			<%if (precondition_recording1.equals("E")) sel="selected"; else sel="";%>
			<option value="E" <%=sel%> ><fmt:message key="Common.deceased.label" bundle="${common_labels}"/></option>
		</select>
</tr>
<tr>
	<td class=label ><fmt:message key="eCA.ReportHeader.label" bundle="${ca_labels}"/></td>
	<td class='fields'>&nbsp;<input type="text" name="report_header" id="report_header" value="<%=report_header1%>" <%=status%>  size=30 maxlength=30   onBlur="return makeValidString(this)"><img src='../../eCommon/images/mandatory.gif'></td>
</tr>

   <%if(mode.trim().equalsIgnoreCase("insert")||mode.trim().equalsIgnoreCase("update")) { %>
	<tr ID='transcription' style='display:none'>
	<td class=label><fmt:message key="eCA.TranscriptionApplicable.label" bundle="${ca_labels}"/></td>
	<td class='fields'><input type="checkbox" name="transcription_yn" id="transcription_yn" value="<%=trans_val%>" <%=trans_checked%>  OnClick ='checkForTranscription(this)'>&nbsp;<fmt:message key="eCA.CutoffPeriodToAllowTrans.label" bundle="${ca_labels}"/>&nbsp;<input type="text" name="cutoff_period" id="cutoff_period" value="<%=cutoff_period%>" size=3 maxlength=3 onkeypress="return CheckForNums(event)" onblur="return checkForMinus(this)"><span id='tdchecktranscription' style='display:none'><img src='../../eCommon/images/mandatory.gif'></span>&nbsp;<fmt:message key="eCA.DaysFromVisitRegDisc.label" bundle="${ca_labels}"/></td>
</tr>
	<%}%>
<tr>
	<td class=label ><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
	<td class=fields><input type="checkbox" name="eff_status" id="eff_status" value="E" <%=enabled_checked1%> OnClick ='checkForMode(this)'></td>
</tr>
</table>

<input type=hidden name="mode" id="mode" value="<%=mode%>">
<input type=hidden name="note_group_id1" id="note_group_id1" value="<%=note_group_id1%>">
<input type=hidden name="note_group_desc1" id="note_group_desc1" value="<%=note_group_desc1%>">
<input type=hidden name="applic_task1" id="applic_task1" value="<%=applic_task1%>">
<input type=hidden name="note_encounter1" id="note_encounter1" value="<%=note_encounter1%>">
<input type=hidden name="role_base1" id="role_base1" value="<%=role_base1%>">
<input type=hidden name="precondition_recording1" id="precondition_recording1" value="<%=precondition_recording1%>">
<input type=hidden name="report_header1" id="report_header1" value="<%=report_header1%>">
<input type=hidden name="eff_status1" id="eff_status1" value="<%=effective_status1%>">
<input type=hidden name="old_note_group_id" id="old_note_group_id" value="<%=note_group_id%>">
<input type=hidden name="system_user_define" id="system_user_define" value="<%=system_user_define%>">
<input type=hidden name="system_user_define1" id="system_user_define1" value="">
</form>
</body>
</html>

