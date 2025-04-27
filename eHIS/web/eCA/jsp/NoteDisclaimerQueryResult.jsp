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
	String note_disclaimer_id  = request.getParameter("note_disclaimer_id");
    String note_disclaimer_desc = request.getParameter("note_disclaimer_desc");
    String applicable_to_rep_yn = request.getParameter("applicable_to_rep_yn");

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	//out.println("note_disclaimer_id"+note_disclaimer_id);
	//out.println("note_disclaimer_desc"+note_disclaimer_desc);
	if(note_disclaimer_desc == null)
	{
		note_disclaimer_desc = "";
	}
	else
	{
		note_disclaimer_desc = note_disclaimer_desc.toUpperCase();
	}

	if(applicable_to_rep_yn == null)
	{
		applicable_to_rep_yn = "";
	}
	else
	{
		applicable_to_rep_yn = applicable_to_rep_yn.toUpperCase();
	}
    
	//String event_class_desc="";
    String eff_status= request.getParameter("eff_status");
	//out.println("eff_statusssssssss"+eff_status);
	int count = 0;
	if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(note_disclaimer_id == null || note_disclaimer_id.equals("")) )
        {
			sql.append(" where upper(DISCLIMER_CODE ) like upper('"+note_disclaimer_id +"%')");
			count =  1;
        }

     //  if(note_disclaimer_id == null || note_disclaimer_id.equals(""))
		if ( !(note_disclaimer_desc == null || note_disclaimer_desc.equals("")) )
        {
			if(count == 1)
			sql.append(" and upper(DISCLIMER_DESC) like '"+note_disclaimer_desc+"%'");
			else
			{
			sql.append(" where upper(DISCLIMER_DESC) like '"+note_disclaimer_desc+"%'");
			count=1;
			}
        }
		if ( !(applicable_to_rep_yn == null || applicable_to_rep_yn.equals("")) )
		{
			 if(count == 1)
			sql.append(" and upper(applicable_to_rep_yn) like '"+applicable_to_rep_yn+"%'");
			else
			{
			sql.append(" where upper(applicable_to_rep_yn) like '"+applicable_to_rep_yn+"%'");
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
        end = pageCnt ;
    else
        end = Integer.parseInt( to ) ;

Connection conn  =  ConnectionManager.getConnection(request);

PreparedStatement stmt1=null;
PreparedStatement stmt=null;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;


String strsql="select count(*) as total from CA_DISCLIMER_TEXT "+sql.toString();

String strsql1="select DISCLIMER_CODE,DISCLIMER_DESC,applicable_to_rep_yn,EFF_STATUS from  CA_DISCLIMER_TEXT "+sql.toString();
//out.println("strsql1"+strsql1);
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
	
    out.println("<A class='gridLink' HREF='../../eCA/jsp/NoteDisclaimerQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/NoteDisclaimerQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<table class='grid' border="0" width="100%" cellspacing='0' cellpadding='3' style="border: 1px solid black;">
<th align="left" class='columnheadercenter' width='15%'><fmt:message key="Common.identification.label" bundle="${common_labels}"/></th>
<th align="left" class='columnheadercenter' width='25%'><fmt:message key="Common.description.label" bundle="${common_labels}"/></th>
<th align="left" class='columnheadercenter' width='25%'><fmt:message key="eCA.ApplicableToReport.label" bundle="${ca_labels}"/></th>
<th align="left" class='columnheadercenter' width='10%'><fmt:message key="Common.EffStatus.label" bundle="${common_labels}"/></th>



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

	out.println("<tr><td class='gridData'>");

		String note_disclaimer_id1	=(rset.getString("DISCLIMER_CODE")==null)?"":rset.getString("DISCLIMER_CODE");
		String note_disclaimer_desc1	 =(rset.getString("DISCLIMER_DESC")==null)?"":rset.getString("DISCLIMER_DESC");
		String applicable_to_rep_yn1	 =(rset.getString("applicable_to_rep_yn")==null)?"":rset.getString("applicable_to_rep_yn");
		
		String effective_status1		=(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
  
	out.println("<a class='gridLink'  href='../../eCA/jsp/NoteDisclaimerAddModify.jsp?mode=update&note_disclaimer_id="+ URLEncoder.encode(note_disclaimer_id1)+"' target='f_query_add_mod' >");
    out.println(note_disclaimer_id1 + "</a></td><td class='gridData'>");

    out.println(note_disclaimer_desc1);
    out.println("</td><td class='gridData' >");
	if ( applicable_to_rep_yn1.equalsIgnoreCase("Y") )
        out.println("<img src='../../eCommon/images/enabled.gif'></img>");
    else
        out.println("<img src='../../eCommon/images/RRnwd.gif'></img>");

    out.println("</td><td class='gridData' >");
	
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
	//out.println("Exception from NoteGroupQueryResult JSP : "+e.getMessage());//COMMON-ICN-0181	
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

