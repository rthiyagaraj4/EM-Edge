<!DOCTYPE html>
<%@ page import ="java.sql.*,oracle.jdbc.driver.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%> 
<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>

<HTML>
<head>
 <%
	String sStyle =

(session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<script language='javascript' src='../../eCommon/js/messages.js'></script>
	<script src='../../eCommon/js/common.js' language='javascript'></script>
<script src='../../eCommon/js/showModalDialog.js' language='JavaScript'></script>


</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String amb_nature_code  = request.getParameter("amb_nature_code");
    String long_desc = request.getParameter("long_desc");
    String short_desc = request.getParameter("short_desc");
	
	if(long_desc == null)
	{
		long_desc = "";
	}
	else
	{
		long_desc = long_desc.toUpperCase();
	}
	
	if(short_desc == null)
	{
		short_desc = "";
	}
	else
	{
		short_desc = short_desc.toUpperCase();
	}
    
	//String event_class_desc="";
    String eff_status= request.getParameter("eff_status");
	int count = 0;
	if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(amb_nature_code == null || amb_nature_code.equals("")) )
        {
			sql.append(" where upper(AMB_NATURE_CODE ) like upper('"+amb_nature_code +"%')");
			count =  1;
        }

     //  if(amb_nature_code == null || amb_nature_code.equals(""))
		if ( !(long_desc == null || long_desc.equals("")) )
        {
			if(count == 1)
			sql.append(" and upper(LONG_DESC) like '"+long_desc+"%'");
			else
			{
			sql.append(" where upper(LONG_DESC) like '"+long_desc+"%'");
			count=1;
			}
        }

		if ( !(short_desc == null || short_desc.equals("")) )
        {
			if(count == 1)
			sql.append(" and upper(SHORT_DESC) like '"+short_desc+"%'");
			else
			{
			sql.append(" where upper(SHORT_DESC) like '"+short_desc+"%'");
			count=1;
			}
        }
  
	if ( !(eff_status == null || eff_status.equals("")) )
    {
         if( eff_status.equals("E") )
         {
			 if(count == 1)
			   sql.append(" and eff_status='E'");
			 else
               sql.append(" where eff_status='E'");
         }
         if ( eff_status.equals("D") )
	     {
            if(count == 1)
			   sql.append(" and eff_status='D'");
			 else
               sql.append(" where eff_status='D'");
			   
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

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt1=null;
PreparedStatement stmt=null;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;


String strsql="select count(*) as total from AE_AMB_NATURE "+sql.toString();

String strsql1="select AMB_NATURE_CODE,LONG_DESC,SHORT_DESC,EFF_STATUS from  AE_AMB_NATURE "+sql.toString();

try
{
stmt = conn.prepareStatement(strsql);
rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");


if(maxRecord == 0)
{

	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));parent.f_query_add_mod.location.href ='../../eAE/jsp/AMBNatureCodeQueryCriteria.jsp' ;</script>");
	
}


%>
<P>
<table align='right'>
<tr>
<td>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eAE/jsp/AMBNatureCodeQueryResult.jsp?from="+(start-14)+"&to="+(end-14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+14) > maxRecord ) )
    out.println("<A HREF='../../eAE/jsp/AMBNatureCodeQueryResult.jsp?from="+(start+14)+"&to="+(end+14)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<br><br>
</p>

<table border="1" width="100%" cellspacing='0' cellpadding='0'>
<th width='15%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></th>
<th width='25%'><fmt:message key="Common.longdescription.label" bundle="${common_labels}"/></th>
<th width='25%'><fmt:message key="Common.shortdescription.label" bundle="${common_labels}"/></th>
<th width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></th>



<%
//rset.beforeFirst();

stmt1=conn.prepareStatement(strsql1);
rset = stmt1.executeQuery();


if ( start != 1 )
     for( int j=1; j<start; i++,j++ )
      rset.next() ;
String classValue= " ";
 while ( rset.next() && i<=end  )
{
    if ( i % 2 == 0 )
                    classValue = "QRYEVEN" ;
                else
            classValue = "QRYODD" ;

	out.println("<tr><td align=='left' class='" + classValue + "'>");

		String amb_nature_code1	=(rset.getString("AMB_NATURE_CODE")==null)?"":rset.getString("AMB_NATURE_CODE");
		String long_desc1	 =(rset.getString("LONG_DESC")==null)?"":rset.getString("LONG_DESC");
		String short_desc1	 =(rset.getString("SHORT_DESC")==null)?"":rset.getString("SHORT_DESC");		
		String effective_status1		=(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
  
	out.println("<a href='../../eAE/jsp/AMBNatureCodeAddModify.jsp?mode=update&amb_nature_code="+ URLEncoder.encode(amb_nature_code1)+"' target='f_query_add_mod' >");
    out.println(amb_nature_code1 + "</a></td><td class='" + classValue + "'>");

    out.println(long_desc1);
	out.println("</td><td class='" + classValue + "'>");
	out.println(short_desc1);
    out.println("</td><td class='" + classValue + "' align='center'>");
	
	  if ( effective_status1.equalsIgnoreCase("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
out.println("</td>");
	i++;
} %>

</td></tr>
</table>
</center>

<br><center>
<%

if(rs!=null) rs.close();
if(stmt!=null) stmt.close();

if(rset!=null) rset.close();
if(stmt1!=null) stmt1.close();
}
catch(Exception e)
{
	System.out.println("Exception from AMBNatureCodeQueryResult JSP : "+e.getMessage());
	e.printStackTrace(System.err);	
}
finally
{
	if (conn != null) 
	ConnectionManager.returnConnection(conn,request);
}	

%>

</center>
</BODY>
</HTML>

