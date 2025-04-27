<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement, webbeans.eCommon.ConnectionManager, java.util.StringTokenizer" contentType="text/html; charset=UTF-8"%>
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

	<script language="javascript" src="../../eFM/js/DTFolderInFSLocn.js"></script>
	<script language="javascript" src="../../eCommon/js/ValidateControl.js"></script>
	<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>
<body onMouseDown="CodeArrest();" onKeyDown = 'lockKey();'>
<form name="DTFolderInFSLocnForm" id="DTFolderInFSLocnForm" action="DTFolderInFSLocnResult.jsp" method="POST">
<%
	Connection connection		=	null;
	PreparedStatement pstmt		=	null;
	PreparedStatement preStmt	=	null;
	ResultSet	rset			=	null;
	ResultSet	resultSet		=	null;

	String facility_id		=	"";
	String from		 		=	"";
	String to		 		=	"";
	String valid_values		=	"";
	String fs_location		=	"";
	String class_value		=	"QRYEVEN";
	String doc_folder_id	=	"";	
	String chk_attribute	=	"";	
	String disablefields	=	"";
	String PrevNext			=	"";
	String checked_yn		=	"";
	
	int start				=	0 ;
	int end					=	0 ;
	int count				=	1;
	int record_count		=	0;

	try
	{

		facility_id		   =	checkForNull((String) session.getAttribute("facility_id"));
		from			   =	checkForNull(request.getParameter("from"));
		to				   =	checkForNull(request.getParameter("to"));
		valid_values	   =	checkForNull(request.getParameter("valid_values"));
		fs_location		   =	checkForNull(request.getParameter("fs_location"));
		from			   =	checkForNull(request.getParameter("from"));
		to				   =	checkForNull(request.getParameter("to"));
		PrevNext		   =	checkForNull(request.getParameter("PrevNext"));
		checked_yn		   =	checkForNull(request.getParameter("checked_yn"));
		
		connection		   =	ConnectionManager.getConnection(request);
		
		if (from.equals(""))
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;

		if (to.equals(""))
			end = 15 ;
		else
			end = Integer.parseInt( to ) ;


%>
<%
	pstmt		=	connection.prepareStatement(" SELECT count(*) record_count FROM fm_doc_folder WHERE eff_status = 'E' ");
	rset =	pstmt.executeQuery();
	if ((rset!=null) && (rset.next()))
		record_count = rset.getInt("record_count");
	
	if (rset != null) rset.close();
	if (pstmt != null) pstmt.close();

	if ((!(start <= 1)) || (!( (start+15) > record_count )))
	{
		%>
		<table align='right'><tr><td align ='right'>
		<%
		if ( !(start <= 1) )
		{
		%>
			<a href='javascript:submitPrevNext(<%=start-15%>, <%=end-15%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
		<%
		}
				
		if ( !( (start+15) > record_count ) )
		{
		%>
			<a href='javascript:submitPrevNext(<%=(start+15)%>, <%=end+15%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
		<%
		}
		%>
		</td></tr></table></p>
		<br><br>				
		<%
	}
%>

<table cellpadding="0" cellspacing="0" border="1" width="75%" align="CENTER"> 
<tr>
	<td width="80%" class='columnheader'><fmt:message key="eFM.FolderName.label" bundle="${fm_labels}"/></td>
	<td width="10%" class='columnheader'><fmt:message key="Common.ApplicableTo.label" bundle="${common_labels}"/></td>
	<td width="10%" class='columnheader'><fmt:message key="Common.defaultSelect.label" bundle="${common_labels}"/></td>
</tr>
<%
		if (!PrevNext.equals("Y"))
		{
			StringBuffer strBuffer	=	new StringBuffer();
			preStmt		=	connection.prepareStatement(" SELECT doc_folder_id FROM fm_folder_in_fs_locn WHERE facility_id = ? AND fs_locn_code = ? ");
			preStmt.setString(1, facility_id);
			preStmt.setString(2, fs_location);
			resultSet	=	preStmt.executeQuery();
			if (resultSet != null)
			while(resultSet.next())
			{
				doc_folder_id	=	checkForNull(resultSet.getString("doc_folder_id"));
				if ((strBuffer!=null) && (strBuffer.length()>0))
					strBuffer.append(",");
				strBuffer.append(doc_folder_id);
			}
			valid_values	=	strBuffer.toString();
		}
		pstmt		=	connection.prepareStatement(" SELECT doc_folder_id, doc_folder_name, decode(patient_period_specific, 'D', 'Period', 'P', 'Patient') patient_period FROM fm_doc_folder WHERE facility_id = ?  AND eff_status = 'E' ORDER BY doc_folder_name ");
		pstmt.setString(1, facility_id);
		rset =	pstmt.executeQuery();
		if (rset!=null)
		{
			if ( start != 1 )
				for( int j=1; j<start; count++,j++ )
					rset.next() ;
			
			StringTokenizer outerToken	=	null;
			String tokenValue			=	"";
			doc_folder_id		=	"";
			while(rset.next() && count<=end )
			{
				chk_attribute		=	"";				
				doc_folder_id		=	"";				
				outerToken			=	new StringTokenizer(valid_values, ",");
				doc_folder_id		=	checkForNull(rset.getString("doc_folder_id"));
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
				while (outerToken.hasMoreTokens())
				{
					tokenValue	=	checkForNull(outerToken.nextToken());
					if (doc_folder_id.equals(tokenValue))
					{
						chk_attribute = "Checked";
						break;
					}
					
					}
%>
	<tr>
		<td width="90%" class="<%=class_value%>"><%=checkForNull(rset.getString("doc_folder_name"))%><input type="Hidden" name="doc_folder_id<%=count%>" id="doc_folder_id<%=count%>" value="<%=doc_folder_id%>"></td>
		<td width="10%" class="<%=class_value%>"><%=checkForNull(rset.getString("patient_period"), "&nbsp;")%>
		</td>
		<td width="10%" class="<%=class_value%>" align="CENTER">
			<%
			if(chk_attribute.equals("Checked"))
					disablefields = "disabled";
					else
					disablefields = "";
			%>
			<input type="checkbox" name="include_yn_<%=count%>" id="include_yn_<%=count%>" value="<%=doc_folder_id%>" onClick="getCheckedValues(this)" <%=chk_attribute%> <%=disablefields%>>
		</td>
	</tr>
<%
				count++;
			}
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
<input type="Hidden" name="fs_location" id="fs_location" value="<%=fs_location%>">
<input type="Hidden" name="operation" id="operation" value="Insert">
<input type="Hidden" name="from" id="from" value="<%=from%>">
<input type="Hidden" name="to" id="to" value="<%=to%>">
<input type="Hidden" name="PrevNext" id="PrevNext" value="Y">
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

