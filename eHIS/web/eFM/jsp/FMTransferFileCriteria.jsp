<!DOCTYPE html>
<!-- by Meghanath -->
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<HTML>
<HEAD>
	<!-- <LINK rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></LINK> -->
	<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eCommon/js/ValidateControl.js'></SCRIPT>
	<SCRIPT language='javascript' src='../../eFM/js/FMTransferFile.js'></SCRIPT>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</HEAD>
<BODY OnMouseDown='CodeArrest()' onLoad='FocusFirstElement();' onKeyDown = 'lockKey();'>
<FORM name='FMTransferFileCriteria_form' id='FMTransferFileCriteria_form'> 
<%
	Connection con						= ConnectionManager.getConnection(request);
	java.sql.Statement stmt				= null;
	PreparedStatement pstmt				= null;
	ResultSet rs						= null;

	String facility_id  = (String) session.getValue("facility_id");

	String ToLocnCode			= request.getParameter("ToLocnCode");
	String auto_rec_ward_yn		= request.getParameter("auto_rec_ward_yn");
	String auto_rec_clinic_yn   = request.getParameter("auto_rec_clinic_yn");
	String auto_rec_pract_yn	= request.getParameter("auto_rec_pract_yn");
	String auto_rec_dept_yn  = request.getParameter("auto_rec_dept_yn");
	if(auto_rec_ward_yn == null || auto_rec_ward_yn.equals("null")) auto_rec_ward_yn = "";
	if(auto_rec_clinic_yn == null || auto_rec_clinic_yn.equals("null")) auto_rec_clinic_yn = "";
	if(auto_rec_pract_yn == null || auto_rec_pract_yn.equals("null")) auto_rec_pract_yn = "";
    if(auto_rec_dept_yn == null || auto_rec_dept_yn.equals("null")) auto_rec_dept_yn = "";
	
	String sql					= "";
	String maintain_doc_or_file = "";
	String mysql				= "";
	String narration			= "";

	try
	{
		stmt = con.createStatement();
		
		mysql = "SELECT maintain_doc_or_file from mp_param";
		rs = stmt.executeQuery(mysql);
	    if( rs != null && rs.next())
		{
			maintain_doc_or_file = rs.getString("maintain_doc_or_file");
		} if(rs!=null)	rs.close();

		if(maintain_doc_or_file == null || maintain_doc_or_file.equals("null")) 							maintain_doc_or_file = "";

		sql  = "SELECT a.narration_code FROM fm_storage_locn a, fm_narration b WHERE a.facility_id = ? AND a.fs_locn_code = ? AND a.narration_code = b.narration_code(+) AND b.eff_status = 'E'";

		pstmt = con.prepareStatement(sql);
		pstmt.setString(1,facility_id);
		pstmt.setString(2,ToLocnCode);
		rs = pstmt.executeQuery();

	    while(rs != null && rs.next())
		{
			narration = rs.getString(1);
		}

		if(narration == null || narration.equals("null")) narration = "";
		%>

		<TABLE border='0' cellpadding='0' cellspacing='0' width='100%' align='center'>
			<TR><TD colspan="8">
				<jsp:include page="../../eFM/jsp/FMFileSearchComponentValues.jsp" ><jsp:param name="flush" value="true" />
					<jsp:param name="frame_name" value="parent.transfer_criteria"/>
					<jsp:param name="form_name" value="FMTransferFileCriteria_form"/>
					<jsp:param name="messageframe_name" value="parent.messageFrame"/>
					<jsp:param name="patientid_name" value="patient_id"/>
					<jsp:param name="fileno_name" value="file_no"/>
					<jsp:param name="filetype_name" value="file_type_code"/>
					<jsp:param name="document_type_name" value="doc_type_code"/>
					<jsp:param name="document_folder_id_name" value="doc_folder_id"/>
					<jsp:param name="volumeno_name" value="volume_no"/>
					<jsp:param name="table_width" value="100"/>
					<jsp:param name="tablealign" value="center"/>
					<jsp:param name="locn_code" value="f_curr_fs_locn"/>
				</jsp:include></TD>
			</TR>
			<TR>
				<TD style="padding-left: 85%;" class='button'  colspan="8">
					<INPUT type='button' class='button' name='add' id='add' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Add.label","common_labels")%>' onClick="AddFiles();">
				<%
				if(maintain_doc_or_file.equals("D"))
				{
					%>
					<INPUT type='button' class='button' name='show' id='show' value='Show all Docs' onCLick="ShowAllFiles();">
					<%
				}
				else if(maintain_doc_or_file.equals("F"))
				{
					%>
					<INPUT type='button' class='button' name='show' id='show' value='<%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eFM.ShowAllFiles.label","fm_labels")%>' onCLick="ShowAllFiles();">
					<%
				}
				%>
				<INPUT type='button' class='button' name='clear' id='clear' value=' <%=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.clear.label","common_labels")%> ' onClick="ClearData();"></TD>
			</TR>
		</TABLE>
		<%
		if(maintain_doc_or_file.equals("D"))
		{
			%>
			<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id ="hdr_tab1" style="visibility:'hidden'">
				<TR><Td class='columnheader' width='30%' id="ParamID"><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></Td>
					<Td class='columnheader' width='15%' id="file_type_ID"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></Td>
					<td class='columnheader' width='10%'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
					<td class='columnheader' width='12%'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
					<td class='columnheader' width='23%'><fmt:message key="eFM.ToFSLocation.label" bundle="${fm_labels}"/></td>
					<td class='columnheader' width='10%'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>?</td>
				</TR>
			</TABLE>
			<%
		}
		else if(maintain_doc_or_file.equals("F"))
		{
			%>
			<TABLE border='1' cellpadding='0' cellspacing='0' width='100%' align='left' id ="hdr_tab" style="visibility:'hidden'">	
				<TR><Th class='columnheader' width='50%' id="ParamID"><fmt:message key="eFM.FileNoPatientDetails.label" bundle="${fm_labels}"/></TH>
					<Th class='columnheader' width='15%' id="file_type_ID"><fmt:message key="eFM.VolumeNo.label" bundle="${fm_labels}"/></Th>
					<Th class='columnheader' width='25%'><fmt:message key="eFM.ToFSLocation.label" bundle="${fm_labels}"/></Th>
					<Th class='columnheader' width='10%'><fmt:message key="Common.Transfer.label" bundle="${common_labels}"/>?</Th>
				</TR>
				<SCRIPT>
					if (document.forms[0].file_type_appl_yn.value=="Y")
					{
						document.getElementById("ParamID").innerText=getLabel("Common.PatientDetails.label","common");
						document.getElementById("file_type_ID").innerHTML=getLabel("Common.filetype.label","common")+" / "+ getLabel("eFM.VolumeNo.label","FM");
					}
				</SCRIPT>
			</TABLE>
			<%
		}
		%>
		<INPUT type='hidden' name='p_stored_val' id='p_stored_val' value=''>
		<INPUT type='hidden' name='filelistvals' id='filelistvals' value=''>
		<INPUT type='hidden' name='patientlistvals' id='patientlistvals' value=''>
		<INPUT type='hidden' name='documentfolderlistvals' id='documentfolderlistvals' value=''>
		<INPUT type='hidden' name='documenttypelistvals' id='documenttypelistvals' value=''>
		<INPUT type='hidden' name='volumelistvals' id='volumelistvals' value=''>
		<INPUT type='hidden' name='p_maintain_doc_or_file' id='p_maintain_doc_or_file' value='<%=maintain_doc_or_file%>'>
		<INPUT type='hidden' name='auto_rec_ward_yn' id='auto_rec_ward_yn' value='<%=auto_rec_ward_yn%>'>
		<INPUT type='hidden' name='auto_rec_clinic_yn' id='auto_rec_clinic_yn' value='<%=auto_rec_clinic_yn%>'>
		<INPUT type='hidden' name='auto_rec_pract_yn' id='auto_rec_pract_yn' value='<%=auto_rec_pract_yn%>'>
		<INPUT type='hidden' name='auto_rec_dept_yn' id='auto_rec_dept_yn' value='<%=auto_rec_dept_yn%>'>
		<input type='hidden' name='f_curr_fs_locn' id='f_curr_fs_locn' value=''>
		<SCRIPT>
			parent.frames[2].document.forms[0].narration.value = "<%=narration%>";
		</SCRIPT>
	</FORM>
	<%
	if(rs!=null)	 rs.close();
	if(stmt!=null)  stmt.close();
	if(pstmt!=null) pstmt.close();
	}catch(Exception e){out.println("Exception e :"+e.toString());}
	finally
	{					
		ConnectionManager.returnConnection(con,request);		
	}
	%>
	</BODY>
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

