<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/RegEmailRecipient.js'></script>

<HTML>
<head>
 <% 
    request.setCharacterEncoding("UTF-8");
	String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);
 %>
	<!-- ****  Modified by Ambiga--CSS @02-02-09 **** -->
	
	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	
</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String mailer_id  = request.getParameter("mailer_id");
    String mailer_name = request.getParameter("mailer_name");
    String email_id = request.getParameter("email_id");
	if(mailer_name == null)
	{
		mailer_name = "";
	}
	else
	{
		mailer_name = mailer_name.toUpperCase();
	}
    
	//String event_class_desc="";
    String eff_status= request.getParameter("eff_status");
	//out.println("eff_statusssssssss"+eff_status);
	int count = 0;
	if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(mailer_id == null || mailer_id.equals("")) )
        {
			sql.append(" where upper(mailer_id ) like upper('"+mailer_id +"%')");
			count =  1;
        }

		if ( !(mailer_name == null || mailer_name.equals("")) )
        {
			if(count == 1){
			sql.append(" and upper(mailer_name) like '"+mailer_name+"%'");
			}else
			{
			sql.append(" where upper(mailer_name) like '"+mailer_name+"%'");
			count=1;
			}
        }
		if ( !(email_id == null || email_id.equals("")) )
        {
			if(count == 1){
			sql.append(" and upper(email_id) like '"+email_id+"%'");
			}else
			{
			sql.append(" where upper(email_id) like '"+email_id+"%'");
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

String strsql="select count(*) as total from SM_REGD_MAILING_LST  "+sql.toString();

String strsql1="select mailer_id,mailer_name,email_id,EFF_STATUS from  SM_REGD_MAILING_LST "+sql.toString();
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
<td class='white' width='88%'></td> 
<td  align='right' width='12%'>
<%
if ( !(start <= 1) )
    out.println("<A HREF='../../eCA/jsp/RegEmailRecipientQueryResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A HREF='../../eCA/jsp/RegEmailRecipientQueryResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none' class='gridLink'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<table width="100%" class="grid">
<td class='columnheadercenter' width='15%'><fmt:message key="eCA.RegisteredRecipientID.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' width='25%'><fmt:message key="eCA.RegisteredRecipientName.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' width='25%'><fmt:message key="eCA.EmailId.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' width='10%'><fmt:message key="Common.EffStatus.label" bundle="${common_labels}"/></td>
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
    /*if ( i % 2 == 0 )
         classValue = "QRYEVEN" ;
     else
         classValue = "QRYODD" ;*/
	classValue = "gridData" ;

	out.println("<tr><td class='" + classValue + "'>");

		String mailer_id1	=(rset.getString("mailer_id")==null)?"":rset.getString("mailer_id");
		String mailer_name1	 =(rset.getString("mailer_name")==null)?"":rset.getString("mailer_name");
		String email_id1	 =(rset.getString("email_id")==null)?"":rset.getString("email_id");
		
		String effective_status1		=(rset.getString("EFF_STATUS")==null)?"":rset.getString("EFF_STATUS");
  
	out.println("<a href='../../eCA/jsp/RegEmailRecipientAddModify.jsp?mode=update&mailer_id="+ URLEncoder.encode(mailer_id1)+"' target='f_query_add_mod' class='gridLink' >");
    out.println(mailer_id1 + "</a></td><td class='" + classValue + "'>");

    out.println(mailer_name1);
    out.println("</td><td class='" + classValue + "' >");
	 out.println(email_id1);
    out.println("</td><td class='" + classValue + "' >");

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
	//out.println("Exception from RegEmailRecipientQueryResult.jsp: "+e.getMessage());//COMMON-ICN-0181
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

