<!DOCTYPE html>
<%@ page import="java.sql.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8"  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<% 
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css");
	Connection connect		= null;
	java.sql.Statement stmt	= null;
	ResultSet rs			= null;
 //below line(s) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012
  String userSecurity=request.getParameter("userSecurity");
 //end issue KAUH-SCF-0016 [IN032341]

	String facilityID 	=	"";
	String doc_or_file	=	"";
   String value="";
try
{
	connect				=	ConnectionManager.getConnection(request);
	facilityID 			=	checkForNull((String) session.getValue("facility_id"));

	//Block to obtain mp_param value
	try 
	{
			
		value =(String)session.getAttribute("doc_or_file");
		if(value==null || value.equals("null")) value="";
		if(value.equals(""))
		{
		stmt = connect.createStatement();
		rs = stmt.executeQuery("Select MAINTAIN_DOC_OR_FILE from MP_PARAM where module_id='MP'");
		if(rs.next()) 
		{
			 doc_or_file = rs.getString("MAINTAIN_DOC_OR_FILE");			
		}
	    session.setAttribute("doc_or_file",doc_or_file);
		}else{
         doc_or_file=value;
		}
	
	}catch(Exception e){out.println("Exception in obtaining MP Parameter::"+e);}	
%>	
<html>
<head>
	<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
	<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
	<script language='javascript' src='../../eFM/js/FMPractitionerComponent.js'></script>
	<script language='javascript' src='../../eFM/js/FMLinkEncounterVolume.js'></script>
	<Script language='JavaScript' src='../../eCommon/js/CommonLookup.js'></Script>
	<script language='javascript' src='../../eFM/js/FMReturnToMRD.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>



</head>


<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'> 
	<% if (doc_or_file.equals("D")) { %>
		<form name='FMReturnToMRDCriteriaForm' id='FMReturnToMRDCriteriaForm' action='DTReturnToMRDResult.jsp' method='POST' target="result_frame">
	<% } else { %>
		<form name='FMReturnToMRDCriteriaForm' id='FMReturnToMRDCriteriaForm' action='FMReturnToMRDResult.jsp' method='POST' target="result_frame">
	<% } %>
	<table cellpadding='3' cellspacing='0' border='0' width='100%'>
		<tr><td class='COLUMNHEADER' colspan="4" ><fmt:message key="Common.ReturnFrom.label" bundle="${common_labels}"/></TD></tr>
		<tr>
			<td class="LABEL" width="25%"><fmt:message key="eFM.FSLocationIdentity.label" bundle="${fm_labels}"/></td>
			<td class="fields" width="25%"><select name="fs_location1" id="fs_location1" onChange="getValidLocations(this.value)">
				<option value="">------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>-----</option>
				<option value="C"><fmt:message key="Common.clinic.label" bundle="${common_labels}"/></option>
				<option value="N"><fmt:message key="Common.nursingUnit.label" bundle="${common_labels}"/></option>
				<option value="Y"><fmt:message key="Common.DaycareUnit.label" bundle="${common_labels}"/></option>
				<option value="E"><fmt:message key="Common.ProcedureUnit.label" bundle="${common_labels}"/></option>
				<option value="T"><fmt:message key="Common.practitioner.label" bundle="${common_labels}"/></option>
				<option value="D"><fmt:message key="Common.department.label" bundle="${common_labels}"/></option>
				</select>
			</td>
			<td class="LABEL" width="25%"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
			<td class="fields" width="25%">
				<select name="fs_req_location" id="fs_req_location" onChange='clearReturning();'>
				<option value="">----------------<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---------------</option>
				</select>&nbsp;<img src='../../eCommon/images/mandatory.gif'></img>
			</td>
		</tr>
		<tr>
			<td class="LABEL"  id="returning"><fmt:message key="eFM.Returning.label" bundle="${fm_labels}"/></td>
			<td class="fields" colspan='3'><input type="text" name="returning_desc" id="returning_desc" value="" onChange="getValidRecords(this);"><input type="hidden" name="returning_code" id="returning_code" value="" ><input type="button" name="ret_button" id="ret_button" value="?" class="BUTTON" onClick="getValidRecords(returning_desc);"></td>
		</tr>
<!-- 	</table>
	<table cellpadding='0' cellspacing='0' border='0' width='100%'>
	 -->	<tr><td class='COLUMNHEADER' colspan="4" ><fmt:message key="Common.criteria.label" bundle="${common_labels}"/></TD></tr>
		<tr><td colspan="4" >
				<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name="frame_name" value="parent.criteria_frame"/>
					<jsp:param name="form_name" value="FMReturnToMRDCriteriaForm"/>
					<jsp:param name="messageframe_name" value="parent.messageFrame"/>
					<jsp:param name="patientid_name" value="patient_id"/>
					<jsp:param name="fileno_name" value="file_no"/>
					<jsp:param name="filetype_name" value="file_type"/>
					<jsp:param name="volumeno_name" value="volume_no"/>
					<jsp:param name="table_width" value="100"/>
					<jsp:param name="function_name" value="FMRetutnToMRD"/>
					<jsp:param name="locn_code" value="f_curr_fs_locn"/>
				</jsp:include>
			</td>
		</tr>
		<tr>
			<td colspan="4" class='button' style="padding-left: 88%;"><input type="Button" class="BUTTON" name="add_button" id="add_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>" style='width:45' onClick="searchForRecord();"><% if (doc_or_file.equals("D")) { %><input type="Button" class="BUTTON" name="all_button" id="all_button" value="Show All Docs" style='width:90' onClick="getValidSearchResult();"><% } else { %><input type="Button" class="BUTTON" name="all_button" id="all_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ShowAllFiles.label","fm_labels")%>" style='width:90' onClick="getValidSearchResult();"><% } %><input type="Button" class="BUTTON" name="clear_button" id="clear_button" value="<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%>" style='width:45' onClick="clearPages();"></td>
		</tr>
	</table>
	<%
	if(stmt!=null)	stmt.close();
	if(rs != null)  rs.close();
	}catch(Exception e){out.println("Exception : " + e.toString());}
	finally
	{			
			ConnectionManager.returnConnection(connect,request);		
	}
	%>
	<input type="Hidden" name="added_items" id="added_items" value="">
	<input type="Hidden" name="reset_flag" id="reset_flag" value="Y">
	<input type="Hidden" name="added_patients" id="added_patients" value="">
	<input type="Hidden" name="added_volumes" id="added_volumes" value="">
	<input type="Hidden" name="show_all_yn" id="show_all_yn" value="Y">
	<input type="Hidden" name="doc_or_file" id="doc_or_file" value="<%=doc_or_file%>">
	<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
	<input type=hidden name='fromSelect' id='fromSelect' value='seleectvalue'>
    <input type='hidden' name='p_stored_val' id='p_stored_val' value=''>
	<!--below line(s) added by venkatesh.S against issue KAUH-SCF-0016 [IN032341] on 23/April/2012 -->
    <input type='hidden' name='userSecurity' id='userSecurity' value="<%=userSecurity%>">
	<!--end issue KAUH-SCF-0016 [IN032341 -->

</form>
</body>
</html>
<%!
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}
public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}
%>

