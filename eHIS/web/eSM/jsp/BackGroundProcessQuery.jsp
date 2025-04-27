<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*,com.ehis.util.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<script language='javascript' src='../../eCommon/js/DateUtils.js'></script>
<HTML>
<head>
	<%
          String sStyle	=
          (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
    %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>

</head>
<BODY  onKeyDown = 'lockKey()' class='CONTENT' OnMouseDown='CodeArrest()'>
<%
    request.setCharacterEncoding("UTF-8");
    String locale					= (String)session.getAttribute("LOCALE");
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
	Connection con=null;
	String proc_id="";                
	String proc_name="";             
	String submitted_by="";           
	String last_execution_date="";         
	String next_execution_date="";                
	String status="";                
	try{

	
	con = ConnectionManager.getConnection(request);
	Statement stmt=null;
	ResultSet rs=null;
	int start = 0 ;
	int end = 0 ;
	int i=1;

	if ( from == null )
		start = 1 ;
	else
		start = Integer.parseInt( from ) ;

	if ( to == null )
	  	end = 14 ;
	else
		end = Integer.parseInt( to ) ;


try
	{
		String strsql2="select proc_id, proc_name, submitted_by, to_char(last_execution_date,'dd/mm/yyyy hh24:mi') last_execution_date1, to_char(next_execution_date,'dd/mm/yyyy hh24:mi') next_execution_date1,status from sm_jobs_vw  ";
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2);
%>


<b><fmt:message key="eSM.JobQueue.label" bundle="${sm_labels}"/></b>
<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<tr>
	<th align=left><fmt:message key="Common.Process.label" bundle="${common_labels}"/></th>
	<th align=left><fmt:message key="Common.LastExecution.label" bundle="${common_labels}"/></th>
	<th align=left><fmt:message key="Common.NextExecution.label" bundle="${common_labels}"/> </th>
	<th align=left><fmt:message key="Common.status.label" bundle="${common_labels}"/></th>
</tr>
<%
				if ( start != 1 )
					 for( int j=1; j<start; i++,j++ )
						rs.next() ;

				String classValue = "" ;

				while ( rs.next() && i<=end )
				{
						if ( i % 2 == 0 )
							classValue = "QRYEVEN" ;
						else
							classValue = "QRYODD" ;
							       
						proc_id=rs.getString("proc_id");
						
						if( proc_id==null) proc_id="";

						proc_name=rs.getString("proc_name");
						if( proc_name==null) proc_name="&nbsp;";

						submitted_by=rs.getString("submitted_by");
						if( submitted_by==null) submitted_by="&nbsp;";

						last_execution_date=rs.getString("last_execution_date1");
						if( last_execution_date==null) last_execution_date="&nbsp;";
						if(!last_execution_date.equals("&nbsp;"))
						  {
								last_execution_date = DateUtils.convertDate(last_execution_date,"DMYHM","en",locale);
						  }
						next_execution_date=rs.getString("next_execution_date1");
						if( next_execution_date==null) next_execution_date="&nbsp;";
						if(!next_execution_date.equals("&nbsp;"))
						  {
                                next_execution_date = DateUtils.convertDate(next_execution_date,"DMYHM","en",locale);
						  }

						status=rs.getString("status");
						if( status==null) status="&nbsp;";
					%>
						<tr>
						<td  nowrap class='<%=classValue%>'>
						<% if(!status.equals("Running")){%>
						<a  href='../../eSM/jsp/BackGroundProcessAddModify.jsp?proc_id=<%=proc_id%>' target='add_mod' >
						<%=proc_name%>
						<%}else {%>
						<%=proc_name%><%}%></td>
						<td nowrap class='<%=classValue%>'><%=last_execution_date%>
						</td>
						
						<td  class='<%=classValue%>'>
						<%=next_execution_date%>
						</td>
						<td  class='<%=classValue%>'>
						<%=status%>
						</td>
						</tr>
					<%					
						i++;
					}
				if(rs!=null)rs.close();
				if(stmt!=null) 	stmt.close();
			%>
			</table>
<%

			if(stmt!=null) 	stmt.close();
			if(rs!=null) 		rs.close();
	}
			catch(Exception e)
			{
					out.print(e.toString());
			}
	}catch(Exception e){out.println(e);}
		finally { 
			ConnectionManager.returnConnection(con,request);
	}	

%>
</center>
</BODY>
</HTML>

