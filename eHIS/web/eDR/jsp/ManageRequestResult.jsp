<!DOCTYPE html>
<%
/**
*	MODULE		: Duplicate Registration Check ...[DR]
*	Developer	: Shyam Prasad.P
*	Created On	: 05 AUG 2005
*	Funtion		: ManageRequestDetail
**/
%>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page contentType="text/html;charset=UTF-8" import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ page import="eDR.*" %>
<html>
<head>

<%
	request.setCharacterEncoding("UTF-8");
   String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
<Script language="JavaScript" src="../../eDR/js/ManageRequest.js" ></Script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../../eCommon/js/common.js'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

</head>

<script>
async function callManagePatient(job_ctrl_no, patient_status)
{	
	var retValue = 	new String();
	var title = getLabel("eDR.ViewRecordDetails.label","DR");
	//var dialogHeight= "25.5" ;
	var dialogHeight= "50vh" ;
	var dialogWidth	= "50vw" ;
	//var dialogWidth	= "50" ;
	var dialogTop = "";
	var center = "1" ;
	var status="no";
	var features	= " dialogHeight:"+dialogHeight+"; scroll=no; dialogWidth:"+dialogWidth+"; center:"+center+"; status:"+status+"; dialogTop :"+dialogTop+"; title:"+title;
	var arguments	= "" ;				
	retValue = await top.window.showModalDialog("../../eDR/jsp/ManageRequestPatientFrameSet.jsp?job_ctrl_no="+job_ctrl_no+"&status="+patient_status,arguments,features);
}
</script>
<body onMouseDown="CodeArrest()" onKeyDown='lockKey()'>
<form>
<%
  Connection con=null;
  Statement stmt=null;
  ResultSet rs=null;
  String from_date="";
  String to_date="";
  String status="";
  //String sql="";
  int i=0;
  int cnt = 0;
  String classValue="";
  String scheduled_date="";
  String current_status="";
  String current_status1="";
  String id="";
  StringBuffer sql=null;
  String sqlstr="";

	try
	{
		   con=	ConnectionManager.getConnection(request);
           
		  sql=new StringBuffer(); 
		  stmt=con.createStatement();
		  from_date =  checkForNull(request.getParameter("start_time"));
		  to_date   =  checkForNull(request.getParameter("start_later_time"));
		  status    =  checkForNull(request.getParameter("Status"),"P");


	    if((from_date.equals("")) && (to_date.equals("")))
		{
		   sql.append("select JOB_CTRL_NO, to_char(REQUEST_DATE,'dd/mm/yyyy hh24:mi') REQUEST_DATE, to_char(SCHEDULED_DATE,'dd/mm/yyyy hh24:mi') SCHEDULED_DATE, to_char(EXEC_START_DATE,'dd/mm/yyyy hh24:mi') EXEC_START_DATE, STATUS,  to_char(EXEC_END_DATE,'dd/mm/yyyy hh24:mi') EXEC_END_DATE, ADDED_BY_ID from DR_JOB_CONTROL where");
		}
       
	    else if(!(from_date.equals("")) && (to_date.equals("")))
		{
		   sql.append("select JOB_CTRL_NO,to_char(REQUEST_DATE,'dd/mm/yyyy hh24:mi') REQUEST_DATE,to_char(SCHEDULED_DATE,'dd/mm/yyyy hh24:mi') SCHEDULED_DATE, to_char(EXEC_START_DATE,'dd/mm/yyyy hh24:mi') EXEC_START_DATE, STATUS, to_char(EXEC_END_DATE,'dd/mm/yyyy hh24:mi') EXEC_END_DATE, ADDED_BY_ID from DR_JOB_CONTROL where scheduled_date >= to_date('"+from_date+"','dd/mm/rrrr hh24:mi') and ");
		}
		else if((from_date.equals("")) && !(to_date.equals("")))
		{
		   sql.append(" select JOB_CTRL_NO,to_char(REQUEST_DATE,'dd/mm/yyyy hh24:mi') REQUEST_DATE,to_char(SCHEDULED_DATE,'dd/mm/yyyy hh24:mi') SCHEDULED_DATE,to_char(EXEC_START_DATE,'dd/mm/yyyy hh24:mi') EXEC_START_DATE, STATUS,  to_char(EXEC_END_DATE,'dd/mm/yyyy hh24:mi') EXEC_END_DATE, ADDED_BY_ID from DR_JOB_CONTROL where scheduled_date <= to_date('"+to_date+"','dd/mm/rrrr hh24:mi') and ");
		}
	    else if(!(from_date.equals("")) && !(to_date.equals("")))
		{
		   sql.append(" select JOB_CTRL_NO,to_char(REQUEST_DATE,'dd/mm/yyyy hh24:mi') REQUEST_DATE,to_char(SCHEDULED_DATE,'dd/mm/yyyy hh24:mi') SCHEDULED_DATE,to_char(EXEC_START_DATE,'dd/mm/yyyy hh24:mi') EXEC_START_DATE,STATUS,  to_char(EXEC_END_DATE,'dd/mm/yyyy hh24:mi') EXEC_END_DATE, ADDED_BY_ID from DR_JOB_CONTROL where scheduled_date between to_date('"+from_date+"','dd/mm/rrrr hh24:mi') and to_date('"+to_date+"','dd/mm/rrrr hh24:mi') and ");
		}
		
		if(status.equals("R"))
		{
			sql.append(" status='R' order by to_date(scheduled_date,'dd/mm/yyyy hh24:mi')");
		}
		else if(status.equals("C"))
		{
			sql.append(" status='C' order by to_date(scheduled_date,'dd/mm/yyyy hh24:mi')");
		}
		else if(status.equals("P"))
		{
			sql.append(" status is null order by to_date(scheduled_date,'dd/mm/yyyy hh24:mi')");
		}
		else if(status.equals("A"))
		{
			sqlstr=sql.toString();
			if(sqlstr.lastIndexOf("and")!=-1)
			sqlstr=sqlstr.substring(0,sqlstr.lastIndexOf("and"));
			sqlstr = sqlstr+" order by to_date(scheduled_date,'dd/mm/yyyy hh24:mi')";
		}

		if(status.equals("A") && from_date.equals("") && to_date.equals(""))
		{
			sqlstr="select  JOB_CTRL_NO, to_char(REQUEST_DATE,'dd/mm/yyyy hh24:mi') REQUEST_DATE, to_char(SCHEDULED_DATE,'dd/mm/yyyy hh24:mi') SCHEDULED_DATE, to_char(EXEC_START_DATE,'dd/mm/yyyy hh24:mi') EXEC_START_DATE, STATUS,  to_char(EXEC_END_DATE,'dd/mm/yyyy hh24:mi') EXEC_END_DATE, ADDED_BY_ID from DR_JOB_CONTROL order by to_date(scheduled_date,'dd/mm/yyyy hh24:mi')";
		}
        if(sqlstr.length()<1)
		sqlstr=sql.toString(); 	
		
		rs=stmt.executeQuery(sqlstr);

	/*if(!rs.next())
	{
		out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
	}
	else
	{
		 
		// rs.last();
		
		rs.beforeFirst();*/
		
		
		while(rs.next())
		{ 
			if (cnt == 0)
			{
			%>
				<table border=1 width='100%' cellspacing=0 cellpadding=0 >
				<tr><td colspan=7>&nbsp;</td></tr>	
				<th class='columnheader'>+</th>
				<th class='columnheader'><fmt:message key="Common.ScheduledDate.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="eDR.ScheduledBy.label" bundle="${dr_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.requesteddate.label" bundle="${common_labels}"/></th>
				<th class='columnheader'><fmt:message key="eDR.ExecutionStartDate.label" bundle="${dr_labels}"/></th>
				<th class='columnheader'><fmt:message key="eDR.ExecutionEndDate.label" bundle="${dr_labels}"/></th>
				<th class='columnheader'><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
			<%
			}
			if ( i % 2 == 0 )
				classValue = "QRYEVEN" ;
			else
				classValue = "QRYODD" ;
				 
			
			id=rs.getString("JOB_CTRL_NO");
			scheduled_date=rs.getString("SCHEDULED_DATE");
			 scheduled_date=DateUtils.convertDate(scheduled_date,"DMYHM","en",localeName);
			current_status=checkForNull(rs.getString("STATUS"));
			if(current_status.equals(""))
				current_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.Pending.label","common_labels");
			else if(current_status.equals("R"))
				current_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"eDR.Running.label","dr_labels");
			else if(current_status.equals("C"))
				current_status1=com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.completed.label","common_labels");
			else if(current_status.equals("E"))
				current_status1="";
			


		%>
		  <tr>
			<td class='<%=classValue%>' align=center><a href="javascript:callManagePatient('<%=id%>','<%=current_status%>')">+</a></td>
		<%

			//out.println("<td  nowrap align=left class='"+classValue+"'><a  href='../jsp/ManageRequestDetail.jsp?id="+id+"&scheduled_date="+scheduled_date+"' target='add_mod'>rs.getString("JOB_CTRL_NO")</a></td>");
           String scheduled_date1=checkForNull(rs.getString("SCHEDULED_DATE"));
		   scheduled_date1=DateUtils.convertDate(scheduled_date1,"DMYHM","en",localeName);
		   String request_date1=checkForNull(rs.getString("REQUEST_DATE"));
		   request_date1=DateUtils.convertDate(request_date1,"DMYHM","en",localeName);
		   String exec_start_date1=checkForNull(rs.getString("EXEC_START_DATE"));
		   exec_start_date1=DateUtils.convertDate(exec_start_date1,"DMYHM","en",localeName);
		   String exec_end_date1=checkForNull(rs.getString("EXEC_END_DATE"));
		   exec_end_date1=DateUtils.convertDate(exec_end_date1,"DMYHM","en",localeName);
			if(current_status.equals(""))
			{	%>
				<td  nowrap align=center class='<%=classValue%>'><a  href='../jsp/ManageRequestDetail.jsp?id=<%=id%>&scheduled_date=<%=scheduled_date%>&scheduled_by=<%=checkForNull(rs.getString("ADDED_BY_ID"))%>' target='add_mod' ><%=scheduled_date1%></a></td>
	<%		}
			else
			{	%>
				<td class='<%=classValue%>' align=center><%=scheduled_date1%></td>
	<%		}	%>
			<td class='<%=classValue%>' align=center ><%=checkForNull(rs.getString("ADDED_BY_ID"))%></td>
			<% if(!request_date1.equals("")){%>
			<td class='<%=classValue%>' align=center ><%=request_date1%></td>
			  <%} else{%>
			<td class='<%=classValue%>' align=center>&nbsp;</td>
			<%}%>
			<% if(!exec_start_date1.equals("")){%>
			<td class='<%=classValue%>' align=center><%=exec_start_date1%></td>
			<%} else{%>
			<td class='<%=classValue%>' align=center>&nbsp;</td>
			<%}%>
			<% if(!exec_end_date1.equals("")){%>
			<td class='<%=classValue%>' align=center><%=exec_end_date1%></td>
			<%} else{%>
			<td class='<%=classValue%>' align=center>&nbsp;</td>
			<%}%>
			<% if(!current_status1.equals("")){%>
			<td class='<%=classValue%>' align=center ><%=current_status1%></td>
		    <%} else{%>
			 <td class='<%=classValue%>' align=center>&nbsp;</td>
			<%}%>
			</tr>

		   <%  i++; 
			   cnt++; 	 
		}

		if(cnt == 0)
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'))</script>");
	
 if( (sql != null) || (sql.length() > 0))
	{
		sql.delete(0,sql.length());
	}
 if(rs   != null) rs.close();
 if(stmt != null) stmt.close();
 }
 catch(Exception e)
 {
	out.println("Exception occured in ManageRequestResult"+e.toString());
 }	
finally
{
	if(rs   != null) rs.close();
	if(stmt != null) stmt.close();
	ConnectionManager.returnConnection(con,request);
}
%>
</form>
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

