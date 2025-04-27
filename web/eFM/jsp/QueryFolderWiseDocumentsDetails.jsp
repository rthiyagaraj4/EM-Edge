<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.Statement, java.sql.PreparedStatement,webbeans.eCommon.ConnectionManager" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language='javascript' src='../../eFM/js/QueryFolderWiseDocuments.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
Connection connection			= null;
PreparedStatement preStatement	= null;
ResultSet	resultSet			= null;
try
{	
	String facilityID 	= checkForNull((String) session.getValue("facility_id"));
	String folder_id 	= checkForNull(request.getParameter("folder_id"));
	String specific 	= checkForNull(request.getParameter("specific"));
	String from_period 	= checkForNull(request.getParameter("from_period"));
	String to_period 	= checkForNull(request.getParameter("to_period"));
	String patient_id 	= checkForNull(request.getParameter("patient_id"));
	String from			= checkForNull(request.getParameter("from"));
	String to			= checkForNull(request.getParameter("to"));
	String class_value  = "QRYEVEN";
	String patline		= "";

	connection = ConnectionManager.getConnection(request);	

	int record_count = 0;
	int start		 = 0;
	int end			 = 0;
	int count		 = 1;
	int increment	 = 16;
	int ind			 = 0;  // To get the index of last occurance of the character ","                   						  in the patline - by Meghanath.

	StringBuffer whereBuffer = null;
	StringBuffer sqlBuffer	 = null;
	StringBuffer countBuffer = new StringBuffer("SELECT COUNT(*) record_count ");
	
	if(from.equals(""))
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if (to.equals(""))
		end = increment ;
	else
		end = Integer.parseInt( to ) ;
	
	if(specific.equals("D"))
	{
		sqlBuffer	= new StringBuffer("SELECT a.doc_type_name, a.doc_no,c.encounter_id, c.patient_id, a.curr_fs_locn_desc,TO_CHAR (b.from_period, 'dd/mm/rrrr') from_period,TO_CHAR (b.to_period, 'dd/mm/rrrr') to_period, DECODE (a.curr_file_status,'I', 'Inside','O', 'Outside','L', 'Lost','T', 'Transit','R', 'Returned','A', 'Archived','E', 'External') curr_file_status,get_patient_line(c.patient_id,'"+localeName+"') patline ");

		whereBuffer	=	new StringBuffer("FROM fm_curr_locn_vw a, fm_doc_folder b,fm_encounter_doc_type_link c WHERE a.facility_id = b.facility_id AND a.doc_folder_id = b.doc_folder_id AND a.facility_id = c.facility_id AND a.doc_type_code = c.doc_type_code AND a.doc_folder_id = c.doc_folder_id AND a.file_no = c.file_no AND a.facility_id = ? AND a.doc_folder_id = ? ");
	}
	else if(specific.equals("P"))
	{
		sqlBuffer =	new StringBuffer("SELECT a.doc_type_name, a.doc_no,c.encounter_id, a.patient_id, a.curr_fs_locn_desc, to_char(b.from_period, 'dd/mm/rrrr') from_period, to_char(b.to_period, 'dd/mm/rrrr') to_period, DECODE (a.curr_file_status,'I','Inside','O','Outside','L','Lost','T','Transit','R','Returned', 'A','Archived', 'E', 'External')curr_file_status ");
		
		whereBuffer	= new StringBuffer(" FROM fm_curr_locn_vw a, fm_doc_folder b,fm_encounter_doc_type_link c WHERE a.facility_id = b.facility_id AND a.facility_id = c.facility_id AND a.doc_folder_id = b.doc_folder_id AND a.doc_type_code = c.doc_type_code AND a.doc_folder_id = c.doc_folder_id AND a.file_no = c.file_no AND a.facility_id = ? AND a.patient_id = ? AND a.doc_folder_id = ?");
	}
	sqlBuffer.append(whereBuffer);
	countBuffer.append(whereBuffer);

	preStatement = connection.prepareStatement(countBuffer.toString());
	if (specific.equals("D"))
	{
		preStatement.setString(1, facilityID);
		preStatement.setString(2, folder_id);		
	}
	else if (specific.equals("P"))
	{
		preStatement.setString(1, facilityID);
		preStatement.setString(2, patient_id);
		preStatement.setString(3, folder_id);
	}
	resultSet = preStatement.executeQuery();
	if ((resultSet != null) && (resultSet.next()))
		record_count = resultSet.getInt("record_count");
	if (record_count == 0)
	{
	%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.criteria_frame.document.forms[0].search.disabled = false;
			parent.criteria_frame.document.location.reload();
			parent.result_frame.document.location.href = "../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href = "../../eCommon/jsp/error.jsp";
		</script>
	<%
	}
	else
	{
	%>
	<body onMouseDown = "CodeArrest();" onLoad="FocusFirstElement();" onKeyDown = 'lockKey();'> 
	<form name='QueryFolderWiseResultForm' id='QueryFolderWiseResultForm' action='QueryFolderWiseDocumentsDetails.jsp' method='POST'>
<%
	if ((!(start <= 1)) || (!( (start+increment) > record_count )))
	{
		%>
		<table align='right'><tr><td align ='right'>
		<%
		if ( !(start <= 1) )
		{
		%>
			<a href='javascript:submitPrevNext(<%=start-increment%>, <%=end-increment%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<%
		}
				
		if ( !( (start+increment) > record_count ) )
		{
		%>
			<a href='javascript:submitPrevNext(<%=(start+increment)%>, <%=end+increment%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
		<%
		}
		%>
		</td></tr></table></p>
		<br><br>				
		<%
	}
%>
	<table width="100%" cellpadding="0" cellspacing="0" border="1">
	<%
		if ((specific.equals("P")) && (!patient_id.equals("")))
		{
	%>
		<tr>
		<td colspan="6">
			<jsp:include page="../../eCommon/jsp/pline.jsp" ><jsp:param name="flush" value="true" />
				<jsp:param name="Patient_ID" value="<%=patient_id%>" />
			</jsp:include>
		</td>
		</tr>
	<%
		}
	%>
	<tr>
	<%
		if (specific.equals("D"))
		{
	%>
		<td class='columnheader'><fmt:message key="Common.PatientDetails.label" bundle="${common_labels}"/></td>
	<%
		}
	%>
		<td class='columnheader'><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
		<td class='columnheader'><fmt:message key="eFM.DocumentID.label" bundle="${fm_labels}"/></td>
		<td class='columnheader'><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
		<td class='columnheader'><fmt:message key="eFM.CurrentFSLocation.label" bundle="${fm_labels}"/></td>
		<td class='columnheader'><fmt:message key="Common.status.label" bundle="${common_labels}"/></td>
	</tr>
	<%
		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		preStatement = connection.prepareStatement(sqlBuffer.toString());
		if (specific.equals("D"))
		{
			preStatement.setString(1, facilityID);
			preStatement.setString(2, folder_id);			
		}
		else if (specific.equals("P"))
		{
			preStatement.setString(1, facilityID);
			preStatement.setString(2, patient_id);
			preStatement.setString(3, folder_id);
		}
		resultSet	=	preStatement.executeQuery();
		if (resultSet!=null)
		{
			if ( start != 1 )
				for( int j=1; j<start; count++,j++ )
					resultSet.next() ;
			while (resultSet.next() && count<=end)
			{
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
			%>
			<tr>
			<%
				if(specific.equals("D"))
				{
					patline = resultSet.getString("patline");
					ind		= patline.lastIndexOf(',');
					patline = patline.substring(0,ind);
					if(patline == null || patline.equals("null"))
						patline = "&nbsp;";
			%>
					<td class="<%=class_value%>" nowrap><FONT size =1><%=checkForNull(resultSet.getString("patient_id"), "&nbsp;")%><br><%=patline%></FONT></td>
			<%
				}
			%>
				<td class="<%=class_value%>" nowrap><FONT size =1><%=checkForNull(resultSet.getString("encounter_id"), "&nbsp;")%></FONT></td>
				<td class="<%=class_value%>" nowrap><center><FONT size =1><%=checkForNull(resultSet.getString("doc_no"), "&nbsp;")%></FONT></center></td>
				<td class="<%=class_value%>" nowrap><FONT size =1><%=checkForNull(resultSet.getString("doc_type_name"), "&nbsp;")%></FONT></td>
				<td class="<%=class_value%>" nowrap><FONT size =1><%=checkForNull(resultSet.getString("curr_fs_locn_desc"), "&nbsp;")%></FONT></td>
				<td class="<%=class_value%>" nowrap><FONT size =1><%=checkForNull(resultSet.getString("curr_file_status"), "&nbsp;")%></FONT></td>
			</tr>
			<%		
				count++;
			}
		}
	%>
	</table>
	<input type="Hidden" name="from" id="from" value="<%=from%>">
	<input type="Hidden" name="to" id="to" value="<%=to%>">
	<input type="Hidden" name="folder_id" id="folder_id" value="<%=folder_id%>">
	<input type="Hidden" name="specific" id="specific" value="<%=specific%>">
	<input type="Hidden" name="from_period" id="from_period" value="<%=from_period%>">
	<input type="Hidden" name="to_period" id="to_period" value="<%=to_period%>">
	<input type="Hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
	</form>
		<script>
			parent.criteria_frame.document.forms[0].search.disabled = false;
		</script>
	</body>
    <%
	}
if(resultSet!=null)	resultSet.close();
if(preStatement!=null) preStatement.close();
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
public static String checkForNull(String inputString)
{
	return(((inputString == null) || (inputString.equals("null")) ) ? "" : inputString);
}

public static String checkForNull(String inputString, String defaultValue)
{
	return(((inputString == null) || (inputString.equals("null")) || (inputString.equals("")) ) ? defaultValue : inputString);
}
%>

