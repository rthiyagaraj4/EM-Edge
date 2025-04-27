<!DOCTYPE html>
<%@ page import="java.sql.Connection, java.sql.ResultSet, java.sql.PreparedStatement,  webbeans.eCommon.ConnectionManager, java.util.StringTokenizer" contentType="text/html; charset=UTF-8"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>

<html>
<head>
<!-- <link rel='stylesheet' type ='text/css' href='../../eCommon/html/IeStyle.css'></link> -->
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"),"IeStyle.css");
	
%>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

<script language='javascript' src='../../eCommon/js/common.js'></script>
<script language='javascript' src='../../eCommon/js/ValidateControl.js'></script>
<script language='javascript' src='../../eCommon/js/CommonCalendar.js'></script>
<script language="javascript" src="../../eCommon/js/rowcolor.js" ></script>
<script src="../../eFM/js/DTDocumentNumberLookup.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


<%
Connection connection			=	null;
PreparedStatement preStatement	=	null;
ResultSet	resultSet			=	null;
StringTokenizer strToken		=	null;	

String heading					=	"";
String data_value				=	"";
int start						=	0;
int end							=	0;
int record_count				=	0;

try
{
	String sqlString			=	checkForNull(request.getParameter("sql"));
	String headArray			=	checkForNull(request.getParameter("headArray"));
	String selectArray			=	checkForNull(request.getParameter("selectArray"));
	String search_text			=	checkForNull(request.getParameter("search_text"));
	String link_field			=	checkForNull(request.getParameter("link_field"));
	String from					=	checkForNull(request.getParameter("from"));
	String to					=	checkForNull(request.getParameter("to"));
	String searchBy				=	checkForNull(request.getParameter("searchBy"));
	String search_criteria		=	checkForNull(request.getParameter("search_criteria"));
	String headCountValue		=	checkForNull(request.getParameter("headCountValue"));
	String src_value			=	checkForNull(request.getParameter("src_value"));
	String prevNextClick		=	checkForNull(request.getParameter("prevNextClick"), "N");
	String class_value			=	"QRYEVEN";
	String visib				=	"";
	StringBuffer returnBuf		=	new StringBuffer();

	int index= search_text.indexOf("'");
	if(index != -1)
	{
	search_text = search_text.replace("'","''");
	}

	if (from.equals(""))
			start	=	1;
	else	start	=	Integer.parseInt(from);
	
	if (to.equals(""))
			end	=	18;
	else	end	=	Integer.parseInt(to);

	int headCntVal	=	-1;
	if (!headCountValue.equals("")) headCntVal = Integer.parseInt(headCountValue);

	connection					=	ConnectionManager.getConnection(request);
%>
	<body onKeyDown = 'lockKey();'>
	<form name="DocNumberLookupResult" id="DocNumberLookupResult" action="DTDocumentNumberLookupResult.jsp" method="POST">
	<%

		if (!(search_text.trim()).equals(""))
		{
			/*Changed by vinod, to add a search criteria before 'order by' clause. - 7/26/2006 11:07 AM*/
			StringBuffer tempString	=	new StringBuffer();
			if (sqlString.indexOf(" ORDER BY") != -1)
				tempString.append(sqlString.substring(0, sqlString.indexOf(" ORDER BY")));
			else
				tempString.append(sqlString);
			if (sqlString.indexOf("where") != -1)
			{
				if (search_criteria.equals("S"))
				{
					tempString.append (" AND UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('");
					tempString.append(search_text);
					tempString.append("%')");
				}
				else if (search_criteria.equals("E"))
				{
					tempString.append(" AND UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('%");
					tempString.append(search_text);
					tempString.append("')");
				}

				else if (search_criteria.equals("C"))
				{
					tempString.append(" AND UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('%"); tempString.append(search_text);
					tempString.append("%')");
				}
			}
			else
			{
				if (search_criteria.equals("S"))
				{
					tempString.append(" WHERE UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('"); tempString.append(search_text);
					tempString.append("%')");
				}
				else if (search_criteria.equals("E"))
				{
					tempString.append(" WHERE UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('%"); tempString.append(search_text);
					tempString.append("')");
				}
				else if (search_criteria.equals("C"))
				{
					tempString.append(" WHERE UPPER(");
					tempString.append(link_field);
					tempString.append(") LIKE UPPER('%"); tempString.append(search_text);
					tempString.append("%')");
				}
			}
			if (sqlString.indexOf(" ORDER BY") != -1)
			{
				tempString.append( sqlString.substring(sqlString.indexOf(" ORDER BY"),sqlString.length()));
			}
			sqlString = tempString.toString() ;
		}
	
		if (!searchBy.equals(""))
		{
			String tempString	=	"";
			if (sqlString.indexOf(" ORDER BY") != -1)
			{
				tempString	=	sqlString.substring((sqlString.lastIndexOf(" ORDER BY ")+10), sqlString.length());
				sqlString	=	sqlString.substring(0 , sqlString.indexOf(" ORDER BY "));
				if (tempString == null) tempString = "";
			}
			if (tempString.equalsIgnoreCase(searchBy))
				sqlString	=	sqlString + " ORDER BY "+ searchBy + " DESC ";
			else
				sqlString	=	sqlString + " ORDER BY "+ searchBy;
		}

		String subString	=	"";
		if (sqlString.indexOf("FROM") != -1) 
			subString	=	sqlString.substring(sqlString.indexOf("FROM"), sqlString.length());
		else if (sqlString.indexOf("from") != -1) 
			subString	=	sqlString.substring(sqlString.indexOf("from"), sqlString.length());
		subString	=	"SELECT COUNT(*) record_count " + subString;
		preStatement	=	connection.prepareStatement(subString);

		resultSet		=	preStatement.executeQuery();
		if ((resultSet != null) && (resultSet.next()))
			record_count	=	resultSet.getInt("record_count");
		if (record_count==0)
		{
		%>
		<script>
			alert(getMessage("NO_RECORD_FOUND_FOR_CRITERIA","common"));
			parent.lookup_head.document.forms[0].Search.disabled = false;
			parent.lookup_detail.document.location.href="../../eCommon/html/blank.html";
		</script>
		<%
		}
		else
		{
			if ((!(start <= 1)) || (!( (start+18) > record_count )))
			{
			%>
			<table align='right'><tr><td align ='right'>
			<%
			if ( !(start <= 1) )
			{
			%>
				<a href='javascript:submitPrevNext(<%=start-18%>, <%=end-18%>)'><fmt:message key="Common.previous.label" bundle="${common_labels}"/></a>
			<%
			}
					
			if ( !( (start+11) > record_count ) )
			{
			%>
				<a href='javascript:submitPrevNext(<%=(start+18)%>, <%=end+18%>)'><fmt:message key="Common.next.label" bundle="${common_labels}"/></a>
			<%
			}
			%>
			</td></tr></table></p>
			<br><br>				
			<%
			}
		%>
	<table width="100%" cellpadding="0" cellspacing="0" border="1" id='tb1'>
	<tr>
	<%
		strToken				=	new StringTokenizer(headArray, ","); 
		int headCount			=	0;
		while (strToken.hasMoreTokens())
		{
			heading	=	strToken.nextToken();
			if (isNull(heading))
			{
				if (headCntVal==headCount)
				{
					visib		=	"Visibility : Visible";
					if (src_value.equals(""))
						src_value	=	"../../eAE/images/Ascending.gif";
					else if ((src_value.equals("../../eAE/images/Ascending.gif")) && (prevNextClick.equals("X")))
						src_value	=	"../../eAE/images/Descending.gif";
					else if (src_value.equals("../../eAE/images/Descending.gif") && (prevNextClick.equals("X")))
						src_value	=	"../../eAE/images/Ascending.gif";
				}
				else
					visib = "Visibility : Hidden";
		%>
			<td class='columnheader' onClick="orderResult('<%=headCount%>');" style="cursor:pointer"><%=heading%>&nbsp;<img src='<%=src_value%>' align='center' id ="img<%=headCount%>" height="9" style="<%=visib%>"> </img></td>
		<%
			}
			headCount++;
		}
	%>
	</tr>
	<%

		if(resultSet!=null)	resultSet.close();
		if(preStatement!=null) preStatement.close();
		preStatement	=	connection.prepareStatement(sqlString);
		resultSet		=	preStatement.executeQuery();
		int count		=	1;
		int tokenCount	=	0;
		int tdCount		=	1;
		if (resultSet != null)
		{
			if ( start != 1 )
				for( int j=1; j<start; count++,j++ )
					resultSet.next() ;
			while(resultSet.next() && count<=end)
			{
				if(class_value.equals("QRYEVEN"))
					class_value = "QRYODD";
				else
					class_value = "QRYEVEN";
			%>
				<input type="Hidden" name="return_value<%=count%>" id="return_value<%=count%>" value="">	
				<tr>
			<%
				if (returnBuf.length()>0)
					returnBuf.delete(0, returnBuf.length());
				
				strToken				=	new StringTokenizer(selectArray, ",");
				tokenCount				=	strToken.countTokens();
				while (strToken.hasMoreTokens())
				{
					heading	=	strToken.nextToken();
					if (isNull(heading))
					{
						data_value	=	checkForNull(resultSet.getString(heading));
						if (link_field.equals(heading))
						{
						%>
							<td class="<%=class_value%>" nowrap style="cursor:pointer;color:blue;" onClick="closeWindow('<%=count%>');" name='<%=tdCount%>' onMouseOver="changeRowColor(this,<%=tokenCount%>);" ><%=checkForNull(data_value, "&nbsp;")%></td>
						<%
						}
						else
						{
						%>
							<td class="<%=class_value%>" nowrap><%=checkForNull(data_value, "&nbsp;")%></td>
						<%	
						}
					} // End of If.
					if (returnBuf.length()>0)
						returnBuf.append("$$");
					returnBuf.append(data_value);
					%>
						<script>
						document.getElementById("return_value")<%=count%>.value = "<%=returnBuf.toString()%>";
						</script>
					<%
				} // End of While
			%>
				</tr>
			<%
				count++;
				tdCount++;
			}
		}
	%>
	</table>
		<input type="Hidden" name="from" id="from" value="<%=from%>">
		<input type="Hidden" name="to" id="to" value="<%=to%>">
		<input type="Hidden" name="sql" id="sql" value="<%=sqlString%>">
		<input type="Hidden" name="headArray" id="headArray" value="<%=headArray%>">
		<input type="Hidden" name="selectArray" id="selectArray" value="<%=selectArray%>">
		<input type="Hidden" name="link_field" id="link_field" value="<%=link_field%>">
		<input type="Hidden" name="searchBy" id="searchBy" value="">
		<input type="Hidden" name="headCountValue" id="headCountValue" value="<%=headCountValue%>">
		<input type="Hidden" name="src_value" id="src_value" value="<%=src_value%>">
		<input type="Hidden" name="prevNextClick" id="prevNextClick" value="Y">
	</form>
	</body>
<%
			if (record_count==1)
			{
			%>
				<script>closeWindow('1');</script>
			<%		
			}
		}
	if(resultSet!=null)	resultSet.close();
	if(preStatement!=null) preStatement.close();
}
catch(Exception e)
{
	out.println("Exception : " + e.toString());
	e.printStackTrace();
}
finally
{
	ConnectionManager.returnConnection(connection,request);
}
%>
<script>parent.lookup_head.document.getElementById("Search").disabled	= false;	</script>
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

public static boolean isNull(String inputString)
{
	return (((inputString == null) || (inputString.equals("null")) ) ? false : true);
}

%>

