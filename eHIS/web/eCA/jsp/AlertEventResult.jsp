<!DOCTYPE html>
<%@ page import ="java.sql.*,java.net.*,java.text.*,webbeans.eCommon.ConnectionManager" contentType="text/html;charset=UTF-8" %>
<%@ include file="../../eCommon/jsp/CommonInclude.jsp"%>


<Script Language="JavaScript" src="../../eCommon/js/ValidateControl.js"></Script>
<script src="../../eCommon/js/common.js" language="javascript"></script>
<script language='javascript' src='../js/AlertEvent.js'></script> 

<HTML>
<head>
 <% 
    request.setCharacterEncoding("UTF-8");
	String sStyle =  (session.getAttribute("PREFERRED_STYLE")!=null)||(session.getAttribute("PREFERRED_STYLE")!="")?(String)session.getAttribute("PREFERRED_STYLE"):"IeStyle.css";
 %> 

	<link rel='StyleSheet' href='../../eCommon/html/<%=sStyle%>' type='text/css'></link>
	
</head>

<BODY class='CONTENT'  OnMouseDown='CodeArrest()' onKeyDown="lockKey()">
 <%
	String whereClause = request.getParameter("whereclause");
	if(whereClause==null) whereClause="";
	String from = request.getParameter("from") ;
    String to = request.getParameter("to") ;
	StringBuffer sql = new StringBuffer();
	String event_id  = request.getParameter("event_id");

    String event_desc = request.getParameter("event_desc");
    String txtCategoryCode = request.getParameter("txtCategoryCode");
    String ActionEvent = request.getParameter("ActionEvent");
    String DocumentName = request.getParameter("DocumentName");
    String ActionBy = request.getParameter("ActionBy");
    String TriggeringTime = request.getParameter("TriggeringTime");


    String sumDesc = "";
    String strsql1 = "";
	String action_event="";

	String  MstQryPageCnt = (((session.getAttribute("MstQryPageCnt") != null) && (session.getAttribute("MstQryPageCnt") != "")))?((String)session.getAttribute("MstQryPageCnt")) : "14";
    int pageCnt = Integer.parseInt(MstQryPageCnt);

	if(event_desc == null)
	{
		event_desc = "";
	}
	else
	{
		event_desc = event_desc.toUpperCase();
	}

	if(txtCategoryCode == null)
	{
		txtCategoryCode = "";
	}
	else
	{
		txtCategoryCode = txtCategoryCode.toUpperCase();
	}
    
	int count = 0;
	if ( (whereClause == null || whereClause.equals("")) )
    {
		if ( !(event_id == null || event_id.equals("")) )
        {
			sql.append(" where upper(ALERT_EVENT_CODE ) like upper('"+event_id+"%')"); 
			count =  1;
        }

		if ( !(event_desc == null || event_desc.equals("")) )
        {
			if(count == 1)
			sql.append(" and upper(ALERT_EVENT_DESC) like '"+event_desc+"%'");
			else
			{
			sql.append(" where upper(ALERT_EVENT_DESC) like '"+event_desc+"%'");
			count=1;
			} 
        }
		if ( !(txtCategoryCode == null || txtCategoryCode.equals("")) )
		{
			 if(count == 1)
			sql.append(" and upper(ALERT_CATEG_CODE) like '"+txtCategoryCode+"%'");
			else
			{
			sql.append(" where upper(ALERT_CATEG_CODE) like '"+txtCategoryCode+"%'");
			count=1;
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
PreparedStatement stmt2=null;
int maxRecord = 0;
ResultSet rset = null;
ResultSet rs = null;
ResultSet rset1 = null;





try
{
String strsql="select count(*) as total from CA_ALERT_EVENT "+sql.toString();
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
	
    out.println("<A class='gridLink' HREF='../../eCA/jsp/AlertEventResult.jsp?from="+(start-pageCnt)+"&to="+(end-pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.previous.label","common_labels")+"</A>");

if ( !( (start+pageCnt) > maxRecord ) )
    out.println("&nbsp;<A class='gridLink' HREF='../../eCA/jsp/AlertEventResult.jsp?from="+(start+pageCnt)+"&to="+(end+pageCnt)+"&whereclause="+URLEncoder.encode(sql.toString())+"'"+" text-decoration='none'>"+com.ehis.util.BundleMessage.getBundleMessage(pageContext,"Common.next.label","common_labels")+"</A>");
%>
</td>
</tr>
</table>
<table class='grid' border="1" width="100%" cellspacing='0' cellpadding='3'>
<td class='columnheadercenter' ><fmt:message key="eCA.AlertEventCode.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' ><fmt:message key="eCA.AlertEventDescription.label" bundle="${ca_labels}"/></td>
<td class='columnheadercenter' ><fmt:message key="eCA.AlertCategoryCode.label" bundle="${ca_labels}"/></td>

<%
//rset.beforeFirst();
strsql1="select ALERT_EVENT_CODE,ALERT_EVENT_DESC,ALERT_CATEG_CODE from  CA_ALERT_EVENT "+sql.toString();
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

		String event_id1	=(rset.getString("ALERT_EVENT_CODE")==null)?"":rset.getString("ALERT_EVENT_CODE");
		String event_desc1	 =(rset.getString("ALERT_EVENT_DESC")==null)?"":rset.getString("ALERT_EVENT_DESC");
		//String txtCategoryCode1	 =(rset.getString("ALERT_CATEG_CODE")==null)?"":rset.getString("ALERT_CATEG_CODE");
		String txtCategoryCode1	= rset.getString("ALERT_CATEG_CODE");
    			if(txtCategoryCode1 == null) txtCategoryCode1 ="&nbsp;";
		strsql1="SELECT ALERT_CATEG_CODE, ALERT_CATEG_DESC FROM CA_ALERT_CATEG WHERE ALERT_CATEG_CODE=?";

        stmt2 = conn.prepareStatement(strsql1);
        stmt2.setString(1,txtCategoryCode1);
        rset1 = stmt2.executeQuery();
       if(rset1.next())
       sumDesc=rset1.getString("ALERT_CATEG_DESC");
       if(sumDesc == null) sumDesc ="&nbsp;";
       if(stmt2!= null) stmt2.close();
       if(rset1!= null) rset1.close();	

		
 
	out.println("<a class='gridLink'  href='../../eCA/jsp/AlertEventAddModify.jsp?mode=update&event_id="+ URLEncoder.encode(event_id1)+"' target='f_query_add_mod' >");
	out.println(event_id1 + "</a></td><td class='gridData'>");
	out.println(event_desc1+"</td><td class='gridData'>");	
    out.println(sumDesc+"</td></tr>"); 
   
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

