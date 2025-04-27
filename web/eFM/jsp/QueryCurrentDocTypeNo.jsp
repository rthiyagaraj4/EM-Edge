<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.Statement, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager, java.util.StringTokenizer" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>
<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
<script language='javascript' src='../../eFM/js/QueryFMCurrentFileStatus.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;
//String facility_id	= (String) session.getValue("facility_id");
String sqlString				=	"";
String file_no					=	"";
String file_type				=	"";
String volume_no				=	"";
String doc_folder_id			=	"";
String p_patient_id				=	"";
String doc_type_id				=	"";
String class_value				=	"QRYEVEN";
String rec_file_no				=	"";
String rec_patient_id			=	"";
String rec_encounter_id			=	"";

StringBuffer SelectSqlBuffer	= null;
int record_count				=	0;
int count						=	1;
try
{
	connection	= ConnectionManager.getConnection(request);

	file_no			= checkForNull(request.getParameter("file_no"));
	file_type		= checkForNull(request.getParameter("file_type"));
	volume_no		= checkForNull(request.getParameter("volume_no"));
	doc_folder_id	= checkForNull(request.getParameter("doc_folder_id"));
	p_patient_id	= checkForNull(request.getParameter("p_patient_id"));
	doc_type_id		= checkForNull(request.getParameter("doc_type_id"));

if (!doc_folder_id.equals(""))	
	{
	sqlString =	"SELECT count(*) record_count FROM fm_curr_locn_vw WHERE doc_folder_id = ? ";
	preStatement =	connection.prepareStatement(sqlString);
	preStatement.setString(1, doc_folder_id);
	}else
	{
	sqlString =	"SELECT count(*) record_count FROM fm_curr_locn_vw WHERE patient_id = ? ";
	preStatement =	connection.prepareStatement(sqlString);
	preStatement.setString(1, p_patient_id);
	}
	resultSet =	preStatement.executeQuery();
	
	if((resultSet != null) && (resultSet.next()))
		record_count = resultSet.getInt("record_count");
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
	if(record_count == 0)
	{
		%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.volumeFrame.document.location.href="../../eCommon/html/blank.html";
			parent.searchResultFrame.document.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
		</script>
		<%
	}
	else
	{
		SelectSqlBuffer.append("SELECT DISTINCT a.file_no, a.file_type_code, a.file_type_desc, a.volume_no, a.doc_type_code, a.doc_type_name, a.patient_id, decode('"+localeName+"', 'en', a.patient_name, nvl(a.patient_name_loc_lang, a.patient_name)) patient_name, b.encounter_id FROM fm_curr_locn_vw a, FM_ENCOUNTER_DOC_TYPE_LINK b WHERE a.file_no=b.file_no and a.facility_id=b.facility_id and a.doc_folder_id is not null ");
		if (!doc_folder_id.equals(""))
			SelectSqlBuffer.append(" AND a.doc_folder_id='"+doc_folder_id+"' ");
		if (!p_patient_id.equals(""))
			SelectSqlBuffer.append(" AND a.patient_id='"+p_patient_id+"' ");
		if (!doc_type_id.equals(""))
			SelectSqlBuffer.append(" AND a.doc_type_code='"+doc_type_id+"' ");

		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();		
		preStatement	=	connection.prepareStatement(SelectSqlBuffer.toString());
	//	preStatement.setString(1, facility_id);
		resultSet		=	preStatement.executeQuery();
	%>
		<body onMouseDown = "CodeArrest();" onKeyDown = 'lockKey();'> 
		<form name='QueryFileTypeVolume' id='QueryFileTypeVolume' action='' method='POST'>
		<%
		if(resultSet != null)
		{
			
			%>
			<table width="66%" cellpadding="0" cellspacing="0" border="1" align="CENTER" id='tb1'>
			<tr>
				<th class='columnheader' width="10%" style="background:#224771" id="th1"><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>		
				<th class='columnheader' width="10%" style="background:#224771" id="th2"><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></th>		
			</tr>
			<%
			while(resultSet.next())
			{
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";

			rec_file_no		=	checkForNull(resultSet.getString("file_no"));
			rec_patient_id	=	checkForNull(resultSet.getString("patient_id"));
			rec_encounter_id=	checkForNull(resultSet.getString("encounter_id"));
		%>
		<tr>
			<td class="<%=class_value%>" align="CENTER" style="cursor:pointer;color:blue" onClick="javascript:searchResult('<%=checkForNull(resultSet.getString("volume_no"))%>', '<%=checkForNull(resultSet.getString("file_no"))%>', '<%=checkForNull(resultSet.getString("patient_id"))%>','<%=checkForNull(resultSet.getString("doc_type_code"))%>');" onMouseOver="changeRowColor(this,1);changeBackground();" name='<%=count%>'><%=checkForNull(resultSet.getString("doc_type_name"), "&nbsp;")%></td>
			<td class="<%=class_value%>" > <A HREF CLASS="label" style="cursor:pointer;" onClick="javascript:showEncounter('<%=rec_encounter_id%>','<%=rec_patient_id%>','<%=rec_file_no%>');"><%=checkForNull(resultSet.getString("patient_id"), "&nbsp;")%></A>,&nbsp;<%=checkForNull(resultSet.getString("patient_name"), "&nbsp;")%></td>
		</tr>
		<%
			count++;
			}
		}
		%>
		<input type="Hidden" name="file_no" id="file_no" value="<%=file_no%>">
		<input type="Hidden" name="file_type" id="file_type" value="<%=file_type%>">
		<input type="Hidden" name="volume_no" id="volume_no" value="<%=volume_no%>">
		</form>
		<script>parent.searchResultFrame.location.href='../../eCommon/html/blank.html';</script>
	<%
	}
	if(preStatement!=null) preStatement.close();
	if(resultSet!=null)	resultSet.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
}
finally
{	
	ConnectionManager.returnConnection(connection,request);
}
%>
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

