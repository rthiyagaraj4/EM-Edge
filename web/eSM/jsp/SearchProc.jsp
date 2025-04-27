<!DOCTYPE html>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 

<HTML>
<head>
	<%
          String sStyle	=
         (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
   %>

	<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<title><fmt:message key="eSM.BackGroundProcesses.label" bundle="${sm_labels}"/></title>
</head>
<BODY  class='CONTENT' onKeyDown = 'lockKey()'>
<script language='javascript'>

function closewin(procid)
{
	
	//window.close();
	//window.returnValue = procid;

	
	
	let dialogBody = parent.parent.document.getElementById('dialog-body');

    dialogBody.contentWindow.returnValue = procid;

    const dialogTag = parent.parent.document.getElementById("dialog_tag");    

    dialogTag.close();   
}
</script>

<%
String procid=request.getParameter("procid");
	Connection con=null;
	String proc_id="";                
	String long_desc="";             
	String proc_srt_cmd="";                
	
	int count = 0;
	
	try{
	request.setCharacterEncoding("UTF-8");
	con = ConnectionManager.getConnection(request);
	Statement stmt1=null;
	Statement stmt=null;
	ResultSet rs1=null;
	ResultSet rs=null;
	

	int i=1;
	
  try
	{
		try {
		String strsql="select count(*) count from sm_proc_id where controllable_yn='Y' and proc_id like upper('"+procid+"%')";
		stmt1=con.createStatement();
		rs1 = stmt1.executeQuery(strsql);
		while(rs1.next())
			{
			count = rs1.getInt("count");
			}		
		if(rs1!=null) rs1.close();
		if(stmt1!=null) stmt1.close();
		}
		catch(Exception e){}
	if (count==0)
		{
		%>
		<script>
			alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));
		    window.close();
		</script>
		<%
		}
		else
		{
	
		String strsql2="select * from sm_proc_id where controllable_yn='Y' and proc_id like upper('"+procid+"%')";
		stmt=con.createStatement();
		rs = stmt.executeQuery(strsql2);

	%>
	<div style="overflow-y:auto; height:600px;">
	<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<tr>
		<th align=left><fmt:message key="Common.ProcessID.label" bundle="${common_labels}"/></th>
		<th align=left><fmt:message key="Common.ProcessName.label" bundle="${common_labels}"/></th>
	</tr>
	<%
					String classValue = "" ;
					while ( rs.next() && i<=count )
					{
							if ( i % 2 == 0 )
								classValue = "QRYEVEN" ;
							else
								classValue = "QRYODD" ;
		   
							proc_id=rs.getString("proc_id");
							if( proc_id==null) proc_id="";

							long_desc=rs.getString("long_desc");
							if( long_desc==null) long_desc="";

							proc_srt_cmd=rs.getString("proc_srt_cmd");
							if(proc_srt_cmd==null) proc_srt_cmd="";
					
							out.println("<tr>");
							out.println("<td  nowrap class='" + classValue + "' onclick=\"closewin('"+proc_id+"')\"><a  href=\"javascript:closewin('"+proc_id+"') \" target='proc1' >");
							
								
							out.println(proc_id+"</td>");
							out.println("<td nowrap class='" + classValue + "'>");
							out.println(long_desc+"</td></tr>");
							%>
							<input type=hidden name='proc_id' id='proc_id' value='<%=proc_id+"/"+long_desc+"/"+proc_srt_cmd%>'>
							<%							
							i++;
						}
						if(rs!=null) rs.close();
						if(stmt!=null) stmt.close();
						out.println("</table></div>");
		}
	  }
	  catch(Exception e)
	  {
				out.print(e.toString());
	  }
	  finally
			{
					if(stmt!=null) 	stmt.close();
					if(rs!=null) 	rs.close();
					
			}
	}catch(Exception e){out.println(e);}
	finally { 
		ConnectionManager.returnConnection(con,request);
     }	
%>
</center>
</BODY>
</HTML>

