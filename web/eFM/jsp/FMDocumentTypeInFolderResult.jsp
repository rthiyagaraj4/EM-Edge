<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement, webbeans.eCommon.ConnectionManager, java.util.StringTokenizer" contentType="text/html; charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
	<!-- <link rel="stylesheet" type="text/css" href="../../eCommon/html/IeStyle.css"></link> -->
	<%
	request.setCharacterEncoding("UTF-8");
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script language="javascript" src="../../eFM/js/FMDocumentTypeFolder.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<SCRIPT language='javascript' src='../../eCommon/js/common.js'></SCRIPT>
</head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="FMDocumentContentForm" id="FMDocumentContentForm" action="FMDocumentTypeInFolderResult.jsp" method="POST">
<%
	Connection connection		=	null;
	PreparedStatement pstmt		=	null;
	PreparedStatement preStmt	=	null;
	ResultSet	rset			=	null;
	ResultSet	resultSet		=	null;
		
	String from		 		=	"";
	String to		 		=	"";
	String valid_values		=	"";
	String folderName		=	"";
	String class_value		=	"QRYEVEN";
	String folder_id		=	"";
	String folder_name		=	"";
	String doc_type_code	=	"";
	String reqd_type		=	"";
	String chk_attribute	=	"";
	String disablefields	=	"";
	String sel_attribute	=	"";
	String PrevNext			=	"";
	String checked_yn		=	"";
	
	int start				=	0 ;
	int end					=	0 ;
	int count				=	1;
