<!DOCTYPE html>
<%@ page import ="java.sql.*,webbeans.eCommon.*,java.net.*,eCommon.XSSRequestWrapper" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
 <%
    request.setCharacterEncoding("UTF-8");
request= new XSSRequestWrapper(request); //MMS-ME-SCF-0097
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<html>
	<head>
		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
		<!-- ****  Modified by kishor kumar n on 06/12/2008 for crf0387 applied new css grid. **** -->
		
		
		<script src="../../eCommon/js/ValidateControl.js" language="javascript"></script>
		<script src="../../eCommon/js/common.js" language="javascript"></script>
		<script language='javascript' src='../js/EMail.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<body onKeyDown="lockKey()">
		<form>
			<table border=0 cellspacing=0 cellpadding='3' width='100%' align=center>
				<tr>	
<%
	String from = request.getParameter("from");
	String to =  request.getParameter("to");
	int i = 1;
	int start = 0;
	int end = 0;
	int maxRecord = 0;
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	StringBuffer sql = new StringBuffer();
	String searchBase = request.getParameter("searchBase") == null ? "" : request.getParameter("searchBase");
	String searchText = request.getParameter("searchText") ==null ? "" : request.getParameter("searchText");
	String condition =  request.getParameter("condition") == null ? "" : request.getParameter("condition");
	String sqlStrCnt = "";
	String sqlStrMain = "";

	try
	{
		con = ConnectionManager.getConnection(request);
		if(searchBase.equals("S")) //if search value is equal to 'Starts with'
		{
			if(!searchText.equals("%"))
				searchText = searchText  + "%";
		}
		else if(searchBase.equals("E")) //if search value is equal to 'Ends with'
		{
			if(!searchText.equals("%"))
				searchText = "%" + searchText;
		}
		else //if search value is equal to 'Contains'
		{
			if(!searchText.equals("%"))
				searchText = "%" + searchText + "%" ;
		}
		if(condition.equals("D"))
		{
			sql.append(" where UPPER(mailer_name) like upper(?) order by mailer_name ");
		}
		else
		{
			sql.append( " where UPPER(mailer_id) like upper(?) order by mailer_id ");
		}

		sqlStrCnt = "select count(*) as total from SM_REGD_MAILING_LST  "+sql.toString();
		sqlStrMain = "select mailer_id,mailer_name,email_id,EFF_STATUS from  SM_REGD_MAILING_LST "+sql.toString();

		ps = con.prepareStatement(sqlStrCnt);
		ps.setString(1,searchText);
		rs = ps.executeQuery();
		while(rs.next())
			maxRecord = rs.getInt("total");

		if(rs != null) rs.close();
		if(ps != null) ps.close();

		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}

	    if (from == null )
	        start = 1 ;
		else
			start = Integer.parseInt(from);

	    if (to == null )
	        end = 5 ;
		else
			end = Integer.parseInt(to);
%>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
	<tr>
		<td class='white' width='87%'></td> 
		<td  align='right' width='13%'>
		<%
		if ( !(start <= 1) )
			out.println("<A HREF='../../eCA/jsp/EMailRegDetails.jsp?from="+(start-5)+"&to="+(end-5)+"&searchBase="+searchBase+"&searchText="+URLEncoder.encode(searchText)+"&condition="+URLEncoder.encode(condition)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

		if ( !( (start+5) > maxRecord ) )
			out.println("&nbsp;<A HREF='../../eCA/jsp/EMailRegDetails.jsp?from="+(start+5)+"&to="+(end+5)+"&searchBase="+searchBase+"&searchText="+URLEncoder.encode(searchText)+"&condition="+URLEncoder.encode(condition)+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
		%>
		</td>
	</tr>
</table>
<table width="100%" class='grid'>
	<tr>
		<td class='columnheadercenter' width='15%'><fmt:message key="eCA.RegisteredRecipientID.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' width='25%'><fmt:message key="eCA.RegisteredRecipientName.label" bundle="${ca_labels}"/></td>
		<td class='columnheadercenter' width='25%'><fmt:message key="eCA.EmailId.label" bundle="${ca_labels}"/></td>
	</tr>
<%
		String mailerId = "";
		String mailername = "";
		String emailID = "";

		ps = con.prepareStatement(sqlStrMain);
		ps.setString(1,searchText);
		rs = ps.executeQuery();

		if (start != 1)
			 for( int j=1; j<start; i++,j++)
				  rs.next();
		String classValue= "gridData";
		while (rs.next() && i<=end)
		{

		 	out.println("<tr><td class='" + classValue + "'>");
			mailerId = rs.getString("mailer_id") == null ? "" : rs.getString("mailer_id");
			mailername = rs.getString("mailer_name") == null ? "" : rs.getString("mailer_name");
			emailID = rs.getString("email_id") == null ? "" : rs.getString("email_id");

			out.println("");
			out.println(mailerId + "</td><td class='" + classValue + "'>");

			out.println(mailername);
			out.println("</td><td class='" + classValue + "' ><a href='javascript:returnEMailId(escape(\""+emailID+"\"),escape(\""+mailerId+"\"))' >");
			out.println(emailID);
			out.println("</a></td>");
			i++;
		}//end of while

		if(rs != null) rs.close();
		if(ps != null) ps.close();
	}//end of try
	catch(Exception e)
	{
		
		//out.println("Exception in try of EMailRegDetails.jsp-"+e.toString());//COMMON-ICN-0181
		e.printStackTrace();
	}
	finally
	{
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(con != null) ConnectionManager.returnConnection(con,request);
	}
%>
			</table>
		</form>
	</BODY>
</HTML>

