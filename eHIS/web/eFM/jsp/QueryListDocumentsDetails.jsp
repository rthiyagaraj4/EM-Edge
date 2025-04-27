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
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eFM/js/QueryListDocuments.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<head>
<%
String facilityID 	=	checkForNull((String) session.getValue("facility_id"));
String encounter_id = request.getParameter("encounter_id")==null?"":request.getParameter("encounter_id");
String patient_id = request.getParameter("patient_id")==null?"":request.getParameter("patient_id");
String doc_folder_id = request.getParameter("doc_folder_id")==null?"":request.getParameter("doc_folder_id");

String search_by = request.getParameter("search_by")==null?"":request.getParameter("search_by");


int record_count			=	0;
String    nextRecord		=request.getParameter("nextRecord");

String   previousRecord	=request.getParameter("previousRecord");                   

		int counter				= 0  ;
		int fromRecordNumber	= 0  ;
		int toRecordNumber  	= 0  ;
	
	
	if ( previousRecord == null )
		fromRecordNumber = 1 ;
	else
	{
		if(previousRecord.equals(""))fromRecordNumber=1;
		else
		fromRecordNumber = Integer.parseInt( previousRecord ) ;
	}

	if ( nextRecord == null )
		toRecordNumber = 8 ;
	else
	{
		if(nextRecord.equals(""))toRecordNumber=8;
		else
		toRecordNumber = Integer.parseInt( nextRecord ) ;
	}


StringBuffer sqlBuffer		=	new StringBuffer();
StringBuffer sqlQuery		=	new StringBuffer();
StringBuffer whereBuffer	=	new StringBuffer();

if ((sqlQuery != null) && (sqlQuery.length() > 0))
		sqlQuery.delete(0, sqlQuery.length());
sqlQuery.append(" select count(*) record_count from fm_encounter_doc_type_link a, fm_doc_type_in_folder b, fm_doc_type c,fm_curr_locn_vw d, pr_encounter e,am_patient_class f ");

if ((whereBuffer != null) && (whereBuffer.length() > 0))
		whereBuffer.delete(0, whereBuffer.length());
whereBuffer.append(" WHERE a.facility_id = e.facility_id AND a.encounter_id = e.encounter_id AND e.patient_class = f.patient_class AND a.facility_id = b.facility_id AND a.doc_folder_id = b.doc_folder_id AND b.doc_type_code = c.doc_type_code AND d.doc_folder_id = b.doc_folder_id AND d.file_no = a.file_no AND d.doc_type_code = a.doc_type_code   AND a.facility_id = '");
whereBuffer.append(facilityID);
whereBuffer.append("' AND a.patient_id = '");
whereBuffer.append(patient_id);
whereBuffer.append("' AND a.encounter_id = '");
whereBuffer.append(encounter_id);
if(!doc_folder_id.equals(""))
{
whereBuffer.append("' AND a.doc_folder_id = '");
whereBuffer.append(doc_folder_id);
}
if(!search_by.equals(""))
{
whereBuffer.append("' AND b.reqd_type = '");
whereBuffer.append(search_by);
}

whereBuffer.append("' ORDER BY f.short_desc, a.encounter_id ");

if ((sqlBuffer != null) && (sqlBuffer.length() > 0))
			sqlBuffer.delete(0, sqlBuffer.length());
sqlBuffer.append(" select f.short_desc encounter_type,a.encounter_id, b.doc_folder_name,b.doc_type_code, c.doc_type_name, c.doc_no, d.curr_fs_locn_short_desc, decode (b.reqd_type,'M','Mandatory','S','Statutory')reqd_type, decode (d.curr_file_status,'I','Inside','O', 'Outside','L', 'Lost','T', 'Transit','R','Returned','A', 'Archived','E','External')curr_file_status from fm_encounter_doc_type_link a,fm_doc_type_in_folder b, fm_doc_type c,fm_curr_locn_vw d,pr_encounter e,am_patient_class f ");

