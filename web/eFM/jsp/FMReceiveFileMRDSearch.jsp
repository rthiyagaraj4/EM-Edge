<!DOCTYPE html>
<!--
	Created On	: 6/15/2002
	Created By	: Nanda Kumar R.
	Module		: File Management (FM)
	Function	: Return File to MRD
-->

<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head> 
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
	<script language='javascript' src='../../eFM/js/FMReturnMRDFile.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();' onLoad="chkFileObj();document.FMReceiveFileMRDSearch.p_out_fcy.disabled=false;document.FMReceiveFileMRDSearch.p_out_fsloc.disabled=false">
<FORM name='FMReceiveFileMRDSearch' id='FMReceiveFileMRDSearch' action='' method='post' target='messageFrame'>
<%
	Connection con			= ConnectionManager.getConnection(request);
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
	
try
{
	stmt	= con.createStatement();
	
	String p_code						= "";		
	String doc_or_file					= "";
	String accept_out_intransit_yn      = "";
	
	int p_count				= 0;
	
	doc_or_file	= request.getParameter("doc_or_file") == null ? "" : request.getParameter("doc_or_file");
	accept_out_intransit_yn	= request.getParameter("accept_out_intransit_yn") == null ? "" : request.getParameter("accept_out_intransit_yn");
%>
<TABLE border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
<tr><th class='columnheader' align="left"  colspan="6"><fmt:message key="eFM.OutstandingFrom.label" bundle="${fm_labels}"/></td></tr>
<TR>
	<TD width='25%'  class='label'><fmt:message key="Common.facility.label" bundle="${common_labels}"/></TD>
	<TD width='30%'  class='fields' ><select name=p_out_fcy tabindex=4 onChange="clearValues()">
			<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
		</select>
	</TD>
	<TD width='20%'   class='label'></TD>
	<TD width='25%'   class='label'></TD>
</TR>
<TR>
	<TD class='label'><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></TD>
	<TD class='fields' colspan=''><select tabindex=5 name="FS_LOCN_ID" id="FS_LOCN_ID"  onChange="PopulateOutFSLoc(this)">
			<option value="">---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
			<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
			<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
			<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
			<option value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
			<option value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
			<option value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></option>
		</select>
	</TD>
	<TD   class='label'><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></TD>
	<TD    class='fields'><select name=p_out_fsloc onChange="" tabindex=6>
			<option value=''>---------- <fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>----------</option>
		</select>
	</td>
</TR>
</TABLE>
<script>
	if('<%=p_count%>'==1)
	{
		document.forms[0].p_curr_fs_loc.value='<%=p_code%>';
		ChangeOutstanding();
	
		var p_curr_fs_loc = parent.frames[2].document.forms[0].p_curr_fs_loc.value;

		if (p_curr_fs_loc.length > 0)
		{
			if(parent.frames[2].document.forms[0].file_no != null)
			{
				parent.frames[2].document.forms[0].file_no.disabled=false;
			}
			parent.frames[2].document.forms[0].p_out_fcy.disabled=false;
			parent.frames[2].document.forms[0].p_out_fsloc.disabled=false;

			var sel = document.forms[0].p_out_fcy;

			while(sel.options.length>1) 
			{
				sel.remove(1);
			}

			var sel1 = document.forms[0].p_out_fsloc;
			while(sel1.options.length>1) 
			{
				sel1.remove(1);
			}
		}
	}
	else
	{
		if (parent.frames[2].document.forms[0].file_no != null)
			parent.frames[2].document.forms[0].file_no.disabled=true;
		parent.frames[2].document.forms[0].p_out_fcy.disabled=true;
		parent.frames[2].document.forms[0].p_out_fsloc.disabled=true;
	}
</script>
<tr></tr>
<TABLE border='0' cellpadding='2' cellspacing='0' width='100%' align='center'>
<tr><th class='columnheader' align="left" colspan="4"><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></td></tr>
<tr><td colspan="4">
		<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
			<jsp:param name="frame_name" value="parent.search_criteria_frame"/>
			<jsp:param name="form_name" value="FMReceiveFileMRDSearch"/>
			<jsp:param name="messageframe_name" value="parent.messageFrame"/>
			<jsp:param name="patientid_name" value="patient_id"/>
			<jsp:param name="fileno_name" value="file_no"/>
			<jsp:param name="filetype_name" value="file_type"/>
			<jsp:param name="volumeno_name" value="volume_no"/>
			<jsp:param name="table_width" value="100"/>
			<jsp:param name="tablealign" value="CENTER"/>
			<jsp:param name="function_name" value="FMReceiveFileMRD"/>
			<jsp:param name="locn_code" value="f_curr_fs_locn"/>
		</jsp:include>
	</td>
	</tr>
<TR>
	<td  colspan="4" align='right'><input  type=button name=Add value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>'  class=button onClick="addFiles()"><% if(doc_or_file.equals("D")){	%><input  type=button name=show_files value='Show all Docs'  class=button onClick="showfiles()" disabled><% }else{%><input  type=button name=show_files disabled value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ShowAllFiles.label","fm_labels")%>'  class=button onClick="showfiles()" ><% } %><input  type=button name=Clear value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  class=button onClick="ClearAllval()">
	</TD>
