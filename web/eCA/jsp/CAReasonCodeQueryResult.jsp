<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>


<HTML>
<head>
<%
request.setCharacterEncoding("UTF-8");
response.addHeader("X-XSS-Protection", "1; mode=block"); //MMS-ME-SCF-0079
response.addHeader("X-Content-Type-Options", "nosniff"); //MMS-ME-SCF-0085
String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
%>
 <!-- <modifeid by Arvind @06-12-2008> -->

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	<style>
	td,th,tr
	{border-bottom: 1px solid #d5e2e5;
	}
	</style>
</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String reason_code  = request.getParameter("reason_code");
    String reason_short_desc = request.getParameter("reason_short_desc");
    String reason_description = request.getParameter("reason_desc");

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	if(reason_short_desc == null)
	{
		reason_short_desc = "";
	}
	else
	{
		reason_short_desc = reason_short_desc.toUpperCase();
	}

	if(reason_description == null)
	{
		reason_description = "";
	}
	else
	{
		reason_description = reason_description.toUpperCase();
	}
    
    String eff_status= request.getParameter("eff_status");
	int count = 0;
	if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(reason_code == null || reason_code.equals("")) )
        {
			sql.append(" where upper(REASON_CODE ) like upper('"+reason_code +"%')");
			count =  1;
        }

		if ( !(reason_short_desc == null || reason_short_desc.equals("")) )
        {
			if(count == 1)
			sql.append(" and upper(REASON_DESC) like '"+reason_short_desc+"%'");
			else
			{
			sql.append(" where upper(REASON_DESC) like '"+reason_short_desc+"%'");
			count=1;
			}
        }
		if ( !(reason_description == null || reason_description.equals("")) )
		{
			 if(count == 1)
			sql.append(" and upper(REASON_TEXT) like '"+reason_description+"%'");
			else
			{
			sql.append(" where upper(REASON_TEXT) like '"+reason_description+"%'");
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

    } 
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
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt1=null;
PreparedStatement stmt=null;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;


String strsql="select count(*) as total from CA_REASON_CODE "+sql.toString();

String strsql1="select REASON_CODE,REASON_DESC,REASON_TEXT,EFF_STATUS from  CA_REASON_CODE "+sql.toString();

try
{
stmt = conn.prepareStatement(strsql);
rs = stmt.executeQuery();
rs.next();
maxRecord = rs.getInt("total");


if(maxRecord == 0)
{
	out.println("<script>alert(getMessage('NO_RECORD_FOUND_FOR_CRITERIA','Common'));history.go(-1);</script>");
}


%>
<table cellpadding='3' cellspacing='0' border='0' width='100%' align='center'>
<tr>
<td class='white' width='82%'></td> 
<td  align='right' width='18%'>
<%
if ( !(start <= 1) )
	
    out.println("<A class='gridLink' HREF='../../eCA/jsp/CAReasonCodeQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/CAReasonCodeQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<table class='GRID' border="0" width="100%" cellspacing='0' cellpadding='3' collapse style="border: 1px solid #d5e2e5;">
<td class='COLUMNHEADERCENTER' width='15%'><fmt:message key="Common.code.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></td>
<td class='COLUMNHEADERCENTER' width='25%'><fmt:message key="eOR.ReasonText.label"bundle="${or_labels}"/></td>

<td class='COLUMNHEADERCENTER' width='10%'><fmt:message key="Common.enabled.label" bundle="${common_labels}"/></td>
<%

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

	out.println("<tr><td class='gridData'>");

		String reason_code1	=(rset.getString("REASON_CODE")==null)?"":rset.getString("REASON_CODE");
		String reason_desc1	 =(rset.getString("REASON_DESC")==null)?"":rset.getString("REASON_DESC");
		String reason_description1	 =(rset.getString("REASON_TEXT")==null)?"":rset.getString("REASON_TEXT");
		
		String effective_status1		=(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
  
	out.println("<a class='gridLink'  href='../../eCA/jsp/CAReasonCodeAddModifyReason.jsp?mode=update&reason_code="+ URLEncoder.encode(reason_code1)+"' target='f_query_add_mod' >");
    out.println(reason_code1 + "</a></td><td class='gridData'>");

    out.println(reason_desc1);
    out.println("</td><td class='gridData' >");
    out.println(reason_description1);
    out.println("</td><td class='gridData' >");
	
	  if ( effective_status1.equalsIgnoreCase("E") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else if ( effective_status1.equalsIgnoreCase("D") )
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");
out.println("</td>");
	i++;
} %>
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
	out.println("Exception from CAReasonCodeQueryResult JSP : "+e.getMessage());
	e.printStackTrace();	
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