sqlQuery.append(whereBuffer.toString());
sqlBuffer.append(whereBuffer.toString());
record_count = 0;
Connection con = null;
con = ConnectionManager.getConnection(request);
PreparedStatement pstmt = null;
PreparedStatement pstmt1 = null;
ResultSet rs = null;
ResultSet rs1 = null;
%>
<%
try{
pstmt = con.prepareStatement(sqlQuery.toString());
rs = pstmt.executeQuery();
while (rs!=null && rs.next())
{
 record_count = rs.getInt("record_count");
}
if (record_count==0)
	{
	%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.searchFrame.document.forms[0].search_button.disabled = false;
			parent.searchFrame.document.location.reload();
			parent.resultFrame.document.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
		</script>
	<%
	}
	else
	{%>
		<script>
			parent.searchFrame.document.forms[0].search_button.disabled = false;
		</script>
<%
%>
<body OnMouseDown='CodeArrest();' onKeyDown = 'lockKey();'>
<form name='listDocsResult' id='listDocsResult' action='QueryListDocumentsDetails.jsp' method='POST''>
<br>
<table border="0" cellpadding="0" cellspacing="0" align='center' width="100%" style="border:1x solid black">
	<tr>
		<td colspan='4'>
		<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
		<jsp:param name="Patient_ID" value="<%=patient_id%>"/>
		</jsp:include>
		</td>
	</tr>
</table>
<br>
	<table align='right'><tr><td>			
				<%
		if ( !(fromRecordNumber <= 1) )
			out.println("<A HREF=\"javascript:submitPrevNext("+(fromRecordNumber-8)+","+(toRecordNumber-8)+")\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
		if ( !( (toRecordNumber+8) > record_count ) )
			out.println("<A HREF=\"javascript:submitPrevNext("+(fromRecordNumber+8)+","+(toRecordNumber+8)+")\" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
			%>
		</td></tr></table>
				<br>				
<%
	
%>
<table border='1' cellpadding='0' cellspacing='0' width='100%' align='center'>
<tr>
	<td class='columnheader' width="10%"><fmt:message key="Common.encountertype.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width="10%"><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width="10%"><fmt:message key="eFM.DocumentFolder.label" bundle="${fm_labels}"/></td>
	<td class='columnheader' width="10%"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
	<td class='columnheader' width="10%"><fmt:message key="eFM.DocumentID.label" bundle="${fm_labels}"/></td>
	<td class='columnheader' width="10%"><fmt:message key="eFM.MandatoryStatutory.label" bundle="${fm_labels}"/></td>
	<td class='columnheader' width="10%"><fmt:message key="eFM.FSLocation.label" bundle="${fm_labels}"/></td>
	<td class='columnheader' width="10%"><fmt:message key="eFM.DocumentStatus.label" bundle="${fm_labels}"/></td>
</tr>
<%
	if (pstmt != null)  pstmt = null;
	if (rs != null)  rs = null;	
	pstmt	=	con.prepareStatement(sqlBuffer.toString());
	rs		=	pstmt.executeQuery();
	String p_encounter_type = "";
	String p_encounter_id = "";	
	String p_doc_folder = "";
	String p_doc_type = "";
	String p_doc_no = "";
	String p_fs_location = "";
	String p_file_status = "";
	String p_reqd_type = "";

	String class_value	=	"QRYEVEN";
	if(rs!=null)
		{
	while(rs.next())
		{
		counter ++ ;
		if(counter >=fromRecordNumber && counter <= toRecordNumber){

			p_encounter_type = checkForNull(rs.getString("encounter_type"));
			p_encounter_id = checkForNull(rs.getString("encounter_id"));
			p_doc_folder = checkForNull(rs.getString("doc_folder_name"));
			p_doc_type = checkForNull(rs.getString("doc_type_name"));
			p_doc_no = checkForNull(rs.getString("doc_no"));
			p_reqd_type = checkForNull(rs.getString("reqd_type"));
			p_fs_location = checkForNull(rs.getString("curr_fs_locn_short_desc"));
			p_file_status = checkForNull(rs.getString("curr_file_status"));
			if(class_value.equals("QRYEVEN"))
				class_value = "QRYODD";
			else
				class_value = "QRYEVEN";
			%>
	<tr>
		<td class="<%=class_value%>" width='10%'><%=p_encounter_type%></td>
		<td class="<%=class_value%>" width='10%'><%=p_encounter_id%></td>		
		<td class="<%=class_value%>" width='10%'><%=p_doc_folder%></td>
		<td class="<%=class_value%>" width='10%'><%=p_doc_type%></td>
		<td class="<%=class_value%>" width='10%'><%=p_doc_no%></td>
		<td class="<%=class_value%>" width='10%'><%=p_reqd_type%></td>
		<td class="<%=class_value%>" width='10%'><%=p_fs_location%></td>
		<td class="<%=class_value%>" width='10%'><%=p_file_status%></td>
	</tr>

			<%
		}//end inner if				
		}//end while
		}//end if
%>

</table>
<input type='hidden' name='previousRecord' id='previousRecord' value='<%=fromRecordNumber%>' >
<input type='hidden' name='nextRecord' id='nextRecord' value='<%=toRecordNumber%>' >
<input type="Hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
<input type="Hidden" name="encounter_id" id="encounter_id" value="<%=encounter_id%>">

</form>
</body>
<% }//else ends %>
<%
if(rs!=null)rs.close();
if(rs1!=null)rs1.close();
if(pstmt!=null)pstmt.close();
if(pstmt1!=null)pstmt1.close();	
} catch(Exception e)
{
	out.println("Exception ::"+e);
}
finally {	
	if(con!=null)	
	ConnectionManager.returnConnection(con,request);
}%>
</html>
<%!
public String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "&nbsp;" : inputString);
}
%>