//	int record_count		=	0;

	try
	{

		String facility_id =	checkForNull((String) session.getAttribute("facility_id"));
		from			   =	checkForNull(request.getParameter("from"));
		to				   =	checkForNull(request.getParameter("to"));
		valid_values	   =	checkForNull(request.getParameter("valid_values"));
		folderName		   =	checkForNull(request.getParameter("folderName"));
		connection		   =	ConnectionManager.getConnection(request);
		from			   =	checkForNull(request.getParameter("from"));
		to				   =	checkForNull(request.getParameter("to"));
		PrevNext		   =	checkForNull(request.getParameter("PrevNext"));
		checked_yn		   =	checkForNull(request.getParameter("checked_yn"));
		
		if (from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if (to.equals(""))
			end = 15 ;
		else
			end = Integer.parseInt( to ) ;

		StringTokenizer folderToken	=	new StringTokenizer(folderName, "$$");
		
		if (folderToken.hasMoreTokens())
			folder_id	=	folderToken.nextToken();
		if (folderToken.hasMoreTokens())
			folder_name	=	folderToken.nextToken();

%>
<%
	/*pstmt		=	connection.prepareStatement(" SELECT count(*) record_count FROM fm_doc_type WHERE eff_status = 'E' ");
	rset =	pstmt.executeQuery();
	if ((rset!=null) && (rset.next()))
		record_count = rset.getInt("record_count");
	
	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close();*/

	/*if ((!(start <= 1)) || (!( (start+15) > record_count )))
	{*/
		%>
		
<%
		if (!PrevNext.equals("Y"))
		{
			StringBuffer strBuffer	=	new StringBuffer();
			preStmt		=	connection.prepareStatement(" SELECT doc_type_code, reqd_type FROM fm_doc_type_in_folder WHERE facility_id = ? AND doc_folder_id = ? ");
			preStmt.setString(1, facility_id);
			preStmt.setString(2, folder_id);

			resultSet	=	preStmt.executeQuery();
			if (resultSet != null)
			while(resultSet.next())
			{
				doc_type_code	=	checkForNull(resultSet.getString("doc_type_code"));
				reqd_type		=	checkForNull(resultSet.getString("reqd_type"));
				if ((strBuffer!=null) && (strBuffer.length()>0))
					strBuffer.append(",");
				strBuffer.append(doc_type_code);
				strBuffer.append("$$");
				strBuffer.append(reqd_type);
			}
			valid_values	=	strBuffer.toString();
		}
		pstmt		=	connection.prepareStatement(" SELECT doc_type_code, doc_type_name FROM fm_doc_type WHERE eff_status = 'E' ORDER BY doc_type_name ");
		rset =	pstmt.executeQuery();
		if (rset!=null)
		{
			if ( start != 1 )
				for( int j=1; j<start; count++,j++ )
					rset.next() ;
			StringTokenizer outerToken	=	null;
			StringTokenizer innerToken	=	null;
			String tokenValue			=	"";
			String document_type_code	=	"";
			int cnt=0;
			while( count<=end && rset.next())
			{
				if(cnt==0)
				{%>
					<table align='right'><tr>
					<%
					if ( !(start <= 1) )
					{
					%>
						<td align ='right' id='prev'><a href='javascript:submitPrevNext(<%=start-15%>, <%=end-15%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a></td>
					<%
					}
							
					//if ( !( (start+15) > record_count ) )
				//	{
					%>
						<td align ='right' id='next' style='visibility:hidden'><a href='javascript:submitPrevNext(<%=(start+15)%>, <%=end+15%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
					<%
				//	}
					%>
					</td></tr></table></p>
					<br><br>				
					<%
				//}
			%>

			<table cellpadding="0" cellspacing="0" border="1" width="75%" align="CENTER"> 
			<tr>
				<th width="80%" ><fmt:message key="Common.documenttype.label" bundle="${common_labels}"/></th>
				<th width="10%" ><fmt:message key="Common.required.label" bundle="${common_labels}"/>&nbsp;<img src='../../eCommon/images/mandatory.gif' align='center' id="mand<%=count%>"></img></th>
				<th width="10%" ><fmt:message key="Common.Include.label" bundle="${common_labels}"/></th>
			</tr>
<%				}
				chk_attribute		=	"";
				sel_attribute		=	"";
				doc_type_code		=	"";
				reqd_type			=	"";
				outerToken	=	new StringTokenizer(valid_values, ",");
				document_type_code	=	checkForNull(rset.getString("doc_type_code"));
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
				while (outerToken.hasMoreTokens())
				{
					doc_type_code	=	"";
					reqd_type		=	"";
					tokenValue	=	checkForNull(outerToken.nextToken());
					if (!tokenValue.equals(""))
					{
						doc_type_code	=	"";
						reqd_type		=	"";
						innerToken	=	new StringTokenizer(tokenValue, "$$");
						if (innerToken.hasMoreTokens())
							doc_type_code	=	checkForNull(innerToken.nextToken());
						if (innerToken.hasMoreTokens())
							reqd_type		=	checkForNull(innerToken.nextToken());
					}
					if (doc_type_code.equals(document_type_code))
					{
						chk_attribute = "Checked";
						
						break;
					}
				}
%>
	<tr>
		<td width="90%" class="<%=class_value%>"><%=checkForNull(rset.getString("doc_type_name"))%><input type="Hidden" name="doc_type_code<%=count%>" id="doc_type_code<%=count%>" value="<%=document_type_code%>"></td>
		<td width="10%" class="<%=class_value%>">
		<select name="required_type<%=count%>" id="required_type<%=count%>" onChange="getSelectedValues(this, include_yn_<%=count%>);getCheckedValues(document.forms[0].include_yn_<%=count%>, required_type<%=count%>);">
		<option value="">---<fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/>---</option>
		<%
			if ((chk_attribute.equals("Checked")) && (reqd_type.equals("M")))
				 sel_attribute	=	"Selected";
			else sel_attribute	=	"";

			if(chk_attribute.equals("Checked"))
				disablefields = "disabled";
			else
				disablefields = "";
		%>
		<option value="M" <%=sel_attribute%>><fmt:message key="Common.Mandatory.label" bundle="${common_labels}"/></option>
		<%
			if ((chk_attribute.equals("Checked")) && (reqd_type.equals("S")))
				 sel_attribute	=	"Selected";
			else sel_attribute	=	"";
			
		%>
		<option value="S" <%=sel_attribute%>><fmt:message key="eFM.Statutory.label" bundle="${fm_labels}"/></option>
		</select>
		</td>
		<td width="10%" class="<%=class_value%>" align="CENTER">
			<input type="checkbox" name="include_yn_<%=count%>" id="include_yn_<%=count%>" value="<%=checkForNull(rset.getString("doc_type_code"))%>" onClick="getCheckedValues(this, required_type<%=count%>)" <%=chk_attribute%> <%=disablefields%>>
		</td>
	</tr>
<%
				count++;
				cnt++;
			}
			if (cnt==0)
			{
				out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
			}
			boolean flag = false;
			if ( cnt < 14 || (!rset.next()) ) {
			%>
				<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='hidden';
				</script>
			<% flag = true;
					} else {%>
				<script >
				if (document.getElementById("next"))
					document.getElementById("next").style.visibility='visible';
				</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



			<%}
		}
	if (rset != null) rset.close();
	if (resultSet != null) resultSet.close();
	if (preStmt != null) preStmt.close();
	if (pstmt != null) pstmt.close();
	}
	catch(Exception e)
	{
		out.println("Exception : " + e.toString());
	}
	finally
	{		
		ConnectionManager.returnConnection(connection, request);
	}
%>	
</table>
<input type="Hidden" name="valid_values" id="valid_values" value="<%=valid_values%>">
<input type="Hidden" name="folderName" id="folderName" value="<%=folderName%>">
<input type="Hidden" name="operation" id="operation" value="Insert">
<input type="Hidden" name="from" id="from" value="<%=from%>">
<input type="Hidden" name="to" id="to" value="<%=to%>">
<input type="Hidden" name="PrevNext" id="PrevNext" value="Y">
<input type="Hidden" name="folder_name" id="folder_name" value="<%=folder_name%>">
<input type="Hidden" name="checked_yn" id="checked_yn" value="<%=checked_yn%>">
</form>
<script>
	parent.messageFrame.document.location.href="../../eCommon/jsp/MstCodeError.jsp?err_num=";
</script>
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