</TR>
</TABLE>
<TABLE border='1' cellpadding='0' cellspacing='0' width='100%'  id = "hdr_tab" style="visibility:hidden" >
<% if(doc_or_file.equals("D")){	%>
	<th class='columnheader' align = 'center' width='28%' id="paramID"><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></th>
	<th class='columnheader' align = 'center' width='14%' id="fileIDs"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>
<% }else {%>
	<th class='columnheader' align = 'center' width='30%' id="paramID"><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></th>
	<th class='columnheader' align = 'center' width='12%' id="fileIDs"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></th>
<% } %>
	<th class='columnheader' align = 'center' width='8%' ><fmt:message key="Common.IssueRemarks.label" bundle="${common_labels}"/></th>
	<th class='columnheader' align = 'center' width='17%' ><fmt:message key="eFM.ReturningFSLocation.label" bundle="${fm_labels}"/></th>
	<!--Modified by Ashwini on 18-Jul-2017 for ML-MMOH-SCF-0763-->
	<th class='columnheader' align = 'center' width='15%'><fmt:message key="eFM.ReturnDueDateTime.label" bundle="${fm_labels}"/></th>
	<th class='columnheader' align = 'center' width='8%' ><fmt:message key="eFM.ReturnRemarks.label" bundle="${fm_labels}"/></th>
	<th class='columnheader' align = 'center' width='10%' ><fmt:message key="eFM.Receive.label" bundle="${fm_labels}"/>?</th>

</TABLE>
	<input type='hidden' name='p_select_values' id='p_select_values' value=''>
	<input type='hidden' name='p_deselect_values' id='p_deselect_values' value=''>
	<input type='hidden' name='p_patient_file_no' id='p_patient_file_no' value=''>
	<input type='hidden' name='p_valtype' id='p_valtype' value=''>
	<input type='hidden' name='p_load_select' id='p_load_select' value=''>
	<input type='hidden' name='p_load_deselect' id='p_load_deselect' value=''>
	<input type='hidden' name='p_total_records' id='p_total_records' value=''>
	<input type='hidden' name='p_select_files' id='p_select_files' value=''>
	<input type='hidden' name='p_deselect_files' id='p_deselect_files' value=''>
	<input type='hidden' name=p_total_select value=''>
	<input type='hidden' name="remove_volume" id="remove_volume" value=''>
	<input type='hidden' name="doc_or_file" id="doc_or_file" value='<%=doc_or_file%>'>
	<input type='hidden' name="accept_out_intransit_yn" id="accept_out_intransit_yn" value='<%=accept_out_intransit_yn%>'>
	<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
    <input type='hidden' name='p_stored_val' id='p_stored_val' value=''>
    <input type='hidden' name='p_stored_val_old' id='p_stored_val_old' value=''>
	<input type='hidden' name='flag' id='flag' value=''>
	<input type='hidden' name='un_defcny' id='un_defcny' value=''>
	<input type='hidden' name='patientid' id='patientid' value=''>
	<input type='hidden' name='fileno' id='fileno' value=''>
	<input type='hidden' name='volno' id='volno' value=''>
	<!-- // code added for icn:19422 date:Wednesday, February 24, 2010 -->
	<input type='hidden' name='added_rem_remarks' id='added_rem_remarks' value=''>
	<input type='hidden' name='added_rem_remarks_values' id='added_rem_remarks_values' value=''>
	<input type='hidden' name='pat_file_vol' id='pat_file_vol' value=''>
	 </FORM>
  </BODY>  
<%
if(rs!=null)	rs.close();
if(stmt!=null) stmt.close();
}catch(Exception e){out.println("Exception e :"+e);}
finally
{		
	ConnectionManager.returnConnection(con,request);	
}
%>
</HTML>
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

