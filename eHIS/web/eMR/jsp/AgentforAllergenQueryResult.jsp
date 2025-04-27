<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*" %>
<%@ page import ="java.sql.*,java.util.*,webbeans.eCommon.ConnectionManager"  contentType="text/html;charset=UTF-8" %>
<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>

 <Script Language="JavaScript" src="../../eCommon/js/common.js"></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>
<script language='javascript' src='../js/AgentforAllergen.js'></script>


<%
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;

	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql= new StringBuffer();
		String Cause_Agent_Code = request.getParameter("CAUSATIVE_CODE");
		String longdesc = request.getParameter("long_desc");
		String enabled = request.getParameter("nature");


		int andCheck = 0;

		Cause_Agent_Code=Cause_Agent_Code.toUpperCase();

		

		if ( !(Cause_Agent_Code == null || Cause_Agent_Code.equals("")) )
				{
				sql.append(" and upper(a.ALLERGEN_CODE)  like  upper('"+Cause_Agent_Code+"%') ");
				andCheck = 1;
				}

			if ( !(longdesc == null || longdesc.equals("")) )
				{
					if ( andCheck == 1 )
					{	sql.append( " and ");
						sql.append(" upper(a.long_desc)  like  upper('"+longdesc+"%') ");
					}
					else
					{
						sql = new StringBuffer();
						sql.append(" and upper(a.long_desc)  like  upper('"+longdesc+"%') ");
						andCheck = 1;
					}
				}

			
			if ( !(enabled == null || enabled.equals("")) )
			{
			   if ( enabled.equals("E") )
					{
				if ( andCheck == 0 )
				{
					sql = new StringBuffer();
					sql.append(" and a.eff_status='E' ");
					andCheck = 1;
				}
				else
					sql.append(" and a.eff_status='E' ");

				}
			   if ( enabled.equals("D") )
				{
				   
				if ( andCheck == 0 ){
					sql = new StringBuffer();
					sql.append("  and  a.eff_status='D' ");
					andCheck = 1;
					
					
				}
				else{
					
					sql.append(" and a.eff_status='D' ");
					
				}
			}
		}
		
		//appending order by clause
		String ord[] = request.getParameterValues("orderbycolumns");

		if ( !(ord == null || ord .equals("")) )
		{
			sql.append(" order by ");

			for ( int i=0;i < ord.length;i++ )
			{
			if ( i == ord.length - 1 )
				sql.append(ord[i]);
			else
				sql.append(ord[i]+",");
			}
		}
	} //end of where clause IF
	else 
	{
		sql = new StringBuffer();
		sql.append(whereClause);
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
Connection conn =null;
Statement stmt=null;
ResultSet rs=null;
int maxRecord = 0;
//out.println("query------"+sql);
try{
conn=ConnectionManager.getConnection(request);
stmt = conn.createStatement();
String strsql1="select count(*) as total from MR_ALLERGEN a, mr_adv_event_type b,MR_ADV_EVENT_TYPE_IND C WHERE a.adv_event_type_code = b.adv_event_type_code  and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND "+sql.toString();
rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");

if(rs!=null)
	rs.close();
if(stmt!=null)
	stmt.close();

	//if(maxRecord == 0)
		//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));history.go(-1);</script>");

String strsql2="SELECT a.ALLERGEN_CODE, a.long_desc, a.short_desc, a.eff_status, a.adv_event_type_code, b.long_desc adv_event_desc ,c.ADV_EVENT_TYPE_IND_DESC FROM MR_ALLERGEN a, mr_adv_event_type b,MR_ADV_EVENT_TYPE_IND C WHERE a.adv_event_type_code = b.adv_event_type_code  and a.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND "+sql.toString();
stmt = conn.createStatement();
rs = stmt.executeQuery(strsql2);


%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
	out.println("<td><A HREF='../../eMR/jsp/AgentforAllergenQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

if ( !( (start+14) > maxRecord ) )
	out.println("<td><A HREF='../../eMR/jsp/AgentforAllergenQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</td>
</table>
<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<% if(maxRecord > 0){ %>
<th><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eMR.AdverseEventTypeDesc.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="eMR.AdverseEventTypeIndicator.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%}
 	if ( start != 1 )
	 for( int j=1; j<start; i++,j++ ){
	  rs.next() ;

	  }
	  String classValue="";
while ( rs.next() && i<=end )
{
if ( i % 2 == 0 )
			classValue = "QRYEVEN" ;
		else
		classValue = "QRYODD" ;
		

%><tr><td  class='<%= classValue%>'><%
	String code = rs.getString("ALLERGEN_CODE");
	out.println("<a href='../../eMR/jsp/AgentforAllergenCriteria.jsp?CAUSATIVE_CODE="+code+"&mode=modify'>");
	out.println(code+"</a></td><td  class='" + classValue + "'>");
	out.println( rs.getString("long_desc") );
	%></td><td  class='<%=classValue %>'><%
	out.println( rs.getString("short_desc") );
	%></td><td  class='<%=classValue%>'><%
	out.println( rs.getString("adv_event_desc") );
	%></td><td  class='<%=classValue%>'><%
	out.println( rs.getString("ADV_EVENT_TYPE_IND_DESC") );
	%></td><td  class='<%=classValue%>' align=center><%
	String eff_status		=(rs.getString("eff_status")==null)?"D":rs.getString("eff_status");
	//if ( rs.getString("eff_status").equals("E") )
	if ( eff_status.equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	i++;

  }//endwhile
%>

</td></tr>
</table>
<br><center>
<%

if(rs!=null)
	rs.close();
if(stmt!=null)
	stmt.close();

%>

</center>
</BODY>
</HTML>
<%
	if(maxRecord == 0)
				{
					out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
				}
}catch(Exception e){
		out.println("Exception "+e.toString());
}
finally{
		
		if(rs!=null) rs.close();
		if(stmt!=null) 	stmt.close();
		ConnectionManager.returnConnection(conn,request);
	}
	
%>
<%!	
	private String checkForNull(String inputString)
	{
		return (inputString==null)	? "" : inputString;
	}

	private String checkForNull(String inputString, String defaultValue)
	{
		return (inputString==null)	? defaultValue : inputString;
	}
%>

