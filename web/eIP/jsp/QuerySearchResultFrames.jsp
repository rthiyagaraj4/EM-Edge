<!DOCTYPE html>
<%@ page contentType="text/html;charset=UTF-8" import= "webbeans.eCommon.*,java.util.*,java.sql.*,java.text.*,java.net.*,eCommon.XSSRequestWrapper" %>
<% request.setCharacterEncoding("UTF-8");
//MMS-ME-SCF-0096 vulnerability Issue
	request= new XSSRequestWrapper(request);
	response.addHeader("X-XSS-Protection", "1; mode=block");
	response.addHeader("X-Content-Type-Options", "nosniff");
	//MMS-ME-SCF-0096 vulnerability Issue
	  %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>
<html>
<head>
<link rel='stylesheet' type ='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

<%
	Connection con = null;
	Statement stmt = null;
	ResultSet rs =null;
	try
	{
		con = ConnectionManager.getConnection(request);
		String facilityId = (String) session.getValue( "facility_id" ) ;
		String step = request.getParameter("step");
		if(step == null) step = "";
		String locale				= (String)session.getAttribute("LOCALE");
%>
</head>
<body onMouseDown='CodeArrest()' onKeyDown='lockKey()'>
<%	if(step.equals(""))
	{
		String sql_legend = " select color_code_scheme, ip_get_desc.ip_transfer_priority('"+facilityId+"',priority_code,'"+locale+"',2)short_desc from ip_transfer_priority where facility_id='"+facilityId+"' and eff_status='E' order by 2 ";
		stmt = con.createStatement();
		rs = stmt.executeQuery(sql_legend);
		%>
		<%!String color_scheme_legend ="";
		String priority_short_desc="";%>
		<%if(rs!=null )
		{
			out.println("<tr><table border='1' width='100%' align='bottom'>");
			while(rs.next())
			{
				
				color_scheme_legend =rs.getString("color_code_scheme");
				priority_short_desc = rs.getString("SHORT_DESC");
				%>
				<td nowrap class='<%=color_scheme_legend%>' STYLE='background-color:<%=color_scheme_legend%> ;width:20vw'></td>
				<td  class='oalabel' ><%=priority_short_desc%>
		<%	} 
		}	
		out.println("</td></tr></table>");
	}
	else if(step.equals("amendleave"))
	{	%>
		<table border='1' width='100%' align='bottom'>
			<tr>
				<td nowrap class='#9DCECE'  STYLE='background-color:#9DCECE ;width:15vw'>&nbsp;</td>
				<td nowrap class='oalabel'  ><fmt:message key="Common.Absence.label" bundle="${common_labels}"/></td>
			</tr>
		</table>
<%	}
	else if(step.equals("bedbook"))
	{	%>
		<table border='1' width='100%' align='bottom'>
			<tr>
				<td  nowrap class='#FECBFA' STYLE='background-color:#FECBFA ;width:75vw' >&nbsp;</td>
				<td  nowrap class='oalabel' ><fmt:message key="eIP.RequestPlaced.label" bundle="${ip_labels}"/></td>
			</tr>
		</table>
<%	}else if(step.equals("assignbed"))
	{	%>
		<table border='1' width='100%' align='bottom'>
			<tr>
				<td  nowrap class='brown' STYLE='background-color:brown;width:75vw'>&nbsp;</td>
				<td  nowrap class='oalabel' ><fmt:message key="eIP.GrcprdforAsgnBed.label" bundle="${ip_labels}"/>&nbsp;<fmt:message key="Common.Expired.label" bundle="${common_labels}"/></td>
			</tr>
		</table>
<%	}
	else
	{	%>
		<table border='1' width='100%' align='bottom'>
			<tr>
				<td  nowrap class='#FCC9B4'  STYLE='background-color:#FCC9B4 ;width:75vw'>&nbsp;</td>
				<td  nowrap class='oalabel'  ><fmt:message key="Common.noshow.label" bundle="${common_labels}"/></td>
				<td  nowrap class='#9DCECE'  STYLE='background-color:#9DCECE ;width:75vw'>&nbsp;</td>
				<td  nowrap class='oalabel'  > <fmt:message key="Common.Abscond.label" bundle="${common_labels}"/> </td>
				<td  nowrap class='#FECBFA'  STYLE='background-color:#FECBFA ;width:75vw'>&nbsp;</td>
				<td  nowrap class='oalabel'  > <fmt:message key="eIP.LeaveExpiry.label" bundle="${ip_labels}"/></td>
			</tr>
		</table>
<%	}	%>

<%		if(stmt != null)   stmt.close();
		if(rs != null)   rs.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	finally
	{
		ConnectionManager.returnConnection(con,request);
	}
%>
</html>

<%!
	public static String checkForNull(String inputString)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? "" : inputString);
	}
	public static String checkForNull(String inputString, String defaultValue)
	{
		return(((inputString==null) || (inputString.equals("null"))) ? defaultValue : inputString);
	}
%>

