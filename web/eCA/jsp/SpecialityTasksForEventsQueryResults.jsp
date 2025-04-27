<!DOCTYPE html>

<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>
<html>
	<head>
<%
	request.setCharacterEncoding("UTF-8");
	String sStyle = (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>

		<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css' />
		<script language="JavaScript" src ="../../eCA/js/SpecialtyEvent.js"></script>
		<Script language ="JavaScript" src ='../../eCommon/js/common.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/CommonLookup.js'></Script>
		<Script language ="JavaScript" src ='../../eCommon/js/ValidateControl.js'></Script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>

	</head>
	<%@page import="java.sql.*,java.io.*, webbeans.eCommon.ConnectionManager"%>
	<body OnMouseDown="CodeArrest()" onKeyDown="lockKey()">
	<%
	  
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
//	PreparedStatement ps1 = null;
//	ResultSet rs1 = null;
	String whereClause = "";	 
	String module = "";
	String event_id="";
//	String sql1="";
	String orderSeqNo = "";
	String from = request.getParameter( "from" ) ;
//	String mode = "modify";
    String to = request.getParameter( "to" ) ;
	String splty_task_desc = "";
//	String splty_event_desc="";
	String classValue = "";
	int rowCount = 0;
	int i =0 ;
	int j = 0;
	StringBuffer sql =new StringBuffer();
	int start = 0;
	int end = 0;
	//String locationCode="";
	StringBuffer sqlQuery =new StringBuffer();
	StringBuffer sqlCount =new StringBuffer();
	int maxRecord =0;
//	int count = 0;
	
	try
	{	
				
			module= request.getParameter("module")==null  ? "" : request.getParameter("module");	
				
			event_id= request.getParameter("event_id")==null  ? "" : request.getParameter("event_id");	

			orderSeqNo= request.getParameter("orderSeqNo")==null  ? "" : request.getParameter("orderSeqNo");	

			splty_task_desc= request.getParameter("splty_task_desc")==null  ? "" : request.getParameter("splty_task_desc");	
			
		con = ConnectionManager.getConnection(request);
		whereClause = request.getParameter("whereClause")==null  ? "" : request.getParameter("whereClause");	
		if(whereClause == null || whereClause.equals(""))
		{
			sql.append(" "+"where  a.SPLTY_EVENT_CODE=c.SPLTY_EVENT_CODE  and   b.SPLTY_TASK_CODE=c.SPLTY_TASK_CODE  and  c.MODULE_ID=d.MODULE_ID");

			if ( !(module == null || module.equals("")) )
				{
					if(module.equals("A")){ }
					else {
							sql.append(" and upper(d.MODULE_ID) like upper('"+module+"%')");
						 }
				}
			
			if ( !(event_id == null || event_id.equals("")) )
				{
					sql.append(" and upper(a.SPLTY_EVENT_CODE) like upper('"+event_id +"%')");
				}
			if ( !(orderSeqNo == null || orderSeqNo.equals("")) ){
					sql.append(" and upper(c.ORDER_SEQ_NO) like upper('"+orderSeqNo+"%')");
				}

			if ( !(splty_task_desc == null || splty_task_desc.equals("")) ){
					sql.append(" and  upper(c.SPLTY_TASK_CODE) like upper('"+splty_task_desc+"%')");
				}

			
			
			
			String ord[] = request.getParameterValues("orderbycolumns");
			if ( !(ord == null || ord .equals("")) )
			{
				sql.append(" order by ");
				for (i=0;i < ord.length;i++ )
				{
				if ( i == ord.length - 1 )
					sql.append(ord[i]);
				else
					sql.append(ord[i]+",");
				}
			}

		}
		else
		{
			sql.append(whereClause);
		}
		if ( from == null )
			start = 1 ;
		else
			start = Integer.parseInt( from ) ;
		if ( to == null )
			end = 14 ;
		else
			end = Integer.parseInt( to ) ;

		sqlCount.append("select count(*) total from  CA_SPLTY_EVENT  a, ca_splty_tasks b, CA_SPLTY_TASKS_FOR_EVENTS c,SM_module d  ");
		sqlCount.append(sql.toString());

		ps = con.prepareStatement(sqlCount.toString());
		rs = ps.executeQuery();
		while(rs.next())
		{
			maxRecord = rs.getInt("total");
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
		if(maxRecord == 0)
		{
			out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
		}
		sqlQuery.append("SELECT a.SPLTY_EVENT_DESC SPLTY_EVENT_DESC,  b.SPLTY_TASK_DESC SPLTY_TASK_DESC, c.ORDER_SEQ_NO  ORDER_SEQ_NO,d.MODULE_NAME  MODULE_NAME  from  CA_SPLTY_EVENT  a, ca_splty_tasks b, CA_SPLTY_TASKS_FOR_EVENTS c ,SM_module d");
		sqlQuery.append(sql.toString());

		ps = con.prepareStatement(sqlQuery.toString());
		rs = ps.executeQuery();
%>
<br>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='88%'></td>
<td align=right>
<%
	if ( !(start <= 1) )
		out.println("<A HREF='../../eCA/jsp/SpecialityTasksForEventsQueryResults.jsp?from="+(start-14)+"&to="+(end-14)+"&whereClause="+java.net.URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");
	if ( !( (start+14) > maxRecord ) )
		out.println("<A HREF='../../eCA/jsp/SpecialityTasksForEventsQueryResults.jsp?from="+(start+14)+"&to="+(end+14)+"&whereClause="+java.net.URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
	</td>
</tr>
</table>
<table border="1" width="100%" cellspacing='0' cellpadding='3' align='center'>
	<tr>
		 <td class='columnheadercenter'  >
			<fmt:message key="Common.Module.label" bundle="${common_labels}"/>
		</td>
		<td class='columnheadercenter'  >
			<fmt:message key="eCA.SpecialityEvent.label" bundle="${ca_labels}"/>
		</td>
		<td class='columnheadercenter'   >
			<fmt:message key="eCA.OrderSequenceNumber.label" bundle="${ca_labels}"/>	  
		</td>
		<td class='columnheadercenter'  >
			<fmt:message key="eCA.SpecialtyTaskDescription.label" bundle="${ca_labels}"/>
		</td>
	</tr>
			
	<tr>
<%
	 for(j=1,i=1; j<start; i++,j++ )
      rs.next() ;
      while ( rs.next() && i<= end  ) 
		{
			classValue =((rowCount & 1) == 0) ? "QRYEVEN" : "QRYODD";
			
	%>
		
		
	 <td class='<%=classValue%>'><%=rs.getString("MODULE_NAME")%></td>
	 <td class='<%=classValue%>'><%=rs.getString("SPLTY_EVENT_DESC")%></td>
	 <td class='<%=classValue%>'><%=rs.getString("ORDER_SEQ_NO")%></td>
	 <td class='<%=classValue%>'><%=rs.getString("SPLTY_TASK_DESC")%></td>



 
</tr>
<%		
		rowCount ++;
		i++;
		}
		if(rs != null) rs.close();
		if(ps != null) ps.close();
	}
	catch(Exception ee)
	{
		//out.println("Exception in SpecialityTasksForEventsQueryResults.jsp "+ee.toString());//COMMON-ICN-0181
		ee.printStackTrace();
	}
	finally
	{
		try{
				
				if(con != null) ConnectionManager.returnConnection(con);
		}
		catch(Exception e){}
	}

%>
	  
	</body>
</html>


