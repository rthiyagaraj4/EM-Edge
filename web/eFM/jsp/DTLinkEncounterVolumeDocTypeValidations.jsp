<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager, java.util.ArrayList, java.util.StringTokenizer, java.util.Iterator" contentType="text/html; charset=UTF-8" %>
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
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;

try
{
	String sqlString			=	"";
	String facilityID 			=	checkForNull((String) session.getValue("facility_id"));
	String document_no			=	checkForNull(request.getParameter("document_no"));
	String operation			=	checkForNull(request.getParameter("operation"));
	String patient_id			=	checkForNull(request.getParameter("patient_id"));
	String doc_folder_id		=	checkForNull(request.getParameter("doc_folder_id"));
	String maintain_doc_or_file	=	checkForNull(request.getParameter("maintain_doc_or_file"));
	String   status=checkForNull(request.getParameter("status"));
	String    count =checkForNull(request.getParameter("count"));
	String first_time=checkForNull(request.getParameter("first_time"));
	connection					=	ConnectionManager.getConnection(request);	
	StringTokenizer	srtToken	=	null;	
	if (operation.equals("DocumentFolder"))
	{
		String patient_period_specific	=	"";
		String from_period				=	"";
		String to_period				=	"";

		sqlString	="SELECT patient_period_specific, patient_id, to_char(from_period, 'dd/mm/rrrr') from_period, to_char(to_period, 'dd/mm/rrrr') to_period FROM fm_doc_folder WHERE facility_id = ? AND doc_folder_id = ? AND eff_status = 'E' ";
		
		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, doc_folder_id);
		resultSet		=	preStatement.executeQuery();
		
		if ((resultSet!=null) && (resultSet.next()))
		{
			patient_period_specific	=	checkForNull(resultSet.getString("patient_period_specific"));
			patient_id				=	checkForNull(resultSet.getString("patient_id"));
			from_period				=	checkForNull(resultSet.getString("from_period"));
			to_period				=	checkForNull(resultSet.getString("to_period"));
			%>
			<script>
				parent.criteria_frame.document.forms[0].patient_period_specific.value='<%=patient_period_specific%>';
				parent.criteria_frame.document.forms[0].patient_id.value='<%=patient_id%>';

				if ("<%=patient_period_specific%>"=="P")
				{
					parent.criteria_frame.document.getElementById("patient").innerHTML=getLabel("Common.patientId.label","common");
					parent.criteria_frame.document.getElementById("patient_detail").innerHTML="<b><%=patient_id%></b>";
					parent.criteria_frame.document.getElementById("period").innerHTML="&nbsp;";
					parent.criteria_frame.document.getElementById("period_detail").innerHTML="&nbsp;";
				}
				else
				{
					parent.criteria_frame.document.getElementById("patient").innerHTML=getLabel("Common.periodfrom.label","common");
					parent.criteria_frame.document.getElementById("patient_detail").innerHTML="<input type='Text' name='from_period' id='from_period' value='"+'<%=from_period%>'+"' maxlength='10' size='8' id='from_period' onBlur=\"validDateObj(this,'DMY',localeName);DateCompare(this, to_period, 'messageFrame','Period From');\" readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
					parent.criteria_frame.document.getElementById("period").innerHTML=getLabel("Common.to.label","common");
					parent.criteria_frame.document.getElementById("period_detail").innerHTML="<input type='Text' name='to_period' id='to_period' value='"+'<%=to_period%>'+"' maxlength='10' size='8' id='to_period' onBlur=\"validDateObj(this,'DMY',localeName);DateCompare(from_period, this, 'messageFrame','Period From');\" readonly>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center'></img>";
				}
				parent.tab_frame.document.location.href			=	"../../eCommon/html/blank.html";
				parent.result_frame.document.location.href		=	"../../eCommon/html/blank.html";
				parent.messageFrame.document.location.href		=	"../../eCommon/jsp/error.jsp";
			</script>
			<%
		}
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
	}
	else if ((!document_no.equals("")) && (operation.equals("GetDocumentType")))
	{
		sqlString		=	" SELECT doc_type_name, doc_type_code FROM fm_doc_type WHERE doc_no = ? ";
		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, document_no);
		resultSet		=	preStatement.executeQuery();
		if ((resultSet!=null) && (resultSet.next()))
		{
		%>
		<script>
			var code	=	'<%=checkForNull(resultSet.getString("doc_type_code"))%>';
			var desc	=	'<%=checkForNull(resultSet.getString("doc_type_name"))%>';
			parent.result_frame.add_doc_frame.document.forms[0].doc_type_code.value = code;
			parent.result_frame.add_doc_frame.document.forms[0].doc_type_desc.value = desc;
			parent.result_frame.add_doc_frame.document.forms[0].add_button.disabled = false;
			parent.result_frame.add_doc_frame.document.getElementById("doc_type").innerText		= desc;
		</script>
		<%
		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		}
		else 
		{
		%>
		<script>
			//alert("Invalid Document Number");
			alert(getMessage('INVALID_DOC_NO','FM'));
			parent.result_frame.add_doc_frame.document.forms[0].document_no.select();
		</script>
		<%
		}
	}
	else if ((!document_no.equals("")) && (operation.equals("AddRecords")))
	{
		String doc_type_code		=	checkForNull(request.getParameter("doc_type_code"));
		String doc_type_desc		=	checkForNull(request.getParameter("doc_type_desc"));
		String volume_no			=	checkForNull(request.getParameter("volume_no"));
		String file_no			=	checkForNull(request.getParameter("file_no"));
		String fs_location			=	checkForNull(request.getParameter("fs_location"));
		String encounter_id			=	checkForNull(request.getParameter("encounter_id"));
		String doc_details	=	checkForNull(request.getParameter("doc_details"));
		String doc_date	=	checkForNull(request.getParameter("doc_date"));
		
		boolean flag				=	true;
		String fs_location_code		=	"";
		String fs_location_desc		=	"";
		int record_count			=	0;

		sqlString	=	" SELECT count(*) record_count FROM fm_encounter_doc_type_link WHERE facility_id = ? AND encounter_id = ? AND doc_type_code = ? AND file_no = ? ";
		
		preStatement	=	connection.prepareStatement(sqlString);
		preStatement.setString(1, facilityID);
		preStatement.setString(2, encounter_id);
		preStatement.setString(3, doc_type_code);
		preStatement.setString(4, file_no);
		resultSet		=	preStatement.executeQuery();
		
		if ((resultSet!=null) && (resultSet.next()))
		{
			record_count	=	resultSet.getInt("record_count");
		}

		if (record_count == 0)
		{
			srtToken	=	new StringTokenizer(fs_location, "$$");
			if (srtToken.hasMoreTokens())
				fs_location_code	=	checkForNull(srtToken.nextToken());
			if (srtToken.hasMoreTokens())
				fs_location_desc	=	checkForNull(srtToken.nextToken());

			ArrayList arrList			=	new ArrayList();
			if (!maintain_doc_or_file.equals("D"))
				arrList.add(volume_no);
			else
			{
				arrList.add(fs_location_code);
				arrList.add(fs_location_desc);
			}
			arrList.add(document_no);
			arrList.add(doc_type_code);
			arrList.add(doc_type_desc);
			arrList.add(doc_details);
			arrList.add(doc_date);
		
			ArrayList documentArrList	=	((ArrayList)session.getAttribute("documentArrList"));	
			if (documentArrList != null)
			{
				String volume_no_temp			=	"";
				String fs_location_temp			=	"";
				String fs_location_desc_temp	=	"";
				String document_no_temp			=	"";
				String doc_type_code_temp		=	"";
				String doc_type_desc_temp		=	"";
				String doc_details_temp			=	"";
				String doc_date_temp			=	"";
				Iterator	outIter =	documentArrList.iterator();
				Iterator	inItr	=	null;
				while (outIter.hasNext())
				{
					inItr	= ((ArrayList)outIter.next()).iterator();
					if (!maintain_doc_or_file.equals("D"))
						volume_no_temp	=	(String)inItr.next();
					else
					{
						fs_location_temp		=   (String)inItr.next();
						fs_location_desc_temp	=   (String)inItr.next();
					}
					document_no_temp			=	(String)inItr.next();
					doc_type_code_temp			=	(String)inItr.next();
					doc_type_desc_temp			=	(String)inItr.next();
					doc_details_temp			=	(String)inItr.next();
					doc_date_temp			=	(String)inItr.next();
					if (document_no.equals(document_no_temp) && doc_type_code.equals(doc_type_code_temp))
					{
						flag	=	false;
					%>
					<script>
						//alert("Record Already Selected");
						alert(getMessage('RECORD_ALREADY_SEL','FM'));
					</script>
					<%
					}
				}
				if (flag)
					documentArrList.add(arrList);
			}
			else
			{
				documentArrList	=	new ArrayList();
				documentArrList.add(arrList);
			}
			if (flag)
			{
				session.setAttribute("documentArrList", documentArrList);
				%>
				<script>
				parent.result_frame.add_doc_frame.document.forms[0].document_no.value	= "";	
				parent.result_frame.add_doc_frame.document.forms[0].add_button.disabled	= true;	
				parent.result_frame.add_doc_frame.document.getElementById("doc_type").innerHTML		= "&nbsp;";	
				parent.result_frame.add_doc_frame.document.forms[0].doc_details.value	= "";
				parent.result_frame.add_doc_frame.document.forms[0].document_date.value	= "";
				//parent.result_frame.select_doc_frame.location.href="../../eFM/jsp/DTLinkEncounterDocumentsList.jsp?maintain_doc_or_file="+"<%=maintain_doc_or_file%> &status="+"<%=status%>";
		  var maintain_doc_or_file="<%=maintain_doc_or_file%>";	
		  var status="<%=status%>";	
		 var  count="<%=count%>";	
		var first_time="<%=first_time%>";	 
parent.result_frame.select_doc_frame.location.href='../../eFM/jsp/DTLinkEncounterDocumentsList.jsp?&maintain_doc_or_file=' +maintain_doc_or_file + '&status='+status+ '&count='+count+ '&first_time='+first_time;	
							
				</script>
				<%
			}
		}
		else
		{
			%>
			 <script>
				//alert("Record Already Exists in Database. ");
				alert(getMessage('RECORD_EXISTS','SM'));
			</script> 
			<%
		}
	}
	else if (operation.equals("RemoveElement"))
	{
		String doc_type_code		=	checkForNull(request.getParameter("doc_type_code"));
		String doc_type_desc		=	checkForNull(request.getParameter("doc_type_desc"));
		String volume_no			=	checkForNull(request.getParameter("volume_no"));
		String fs_location			=	checkForNull(request.getParameter("fs_location"));
		String fs_location_code		=	"";
		String fs_location_desc		=	"";

		srtToken	=	new StringTokenizer(fs_location, "$$");
		if (srtToken.hasMoreTokens())
			fs_location_code	=	checkForNull(srtToken.nextToken());
		if (srtToken.hasMoreTokens())
			fs_location_desc	=	checkForNull(srtToken.nextToken());
		
		ArrayList arrList			=	new ArrayList();
		if (!maintain_doc_or_file.equals("D"))
			arrList.add(volume_no);
		else
		{
			arrList.add(fs_location_code);
			arrList.add(fs_location_desc);
		}

		arrList.add(document_no);
		arrList.add(doc_type_code);
		arrList.add(doc_type_desc);
		ArrayList documentArrList	=	((ArrayList)session.getAttribute("documentArrList"));	
		documentArrList.remove(arrList);
		session.setAttribute("documentArrList", documentArrList);
	%>
		<script>
			parent.result_frame.add_doc_frame.document.forms[0].document_no.value	= "";	
			parent.result_frame.add_doc_frame.document.forms[0].add_button.disabled	= true;	
			parent.result_frame.add_doc_frame.document.getElementById("doc_type").innerHTML		= "&nbsp;";	
	 //	parent.result_frame.select_doc_frame.location.href="../../eFM/jsp/DTLinkEncounterDocumentsList.jsp?maintain_doc_or_file="+"<%=maintain_doc_or_file%>";
		 var maintain_doc_or_file="<%=maintain_doc_or_file%>";	
		  var status="<%=status%>";	
		  var  count="<%=count%>";	 parent.result_frame.select_doc_frame.location.href='../../eFM/jsp/DTLinkEncounterDocumentsList.jsp?&maintain_doc_or_file=' +maintain_doc_or_file + '&status='+status+ '&count='+count;	
		
		</script>
	<%
	}
	%>
	<script>
	parent.messageFrame.location.href='../../eCommon/jsp/error.jsp';
	</script>
	<%
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

%>

