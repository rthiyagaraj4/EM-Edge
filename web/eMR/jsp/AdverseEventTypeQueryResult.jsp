<!DOCTYPE html>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<%@ page import ="java.sql.*,java.util.*,java.net.*,java.text.*,webbeans.eCommon.*"  contentType="text/html;charset=UTF-8" %>

<% String sStyle = checkForNull((String)session.getAttribute("PREFERRED_STYLE"), "IeStyle.css"); %>



<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/ValidateControl.js' language='javascript'></script>

 <script language='javascript' src='../js/AdverseEventType.js'></script>

<%
	out.println("<HTML><head><link rel='stylesheet' type='text/css' href='../../eCommon/html/"+sStyle+"'></link></head><BODY  class='CONTENT' onKeyDown = 'lockKey()'  OnMouseDown='CodeArrest()'>");
	request.setCharacterEncoding("UTF-8");
	String whereClause = request.getParameter("whereclause");
	StringBuffer sql = new StringBuffer();
	String from = request.getParameter( "from" ) ;
	String to = request.getParameter( "to" ) ;
		//out.println("suman");


	if ( (whereClause == null || whereClause.equals("")) )
	{
		sql= new StringBuffer();
		String adv_event_code = request.getParameter("ADV_EVENT_TYPE_CODE");
		//out.println(adv_event_code);
		String longdesc = request.getParameter("long_desc");
		String enabled = request.getParameter("nature");
		String adv_event_ind = request.getParameter("ADV_EVENT_TYPE_IND");

		String user_define  = request.getParameter("user_define");

		int andCheck = 0;

		adv_event_code=adv_event_code.toUpperCase();

		

		if ( !(adv_event_code == null || adv_event_code.equals("")) )
				{
				sql.append(" and upper(a.ADV_EVENT_TYPE_CODE)  like  upper('"+adv_event_code+"%') ");
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
			if(! (adv_event_ind ==null || adv_event_ind.equals("")))
			{
				if ( andCheck == 1 )
					{	sql.append( " and ");
						sql.append(" upper(b.ADV_EVENT_TYPE_IND)  like  upper('"+adv_event_ind+"%') ");
					}
					else
					{
						sql = new StringBuffer();
						sql.append(" and upper(b.ADV_EVENT_TYPE_IND)  like  upper('"+adv_event_ind+"%') ");
						andCheck = 1;
					}

			}
				if ( !(user_define == null || user_define.equals("")) )
			{
			   if ( user_define.equals("U") )
					{
				if ( andCheck == 0 )
				{
					sql = new StringBuffer();
					sql.append(" and a.SYS_USER_VAL='U' ");
					andCheck = 1;
				}
				else
					sql.append(" and a.SYS_USER_VAL='U' ");

				}
			   if ( user_define.equals("S") )
				{
				   
				if ( andCheck == 0 ){
					sql = new StringBuffer();
					sql.append("  and  a.SYS_USER_VAL='S'  ");
					andCheck = 1;
					
					
				}
				else{
					
					sql.append(" and a.SYS_USER_VAL='S'  ");
					
				}
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
	  	end = 10 ;
	else
		end = Integer.parseInt( to ) ;
Connection conn =null;
Statement stmt=null;
//ResultSet rset=null;
ResultSet rs=null;
int maxRecord = 0;
//out.println("query------"+sql);
try{
conn=ConnectionManager.getConnection(request);
stmt = conn.createStatement();
String strsql1="select count(*) as total from  mr_adv_event_type a,MR_ADV_EVENT_TYPE_DETAIL b ,MR_ADV_EVENT_TYPE_IND c where a.adv_event_type_code=b.adv_event_type_code and b.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND  "+sql.toString();
rs = stmt.executeQuery(strsql1);
rs.next();
maxRecord = rs.getInt("total");

if(rs!=null)
	rs.close();
if(stmt!=null)
	stmt.close();

	//if(maxRecord == 0)
		//out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA'));history.go(-1);</script>");

String strsql2="SELECT a.adv_event_type_code, a.long_desc, a.short_desc, a.eff_status,       a.SYS_USER_VAL,b.ADV_EVENT_TYPE_IND,c.ADV_EVENT_TYPE_IND_DESC FROM mr_adv_event_type a,MR_ADV_EVENT_TYPE_DETAIL b ,MR_ADV_EVENT_TYPE_IND c where a.adv_event_type_code=b.adv_event_type_code and b.ADV_EVENT_TYPE_IND=c.ADV_EVENT_TYPE_IND "+sql.toString();
//out.println("sql--------------->"+strsql2);
stmt = conn.createStatement();
rs = stmt.executeQuery(strsql2);
//out.println("strsql2--------------"+strsql2);

%>
<P>
<table align='right'>
<tr>
<td>
<%

if ( !(start <= 1) )
	out.println("<td align ='right'><A HREF='../../eMR/jsp/AdverseEventTypeQueryResult.jsp?from="+(start-10)+"&to="+(end-10)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A></td>");

if ( !( (start+10) > maxRecord ) )
	out.println("<td align ='right'><A HREF='../../eMR/jsp/AdverseEventTypeQueryResult.jsp?from="+(start+10)+"&to="+(end+10)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A></td>");
%>
</tr>
</td>
</table>
<br><br>
</P>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
	<% if(maxRecord > 0){ %>
<th><fmt:message key="eMR.AdverseEventTypeCode.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th><fmt:message key="eMR.AdverseEventTypeIndicator.label" bundle="${mr_labels}"/></th>
<th><fmt:message key="Common.UserDefined.label" bundle="${common_labels}"/></th>
<th><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>

<%}
	String new_code="";
	String prev_code="";
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
		
		new_code=rs.getString("ADV_EVENT_TYPE_CODE");
		if(!new_code.equals(prev_code))
	{

			out.println ( "<tr><td class='QRYEVEN'>");
			%><a href="javascript:onclick=callcriteria('<%=new_code%>','modify')"><%out.println ("<font size='2' color='blue'><b>"+new_code+"</b></font></a></td>");
			%><td class='QRYEVEN'><%=rs.getString("long_desc") %></td>
					
				<td class='QRYEVEN'><%=rs.getString("short_desc")%></td>
				<td class='QRYEVEN'>&nbsp;</td>
				<td class='QRYEVEN'>&nbsp;</td>
				<td class='QRYEVEN'>&nbsp;</td></tr><%
	}
	%><tr><td class='QRYODD'>&nbsp;</td>
		<td  class='QRYODD'>&nbsp;</td>
		<td  class='QRYODD'>&nbsp;</td>
		<td  class='QRYODD' nowrap><%=rs.getString("ADV_EVENT_TYPE_IND_DESC")%><%
	out.println("</td><td  class='QRYODD' align=center>");
	if ( rs.getString("SYS_USER_VAL").equals("U") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	out.println("</td><td  class='QRYODD' align=center>");
	//String eff_status		=(rs.getString("eff_status")==null)?"D":rs.getString("eff_status");
	//if ( rs.getString("eff_status").equals("E") )
	String eff_status		=(rs.getString("eff_status")==null)?"D":rs.getString("eff_status");
	if ( eff_status.equals("E") )
		out.println("<img src='../../eCommon/images/enabled.gif'></img>");
	else
		out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
	prev_code=rs.getString("ADV_EVENT_TYPE_CODE");
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

