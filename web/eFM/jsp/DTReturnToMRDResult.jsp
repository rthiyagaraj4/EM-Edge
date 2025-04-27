<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.Statement, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager, java.util.StringTokenizer" contentType="text/html; charset=UTF-8" %>
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
<script language='javascript' src='../../eFM/js/FMReturnToMRD.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>
<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

String facility_id				=	"";
String patient_id				=	"";
String fs_location				=	"";
String fs_req_location			=	"";
String returning_code			=	"";
String date_time				=	"";
String transport_mode			=	"";
String transport_mode_desc		=	"";
String file_type_appl_yn		=	"N";
String file_no					=	"";
String file_type				=	"";
String volume_no				=	"";
String from		 				=	"";
String to		 				=	"";
String added_items				=	"";
String added_patients			=	"";
String added_volumes			=	"";
String show_all_yn				=	"Y";
String valid_records			=	"Y";
String class_value				=	"QRYEVEN";
int total_records			= 0;


String doc_folder_id = "", doc_folder_name = "", doc_type_name = "", doc_type="",doc_type_code="";
int record_count				=	0;
int start						=	0 ;
int end							=	0 ;
int count						=	1 ;

StringBuffer sqlBuffer		=	new StringBuffer();
StringBuffer queryBuffer	=	new StringBuffer();
StringBuffer whereBuffer	=	new StringBuffer();

