<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,webbeans.eCommon.* " contentType="text/html;charset=UTF-8"  %>
<%@ page import="eMP.DLAInterfaceUtil"%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<% 
	String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); 
	request.setCharacterEncoding("UTF-8");
	String locale = ((String)session.getAttribute("LOCALE"));
	String patient_id = (String)session.getAttribute("dla_patient_id");
%>

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src='../../eCommon/js/common.js' language='javascript'></script>
<script language='javascript' src='../../eMP/js/dlainterface.js'></script>

<%
// exception not null indicates SQL server connection failed while processing the request & 
// message will be displayed in message frame.
String exception = (String)session.getAttribute("exception");
if(exception != null)
{
%>
	<script>
	var msg = getMessage("SQL_DB_CONN_FAIL","MP");
	parent.message_frame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
	</script>
<%
}
else
{

Connection sqlServerConn = null;
PreparedStatement isExistingPStmt = null;
ResultSet isExistingRSet = null;

String from = null;
String to = null;
String function_id = (String)session.getAttribute("dla_function_id");

boolean isFromOracleDB = true;
boolean invalidDOB = false;

try
{
	out.println("<HTML><head>"+
	"<link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link>"+
	"</head>"+
	"<BODY class='CONTENT' OnMouseDown='CodeArrest()' onKeyDown = 'lockKey()'>");

	String searchQuery = "";
	String serach_mode = request.getParameter("serach_mode");
	String dateFormat = "";	

	isFromOracleDB = Boolean.valueOf(request.getParameter("isFromOracleDB"));

	sqlServerConn = DLAInterfaceUtil.getConnection("DLAP");
	if(sqlServerConn == null)
	{
	%>
		<script>
		var msg = getMessage("SQL_DB_CONN_FAIL","MP");
		parent.message_frame.location.href = '../../eCommon/jsp/MstCodeError.jsp?err_num='+msg;
		</script>
	<%
	}
	else
	{

	from = request.getParameter("from");
	to = request.getParameter("to");

	String today_datetime1 = (String)session.getAttribute("today_datetime");	
	String dla_machine_name1 = (String)session.getAttribute("dla_machine_name");

/*	if(serach_mode != null && serach_mode.equalsIgnoreCase("N"))
	{
	

		searchQuery = DLAInterfaceUtil.getSqlDBQueryByNationalID();

		

		isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);
		isExistingPStmt.setString(2,national_id_name);			
		search_type = "0";
		req_search = national_id_name;

		
	}
	else if(serach_mode != null && serach_mode.equalsIgnoreCase("S"))
	{
	

		boolean flag_fname = false;

		search_type = "1";
		req_search = first_name;
		if(first_name != null && !first_name.equalsIgnoreCase(""))
		{
		//	searchQuery = searchQuery+" fname LIKE '"+first_name+"%'";
			searchQuery = searchQuery+" fname LIKE ?";
			flag_fname = true;
			req_search = req_search+" ";
		}
		if(sur_name != null && !sur_name.equalsIgnoreCase(""))
		{
			if(flag_fname)
			{
				searchQuery = searchQuery+" AND lname LIKE ?";
				isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);
				isExistingPStmt.setString(2,first_name+"%");
				isExistingPStmt.setString(3,sur_name+"%");
			}
			else
			{
				searchQuery = searchQuery+" lname LIKE ?";
				isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);				
				isExistingPStmt.setString(2,sur_name+"%");
			}
			req_search = req_search+sur_name;
		}
		else
		{
			isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);				
			isExistingPStmt.setString(2,first_name+"%");
		}
*/	
	searchQuery = DLAInterfaceUtil.getSqlDBSearchByName();

	isExistingPStmt = sqlServerConn.prepareStatement(searchQuery,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
	isExistingPStmt.setString(1,dla_machine_name1+"/"+today_datetime1);

		
//	}

	isExistingRSet = isExistingPStmt.executeQuery();
	
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if(from == null) start = 1 ;
	else start = Integer.parseInt(from) ;

	if(to == null)	end = 10 ;
	else end = Integer.parseInt(to) ;

//Connection conn = (Connection) session.getValue( "connection" ) ;



//int maxRecord = 0;
	

/*	isExistingRSet.last();
	int rowCount = isExistingRSet.getRow();
	isExistingRSet.beforeFirst();



	boolean newRequest = Boolean.valueOf(request.getParameter("newRequest"));

	// If only one patient exists with the entered search criteria, that patient details will be derectly displayed.
	if(rowCount == 1 && newRequest)
	{		
		isExistingRSet.next();
		String code = checkForNull(isExistingRSet.getString(1),"&nbsp;");
		response.sendRedirect("../../eMP/jsp/DlaInterfaceMain.jsp?display=details&national_id="+code+"&isFromOracleDB="+isFromOracleDB);
	}
	else
	{		
*/	if ( start != 1 )
	{
		for(int j=1; j<start; i++,j++)
		{
			isExistingRSet.next() ;
		}
	}
	String classValue = "" ;
	int cnt=0;	
	while (i <= end && isExistingRSet.next())
	{
		
		if(cnt == 0)
		{
%>		
		<P>
		<DIV id="details" STYLE="display:block">
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<tr>

<%		
		if ( !(start <= 1) )
			out.println("<td align ='right' id='prev' class='CAGROUP'><A HREF='../../eMP/jsp/DLAQueryResults.jsp?from="+(start-10)+"&isFromOracleDB="+isFromOracleDB+"&to="+(end-10)+"&serach_mode="+serach_mode+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");			
%>
		<td align ='right' class='CAGROUP' width="10%">
<%		 
		//if ( !( (start+14) > maxRecord ) )
			out.println("<A HREF='../../eMP/jsp/DLAQueryResults.jsp?from="+(start+10)+"&isFromOracleDB="+isFromOracleDB+"&to="+(end+10)+"&serach_mode="+serach_mode+"'"+" text-decoration='none' style='visibility:hidden' id='next'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");			
%>
		</td>
		</tr>
		</table>
		<BR><BR>
		</P>

		<center>
		<table border="1" width="100%" cellspacing='0' cellpadding='0'>
		<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="Common.TITLE.label" bundle="${common_labels}"/></th>
		<th><%= DLAInterfaceUtil.getLabelPrompt(locale,"FirstName") %></th>
		<th><%= DLAInterfaceUtil.getMiddleNamePrompt(locale) %></th>
		<th><%= DLAInterfaceUtil.getLabelPrompt(locale,"FamilyName") %></th>		
		<th><fmt:message key="Common.DOB.label" bundle="${common_labels}"/></th>
		<th><fmt:message key="eMP.fathername.label" bundle="${mp_labels}"/></th>
		<th><fmt:message key="eMP.mothername.label" bundle="${mp_labels}"/></th>
<%
		}		
		if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

		out.println("<tr><td align='left' class='" + classValue + "'>");
		String code = checkForNull(isExistingRSet.getString(1),"&nbsp;");		
	//	out.println("<a href='../../eMP/jsp/DlaInterfaceMain.jsp?display=details&national_id="+code+"&isFromOracleDB="+isFromOracleDB+"'>");
		out.println("<a href='../../eMP/jsp/DlaIDupChk.jsp?national_id="+code+"&patient_id="+patient_id+"'>");
		out.println(code+"</a></td><td class='" + classValue + "'>");
		out.println( checkForNull(isExistingRSet.getString(13),"&nbsp;") );
		out.println("</td><td class='" + classValue + "'>");
		out.println( checkForNull(isExistingRSet.getString(2),"&nbsp;") );
		out.println("</td><td class='" + classValue + "'>");
		out.println(checkForNull(isExistingRSet.getString(21),"&nbsp;"));
		out.println("</td><td class='" + classValue + "'>");
		out.println(checkForNull(isExistingRSet.getString(3),"&nbsp;"));
		out.println("</td><td class='" + classValue + "'>");
		
		String tempDate = checkForNull(isExistingRSet.getString(4),"&nbsp;");
		dateFormat = "yyyyMMdd";
		//java.util.Date utilDate = (java.util.Date)DLAInterfaceUtil.convertToDate(tempDate,dateFormat);
		//java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());

		if(tempDate.length() == 8)
		{
			try
			{
				Integer.parseInt(tempDate.substring(0,4));
			}
			catch(NumberFormatException exp)
			{
				invalidDOB = true;
			}
		}
		else
		{
			invalidDOB = true;
		}

		if(locale != null && locale.equalsIgnoreCase("th") && !invalidDOB)
		{
		//	tempDate = DLAInterfaceUtil.convertStringDateFormats(tempDate,dateFormat,"dd/MM/yyyy");
			tempDate = tempDate.substring(6,8) + "/" + tempDate.substring(4,6) + "/" + tempDate.substring(0,4);
		}
		else if(!invalidDOB)
		{
		//	String tempDate1 = DLAInterfaceUtil.convert_to_greg_date(sqlDate,"th");						
		//	tempDate = DLAInterfaceUtil.convertStringDateFormats(tempDate1,"yyyy-MM-dd","dd/MM/yyyy");

			tempDate = tempDate.substring(6,8) + "/" + tempDate.substring(4,6) + "/" 
						+ (Integer.parseInt(tempDate.substring(0,4)) - 543);
		}

		out.println(tempDate);
		out.println("</td><td class='" + classValue + "'>");		
		out.println(checkForNull(isExistingRSet.getString(7),"&nbsp;"));
		out.println("&nbsp;</td><td class='" + classValue + "'>");		
		out.println(checkForNull(isExistingRSet.getString(8),"&nbsp;"));
		out.println("&nbsp;</td>");			
		i++;
		cnt++;
	} 


//	if (cnt==0 && !isFromOracleDB && newRequest)
	if (cnt == 0)
	{		
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));</script>");
	}	
	boolean flag = false;
	if ( cnt < 2 || (!isExistingRSet.next()) )
	{
%>
	<script>
	if(document.getElementById("next") != null)
	document.getElementById("next").style.visibility='hidden';
	</script>
<% 	
	flag = true;
	} 
	else 
	{
%>
	<script >	
	if(document.getElementById("next") != null)
	document.getElementById("next").style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>




<%	}
	if (cnt == 0)
	{
%>
	</tr>
	</table>
	</DIV>
	</center>

<%
	}
if(invalidDOB)
{
%>
	<script>
		var msg = getMessage("INVALID_VALUE","common");		
		msg = msg.replace('#',getLabel("Common.birthDate.label","Common"));
		alert(msg);
	</script>
<%
}
//	}


%>

<!-- </center> -->

<FORM ID="dla_search_form" ACTION="../../servlet/eMP.DLATransactionServlet" METHOD="post">
<INPUT TYPE="hidden" name="mode" id="mode" VALUE="DLASearch">
<INPUT TYPE="hidden" name="flag" id="flag" ID="flag" VALUE="<%=request.getParameter("mode")%>">
<INPUT TYPE="hidden" name="search_by" id="search_by" ID="search_by" VALUE="<%=request.getParameter("serach_mode")%>">
<INPUT TYPE="hidden" name="isFromOracleDB" id="isFromOracleDB" ID="isFromOracleDB" VALUE="<%=request.getParameter("isFromOracleDB")%>">
<!-- <INPUT TYPE="hidden" name="nat_id" id="nat_id" ID="nat_id" VALUE="<%=session.getAttribute("dla_national_id")%>"> -->
<INPUT TYPE="hidden" name="new_request" id="new_request" ID="new_request" VALUE="<%=request.getParameter("newRequest")%>">
<INPUT TYPE="hidden" name="code" id="code" ID="code" VALUE="<%=request.getParameter("code")%>">
<input type="hidden" name="function_id" id="function_id" id="function_id" value="<%=function_id%>">
<input type="hidden" name="patient_id" id="patient_id" id="patient_id" value="<%=patient_id%>">
</FORM>

</BODY>
</HTML>
<%
	}
	}
catch(Exception exp)
{
	exp.printStackTrace(System.err);
}
finally
{
	try
	{
		if(isExistingRSet != null) isExistingRSet.close();
		if(isExistingPStmt != null) isExistingPStmt.close();
		if(sqlServerConn != null) DLAInterfaceUtil.closeConnection(sqlServerConn);
	}
	catch(Exception exp)
	{
		exp.printStackTrace(System.err);
	}
}}%>

<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	?	""	:	inputString;
	}
	
	public static String checkForNull(String inputString, String defaultValue)
	{
		String temp = ((inputString == null) || (inputString.equals("null")) || (inputString.equals(""))) ? defaultValue : inputString;
		return(temp);
	}
%>

