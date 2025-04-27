<!DOCTYPE html>
<!--
	Created On	: 6/15/2002
	Created By	: Nanda Kumar R.
	Module			: File Management (FM)
	Function		: Request of File
--> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<head> 
	<!-- <link rel='stylesheet' type='text/css' href='../../eCommon/html/IeStyle.css'> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js' ></script>
	<script language='javascript' src='../../eFM/js/FMRequestFile.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<BODY onMouseDown="CodeArrest()" onKeyDown = 'lockKey();'>
<FORM name = 'fm_req_criteria' action='../../servlet/eFM.FMParameterServlet' method='post' target='messageFrame'>
<%
        String doc_or_file = request.getParameter("doc_or_file")==null?"F":request.getParameter("doc_or_file");	
		String facilityid 			= (String) session.getValue("facility_id");
		String external_facility	= request.getParameter("external_facility");
		if((external_facility == null) || (external_facility.equals("null"))) external_facility = "";	
		String chkParam = "";
		String checkbox_checked_autocheck="";
	    String checkbox_val_autochk="";
       String auto_check_patient_file_request = request.getParameter("auto_check_patient_file_request");
    /*Below Code Added for this CRF[SKR-CRF-0012]*/ 	
	 if(auto_check_patient_file_request==null)auto_check_patient_file_request="N";
	   if(auto_check_patient_file_request.equals("Y"))
					{ 
						checkbox_checked_autocheck = "checked";
						checkbox_val_autochk ="Y";
					}
					else 
					{
						checkbox_checked_autocheck = "";
						checkbox_val_autochk ="N";
					}
         //End CRF[SKR-CRF-0012]	

		
%>
<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
<td colspan='4' width='100%'>
<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" flush="true">
	<jsp:param name="frame_name" value="parent.search_criteria"/>
	<jsp:param name="form_name" value="fm_req_criteria"/>
	<jsp:param name="messageframe_name" value="parent.messageFrame"/>
	<jsp:param name="patientid_name" value="p_patient_id"/>
	<jsp:param name="fileno_name" value="p_file_no"/>
	<jsp:param name="filetype_name" value="file_type"/>
	<jsp:param name="volumeno_name" value="volume_no"/>
	<jsp:param name="doctype_appl_yn" value="Y"/>
	<jsp:param name="table_width" value="100"/>
	<jsp:param name="external_facility" value="<%=external_facility%>"/>
	<jsp:param name="locn_code" value="f_curr_fs_locn"/>
</jsp:include></td>

</tr>
 <tr> <td>&nbsp;</td> </tr>
    <tr> <!--Modified for this CRF HSA-CRF-0306-->
		<td  class='label' width='25%'><fmt:message key="eFM.PrintPatientFileRequestSlip.label" bundle="${fm_labels}"/></td>
		<td class='fields'><!--<input type='checkbox'   name='print_req_slip' id='print_req_slip' value='Y' >--><%/*Above Line Commented modified Below Line for this CRF[SKR-CRF-0012]*/%>
		<input type='checkbox'   name='print_req_slip' id='print_req_slip' value='<%=checkbox_val_autochk%>' <%=checkbox_checked_autocheck%>></td>
		<td class='fields' width='25%'>&nbsp;</td>
		<td class='fields' width='25%'>&nbsp;</td>
		</tr>
   <tr>

<!-- 
	To Get Result Reocrds onBlur of Patient ID - getPatientIDRecords(event,this);
	To Get Result Reocrds onBlur of File No - getFileNoRecords(event,this);
-->		<td colspan='3' width='75%'></td>
		<TD class='button' width='25%'>
			<input type=button name=Add value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label", "common_labels")%>' class=button onClick="addFiles()"><input type=button name=Clear value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>'  class=button onClick="javascript:Clearval();">
			</TD>
		</TR>
</TABLE>
<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id = "hdr_tab" style="visibility:hidden">
<% if(doc_or_file.equals("D")){%>
	<td class='COLUMNHEADER' width="15%" id="ParamID" ><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width="8%" id="file_type_ID" ><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width="14%" id="file_type_ID" ><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
	<td class='COLUMNHEADER' width="12%" id="file_type_ID" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
<% }else{ %>
	<td class='COLUMNHEADER' width="25%" id="ParamID" ><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></td>
	<td class='COLUMNHEADER' width="12%" id="file_type_ID"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></td>
<% } %>
	<td class='COLUMNHEADER' width="8%" id="reqRemark"><fmt:message key="eFM.RequestRemarks.label" bundle="${fm_labels}"/></td>
	<td class='COLUMNHEADER' width="13%" ><fmt:message key="eFM.PermanentFSLocation.label" bundle="${fm_labels}"/></td>
	<td class='COLUMNHEADER' width="13%" ><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
	<td class='COLUMNHEADER' width="13%" ><fmt:message key="eFM.FileRequiredOn.label" bundle="${fm_labels}"/></td> 
<% if(doc_or_file.equals("D")){%>
	<td class='COLUMNHEADER' width="9%" ><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/></td>
<% }else{ %>
	<td class='COLUMNHEADER' width="9%" ><fmt:message key="eFM.FileStatus.label" bundle="${fm_labels}"/></td>
<% } %>
	<td class='COLUMNHEADER' width="8%" ><fmt:message key="Common.Request.label" bundle="${common_labels}"/> ?</td>
	<input type='hidden' name="doc_or_file" id="doc_or_file" value='<%=doc_or_file%>'>

<script>
	if(document.forms[0].doc_or_file.value!="D")
	{
		if (document.forms[0].file_type_appl_yn.value=="Y")
		{
			document.getElementById("ParamID").innerText=getLabel("Common.PatientDetails.label","common");
			document.getElementById("file_type_ID").innerHTML=getLabel("Common.filetype.label","common")+    " / "+ getLabel("eFM.VolumeNo.label","FM");
		}
	}
</script>
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
<input type="hidden" name="flag" id="flag" value=''>
<input type="hidden" name="chkParam" id="chkParam" value='<%=chkParam%>'>
<input type="hidden" name="facilityid" id="facilityid" value='<%=facilityid%>'>
<input type="hidden" name="patient_id" id="patient_id" >
<input type='hidden' name="added_values" id="added_values" value=''>
<input type='hidden' name="added_volumes" id="added_volumes" value='Y'>
<input type='hidden' name="invalid_volumes" id="invalid_volumes" value=''>
<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
</FORM>
</BODY>

</HTML>