try
{
	facility_id 		=	checkForNull((String) session.getValue("facility_id"));
	fs_location			=	checkForNull(request.getParameter("fs_location"));
	fs_req_location		=	checkForNull(request.getParameter("fs_req_location"));
	returning_code		=	checkForNull(request.getParameter("returning_code"));
	date_time			=	checkForNull(request.getParameter("date_time"));
	transport_mode		=	checkForNull(request.getParameter("transport_mode"));
	transport_mode_desc	=	checkForNull(request.getParameter("transport_mode_desc"));
	patient_id			=	checkForNull(request.getParameter("patient_id"));
	file_type_appl_yn	=	checkForNull(request.getParameter("file_type_appl_yn"));
	file_no				=	checkForNull(request.getParameter("file_no"));
	file_type			=	checkForNull(request.getParameter("file_type"));
	volume_no			=	checkForNull(request.getParameter("volume_no"));
	from				=	checkForNull(request.getParameter("from"));
	to					=	checkForNull(request.getParameter("to"));
	added_items			=	checkForNull(request.getParameter("added_items"));
	added_patients		=	checkForNull(request.getParameter("added_patients"));
	added_volumes		=	checkForNull(request.getParameter("added_volumes"));
	valid_records		=	checkForNull(request.getParameter("valid_records"));
	show_all_yn			=	checkForNull(request.getParameter("show_all_yn"), "Y");
	
	if (from.equals(""))
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if (to.equals(""))
		end = 10 ;
	else
		end = Integer.parseInt( to ) ;
	
	connection			=	ConnectionManager.getConnection(request);	

	sqlBuffer.append("SELECT a.file_no, a.file_type_code,c.encounter_id,a.file_type_desc, a.volume_no, a.patient_id, get_patient_line (a.patient_id,'"+localeName+"') patient_line, to_char(a.iss_date_time, 'dd/mm/rrrr hh24:mi') iss_date_time, a.curr_fs_locn_code, a.curr_fs_locn_short_desc,a.MR_PAT_FS_LOCN_DESC, a.volume_no,a.doc_folder_id doc_folder_id, a.doc_folder_name, a.doc_type_name,a.doc_type_code, (CASE WHEN b.PATIENT_PERIOD_SPECIFIC='D' THEN ', ' || TO_CHAR(b.from_period,'dd/mm/rrrr ')|| ' - ' || TO_CHAR(b.to_period,'dd/mm/rrrr ')  ELSE ', ' || get_patient_line(b.patient_id) END)doc_type FROM fm_curr_locn_vw a,fm_doc_folder b,fm_encounter_doc_type_link c ");

	queryBuffer.append("SELECT COUNT(*) record_count FROM fm_curr_locn_vw a, fm_doc_folder b,fm_encounter_doc_type_link c ");
	whereBuffer.append(" where a.doc_folder_id=b.doc_folder_id and a.facility_id=b.facility_id and a.facility_id=c.facility_id and a.file_no=c.file_no ");
	whereBuffer.append(" and a.curr_file_status = 'O' AND a.curr_facility_id = '");
	whereBuffer.append(facility_id);
	whereBuffer.append("' AND a.curr_fs_locn_code = '");
	whereBuffer.append(fs_req_location);
	whereBuffer.append("' ");
	if (!returning_code.equals(""))
	{
		whereBuffer.append(" AND a.CURR_LOCN_ID = '");
		whereBuffer.append(returning_code);
		whereBuffer.append("' ");
	}
	
	if (!show_all_yn.equals("Y"))
	{
	//	whereBuffer.append(" AND a.file_no IN (");
	//	whereBuffer.append(added_items);
	//	whereBuffer.append(") AND a.patient_id IN (");
	whereBuffer.append(" AND a.patient_id IN (");
		whereBuffer.append(added_patients);
		whereBuffer.append(") ");
		
		if (!volume_no.equals(""))
		{
			whereBuffer.append(" AND a.volume_no IN (");
			whereBuffer.append(added_volumes);
			whereBuffer.append(") ");
		}
	}

	queryBuffer.append(whereBuffer.toString());
	preStatement	=	connection.prepareStatement(queryBuffer.toString());

	resultSet		=	preStatement.executeQuery();
	
	if ((resultSet != null) && (resultSet.next()))
		record_count = resultSet.getInt("record_count");

	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();

	if (record_count == 0)
	{
	%>
		<script>			
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.result_frame.document.location.href="../../eCommon/html/blank.html";
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
			parent.criteria_frame.document.forms[0].all_button.disabled = false;
			parent.criteria_frame.document.forms[0].patient_id.value = '';
		</script>
	<%
	}
	else
	{
		sqlBuffer.append(whereBuffer.toString());

		if (preStatement != null) preStatement = null;
		if (resultSet != null) resultSet = null;
		preStatement	=	connection.prepareStatement(sqlBuffer.toString());
		resultSet		=	preStatement.executeQuery();
	%>
		<body onMouseDown = "CodeArrest();" onKeyDown = 'lockKey();'> 
		<form name='FMReturnToMRDResultForm' id='FMReturnToMRDResultForm' action='DTReturnToMRDResult.jsp' method='POST'>
		<%
		if ((!(start <= 1)) || (!( (start+10) > record_count )))
		{
			%>
			<table align='right' ><tr><td  >
			<%
			if ( !(start <= 1) )
			{
			%>
				<a href='javascript:submitPrevNext(<%=start-10%>, <%=end-10%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
			<%
			}
					
			if ( !( (start+10) > record_count ) )
			{
			%>
				<a href='javascript:submitPrevNext(<%=(start+10)%>, <%=end+10%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			<%
			}
			%>
			</td></tr></table></p>
			<br><br>				
			<%
		}
		if (resultSet != null)
		{
		%>
		<table width="98%" cellpadding="0" cellspacing="0" border="1" align="CENTER">
		<tr>
			<td class='columnheader' width="26%"><fmt:message key="Common.documentdetails.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width="12%" ><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width="12%" ><fmt:message key="Common.encounterid.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width="13%"><fmt:message key="Common.issueddate.label" bundle="${common_labels}"/></td>
			<td class='columnheader' width="17%"><fmt:message key="eFM.IssuedFSLocation.label" bundle="${fm_labels}"/></td>
			<td class='columnheader' width="10%"><fmt:message key="eFM.ConfirmReturn.label" bundle="${fm_labels}"/></td>
		</tr>
		<%
			int strCount				=	0;
			int inc						=	0;
			String check_attribute		=	"";
			String confirm_values		=	"";
			StringTokenizer strToken	=	null;
			if ( start != 1 )
				for( int j=1; j<start; count++,j++ )
					resultSet.next() ;
			
			while (resultSet.next() && count<=end)
			{
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
				check_attribute = "";
				strToken	=	new StringTokenizer(valid_records, ",");
				strCount	=	strToken.countTokens();
				confirm_values	=	checkForNull(resultSet.getString("file_no"));
				confirm_values	= confirm_values +  "||" + checkForNull(resultSet.getString("volume_no"));
				confirm_values	= confirm_values +  "||" + checkForNull(resultSet.getString("doc_folder_id"));
				confirm_values	= confirm_values +  "||" + checkForNull(resultSet.getString("doc_type_code"));

				for (inc=0; inc<strCount; inc++)
				{
					if (strToken.hasMoreTokens())
						if ((checkForNull(strToken.nextToken())).equals(confirm_values))
							check_attribute = "Checked";
				}
				doc_folder_id = checkForNull(resultSet.getString("doc_folder_id"));
				doc_folder_name = checkForNull(resultSet.getString("doc_folder_name"));
				doc_type_name = checkForNull(resultSet.getString("doc_type_name"));
				doc_type = checkForNull(resultSet.getString("doc_type"));
				doc_type_code = checkForNull(resultSet.getString("doc_type_code"));
	
			%>
			<tr>
			<!-- Col 1 -->
			<td class="<%=class_value%>"><font size=1><b><%=doc_folder_id%><input type='hidden' name='doc_folder_id<%=count%>' id='doc_folder_id<%=count%>' value='<%=doc_folder_id%>'></b>
			<br>&nbsp;<%=doc_folder_name%><%=doc_type%><input type='hidden' name='doc_type_code<%=count%>' id='doc_type_code<%=count%>' value='<%=doc_type_code%>'></font></td>
			<td class="<%=class_value%>" ><font size="1"><%=doc_type_name%>,<BR><A HREF CLASS="label" onMouseover="changeCursor(this)" onClick="callPatDetails('<%=resultSet.getString("PATIENT_ID")%>')"><%=resultSet.getString("PATIENT_ID")%>&nbsp;</A></font></td>	

			<!-- ragha -->

			<td  CLASS="<%=class_value%>" width='12%'>
			<A HREF onMouseover="changeCursor(this)" onClick="showEncounter('<%=resultSet.getString("ENCOUNTER_ID")%>','<%=resultSet.getString("PATIENT_ID")%>','<%=resultSet.getString("FILE_NO")%>')"><font size=1><%=resultSet.getString("encounter_id")%></font></A></td>

			<td class="<%=class_value%>" align="CENTER"><font size="1"><%=checkForNull(resultSet.getString("iss_date_time"), "&nbsp;")%></font></td>	
			<td class="<%=class_value%>" align='center'><font size="1"><%=checkForNull(resultSet.getString("MR_PAT_FS_LOCN_DESC"), "&nbsp;")%></font></td>	
			<td class="<%=class_value%>" align="CENTER"><font size="1"><input type="checkbox" name="confirm<%=count%>" id="confirm<%=count%>" value="<%=confirm_values%>" onClick="markCheckedRecords(this);" <%=check_attribute%> ></font></td>	
			</tr>
			<%
				count++;
				total_records ++;
			}
		}
	%>
		<input type="Hidden" name="from" id="from" value="<%=from%>">
		<input type="Hidden" name="to" id="to" value="<%=to%>">
		<input type="Hidden" name="fs_location" id="fs_location" value="<%=fs_location%>">
		<input type="Hidden" name="fs_req_location" id="fs_req_location" value="<%=fs_req_location%>">
		<input type="Hidden" name="returning_code" id="returning_code" value="<%=returning_code%>">
		<input type="Hidden" name="date_time" id="date_time" value="<%=date_time%>">
		<input type="Hidden" name="transport_mode" id="transport_mode" value="<%=transport_mode%>">
		<input type="Hidden" name="patient_id" id="patient_id" value="<%=patient_id%>">
		<input type="Hidden" name="file_type_appl_yn" id="file_type_appl_yn" value="<%=file_type_appl_yn%>">
		<input type="Hidden" name="file_no" id="file_no" value="<%=file_no%>">
		<input type="Hidden" name="file_type" id="file_type" value="<%=file_type%>">
		<input type="Hidden" name="volume_no" id="volume_no" value="<%=volume_no%>">
		<input type="Hidden" name="added_items" id="added_items" value="<%=added_items%>">
		<input type="Hidden" name="added_patients" id="added_patients" value="<%=added_patients%>">
		<input type="Hidden" name="show_all_yn" id="show_all_yn" value="<%=show_all_yn%>">
		<input type="Hidden" name="valid_records" id="valid_records" value="<%=valid_records%>">
		<input type="Hidden" name="transport_mode_desc" id="transport_mode_desc" value="<%=transport_mode_desc%>">
		<input type="Hidden" name="total_records" id="total_records" value="<%=total_records%>">
		<input type="Hidden" name="doc_folder_ids" id="doc_folder_ids" value="<%=total_records%>">
		<input type="Hidden" name="doc_type_codes" id="doc_type_codes" value="<%=total_records%>">


		</form>
		<script>
			parent.criteria_frame.document.forms[0].fs_location.disabled = true;
			parent.criteria_frame.document.forms[0].fs_req_location.disabled = true;
			parent.criteria_frame.document.forms[0].returning_desc.disabled = true;
			parent.criteria_frame.document.forms[0].ret_button.disabled = true;
			parent.criteria_frame.document.forms[0].all_button.disabled = true;
			parent.messageFrame.document.location.href="../../eCommon/jsp/error.jsp";
		</script>
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
	return(((inputString == null) || (inputString.equals("null")) ) ? defaultValue : inputString);
}

%>

