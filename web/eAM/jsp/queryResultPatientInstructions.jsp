<!DOCTYPE html>
<%--
	FileName		: queryResultPatientInstructions.jsp
	Version	    : 3	
	Created On	: 03-08-2009
	Created By	: S.Sathish 
--%>

<%
String sStyle	=
(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp" %>
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<Script Language="JavaScript" src="../../eCommon/js/common.js"></Script>
<HTML>
<head>
		<link rel='stylesheet' type='text/css' href='../../eCommon/html/<%=sStyle%>'></link>
</head>
<BODY OnMouseDown='CodeArrest()' class='CONTENT' onKeyDown = 'lockKey()' >

<%
	request.setCharacterEncoding("UTF-8");

	String whereClause = request.getParameter("whereclause");	
	StringBuffer sbQuery = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{	
	String instructionid = request.getParameter("instruction_id");
	String instructiondesc = request.getParameter("instruction_desc");
	String enabled = request.getParameter("eff_status");

	int andCheck = 0;
	
	if ( !(instructionid == null || instructionid.equals("")) )
		{
		 sbQuery.setLength(0);
		 sbQuery.append("where upper(instruction_id) like upper('"+instructionid+"%')");		
		 andCheck = 1;
		}

	if ( !(instructiondesc == null || instructiondesc.equals("")) )
	{
		if ( andCheck == 1 )
		{			
			sbQuery.append("and upper(instruction_desc)  like  upper('"+instructiondesc+"%') ");			
		}
		else
		{
			sbQuery.setLength(0);
			sbQuery.append("where upper(instruction_desc)  like upper('"+instructiondesc+"%') ");			
			andCheck = 1;
		}
	}
	
	if ( !(enabled == null || enabled.equals("")) )
	{
	     if( enabled.equals("E") )
	     {
	        if ( andCheck == 0 )
			{
				sbQuery.setLength(0);
				sbQuery.append("where eff_status='E'");
			}		
			else
			{
				sbQuery.append(" and eff_status='E'");
			}
	   	 
	     }
	     if ( enabled.equals("D") )
	     {
	     	if ( andCheck == 0 )
			{
				sbQuery.setLength(0);
				sbQuery.append("where  eff_status='D'");
			}
	     	else
			{
				sbQuery.append(" and eff_status='D'");
			}
	     	    
	     }
	     
	}

	//appending order by clause
	String ord[] = request.getParameterValues("orderbycolumns");

	if ( !(ord == null || ord .equals("")) )
	{
		sbQuery.append(" order by ");		
		for ( int i=0;i < ord.length;i++ )
	 	{
			if ( i == ord.length - 1 )
				sbQuery.append(ord[i]);			
			else
				sbQuery.append(ord[i]+",");			
		}
	 }
	
	} //end of where clause IF
	else
	{
		sbQuery.setLength(0);
		sbQuery.append(whereClause);
	}
		

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

Connection conn = null;
conn = ConnectionManager.getConnection(request);
Statement stmt = null;
int maxRecord = 0;
ResultSet rs = null;

try{

stmt = conn.createStatement();

rs = stmt.executeQuery("select * from am_pat_instructions "+sbQuery.toString());

	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ )
	  rs.next() ;

	while ( i<=end && rs.next() )
{
		if(maxRecord==0)
	{
%>

<P>
<table align='right'>
<tr >
<%
if ( !(start <= 1) )
	out.println("<td align ='right' id='prev'><A HREF='../../eAM/jsp/queryResultPatientInstructions.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

//if ( !( (start+14) > maxRecord ) )
	out.println("<td align ='right' id='next' style='visibility:hidden'><A HREF='../../eAM/jsp/queryResultPatientInstructions.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sbQuery.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</table>
<br></br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.Nature.label" bundle="${common_labels}"/></th>

<% }
 	

	  String classValue = "" ;

	if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
			classValue = "QRYODD" ;

	out.println("<tr><td class='" + classValue + "'align=='left'>");	
	String code = rs.getString("instruction_id");
    String desc = rs.getString("instruction_desc"); 
	out.println("<a href='../../eAM/jsp/addModifyPatientInstructions.jsp?instruction_id="+ code + "' target='f_query_add_mod' >");
    out.println(code+"</a></td><td class='" + classValue + "'>");
	out.println(desc);
	out.println("</td><td class='" + classValue + "'>");
	if ( rs.getString("eff_status").equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;
	maxRecord++;
	}//end of while 
		sbQuery.setLength(0);

if(maxRecord == 0)
{%>
	<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>
<%}

if ( maxRecord < 14 || (!rs.next()) ) {
%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='hidden';
	</script>
<% 
		} else {%>
	<script >
	if (document.getElementById('next'))
		document.getElementById('next').style.visibility='visible';
	</script>
<Script src=\"../../eCommon/js/showModalDialog.js\" language=\"JavaScript\"></Script>



<%}
		if (rs != null)   rs.close();
	     if (stmt != null) stmt.close();

}	catch(Exception e) { 
//out.println(e.toString());
e.printStackTrace();
}

	finally {
		 
	   ConnectionManager.returnConnection(conn,request);
	}

%>

</td></tr>
</table>

</BODY>
</HTML>

